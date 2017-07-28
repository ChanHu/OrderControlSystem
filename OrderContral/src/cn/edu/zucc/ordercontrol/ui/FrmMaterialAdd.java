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
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cn.edu.zucc.ordercontrol.control.MaterialManager;
import cn.edu.zucc.ordercontrol.dao.SupplierDao;
import cn.edu.zucc.ordercontrol.model.Material;
import cn.edu.zucc.ordercontrol.model.Supplier;

public class FrmMaterialAdd extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Material pub = null;

	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private JButton btnOk = new JButton("确定");
	private JButton btnCancel = new JButton("取消");
	private JLabel labelId1 = new JLabel("材料编号：");
	private JLabel labelId2 = new JLabel("供货商编号：");
	private JLabel labelId3 = new JLabel("材料名字：");
	private JLabel labelId4 = new JLabel("材料价格");
	private JLabel labelId5 = new JLabel("材料简介：");
	private JTextArea brief = new JTextArea(5, 28);

	private JTextField edtId1 = new JTextField(20);
	private JTextField edtId2 = new JTextField(20);
	private JTextField edtId3 = new JTextField(20);
	private JTextField edtId4 = new JTextField(20);
	String[] strmaterials;
	JComboBox<String> combotype = null;
	
	public FrmMaterialAdd(JDialog f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		
		List<Supplier> list=(new SupplierDao()).loadall();
		strmaterials=new String[list.size()+1];
		strmaterials[0]="";
		Iterator<Supplier>  iterator=list.iterator();
		int i=1;
		while(iterator.hasNext()){
			strmaterials[i]=iterator.next().getSupplierID();
			i++;
		}
		combotype = new JComboBox<>(strmaterials);
		
		
		workPane.add(labelId1);
		workPane.add(edtId1);
		workPane.add(labelId3);
		workPane.add(edtId3);
		workPane.add(labelId4);
		workPane.add(edtId4);
		workPane.add(labelId2);
		workPane.add(combotype);
		workPane.add(labelId5);
		workPane.add(brief);
		
		
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		this.setSize(250, 500);
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

			pub = new Material();
			pub.setMaterialId(this.edtId1.getText());
			pub.setSupplierID(strmaterials[combotype.getSelectedIndex()]);
			pub.setMaterialName(this.edtId3.getText());
			pub.setMaterialGuidePrice(this.edtId4.getText());
			pub.setMaterialIntroduction(this.brief.getText());

			(new MaterialManager()).CreateMaterial(pub);
			this.setVisible(false);
		}
	}

	public Material getPub() {
		return pub;
	}
}
