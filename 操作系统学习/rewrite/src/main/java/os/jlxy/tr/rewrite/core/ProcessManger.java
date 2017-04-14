package os.jlxy.tr.rewrite.core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProcessManger {
	private static Logger log = Logger.getLogger("PcbManger");
	private static ProcessManger single = null;
	
	private PcbPool pool = new PcbPool();
	private PcbQueue queue = new PcbQueue();
	
	public ProcessManger getPcbManger(){
		if(single == null)throw new IllegalStateException("PcbManager注入失败");
		return single;
	}
	public void init(){
		single=this;
	}
	public ProcessManger(){
		
		try {
//			System.setOut(new PrintStream("D:/tmp.txt"));
			System.out.println("进程管理器启动完成");
			log.info("进程管理器启动完成");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		init();
//		System.out.println(queue);
	}
	
	// 创建进程，成功返回>0的进程号，错误返回负数
	public int createProcess(String name,int time,int priority){
//		synchronized(pool){
			//get a pcb from pool
			Pcb pcb = pool.getOnePcb();
			//设置属性
			pcb.setName(name);
			pcb.setRemainTime(time);
			pcb.setPriority(priority);
			//放入就绪队列
			pcb.setReady();
			queue.add2Ready(pcb);
			return pcb.getPid();
//		}
	}
	
	//默认时间进程
	public int createProcess(String name){
		return createProcess(name, 60000, 1);
	}
	
	//结束进程
	public void destroy(int pid){
		Pcb pcb =  queue.getPcb(pid);
		if(pcb==null)return;
		queue.removePcb(pid);
		pool.giveBack(pcb);
	}
	
	public void destroyAllProcess(){
		synchronized (queue) {
            Map<Integer, Pcb> map = new HashMap();
            map.putAll(queue.running);
            map.putAll(queue.ready);
            map.putAll(queue.waiting);
            Iterator<Pcb> ite = map.values().iterator();
            while (ite.hasNext()) {
                Pcb p = ite.next();
                queue.removePcb(p.getPid());
                // 归还到池中
                pool.giveBack(p);
            }
        }
	}

	// 阻塞进程，也可以由进程自己调用
    public void blocked(int pid) {
        synchronized (queue) {
            Pcb pcb = queue.getPcb(pid);
            if (pcb == null) {
                return;
            }

            pcb = queue.removePcb(pid);
            pcb.setWaiting();
            queue.add2Waiting(pcb);
        }
    }
    
 // 唤醒进程
    public void wakeup(int pid) {
        synchronized (queue) {
            Pcb pcb = queue.getPcb(pid, "waiting");
            if (pcb == null) {
                return;
            }
            pcb = queue.removeFromWaiting(pid);
            pcb.setReady();
            queue.add2Ready(pcb);
        }
    }
    
 // 设为就绪态
    public void ready(int pid) {
        synchronized (queue) {
            Pcb pcb = queue.getPcb(pid);
            if (pcb == null) {
                return;
            }

            pcb = queue.removePcb(pid);
            pcb.setReady();
            queue.add2Ready(pcb);
        }
    }
	
 // 设为运行态
    public void running(int pid) {
        synchronized (queue) {
            Pcb pcb = queue.getPcb(pid);
            if (pcb == null) {
                return;
            }

            pcb = queue.removePcb(pid);
            pcb.setRunning();
            queue.add2Running(pcb);
//            System.out.println(queue.getPcb(pid).getName());
//            System.out.println(queue.running.get(1).getName());
        }
    }
    
    public PcbQueue getPcbQueue(){
    	return this.queue;
    }
    
    public Pcb[] getAllRunningProcess(){
    	return queue.getAllRunningPcb();
    }
    public Pcb[] getAllReadyProgress(){
    	return queue.getAllReadyPcb();
    }
    public Pcb[] getAllWaitingProgress(){
    	return queue.getAllWaitingPcb();
    }
   
  
}
