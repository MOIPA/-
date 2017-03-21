package test;

abstract class Shape{
	protected abstract double Area();
	public abstract void printArea();
}

class Circle extends Shape{
		final double pi = 3.14;
		private int radius;
		public Circle(int r){
			radius= r;
		}
		protected double Area() {
			return pi*radius*radius;
		}
	
		public void printArea() {
			System.out.println("Ãæ»ýÊÇ£º"+this.Area());	
		}
}

class test6 {
	public static void main(String[] args) {
		int n = (int)(Math.random()*10)%10;
		Circle c1 = new Circle(n);
		c1.printArea();
	}
}