public class BubbleSort {
	
	public static void swap(int[] array,int x,int y){
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
	
	public static void Bsort(int[] array){
		for(int i=0;i<array.length;i++)
			for(int j=0;j<array.length-i-1;j++)
				if(array[j]>array[j+1])
					swap(array,j,j+1);
	}
	
	public static void main(String[] args) {
		int[] test = new int[10];
		
		for(int i=0;i<10;i++)
			test[i] = (i*77)%10;

		for(int i=0;i<10;i++)
			System.out.print(test[i]+" ");
		System.out.println();
		
		Bsort(test);
		
		for(int i=0;i<10;i++)
			System.out.print(test[i]+" ");
	}
}
