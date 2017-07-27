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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cn.edu.zucc.ordercontrol.control.ProductTypeManager;
import cn.edu.zucc.ordercontrol.model.ProductType;
import cn.edu.zucc.ordercontrol.uti.BaseException;

public class FrmProductTypeAdd extends JDialog implements ActionListener {
	private ProductType productType = null;

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

	public FrmProductTypeAdd(JDialog f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout());
		toolBar.add(btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		
		workPane.add(labelid);
		workPane.add(edtid);
		workPane.add(labelname);
		workPane.add(edtname);
		workPane.add(labelbrief);
		brief.setLineWrap(true);
		workPane.add(brief);

		this.getContentPane().add(workPane, BorderLayout.CENTER);
		this.setSize(250, 360);
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
		if (e.getSource() == this.btnCancel) {
			this.setVisible(false);
			return;
		} else if (e.getSource() == this.btnOk) {

			this.productType = new ProductType();
			productType.setProductTypeID(edtid.getText());
			productType.setProductTypeName(edtname.getText());
			productType.setProductTypeIntroduction(brief.getText());

			try {
				(new ProductTypeManager()).CreateProductType(productType);
				this.setVisible(false);
			} catch (BaseException e1) {
				this.productType = null;
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	public ProductType getReadertype() {
		return productType;
	}
}
