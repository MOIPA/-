//for my dearest

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculator extends JFrame implements ActionListener{
	
	private char flag;
	
	private int record;
	
	private JTextField tx;
	
	private JPanel panela;
	
	private JPanel panelb;
	
	private JButton[] button = new JButton[10]; 
	
	private JButton[] buttonCal = new JButton[10];
	
	private JButton back ;
	
	private JButton C ;
	
	JFrame frm ;
	
	boolean clear(){
		if(tx.getText().equals(null)){
			return false;
		}
		else return true;
	}

	String operator;
	
	double previous;
	
	double next;
	
	public calculator(){
		//设置面板 按钮 框架 文本框参数
		tx= new JTextField(300);
		panela= new JPanel(new GridLayout(1,2));
		panelb= new JPanel(new GridLayout(5, 4));
		back = new JButton("Back");
		C = new JButton("C");
		frm = new JFrame();
		frm.setLayout(null);
		frm.setLocation(600, 600);
		frm.setSize(700, 600);
		tx.setHorizontalAlignment(JTextField.RIGHT);
		tx.setLocation(40, 30);
		tx.setSize(600, 50);
		
		panela.setLocation(0, 100);
		panela.setSize(700,80);
		
		panelb.setLocation(0, 180);
		panelb.setSize(700, 360);
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
		
				
		//0-9 和符号按钮
		for(int i=0;i<10;i++){
			button[i] = new JButton(""+i);
		}
		buttonCal[0] = new JButton("/");
		buttonCal[1] = new JButton("*");
		buttonCal[2] = new JButton("-");
		buttonCal[3] = new JButton("+");
		buttonCal[4] = new JButton("=");
		buttonCal[5] = new JButton(".");
		buttonCal[6] = new JButton("+/-");
		buttonCal[7] = new JButton("%");
		buttonCal[8] = new JButton("sqrt");
		buttonCal[9] = new JButton("1/x");
		//
		//添加 按钮 面板
		panela.add(back);
		panela.add(C);
		panelb.setLayout(new GridLayout(5,4));
		panelb.add(button[7]);panelb.add(button[8]);panelb.add(button[9]);panelb.add(buttonCal[0]);
		panelb.add(button[4]);panelb.add(button[5]);panelb.add(button[6]);panelb.add(buttonCal[1]);
		panelb.add(button[1]);panelb.add(button[2]);panelb.add(button[3]);panelb.add(buttonCal[2]);
		panelb.add(button[0]);panelb.add(buttonCal[6]);panelb.add(buttonCal[5]);panelb.add(buttonCal[3]);
		panelb.add(buttonCal[9]);panelb.add(buttonCal[7]);panelb.add(buttonCal[8]);panelb.add(buttonCal[4]);
		//
		//添加监听者
		back.addActionListener(this);C.addActionListener(this);;
		button[0].addActionListener(this);button[5].addActionListener(this);
		button[1].addActionListener(this);button[6].addActionListener(this);
		button[2].addActionListener(this);button[7].addActionListener(this);
		button[3].addActionListener(this);button[8].addActionListener(this);
		button[4].addActionListener(this);button[9].addActionListener(this);
		buttonCal[0].addActionListener(this);buttonCal[5].addActionListener(this);
		buttonCal[1].addActionListener(this);buttonCal[6].addActionListener(this);
		buttonCal[2].addActionListener(this);buttonCal[7].addActionListener(this);
		buttonCal[3].addActionListener(this);buttonCal[8].addActionListener(this);
		buttonCal[4].addActionListener(this);buttonCal[9].addActionListener(this);
		//
		frm.setJMenuBar(bar);
		frm.add(tx);
		frm.add(panela);
		frm.add(panelb);
		//实现
		frm.setResizable(false);
		frm.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		Object temp=e.getSource();
		if(temp==C)tx.setText(null);
		//为0-9按钮添加行动
		if(temp==button[0])tx.setText(tx.getText()+"0");
		if(temp==button[1])tx.setText(tx.getText()+"1");
		if(temp==button[2])tx.setText(tx.getText()+"2");
		if(temp==button[3])tx.setText(tx.getText()+"3");
		if(temp==button[4])tx.setText(tx.getText()+"4");
		if(temp==button[5])tx.setText(tx.getText()+"5");
		if(temp==button[6])tx.setText(tx.getText()+"6");
		if(temp==button[7])tx.setText(tx.getText()+"7");
		if(temp==button[8])tx.setText(tx.getText()+"8");
		if(temp==button[9])tx.setText(tx.getText()+"9");
		//为+号添加动作
		if(temp==buttonCal[3]){
			previous = Double.parseDouble(tx.getText());
			flag='+';
			tx.setText(tx.getText()+"+");
		}
		//为=号添加动作
		if(temp==buttonCal[4]){
			String tmp = tx.getText();
			record=0;
			if(flag=='+'){
				for(int i=0;i<tmp.length();i++){
					record++;
					if(tmp.charAt(i)=='+')break;
				}
				String NEXT = tmp.charAt(record)+"";
				for(int i=record+1;i<tmp.length();i++){
				NEXT = NEXT+tmp.charAt(i);
				}
				next = Double.parseDouble(NEXT);
				tx.setText(next+previous+"");
			}
			
		}
		if(temp==back){
			String tem = tx.getText();
			tx.setText(null);
			for(int i=0;i<tem.length()-1;i++)
				tx.setText(tx.getText()+tem.charAt(i));
		}
	}
	
	public static void main(String[] args) {
		new calculator();
	}
	
	
}
