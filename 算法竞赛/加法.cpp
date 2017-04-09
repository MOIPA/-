#include<iostream>
using namespace std;
int main(void){
	int a,b,n;
	cin>>n;
	while(cin>>a>>b){
		cout<<a+b<<endl;
		n--;
		if(n<=0)break;
	} 
}
