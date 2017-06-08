package os.jlxy.tr.rewrite.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.*;
import javax.swing.plaf.synth.SynthLookAndFeel;

import org.omg.CORBA.CTX_RESTRICT_SCOPE;

public class InitFrame {
	private JFrame frm = new JFrame("tr and tzq的操作系统");
	private JScrollPane js;
	private ImageIcon icon1 = new ImageIcon("D:/OS_pic/btn4.png");
	private ImageIcon icon2 = new ImageIcon("D:/OS_pic/btn3.png");
	private ImageIcon background = new ImageIcon("D:/OS_pic/BackGround2.jpg");
	private JPanel Pbtn = new JPanel();
//	private Table tb;

//	private JButton crtBtn = new JButton("add");
//	private JButton delBtn = new JButton("del");

	public InitFrame(Table tb,JButton crtBtn,JButton delBtn,JButton waiting,JButton ready,JButton destroyAll,JTextArea tf,JButton fcfs,JButton pri) {
		// 参数用来设定table
		// 本身参数已定
//		tb = new Table(x, y, width, height);
		//给JFRAME设置的背景
		Image backimg = background.getImage().getScaledInstance(700, 600, Image.SCALE_FAST);
		JLabel jlabel = new JLabel(new ImageIcon(backimg));
		jlabel.setBounds(0, 0, 700, 600);
		frm.getLayeredPane().add(jlabel, new Integer(Integer.MIN_VALUE));
		
		JPanel jp = (JPanel) frm.getContentPane();
	    JRootPane jp1 = (JRootPane) frm.getRootPane();
	    jp.setOpaque(false);
	    jp1.setOpaque(false);
	    //设置背景风格
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			} catch (Exception e) {
			e.printStackTrace();
			}
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setBounds(500, 200, 700, 600);
		frm.setResizable(false);
		frm.setLayout(null);
		
		//改变按钮面板样式
		Pbtn.setBorder(BorderFactory.createTitledBorder(""));
		Pbtn.setLayout(null);
		Pbtn.setBounds(430, 10, 200, 300);
//		Pbtn.setBackground(Color.white);
//		Pbtn.setBackground(Color.);
		Pbtn.setLayout(new GridLayout(4, 2,20,10));
		Pbtn.setBackground(Color.blue);
		Pbtn.setOpaque(false);
		
		crtBtn.setSize(80, 40);
		delBtn.setSize(80, 40);
		waiting.setSize(100, 40);
		ready.setSize(100, 40);
		destroyAll.setSize(100, 40);
		fcfs.setSize(100, 40);
		pri.setSize(100,40);
		
		//改进按钮样式
		ImproveMyBtn(crtBtn);
		ImproveMyBtn(delBtn);
		ImproveMyBtn(waiting);
		ImproveMyBtn(ready);
		ImproveMyBtn(destroyAll);
		ImproveMyBtn(fcfs);
		ImproveMyBtn(pri);
		
		
//		crtBtn.setBounds(430, 20, 80, 40);
//		delBtn.setBounds(430, 60, 80, 40);
//		waiting.setBounds(530, 20, 100, 40);
//		ready.setBounds(530, 60, 100, 40);
//		destroyAll.setBounds(530, 100, 100, 40);
		
		//设置输出文本区域半透明
		tf.setOpaque(false);
		tf.setBounds(10, 320, 400, 250);
		tf.setForeground(Color.black);
		js=new JScrollPane(tf);
		js.setBounds(10, 320, 400, 230);
		js.setOpaque(false);
		js.getViewport().setOpaque(false);
		
		frm.add(tb.getJScroll());
//		frm.add(crtBtn);
//		frm.add(delBtn);
//		frm.add(waiting);
//		frm.add(ready);
//		frm.add(destroyAll);
//		frm.add(js);
		

		Pbtn.add(crtBtn);
		Pbtn.add(delBtn);
		Pbtn.add(waiting);
		Pbtn.add(ready);
		
		Pbtn.add(fcfs);
		Pbtn.add(pri);
		Pbtn.add(destroyAll);
		frm.add(js);
		frm.add(Pbtn);

		new Menu(frm);

		frm.setVisible(true);
	}
	
	private void ImproveMyBtn(final JButton btn){
		btn.setIcon(icon1);
//		btn.setText("创建");
		btn.setHorizontalTextPosition(SwingConstants.CENTER);
		btn.setOpaque(false);//不透明
		btn.setContentAreaFilled(false);//图片按钮填满
		btn.setMargin(new Insets(0,0,0,0));//按钮和文字距离
		btn.setFocusPainted(false);//是否获得焦点
		btn.setBorderPainted(false);//是否绘制边框
		btn.setBorder(BorderFactory.createRaisedBevelBorder());//设置边框
		btn.setFont(new  java.awt.Font("宋体",Font.BOLD,12));
		btn.setForeground(new Color(240, 255, 255));
		btn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btn.setIcon(icon2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn.setIcon(icon1);
			}
			
		});
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
