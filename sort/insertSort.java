package ����;

public class insertSort {
	private int[] num;
	private int len = num.length;
	public void insertSort(int[] forSort){
		num = forSort;
	}
	//���뺯����p2insert�Ǳ�����ĵص� p�ǲ����λ�õ�����λ��
	//�������������ڵ����������ڲ���ͬʱ���ı������С
	public void insert(int p2insert,int p){
		int temp=num[p-1];
		for(int i=p-1;i>=p2insert;i--){
			num[i]=num[i-1];
		}
		num[p2insert-1]=temp;
	}
	
	public void sort(){
		int next;
		for(int point=0;point<len;point++){ 
			int flag=0,posi=0; //�ж��Ƿ����if���
			next = point+1;
			if(num[next]<num[point]){
				flag = 1;
				while(num[next]<num[point-posi])
					posi++;
					
			}
			if(flag==1)insert(point-posi+1,next);
		}
		
	}
	
}
