#include<stdio.h>
#include<sys/types.h>
#include<sys/stat.h>

int main(void){

chdir("/home/tr/");
mkdir("test",S_IWOTH|S_IROTH|S_IWUSR|S_IRUSR|S_IWGRP|S_IRGRP);

return 0;
}
