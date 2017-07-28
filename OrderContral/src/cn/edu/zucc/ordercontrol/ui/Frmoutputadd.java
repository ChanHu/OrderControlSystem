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

import cn.edu.zucc.ordercontrol.control.StockOutputManager;
import cn.edu.zucc.ordercontrol.dao.ProductDao;
import cn.edu.zucc.ordercontrol.model.Product;
import cn.edu.zucc.ordercontrol.model.StockOutput;
import cn.edu.zucc.ordercontrol.uti.BaseException;


public class Frmoutputadd extends JDialog implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private StockOutput   output= null;

	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private JButton btnOk = new JButton("确定");
	private JButton btnCancel = new JButton("取消");
	private JLabel labelid = new JLabel("出售ID：");
	private JLabel labelid2 = new JLabel("出售数量：");
	private JLabel labelid3 = new JLabel("出售类型：");
	String[] strproducts;
	
	
	private JTextField edtid = new JTextField(16);
	private JTextField edtid2= new JTextField(16);
	JComboBox<String> combotype = null;




	public Frmoutputadd(JDialog f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout());
		toolBar.add(btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		
		List<Product> list= (new ProductDao()).loadall();
		//提取类别信息
		strproducts=new String[list.size()+1];
		strproducts[0]="";
		Iterator<Product>  iterator=list.iterator();
		int i=1;
		while(iterator.hasNext()){
			strproducts[i]=iterator.next().getProductId();
			i++;
		}
		combotype = new JComboBox<>(strproducts);
		
		workPane.add(labelid);
		workPane.add(edtid);
		workPane.add(labelid2);
		workPane.add(edtid2);
		workPane.add(labelid3);
		workPane.add(combotype);
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		this.setSize(240, 260);
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

			this.output= new StockOutput();
			output.setProductId(strproducts[combotype.getSelectedIndex()]);
			output.setStockOutputID(edtid.getText());
			output.setStockOutputCount(edtid2.getText());
			
			try {
				(new StockOutputManager()).CreateStockOutput(output);
				this.setVisible(false);
			} catch (BaseException e1) {
				this.output = null;
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	public StockOutput getoutput() {
		return output;
	}
}
