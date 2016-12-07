package ÅÅĞò;

public class ChoseSort {
	
	public static void swap(int[] array,int x,int y){
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
	
	public static void Csort(int[] array){
		for(int i=0;i<array.length;i++)
			for(int j=0;j<array.length;j++)
				if(array[i]<array[j])
					swap(array,i,j);
	}
	
	public static void main(String[] args) {
		int[] test = new int[10];
		
		for(int i=0;i<10;i++)
			test[i] = (i*44)%10;

		for(int i=0;i<10;i++)
			System.out.print(test[i]+" ");
		System.out.println();
		
		Csort(test);
		
		for(int i=0;i<10;i++)
			System.out.print(test[i]+" ");
	}
}

