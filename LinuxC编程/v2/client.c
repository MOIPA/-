#include<sys/socket.h>
#include<arpa/inet.h>
#include<stdio.h>
#include<string.h>
#include<sys/stat.h>
#include<dirent.h>
#include<sys/types.h>

int isBinary=1;
void doLcd(char *content){
        char buffer[100];
        printf("do lcd\n");
        if(chdir(content)==-1)printf("can't switch dir\n");
        else{
                getcwd(buffer,100);
                printf("now u are in %s\n",buffer); 
        }
}
void doLpwd(){
        char buffer[100];
        getcwd(buffer,100);
        printf("%s\n",buffer);
}
void doLmkdir(char *content){
        if(mkdir(content,S_IWUSR|S_IRUSR|S_IROTH|S_IRGRP)==-1)printf("can't create dir\n");
        else printf("dir created\n");
}
void doLrmdir(char *content){
        if(rmdir(content)==-1)printf("can't remove dir\n");
        else printf("dir removed\n"); 
}
void doDir(){
        char buffer[1024]={0};
        char path[100]={0};
        DIR *dir;
        struct dirent * entry;
        getcwd(path,100);
        if((dir=opendir(path))==NULL){
                printf("unable to open dir\n");
                return;
        }
        while((entry=readdir(dir))!=NULL){
                if(strcmp(".",entry->d_name)==0||strcmp("..",entry->d_name)==0)continue;
                strcat(buffer,entry->d_name);
                strcat(buffer,"\n");
        }
        closedir(dir);
        printf("%s",buffer);

}
int doSplit(char split,const char *s,char* command,char *content){
        char str[2][50];
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
<<<<<<< HEAD
void doContinuePutFile(int server_sock,char * file_name){//include a while to continue send file content
        FILE *file;
        char buffer[1024]={0};
        printf("the file name is:%s\n",file_name);
        if(isBinary==0)file = fopen(file_name,"rt");
        if(isBinary==1)file = fopen(file_name,"rb");
        if(file==NULL){
                strcpy(buffer,"ERROR");
                send(server_sock,buffer,100,0);
                printf("can't open %s file",file_name);         //open file failed
                return;
        }
                //printf("start send1\n");
        if(isBinary==0){
                while(1){
                        memset(buffer,0,1024);
                        if(fread(buffer,sizeof(char),1024,file)==0)break;
                        //readed
                        //printf("put:client do one send: %s\n",buffer);
                        send(server_sock,buffer,1024,0);		
                }
        }
                //printf("start send2\n");
        if(isBinary==1){
            while(1){
                //printf("start send3\n");
                memset(buffer,0,1024);
                buffer[1023]=fread(buffer,sizeof(char),100,file);//the last  to put read blocks
                //read 100 B one time or buffer[1023]will be -1
                if((int)buffer[1023]<=0)break;
                send(server_sock,buffer,1024,0);
                printf("send %d blocks\n",(int)buffer[1023]);
            }

        }
    close(file);
}

void doContinueGetFile(int server_sock,char *file_name){//include a while to continue get file content
        //start receiving file
        FILE *file;
        int i=0;
        char buffer[1024];
        memset(buffer,0,1024);
        if(isBinary==0){
                file=fopen(file_name,"wt+");
                while(1){
                        recv(server_sock,buffer,1024,0);
                        if(strcmp(buffer,"ServerEnd")==0){
                                close(file);
                                return;
                        }	
                        //store file to local
                        printf("store:%s\n",buffer);
                        while(buffer[i++]!=0);
                        fwrite(buffer,sizeof(char),i-1,file);
                        fflush(file);
                        i=0;
                }
        }
        if(isBinary==1){
                file=fopen(file_name,"wb+");
                while(1){
                        recv(server_sock,buffer,1024,0);
                        if(strcmp(buffer,"ServerEnd")==0){
                                close(file);
                                return;
                        }	
                        //store file to local
                        fwrite(buffer,sizeof(char),(int)buffer[1023],file);
                        fflush(file);
                }
        }
        close(file);
}


=======
>>>>>>> parent of bc37075... 最终版
void doGetFileContent(char *buffer,char* file_name){
    FILE *file;
    printf("the file name is:%s\n",file_name);
    if(isBinary==0)file = fopen(file_name,"rt");
    if(isBinary==1)file = fopen(file_name,"rb");
    if(file==NULL){
        strcpy(buffer,"error");
        printf("can't open %s file",file_name);         //open file failed
        return;
    }
    //xun huan duqu
    int i=0;
    memset(buffer,0,1024);
    if(isBinary==0)while(fread(&buffer[i++],sizeof(char),1,file)!=0);
    if(isBinary==1)while(fread(&buffer[i++],1,8,file)!=0);
    //strcpy(buffer,"the file content");//***********************************TEST
    printf("client send file is: %s:end\n",buffer);
}

int main(void){

        char buffer[100]={0};
        char command[200]={0};
        char content[200]={0};
        int server_sock,isSplited;
        struct sockaddr_in server_sockaddr;


        //init sockaddr
        server_sockaddr.sin_family=AF_INET;
        server_sockaddr.sin_port=htons(8181);
        server_sockaddr.sin_addr.s_addr=inet_addr("127.0.0.1");

        server_sock = socket(AF_INET,SOCK_STREAM,0);

        if(connect(server_sock,(struct sockaddr*)&server_sockaddr,sizeof(struct sockaddr))==-1){
                printf("client connect error\n");
                return 0;
        }

        //do login function
        //        if(recv(server_sock,buffer,1024,0)==-1)printf("can't receive message from server!\n");  //receive request from server
        //        else printf("%s",buffer);
        //        scanf("%s",buffer);
        //        if(send(server_sock,buffer,sizeof(buffer),0)==-1)printf("client : send error\n");       //send username
        //        if(recv(server_sock,buffer,1024,0)==-1)printf("can't receive message from server!\n");  //receive request from server
        //        else printf("%s",buffer);
        //        scanf("%s",buffer);
        //        if(send(server_sock,buffer,sizeof(buffer),0)==-1)printf("client : send error\n");       //send userpwd


        while(1){

                //receiver from server and echo
                if(recv(server_sock,buffer,1024,0)==-1)printf("can't receive message from server!\n");
                else{
                        printf("%s\n",buffer);
                        if(strcmp(buffer,"not right user name or password\n")==0){
                                //close(server_sock);
                                //server_sock = socket(AF_INET,SOCK_STREAM,0);
                                //printf("reconnect...\n");
                                //if(connect(server_sock,(struct sockaddr*)&server_sockaddr,sizeof(struct sockaddr))==-1)printf("client connect error\n");
                                break;
                        }                                                                               //exit the client or reopen connect
                }
                while(1){
                        //scanf("%s",buffer);//scan from user input
                        printf("server>");
                        scanf(" %[^\n]",buffer);
                        isSplited = doSplit(' ',buffer,command,content);

                        //judge if user want to do it on client***
                        if(strcmp(command,"lcd")==0){
                                if(isSplited==-1)printf("miss input\n");
                                else doLcd(content);
                                //receive users command again
                                continue;
                        }
                        else if(strcmp(command,"lpwd")==0){
                                doLpwd();
                                continue;
                        }
                        else if(strcmp(command,"lmkdir")==0){
                                if(isSplited==-1)printf("miss input\n");
                                else doLmkdir(content);
                                continue;
                        }
                        else if(strcmp(command,"lrmdir")==0){
                                if(isSplited==-1)printf("miss input\n");
                                else doLrmdir(content);
                                continue;
                        }
                        else if(strcmp(command,"dir")==0){
                                doDir(content);
                                continue;
                        }
                        else if(strcmp(command,"binary")==0){
                                isBinary=1;
                                break;
                        }
                        else if(strcmp(command,"ascall")==0){
                                isBinary=0;
                                break;
                        }
                        else if(strcmp("put",command)==0){
<<<<<<< HEAD
<<<<<<< HEAD
                                if(send(server_sock,buffer,sizeof(buffer),0)==-1)printf("client : send error\n");//send put file to server
                                recv(server_sock,buffer,100,0);//confirm if user can do put
                                if(strcmp("filecontent",buffer)==0){
                                        doContinuePutFile(server_sock,content);//include a while to continue send file content
                                        memset(buffer,0,100);
                                        strcpy(buffer,"END");
                                        break;
                                }else{
                                        printf("no input!\n");
                                        continue;
                                }
                        }
                        else if(strcmp("get",command)==0){
                                if(send(server_sock,buffer,sizeof(buffer),0)==-1)printf("client : send error\n");//send get file to server
                                recv(server_sock,buffer,1024,0);//confirm if user can do get
                                printf("get :%s\n",buffer);
                                if(strcmp("OK",buffer)==0){
                                        doContinueGetFile(server_sock,content);//include a while to continue get file content
                                        memset(buffer,0,1024);
                                        strcpy(buffer,"END");
                                        break;
                                }else{
                                        printf("no input!\n");
                                        continue;
                                }


                        }
                        else if(strcmp("testput",command)==0){
                                //start if user want to put file
                                if(send(server_sock,buffer,sizeof(buffer),0)==-1)printf("client : send error\n");
                                recv(server_sock,buffer,100,0);                 //first: send command and file name to server and get result from server
                                if(strcmp("filecontent",buffer)==0){            //means client should send file to server
                                        doGetFileContent(buffer,content);               //second:get file content
                                        //send(server_sock,buffer,sizeof(buffer),0);      //last: send file content  // directly let download send which in else to do the send
                                        //continue;
                                        break;
=======
                        //start if user want to put file
                                if(send(server_sock,buffer,sizeof(buffer),0)==-1)printf("client : send error\n");
                                recv(server_sock,buffer,100,0);                 //first: send command and file name to server and get result from server
                                if(strcmp("filecontent",buffer)==0){            //means client should send file to server
=======
                        //start if user want to put file
                                if(send(server_sock,buffer,sizeof(buffer),0)==-1)printf("client : send error\n");
                                recv(server_sock,buffer,100,0);                 //first: send command and file name to server and get result from server
                                if(strcmp("filecontent",buffer)==0){            //means client should send file to server
>>>>>>> parent of bc37075... 最终版
                                doGetFileContent(buffer,content);               //second:get file content
                                //send(server_sock,buffer,sizeof(buffer),0);      //last: send file content  //直接break 交给下面的else里的send做  directly let download send which in else to do the send
                                //continue;
                                break;
<<<<<<< HEAD
>>>>>>> parent of bc37075... 最终版
=======
>>>>>>> parent of bc37075... 最终版
                                }else{
                                   // printf("%s\n",buffer);
                                    continue;
                                }
                        }
<<<<<<< HEAD
<<<<<<< HEAD
                        else if(strcmp("testget",command)==0){
                                send(server_sock,buffer,100,0);//send get file command
                                recv(server_sock,buffer,1024,0);//get file content
                                if(strcmp(buffer,"error")==0){		//failed send to server fail info
                                        printf("get file failed\n");
                                        continue;
                                }else{				//get file succeed
                                        doRestoreFile(content,buffer);
                                        printf("get file succeed\n");
                                        continue;
                                }	

                        }
=======
>>>>>>> parent of bc37075... 最终版
=======
>>>>>>> parent of bc37075... 最终版
                        else break; //not local command break
                }

                //end*************************************


                //if user want to exit
                if(strcmp("quit",buffer)==0){
                        if(send(server_sock,buffer,sizeof(buffer),0)==-1)printf("client : send error\n");
                        printf("quited\n");
                        break;
                }
                //response to server
                else if(send(server_sock,buffer,sizeof(buffer),0)==-1)printf("client : send error\n");
        }

        close(server_sock);
        return 0;
}
