
public class Sale {
	public static void main(String[] args) {
		SaleTickets t= new SaleTickets();
		Thread a1 = new Thread(t);
		Thread a2 = new Thread(t);
		Thread a3 = new Thread(t);
		Thread a4 = new Thread(t);
		a1.start();
		a2.start();
		a3.start();
		a4.start();
	}
}

class SaleTickets implements Runnable{
	private int tickets = 1;
	public void run(){
		while(true){
			if(tickets<=100)
				System.out.println(Thread.currentThread().getName()+"ÏúÊÛµÚ"+tickets+++"Æ±");
			else break;
		}
	}
}
