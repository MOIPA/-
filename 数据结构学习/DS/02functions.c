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
void SequenceSum() {
	//������� ����3 1+2+3
	int i,n,sum=0,temp=0;
	printf("input a number > 1\n");
	scanf("%d",&n);
	if(n<=1) {
		printf("error number");
		return;
	}
	for(i=1; i<=n; i++) {
		temp++;
		sum+=temp;
	}
	printf("result is : %d \n",sum);
}
void PrintMultiplicationTable() {
	int i,j;
	for(i=1; i<=9; i++) {
		for(j=i; j<=9; j++) {
			printf("%d*%d=%-2d ",i,j,i*j);
		}
		printf("\n");
//		sleep(2);
	}
}
void NumberGame() {
	int n,gn;
	printf("guss number game\n please enter a number\n");
	scanf("%d",&n);
//	clrscr();  //conio.h TCƽ̨ר��
	system("cls");
	srand((int)time(0));
	gn=rand()%100;
	while(gn!=n) {
		n>gn?printf("too bigger enter:\n"):printf("too smaller enter:\n");
		scanf("%d",&n);
	}
	printf("yes\n");
}
void ReverseMatrix() {
	int ROW=3,COL=3,i,j;
	printf("enter ROW,COL\n");
	scanf("%d,%d",&ROW,&COL);
	printf("enter the element of the matrix(3*3)\n");
	int matrix[ROW][COL];
	for(i=0; i<ROW; i++) {
		for(j=0; j<COL; j++) {
			scanf("%d",&matrix[i][j]);
		}
	}
	for(i=0; i<ROW; i++) {
		for(j=0; j<COL; j++) {
			printf("%d ",matrix[i][j]);
		}
		printf("\n");
	}
	printf("\n\n");
	for(i=0; i<ROW; i++) {
		for(j=0; j<=i; j++) { //j<=i ���ܵ���col��Ȼȫ���ֻ�������
			int temp = matrix[i][j];
			matrix[i][j]=matrix[j][i];
			matrix[j][i]=temp;
		}
	}
	for(i=0; i<ROW; i++) {
		for(j=0; j<COL; j++) {
			printf("%d ",matrix[i][j]);
		}
		printf("\n");
	}
}
void PrimeNumber() {
	int N=50;
	//�������������ֻҪ����Ĳ�������ǰ�������ҲΪ����,����2���ⶼ������
	int primes[N]; //�����б�
	int pc=0;//��������
	int rn = 3; //��ѡ����
	int i,j,is=0;//�����ж�λ
	for(i=0; i<N; i++) primes[i]=-1;
	printf(" %d  primes:\n",N);
	primes[0]=2;
	pc++;
	while(pc<N) {
		for(i=0; i<pc; i++) {
			if(rn%primes[i]==0) {
				rn+=2;	//���� ׼����һ��������
				is=0; 	//��������
				break;	//������������������
			}
		}
		if(is==1)primes[pc++]=rn;
		is=1;
	}
	for(i=0; i<N; i++) printf("%d ",primes[i]);
}

void t() {
	int N=50;
	int primes[N];
	int pc,m,k;
	printf("\n The first %d prime numbers are:\n",N);
	primes[0]=2;/*2�ǵ�һ������*/
	pc             =1;/*���е�һ������*/
	m               =3;/*�����Ե�����3��ʼ*/
	while(pc<N) {
		/*����mʹ��Ϊ��һ������*/
		k=0;
		while(primes[k]*primes[k]<=m)
			if(m%primes[k]==0) {
				/*m�Ǻ���*/
				m+=2;/*��mȡ��һ������*/
				k=1;/*������primes[0]=2ȥ����m������k��һ��ʼ*/
			} else
				k++;/*��������һ������ȥ����*/
		primes[pc++]=m;
		m+=2;/*��2�⣬����������������*/
	}
	/*���primes[0]��primes[pc-1]*/
	for(k=0; k<pc; k++)
		printf("%4d",primes[k]);
	printf("\n\n Press any key to quit...\n ");
	getch();
}

void PermanentCalendar() {

}

void ShowWhichDay() {
	//w=y+[y/4]+[c/4]-2c+[26(m+1)/10]+d-1
	//w:���� c:����-1 y:�꣨��λ���� m:�� >=3 <=14 (1,2�·ݿ���ȥ���13��4�·�);
	int num[10],i;
	int yearFull,fwYear;
	int century,month,day;
//	int targetNum=123456;
//	int len = SplitNumber(num,targetNum);
//	for(i=0;i<len;i++)printf("ret:%4d",num[i]);
	printf("enter the expected year:");
	scanf("%d",&yearFull);
	printf("enter the expected month,day:");
	scanf("%d,%d",&month,&day);

//	if(yuearFull>3000||yuearFull<1000){
//		printf("error year");
//	}
	//�õ�������λ��ݺ�����
	i=SplitNumber(num,yearFull);
	fwYear = num[i-2]*10+num[i-1];
	century=yearFull/100;
	if(1==month||2==month)month+=12;
	int w=0;
	w=fwYear+fwYear/4+century/4-2*century+26*(month+1)/10+day-1;
	switch(w%7) {
		case 1:
			printf("\nit is the monday\n");break;
		case 2:
			printf("\nit is the tuesday\n");break;
		case 3:
			printf("\nit is the wednesday\n");break;
		case 4:
			printf("\nit is the Thursday\n");break;
		case 5:
			printf("\nit is the friday\n");break;
		case 6:
			printf("\nit is the saturday\n");break;
		case 7:
			printf("\nit is the sunday\n");break;
	}
}
int SplitNumber(int *num,int targetNum) {
	//�ָ�����  ���������С
	int i=0,j;
	while(targetNum>0) {
		num[i++]=targetNum%10;
		targetNum /=10;
	}
	//��һ��
	for(j=0; j<i/2; j++) {
		int temp = num[j];
		num[j] = num[i-1-j];
		num[i-1-j]=temp;
	}
	return i;
}

void testScanfFormat(){
	//С����
	char str[20];
	printf("input things with space\n");
	scanf("%[^\n]%*c",str); //������пո���ַ��� 
	//%[^\n] ^:�� ��ʾ����֪��\n�������ǲ�����\n  %*c����\n�������Ķ����һ������\n 
	printf("%s",str); 
}























