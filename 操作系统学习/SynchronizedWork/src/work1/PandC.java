package work1;

import java.util.LinkedList;

public class PandC {
	public static void main(String[] args) {
		int max = 4;
		Buffer buf = new Buffer();
		Producere pro = new Producere(buf, max);
		Consumer con = new Consumer(buf, max);
		pro.start();
		con.start();
	}
}

// buffer »º³åÇø¶¨Òå
class Buffer {
	private LinkedList list = new LinkedList();

	public void add(Object item) {
		list.add(item);
	}

	public Object get() {
		return list.removeFirst();
	}

	public int getCount() {
		return list.size();
	}
}

class Producere extends Thread {
	private Buffer buf;
//	private Semaphore semp;
	private int max;

	public Producere(Buffer buf, int max) {
		this.buf = buf;
		this.max = max;
	}

	@Override
	public void run(){
		synchronized(buf){
			while(true){
				try {
					if(buf.getCount()==max){
						buf.wait();
					}else{
						buf.add("goods");
						System.out.println("have added a goods");
						sleep(1000);
						if(buf.getCount()==1)
							buf.notifyAll();
							//wake up consumer
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
class Consumer extends Thread{
	private Buffer buf;
	private int max;
	
	public Consumer(Buffer buf, int max){
		this.buf=buf;
		this.max=max;
	}
	@Override
	public void run(){
		synchronized (buf) {
			while(true){
				if(buf.getCount()==0)
					try {
						buf.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				else{
					System.out.println("get a goods "+buf.get());
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(buf.getCount()==max-1)buf.notifyAll();
				}
			}
		}
	}
}
