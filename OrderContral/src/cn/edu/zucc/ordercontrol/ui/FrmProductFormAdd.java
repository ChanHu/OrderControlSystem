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
import javax.swing.JTextField;

import cn.edu.zucc.ordercontrol.control.ProductFormManager;
import cn.edu.zucc.ordercontrol.dao.MaterialDao;
import cn.edu.zucc.ordercontrol.model.Material;
import cn.edu.zucc.ordercontrol.model.Product;
import cn.edu.zucc.ordercontrol.model.Productform;
import cn.edu.zucc.ordercontrol.uti.BaseException;


public class FrmProductFormAdd extends JDialog implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Productform productform = null;

	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private JButton btnOk = new JButton("ȷ��");
	private JButton btnCancel = new JButton("ȡ��");
	private JLabel proid = new JLabel("��ƷID��");
	private JLabel matid = new JLabel("����ID��");
	private JLabel matcnt = new JLabel("����������");

	String[] strPdts;
	String[] strMats;
	

	JComboBox<String> combopro = null;
	JComboBox<String> combomat = null;
	
	private JTextField edtcnt = new JTextField(16);
	



	public FrmProductFormAdd(JDialog f, String s, boolean b,List<Product> list) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout());
		toolBar.add(btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		
		
		//��ȡ�����Ϣ
		strPdts=new String[list.size()+1];
		strPdts[0]="";
		Iterator<Product>  iterator=list.iterator();
		int i=1;
		while(iterator.hasNext()){
			strPdts[i]=iterator.next().getProductTypeID();
			i++;
		}
		combopro = new JComboBox<>(strPdts);
		
		//��ȡ�����Ϣ
		List<Material> list2=(new MaterialDao()).loadall();
		strMats=new String[list2.size()+1];
		strMats[0]="";
		Iterator<Material>  iterator2=list2.iterator();
		 i=1;
		while(iterator2.hasNext()){
			strMats[i]=iterator2.next().getMaterialId();
			i++;
		}
		combomat = new JComboBox<>(strMats);
		
		
		
		workPane.add(proid);
		workPane.add(combopro);
		workPane.add(matid);
		workPane.add(combomat);
		workPane.add(matcnt);
		workPane.add(edtcnt);
		
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		this.setSize(250, 360);
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
		if (e.getSource() == this.btnCancel) {
			this.setVisible(false);
			return;
		} else if (e.getSource() == this.btnOk) {

			this.productform=new Productform();
			productform.setProductId(strPdts[combopro.getSelectedIndex()]);
			productform.setMaterialId(strMats[combomat.getSelectedIndex()]);
			productform.setMaterialcount(edtcnt.getText());
			try {
				(new ProductFormManager()).CreateProductform(productform);
				this.setVisible(false);
			} catch (BaseException e1) {
				this.productform = null;
				JOptionPane.showMessageDialog(null, e1.getMessage(), "����", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	public Productform getProductForm() {
		return productform;
	}
}
