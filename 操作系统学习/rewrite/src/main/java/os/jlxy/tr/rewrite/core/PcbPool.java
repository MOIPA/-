package os.jlxy.tr.rewrite.core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


//import os.jlxy.tr.rewrite.test.MyLogHander;

public class PcbPool {
	
	private Logger log = Logger.getLogger("PcbPool");
	
	static final int CAPACITY = 100;
	Queue<Pcb> queue= new LinkedList<Pcb>();  //队列
	
	public PcbPool(){
//		this.queue = new LinkedList<Pcb>();
//		System.out.println("**************");
		init();
		ConsoleHandler consoleHandler = new ConsoleHandler(); 
		  
		   log.addHandler(consoleHandler); 
		   FileHandler fileHandler = null;
			try {
				fileHandler = new FileHandler("D:/LogFiles/PcbPool.log");
			} catch (Exception e) {
				e.printStackTrace();
			} 
		   fileHandler.setLevel(Level.INFO); 
		   fileHandler.setFormatter(new MyLogHander()); 
		   log.addHandler(fileHandler); 
		   try {
//			System.setOut(new PrintStream("D:/tmp.txt"));
			System.out.println("PCB池初始化完成");
			log.info("PCB池初始化完成");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void init(){
		this.queue.clear();
		for(int i=0;i<CAPACITY;i++){
			this.queue.offer(new Pcb(i+1));
		}
	}
	
	//synchronized 线程锁  用于防止多个进程同时访问
	public Pcb getOnePcb(){
		Pcb temp = this.queue.poll();
		if(temp==null){
			throw new IllegalStateException("已达到最大进程数目限制");
		}
		return temp;
	}
	public void giveBack(Pcb pcb){
		if(this.queue.size()==CAPACITY)return;
		pcb.setRemainTime(0);
		pcb.setPriority(0);
		this.queue.offer(pcb);
	}
}
