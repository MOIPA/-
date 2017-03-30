#include<iostream>
using namespace std;
int *ret(int num[],int times){
	int count=0;
	while(num[count]!=-1)count++;
	for(int i=0;i<count;i++)num[i]*=times;
	for(int i=0;i<count;i++)
	if(num[i]>9){
		if(num[i+1]==-1)num[i+1]+=num[i]/10+1;
		else num[i+1]+=num[i]/10;
		num[i]=num[i]%10;	
	}
	return num;
}
void printNum(int num[]){
	int count=0;
	while(num[count++]!=-1);
	for(int i=count-2;i>=0;i--)cout<<num[i];
	cout<<endl;
}
int main(void){
	int n,count=2;
	int *num=new int[1000];
	cin>>n;
	while(n!=-1){
		for(int i=0;i<1000;i++)num[i]=-1;
		num[0]=1;

		for(int i=1;i<n;i++)num=ret(num,count++);
	//for(int i=0;i<5;i++)cout<<num[i]<<" ";
		printNum(num);
		cin>>n;
		count=2;
	}
	
//	@test//succeed!	
//	num[0]=1;
//	num[1]=1;
//	num=ret(num,8);
//	for(int i=0;i<5;i++)cout<<num[i]<<" ";
	
}