package 排序;

public class QuickSort {
	
	public static void Swap(int[] num,int x,int y){
		int temp = num[x];
		num[x]=num[y];
		num[y]=temp;
	}
	
	public static void setpoint(int[] num,int x){
		Swap(num,0,x);
	}
	
	public static void qsort(int[] num,int start,int end)
	{
		if (start < end)
		{
			int i = start, j = end, x = num[start];
			
			while (i < j)
			{
				while (i < j && num[j] >= x) // 从右向左找第一个小于x的数
					j--;
				if (i < j)
					num[i++] = num[j];

				while (i < j && num[i] < x) // 从左向右找第一个大于等于x的数
					i++;
				if (i < j)
					num[j--] = num[i];
			}
			num[i] = x;
			qsort(num, start, i - 1);
			qsort(num, i + 1, end);
		}
	}
	
	
	
	public static void main(String[] args) {
		int[] num = {2,5,1,4,8,3};
		qsort(num,0,5);
		//Swap(num, 0, 1);
		System.out.println(num[0]+" "+num[1]+" "+num[2]+" "+num[3]+" "+num[4]+" "+num[5]+" ");
		
	}
}
