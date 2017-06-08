package os.jlxy.tr.rewrite.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Writer;
import java.util.Properties;

import javax.swing.*;

import os.jlxy.tr.rewrite.core.Clock;
import os.jlxy.tr.rewrite.core.ProcessManger;
import os.jlxy.tr.rewrite.view.InitFrame;
import os.jlxy.tr.rewrite.view.MultipleInput;
import os.jlxy.tr.rewrite.view.Table;

//combine table and frm inorder to operate table
public class ComTabFrm implements ActionListener {

	private Table tb = new Table(10, 10, 400, 300);
	private JButton crtBtn = new JButton("添加");
	private JButton delBtn = new JButton("结束");
	private JButton waiting = new JButton("设置为等待");
	private JButton ready = new JButton("设置为就绪");
	private JButton destroyAll = new JButton("结束所有");
	private JButton fcfs = new JButton("FCFS");
	private JButton pri = new JButton("PRIORITY");
	@SuppressWarnings("unused")
	private static int countFile = 0;

	private JTextArea tf = new JTextArea();
	@SuppressWarnings("unused")
	private InitFrame frm = new InitFrame(tb, crtBtn, delBtn, waiting, ready, destroyAll, tf, fcfs,pri);

	private ProcessManger manger = new ProcessManger();
	private Clock clock = new Clock(manger, tf);

	public ComTabFrm() {
		// manger.running(manger.createProcess("init", 5000, 1));
		// manger.createProcess("test",5000,1);
		// addMyListener();
		// crtBtn.setBounds(500, 100, 80, 40);
		// delBtn.setBounds(500, 150, 80, 40);
		// tf.setText("hello os!\r\nlalalla");
		// tb.insert("1", "test", "stop", "0", "0");
		// tb.insert("1", "test", "stop", "0", "0");

		crtBtn.addActionListener(this);
		delBtn.addActionListener(this);
		waiting.addActionListener(this);
		ready.addActionListener(this);
		destroyAll.addActionListener(this);
		fcfs.addActionListener(this);

		clock.start(tb,readConfig(),fcfs,pri);

	}


	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn.getText().equals("添加")) {
			try {
				String[] temp = new MultipleInput().init();
				while (Integer.parseInt(temp[1]) <= 0 || Integer.parseInt(temp[1]) > 5) {
					JOptionPane.showMessageDialog(null, "错误的优先级");
					temp = new MultipleInput().init();
				}
				int pid = manger.createProcess(temp[0], Integer.parseInt(temp[2]) * 1000 + 5000,
						Integer.parseInt(temp[1]));
				tb.insert(pid + "", temp[0], manger.getPcbQueue().getPcb(pid).getStatus(), temp[2], temp[1]);

				// temp=null;//**********************************************输入bug
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "请输入");
			}
		}

		if (btn.getText().equals("结束")) {
			try {
				String pid = (String) tb.getTable().getValueAt(tb.getTable().getSelectedRow(), 0);
				tb.delete();
				// System.out.println(pid);
				manger.destroy(Integer.parseInt(pid));
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "没有选择");
			}
		}

		if (btn.getText().equals("设置为等待")) {
			try {
				String pid = (String) tb.getTable().getValueAt(tb.getTable().getSelectedRow(), 0);
				tb.updateByPid(pid, "waiting",
						manger.getPcbManger().getPcbQueue().getPcb(Integer.parseInt(pid)).getRemainTime() / 1000 + "");
				manger.blocked(Integer.parseInt(pid));
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "没有选择");
			}
		}

		if (btn.getText().equals("设置为就绪")) {
			try {
				String pid = (String) tb.getTable().getValueAt(tb.getTable().getSelectedRow(), 0);
				tb.updateByPid(pid, "ready",
						manger.getPcbManger().getPcbQueue().getPcb(Integer.parseInt(pid)).getRemainTime() / 1000 + "");
				manger.ready(Integer.parseInt(pid));
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "没有选择");
			}
		}

		if (btn.getText().equals("结束所有")) {
			try {
				tb.deleteAll();
				manger.destroyAllProcess();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "error");
			}
		}

//		if (btn.getText().equals("FCFS")) {
//			try {
				//读取一次
//				String cores = null;
//				String algo = null;
//				// JOptionPane.showInputDialog(null,"请输入你的算法（FCFS,Priority）：\n","title",JOptionPane.PLAIN_MESSAGE,null,null,"在这输入");
//				File file = new File("D:/OsConfig/Config.txt");
//				InputStreamReader read = new InputStreamReader(new FileInputStream(file));
//				BufferedReader bufferedReader = new BufferedReader(read);
//				algo = bufferedReader.readLine();
//				cores = bufferedReader.readLine();
//				read.close();
//				//复写
//				FileWriter fos = new FileWriter("D:/OsConfig/Config.txt");
//				BufferedWriter bw = new BufferedWriter(fos);
//				if(algo.equals("FCFS")){
//					bw.write("Priority");
//					JOptionPane.showMessageDialog(null, "成功转换到优先级算法");
//				}else {
//					bw.write("FCFS");
//					JOptionPane.showMessageDialog(null, "成功转换到先来先服务算法");
//				}
//				bw.newLine();
//				bw.write(cores);
//				bw.newLine();
//				bw.flush();
//				bw.close();
//				JOptionPane.showMessageDialog(null, "succeed");

//			} catch (Exception e2) {
//
//			}
//		}
	}

	// 读取最后一行
	public String readLastLine(File file) throws IOException {
		String charset = "UTF-8";
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

	//读取配置 写入clock
	private String[] readConfig(){
	
		//相对路径访问
//		String path = "D:/OsConfig/config.properties";
//		Properties pro = new Properties();
//		try {
//			pro.load(ComTabFrm.class.getResourceAsStream(path));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		String[] con = new String[2];
//		con[0] = pro.getProperty("algorithm");
//		con[1] = pro.getProperty("cores");
		
		//绝对路径访问
		String[] con = new String[2];
		String path = "D:/OsConfig/config.properties";
		try{
			Properties pro = new Properties();
			File file = new File(path);
			FileInputStream fi = new FileInputStream(file);
			pro.load(fi);
			
			con[0] = pro.getProperty("algorithm");
			con[1] = pro.getProperty("cores");
		}catch(Exception e){
			System.out.println("read problem");
		}
		
		return con;
	}
	
	
}
