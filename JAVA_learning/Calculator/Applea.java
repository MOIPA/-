package testFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Applea extends JFrame implements ActionListener{

	static Applea frm = new Applea();
	static JButton bt = new JButton("set the color of text");
	static JTextArea ta = new JTextArea("the color",5,20);

	public static void main (String[] args){
		bt.addActionListener(frm);

		frm.setTitle("cao zuo shi jian");
		frm.setLayout(new FlowLayout());
		frm.setSize(500,400);
		frm.add(ta);
		frm.add(bt);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	
		
	}

	public void actionPerformed(ActionEvent e){
		ta.setForeground(Color.red);
		}

}
