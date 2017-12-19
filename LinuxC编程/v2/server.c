#include<sys/socket.h>
#include<stdlib.h>
#include<dirent.h>
#include<sys/types.h>
#include<arpa/inet.h>
#include<netinet/in.h>
#include<stdio.h>
#include<pthread.h>
#include<string.h>
#include<sys/stat.h>

void doMkDir(int client_sock,char *content);
void doRmDir(int client_sock,char *content);
void doLs(int client_sock,char *path);
void doCd(int client_sock,char *current_dir,char *content);
void *handClientRequest(void *arg);
void *handServerRequest(void *arg);
int doSplit(char split,const char *s,char* command,char *content);

typedef struct{
	char thread_name[20];
	pthread_t thread;
}NameAndThread;

int total_users=0,current_users=0,quitSingal=0,isBinary=1;//shared resources   quitSingal 0:not quit 1:need quit
char users_lists[20][20];
NameAndThread tlists[40];

struct User{
	char name[30];
	char pwd[30];
	int kind;//1:root user 0:common user -1:visitor
};
struct MyArg{
	int client_sock;
	int user_kind;
	//        struct UserThreadAndName *lists;
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

//struct UserThreadAndName *do_createUsrInfo(int *thread_counts){
//        struct UserThreadAndName *lists;
//        struct UserThreadAndName userinfo_1;
//        strcpy(userinfo_1.thread_name,"empty");
//        lists[0]=userinfo_1;
//
//        *thread_counts=1;
//        //    struct User user1;          //**********************************the program will breakdown without this sentence?????????
//
//        return lists;
//}

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
	//struct UserThreadAndName userInfo;
	//struct UserThreadAndName *lists;
	int user_accounts,user_kind,thread_counts;
	struct MyArg client_arg; 
	char buffer[1024];
	pthread_t process_client;
	pthread_t process_server;
	//init users which put thread and name
	//do_createUsrInfo(&thread_counts);      //**********************************BUG:segmentation fault
	//init user_lists
	int j;
	for(j=0;j<20;j++){
		strcpy(users_lists[j],"empty");
	}
	for(j=0;j<40;j++){
		strcpy(tlists[j].thread_name,"empty");
		tlists[j].thread=-1;
	}
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

	//TODO start a new thread to handle request from server users
	if(pthread_create(&process_server,NULL,handServerRequest,NULL)!=0)printf("Server handler start failed\n");


	//TODO accept throw new thread

	while(1){
		//printf("server> : server waiting...\n");
		//accept from server socket
		if((client_sock = accept(server_sock,(struct sockaddr*)&server_sockaddr,&server_addr_len))==-1)printf("server accept error\n");
		//judge user kind

		if(quitSingal==1)break;                                                             //quit judge
		strcpy(buffer,"please enter your user name:");
		if(send(client_sock,buffer,40,0)==-1)printf("server send error\n");                 //send message to client
		if(quitSingal==1)break;                                                             //quit
		if(recv(client_sock,buffer,1024,0)==-1)printf("server receive error in while\n");   //receive user name from client
		if(quitSingal==1)break;                                                             //quit judge
		strcpy(login_user.name,buffer);

		strcpy(buffer,"please enter your user password:");
		if(quitSingal==1)break;                                                             //quit judge
		if(send(client_sock,buffer,40,0)==-1)printf("server send error\n");                 //send to client
		if(quitSingal==1)break;                                                             //quit judge
		if(recv(client_sock,buffer,1024,0)==-1)printf("server receive error in while\n");   //receive user pwd from client
		strcpy(login_user.pwd,buffer);

		user_kind = judgeUser(login_user.name,login_user.pwd,users,user_accounts);          //judge user kind

		//start new thread
		if(user_kind==-1){
			//TODO what should i do when user put error info
			strcpy(buffer,"not right user name or password, you are visitor!\n");
			//send(client_sock,buffer,40,0);
		}
		//else if(user_kind!=-1){                                                             //login succeed
		client_arg.client_sock=client_sock;
		client_arg.user_kind=user_kind;
		//client_arg.lists = lists;
		strcat(buffer,"welcome your are the  ");
		//strcat(buffer,current_users+49);
		char tmp[10];
		current_users++;
		sprintf(tmp,"%d",current_users);
		strcat(buffer,tmp);
		strcat(buffer,"th user");
		if(quitSingal==1)break;                                                             //quit judge
		send(client_sock,buffer,140,0);
		if(quitSingal==1)break;                                                             //quit judge
		if(pthread_create(&process_client,NULL,handClientRequest,&client_arg)!=0){
			current_users--;
		}
		//}
		if(quitSingal==1)break;                                                             //quit judge

	}
	close(client_sock);
	close(server_sock);

	return 0;
}
void doGet(int client_sock,const char *file_name){
	printf("enter do get\n");
	char content_buffer[1025];
	memset(content_buffer,0,1025);
	FILE *file;
	int i=0;
	if(isBinary==0){
		file=fopen(file_name,"rt+");
		if(file==NULL)strcpy(content_buffer,"error");
		else{		//file can be open
			while(fread(&content_buffer[i++],sizeof(char),1,file)!=0);
		}
	}
	if(isBinary==1){
		file=fopen(file_name,"rb+");
		if(file==NULL)strcpy(content_buffer,"error");
		else{
			while(fread(&content_buffer[i++],8,1,file)!=0);
		}
	}
	send(client_sock,content_buffer,1024,0);
	//	printf("buffer send %s\n",content_buffer);
	fclose(file);

}
void doContinuePutFile(int client_sock,char *file_name){
	int i=0;
	//client start send file content
	char buffer[1024]={0};
	FILE *file;
	if(isBinary==1){
		file = fopen(file_name,"wb+");
	}
	if(isBinary==0){
		file = fopen(file_name,"wt+");
	}
	if(file==NULL){
		memset(buffer,0,1024);
		strcpy(buffer,"anything");
		send(client_sock,buffer,100,0);         
		return;
	}
	//file is ok to receive
	memset(buffer,0,1024);
	strcpy(buffer,"filecontent");
	send(client_sock,buffer,100,0);        
	//client start to send to server ready to receive
	while(1){
		memset(buffer,0,1024);
		recv(client_sock,buffer,1024,0);//receive data from server
		if(strcmp(buffer,"ERROR")==0){
			recv(client_sock,buffer,1024,0);//client send failed server recv again to avoid bug
			close(file);
			return;
		}else if(strcmp(buffer,"END")==0){
			strcpy(buffer,"translated");
			send(client_sock,buffer,100,0);
			close(file);
			return;//translate ended
		}
		if(isBinary==0){//under ascall mode
			//store file
			//len=sprintf(tmpBuf,"%s",buffer);
			//while(buffer[i]!=0){
			//	fwrite(&buffer[i++],sizeof(char),1,file);
			//}
			while(buffer[i++]!=0);
			//FUCK ME****************************************************DO FFLUSH!!!!!!
			//printf("put:server recv and store:%s,len:%d\n",buffer,i);
			//printf("1:%c",buffer[0]);
			fwrite(buffer,sizeof(char),i-1,file);
			fflush(file);
			i=0;//reset i
			//printf("end\n");
			//write(file,tmpBuf,len);
		}
		if(isBinary==1){//under binary mode
			//TODO
			int counts = (int)buffer[1023];//blocks i should read
			fwrite(buffer,sizeof(char),counts,file);	
            printf("write %d blocks\n",counts);
			fflush(file);
		}

	}
	close(file);

}
void doContinueGetFile(int client_sock,char *file_name){
	char buffer[1024];
	memset(buffer,0,1024);
	FILE * file;
	if(isBinary==0){
		file = fopen(file_name,"rt+");
		if(file==NULL){
            printf("refused to send file\n");
			strcpy(buffer,"no");
			send(client_sock,buffer,10,0);
			close(file);
			return;
		}
		//ok to send file
		strcpy(buffer,"OK");
		send(client_sock,buffer,1024,0);//inform client to start receive
		while(1){
			memset(buffer,0,1024);
			if(fread(buffer,sizeof(char),1024,file)==0){
				memset(buffer,0,1024);
				strcpy(buffer,"ServerEnd");
				//printf("send :%s",buffer);
				send(client_sock,buffer,20,0);//translated send ServerEnd
				//printf("time to end\n");
				break;
			}
			//printf("server send:%s:end\n",buffer);
			send(client_sock,buffer,1024,0);
		}
	}
	if(isBinary==1){
		file = fopen(file_name,"rb+");
		if(file==NULL){
			strcpy(buffer,"no");
			send(client_sock,buffer,10,0);
			close(file);
			return;
		}
		//ok to send file
		strcpy(buffer,"OK");
		send(client_sock,buffer,1024,0);//inform client to start receive
        while(1){
                memset(buffer,0,1024);
                buffer[1023]=fread(buffer,sizeof(char),100,file);
                if((int)buffer[1023]==0){
                        memset(buffer,0,1024);
                        strcpy(buffer,"ServerEnd");
                        send(client_sock,buffer,20,0);//translated send ServerEnd
                        break;
                }
                //translate file
                send(client_sock,buffer,1024,0);
        }
    }		
	close(file);

}
void doPut(int client_sock,const char *file_name,const char *file_content ){
	char buffer[1024];
	FILE *file; 
	if(isBinary==1){
		//put file to local
		file = fopen(file_name,"wb+");
		fwrite(file_content,8,1024,file);
	}
	if(isBinary==0){
		file = fopen(file_name,"wt+");
		fwrite(file_content,sizeof(char),1024,file);
	}

	memset(buffer,0,1024);
	strcpy(buffer,"file translated");
	send(client_sock,buffer,100,1);
	//    printf("received file is:\n%s\n",file_content);
	fclose(file);
}

void *handClientRequest(void *arg){
	total_users++;
	char name[50];
	struct MyArg client_arg = *(struct MyArg*)arg;
	//struct UserThreadAndName *lists = client_arg.lists;
	char  buffer[1024]={0}; 
	char command[1024]={0};
	char content[1024]={0};
	char default_dir[1024]={0};
	char current_dir[1024]={0};
	pthread_detach(pthread_self());
	int client_sock=client_arg.client_sock;
	int user_kind = client_arg.user_kind;
	int isSplit;

	//start set users_lists erogdic lists if not empty set that value
	int  k=0;
	//	for(;k<20;k++){
	//		if(strcmp(users_lists[k],"empty")==0)break; 
	//	}
	//	if(user_kind==1)sprintf(name,"admin user:%d",current_users);
	//	else sprintf(name,"visitor :%d",total_users);
	//	strcpy(users_lists[k],name);
	//	memset(name,0,50); 
	//			//another way
	for(k=0;k<40;k++){
		if(strcmp(tlists[k].thread_name,"empty")==0)break;  //empty means it is not used
	}	
	if(user_kind==1)sprintf(name,"admin user:%d",total_users);//total users as the ID
	else sprintf(name,"visitor:%d",total_users);

	strcpy(tlists[k].thread_name,name);
	tlists[k].thread = pthread_self();	

	//end 

	//if(user_kind==1) sprintf(name,"admin user %d",current_users);
	//else sprintf(name,"visitor %d",current_users);
	//strcpy(lists[current_users-1].name,name);                //means new thread has created set user thread and name
	//lists[current_users-1].thread=pthread_self(); 

	strcpy(default_dir,"/home/tr/server");
	strcpy(current_dir,default_dir);
	chdir(default_dir);              //user default directory
	while(1){
		//strcpy(buffer,"server>new thread created!\n");
		//if(send(client_sock,buffer,30,0)==-1)printf("handcliendRequest error\n");
		// printf("do\n");
		//receive
		if(recv(client_sock,buffer,1024,0)==-1)break;
		isSplit = doSplit(' ',buffer,command,content);     //split command and content if split failed then command=buffer

		//execute user command
		//if(strcmp(command,"lcd")==0){//lcd
		//        if(user_kind==1)
		//                strcpy(buffer,"do lcd command!");
		//        else strcpy(buffer,"do lcd command!");
		//        send(client_sock,buffer,30,0);
		//}
		if(strcmp(command,"ls")==0){//ls
			doLs(client_sock,current_dir);
		}
		else if(strcmp(command,"pwd")==0){//pwd
			getcwd(buffer,40);
			send(client_sock,buffer,40,0); 
		}
		else if(strcmp(command,"binary")==0){//binary
			strcpy(buffer,"changed to binary mode");
			isBinary=1;
			send(client_sock,buffer,40,0); 
		}
		else if(strcmp(command,"ascall")==0){//ascall
			strcpy(buffer,"changed to ascall mode");
			isBinary=0;
			send(client_sock,buffer,40,0); 
		}
		else if(strcmp(command,"mkdir")==0){ //mkdir
			if(isSplit==-1||user_kind==-1){
				strcpy(buffer,"unable to operate");       //may needs content judge isSplited
				send(client_sock,buffer,100,0); 
			}
			else doMkDir(client_sock,content);
		}
		else if(strcmp(command,"rmdir")==0){//rmdir
			if(isSplit==-1||user_kind==-1){
				strcpy(buffer,"unable to operate");       //may needs content judge isSplited
				send(client_sock,buffer,100,0);
			}
			else doRmDir(client_sock,content);
		}
		else if(strcmp(command,"cd")==0){ //cd
			if(isSplit==-1||user_kind==-1){
				strcpy(buffer,"unable to operate");       //may needs content judge isSplited
				send(client_sock,buffer,100,0); 
			}
			else {
				if(strcmp(content,"")!=0&&strcmp(content,"\n")!=0)
					doCd(client_sock,current_dir,content);
			}                    
		}
		else if(strcmp(command,"testget")==0){ //get
			if(isSplit==-1||user_kind==-1){
				strcpy(buffer,"error");       //may needs content judge isSplited
				send(client_sock,buffer,100,0); 
			}
			else {
				//printf("buffer is:%s\n,content(file name)is:%s\n",buffer,content); *****************OUTPUT TEST
				doGet(client_sock,content);
			}
		}
		else if(strcmp(command,"put")==0){//rput
			if(isSplit==-1){
				strcpy(buffer,"anything");       //if splited filed anything to send because client only do when recv is filecontent
				send(client_sock,buffer,100,0); 
			}
			else {
				doContinuePutFile(client_sock,content);
			}
		}
		else if(strcmp(command,"get")==0){//rget
			if(isSplit==-1){
				strcpy(buffer,"anything");       //if splited filed anything to send because client only do when recv is filecontent
				send(client_sock,buffer,100,0); 
			}
			else {
				doContinueGetFile(client_sock,content);
			}
		}
		else if(strcmp(command,"testput")==0){ //put                          //upload files to server  content is file name
			if(isSplit==-1){
				strcpy(buffer,"nocontent");       //may needs content judge isSplited
				send(client_sock,buffer,100,0); 
			}
			else {
				memset(buffer,0,1024);
				strcpy(buffer,"filecontent");
				send(client_sock,buffer,100,0);         //need file content request
				recv(client_sock,buffer,100,0);        //recv again to get file content
				if(strcmp("error",buffer)==0)send(client_sock,buffer,100,0);          //open failed do nothig
				else doPut(client_sock,content,buffer);      //content: is file name buffer: is file content 
			}
		}
		else if(strcmp(command,"testget")==0){//get
			if(isSplit==-1){			//if no input send error
				strcpy(buffer,"error");
				send(client_sock,buffer,100,0);	
			}
			else{
				memset(buffer,0,1024);
				doGet(client_sock,content);
			} 
		}

		//exit command
		else if(strcmp(buffer,"quit")==0){
			strcpy(tlists[k].thread_name,"empty");
			current_users--;
			close(client_sock);
			return;
		}
		else {
			strcpy(buffer,"no such command\n");
			send(client_sock,buffer,30,0);
		}
	}
	// current_users--;
	// close(client_sock);
	// pthread_exit(NULL);
}


void *handServerRequest(void *arg){
	//struct UserThreadAndName *lists;
	//lists = (struct UserThreadAndName*)arg;
	pthread_detach(pthread_self());
	int k=0;
	char buffer[1024];
	char command[20];
	char content[20];
	int isSplited=-1;
	printf("server handler waiting\n");
	while(1){
		printf("server>");
		scanf(" %[^\n]",buffer);
		isSplited = doSplit(' ',buffer,command,content);
		if(strcmp(buffer,"count_all")==0){
			printf("all users:%d\n",total_users);
		}
		if(strcmp(buffer,"count_current")==0){
			printf("current users:%d\n",current_users);
		}
		if(strcmp(buffer,"quit")==0){
			quitSingal=1;
			exit(0);
			//break;    
		}
		if(strcmp(command,"kill")==0){
			if(isSplited!=-1){
				for(k=0;k<40;k++){
					if(strcmp(tlists[k].thread_name,content)==0){
						memset(tlists[k].thread_name,0,20);
						strcpy(tlists[k].thread_name,"empty");
						//pthread_cancel(tlists[k].thread);
						printf("%s killed",content);	
					}
				}
			}
		}
		if(strcmp(buffer,"lists")==0){
			//printf("enter lists\n");
			//printf("k is %d",k);
			//fflush(stdin);
			for(k=0;k<20;k++){
				//printf("k is %d",k);
				if(strcmp(tlists[k].thread_name,"empty")!=0){
					printf("%s,thread id: %lu\n",tlists[k].thread_name,tlists[k].thread);
				}
			}
			//printf("k is %d",k);
		}
		//if(strcmp(buffer,"list")==0){
		//    int i=0;
		//    for(;i<50;i++){
		//        if(strcmp(lists[i].name,"empty")!=0){
		//            printf("%s\n",lists[i].name);
		//            printf("%lu\n",lists[i].thread);
		//        }
		//    }
		//}
	}
	return;
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

void doRmDir(int client_sock,char *content){
	char buffer[1024];
	if(rmdir(content)==-1)strcpy(buffer,"unable to remove dir : ");
	else strcpy(buffer,"dir removed : ");
	strcat(buffer,content);
	send(client_sock,buffer,40,0);
}

void doMkDir(int client_sock,char * content){
	char buffer[1024];
	if(mkdir(content,S_IRUSR|S_IWUSR|S_IRGRP|S_IWGRP|S_IROTH|S_IWOTH|S_IXUSR|S_IXGRP|S_IXOTH)==-1){
		strcpy(buffer,"unable to create dir : ");
	}else{
		strcpy(buffer,"dir created : ");
	}   
	strcat(buffer,content);
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
	//printf("counts is %d,and record is%d,and split is%d\n",counts,record,isSplited);//******************DEBUG
	strncat(str[0],s,record);
	record++;
	for(;record<counts;record++)
		strncat(str[1],&s[record],1);
	int k=0;
	for(k=0;k<strlen(command);k++)command[k]=' ';
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
