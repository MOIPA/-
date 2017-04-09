#include<iostream>
using namespace std;

int count=0;
void attempt(int s){
	if(s<0)cout<<s<<endl;
	else {
		attempt(--s);
		count++;
	}
}
int main(void){
	int s=5;
	attempt(s);
	cout<<count<<endl;
	return 0;
}
