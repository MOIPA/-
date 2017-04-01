#include<iostream>
using namespace std;
int main(void){
	for(int x=0;x<100;x++)
		for(int n=0;n<100;n++)
			if(n*x+((n-1)*n)/2==236)cout<<x<<endl;
	return 0;
}
