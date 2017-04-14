package os.jlxy.tr.rewrite.core;

public class Round {
	public int getNextPid(Pcb pcbRunning,Pcb[] ready){
		
		if(ready[ready.length-1].getPid()==pcbRunning.getPid()){
			return ready[0].getPid();
		}else return pcbRunning.getPid()+1;
		
	}
}
