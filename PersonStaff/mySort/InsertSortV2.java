
public class InsertSortV2 {
	public static void Sort(int[] num){
		int n=num.length;
		int i,j;
		for(i=1;i<n;i++){
			if(num[i]<num[i-1]){
				int temp = num[i];
				for(j=i-1;j>=0&&num[j]>temp;j--)
					num[j+1] = num[j];
				num[j+1] = temp;
			}
		}
	}
	public static void main(String[] args) {
		int[] num = {1,2,3,0};
		Sort(num);
		System.out.println(num[0]+" "+num[1]+" "+num[2]+" "+num[3]+" ");
	}
}
