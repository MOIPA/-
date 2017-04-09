#include<iostream>
using namespace std;

int count=0;

void swap(int *x,int *y){
	int temp=*x;
	*y=*x;
	*x=temp;
}

void perm(int num[],int start,int end){
	if(start>end){
		//for(int i=0;i<=end;i++)cout<<num[i]<<" ";
		if( num[0]+(float)num[1]/num[2]+
		(float)(num[3]*100+num[4]*10+num[5])/
		(num[6]*100+num[7]*10+num[8]) ==10){
			count++;
			cout<<num[0]<<"+"<<num[1]<<"/"<<num[2]<<"+"<<num[3]<<num[4]<<num[5]<<"/"
			<<num[6]<<num[7]<<num[8]<<endl;
		}
		
		//cout<<endl;
	}else
		for(int i=start;i<=end;i++){
			swap(num[start],num[i]);
			perm(num,start+1,end);
			swap(num[start],num[i]);
		}
	
} 

int main(void){
	int num[]={1,2,3,4,5,6,7,8,9};
	perm(num,0,8);
	cout<<count<<endl;
}
