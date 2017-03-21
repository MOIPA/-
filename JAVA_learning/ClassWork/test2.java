import java.util.*;
public class test2 {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int num,a,b,c,d;
		do{
			System.out.println("输入一个四位数");
			num = reader.nextInt();
		}while(num<=1000||num>=9999);
		
		a = num/1000;
		b = (num-a*1000)/100;
		c = (num-a*1000-b*100)/10;
		d = num%10;
		System.out.println(a+b+c+d);
	}
}
