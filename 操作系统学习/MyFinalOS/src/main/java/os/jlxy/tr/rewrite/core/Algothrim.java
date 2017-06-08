package os.jlxy.tr.rewrite.core;

//先来先服务
public class Algothrim {
//	private Pcb[] pcb;
//	private int length;

	
	public int getOneRunningProcess(Pcb[] pcbRunning){
		int [] camp = new int[pcbRunning.length];
		int minRecord = 0;
//		this.pcb = pcbRunning;
		if(pcbRunning.length>=1){
			
			//将优先级放在一个数组里待会比较
			for(int i=0;i<pcbRunning.length;i++)
				camp[i]=pcbRunning[i].getPriority();
			
			minRecord = campareArray(camp);
			
			return pcbRunning[minRecord].getPid();
		}
		else return -1;
	}
	
	public int getOneReadyProgress(Pcb[] pcbReady){
//		System.out.println("PcbLength is : "+pcbReady.length);
		int [] camp = new int[pcbReady.length];
		int minRecord = 0;
		if(pcbReady.length>=1){
			//将优先级放在一个数组里待会比较
			for(int i=0;i<pcbReady.length;i++)
				camp[i]=pcbReady[i].getPriority();
			
			minRecord = campareArray(camp);
			
			return pcbReady[minRecord].getPid();
		}
			
		else return -1;
	}
	
	public int getOneReadyProgressRandom(Pcb[] pcbReady){
//		System.out.println("PcbLength is : "+pcbReady.length);
		if(pcbReady.length>=1){
			return pcbReady[pcbReady.length-1].getPid();
		}else return -1;
		
	}
	
	public int getOneReadyProcessFCFS(Pcb[] pcbReady){
		return pcbReady[0].getPid();
	}
	
	//比较所有数 返回最小数的下标
	private int campareArray(int[] array){
		int minRecord = 0;
		int minNumber = 100;
		for(int i=0;i<array.length;i++){
			if(minNumber>array[i]){
				minNumber = array[i];
				minRecord=i;
			}
		}
		return minRecord;
	}
	
}
