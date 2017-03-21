package ÅÅĞò;

public class shellSort {
	public static void sort(int[] num,int n){
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
	
	public static void main(String[] args) {
		int[] num = {1,2,3,0};
		sort(num, 4);
		System.out.println(num[0]+" "+num[1]+" "+num[2]+" "+num[3]+" ");
	}
}
