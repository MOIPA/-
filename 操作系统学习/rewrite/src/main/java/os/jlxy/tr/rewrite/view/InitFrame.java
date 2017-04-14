package os.jlxy.tr.rewrite.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.omg.CORBA.CTX_RESTRICT_SCOPE;

public class InitFrame {
	private JFrame frm = new JFrame("tr and tzq的操作系统");
	private JScrollPane js;
//	private Table tb;

//	private JButton crtBtn = new JButton("add");
//	private JButton delBtn = new JButton("del");

	public InitFrame(Table tb,JButton crtBtn,JButton delBtn,JButton waiting,JButton ready,JButton destroyAll,JTextArea tf) {
		// 参数用来设定table
		// 本身参数已定
//		tb = new Table(x, y, width, height);

		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setBounds(500, 200, 700, 600);
		frm.setResizable(false);
		frm.setLayout(null);
		
		crtBtn.setBounds(430, 20, 80, 40);
		delBtn.setBounds(430, 60, 80, 40);
		waiting.setBounds(530, 20, 100, 40);
		ready.setBounds(530, 60, 100, 40);
		destroyAll.setBounds(530, 100, 100, 40);
		//tf.setBounds(10, 320, 400, 250);
		js=new JScrollPane(tf);
		js.setBounds(10, 320, 400, 230);
		
		frm.add(tb.getJScroll());
		frm.add(crtBtn);
		frm.add(delBtn);
		frm.add(waiting);
		frm.add(ready);
		frm.add(destroyAll);
		frm.add(js);

		new Menu(frm);
//		addMyListener();
		

		frm.setVisible(true);
	}
	
//	private void addMyListener(){
//		crtBtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				tb.insert("1", "test", "stop", "0", "0");
//			}
//		});
//		
//		delBtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		});
//	}

//	// 增
//	public void insert(String pid, String name, String status, String remainTime, String priority) {
//		tb.insert(pid, name, status, remainTime, priority);
//		tb.repaint();
//		frm.repaint();
//	}
//
//	// 删
//	public void delete() {
//		tb.delete();
//	}
//
//	// 查
//	public void getStatusById(String Pid) {
//		tb.getStatusById(Pid);
//	}
//
//	// 改
//	public void updateByPid(String Pid, String status, String remainTime) {
//		tb.updateByPid(Pid, status, remainTime);
//	}
	
}
