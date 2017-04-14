package os.jlxy.tr.rewrite.test;

import javax.xml.crypto.dsig.CanonicalizationMethod;

public class testCompare {
	
	public static void main(String[] args) {
		int[] array={4,2,3,1,5};
		System.out.println(campareArray(array));
	}
	
	private static int campareArray(int[] array){
		int minRecord = 0;
		int minNumber = 100;
		for(int i=0;i<array.length;i++){
			if(minNumber>array[i]){
				minNumber = array[i];
				minRecord=i;
			}
		}
		return minRecord;
	}
}
