package testFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class test {

        static JFrame frm = new JFrame();
        static JButton bt = new JButton("set the color of text");
        static JTextArea ta = new JTextArea("the color",5,20);

        public static void main(String[] args){
			
        		MyActLister mya = new MyActLister();
        		bt.addActionListener(mya);
                frm.setTitle("cao zuo shi jian");
                frm.setLayout(new FlowLayout());
                frm.setSize(500,400);
                frm.add(ta);
                frm.add(bt);
                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frm.setVisible(true);
        }

        static class MyActLister implements ActionListener{
        	public void actionPerformed(ActionEvent a){
        		ta.setForeground(Color.red);
        	}
        }

}

