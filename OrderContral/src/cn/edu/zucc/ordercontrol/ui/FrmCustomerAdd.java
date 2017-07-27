package cn.edu.zucc.ordercontrol.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.edu.zucc.ordercontrol.control.CustomerManager;
import cn.edu.zucc.ordercontrol.model.Customer;
import cn.edu.zucc.ordercontrol.uti.BusinessException;

public class FrmCustomerAdd extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Customer pub = null;

	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private JButton btnOk = new JButton("ȷ��");
	private JButton btnCancel = new JButton("ȡ��");
	private JLabel labelId1 = new JLabel("�˿ͱ�ţ�");
	private JLabel labelId2 = new JLabel("�˿����֣�");
	private JLabel labelId3 = new JLabel("�˿͵�ַ��");
	private JLabel labelId4 = new JLabel("��ϵ�ˣ�");
	private JLabel labelId5 = new JLabel("��ϵ�绰��");

	private JTextField edtId1 = new JTextField(20);
	private JTextField edtId2 = new JTextField(20);
	private JTextField edtId3 = new JTextField(20);
	private JTextField edtId4 = new JTextField(20);
	private JTextField edtId5 = new JTextField(20);

	public FrmCustomerAdd(JDialog f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelId1);
		workPane.add(edtId1);
		workPane.add(labelId2);
		workPane.add(edtId2);
		workPane.add(labelId3);
		workPane.add(edtId3);
		workPane.add(labelId4);
		workPane.add(edtId4);
		workPane.add(labelId5);
		workPane.add(edtId5);
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		this.setSize(300, 500);
		// ��Ļ������ʾ
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2, (int) (height - this.getHeight()) / 2);

		this.validate();
		this.btnOk.addActionListener(this);
		this.btnCancel.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.btnCancel) {
			this.setVisible(false);
			return;
		} else if (e.getSource() == this.btnOk) {

			pub = new Customer();
			pub.setCustomerID(this.edtId1.getText());
			pub.setCustomerName(this.edtId2.getText());
			pub.setCustomerAddresss(this.edtId3.getText());
			pub.setCustomerContacts(this.edtId4.getText());
			pub.setCustomerPhone(this.edtId5.getText());

			try {
				(new CustomerManager()).CreateCustomer(pub);
			} catch (BusinessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, e1.getMessage(), "����", JOptionPane.ERROR_MESSAGE);
			}
			this.setVisible(false);
		}
	}

	public Customer getPub() {
		return pub;
	}
}
