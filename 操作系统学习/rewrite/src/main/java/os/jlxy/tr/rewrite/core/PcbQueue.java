package os.jlxy.tr.rewrite.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

/**
 * 各个状态进程的队列
 *
 * 
 */

public class PcbQueue {

	private static Logger log = Logger.getLogger("PcbQueue");

	final Map<Integer, Pcb> running; // 运行队列
	final Map<Integer, Pcb> ready; // 就绪队列
	final Map<Integer, Pcb> waiting; // 等待队列

	public PcbQueue() {
		this.running = new HashMap();
		this.ready = new HashMap();
		this.waiting = new HashMap();
	}

	// 加入一个进程到运行队列
	void add2Running(Pcb process) {
		if (process == null) {
			return;
		}

		if (!this.running.containsKey(process.getPid())) {
			this.running.put(process.getPid(), process);
		}
	}

	// 从运行队列中取出一个Process
	Pcb removeFromRunning(int pid) {
		return this.running.remove(pid);
	}

	// 加入一个Process到就绪队列
	void add2Ready(Pcb process) {
		if (process == null) {
			return;
		}
		this.ready.put(process.getPid(), process);
	}

	// 从就绪队列中取出一个
	Pcb removeFromReady(int pid) {
		return this.ready.remove(pid);
	}

	// 加入到等待队列
	void add2Waiting(Pcb process) {
		if (process == null) {
			return;
		}
		this.waiting.put(process.getPid(), process);
	}

	// 从等待队列中取出一个
	Pcb removeFromWaiting(int pid) {
		return this.waiting.remove(pid);
	}

	// 通过pid获得这个进程
	public Pcb getPcb(int pid) {
		Pcb ret = null;
		ret = this.running.get(pid);
		if (ret != null) {
			return ret;
		}

		ret = this.ready.get(pid);
		if (ret != null) {
			return ret;
		}

		return this.waiting.get(pid);
	}

	// 通过pid和状态获得这个进程
	Pcb getPcb(int pid, String status) {
		if (status.equals("running"))
			return this.running.get(pid);
		else if (status.equals("ready"))
			return this.ready.get(pid);
		else if (status.equals("waiting"))
			return this.waiting.get(pid);
		else
			return null;
	}

	Pcb removePcb(int pid) {
		Pcb pcb = null;
		if (running.containsKey(pid)) {
			pcb = running.remove(pid);
		} else if (ready.containsKey(pid)) {
			pcb = ready.remove(pid);
		} else if (waiting.containsKey(pid)) {
			pcb = waiting.remove(pid);
		}
		return pcb;
	}
	
	public Pcb[] getAllRunningPcb(){

		Pcb[] pcb;
		int i=0,sum=0;
		Iterator it = running.keySet().iterator();  
		
		while(it.hasNext()){
			it.next();
			sum++;
		}

		//重置
		it = running.keySet().iterator();
		

		pcb=new Pcb[sum];
        while(it.hasNext()) {  
//        	System.out.println("*********");
            Integer key = (Integer)it.next();
//            System.out.println("key:" + key);  
//            System.out.println("value:" + running.get(key).getName());  
//            Integer key = (Integer)it.next();
            pcb[i++]=running.get(key);
        }
        return pcb;
	}
	public Pcb[] getAllReadyPcb(){
		Pcb[] pcb;
		int i=0,sum=0;
		Iterator it = ready.keySet().iterator();  
		while(it.hasNext()){
			it.next();
			sum++;
		}
		it = ready.keySet().iterator(); 
		pcb=new Pcb[sum];
        while(it.hasNext()) {  
//            String key = (String)it.next();
//            System.out.println("key:" + key);  
//            System.out.println("value:" + hashMap.get(key));  
            Integer key = (Integer)it.next();
            pcb[i++]=ready.get(key);
        }
        return pcb;
	}
	public Pcb[] getAllWaitingPcb(){
		Pcb[] pcb;
		int i=0,sum=0;
		Iterator it = waiting.keySet().iterator();  
		while(it.hasNext()){
			it.next();
			sum++;
		}
		
		it = waiting.keySet().iterator();  
		pcb=new Pcb[sum];
		
        while(it.hasNext()) {  
//        	System.out.println(sum+"*88888888");
            Integer key = (Integer)it.next();
//            System.out.println("key:" + key);  
//            System.out.println("value:" + waiting.get(key));  
            
            pcb[i++]=waiting.get(key);
        }
        return pcb;
	}

}
