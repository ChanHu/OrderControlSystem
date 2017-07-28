package cn.edu.zucc.ordercontrol.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.ordercontrol.control.ProductFormManager;
import cn.edu.zucc.ordercontrol.control.ProductManager;
import cn.edu.zucc.ordercontrol.control.ProductTypeManager;
import cn.edu.zucc.ordercontrol.dao.ProductDao;
import cn.edu.zucc.ordercontrol.dao.ProductTypeDao;
import cn.edu.zucc.ordercontrol.dao.ProductformDao;
import cn.edu.zucc.ordercontrol.model.Product;
import cn.edu.zucc.ordercontrol.model.ProductType;
import cn.edu.zucc.ordercontrol.model.Productform;

public class FrmProduct extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel toolBar1 = new JPanel();
	private JPanel list1 = new JPanel();
	private JPanel toolBar2 = new JPanel();
	private JPanel list2 = new JPanel();
	private JPanel toolBar3 = new JPanel();
	private JPanel list3 = new JPanel(); 

	
	private JLabel l1= new JLabel("                产品类别");
	private JLabel l2= new JLabel("                       产品");
	private JLabel l3= new JLabel("                产品构成");
	
	private JButton btnAdd = new JButton("添加");
	private JButton btnModify = new JButton("修改");
	private JButton btnDelete = new JButton("删除");
	private JButton btnAdd2 = new JButton("添加");
	private JButton btnModify2 = new JButton("修改");
	private JButton btnDelete2 = new JButton("删除");
	private JButton btnAdd3 = new JButton("添加");
	private JButton btnModify3 = new JButton("修改");
	private JButton btnDelete3 = new JButton("删除");
	
	
	
	private Object tblTitle[] = { "类别ID", "类别名称", "类别简介" };
	private Object tblTitle1[] = { "产品ID", "产品类别", "产品名称","产品价格","产品简介"};
	private Object tblTitle2[] = { "产品ID", "材料ID", "材料数量" };
	
	private Object tblData[][];
	private Object tblData2[][];
 	private Object tblData3[][];
 	
	DefaultTableModel tablmod = new DefaultTableModel();
	private JTable ProductTypeTable = new JTable(tablmod);
	
	DefaultTableModel tablmod2 = new DefaultTableModel();
	private JTable ProductTable = new JTable(tablmod2);
	
	DefaultTableModel tablmod3 = new DefaultTableModel();
	private JTable ProductFormTable = new JTable(tablmod3);
	
	List<ProductType> types;
	List<Product> products;
	List<Productform> forms;

	private void reloadTypeTable() {
		types = (new ProductTypeDao()).loadall();
		tblData = new Object[types.size()][3];
		for (int i = 0; i < types.size(); i++) {
			tblData[i][0] = types.get(i).getProductTypeID() + "";
			tblData[i][1] = types.get(i).getProductTypeName();
			tblData[i][2] = types.get(i).getProductTypeIntroduction() + "";
		}
		tablmod.setDataVector(tblData, tblTitle);
		this.ProductTypeTable.validate();
		this.ProductTypeTable.repaint();
	}
	
	private void reloadProductTable() {
		products = (new ProductDao()).loadall();
		tblData2 = new Object[products.size()][5];
		for (int i = 0; i < products.size(); i++) {
			tblData2[i][0] = products.get(i).getProductId() + "";
			tblData2[i][1] = products.get(i).getProductTypeID();
			tblData2[i][2] = products.get(i).getProductName() + "";
			tblData2[i][3] = products.get(i).getProductPrice();
			tblData2[i][4] = products.get(i).getProductIntroduction() + "";
		}
		tablmod2.setDataVector(tblData2, tblTitle1);
		this.ProductTable.validate();
		this.ProductTable.repaint();
	}
	
	
	private void reloadFormTable() {
		forms = (new ProductformDao()).loadall();
		tblData3 = new Object[forms.size()][3];
		for (int i = 0; i < forms.size(); i++) {
			tblData3[i][0] = forms.get(i).getProductId() + "";
			tblData3[i][1] = forms.get(i).getMaterialId();
			tblData3[i][2] = forms.get(i).getMaterialcount() + "";
		}
		tablmod3.setDataVector(tblData3, tblTitle2);
		this.ProductFormTable.validate();
		this.ProductFormTable.repaint();
	}
	
	public void details(int i,int j) {
		JDialog jf2222 = new JDialog(this, "详情", true);
		jf2222.setSize(320, 138);
		
		Toolkit kit = Toolkit.getDefaultToolkit();// 设置顶层容器框架为居中
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		int x = (width - 250) / 2;
		int y = (height - 250) / 2;
		jf2222.setLocation(x, y);
		
		JPanel contentPane222 = new JPanel();
		contentPane222.setLayout(new BorderLayout());
		JPanel p111 = new JPanel();
		jf2222.setContentPane(contentPane222);
		JTextArea brief222 = new JTextArea(5, 15);
		brief222.setEditable(true);
		brief222.setLineWrap(true);
		brief222.setText(tblData[i][j - 1].toString());
		brief222.setSize(300, 300);
		p111.add(brief222);
		contentPane222.add(p111);
		
		jf2222.setAlwaysOnTop(true);
		jf2222.setVisible(true);
	}
	
	public void details2(int i,int j) {
		JDialog jf2222 = new JDialog(this, "详情", true);
		jf2222.setSize(320, 138);
		
		Toolkit kit = Toolkit.getDefaultToolkit();// 设置顶层容器框架为居中
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		int x = (width - 250) / 2;
		int y = (height - 250) / 2;
		jf2222.setLocation(x, y);
		
		JPanel contentPane222 = new JPanel();
		contentPane222.setLayout(new BorderLayout());
		JPanel p111 = new JPanel();
		jf2222.setContentPane(contentPane222);
		JTextArea brief222 = new JTextArea(5, 15);
		brief222.setEditable(true);
		brief222.setLineWrap(true);
		brief222.setText(tblData2[i][j - 1].toString());
		brief222.setSize(300, 300);
		p111.add(brief222);
		contentPane222.add(p111);
		
		jf2222.setAlwaysOnTop(true);
		jf2222.setVisible(true);
	}
	
	public FrmProduct(JDialog f, String s, boolean b) {
		super(f, s, b);
		
		
		ImageIcon icon = new ImageIcon("src/model/1.jpg");
		JLabel label = new JLabel(icon);
		label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		JPanel j = (JPanel) this.getContentPane();
		j.setOpaque(false);
		
		
		toolBar1.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar1.add(btnAdd);
		toolBar1.add(btnModify);
		toolBar1.add(this.btnDelete);
		toolBar1.setOpaque(false);
		
		toolBar2.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar2.add(btnAdd2);
		toolBar2.add(btnModify2);
		toolBar2.add(this.btnDelete2);
		toolBar2.setOpaque(false);
		
		
		toolBar3.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar3.add(btnAdd3);
		toolBar3.add(btnModify3);
		toolBar3.add(this.btnDelete3);
		toolBar3.setOpaque(false);
		
		
		list1.setLayout(new BorderLayout());
		list1.add(toolBar1,BorderLayout.SOUTH);
		
		l1.setFont(new Font("宋体",Font.BOLD, 20));
		list1.add(l1,BorderLayout.NORTH);
		reloadTypeTable();
		list1.add(new JScrollPane(this.ProductTypeTable), BorderLayout.CENTER);
		list1.setOpaque(false);
		
		list2.setLayout(new BorderLayout());
		list2.add(toolBar2,BorderLayout.SOUTH);
		l2.setFont(new Font("宋体",Font.BOLD, 20));
		list2.add(l2,BorderLayout.NORTH);
		reloadProductTable();
		list2.add(new JScrollPane(this.ProductTable), BorderLayout.CENTER);
		list2.setOpaque(false);
		
		
		list3.setLayout(new BorderLayout());
		list3.add(toolBar3,BorderLayout.SOUTH);
		l3.setFont(new Font("宋体",Font.BOLD, 20));
		list3.add(l3,BorderLayout.NORTH);
		reloadFormTable();
		list3.add(new JScrollPane(this.ProductFormTable), BorderLayout.CENTER);
		list3.setOpaque(false);
		
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(list1, "West");
		getContentPane().add(list2, "Center");
		getContentPane().add(list3, "East");

		
		// 屏幕居中显示
		this.setSize(1500,800);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2, (int) (height - this.getHeight()) / 2);
		
		//details
		this.ProductTypeTable.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				int i = ProductTypeTable.getSelectedRow();
				if (i < 0) {
					return;
				}
				int j = ProductTypeTable.getSelectedColumn();
				j++;
				if (j == ProductTypeTable.getColumnCount()) {
					details(i,j);
				}
			}

		});

		//details
		this.ProductTable.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				int i = ProductTable.getSelectedRow();
				if (i < 0) {
					return;
				}
				int j = ProductTable.getSelectedColumn();
				j++;
				if (j == ProductTable.getColumnCount()) {
					details2(i,j);
				}
			}

		});
		
		
			this.validate();
		
		this.btnAdd.addActionListener(this);
		this.btnModify.addActionListener(this);
		this.btnDelete.addActionListener(this);
		this.btnAdd2.addActionListener(this);
		this.btnModify2.addActionListener(this);
		this.btnDelete2.addActionListener(this);
		this.btnAdd3.addActionListener(this);
		this.btnModify3.addActionListener(this);
		this.btnDelete3.addActionListener(this);
		
		
		
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// System.exit(0);
			}
		});


}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.btnAdd) {
			FrmProductTypeAdd add = new FrmProductTypeAdd(this, "产品类别增加", true);
			add.setVisible(true);
			if (add.getProductType() != null) {// 刷新表格
				this.reloadTypeTable();
			}
		} else if (e.getSource() == this.btnModify) {
			int i =this.ProductTypeTable.getSelectedRow();
			FrmProductTypeModify add= new FrmProductTypeModify(this, "产品类别修改", true, types.get(i));
			add.setVisible(true);
			if(add.getProductType()!=null)
				this.reloadTypeTable();
		} else if (e.getSource() == this.btnDelete) {
			int i = this.ProductTypeTable.getSelectedRow();
			if (i < 0) {
				JOptionPane.showMessageDialog(null, "请选择读者类别", "提示", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (JOptionPane.showConfirmDialog(this, "确定删除该类别吗？", "确认",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			
			(new ProductTypeManager()).deleteProductType(types.get(i));
			this.reloadTypeTable();

			}
		} else if (e.getSource() == this.btnAdd2) {
			FrmProductAdd add = new FrmProductAdd(this, "产品增加", true,types);
			add.setVisible(true);
			if (add.getProduct() != null) {// 刷新表格
				this.reloadProductTable();
			}
		} else if (e.getSource() == this.btnModify2) {
			int i = this.ProductTable.getSelectedRow();
			FrmProductModify add=new FrmProductModify(this, "", true, types,products.get(i));
			add.setVisible(true);
			if(add.getProduct()!=null)
				this.reloadProductTable();
		} else if (e.getSource() == this.btnDelete2) {
			int i = this.ProductTable.getSelectedRow();
			if (i < 0) {
				JOptionPane.showMessageDialog(null, "请选择读者类别", "提示", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (JOptionPane.showConfirmDialog(this, "确定删除该类别吗？", "确认",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
		
			(new ProductManager()).deleteProduct(products.get(i));
			this.reloadProductTable();

			}
		} else if (e.getSource() == this.btnAdd3) {
			FrmProductFormAdd add=new FrmProductFormAdd(this, "产品组成增加", true, products);
			add.setVisible(true);
			if (add.getProductForm() != null) {// 刷新表格
				this.reloadFormTable();
			}
		} else if (e.getSource() == this.btnModify3) {
			int i = this.ProductFormTable.getSelectedRow();
			FrmProductFormModify add=new FrmProductFormModify(this, "产品组成修改", true, products, forms.get(i));
			add.setVisible(true);
			if(add.getProductForm()!=null)
				this.reloadFormTable();
		} else if (e.getSource() == this.btnDelete3) {
			int i = this.ProductFormTable.getSelectedRow();
			if (i < 0) {
				JOptionPane.showMessageDialog(null, "请选择读者类别", "提示", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (JOptionPane.showConfirmDialog(this, "确定删除该类别吗？", "确认",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
		
			(new ProductFormManager()).deleteform(forms.get(i));
			this.reloadFormTable();

			}
		}  	
}

}
