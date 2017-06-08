package os.jlxy.tr.rewrite.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import os.jlxy.tr.rewrite.view.Table;

//每五秒调用一次调度程序并且读取一次日志文件输出
public class Clock {

	private Timer timer = new Timer(true);
	private Logger log = Logger.getLogger("Clock");
	private ProcessManger manger;
	private JTextArea tf;
	private JButton fcfs;
	private JButton pri;
	private String cores;
	private String algo;

	public Clock(ProcessManger manger, JTextArea tf) {
		this.manger = manger;
		this.tf = tf;
	}

	public void start(Table tb, String config[], JButton fcfs_, JButton pri_) {
		// 传递配置文件
		cores = config[1];
		algo = config[0];
		// 传递按钮用于修改内存里的配置信息
		this.fcfs = fcfs_;
		this.pri = pri_;

		final Scheduler sche = new Scheduler(manger, tb);
		// Scheduler sche = new Scheduler();
		try {
			readLog();
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		// 在TimerTask里面每次读取 刚刚的配置信息调用相关的算法
		TimerTask timerTask = new TimerTask() {
			public void run() {
				String proInfo = "";
				//
				try {
					// System.setOut(new PrintStream("D:/tmp.txt"));
					System.out.println("    调度程序运行 ...");
					log.info("调度程序运行 ...");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				// log.info("调度程序运行 ...");

				for (int i = 0; i < manger.getAllRunningProcess().length; i++) {
					Pcb[] pcb = manger.getAllRunningProcess();
					proInfo = pcb[i].getName() + " pdi:" + pcb[i].getPid() + " Proiority:" + pcb[i].getPriority()
							+ " time:" + pcb[i].getRemainTime() + "ms status:" + pcb[i].getStatus();
					System.out.println("    " + proInfo);
				}
				try {
					readLog();
				} catch (IOException e) {
					System.out.println("读取文件错误");
					e.printStackTrace();
				}

				// sche.executeFCFS();
				// *****************************************************************************************
				// sche.executeRound();
				// sche.executePriority();
				// sche.executeFSFC();
				// 读取一次配置文件
				// try {
				// String config[] = readConfig();
				// int cores = readCores();
				//// System.out.println(cores);
				// if(config[0].equals("Priority"))sche.executePriority(cores);
				// if(config[0].equals("FCFS"))sche.executeFSFC(cores);
				// } catch (IOException e) {
				// e.printStackTrace();
				// }

				// 读取配置文件2.0
				// System.out.println(algo+"*******");
				// System.out.println(cores+"*******");
				if (algo.equals("Priority"))
					sche.executePriority(Integer.parseInt(cores));
				else
					sche.executeFSFC(Integer.parseInt(cores));
				// *****************************************************************************************
			}
		};

		timer.schedule(timerTask, 5000, 5000);
		System.out.println("    时钟中断启动完成");
		log.info("时钟中断启动完成");

		//给按钮添加监听
		fcfs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				algo = "FCFS";
				JOptionPane.showMessageDialog(null, "切换到先到先得算法");
			}
		});
		pri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				algo="Priority";
				JOptionPane.showMessageDialog(null, "切换到优先级算法");
			}
		});

	}

	private void readLog() throws IOException {
		// 读取文件
		File file = new File("D:/tmp.txt");
		try {
			InputStreamReader read = new InputStreamReader(new FileInputStream(file));
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = null;
			tf.setText("");
			while ((lineTxt = bufferedReader.readLine()) != null) {
				// tf.setText(tf.getText()+readLastLine(file) + "\n");
				tf.setText(tf.getText() + lineTxt + "\n");
			}
			tf.setCaretPosition(tf.getText().length());
			// tf.setText(tf.getText() + lineTxt);
			read.close();

			// 将文件重置
			// BufferedWriter output = new BufferedWriter(new FileWriter(file));
			// output.write("adgqweqwegqwe*****88\n");
			// output.close();
			// tf.setText(tf.getText() + Proinfo + "\n");

		} catch (FileNotFoundException e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}

	}

	private String[] readConfig() throws IOException {
		// 读取文件
		String[] config = new String[3];
		File file = new File("D:/OsConfig/Config.txt");
		try {
			InputStreamReader read = new InputStreamReader(new FileInputStream(file));
			BufferedReader bufferedReader = new BufferedReader(read);
			config[0] = null;
			config[0] = bufferedReader.readLine();

			read.close();
		} catch (FileNotFoundException e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return config;

	}

	private Integer readCores() {
		Integer cores = 0;
		File file = new File("D:/OsConfig/Config.txt");
		try {
			InputStreamReader read = new InputStreamReader(new FileInputStream(file));
			BufferedReader bufferedReader = new BufferedReader(read);
			bufferedReader.readLine();
			cores = Integer.parseInt(bufferedReader.readLine());

			read.close();
			bufferedReader.close();
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return cores;
	}

}
