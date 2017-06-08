package os.jlxy.tr.rewrite.core;

import java.awt.Color;
import java.awt.Component;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import os.jlxy.tr.rewrite.view.Table;

public class Scheduler {
	private Logger log = Logger.getLogger("Scheduler");
	private ProcessManger manger;
	private PcbQueue queue;

	private Pcb[] pcbRunning;
	private Pcb[] pcbReady;
	private static int count = 0;
	private Table tb;

	private Algothrim algo = new Algothrim();

	public Scheduler(ProcessManger manger, Table tb) {
		this.tb = tb;
		this.manger = manger;
		queue = manger.getPcbQueue();

		ConsoleHandler consoleHandler = new ConsoleHandler();

		log.addHandler(consoleHandler);
		FileHandler fileHandler = null;
		try {
			fileHandler = new FileHandler("D:/LogFiles/Scheduler.log");
		} catch (Exception e) {
			e.printStackTrace();
		}
		fileHandler.setLevel(Level.INFO);
		fileHandler.setFormatter(new MyLogHander());
		log.addHandler(fileHandler);
		try {
			// System.setOut(new PrintStream("D:/tmp.txt"));
			System.out.println("    进程调度器启动完成");
			log.info("进程调度器启动完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
		setTableLight();
	}

	public void executePriority(int cores) {
		setTableLight();
		// 扫描是否还有进程
		// System.out.println("***********executer");
		if (!isAliveProcess()) {

			System.out.println("    No processes!");
			return;
		}
		// System.out.println("**********");
		// 扫描出小于零的进程终结它
		destoryDeadPro();

		// 扫描是否还有进程
		if (!isAliveProcess()) {
			System.out.println("    No processes!");
			return;
		}

		// 如果没有进程运行了 切换一个新的就绪进程或者进程数少于内核数
		if (manger.getAllRunningProcess().length < cores)
			getOnePriorityPro();
//			getSeveralPrioritypro(cores);

		// 通过算法得到一个进程并且自动减少时间
		// 并且自动更新table
		AutoDecreseTime();
		
//		stopPro();
		 destoryDeadPro();
	}

	
	public void executeFSFC(int cores) {
		setTableLight();
		// 扫描是否还有进程
		// System.out.println("***********executer");
		if (!isAliveProcess()) {

			System.out.println("    No processes!");
			return;
		}
		// System.out.println("**********");
		// 扫描出小于零的进程终结它
		destoryDeadPro();
		setTableLight();

		// 扫描是否还有进程
		if (!isAliveProcess()) {
			System.out.println("    No processes!");
			return;
		}

		// 如果没有进程运行了 切换一个新的就绪进程并且进程数量少于参数值
		if (manger.getAllRunningProcess().length < cores){
			getSeveralFCFSpro(cores-manger.getAllRunningProcess().length);
		}
//		getOneFCFSPro();
		setTableLight();
		// 通过算法得到一个进程并且自动减少时间
		// 并且自动更新table
		AutoDecreseTime();
		
//		stopPro();
		 destoryDeadPro();
		 setTableLight();
	}
	
	//得到相应数量进程
	private boolean getSeveralFCFSpro(int quantities){
		for(int i=0;i<quantities;i++)
			 getOneFCFSPro();
		return false;
		
	}
	
	private boolean getSeveralPrioritypro(int quantities){
		for(int i=0;i<quantities;i++)
			 getOnePriorityPro();
		return false;
		
	}
	
//	public void executeRound() {
//
//		// System.out.println("**********");
//		// 扫描出小于零的进程终结它
//		destoryDeadPro();
//
//		// 扫描是否还有进程
//		if (!isAliveProcess()) {
//			System.out.println("No processes!");
//			return;
//		}
//
//		// 如果有进程运行 换出此进程 切换一个新的就绪进程
//		if (manger.getAllRunningProcess().length > 0) {
//			 getNextPro();
//			for (int i = 0; i < manger.getAllRunningProcess().length; i++) {
//				
//				manger.ready(manger.getAllRunningProcess()[i].getPid());
//				tb.updateByPid(manger.getAllRunningProcess()[i].getPid() + "",
//						"ready",
//						manger.getAllRunningProcess()[i].getRemainTime() / 1000 + "");
//			}
//			AutoDecreseTime();
//		}
//
//		// 如果没有进程运行了 切换一个新的就绪进程
//		if (manger.getAllRunningProcess().length <= 0)
//			getOnePriorityPro();
//
//		// 通过算法得到一个进程并且自动减少时间
//		// 并且自动更新table
//
////		 destoryDeadPro();
//		stopPro();
//	}

	private void destoryDeadPro() {
		pcbRunning = manger.getAllRunningProcess();
		for (int i = 0; i < pcbRunning.length; i++) {
			if (pcbRunning[i].getRemainTime() <= 0) {
				log.info("进程 pid = " + pcbRunning[i].getPid() + " 终止");
				manger.destroy(pcbRunning[i].getPid());
				tb.deletePid(pcbRunning[i].getPid() + "");
				System.out.println("    进程 pid = " + pcbRunning[i].getPid() + " 终止");

			}
		}
	}

	private void stopPro() {
		pcbRunning = manger.getAllRunningProcess();
		for (int i = 0; i < pcbRunning.length; i++) {
			if (pcbRunning[i].getRemainTime() <= 0) {
				log.info("换出进程 pid = " + pcbRunning[i].getPid());
				System.out.println("    换出进程 pid = " + pcbRunning[i].getPid());
				// manger.destroy(pcbRunning[i].getPid());
				tb.updateByPid(pcbRunning[i].getPid() + "", "stopped", pcbRunning[i].getRemainTime() / 1000 + "");
				pcbRunning[i].setStatus("stopped");
			}
		}
	}

	private boolean getOnePriorityPro() {
		pcbReady = manger.getAllReadyProgress();
		if (pcbReady.length <= 0)
			return false;
		// System.out.println("pid is :"+algo.getOneReadyProgress(pcbReady));
		int pid = algo.getOneReadyProgress(pcbReady);

		PcbQueue queue = manger.getPcbQueue();
		/// ************************************8

		if (pid != -1) {
			log.info("换进进程 pid = " + pid + ", name = " + queue.getPcb(pid).getName());
			System.out.println("    换进进程 pid = " + pid + ", name = " + queue.getPcb(pid).getName());
			manger.running(pid);
			tb.updateByPid(pid + "", "running", queue.getPcb(pid).getRemainTime() / 1000 + "");
			pcbRunning = manger.getAllRunningProcess();
		}
		if (pid == -1)
			return false;
		else
			return true;
	}
	
	private boolean getOneFCFSPro() {
		pcbReady = manger.getAllReadyProgress();
		if (pcbReady.length <= 0)
			return false;
		// System.out.println("pid is :"+algo.getOneReadyProgress(pcbReady));
		int pid = algo.getOneReadyProcessFCFS(pcbReady);

		PcbQueue queue = manger.getPcbQueue();
		/// ************************************8

		if (pid != -1) {
			log.info("换进进程 pid = " + pid + ", name = " + queue.getPcb(pid).getName());
			System.out.println("    换进进程 pid = " + pid + ", name = " + queue.getPcb(pid).getName());
			manger.running(pid);
			tb.updateByPid(pid + "", "running", queue.getPcb(pid).getRemainTime() / 1000 + "");
			pcbRunning = manger.getAllRunningProcess();
		}
		if (pid == -1)
			return false;
		else
			return true;
	}

	private void AutoDecreseTime() {
		pcbRunning = manger.getAllRunningProcess();
		// algo = new Algorithm();
		for(int i=0;i<pcbRunning.length;i++){
			pcbRunning[i].decreaseTime(5000);
			int pid = pcbRunning[i].getPid();
			tb.updateByPid(pid + "", queue.getPcb(pid).getStatus() + "", queue.getPcb(pid).getRemainTime() / 1000 + "");
		}
	}

	private boolean isAliveProcess() {
		// System.out.println("**********");
		pcbRunning = manger.getAllRunningProcess();
		pcbReady = manger.getAllReadyProgress();
		if (pcbRunning.length <= 0 && pcbReady.length <= 0)
			return false;
		else
			return true;
	}

//	private boolean getNextPro() {
//		Round round = new Round();
//		if (manger.getAllRunningProcess().length <= 0)
//			return false;
//		int pid = round.getNextPid(manger.getAllRunningProcess()[0], manger.getAllReadyProgress());
//
//		PcbQueue queue = manger.getPcbQueue();
//
//		if (pid != -1) {
//			log.info("换进进程 pid = " + pid + ", name = " + queue.getPcb(pid).getName());
//			System.out.println("    换进进程 pid = " + pid + ", name = " + queue.getPcb(pid).getName());
//			manger.running(pid);
//			tb.updateByPid(pid + "", "running", queue.getPcb(pid).getRemainTime() / 1000 + "");
//			pcbRunning = manger.getAllRunningProcess();
//		}
//		if (pid == -1)
//			return false;
//		else
//			return true;
//
//	}

	private void setTableLight(){
		DefaultTableCellRenderer backgroundColor = new DefaultTableCellRenderer(){
			public void setValue(Object value){
				String status = value.toString();
				if(status.equals("running")){
					setBackground(Color.green);
					setForeground(Color.blue);
					setText(value.toString());
				}else if(status.equals("ready")){
					setBackground(Color.white);
					setForeground(Color.black);
					setText(value.toString());
				}else if(status.equals("waiting")){
					setBackground(Color.white);
					setForeground(Color.black);
					setText(value.toString());
				}
			}
		};
		TableColumn status = tb.getTable().getColumn("status");
		status.setCellRenderer(backgroundColor);
		
	}
	
	// public static void main(String[] args) {
	// Pcb[] pcb;
	// manger.running(manger.createProcess("test1", 0, 1));
	// manger.running(manger.createProcess("test2", 20000, 1));
	// manger.running(manger.createProcess("test3", 30000, 1));
	//// manger.running(pid);
	// pcb = manger.getAllRunningProcess();
	//
	// for(int i=0;i<pcb.length;i++)
	// System.out.println(manger.getAllRunningProcess()[i].getStatus()+"
	// "+manger.getAllRunningProcess()[i].getRemainTime());
	//// System.out.println("*******");
	// Scheduler sche = new Scheduler();
	// pcb = manger.getAllRunningProcess();
	// for(int i=0;i<pcb.length;i++)
	// System.out.println(manger.getAllRunningProcess()[i].getName()+"
	// "+manger.getAllRunningProcess()[i].getRemainTime());
	//
	// }
}
