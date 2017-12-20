#include<unistd.h>
#include<string.h>
#include<arpa/inet.h>
#include<stdio.h>
#include<sys/stat.h>
#include<dirent.h>
#include<sys/socket.h>
#include<sys/types.h>

#define DEFAULT_IP "127.0.0.1"

int binary=1;
void ExecuteLcd(char *parameter){
        char buf[120];
		if (chdir(parameter) == -1) {
			printf("can't switch dir\n");
			return;
		}
		getcwd(buf, 100);
		printf("切换目录为 %s\n", buf);
}
void ExecuteLpwd(){
        char buf[100];
        getcwd(buf,100);
        printf("当前目录为%s\n",buf);
}
void ExecuteLmkdir(char *parameter){
        if(mkdir(parameter,S_IWUSR|S_IRUSR|S_IROTH|S_IRGRP|S_IXUSR|S_IXOTH)==-1)printf("创建文件夹失败\n");

        else printf("成功创建文件夹\n");
}
void ExecuteLrmdir(char *parameter){
        if(rmdir(parameter)==-1)printf("删除文件夹失败\n");
        else printf("删除创建文件夹\n"); 
}
void ExecuteDir(){
	char buf[1024];
	char path[120];
	memset(buf, 0, 1024);
	memset(path, 0, 120);

	DIR *dp;
	struct dirent * entry;
	getcwd(path, 100);
	if ((dp = opendir(path)) == NULL) {
		printf("unable to open dir\n");
		return;
	}
	while ((entry = readdir(dp)) != NULL) {
		strcat(buf, entry->d_name);
		strcat(buf, "\n");
	}
	closedir(dp);
	printf("%s", buf);
		

}
int SplitByTag(char split,const char *s,char* command,char *content){
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
void ExecutePut(int server_sockfd,char * parameter){
        FILE *fp;
        char buf[1024];
		memset(buf, 0, 1024);
		if (binary == 0) {
			fp = fopen(parameter, "rt");
			if (fp == NULL) {
				strcpy(buf, "ERROR");
				send(server_sockfd, buf, 100, 0);
				printf("失败\n");
				return;
			}
		}
        if(binary==1){
			fp = fopen(parameter,"rb");
			if (fp == NULL) {
				strcpy(buf, "ERROR");
				send(server_sockfd, buf, 100, 0);
				printf("失败\n");
				return;
			}
		}
        
        if(binary==0){
                while(1){
                        memset(buf,0,1024);
                        if(fread(buf,sizeof(char),1024,fp)==0)break;
                        send(server_sockfd,buf,1024,0);		
                }
        }
                //printf("start send2\n");
        if(binary==1){
            while(1){
                //printf("start send3\n");
                memset(buf,0,1024);
                buf[1023]=fread(buf,sizeof(char),100,fp);//the last  to put read blocks
                //read 100 B one time or buffer[1023]will be -1
                if((int)buf[1023]<=0)break;
                send(server_sockfd,buf,1024,0);
                //printf("send %d blocks\n",(int)buf[1023]);
            }

        }
    fclose(fp);
}

void ExecuteGet(int server_sockfd,char *file_name){
       
        FILE *fp;
		char buf[1024] = {0};
        if(binary==0){
                fp=fopen(file_name,"wt+");
				int position = 0;
                while(1){
                        recv(server_sockfd,buf,1024,0);
                        if(strcmp(buf,"finish")==0){
                                fclose(fp);
                                return;
                        }	
                        printf("store:%s\n",buf);
                        while(buf[position++]!=0);
                        fwrite(buf,sizeof(char),position-1,fp);
                        fflush(fp);
                        position=0;
                }
        }
        if(binary==1){
                fp=fopen(file_name,"wb+");
                while(1){
                        recv(server_sockfd,buf,1024,0);
                        if(strcmp(buf,"finish")==0){
                                fclose(fp);
                                return;
                        }	
                        //store file to local
                        fwrite(buf,sizeof(char),(int)buf[1023],fp);
                        fflush(fp);
                }
        }
        fclose(fp);
}

int main(void){

        char buf[1024]={0};
        char cmd[200]={0};
        char parameter[200]={0};
        int server_sockfd,legal;
        struct sockaddr_in addr;

		server_sockfd = socket(AF_INET, SOCK_STREAM, 0);

		addr.sin_addr.s_addr = inet_addr(DEFAULT_IP);
        addr.sin_family=AF_INET;
        addr.sin_port=htons(88888);


        if(connect(server_sockfd,(struct sockaddr*)&addr,sizeof(struct sockaddr))==-1){
                printf("连接失败\n");
                return 0;
        }

        while(1){

                if(recv(server_sockfd,buf,1024,0)==-1)printf("无法接收消息!\n");
                else{
                        printf("%s\n",buf);                                                                             //exit the client or reopen connect
                }
                while(1){
                        printf("ftpserver>");
                        scanf(" %[^\n]",buf);
                        legal = SplitByTag(' ',buf,cmd,parameter);

						if (strcmp("quit", buf) == 0) {
							if (send(server_sockfd, buf, sizeof(buf), 0) == -1)printf("发送失败\n");
							printf("退出\n");
							close(server_sockfd);
							return 0;
						}
						else if (strcmp(cmd, "lpwd") == 0) {
							ExecuteLpwd();
							continue;
						}
                        else if(strcmp(cmd,"lcd")==0){
                                if(legal==-1)printf("操作失败\n");
                                else ExecuteLcd(parameter);
                                continue;
                        }
                        else if(strcmp(cmd,"lmkdir")==0){
                                if(legal==-1)printf("操作失败\n");
                                else ExecuteLmkdir(parameter);
                                continue;
                        }
						else if (strcmp(cmd, "lrmdir") == 0) {
							if (legal == -1)printf("操作失败\n");
							else ExecuteLrmdir(parameter);
							continue;
						}
                        else if(strcmp(cmd,"dir")==0){
                                ExecuteDir();
                                continue;
                        }
						else if (strcmp(cmd, "binary") == 0) {
							binary = 1;
							break;
						}
						else if (strcmp(cmd, "ascall") == 0) {
							binary = 0;
							break;
						}
						else if (strcmp("put", cmd) == 0) {
							if (send(server_sockfd, buf, sizeof(buf), 0) == -1)printf("发送失败\n");
							recv(server_sockfd, buf, 100, 0);
							if (strcmp("filecontent", buf) == 0) {
								ExecutePut(server_sockfd, parameter);
								memset(buf, 0, 100);
								strcpy(buf, "END");
								break;
							}
							else {
								continue;
							}
						}
                        else if(strcmp("get",cmd)==0){
                                if(send(server_sockfd,buf,sizeof(buf),0)==-1)printf("发送失败\n");
                                recv(server_sockfd,buf,1024,0);
                                printf("开始传输\n");
                                if(strcmp("ready",buf)==0){
                                        ExecuteGet(server_sockfd,parameter);
                                        memset(buf,0,1024);
                                        strcpy(buf,"finish");
                                        break;
                                }else{
                                        continue;
                                }


                        }
                        else break;
                }

                if(send(server_sockfd,buf,sizeof(buf),0)==-1)printf("发送失败\n");
        }


}
