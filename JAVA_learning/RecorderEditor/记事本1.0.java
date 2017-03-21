package 作业;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import javax.swing.colorchooser.DefaultColorSelectionModel;
 class Mylist implements ActionListener{
    public void actionPerformed(ActionEvent e) {
    e.getSource();
    }
    
}
public class 记事本 {
    static private int status=0;
    static private int tempstatus=0;
    static private int issaved=0;
    static private JFileChooser jfc;
    static private File newFile;
    static private FileInputStream fin;
    static private FileOutputStream fout;
    static private JFrame frm = new JFrame("记事本");
    static private JMenuBar bar = new JMenuBar();
    static private JMenu menwj = new JMenu("文件");
    static private JMenuItem wenjian = new JMenuItem("文件");
    static private JMenu bianji = new JMenu("编辑");
    static private JMenuItem xinjian = new JMenuItem("新建");
    static private JMenuItem open = new JMenuItem("打开");
    static private JMenuItem save = new JMenuItem("保存");
    static private JMenuItem saveas = new JMenuItem("另存为");
    static private JMenuItem close = new JMenuItem("退出");
    static private JMenuItem asellect = new JMenuItem("全选");
    static private JMenuItem frontcolor = new JMenuItem("前景色");
    static private JMenuItem backcolor = new JMenuItem("背景色");
    public static void main(String[] args) {
        JTextArea tx = new JTextArea();
        bar.add(menwj);
        bar.add(bianji);
        bianji.add(asellect);
        bianji.addSeparator();
        bianji.add(frontcolor);
        bianji.add(backcolor);
        menwj.add(xinjian);
        menwj.add(open);
        menwj.addSeparator();
        menwj.add(save);
        menwj.add(saveas);
        menwj.addSeparator();
        menwj.add(close);       
       
     frm.add(tx);
     frm.setSize(600,400);
     frm.setLayout(new GridLayout());
     frm.setLocation(700,300);
     frm.setJMenuBar(bar);
    
     close.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            System.exit(0);
            }
    });
     asellect.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            tx.selectAll();
            } 
     });
     open.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
             jfc = new JFileChooser();
            status = jfc.showOpenDialog(frm);
             if(status!=JFileChooser.APPROVE_OPTION)
                 tx.setText("未选择文件");
             else{
                 try{
                     File filea = jfc.getSelectedFile();
                     Scanner reader = new Scanner(filea);
                     String info = "";
                     while(reader.hasNext()){
                         String str = reader.nextLine();
                         info+=str+"\r\n";
                     }
                     tx.setText(info);
                 }catch(FileNotFoundException filee){}
             }
         }
     });
     save.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
           
            if(status==0){
                jfc = new JFileChooser();
                jfc.showSaveDialog(frm);
              try{
                  File file = jfc.getSelectedFile();
                  FileOutputStream fout = new FileOutputStream(file);
                  BufferedOutputStream bfout = new BufferedOutputStream(fout);
                  byte[] b = (tx.getText()).getBytes();
                  bfout.write(b, 0, b.length);
                  bfout.close();
              }catch(Exception savefile){};
             } 
            if(status==JFileChooser.APPROVE_OPTION){
              try{
                  File file = jfc.getSelectedFile();
                  FileOutputStream fout = new FileOutputStream(file);
                  BufferedOutputStream bfout = new BufferedOutputStream(fout);
                  byte[] b = (tx.getText()).getBytes();
                  bfout.write(b, 0, b.length);
                  bfout.close();
              }catch(Exception savefile){};
             } 
         }
     });
     saveas.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
             jfc = new JFileChooser();
            // status=JFileChooser.APPROVE_OPTION;
            // try{
                status = jfc.showSaveDialog(frm);
            //   status = tempstatus;
            //}catch(Exception noFile){tx.setText(tx.getText()+"\n**********未选择任何输出文件**********");}
            
            if(status==JFileChooser.APPROVE_OPTION){
              try{
                  File file = jfc.getSelectedFile();
                  FileOutputStream fout = new FileOutputStream(file);
                  BufferedOutputStream bfout = new BufferedOutputStream(fout);
                  byte[] b = (tx.getText()).getBytes();
                  bfout.write(b, 0, b.length);
                  bfout.close();
              }catch(Exception savefile){};
             }else tx.setText(tx.getText()+"\n**********未选择任何输出文件**********");
            issaved=1;
         }
     });
     xinjian.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent ea){
                tx.setText(null);
         }
     });
     
     frontcolor.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent fe){
          JColorChooser chooser=new JColorChooser();
             Color color=chooser.showDialog(frm,"选取颜色",Color.lightGray ); 
             tx.setForeground(color);
         }
     });
     
     backcolor.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent be){
             JColorChooser chooser = new JColorChooser();
             Color color = chooser.showDialog(frm,"选取颜色",Color.lightGray);
             tx.setBackground(color);
         }
     });
     frm.setVisible(true);
    } 
}

