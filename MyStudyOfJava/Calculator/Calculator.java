package testFrame;

import java.awt.event.*;
import java.util.Stack;

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame implements ActionListener{
	static Calculator frm = new Calculator();
	static JPanel north = new JPanel();
	static JPanel center = new JPanel(new GridLayout(1,2));
	static JPanel south = new JPanel();
	static JTextField tx = new JTextField(40);
	static JButton back = new JButton("Back");
	static JButton C = new JButton("C");
	static JButton chu,cheng,jian,jia,dengyu,jiachujian,dian,yichux,baifen,sqrt;
	static int a=0,b=0;
	static char cha;
	
	public static void main(String[] args) {
		Stack z =new Stack();
		//menu
		JMenuBar bar = new JMenuBar();
		JMenu filemenu = new JMenu("文件");
		JMenu help = new JMenu("帮助");

		JMenuItem file = new JMenuItem("文件 |>");
		JMenuItem exit = new JMenuItem("退出");
		JMenuItem about = new JMenuItem("关于");
		bar.add(filemenu);
		bar.add(help);
		filemenu.add(file);
		filemenu.add(exit);
		help.add(about);

		//
		frm.setJMenuBar(bar);
		frm.setLayout(null);
		frm.setSize(800,600);
		frm.setResizable(false);
		frm.setLocation(600, 200);
		//
		JButton[] x = new JButton[10];
		for(int i=0;i<10;i++)
			x[i] = new JButton(""+i);
		
		chu = new JButton("/");
		cheng = new JButton("*");
		jia = new JButton("+");
		jian = new JButton("-");
		dengyu = new JButton("=");
		jiachujian = new JButton("+/-");
		dian = new JButton(".");
		yichux = new JButton("1/x");
		baifen = new JButton("%");
		sqrt = new JButton("sqrt");
		
		
		south.setLayout(new GridLayout(5,4));
		south.add(x[7]);south.add(x[8]);south.add(x[9]);south.add(chu);
		south.add(x[4]);south.add(x[5]);south.add(x[6]);south.add(cheng);
		south.add(x[1]);south.add(x[2]);south.add(x[3]);south.add(jian);
		south.add(x[0]);south.add(jiachujian);south.add(dian);south.add(jia);
		south.add(yichux);south.add(baifen);south.add(sqrt);south.add(dengyu);		
		north.add(tx);
		center.add(back);
		center.add(C);

		jia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//a = Integer.parseInt(tx.getText());
				//b = Integer.parseInt(tx.getText());
				z.push(Integer.parseInt(tx.getText()));
				cha = '+';
				tx.setText(null);
			}
		});
		
		jian.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//a = Integer.parseInt(tx.getText());
				//b = Integer.parseInt(tx.getText());
				z.push(Integer.parseInt(tx.getText()));
				cha = '-';
				tx.setText(null);
			}
		});
		
		cheng.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				z.push(Integer.parseInt(tx.getText()));
				cha = '*';
				tx.setText(null);
			}
		});
		
		chu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				z.push(Integer.parseInt(tx.getText()));
				cha = '/';
				tx.setText(null);
			}
		});
		
		
		dengyu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				b=Integer.parseInt(tx.getText());
				a=(int)z.pop();
				
				//不同符号的定义**************************
				if(cha == '+'){
				int ret=a+b;
				tx.setText(new String(""+ret));
				}
				else if(cha=='-'){
					int ret = a-b;
					tx.setText(new String(""+ret));
				}
				else if(cha=='*'){
					float ret = a*b;
					tx.setText(new String(""+ret));
				}
				else if(cha=='/'){
					float ret = (float)a/(float)b;
					tx.setText(new String(""+ret));
				}
			}
		});
		C.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				a=0;b=0;
				tx.setText(null);
			}
		});
		
		//123456789定义操作*********************************
		x[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tx.setText(tx.getText()+"0");
			}
		});		
		x[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tx.setText(tx.getText()+"1");
			}
		});
		x[2].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tx.setText(tx.getText()+"2");
			}
		});
		x[3].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tx.setText(tx.getText()+"3");
			}
		});
		x[4].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tx.setText(tx.getText()+"4");
			}
		});
		x[5].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tx.setText(tx.getText()+"5");
			}
		});
		x[6].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tx.setText(tx.getText()+"6");
			}
		});
		x[7].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tx.setText(tx.getText()+"7");
			}
		});
		x[8].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tx.setText(tx.getText()+"8");
			}
		});
		x[9].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tx.setText(tx.getText()+"9");
			}
		});
		//***********************************************
		
		north.setBounds(10,10,700,50);
		center.setBounds(0,60,800,70);
		south.setBounds(0, 130, 800, 410);
		
		frm.add(north);
		frm.add(center);
		frm.add(south);
		
		frm.setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		
		
		
	}
	
}
