#include<stdio.h>
#include<string.h>
#include<stdlib.h>


int doSplit2(char split,const char *s,char* command,char *content){
    char str[2][1024];
    
    int counts=strlen(s),record,isSplited=0;
    
    for(record=0;record<counts;record++){
        if(s[record]==split)break;
    }
    if(record==counts)isSplited=-1;     //无法分割命令和参数
    strncat(str[0],s,record);
    record++;
    for(;record<counts;record++)
        strncat(str[1],&s[record],1);
    strcpy(command,str[0]);
    strcpy(content,str[1]);
    return isSplited;                       
}

void doSplit(char split,char *s){
    char str[2][1024];
    
    int counts=strlen(s),record;
    
    for(record=0;record<counts;record++){
        if(s[record]==split)break;
    }
    strncat(str[0],s,record);
    record++;
    for(;record<counts;record++)
        strncat(str[1],&s[record],1);
    
    printf("first is:%s\n",str[0]);
    printf("second is:%s\n",str[1]);
}

int main(void){
    char buffer[1024]={0};
    char command[1024]={0};
    char content[1024]={0};
    scanf("%[^\n]",buffer);
    int res = doSplit2(' ',buffer,command,content);
    memset(buffer,0,strlen(buffer));
    memset(command,0,strlen(command));
    memset(content,0,strlen(content));
    printf("buffer is %s\n and command is %s\n",buffer,command);
    strcpy(buffer,"cd");
    res = doSplit2(' ',buffer,command,content);
    printf("buffer is%s\nresult is:%d\ncommand is:%s\ncontent is:%s\n",buffer,res,command,content);
return 0;
}
