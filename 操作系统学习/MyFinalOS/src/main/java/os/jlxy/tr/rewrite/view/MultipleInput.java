package os.jlxy.tr.rewrite.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

///打开一个对话输入框 调用init函数 返回String数组 0是名字 1是生命 2是优先级别
public class MultipleInput extends JDialog {
	// private JLabel jlinfo;
	private JTextField textName, textLife, textPriority;
	private JButton button = new JButton("确认输入");
	private static String[] infomation = new String[3];

	public String[] init() {
		setTitle("输入信息");
		setModal(true);
		setSize(150, 200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		JLabel name = new JLabel("名字");
		JLabel remainTime = new JLabel("生命");
		JLabel priority = new JLabel("优先级");
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

		// jlinfo = new JLabel("信息:",JLabel.CENTER);
		add(panel);
		// add(jlinfo,BorderLayout.NORTH);
		add(button, BorderLayout.SOUTH);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = "名字:" + textName.getText() + " 生命:" + textLife.getText() + " 优先级:"
						+ textPriority.getText();
				infomation[0] = textName.getText();
				infomation[1] = textLife.getText();
				infomation[2] = textPriority.getText();

				// jlinfo.setText(info);
				JOptionPane.showMessageDialog(null, temp);
				// System.exit(0); FFFFFFUUUUUUCCCCCCKKKKKK！！！！！！！！！！！！！！:终止全部进程
				close(); // !!!!!!!!!!!!!!!!!!!!!!!!!
			}
		});
		this.setVisible(true);
		if(infomation[0]==""||infomation[1]==""||infomation[2]==""||infomation[0]==null||infomation[1]==null||infomation[2]==null)
			return null;
		else return infomation;
	}

	private void close() {
		this.dispose();
	}
	

	public String[] getInfo() {
		return infomation;
	}

	public static void main(String[] args) {
		System.out.println(new MultipleInput().init()[2] + "");
	}
}
