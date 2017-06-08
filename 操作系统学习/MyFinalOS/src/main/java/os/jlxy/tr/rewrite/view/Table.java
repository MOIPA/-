package os.jlxy.tr.rewrite.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Table {

	private final int len = 5;
	private ImageIcon icon = new ImageIcon("D:/OS_pic/btn1.png");
	private JTable tb;
	private DefaultTableModel dm;
	private JScrollPane js;
	private Object[][] rowData = new Object[0][len];
	private String[] columnNames = new String[len];

	public Table(int x, int y, int width, int height) {
		setColumnNames();
		// System.out.println(columnNames[0]);
		// setRowData();
		// String[] columnNames = {"���?","�û���","����"};
		dm = new DefaultTableModel(rowData, columnNames);
		tb = new JTable(dm);
		tb.setRowHeight(30);
		tb.setBounds(x, y, width, height);
		tb.getTableHeader().setBackground(Color.gray);
		tb.getTableHeader().setForeground(Color.white);
		tb.setOpaque(false);
		// changeBackColor();
		js = new JScrollPane(tb);
		js.getViewport().setOpaque(false);
		js.setOpaque(false);
		js.setBounds(x, y, width, height);
		tb.setVisible(true);
	}

	private void setColumnNames() {
		int j = 0;
		columnNames[j++] = "pid";
		columnNames[j++] = "name";
		columnNames[j++] = "status";
		columnNames[j++] = "remain time";
		columnNames[j++] = "priority";
	}

	// �����? �õ�����Table��JSCROLLPANEL
	public JScrollPane getJScroll() {
		return js;
	}
	
	public void repaint(){
		tb.repaint();
	}

	// ������ �õ�Table
	public JTable getTable() {
		return tb;
	}

	// ����һ��
	public void insert(String pid, String name, String status, String remainTime, String priority) {
		// tb.setRowSelectionAllowed(true);
		Object[] data = { pid, name, status, remainTime, priority };
		dm.addRow(data);

	}

	// ��ʱ���� ��������?
	public void update(int row, int column, String value) {
		tb.getModel().setValueAt(value, row, column);
	}

	// ����Pid�õ���һ�е��к�
	private int getPosByPid(String Pid) {
		int pos = -1;
		for (int i = 0; i < tb.getRowCount(); i++)
			if (tb.getModel().getValueAt(i, 0).equals(Pid))
				pos = i;
		return pos;
	}

	// ����Pid�޸�״̬��ʣ��ʱ��
	public void updateByPid(String Pid, String status, String remainTime) {
		tb.getModel().setValueAt(status, getPosByPid(Pid), 2);
		tb.getModel().setValueAt(remainTime, getPosByPid(Pid), 3);
//		tb.getModel().setValueAt(remainTime, getPosByPid(Pid), 4);
	}

	public String getStatusById(String Pid) {
		return (String) tb.getModel().getValueAt(getPosByPid(Pid), 2);
	}

	public void delete() {
		// DefaultTableModel dm= (DefaultTableModel)tb.getModel();
		// if(tb.getSelectedColumn()==-1){
		// JOptionPane.showMessageDialog(null, "��ѡ��һ��");
		// }else{
		// dm.removeRow(tb.getSelectedRow());
		// }
		try {
			DefaultTableModel dm = (DefaultTableModel) tb.getModel();
			dm.removeRow(tb.getSelectedRow());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "请选择一行");
		}
	}
	
	public void deletePid(String pid){
		DefaultTableModel dm = (DefaultTableModel) tb.getModel();
		dm.removeRow(getPosByPid(pid));
	}
	
	public void deleteAll(){
//		for(int i=0;i<tb.getRowCount();i++){
			DefaultTableModel dm = (DefaultTableModel) tb.getModel();
			while(dm.getRowCount()>0){
				dm.removeRow(dm.getRowCount()-1);
				}
//		}
	}
	


	// public void changeBackColor(){
	// for(int i=1;i<=tb.getModel().getRowCount();i++){
	// if(tb.getModel().getValueAt(i, 3).equals("runing"))
	// tb.setSelectionBackground(Color.blue);
	// }
	// }
	//

}
