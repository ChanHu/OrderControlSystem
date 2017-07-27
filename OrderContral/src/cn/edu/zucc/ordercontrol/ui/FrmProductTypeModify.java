package cn.edu.zucc.ordercontrol.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cn.edu.zucc.ordercontrol.control.ProductTypeManager;
import cn.edu.zucc.ordercontrol.control.SupplierManager;
import cn.edu.zucc.ordercontrol.model.ProductType;
import cn.edu.zucc.ordercontrol.model.Supplier;
import cn.edu.zucc.ordercontrol.uti.BusinessException;


public class FrmProductTypeModify extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductType pub=null;
	private ProductType old = null;

	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private JButton btnOk = new JButton("确定");
	private JButton btnCancel = new JButton("取消");
	private JLabel labelid = new JLabel("类别ID：");
	private JLabel labelname = new JLabel("类别名称：");
	private JLabel labelbrief = new JLabel("类别简介：");
	
	private JTextField edtid = new JTextField(20);
	private JTextField edtname = new JTextField(20);
	private JTextArea brief = new JTextArea();
	

	public FrmProductTypeModify(JDialog f, String s, boolean b, ProductType productType) {
		super(f, s, b);
		old = productType;
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelid);
		workPane.add(edtid);
		edtid.setText(productType.getProductTypeID());
		workPane.add(labelname);
		workPane.add(edtname);
		edtname.setText(productType.getProductTypeName());
		workPane.add(labelbrief);
		workPane.add(brief);
		brief.setLineWrap(true);
		brief.setText(productType.getProductTypeIntroduction());
		

		this.getContentPane().add(workPane, BorderLayout.CENTER);
		this.setSize(275, 400);
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

			pub= new ProductType();
			pub.setProductTypeID(edtid.getText());
			pub.setProductTypeName(edtname.getText());
			pub.setProductTypeID(brief.getText());

			try {
				(new ProductTypeManager()).modifyProductType(pub,old);
			} catch (BusinessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.setVisible(false);

		}
	}

	public ProductType getProductType() {
		return pub;
	}
}
