package os.jlxy.tr.rewrite.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

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
	@SuppressWarnings("unused")
	private static int countFile=0;

	private JTextArea tf = new JTextArea();
	@SuppressWarnings("unused")
	private InitFrame frm = new InitFrame(tb, crtBtn, delBtn, waiting, ready, destroyAll, tf);

	private ProcessManger manger = new ProcessManger();
	private Clock clock = new Clock(manger,tf);

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
		
		clock.start(tb);

	}

	// private void addMyListener() {
	// crtBtn.addActionListener(new ActionListener() {
	// public void actionPerformed(ActionEvent e) {
	// try{
	// String[] temp = new MultipleInput().init();
	// tb.insert("0", temp[0], "stop", temp[1], temp[2]);
	// temp=null;//**********************************************输入bug
	// }catch(Exception e1){
	// JOptionPane.showMessageDialog(null, "请输入");
	// }
	// }
	// });
	//
	// delBtn.addActionListener(new ActionListener() {
	// public void actionPerformed(ActionEvent e) {
	// tb.delete();
	// }
	// });
	// }

	// private void createProcess() {
	// // Clock.create.........
	// // 这个函数 需要返回一个PID
	// }

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
	}
	
	
}
