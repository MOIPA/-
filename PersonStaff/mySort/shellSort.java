public class shellSort {
	public void sort(int[] num,int n){
		int i,j,gap;
		for(gap=n/2;gap>0;gap/=2){
			for(i=0;i<gap;i++){
				for(j=i+gap;j<n;j+=gap){
					if(num[j]<num[j-gap]){
						int temp = num[j];
						int k = j-gap;
						while(k>=0&&num[k]>temp){
							num[k+gap] = num[k];
							k-=gap;
						}
						num[k+gap]=temp;
					}
				}
			}
		}
	}
}