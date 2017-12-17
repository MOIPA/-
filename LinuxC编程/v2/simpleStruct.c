#include<stdio.h>

typedef struct{
	int number;
}Data;

typedef struct{
	Data data;	
}Para;

int main(void){

	//Data *d2 = (Data*)malloc(sizeof(Data)*10); 
	Data *d2;
	d2[0].number=-3;
	d2[1].number=-2;
	//Data d3[10];
	//Data *d3 = (Data*)malloc(sizeof(Data)*10); 
	Data *d3;
	d3 = d2;
	printf("%d\n",d3[1].number);


	Data d1;
	d1.number=-1;
	Para p1;
	p1.data = d1;
	d1.number=-2;
	printf("%d\n",p1.data.number);

}
