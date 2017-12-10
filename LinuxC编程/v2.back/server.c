#include<sys/socket.h>
#include<dirent.h>
#include<sys/types.h>
#include<arpa/inet.h>
#include<netinet/in.h>
#include<stdio.h>
#include<pthread.h>
#include<string.h>
#include<sys/stat.h>

void doMkDir(int client_sock,char *content);
void doRmDir();
void doLs(int client_sock,char *path);
void doCd(int client_sock,char *current_dir,char *content);
void doPut();
void doMPut();
void doGet();
void doMGet();
void *handClientRequest(void *arg);
int doSplit(char split,const char *s,char* command,char *content);

struct User{
        char name[30];
        char pwd[30];
        int kind;//1:root user 0:common user
};
struct MyArg{
        int client_sock;
        int user_kind;
};

//create user
struct User *do_createUsr(int *user_accounts){
        struct User *users;
        struct User admin_user,com_user;
        strcpy(admin_user.name,"admin");
        strcpy(admin_user.pwd,"123");
        strcpy(com_user.name,"common");
        strcpy(com_user.pwd,"123");
        admin_user.kind=1;
        com_user.kind=0;
        users[0]=admin_user;
        users[1]=com_user;
        *user_accounts=2;
        return users;

}
int judgeUser(char *name,char *pwd,struct User* users,int user_accounts){
        int i,user_kind=-1;
        for(i=0;i<user_accounts;i++)
                if((strcmp(name,users[i].name)==0)&&(strcmp(pwd,users[i].pwd)==0))
                        return users[i].kind;

        return -1;
}

int main(int arg,char* argv[]){
        int server_sock,client_sock;
        socklen_t server_addr_len = sizeof(struct sockaddr_in);
        struct sockaddr_in server_sockaddr;
        struct User login_user;
        struct User *users;
        int user_accounts,user_kind;
        struct MyArg client_arg; 
        char buffer[1024];
        pthread_t process_client;
        //init user
        users = do_createUsr(&user_accounts);
        //init server address 
        server_sockaddr.sin_family=AF_INET;
        server_sockaddr.sin_port=htons(8181);
        if(arg==2){
                server_sockaddr.sin_addr.s_addr=inet_addr(argv[1]);
                //printf("bind user set ip port\n");
        }else if(arg==1){
                server_sockaddr.sin_addr.s_addr=inet_addr("127.0.0.1");
                //printf("bind default ip port\n");
        }
        //init server socket
        server_sock = socket(AF_INET,SOCK_STREAM,0);
        //bind server socket to address
        if( bind(server_sock,(struct sockaddr*)&server_sockaddr,sizeof(struct sockaddr))==-1)printf("server bind error\n");
        //listen 
        if(listen(server_sock,5)==-1)printf("listen error\n");


        //TODO accept throw new thread

        while(1){
                //printf("server> : server waiting...\n");
                //accept from server socket
                if((client_sock = accept(server_sock,(struct sockaddr*)&server_sockaddr,&server_addr_len))==-1)printf("server accept error\n");
                //judge user kind

                strcpy(buffer,"please enter your user name:");
                if(send(client_sock,buffer,40,0)==-1)printf("server send error\n");                 //send message to client
                if(recv(client_sock,buffer,1024,0)==-1)printf("server receive error in while\n");   //receive user name from client
                strcpy(login_user.name,buffer);

                strcpy(buffer,"please enter your user password:");
                if(send(client_sock,buffer,40,0)==-1)printf("server send error\n");                 //send to client
                if(recv(client_sock,buffer,1024,0)==-1)printf("server receive error in while\n");   //receive user pwd from client
                strcpy(login_user.pwd,buffer);

                user_kind = judgeUser(login_user.name,login_user.pwd,users,user_accounts);          //judge user kind

                //start new thread
                if(user_kind==-1){
                        //TODO what should i do when user put error info
                        strcpy(buffer,"not right user name or password\n");
                        send(client_sock,buffer,40,0);
                }
                else if(user_kind!=-1){                                                             //login succeed
                        client_arg.client_sock=client_sock;
                        client_arg.user_kind=user_kind;
                        strcpy(buffer,"welcome\n");
                        send(client_sock,buffer,40,0);
                        if(pthread_create(&process_client,NULL,handClientRequest,&client_arg)!=0)printf("server create thread error\n");
                }

        }

        return 0;
}

void *handClientRequest(void *arg){
        struct MyArg client_arg = *(struct MyArg*)arg;
        char  buffer[1024]={0}; 
        char command[1024]={0};
        char content[1024]={0};
        char default_dir[1024]={0};
        char current_dir[1024]={0};
        pthread_detach(pthread_self());
        int client_sock=client_arg.client_sock;
        int user_kind = client_arg.user_kind;
        int isSplit;
        strcpy(default_dir,"/home/server/");
        strcpy(current_dir,default_dir);
        chdir(default_dir);              //user default directory
        while(1){
                //strcpy(buffer,"server>new thread created!\n");
                //if(send(client_sock,buffer,30,0)==-1)printf("handcliendRequest error\n");
                // printf("do\n");

                sleep(1);
                //receive
                if(recv(client_sock,buffer,1024,0)==-1)break;
                isSplit = doSplit(' ',buffer,command,content);     //split command and content if split failed then command=buffer

                //execute user command
                if(strcmp(command,"lcd")==0){//lcd
                        if(user_kind==1)
                                strcpy(buffer,"do lcd command!");
                        else strcpy(buffer,"do lcd command!");
                        send(client_sock,buffer,30,0);
                }
                else if(strcmp(command,"ls")==0){//ls
                        doLs(client_sock,current_dir);
                }
                else if(strcmp(command,"pwd")==0){//pwd
                        getcwd(buffer,40);
                        send(client_sock,buffer,40,0); 
                }
                else if(strcmp(command,"mkdir")==0){ //mkdir
                        if(isSplit==-1)strcpy(buffer,"please enter your content");       //cd may needs content judge isSplited
                        else doMkDir(client_sock,content);
                }
                else if(strcmp(command,"cd")==0){ //cd
                        if(isSplit==-1)strcpy(buffer,"please enter your content");       //cd may needs content judge isSplited
                        else {
                                doCd(client_sock,current_dir,content);
                        }                    
                }


                //exit command
                else if(strcmp(buffer,"quit")==0){
                        break;
                }
                else {
                        strcpy(buffer,"no such command\n");
                        send(client_sock,buffer,30,0);
                }
        }
        close(client_sock);
        pthread_exit(NULL);
}

void doLs(int client_sock,char *path){
        char buffer[1024]={0};
        DIR *dir;
        struct dirent * entry;
        if((dir=opendir(path))==NULL){
                strcpy(buffer,"unable to open dir");
                send(client_sock,buffer,100,0);
                return;
        } 
        while((entry=readdir(dir))!=NULL){
                if(strcmp(".",entry->d_name)==0||strcmp("..",entry->d_name)==0)continue;
                strcat(buffer,entry->d_name);
                strcat(buffer,"\n");
        }
        closedir(dir);
        send(client_sock,buffer,100,0);

}

void doMkDir(int client_sock,char * content){
        char buffer[1024];
        if(mkdir(content,S_IRUSR|S_IWUSR|S_IRGRP|S_IWGRP|S_IROTH)==-1){
                strcpy(buffer,"unable to create dir");
        }else{
                strcpy(buffer,"dir created");
        }   
        send(client_sock,buffer,40,0);

}

void doCd(int client_sock,char *current_dir,char *content){
        char buffer[1024]={0};
        if(chdir(content)==-1)strcpy(buffer,"unable to switch dir");
        else{
                strcpy(buffer,"done changed to : ");
                getcwd(current_dir,40);                            //update current_path
                strcat(buffer,current_dir);    
        }
        send(client_sock,buffer,40,0);
}

int doSplit(char split,const char *s,char* command,char *content){
        char str[2][1024];
        memset(str[0],0,strlen(str[0]));
        memset(str[1],0,strlen(str[1]));
        int counts=strlen(s),record,isSplited=0;

        for(record=0;record<counts;record++){
                if(s[record]==split)break;
        }
        if(record==counts)isSplited=-1;     //无法分割命令和参数
        strncat(str[0],s,record);
        record++;
        for(;record<counts;record++)
                strncat(str[1],&s[record],1);
        int k=0;
        for(k=0;k<strlen(command);k++)command[k]=' ';
        memset(command,0,strlen(command));
        memset(content,0,strlen(content));
        strcpy(command,str[0]);
        strcpy(content,str[1]);
        return isSplited;                       
}

//from books p104
//  void printdir(char *dir,int depth,char *buffer){
//        DIR *dp;
//        struct dirent * entry;
//        struct stat statbuf;
//        if((dp=opendir(dir))==NULL){
//                printf("cannot open directory:%s\n",dir);
//                return;
//        }
//        //ÒÆ¶¯µ½Ä¿Â¼ÏÂ 
//        chdir(dir);
//        while((entry=readdir(dp))!=NULL){
//                stat(entry->d_name,&statbuf);//´«Èëµ±Ç°Ä¿Â¼ 
//                if(S_ISDIR(statbuf.st_mode)){
//                        if(strcmp(".",entry->d_name)==0||strcmp("..",entry->d_name)==0)continue;
//                        strcat(buffer,entry->d_name);
//                        strcat(buffer,"\n");
//                        //printf("%*s%s/\n",depth,"   ",entry->d_name);
//                        printdir(entry->d_name,depth);
//                }
//                else  //hprintf("%*s%s\n",depth,"   ",entry->d_name);
//        }
//        chdir("..");
//        closedir(dp);
//}
