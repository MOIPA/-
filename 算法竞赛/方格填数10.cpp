#include<iostream>
using namespace std;

int count=0;

//ÅĞ¶ÏÊÇ·ñÏàÁÚ 
bool compare(int num[],int x,int y){
		if(num[x]==num[y]||num[x]-num[y]==1||num[x]-num[y]==-1)return false;
		else return true;
}

//ÅÅÁĞº¯Êı
void swap(int *x,int *y){
	int temp=*x;
	*x=*y;
	*y=temp;
}
void perm(int num[],int x,int y){
	if(x>y){
		int f=1;
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
		if(f==1)count++;
	}else{
		for(int i=x;i<=y;i++){
			swap(&num[x],&num[i]);
			perm(num,x+1,y);
			swap(&num[x],&num[i]);
		}
	}
}
 
int main(void){
	
	int num[10]={0,1,2,3,4,5,6,7,8,9};
	perm(num,0,9);
	cout<<count<<endl;
	
}
