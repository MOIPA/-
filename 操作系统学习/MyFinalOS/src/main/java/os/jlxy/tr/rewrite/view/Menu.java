package os.jlxy.tr.rewrite.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Menu {

	private JMenuBar mb = new JMenuBar();
	private JMenu info = new JMenu("about");
	private JMenuItem author = new JMenuItem("Author");


	public Menu(final JFrame frm) {
		mb.add(info);
		info.add(author);
		frm.setJMenuBar(mb);
		author.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frm, "made by 2015020800117-tr \n and 2015020800115-tzq");
			}
		});
	}
}
