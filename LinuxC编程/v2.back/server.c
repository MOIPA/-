#include<sys/socket.h>
#include<arpa/inet.h>
#include<netinet/in.h>
#include<stdio.h>
#include<pthread.h>
#include<string.h>

void doMkDir();
void doRmDir();
void doPwd();
void doCd();
void doLs();
void doPut();
void doMPut();
void doGet();
void doMGet();
void *handClientRequest(void *arg);

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
        if(listen(server_sock,5)==-1)printf("server> listen error\n");


        //TODO accept throw new thread

        while(1){
                //printf("server> : server waiting...\n");
                //accept from server socket
                if((client_sock = accept(server_sock,(struct sockaddr*)&server_sockaddr,&server_addr_len))==-1)printf("server accept error\n");
                //judge user kind

                strcpy(buffer,"server>please enter your user name:");
                if(send(client_sock,buffer,40,0)==-1)printf("server send error\n");                 //send message to client
                if(recv(client_sock,buffer,1024,0)==-1)printf("server receive error in while\n");   //receive user name from client
                strcpy(login_user.name,buffer);

                strcpy(buffer,"server>please enter your user password:");
                if(send(client_sock,buffer,40,0)==-1)printf("server send error\n");                 //send to client
                if(recv(client_sock,buffer,1024,0)==-1)printf("server receive error in while\n");   //receive user pwd from client
                strcpy(login_user.pwd,buffer);

                user_kind = judgeUser(login_user.name,login_user.pwd,users,user_accounts);          //judge user kind

                //start new thread
                if(user_kind==-1){
                    //TODO what should i do when user put error info
                    strcpy(buffer,"server>not right user name or password\n");
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
        char  buffer[1024]; 
        pthread_detach(pthread_self());
        int client_sock=client_arg.client_sock;
        int user_kind = client_arg.user_kind;
        while(1){
                //strcpy(buffer,"server>new thread created!\n");
                //if(send(client_sock,buffer,30,0)==-1)printf("handcliendRequest error\n");
                // printf("do\n");
                sleep(1);
                //receive
                if(recv(client_sock,buffer,1024,0)==-1)break;

                //do command
                if(strcmp(buffer,"lcd")==0){
                        if(user_kind==1)
                        strcpy(buffer,"server root>do lcd command!\n");
                        else strcpy(buffer,"server common>do lcd command!\n");
                        send(client_sock,buffer,30,0);
                }
                else if(strcmp(buffer,"ls")==0){
                        strcpy(buffer,"server>do ls command!\n");
                        send(client_sock,buffer,30,0);
                }
                //exit command
                else if(strcmp(buffer,"quit")==0){
                        break;
                }
                else {
                    strcpy(buffer,"server>no such command\n");
                    send(client_sock,buffer,30,0);
                }
        }
        close(client_sock);
        pthread_exit(NULL);
}
