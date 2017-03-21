import java.util.*;
public class test1 {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int count=0;
		String forcount,temp;
		char c;
		System.out.println("ÊäÈë×Ö·û´®£º");
		forcount = reader.nextLine();
		System.out.println("ÊäÈë×Ö·û£º");
		temp = reader.nextLine();
		c = temp.charAt(0);
		
		for(int i=0;i<forcount.length();i++)
			if(forcount.charAt(i)==c) count++;
		
		System.out.println(count);
		
	}
}
