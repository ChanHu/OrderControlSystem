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
import javax.swing.JTextField;

import cn.edu.zucc.ordercontrol.control.MaterialManager;
import cn.edu.zucc.ordercontrol.model.Material;

public class FrmMaterialModify extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Material pub = null;
	private Material old = null;

	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private JButton btnOk = new JButton("确定");
	private JButton btnCancel = new JButton("取消");
	private JLabel labelId1 = new JLabel("供货商编号：");
	private JLabel labelId2 = new JLabel("供货商名称：");
	private JLabel labelId3 = new JLabel("供货商地址：");
	private JLabel labelId4 = new JLabel("供货商联系人：");
	private JLabel labelId5 = new JLabel("供货商电话：");
	private TextArea brief = new TextArea(5, 28);

	private JTextField edtId1 = new JTextField(20);
	private JTextField edtId2 = new JTextField(20);
	private JTextField edtId3 = new JTextField(20);
	private JTextField edtId4 = new JTextField(20);

	public FrmMaterialModify(JDialog f, String s, boolean b, Material material) {
		super(f, s, b);
		old = material;
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelId1);
		workPane.add(edtId1);
		edtId1.setText(material.getMaterialId());
		workPane.add(labelId2);
		workPane.add(edtId2);
		edtId2.setText(material.getSupplierID());
		workPane.add(labelId3);
		workPane.add(edtId3);
		edtId3.setText(material.getMaterialName());
		workPane.add(labelId4);
		workPane.add(edtId4);
		edtId4.setText(material.getMaterialGuidePrice());
		workPane.add(labelId5);
		workPane.add(brief);
		brief.setText(material.getMaterialIntroduction());

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

			pub = new Material();
			pub.setMaterialId(this.edtId1.getText());
			pub.setSupplierID(this.edtId2.getText());
			pub.setMaterialName(this.edtId3.getText());
			pub.setMaterialGuidePrice(this.edtId4.getText());
			pub.setMaterialIntroduction(this.brief.getText());

			(new MaterialManager()).modifyMaterial(pub, old);

			this.setVisible(false);

		}
	}

	public Material getpub() {
		return pub;
	}
}
