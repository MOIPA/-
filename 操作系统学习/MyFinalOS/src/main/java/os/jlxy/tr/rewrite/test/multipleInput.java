package os.jlxy.tr.rewrite.test;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.*;

///��һ���Ի������ ����init���� ����String���� 0������ 1������ 2�����ȼ���
public class multipleInput extends JDialog {
	// private JLabel jlinfo;
	private JTextField textName, textLife, textPriority;
	private JButton button = new JButton("ȷ������");
	private static String[] infomation = new String[3];

	public String[] init() {
		setTitle("������Ϣ");
		setModal(true);
		setSize(150, 200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		JLabel name = new JLabel("����");
		JLabel remainTime = new JLabel("����");
		JLabel priority = new JLabel("���ȼ�");
		textName = new JTextField(8);
		textLife = new JTextField(8);
		textPriority = new JTextField(8);
		JPanel panel = new JPanel(new GridLayout(3, 2));
		panel.add(name);
		panel.add(textName);
		panel.add(priority);
		panel.add(textLife);
		panel.add(remainTime);
		panel.add(textPriority);

		// jlinfo = new JLabel("��Ϣ:",JLabel.CENTER);
		add(panel);
		// add(jlinfo,BorderLayout.NORTH);
		add(button, BorderLayout.SOUTH);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = "����:" + textName.getText() + " ����:" + textLife.getText() + " ���ȼ�:"
						+ textPriority.getText();
				infomation[0] = textName.getText();
				infomation[1] = textLife.getText();
				infomation[2] = textPriority.getText();

				// jlinfo.setText(info);
				JOptionPane.showMessageDialog(null, temp);
				// System.exit(0); FFFFFFUUUUUUCCCCCCKKKKKK����������������������������:��ֹȫ������
				close(); // !!!!!!!!!!!!!!!!!!!!!!!!!
			}
		});
		this.setVisible(true);

		return infomation;
	}

	private void close() {
		this.dispose();
	}
	
	public void exit(){
		System.exit(0);
	}
	

	public String[] getInfo() {
		return infomation;
	}

	public static void main(String[] args) {
		System.out.println(new multipleInput().init()[2] + "");
	}
}
