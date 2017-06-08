package work1;

public class Szh {
	public static void main(String[] args) {
		sources com = new sources();
		ProducerS p = new ProducerS(com);
		ConsumerS c = new ConsumerS(com);
		p.start();
		c.start();
	}
}

class ConsumerS extends Thread {
	private sources com;

	public ConsumerS(sources thisc) {
		com = thisc;
	}

	public void run() {
		char c;
		for (int i = 0; i < 5; i++) {
			c = com.get();
			// System.out.println(c);
			System.out.println("C: " + c);
		}
	}
}

class sources {
	private char ch;
	private boolean available = false;

	synchronized char get() {
		System.out.println("**********GET_available:" + available);
		while (available == false)
			try {
				// System.out.println("*******wait*********");
				wait();
			} catch (InterruptedException e) {
			}
		// System.out.println("*******available time 1*********");
		available = false;
		// System.out.println("*******available time 2*********");
		notify();
		// System.out.println("*******available time 3*********");
		return ch;
	}

	synchronized void put(char newch) {
		System.out.println("**********PUT_available:" + available);
		while (available == true)
			try {
				wait();
			} catch (InterruptedException e) {
			}

		ch = newch;
		available = true;
		notify();
	}
}

class ProducerS extends Thread {
	private sources com;

	public ProducerS(sources thisc) {
		com = thisc;
	}

	public void run() {
		char c;
		for (c = 'a'; c <= 'e'; c++) {
			System.out.println("P: " + c);
			com.put(c);
			
		}
	}
}
