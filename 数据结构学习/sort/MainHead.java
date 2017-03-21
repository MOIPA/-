package ≈≈–Ú;

import java.awt.HeadlessException;

public class MainHead {

	public static void main(String[] args) {
		HeapSort sort = new HeapSort();
		Integer[] test = new Integer[10];
		
		for(int count=0;count<1000;count++){
			for(int i=0;i<10;i++)
				test[i] = (int)(Math.random()*100);
			sort.sort(test);
			for(int i=0;i<test.length-1;i++){
					if(test[i]>test[i+1]) System.out.println("failued!");
					//else System.out.println("succeeded!");
					}
		}
	}
}
