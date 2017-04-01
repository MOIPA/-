#include<iostream>
using namespace std;

int count=0;

void swap(int *x,int *y){
	int m;
	m=*x;
	*x=*y;
	*y=m;
}

void perm(int num[],int x,int y){
	if(x>y){
		for(int i=0;i<=y;i++)cout<<num[i]<<" ";
		cout<<endl;
		count++;
	}else{
		for(int i=x;i<=y;i++){
			swap(&num[x],&num[i]);
			perm(num,x+1,y);
			swap(&num[x],&num[i]);//*********每次换完都得换回来！！！！！！ 
		}
	} 
} 

int main(void){
	int num[]={1,2,3,4,5};
	perm(num,0,4);
	cout<<"********"<<count<<"********"<<endl;
}
