

public class QuickSort {
	
	private void Swap(int[] num,int x,int y){
		int temp = num[x];
		num[x]=num[y];
		num[y]=temp;
	}
	
	private void setpoint(int[] num,int x){
		Swap(num,0,x);
	}
	
	private void qsort(int[] num,int start,int end)
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
	public void sort(int[]num){
		qsort(num,0,num.length-1);
	}
}
