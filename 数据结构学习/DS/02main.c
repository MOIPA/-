//02 main
#include"02list.h"

int main(void) {
	//SayHi();
//	int num[2];
//	ScanTwoNumber(num);
//	doMul(num);
//	doMax(num);
//	IOString();
//	ShowSize();
//	SequenceSum();
//	PrintMultiplicationTable();
//	NumberGame();
//	ReverseMatrix();
//	PrimeNumber();
//	t();
//	ShowWhichDay();
//	testScanfFormat();
//	PermanentCalendar();
	doArraySort();
	return 0;
}



void doMul(int *num) {
	printf("mul result: %d\n",Mul(num[0],num[1]));
}

void doMax(int *num){
	printf("max result: %.0f \n",Max(num[0],num[1]));
}
void doArraySort(){
	int i;
	int num[10] = {-10,1,-20,3,7,5,-6,0,-20,8};
	for(i=0;i<10;i++)printf("%d||",num[i]);
	ArraySort(num,10);
	printf("\n");
	for(i=0;i<10;i++)printf("%-3d",num[i]);
} 
