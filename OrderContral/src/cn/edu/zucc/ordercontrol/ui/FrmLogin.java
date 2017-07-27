package cn.edu.zucc.ordercontrol.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.edu.zucc.ordercontrol.dao.AdminDao;
import cn.edu.zucc.ordercontrol.model.Admin;

public class FrmLogin extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Admin currentAdmin = null;
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private JButton btnLogin = new JButton("µ«¬Ω");
	private JButton btnCancel = new JButton("»°œ˚");
	private JButton btnRegister = new JButton("◊¢≤·");

	private JLabel labelUser = new JLabel("’À∫≈£∫");
	private JLabel labelPwd = new JLabel("√‹¬Î£∫");
	private JTextField edtUserId = new JTextField(20);
	private JPasswordField edtPwd = new JPasswordField(20);

	public FrmLogin(JDialog f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(this.btnRegister);
		toolBar.add(btnLogin);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelUser);
		workPane.add(edtUserId);
		workPane.add(labelPwd);
		workPane.add(edtPwd);
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		this.setSize(320, 140);
		// Â±èÂπïÂ±Ö‰∏≠ÊòæÁ§∫
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2, (int) (height - this.getHeight()) / 2);

		this.validate();

		btnLogin.addActionListener(this);
		btnCancel.addActionListener(this);
		this.btnRegister.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnLogin) {
			String Adminid = this.edtUserId.getText();
			String pwd = new String(this.edtPwd.getPassword());

			Admin.currentLoginAdmin = (new AdminDao()).search(Adminid);
			if ((new AdminDao()).search(Adminid) == null) {
				JOptionPane.showMessageDialog(null, "id¥ÌŒÛ", "¥ÌŒÛÃ· æ", JOptionPane.ERROR_MESSAGE);
			}
			if (pwd.equals((new AdminDao()).search(Adminid).getAdminPasswd())) {
				FrmLogin.currentAdmin = (new AdminDao()).search(Adminid);
				setVisible(false);

			} else {
				JOptionPane.showMessageDialog(null, "√‹¬Î¥ÌŒÛ", "¥ÌŒÛÃ· æ", JOptionPane.ERROR_MESSAGE);
			}

		} else if (e.getSource() == this.btnCancel) {
			System.exit(0);
		} else if (e.getSource() == this.btnRegister) {
			FrmRegister dlg = new FrmRegister(this, "◊¢≤·", true);
			Toolkit kit = Toolkit.getDefaultToolkit();// …Ë÷√∂•≤„»›∆˜øÚº‹Œ™æ”÷–
			Dimension screenSize = kit.getScreenSize();
			int width = screenSize.width;
			int height = screenSize.height;
			int x = (width - 320) / 2;
			int y = (height - 140) / 2;
			dlg.setLocation(x, y);

			dlg.setVisible(true);
		}
	}

}
