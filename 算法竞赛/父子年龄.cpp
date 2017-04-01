#include<stdio.h>
#include<iostream>
using namespace std;
int main(void){
	int son,father,father_s;
	for(son=1;son<=72;son++){
		father=son+27;
		father_s=(father%10*10)+(father/10);
		if(father_s==son)cout<<father<<endl;
	}
	
	return 0;
}
