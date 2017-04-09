#include<iostream>
using namespace std;

int count=0;

bool exist4or1(int ret[],int x){
	bool flag=false;
	for(int i=0;i<5;i++)
		if(ret[x]-ret[i]==1||ret[x]-ret[i]==-1||ret[x]-ret[i]==4||ret[x]-ret[i]==-4)
			flag=true;
	return flag;
}

bool judge(int ret[]){
	bool flag=true;
	for(int i=0;i<5;i++){
		if(!exist4or1(ret,i))flag=false;
	}
	return flag;
}



void Comb(int num[],int result[],int s,int e,int take){
	if(take<=0){
		if(judge(result)){
			count++;
			for(int i=0;i<5;i++)cout<<result[i]<<" ";
			cout<<endl;
		}
		
	}else{
		for(int i=s;i<=e;i++){
			result[take-1]=num[i];
			Comb(num,result,++s,e,take-1);
		}
	}
}

int main(void){
	int num[]={1,2,3,4,5,6,7,8,9,10,11,12};
	int result[10];
	
	//int testRet[]={4,3,6,7,9};
	//cout<<judge(testRet)<<endl;
	
	Comb(num,result,0,11,5);
	cout<<"********"<<count<<"********"<<endl;
}
