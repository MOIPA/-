package os.jlxy.tr.rewrite.core;

public class Pcb {
	private int pid;
	private String name;
	private String status;
	private int priority;
	private int remainTime;
	
	public Pcb(int Pid){
		this.pid=Pid;
	}
	
	public int getPid() {
		return pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getRemainTime() {
		return remainTime;
	}
	public void setRemainTime(int remainTime) {
		this.remainTime = remainTime;
	}
	
	void decreaseTime(int time){
		this.remainTime-=time;
		if(this.remainTime<=0){
			this.remainTime=0;
		}
	}
	
	public void setRunning(){
		this.status="running";
	}
	
	public void setReady(){
		this.status="ready";
	}
	
	public void setWaiting(){
		this.status="waiting";
	}
}
