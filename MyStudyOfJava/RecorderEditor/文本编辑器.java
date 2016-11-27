package 文本编辑器;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;
public class 文本编辑器 extends JFrame implements ActionListener {
    private JPanel panel = new JPanel();
    private JFrame frm = new JFrame("简单文本编辑器");
    private JToolBar bar = new JToolBar();
    private JButton open = new JButton();
    private JButton save = new JButton();
    private JButton edit = new JButton();
    private JTextArea tx = new JTextArea();
    private JScrollPane js = new JScrollPane(tx);
    private JColorChooser colorchooser =new JColorChooser();
    private JFileChooser filechooser = new JFileChooser();
    private ImageIcon imageopen = new ImageIcon("C:/Users/TR/Pictures/Saved Pictures/a.jpg");
    public 文本编辑器(){
        open.setIcon(imageopen);
        save.setIcon(imageopen);
        edit.setIcon(imageopen);
        open.setBounds(20, 5, 30, 30);
        save.setBounds(50, 5, 30, 30);
        edit.setBounds(80, 5, 30, 30);
        bar.setLayout(null);
        open.setToolTipText("打开");
        save.setToolTipText("保存");
        edit.setToolTipText("颜色");
        bar.add(open);
        bar.add(save);
        bar.add(edit);
        
        bar.setBounds(0, 0, 500, 40);
        js.setBounds(40, 80, 360, 200);
        open.addActionListener(this);
        save.addActionListener(this);
        edit.addActionListener(this);
        String initial =" ";
        for(int i=0;i<20;i++){
            for(int j=0;j<200;j++){
                initial+=" ";
            }
            initial+="\r\n";
        }
        initial="您好"+initial;
        tx.setText(initial);
        frm.setLayout(null);
        frm.add(js);
        frm.add(bar);
       
        frm.setLocation(700,300);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setSize(500,400);
        frm.setVisible(true);
    }
    
    public static void main(String[] args) {
        new 文本编辑器();
    }

    public void actionPerformed(ActionEvent e) {
        JButton but = (JButton)e.getSource();
        if(but==open){
            try{
            int status = filechooser.showOpenDialog(frm);
            if(status==JFileChooser.APPROVE_OPTION){
                File selectedfile = filechooser.getSelectedFile();
                Scanner reader = new Scanner(selectedfile);
                String info = "";
                while(reader.hasNext()){
                    info+=reader.nextLine()+"\r\n";
                }
                tx.setText(info);
            }else tx.setText("未选择文本");
            }catch(Exception fe){};
        }
        
        if(but==save){
            try{
                int status = filechooser.showSaveDialog(frm);
                if(status==JFileChooser.APPROVE_OPTION){
                    File file = filechooser.getSelectedFile();
                    FileOutputStream fout = new FileOutputStream(file);
                    BufferedOutputStream bfout = new BufferedOutputStream(fout);
                    byte[] temp = (tx.getText()).getBytes();
                    bfout.write(temp);
                    bfout.close();
                }
            }catch(Exception se){};
        }
        
        if(but==edit){
            try{
                Color color = colorchooser.showDialog(this,"Choose Background Color",Color.BLACK);
                tx.setBackground(color);
            }catch(Exception ee){};
        }
        
    }
    
}
