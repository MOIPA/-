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
	//数列求和 输入3 1+2+3
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
//	clrscr();  //conio.h TC平台专属
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
		for(j=0; j<=i; j++) { //j<=i 不能等于col不然全部又换回来了
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
	//数组里放质数，只要后面的不能整除前面的质数也为质数,除了2以外都是奇数
	int primes[N]; //质数列表
	int pc=0;//质数个数
	int rn = 3; //候选质数
	int i,j,is=0;//质数判断位
	for(i=0; i<N; i++) primes[i]=-1;
	printf(" %d  primes:\n",N);
	primes[0]=2;
	pc++;
	while(pc<N) {
		for(i=0; i<pc; i++) {
			if(rn%primes[i]==0) {
				rn+=2;	//合数 准备下一个数测试
				is=0; 	//不是质数
				break;	//合数，不用找了跳出
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
	primes[0]=2;/*2是第一个质数*/
	pc             =1;/*已有第一个质数*/
	m               =3;/*被测试的数从3开始*/
	while(pc<N) {
		/*调整m使它为下一个质数*/
		k=0;
		while(primes[k]*primes[k]<=m)
			if(m%primes[k]==0) {
				/*m是合数*/
				m+=2;/*让m取下一个奇数*/
				k=1;/*不必用primes[0]=2去测试m，所以k从一开始*/
			} else
				k++;/*继续用下一个质数去测试*/
		primes[pc++]=m;
		m+=2;/*除2外，其余质数均是奇数*/
	}
	/*输出primes[0]至primes[pc-1]*/
	for(k=0; k<pc; k++)
		printf("%4d",primes[k]);
	printf("\n\n Press any key to quit...\n ");
	getch();
}

void PermanentCalendar(int year) {
//	printf("%d",ShowWhichDay(2018,2,1));
	int m2 = 28;
	if(1==IsLeap(year)) {
		m2=29;
	}
	PrintOneMonth(2018,9,30);
}
void PrintOneMonth(int year,int month,int days) {
	int wDay,i,j,fDay=2; //fDay 数组里面即将填写的天
	int cal[6][7];
	for(i=0; i<6; i++)for(j=0; j<7; j++)cal[i][j]=0;
	//首先计算这月一日是周几
	wDay = ShowWhichDay(year,month,1);
	if(0==wDay)wDay=7;
	cal[0][wDay-1]=1;
	//填充剩下的日子到数组
	for(i=0; i<6; i++) {
		if(fDay>days)break;//填完了 出去
		for(j=0; j<7; j++) {
			if(fDay>days)break;//填完了 出去
			if(i==0&&fDay==2) { //第一层第一个 前面有不用写的
				j+=wDay;//假如是2 直接在数组[2]写
				if(wDay==7)break;//这层不用写
			}
			cal[i][j] = fDay++;
		}
	}
	//打印显示
	for(i=1; i<=7; i++) {
		switch(i) {
			case 1:
				printf("%10s","monday");
				break;
			case 2:
				printf("%10s","tuesday");
				break;
			case 3:
				printf("%10s","wednesday");
				break;
			case 4:
				printf("%10s","Thursday");
				break;
			case 5:
				printf("%10s","friday");
				break;
			case 6:
				printf("%10s","saturday");
				break;
			case 7:
				printf("%10s","sunday");
				break;
		}
	}
	printf("\n");
	for(i=0; i<6; i++) {
		for(j=0; j<7; j++) {
			if(cal[i][j]==0) {
				printf("%10s"," ");
				continue;
			}
			printf("%10d",cal[i][j]);
		}
		printf("\n");
	}
}

int ShowWhichDay(int year,int month,int day) {
	//w=y+[y/4]+[c/4]-2c+[26(m+1)/10]+d-1
	//w:星期 c:世纪-1 y:年（两位数） m:月 >=3 <=14 (1,2月份看作去年的13，4月份);
	int num[10],i;
	int yearFull=year,fwYear;
	int century;
	//得到后面两位年份和世纪
	i=SplitNumber(num,yearFull);
	fwYear = num[i-2]*10+num[i-1];
	century=yearFull/100;
	if(1==month||2==month) {
		month+=12;
		fwYear--;
	}
	int w=0;
	w=fwYear+fwYear/4+century/4-2*century+26*(month+1)/10+day-1;
//	switch(w%7) {
//		case 1:
//			printf("\nit is the monday\n");break;
//		case 2:
//			printf("\nit is the tuesday\n");break;
//		case 3:
//			printf("\nit is the wednesday\n");break;
//		case 4:
//			printf("\nit is the Thursday\n");break;
//		case 5:
//			printf("\nit is the friday\n");break;
//		case 6:
//			printf("\nit is the saturday\n");break;
//		case 0:
//			printf("\nit is the sunday\n");break;
//	}
	if(w<0)return (w%7+7)%7;
	return w%7;
}
int SplitNumber(int *num,int targetNum) {
	//分割数字  返回数组大小
	int i=0,j;
	while(targetNum>0) {
		num[i++]=targetNum%10;
		targetNum /=10;
	}
	//倒一下
	for(j=0; j<i/2; j++) {
		int temp = num[j];
		num[j] = num[i-1-j];
		num[i-1-j]=temp;
	}
	return i;
}

void testScanfFormat() {
	//小测试
	char str[20];
	printf("input things with space\n");
	scanf("%[^\n]%*c",str); //读入带有空格的字符串
	//%[^\n] ^:非 表示读入知道\n结束但是不读入\n  %*c读入\n以免后面的读入第一个就是\n
	printf("%s",str);
}

int IsLeap(int year) { //判断是否是闰年 闰年2月29天 平年2月28天
//能被4整除并且不能被100整除  或者被400整除的就是闰年
	if(year%4==0&&year%100!=0||year%400==0)return 1;
	return 0;
}

void ArraySort(int *num,int len){
//	双向冒泡排序算法的运作如下：
//传统冒泡气泡排序的双向进行，先让气泡排序由左向右进行，再来让气泡排序由右往左进行，如此完成一次排序的动作
//使用left与right两个旗标来记录左右两端已排序的元素位置。
	int temp;
	int left=0,right=len-1,i,j;
	while(left<right){
		//先是从小到大排序一次选择一个最大的到最后
		for(i=left;i<right;i++){
			if(num[i]>num[i+1])Swap(&num[i],&num[i+1]);
		} 
		right--;
		//从小到大排序选择一个最小的到前面
		for(i=left;i<right;i++){
			if(num[i]>num[i+1])Swap(&num[i],&num[i+1]);
		} 	
		left++;
	} 
} 

void Swap(int *a,int *b){
	int temp=*b;
	*b=*a;
	*a=temp;
}





















