package cn.edu.zucc.ordercontrol.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.edu.zucc.ordercontrol.dao.SupplierDao;
import cn.edu.zucc.ordercontrol.model.Supplier;

public class FrmMaterialModify extends JDialog implements ActionListener{

	
	private Supplier aSupplier=null;
	


	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("确定");
	private Button btnCancel = new Button("取消");
	private JLabel labelId1 = new JLabel("供货商编号：");
	private JLabel labelId2 = new JLabel("供货商名称：");
	private JLabel labelId3 = new JLabel("供货商地址：");
	private JLabel labelId4 = new JLabel("供货商联系人：");
	private JLabel labelId5 = new JLabel("供货商电话：");
	private JLabel labelId6 = new JLabel("供货商简介：");
	private TextArea brief = new TextArea(5,28);
	
	private JTextField edtId1 = new JTextField(20);
	private JTextField edtId2 = new JTextField(20);
	private JTextField edtId3 = new JTextField(20);
	private JTextField edtId4 = new JTextField(20);
	private JTextField edtId5 = new JTextField(20);
	
	
	public FrmMaterialModify(JDialog  f, String s, boolean b,Supplier supplier) {
		super(f,s,b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelId1);
		workPane.add(edtId1);
		edtId1.setText(supplier.getSupplierID());
		workPane.add(labelId2);
		workPane.add(edtId2);
		edtId2.setText(supplier.getSupplierName());
		workPane.add(labelId3);
		workPane.add(edtId3);
		edtId3.setText(supplier.getSupplierAddress());
		workPane.add(labelId4);
		workPane.add(edtId4);
		edtId4.setText(supplier.getSupplierContacts());
		workPane.add(labelId5);
		workPane.add(edtId5);
		edtId5.setText(supplier.getSupplierPhone());
		workPane.add(labelId6);
		workPane.add(brief);
		brief.setText(supplier.getSupplierBriefIntroduction());
		
		
		
		
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		this.setSize(300,500);
		// 屏幕居中显示
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();
		this.btnOk.addActionListener(this);
		this.btnCancel.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.btnCancel) {
			this.setVisible(false);
			return;
		}
		else if(e.getSource()==this.btnOk){
			
			aSupplier=new Supplier();
			aSupplier.setSupplierID(this.edtId1.getText());
			aSupplier.setSupplierName(this.edtId2.getText());
			aSupplier.setSupplierAddress(this.edtId3.getText());
			aSupplier.setSupplierContacts(this.edtId4.getText());
			aSupplier.setSupplierPhone(this.edtId5.getText());
			aSupplier.setSupplierBriefIntroduction(this.brief.getText());
			
			(new SupplierDao()).modifySupplier(aSupplier);
			this.setVisible(false);

		}
	}
	public Supplier getaSupplier() {
		return aSupplier;
	}
}

