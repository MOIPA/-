package ��;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.event.*;

import javax.swing.*;
import javax.swing.border.Border;

public class StudyRecordV1_0{
	static JFrame frm = new JFrame("�򿨼�¼");
	static JPanel panela = new JPanel();
	static JPanel panelb = new JPanel();
	static JButton b1 = new JButton("days");
	static JButton add[] = new JButton[11]; 
	static JButton sub[] = new JButton[11]; 
	static JLabel[] courses = new JLabel[11];
	static JTextPane[] record = new JTextPane[11];
	static JLabel day = new JLabel("days");

	public static void main(String[] args)  throws IOException{
		//��������****************************
		frm.setSize(500, 530);
		frm.setLocation(700, 200);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLayout(new BorderLayout());
		panela.setLayout(null);
		//����courses��record****************************************
		for(int i=0;i<9;i++)
			add[i] = new JButton("add");
		for(int i=0;i<9;i++)
			sub[i] = new JButton("sub");
		int x=30;
		courses[0] = new JLabel("����");
		courses[1] = new JLabel("����");
		courses[2] = new JLabel("���");
		courses[3] = new JLabel("����");
		courses[4] = new JLabel("����");
		courses[5] = new JLabel("���ݽṹ");
		courses[6] = new JLabel("��ѧ");
		courses[7] = new JLabel("Ӣ��");
		courses[8] = new JLabel("JAVA");
		courses[9] = new JLabel("�����");
		
		for(int i=0;i<10;i++){
			record[i] = new JTextPane();
			record[i].setBounds(200, x, 80, 30);
			//record[i].setEnabled(false);
			record[i].setForeground(Color.black);
			record[i].setSelectedTextColor(Color.red);
			x+=40;
		}
		x = 30;
		for(int i=0;i<10;i++){
			courses[i].setBounds(70, x, 80, 30);
			x+=40;
		}
		x=30;
		for(int i=0;i<10;i++){
			add[i] = new JButton("add");
			add[i].setBounds(300, x, 70, 30);
			x+=40;
		}
		x=30;
		for(int i=0;i<10;i++){
			sub[i] = new JButton("sub");
			sub[i].setBounds(380, x, 70, 30);
			x+=40;
		}
		
		//ʵ�ֶ�д�򿪼�¼***************************************
		String temp[] = new String[11];
		//FileWriter fw = new FileWriter("C://Users//tangz//Documents//configFile.txt");
		FileReader filereader = new FileReader("C://Users//tangz//Documents//configFile.txt");
		BufferedReader bwrite = new BufferedReader(filereader);
		
		for(int i=0;i<10;i++){
			if((temp[i] = bwrite.readLine())!=null){
			record[i].setText(temp[i]);
			}
		}
		filereader.close();
		bwrite.close();
		//fw.write("12");
		//fw.close();
		//��Ӽ���********************************************
		for(int j=0;j<10;j++){
			int i=j;
			add[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(temp[0]==null)
						for(int i=0;i<10;i++)
						record[i].setText("0");
					if(record[i].getText()==null)
						record[i].setText("0");
					record[i].setText((Integer.parseInt(record[i].getText())+1)+"");
					temp[i] = record[i].getText();
					try {
						FileWriter fw = new FileWriter("C://Users//tangz//Documents//configFile.txt");
						BufferedWriter bw = new BufferedWriter(fw);
						for(int i=0;i<10;i++){
							bw.write(temp[i]);
							bw.newLine();
						}
						bw.flush();
						fw.close();
						bw.close();
					} catch (IOException e1) {}
				}
			});
		}
		for(int j=0;j<10;j++){
			int i=j;
			sub[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(temp[0]==null)
						for(int i=0;i<10;i++)
						record[i].setText("0");
					
					record[i].setText((Integer.parseInt(record[i].getText())-1)+"");
					temp[i] = record[i].getText();
					try {
						FileWriter fw = new FileWriter("C://Users//tangz//Documents//configFile.txt");
						BufferedWriter bw = new BufferedWriter(fw);
						for(int i=0;i<10;i++){
							bw.write(temp[i]);
							bw.newLine();
						}
						bw.flush();
						fw.close();
						bw.close();
					} catch (IOException e1) {}
				}
			});
		}
		//���*****************************************************
		panelb.add(day);
		for(int i=0;i<10;i++)
			panela.add(record[i]);
		for(int i=0;i<10;i++)
			panela.add(courses[i]);
		for(int i=0;i<10;i++)
			panela.add(add[i]);
		for(int i=0;i<10;i++)
			panela.add(sub[i]);
			
		frm.add(panelb,BorderLayout.NORTH);
		frm.add(panela,BorderLayout.CENTER);
		frm.setVisible(true);
	}
}
