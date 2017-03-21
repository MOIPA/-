package ≈≈–Ú;

public class InsertSortV1 {
	public static void Sort(int[] num,int n){
		int i,j,k;
		for(i=1;i<n;i++){
			for(j=i-1;j>=0;j--)
				if(num[j]<num[i])
					break;
			System.out.println("j="+j);
			if(j!=i-1){
				int temp = num[i];
				for(k=i-1;k>j;k--)
					num[k+1]=num[k];
					num[k+1]=temp;
				
			}
		}
	}
	public static void main(String[] args) {
		int[] num = {1,2,3,0};
		Sort(num, 4);
		System.out.println(num[0]+" "+num[1]+" "+num[2]+" "+num[3]+" ");
	}
}
