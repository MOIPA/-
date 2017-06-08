package work1;

import java.util.concurrent.Semaphore;

public class SemaVerion {
	public static void main(String[] args) {
		final int N = 5;
		Semaphore blank = new Semaphore(N);
		Semaphore item = new Semaphore(0);
		Semaphore mutex = new Semaphore(1);
		Producer p = new Producer(blank, item, mutex);
		Consumere c = new Consumere(blank, item, mutex);
		
		while(true){
			for(int i=0;i<N;i++)p.start();
			for(int i=0;i<N;i++)c.start();
			
		}
//		while(true){
////			if(count<N)p.start();
////			System.out.println("enter consumer");
//			c.start();
////			c.start();
//		
//		}
		
	}
}

class Producer{
	private Semaphore blank ;
	private Semaphore item ;
	private Semaphore mutex ;
	private int count;
	
	public Producer(Semaphore blank,Semaphore item,Semaphore mutex) {
		this.blank = blank;
		this.item = item;
		this.mutex = mutex;
	}
	
	public int start(){
//		while(true){
			try {
				blank.acquire();
				mutex.acquire();
				//生产
				
				System.out.println("added a goods");
				count++;
				item.release();
				mutex.release();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return count;
//		}
	}
}

class Consumere{
	private Semaphore blank ;
	private Semaphore item ;
	private Semaphore mutex ;
	private int count;
	
	public Consumere(Semaphore blank,Semaphore item,Semaphore mutex) {
		this.blank = blank;
		this.item = item;
		this.mutex = mutex;
	}
	
	public int start(){
//		while(true){
			try {
				item.acquire();
				mutex.acquire();
				//消费
				System.out.println("consumed a goods");
				count--;
				blank.release();
				mutex.release();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return count;
//		}
	}
}

class Buff{
	
}
