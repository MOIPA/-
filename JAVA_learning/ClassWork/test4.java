class Number{
	private int n1,n2;
	public Number(){
		n1=n2=0;
	}
	public Number(int a,int b){
		n1 = a;
		n2 = b;
	}
	public void addition(){
		System.out.println(n1+n2);
	}
	public void subtration(){
		System.out.println(n1-n2);
	}
	public void multiplication(){
		System.out.println(n1*n2);
	}
	public void division(){
		System.out.println(n1/n2);
	}
}
public class test4 {
	public static void main(String[] args) {
		Number num = new Number(7,3);
		num.addition();
		num.subtration();
		num.multiplication();
		num.division();
	}
}
