import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VisibleSort {
	private int len=13;
	private JTextField txa = new JTextField();
	private JTextField txb = new JTextField();	
	public VisibleSort(){
		JFrame frm = new JFrame("≈≈–Ú");
		frm.setBounds(700, 200, 450, 300);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLayout(null);
		setButton(frm);		
		setText(frm);
		frm.setVisible(true);
	}
	
	private int[] produceNum(){
		int[] array = new int[len];
		for(int i=0;i<len;i++){
			array[i] = (int)(Math.random()*100);
		}
		return array;
	}
	
	private void setButton(JFrame frm){
		JButton[] but = new JButton[9];
		but[0]= new JButton("√∞≈›≈≈–Ú");
		but[1]= new JButton("≤Â»Î≈≈–Ú");
		but[2]= new JButton("øÏÀŸ≈≈–Ú");
		but[3]= new JButton("∂—≈≈–Ú");
		but[4]= new JButton("—°‘Ò≈≈–Ú");
		but[5]= new JButton("œ£∂˚≈≈–Ú");
		but[6] = new JButton("¥¥Ω®ÀÊª˙ ˝");
		for(int i=0;i<3;i++){
		but[i].setBounds(10+i*100, 90, 100, 30);
		frm.add(but[i]);
		}
		for(int i=3;i<6;i++){
		but[i].setBounds(10+(i-3)*100, 120, 100, 30);
		frm.add(but[i]);
		}
		but[6].setBounds(20, 10, 100, 30);
		frm.add(but[6]);
		addListForBut(but);
	}
		
	private int[] stringToArray(String temp){
		String[] tempnum = new String[len];
		for(int i=0;i<len;i++){
			tempnum[i] = "";
		}
		int[] num = new int[len];
		int point=0;
		int i=0;
		//*************************************************∂¡»Î ˝◊÷À„∑®
		while(point<temp.length()){
			if(temp.charAt(point)!=' '){
				tempnum[i]+=temp.charAt(point)+"";
				if(temp.charAt(point+1)==' ')
					i++;
			}
				point++;
		}
		
		for(int k=0;k<len;k++){
			num[k]=Integer.parseInt(tempnum[k]);
		}
		return num;
	}
	
	private void addListForBut(JButton[] but){
		but[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				txb.setText("");
				String temp = txa.getText()+"    ";
				int[] num = new int[len];
				num = stringToArray(temp);
				BubbleSort bs = new BubbleSort();
				bs.Bsort(num);
				for(int k=0;k<len;k++)
					txb.setText(txb.getText()+num[k]+"    ");
				
			}
		});
		but[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				txb.setText("");
				String temp = txa.getText()+"    ";
				int[] num = new int[len];
				num = stringToArray(temp);
				InsertSortV2 is = new InsertSortV2();
				is.Sort(num);
				for(int k=0;k<len;k++)
					txb.setText(txb.getText()+num[k]+"    ");
				
			}
		});
		but[2].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				txb.setText("");
				String temp = txa.getText()+"    ";
				int[] num = new int[len];
				num = stringToArray(temp);
				QuickSort qs = new QuickSort();
				qs.sort(num);
				for(int k=0;k<len;k++)
					txb.setText(txb.getText()+num[k]+"    ");
				
			}
		});
		but[3].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				txb.setText("");
				String temp = txa.getText()+"    ";
				int[] num = new int[len];
				num = stringToArray(temp);
				Integer[] numInt = new Integer[len];
				for(int i=0;i<len;i++)
					numInt[i] = num[i];
				HeapSort hs = new HeapSort();
				hs.sort(numInt);
				for(int k=0;k<len;k++)
					txb.setText(txb.getText()+numInt[k]+"    ");
				
			}
		});		
		but[4].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				txb.setText("");
				String temp = txa.getText()+"    ";
				int[] num = new int[len];
				num = stringToArray(temp);
				ChoseSort cs = new ChoseSort();
				cs.Csort(num);
				for(int k=0;k<len;k++)
					txb.setText(txb.getText()+num[k]+"    ");
				
			}
		});
		but[5].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				txb.setText("");
				String temp = txa.getText()+"    ";
				int[] num = new int[len];
				num = stringToArray(temp);
				shellSort ss = new shellSort();
				ss.sort(num, num.length);
				for(int k=0;k<len;k++)
					txb.setText(txb.getText()+num[k]+"    ");
				
			}
		});
		but[6].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int[] num = produceNum();
				String temp=num[0]+"";
				for(int i=1;i<len;i++){
					temp+="    "+num[i];
				}
				txa.setText(temp);
				}
		});
	}
	
	public void setText(JFrame frm){
		txa.setBounds(10, 50, 400, 30);
		frm.add(txa);
		txb.setBounds(10, 170, 400, 30);
		frm.add(txb);
	}
		
	public static void main(String[] args) {
		VisibleSort test = new VisibleSort();		
	}
}
