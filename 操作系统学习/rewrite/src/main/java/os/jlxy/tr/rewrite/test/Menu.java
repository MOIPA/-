package os.jlxy.tr.rewrite.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Menu {

	private JMenuBar mb = new JMenuBar();
	private JMenu info = new JMenu("��Ϣ");
	private JMenuItem author = new JMenuItem("tr");

	public Menu(JFrame frm) {
		mb.add(info);
		info.add(author);
		frm.setJMenuBar(mb);
		author.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(frm, "made by tr");
			}
		});
	}
}
