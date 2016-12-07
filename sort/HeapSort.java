package ≈≈–Ú;

public class HeapSort {
	public static void sort(Integer[] forSortArray){
		Integer[] array;
		array = new Integer[forSortArray.length+1];
		System.arraycopy(forSortArray, 0, array, 1, forSortArray.length);
		
		makeHeap(array);
		//for(int i=1;i<=array.length-1;i++)
		//	System.out.print(array[i]+" ");
		screen(array);
		
		System.arraycopy(array, 1, forSortArray, 0, forSortArray.length);
	}
	
	private static void makeHeap(Integer[] array){
		for(int i=array.length-1;i>=1;i--){
			do_screen(array, i, array.length-1);
		}
	}
	
	private static void screen(Integer[] array){
		for(int pos=array.length-1;pos>=1;pos--){
			swap(array,1,pos);
			do_screen(array,1,pos-1);
		}
	}
	
	private static Integer max(Integer[] num,Integer x,Integer y){
		if(num[x]>num[y]) return x;
		else return y;
	}
	
	private static void do_screen(Integer[] array,Integer start,Integer end){
		int p=start;
		while(p<=end){
		if(!isHeapNode(array, p, end))
			if(p*2==end)
				swap(array,p,p*2);
			else if(p*2+1<=end)
				swap(array,p,max(array,p*2,p*2+1));
		p++;   //***********************************************
		}
	}
	
	private static boolean isHeapNode(Integer[] array,int start,int end){
		if(start*2>end)
			return true;
		else if(start*2==end&&array[end]<array[start])
			return true;
		else if(start*2+1<=end&&array[start*2+1]<array[start]&&array[start*2]<array[start])
			return true;
		else return false;
	}
	
	private static void swap(Integer[] array,int x,int y){
		int temp = array[x];
		array[x]=array[y];
		array[y]=temp;
	}
	
}
