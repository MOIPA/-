//02 main
#include"02list.h"

int main(void) {
	//SayHi();
//	int num[2];
//	ScanTwoNumber(num);
//	doMul(num);
//	doMax(num);
//	IOString();
	ShowSize();
	return 0;
}

void doMul(int *num) {
	printf("mul result: %d\n",Mul(num[0],num[1]));
}

void doMax(int *num){
	printf("max result: %.0f \n",Max(num[0],num[1]));
}

