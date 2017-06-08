package os.jlxy.tr.rewrite.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class InitFrame {
	private JFrame frm = new JFrame();
	private JDialog dia = new JDialog(frm, "test", true);
	private JLabel lblInput = new JLabel();
	private JButton createBtn = new JButton("����");
	private JButton deleteBtn = new JButton("ɾ��");
	private Menu menu = new Menu(frm);
	private Table tb = new Table(0, 0, 300, 300);
	private JTextField Jpid;
	private JTextField Jstatus;
	private JTextField Jname;
	private JTextField JremainTime;

	public InitFrame() {
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLayout(null);
		frm.setBounds(400, 200, 500, 400);

		component();
		// componentLbl();
		setTable();

		frm.setVisible(true);
	}

	private void setTable() {
		tb.insert("1", "tets", "stop", "0", "1");
		tb.insert("0", "tets", "running", "0", "1");
		tb.updateByPid("0", "stop", "-1");
		System.out.println(tb.getStatusById("1"));
		// tb.getPosByPid("0");
		frm.add(tb.getJScroll());
	}

	private void component() {
		// dia.setVisible(true);
		// JOptionPane.showInputDialog("input");
		createBtn.setBounds(340, 30, 80, 40);
		deleteBtn.setBounds(340, 90, 80, 40);
		// lblInput.setBounds(200, 100, 90, 40);
		frm.add(createBtn);
		frm.add(deleteBtn);
		// frm.add(lblInput);
		createBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// JOptionPane.showMessageDialog(frm, "confirm");
				String temp = JOptionPane.showInputDialog("enter left time");
				tb.insert("0", "test", "run", temp, "1");

				// JOptionPane.showinput
			}
		});
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tb.delete();
			}
		});

	}

}
