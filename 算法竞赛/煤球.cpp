#include<iostream>
using namespace std;

int produc(int n){
	return n+n*(n-1)/2;
}

int main(void){
	int sum=0;
	for(int i=1;i<=5;i++)
		sum+=produc(i);
	cout<<sum<<endl;	
}
