#include<iostream>
using namespace std;
int count=0,f=1;
bool compare(int num[],int x,int y){
		if(num[x]==num[y]||num[x]-num[y]==1||num[x]-num[y]==-1)return false;
		else return true;
}

int main(void){
	int num[11];
	
	for(int a0=0;a0<10;a0++)
	for(int a1=0;a1<10;a1++)
	for(int a2=0;a2<10;a2++)
	for(int a3=0;a3<10;a3++)
	for(int a4=0;a4<10;a4++)
	for(int a5=0;a5<10;a5++)
	for(int a6=0;a6<10;a6++)
	for(int a7=0;a7<10;a7++)
	for(int a8=0;a8<10;a8++)
	for(int a9=0;a9<10;a9++){
		num[0]=a0;num[4]=a4;num[7]=a7;
		num[1]=a1;num[5]=a5;num[8]=a8;
		num[2]=a2;num[6]=a6;num[9]=a9;
		num[3]=a3;
		if(!compare(num,0,1))f=0;
		if(!compare(num,0,3))f=0;
		if(!compare(num,0,4))f=0;
		if(!compare(num,0,5))f=0;
		
		if(!compare(num,1,2))f=0;
		if(!compare(num,1,4))f=0;
		if(!compare(num,1,5))f=0;
		if(!compare(num,1,6))f=0;
		
		
		if(!compare(num,2,5))f=0;
		if(!compare(num,2,6))f=0;
		
		
		if(!compare(num,3,4))f=0;
		if(!compare(num,3,7))f=0;
		if(!compare(num,3,8))f=0;
	 	
	 	
		if(!compare(num,4,5))f=0;
		if(!compare(num,4,7))f=0;
		if(!compare(num,4,8))f=0;
		if(!compare(num,4,9))f=0;
		
		
		if(!compare(num,5,6))f=0;
		if(!compare(num,5,8))f=0;
		if(!compare(num,5,9))f=0;
		 
		
		if(!compare(num,6,9))f=0;
		if(!compare(num,7,8))f=0;
		if(!compare(num,8,9))f=0;
		if(f==1){
			count++;
			cout<<count<<endl;
		}
		f=1;
	}
	
}
