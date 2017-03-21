package 排序;

public class shellSortFV {
			//交换函数
	public static void swap(int[] num,int x,int y){
		int temp;
		temp = num[x];
		num[x] = num[y];
		num[y] = temp;
	}
			//排序函数
	public static void sort(int[] num,int n){
		int i,j,gap;
		for(gap=n/2;gap>0;gap/=2){	//步长决定了循环次数直到步长为1
			for(i=gap;i<n;i++){	//从第步长的数开始，往后每一个数在它的步长分组内排序
				for(j=i-gap;j>=0&&num[j]>num[j+gap];j-=gap)//如果小于上个步长数 交换位置
					swap(num,j,j+gap);
			}
		}
	}
public static void main(String[] args) {
	int[] num = { 1, 2, 3, 0 };
	sort(num, 4);
	System.out.println(num[0] + " " + num[1] + " " + num[2] + " " + num[3] + " ");
}
}
