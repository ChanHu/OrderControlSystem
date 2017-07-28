package cn.edu.zucc.ordercontrol.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cn.edu.zucc.ordercontrol.control.ProductManager;
import cn.edu.zucc.ordercontrol.model.Product;
import cn.edu.zucc.ordercontrol.model.ProductType;
import cn.edu.zucc.ordercontrol.uti.BaseException;


public class FrmProductAdd extends JDialog implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Product product = null;

	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private JButton btnOk = new JButton("确定");
	private JButton btnCancel = new JButton("取消");
	private JLabel labelid = new JLabel("产品ID：");
	private JLabel labeltype = new JLabel("产品类别：");
	private JLabel labelname = new JLabel("产品名称：");
	private JLabel labelprice = new JLabel("产品价格：");
	private JLabel labelbrief = new JLabel("类别简介：");
	String[] strTypes;
	
	
	
	private JTextField edtid = new JTextField(16);
	JComboBox<String> combotype = null;
	private JTextField edtname = new JTextField(16);
	private JTextField edtprice = new JTextField(16);
	private JTextArea brief = new JTextArea();



	public FrmProductAdd(JDialog f, String s, boolean b,List<ProductType> list) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout());
		toolBar.add(btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		
		
		//提取类别信息
		strTypes=new String[list.size()+1];
		strTypes[0]="";
		Iterator<ProductType>  iterator=list.iterator();
		int i=1;
		while(iterator.hasNext()){
			strTypes[i]=iterator.next().getProductTypeID();
			i++;
		}
		combotype = new JComboBox<>(strTypes);
		
		
		
		workPane.add(labelid);
		workPane.add(edtid);

		workPane.add(labelname);
		workPane.add(edtname);
		workPane.add(labelprice);
		workPane.add(edtprice);
		workPane.add(labelbrief);
		brief.setLineWrap(true);
		workPane.add(brief);
		workPane.add(labeltype);
		workPane.add(combotype);
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

			this.product = new Product();
			product.setProductId(edtid.getText());
			product.setProductTypeID(strTypes[combotype.getSelectedIndex()]);
			product.setProductName(edtname.getText());
			product.setProductPrice(edtprice.getText());
			product.setProductIntroduction(brief.getText());
			try {
				(new ProductManager()).CreateProduct(product);
				this.setVisible(false);
			} catch (BaseException e1) {
				this.product = null;
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	public Product getProduct() {
		return product;
	}
}
