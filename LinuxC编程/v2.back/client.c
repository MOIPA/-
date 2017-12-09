#include<sys/socket.h>
#include<arpa/inet.h>
#include<stdio.h>
#include<string.h>

int main(void){

        char buffer[10]={0};
        int server_sock;
        struct sockaddr_in server_sockaddr;


        //init sockaddr
        server_sockaddr.sin_family=AF_INET;
        server_sockaddr.sin_port=htons(8181);
        server_sockaddr.sin_addr.s_addr=inet_addr("127.0.0.1");

        server_sock = socket(AF_INET,SOCK_STREAM,0);

        if(connect(server_sock,(struct sockaddr*)&server_sockaddr,sizeof(struct sockaddr))==-1)printf("client connect error\n");

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
                        printf("%s",buffer);
                        if(strcmp(buffer,"server>not right user name or password\n")==0){
                                //close(server_sock);
                                //server_sock = socket(AF_INET,SOCK_STREAM,0);
                                //printf("reconnect...\n");
                                //if(connect(server_sock,(struct sockaddr*)&server_sockaddr,sizeof(struct sockaddr))==-1)printf("client connect error\n");
                                break;
                        }                                                                               //exit the client or reopen connect
                }
                printf("server>");
                scanf("%s",buffer);//scan from user input

                //response to server
                if(send(server_sock,buffer,sizeof(buffer),0)==-1)printf("client : send error\n");

                //if user want to exit
                if(strcmp("quit",buffer)==0){
                        if(send(server_sock,buffer,sizeof(buffer),0)==-1)printf("client : send error\n");
                        printf("quited\n");
                        break;
                }
        }

        close(server_sock);
        return 0;
}
