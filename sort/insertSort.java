package 排序;

public class insertSort {
	private int[] num;
	private int len = num.length;
	public void insertSort(int[] forSort){
		num = forSort;
	}
	//插入函数：p2insert是被插入的地点 p是插入的位置的数的位置
	//功能是在数组内的数载数组内插入同时不改变数组大小
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
			int flag=0,posi=0; //判断是否进入if语句
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
