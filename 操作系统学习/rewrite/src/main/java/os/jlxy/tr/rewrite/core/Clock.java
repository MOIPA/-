package os.jlxy.tr.rewrite.core;

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

import javax.swing.JTextArea;

import os.jlxy.tr.rewrite.view.Table;

//每五秒调用一次调度程序并且读取一次日志文件输出
public class Clock {

	private Timer timer = new Timer(true);
	private Logger log = Logger.getLogger("Clock");
	private ProcessManger manger;
	private JTextArea tf;

	public Clock(ProcessManger manger, JTextArea tf) {
		this.manger = manger;
		this.tf = tf;
	}

	public void start(Table tb) {
		final Scheduler sche = new Scheduler(manger, tb);
		// Scheduler sche = new Scheduler();
		try {
			readLog();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		TimerTask timerTask = new TimerTask() {
			public void run() {
				String proInfo = "";
//				  ConsoleHandler consoleHandler = new ConsoleHandler();
//				  consoleHandler.setLevel(Level.ALL);
//				  log.addHandler(consoleHandler);
//				  FileHandler fileHandler = null;
//				  try {
//				  fileHandler = new FileHandler("D:/LogFiles/Clock.log");
//				  } catch (Exception e) {
//				  e.printStackTrace();
//				  }
//				  fileHandler.setLevel(Level.INFO);
//				  fileHandler.setFormatter(new MyLogHander());
//				  log.addHandler(fileHandler);
				
//				  System.out.println(manger.getAllRunningProcess().length);
				try {
//					System.setOut(new PrintStream("D:/tmp.txt"));
					System.out.println("调度程序运行 ...");
					log.info("调度程序运行 ...");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
//				log.info("调度程序运行 ...");

				for (int i = 0; i < manger.getAllRunningProcess().length; i++) {
					Pcb[] pcb = manger.getAllRunningProcess();
					proInfo = pcb[i].getName() + " pdi:" + pcb[i].getPid() + " Proiority:" + pcb[i].getPriority()
							+ " time:" + pcb[i].getRemainTime() + "ms status:" + pcb[i].getStatus();
					System.out.println(proInfo);
				}
				try {
					readLog();
				} catch (IOException e) {
					System.out.println("读取文件错误");
					e.printStackTrace();
				}

//				sche.executeFCFS();
//*****************************************************************************************
//				sche.executeRound();
//				sche.executePriority();
//				sche.executeFSFC();
				//读取一次配置文件
				try {
					String config[] = readConfig();
					if(config[0].equals("priority"))sche.executePriority();
					if(config[0].equals("FCFS"))sche.executeFSFC();
				} catch (IOException e) {
					e.printStackTrace();
				}
//*****************************************************************************************
			}
		};

		timer.schedule(timerTask, 5000, 5000);
		System.out.println("时钟中断启动完成");
		log.info("时钟中断启动完成");
	}

	private void readLog() throws IOException {
		// 读取文件
		File file = new File("D:/tmp.txt");
		try {
			InputStreamReader read = new InputStreamReader(new FileInputStream(file));
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt =null;
			tf.setText("");
			while ((lineTxt = bufferedReader.readLine()) != null) {
//				tf.setText(tf.getText()+readLastLine(file) + "\n");
				tf.setText(tf.getText()+lineTxt + "\n");
			}
			tf.setCaretPosition(tf.getText().length());
//			tf.setText(tf.getText() + lineTxt);
			read.close();
			
			// 将文件重置
//			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			// output.write("adgqweqwegqwe*****88\n");
//			output.close();
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
			config[0] =null;
			config[0] = bufferedReader.readLine();
			
			read.close();
		} catch (FileNotFoundException e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return config;

	}
	
	//读取最后一行
	public String readLastLine(File file) throws IOException {  
		String charset="UTF-8";
        if (!file.exists() || file.isDirectory() || !file.canRead()) {  
          return null;  
        }  
        RandomAccessFile raf = null;  
        try {  
          raf = new RandomAccessFile(file, "r");  
          long len = raf.length();  
          if (len == 0L) {  
            return "";  
          } else {  
            long pos = len - 1;  
            while (pos > 0) {  
              pos--;  
              raf.seek(pos);  
              if (raf.readByte() == '\n') {  
                break;  
              }  
            }  
            if (pos == 0) {  
              raf.seek(0);  
            }  
            byte[] bytes = new byte[(int) (len - pos)];  
            raf.read(bytes);  
            if (charset == null) {  
              return new String(bytes);  
            } else {  
              return new String(bytes, charset);  
            }  
          }  
        } catch (FileNotFoundException e) {  
        } finally {  
          if (raf != null) {  
            try {  
              raf.close();  
            } catch (Exception e2) {  
            }  
          }  
        }  
        return null;  
      }  

}


