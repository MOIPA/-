
public class shellSortFV {
	private void swap(int[] num,int x,int y){
		int temp;
		temp = num[x];
		num[x] = num[y];
		num[y] = temp;
	}
	private void sort(int[] num,int n){
		int i,j,gap;
		for(gap=n/2;gap>0;gap/=2){
			for(i=gap;i<n;i++){
				for(j=i-gap;j>=0&&num[j]>num[j+gap];j-=gap)
					swap(num,j,j+gap);
			}
		}
	}

}
