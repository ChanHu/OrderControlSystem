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

public class FrmCustomerModify extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Customer pub = null;
	private Customer old = null;

	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private JButton btnOk = new JButton("确定");
	private JButton btnCancel = new JButton("取消");
	private JLabel labelId1 = new JLabel("顾客编号：");
	private JLabel labelId2 = new JLabel("顾客名字：");
	private JLabel labelId3 = new JLabel("顾客地址：");
	private JLabel labelId4 = new JLabel("联系人：");
	private JLabel labelId5 = new JLabel("联系电话：");

	private JTextField edtId1 = new JTextField(20);
	private JTextField edtId2 = new JTextField(20);
	private JTextField edtId3 = new JTextField(20);
	private JTextField edtId4 = new JTextField(20);
	private JTextField edtId5 = new JTextField(20);

	public FrmCustomerModify(JDialog f, String s, boolean b, Customer customer) {
		super(f, s, b);
		old = customer;
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelId1);
		workPane.add(edtId1);
		edtId1.setText(customer.getCustomerID());
		workPane.add(labelId2);
		workPane.add(edtId2);
		edtId2.setText(customer.getCustomerName());
		workPane.add(labelId3);
		workPane.add(edtId3);
		edtId3.setText(customer.getCustomerAddresss());
		workPane.add(labelId4);
		workPane.add(edtId4);
		edtId4.setText(customer.getCustomerContacts());
		workPane.add(labelId5);
		workPane.add(edtId5);
		edtId5.setText(customer.getCustomerPhone());

		this.getContentPane().add(workPane, BorderLayout.CENTER);
		this.setSize(300, 500);
		// 屏幕居中显示
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
				(new CustomerManager()).modifyCustomer(pub, old);
			} catch (BusinessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
			}
			this.setVisible(false);
		}
	}

	public Customer getPub() {
		return pub;
	}
}
