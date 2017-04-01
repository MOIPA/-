#include<iostream>
using namespace std;

int count=0;

void swap(int *x,int *y){
	int temp=*x;
	*x=*y;
	*y=temp; 
} 

void perm(int num[],int x,int y){
	if(x>y){
		if(num[0]+num[1]==num[2])
			if(num[3]-num[4]==num[5])
				if(num[6]*num[7]==num[8])
					if(num[9]==num[10]*num[11]){
						count++;
						cout<<"********************************"<<endl;
						cout<<num[0]<<'+'<<num[1]<<'='<<num[2]<<endl;
						cout<<num[3]<<'-'<<num[4]<<'='<<num[5]<<endl;
						cout<<num[6]<<'*'<<num[7]<<'='<<num[8]<<endl;
						cout<<num[9]<<'/'<<num[10]<<'='<<num[11]<<endl; 
						cout<<"********************************"<<endl;
						cout<<endl;
					}
	}else{
		for(int i=x;i<=y;i++){
			swap(&num[x],&num[i]);
			perm(num,x+1,y);
			swap(&num[x],&num[i]);
		}
	}
}

int main(void){
	int num[]={6,7,13,9,8,1,3,4,12,10,2,5,11};
	perm(num,0,11);
	cout<<count;
	return 0;
} 
