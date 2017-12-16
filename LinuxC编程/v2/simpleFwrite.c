#include<stdio.h>
#include<string.h>
int main(void){

        FILE *file;
        char buffer[1024];
        memset(buffer,' ',1024);
        strcpy(buffer,"test content");
        file = fopen("a","wb+");
        int i=0;
        while(buffer[i]!=0)
                fwrite(&buffer[i++],sizeof(char),1,file);
        fclose(file);

        return 0;
}
