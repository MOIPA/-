//02 implement function in 02list
#include"02list.h"
void SayHi() {
	printf("hello world!-tr\n");
}

int Mul(int a,int b) {
	return a*b;
}
float Max(float a,float b) {
	return a>b?a:b;
}
void ScanTwoNumber(int *num) {
//	int *num;
	printf("enter two number explicted by space\n");
	scanf("%d %d",&num[0],&num[1]);
}
void IOStringDel() {
	char ch,nch;	/* */
	int count;	/* */
	int k;		/* */

	printf("Please input a string with a # in the end.\n");
	scanf("%c",&ch);	/* */
	while(ch != '#') {	/* */
		if(ch >= '0' && ch <= '9') {
			/* */
			count = ch-'0'+1;	/* */
			scanf("%c",&nch);	/* */
			for(k=0; k<count; k++)	/* */
				printf("%c",nch);
		} else
			printf("%c",ch);	/* */
		printf(" ");			/* */
		scanf("%c",&ch);		/* */
	}
	printf("#\n");				/* */

}
void IOString() {
//when user put a String and enter them to the program,it just scan one
//then put one to the buffer or out one oncetime?
	char ch;
	printf("Please input a string with a # in the end.\n");
	scanf("%c",&ch);
	while(ch!='#') {
		printf("%c",ch);
//		delay(500);
		sleep(1);
		scanf("%c",&ch);
	}
	printf("\n end \n");
}
void ShowSize() {
	printf("the byte(8bit) of type taken:\n");
	printf("int:%d\n",sizeof(int));
	printf("char:%d\n",sizeof(char));
	printf("long:%d\n",sizeof(long));
	printf("short:%d\n",sizeof(short));
	printf("unsigned int:%d\n",sizeof(unsigned int));
	printf("float:%d\n",sizeof(float));
	printf("double:%d\n",sizeof(double));
	printf("long double:%d\n",sizeof(long double));
}
void SequenceSum(){
	//数列求和 输入3 1+2+3
	int i,n,sum=0,temp=0;
	printf("input a number > 1\n");
	scanf("%d",&n);
	if(n<=1){
		printf("error number");
		return;
	} 
	for(i=1;i<=n;i++){
		temp++;
		sum+=temp;
	} 
	printf("result is : %d \n",sum);
} 
void PrintMultiplicationTable(){ 
	int i,j;
	for(i=1;i<=9;i++){
		for(j=i;j<=9;j++){
			printf("%d*%d=%-2d ",i,j,i*j);
		}
		printf("\n");
//		sleep(2);
	}
}
void NumberGame(){
	int n,gn;
	printf("guss number game\n please enter a number\n");
	scanf("%d",&n);
//	clrscr();  //conio.h TC平台专属
	system("cls"); 
	srand((int)time(0));
	gn=rand()%100;
	while(gn!=n){
		n>gn?printf("too bigger enter:\n"):printf("too smaller enter:\n");
		scanf("%d",&n);
	}
	printf("yes\n");
} 
void ReverseMatrix(){
	int ROW=3,COL=3,i,j;
	printf("enter ROW,COL\n");
	scanf("%d,%d",&ROW,&COL);
	printf("enter the element of the matrix(3*3)\n");
	int matrix[ROW][COL];
	for(i=0;i<ROW;i++){
		for(j=0;j<COL;j++){
			scanf("%d",&matrix[i][j]);
		}
	} 
	for(i=0;i<ROW;i++){
		for(j=0;j<COL;j++){
			printf("%d ",matrix[i][j]);
		}
		printf("\n");
	}
	printf("\n\n");
	for(i=0;i<ROW;i++){
		for(j=0;j<=i;j++){ //j<=i 不能等于col不然全部又换回来了 
			int temp = matrix[i][j];
			matrix[i][j]=matrix[j][i];
			matrix[j][i]=temp;
		}
	}
	for(i=0;i<ROW;i++){
		for(j=0;j<COL;j++){
			printf("%d ",matrix[i][j]);
		}
		printf("\n");
	}
} 
void PrimeNumber(){
	//数组里放质数，只要后面的不能整除前面的质数也为质数
	int primes[50];	 
}



