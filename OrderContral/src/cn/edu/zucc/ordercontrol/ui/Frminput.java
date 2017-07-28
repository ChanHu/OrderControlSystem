package cn.edu.zucc.ordercontrol.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.util.Iterator;
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

import cn.edu.zucc.ordercontrol.control.ProduceManager;
import cn.edu.zucc.ordercontrol.control.ProductFormManager;
import cn.edu.zucc.ordercontrol.control.StockInputManager;
import cn.edu.zucc.ordercontrol.control.StockOfMaterialManager;
import cn.edu.zucc.ordercontrol.control.StockOfProductManager;
import cn.edu.zucc.ordercontrol.control.StockOutputManager;
import cn.edu.zucc.ordercontrol.dao.ProduceDao;
import cn.edu.zucc.ordercontrol.dao.StockInputDao;
import cn.edu.zucc.ordercontrol.dao.StockOfMaterialDao;
import cn.edu.zucc.ordercontrol.dao.StockOfProductDao;
import cn.edu.zucc.ordercontrol.dao.StockOutputDao;
import cn.edu.zucc.ordercontrol.model.Produce;
import cn.edu.zucc.ordercontrol.model.Productform;
import cn.edu.zucc.ordercontrol.model.StockInput;
import cn.edu.zucc.ordercontrol.model.StockOfMaterial;
import cn.edu.zucc.ordercontrol.model.StockOfProduct;
import cn.edu.zucc.ordercontrol.model.StockOutput;
import cn.edu.zucc.ordercontrol.uti.BusinessException;

public class Frminput extends JDialog implements ActionListener {
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
	private JPanel list4 = new JPanel();
	private JPanel list5 = new JPanel();
	private JPanel list = new JPanel();
	private JPanel toolBar4 = new JPanel();
	private JPanel toolBar5 = new JPanel();
	private JLabel l1= new JLabel("                材料库存");
	private JLabel l2= new JLabel("                       产品库存");
	private JLabel l3= new JLabel("                采购信息");
	private JLabel l4= new JLabel("                出售信息");
	private JLabel l5= new JLabel("                生产信息");

	
	private JButton btnAdd = new JButton("添加");
	private JButton btnModify = new JButton("完成");
	private JButton btnDelete = new JButton("删除");
	private JButton btnDelete11 = new JButton("销毁");

	private JButton btnAdd2 = new JButton("添加");
	private JButton btnModify2 = new JButton("完成");
	private JButton btnDelete2 = new JButton("删除");
	private JButton btnDelete22 = new JButton("销毁");
	
	private JButton btnAdd3 = new JButton("添加");
	private JButton btnModify3 = new JButton("完成");
	private JButton btnDelete3 = new JButton("删除");
	private JButton btnDelete33 = new JButton("销毁");
	
	private JButton btnSearch1 = new JButton("查询");
	private JButton btnSearch2 = new JButton("查询");
	private JButton btnSearch3 = new JButton("查询");
	private JButton btnSearch4 = new JButton("查询");
	private JButton btnSearch5 = new JButton("查询");

	
	
	private JTextArea textArea1= new JTextArea();
	private JTextArea textArea2= new JTextArea();
	private JTextArea textArea11= new JTextArea();
	private JTextArea textArea22= new JTextArea();
	private JTextArea textArea3= new JTextArea();
	private JTextArea textArea4= new JTextArea();
	private JTextArea textArea5= new JTextArea();
	
	private Object tblTitle[] = { "材料ID", "采购ID", "采购时间","采购数量","完成情况" };
	private Object tblTitle1[] = { "储存ID", "材料ID", "储存数量","储存地址"};
	private Object tblTitle2[] = { "产品ID", "销售ID", "销售时间","销售数量","完成情况" };
	private Object tblTitle3[] = { "储存ID", "产品ID", "储存数量","储存地址"};
	private Object tblTitle4[] = { "生产ID", "产品ID", "生产时间","生产数量","完成情况" };

	
	
	private Object tblData[][];
	private Object tblData2[][];
	private Object tblData3[][];
	private Object tblData4[][];
	private Object tblData5[][];

	
	
 	
	DefaultTableModel tablmod = new DefaultTableModel();
	private JTable inputTable = new JTable(tablmod);
	
	DefaultTableModel tablmod2 = new DefaultTableModel();
	private JTable stockTable = new JTable(tablmod2);
	
	DefaultTableModel tablmod3 = new DefaultTableModel();
	private JTable outputTable = new JTable(tablmod3);
	
	DefaultTableModel tablmod4 = new DefaultTableModel();
	private JTable stockTable2 = new JTable(tablmod4);
	
	DefaultTableModel tablmod5 = new DefaultTableModel();
	private JTable produceTable = new JTable(tablmod5);
	
	
	List<StockInput> inputs;
	List<StockOfMaterial> materials;
	List<StockOutput> outputs;
	List<StockOfProduct> products;
	List<Produce> produces;
	

	private void reloadinputTable() {
		if (textArea3.getText().equals("materialid"))
			textArea3.setText("");
		if (textArea3.getText().equals("") )
			inputs = (new StockInputDao()).loadall();
		else
			inputs = (new StockInputManager()).searchStockInput(textArea3.getText(), "");
		
		
		
		tblData = new Object[inputs.size()][5];
		for (int i = 0; i < inputs.size(); i++) {
			tblData[i][0] = inputs.get(i).getMaterialId() + "";
			tblData[i][1] = inputs.get(i).getStockInputID();
			tblData[i][2] = inputs.get(i).getStockInputDate() + "";
			tblData[i][3] = inputs.get(i).getStockInputCount() + "";
			tblData[i][4] = inputs.get(i).isStockInputFinish() + "";
		}
		tablmod.setDataVector(tblData, tblTitle);
		if (textArea3.getText() == null || textArea3.getText().equals(""))
			textArea3.setText("materialid");
		this.inputTable.validate();
		this.inputTable.repaint();
	}

	
	private void reloadMaterialTable() {
		
		//System.out.println(1);
		if (textArea1.getText().equals("id"))
				textArea1.setText("");
		if (textArea11.getText().equals("address"))
				textArea11.setText("");
		if (textArea1.getText().equals("") && textArea11.getText().equals(""))
			materials = (new StockOfMaterialDao()).loadall();
		else
			materials = (new StockOfMaterialManager()).searchStockOfMaterial(textArea1.getText(), textArea11.getText());
		
		tblData2 = new Object[materials.size()][4];
		for (int i = 0; i < materials.size(); i++) {
			tblData2[i][0] = materials.get(i).getStockOfMaterialId() + "";
			tblData2[i][1] = materials.get(i).getMaterialId();
			tblData2[i][2] = materials.get(i).getStockOfMaterialCount()+ "";
			tblData2[i][3] = materials.get(i).getStockOfMaterialAddress();
		}
		tablmod2.setDataVector(tblData2, tblTitle1);
		if (textArea1.getText() == null || textArea1.getText().equals(""))
			textArea1.setText("id");
		if (textArea11.getText() == null || textArea11.getText().equals(""))
			textArea11.setText("address");
		
		
		this.stockTable.validate();
		this.stockTable.repaint();
	}
	
	
	

	
	private void reloadoutputTable() {
		if (textArea4.getText().equals("productid"))
			textArea4.setText("");
		if (textArea4.getText().equals("") )
			outputs = (new StockOutputDao()).loadall();
		else
			outputs = (new StockOutputManager()).searchStockOutput(textArea4.getText(), "");
		
		
		tblData3 = new Object[outputs.size()][5];
		for (int i = 0; i < outputs.size(); i++) {
			tblData3[i][0] = outputs.get(i).getProductId() + "";
			tblData3[i][1] = outputs.get(i).getStockOutputID();
			tblData3[i][2] = outputs.get(i).getStockOutputDate()+ "";
			tblData3[i][3] = outputs.get(i).getStockOutputCount();
			tblData3[i][4] = outputs.get(i).isStockOutputFinish();
		}
		tablmod3.setDataVector(tblData3, tblTitle2);
		if (textArea4.getText() == null || textArea4.getText().equals(""))
			textArea4.setText("productid");
		this.outputTable.validate();
		this.outputTable.repaint();
	}
	
	private void reloadProductTable() {
		
		if (textArea2.getText().equals("id"))
			textArea2.setText("");
		if (textArea22.getText().equals("address"))
			textArea22.setText("");
		if (textArea2.getText().equals("") && textArea22.getText().equals(""))
			products = (new StockOfProductDao()).loadall();
		else
			products = (new StockOfProductManager()).searchStockOfProduct(textArea2.getText(), textArea22.getText());
	
		products = (new StockOfProductDao()).loadall();
		tblData4 = new Object[products.size()][4];
		for (int i = 0; i < products.size(); i++) {
			tblData4[i][0] = products.get(i).getStockOfProductID() + "";
			tblData4[i][1] = products.get(i).getProductId();
			tblData4[i][2] = products.get(i).getStockOfProductCount()+ "";
			tblData4[i][3] = products.get(i).getStockOfProductAddress();
		}
		tablmod4.setDataVector(tblData4, tblTitle3);

		if (textArea2.getText() == null || textArea2.getText().equals(""))
			textArea2.setText("id");

		
			
		if (textArea22.getText() == null || textArea22.getText().equals(""))
			textArea22.setText("address");
		
		
		this.stockTable2.validate();
		this.stockTable2.repaint();
	}
	
	private void reloadProduceTable() {
		
		if (textArea5.getText().equals("productid"))
			textArea5.setText("");
		if (textArea5.getText().equals("") )
			produces = (new ProduceDao()).loadall();
		else
			produces = (new ProduceManager()).searchProduce("",textArea5.getText());
		
		tblData5 = new Object[produces.size()][5];
		for (int i = 0; i < produces.size(); i++) {
			tblData5[i][0] = produces.get(i).getProduceId() + "";
			tblData5[i][1] = produces.get(i).getProductId();
			tblData5[i][2] = produces.get(i).getProduceDate()+ "";
			tblData5[i][3] = produces.get(i).getProduceCount();
			tblData5[i][4] = produces.get(i).isProduceFinish();
		}
		tablmod5.setDataVector(tblData5, tblTitle4);
		if (textArea5.getText() == null || textArea5.getText().equals(""))
			textArea5.setText("productid");
		this.produceTable.validate();
		this.produceTable.repaint();
	}
	
	
	public Frminput(JDialog f, String s, boolean b) {
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
		toolBar1.add(this.btnDelete11);
		toolBar1.add(btnSearch3);
		toolBar1.add(textArea3);
		textArea3.setColumns(10);
		toolBar1.setOpaque(false);
		
		toolBar2.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar2.add(btnAdd2);
		toolBar2.add(btnModify2);
		toolBar2.add(this.btnDelete2);
		toolBar2.add(this.btnDelete22);
		toolBar2.add(btnSearch4);
		toolBar2.add(textArea4);
		textArea4.setColumns(10);
		toolBar2.setOpaque(false);
		
		toolBar3.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar3.add(btnAdd3);
		toolBar3.add(btnModify3);
		toolBar3.add(this.btnDelete3);
		toolBar3.add(this.btnDelete33);
		toolBar3.add(btnSearch5);
		toolBar3.add(textArea5);
		textArea5.setColumns(10);
		toolBar3.setOpaque(false);
		
		toolBar4.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar4.add(btnSearch1);
		toolBar4.add(textArea1);
		toolBar4.add(textArea11);
		textArea1.setColumns(10);
		textArea11.setColumns(10);
		toolBar4.setOpaque(false);
		
		toolBar5.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar5.add(btnSearch2);
		toolBar5.add(textArea2);
		toolBar5.add(textArea22);
		textArea2.setColumns(10);
		textArea22.setColumns(10);
		toolBar5.setOpaque(false);
		
		list1.setLayout(new BorderLayout());
		l1.setFont(new Font("宋体",Font.BOLD, 20));
		list1.add(l1,BorderLayout.NORTH);
		list1.add(toolBar4, BorderLayout.SOUTH);
		list1.add(new JScrollPane(this.stockTable), BorderLayout.CENTER);
		list1.setOpaque(false);
		reloadMaterialTable();
		
		list2.setLayout(new BorderLayout());
		l2.setFont(new Font("宋体",Font.BOLD, 20));
		list2.add(l2,BorderLayout.NORTH);
		list2.add(toolBar5, BorderLayout.SOUTH);
		list2.add(new JScrollPane(this.stockTable2), BorderLayout.CENTER);
		list2.setOpaque(false);
		reloadProductTable();
		
		list3.setLayout(new BorderLayout());
		l3.setFont(new Font("宋体",Font.BOLD, 20));
		list3.add(l3, BorderLayout.NORTH);
		list3.add(toolBar1, BorderLayout.SOUTH);
		list3.add(new JScrollPane(this.inputTable), BorderLayout.CENTER);
		list3.setOpaque(false);
		reloadinputTable();
		
		list4.setLayout(new BorderLayout());
		l4.setFont(new Font("宋体",Font.BOLD, 20));
		list4.add(l4, BorderLayout.NORTH);
		list4.add(toolBar2, BorderLayout.SOUTH);
		list4.add(new JScrollPane(this.outputTable), BorderLayout.CENTER);
		list4.setOpaque(false);
		reloadoutputTable();
		
		list5.setLayout(new BorderLayout());
		l5.setFont(new Font("宋体",Font.BOLD, 20));
		list5.add(l5, BorderLayout.NORTH);
		list5.add(toolBar3, BorderLayout.SOUTH);
		list5.add(new JScrollPane(this.produceTable), BorderLayout.CENTER);
		list5.setOpaque(false);
		reloadProduceTable();
		
		list.setLayout(new GridLayout(3,1));
		list.add(list3, BorderLayout.NORTH);
		list.add(list4, BorderLayout.CENTER);
		list.add(list5, BorderLayout.SOUTH);
		list.setOpaque(false);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(list1,"West");
		getContentPane().add(list2,"Center");
		getContentPane().add(list,"East");

		
		// 屏幕居中显示
		this.setSize(1500,800);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2, (int) (height - this.getHeight()) / 2);		
		
		
			this.validate();
		
		this.btnAdd.addActionListener(this);
		this.btnModify.addActionListener(this);
		this.btnDelete.addActionListener(this);
		this.btnDelete11.addActionListener(this);
		this.btnDelete22.addActionListener(this);
		this.btnDelete33.addActionListener(this);
		this.btnAdd2.addActionListener(this);
		this.btnModify2.addActionListener(this);
		this.btnDelete2.addActionListener(this);
		this.btnAdd3.addActionListener(this);
		this.btnModify3.addActionListener(this);
		this.btnDelete3.addActionListener(this);
		
		this.btnSearch1.addActionListener(this);
		this.btnSearch2.addActionListener(this);
		this.btnSearch3.addActionListener(this);
		this.btnSearch4.addActionListener(this);
		this.btnSearch5.addActionListener(this);
		
		
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
			Frminputadd add=new Frminputadd(this, "采购订单", true);
			add.setVisible(true);
			if (add.getinput() != null) {// 刷新表格
				this.reloadinputTable();
			}
		} else if (e.getSource() == this.btnModify) {
			int i =this.inputTable.getSelectedRow();
			StockInput old=inputs.get(i);
			StockInput new1 =old;
			if(old.isStockInputFinish()==false)
			{
				new1.setStockInputFinish(true);
				try {
					(new StockInputManager()).modifyStockInput(new1,old);
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String address = JOptionPane.showInputDialog("Please input address");
				StockOfMaterial aMaterial=new StockOfMaterial();
				aMaterial.setMaterialId(new1.getMaterialId());
				aMaterial.setStockOfMaterialAddress(address);
				aMaterial.setStockOfMaterialCount(new1.getStockInputCount());
				aMaterial.setStockOfMaterialId(new1.getStockInputID());
				(new StockOfMaterialDao()).CreateStockOfMaterial(aMaterial);
				
				reloadinputTable();
				reloadMaterialTable();
			}
			
			
		} else if (e.getSource() == this.btnDelete) {
			int i =this.inputTable.getSelectedRow();
			if (i < 0) {
				JOptionPane.showMessageDialog(null, "请选择读者类别", "提示", JOptionPane.ERROR_MESSAGE);
				return;
			}
			StockInput old=inputs.get(i);
			if(old.isStockInputFinish()==false)
			{
				
				if (JOptionPane.showConfirmDialog(this, "确定删除该类别吗？", "确认",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				
				(new StockInputManager()).deleteStockInput(old);
				this.reloadinputTable();

				}
			}else {
				JOptionPane.showMessageDialog(null, "该订单已完成，无法删除", "操作失败 ", JOptionPane.ERROR_MESSAGE); 
			}
			
		}else if (e.getSource() == this.btnDelete11) {
			int i =this.inputTable.getSelectedRow();
			if (i < 0) {
				JOptionPane.showMessageDialog(null, "请选择读者类别", "提示", JOptionPane.ERROR_MESSAGE);
				return;
			}
			StockInput old=inputs.get(i);
				if (JOptionPane.showConfirmDialog(this, "确定删除吗？", "确认",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				
				(new StockInputManager()).deleteStockInput(old);
				this.reloadinputTable();

				}
			
		}else if (e.getSource()==this.btnSearch1){ 
			reloadMaterialTable();
		}else if (e.getSource()==this.btnSearch2){ 
			reloadProductTable();
		}else if (e.getSource()==this.btnSearch3){ 
			reloadinputTable();
		}else if (e.getSource()==this.btnSearch4){ 
			reloadoutputTable();
		}else if (e.getSource()==this.btnSearch5){ 
			reloadProduceTable();
		}else if (e.getSource()==this.btnAdd3){
			Frmproduceadd add=new Frmproduceadd(this, "增加生产订单", true);
			add.setVisible(true);
			if (add.getinput() != null) {// 刷新表格
				this.reloadProduceTable();
			}
		}else if (e.getSource()==this.btnModify3){
			//judge finish
			int i=produceTable.getSelectedRow();
			Produce aProduce=produces.get(i);
			if(aProduce.isProduceFinish()==true)
				return ;
			
			//judge right
			int cnt=Integer.parseInt(aProduce.getProduceCount());
			int flag=1;
			List<Productform> list=(new ProductFormManager()).searchform(aProduce.getProductId(),"");
			Iterator<Productform> iterator=list.iterator();
			while(iterator.hasNext())
			{
				Productform aProductform=iterator.next();
				int needcnt=Integer.parseInt(aProductform.getMaterialcount())*cnt;
				
				int allcnt=0;
				List<StockOfMaterial> ll=(new StockOfMaterialManager()).searchStockOfMaterial(aProductform.getMaterialId(),"");
				Iterator<StockOfMaterial> iterator2=ll.iterator();
				while(iterator2.hasNext())
				{
					StockOfMaterial aMaterial=iterator2.next();
					allcnt+=Integer.parseInt(aMaterial.getStockOfMaterialCount());
				}
				if(allcnt<needcnt) {
					flag=0; 
					break;
				}
			}
			
			//produce
			if(flag==1){
				list=(new ProductFormManager()).searchform(aProduce.getProductId(),"");
				iterator=list.iterator();
				while(iterator.hasNext()){
					Productform aProductform=iterator.next();
					int needcnt=Integer.parseInt(aProductform.getMaterialcount())*cnt;
					
					
					List<StockOfMaterial> ll=(new StockOfMaterialManager()).searchStockOfMaterial(aProductform.getMaterialId(),"");
					Iterator<StockOfMaterial> iterator2=ll.iterator();
					while(iterator2.hasNext())
					{
						StockOfMaterial aMaterial=iterator2.next();
						Integer ccnt= Integer.parseInt(aMaterial.getStockOfMaterialCount());
						if(needcnt>=ccnt){
							needcnt-=ccnt;
							(new StockOfMaterialManager()).deleteStockOfMaterial(aMaterial);
						}else if(needcnt<ccnt){
							ccnt-=needcnt;
							needcnt=0;
							aMaterial.setStockOfMaterialCount(ccnt.toString());
							try {
								(new StockOfMaterialManager()).modifyStockOfMaterial(aMaterial, aMaterial);
							} catch (BusinessException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						if(needcnt==0) break;
					}
						
					aProduce.setProduceDate(new Date(System.currentTimeMillis()));
					aProduce.setProduceFinish(true);
					try {
						(new ProduceManager()).modifyProduce(aProduce, aProduce);
					} catch (BusinessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			// add product 
				
				String address = JOptionPane.showInputDialog("Please input prouct address");
				StockOfProduct aProduct=new StockOfProduct();
				aProduct.setProductId(aProduce.getProductId());
				aProduct.setStockOfProductAddress(address);
				aProduct.setStockOfProductID(aProduce.getProduceId());
				aProduct.setStockOfProductCount(aProduce.getProduceCount());
				try {
					(new StockOfProductManager()).CreateStockOfProduct(aProduct);
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				reloadProductTable();
				reloadMaterialTable();
				reloadProduceTable();
			}
			else if(flag==0){
				JOptionPane.showMessageDialog(null, "材料不足", "操作失败 ", JOptionPane.ERROR_MESSAGE);
			}
		}else if (e.getSource()==this.btnDelete3){
			int i=produceTable.getSelectedRow();
			Produce aProduce=produces.get(i);
			if(aProduce.isProduceFinish()==false){
				(new ProduceManager()).deleteProduce(aProduce);
				reloadProduceTable();
			}else{
				JOptionPane.showMessageDialog(null, "订单已完成", "操作失败 ", JOptionPane.ERROR_MESSAGE);
			}
		}else if (e.getSource()==this.btnDelete33){
			int i=produceTable.getSelectedRow();
			Produce aProduce=produces.get(i);
			if (JOptionPane.showConfirmDialog(this, "确定删除吗？", "确认",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				(new ProduceManager()).deleteProduce(aProduce);
				reloadProduceTable();
			}
		}else if (e.getSource()==this.btnAdd2){
			Frmoutputadd add=new Frmoutputadd(this, "出售订单添加", true);
			add.setVisible(true);
			if(add.getoutput()!=null)
				this.reloadoutputTable();
		}else if (e.getSource()==this.btnModify2){
			int i=outputTable.getSelectedRow();
			StockOutput aOutput=new StockOutput();
			aOutput=outputs.get(i);
			//check
			Integer allcnt=Integer.valueOf(aOutput.getStockOutputCount());
			List<StockOfProduct> l1=(new StockOfProductManager()).searchStockOfProduct(aOutput.getProductId(), "");
			Iterator<StockOfProduct> iterator=l1.iterator();
			Integer rcnt=0;
			while(iterator.hasNext()){
				StockOfProduct aOfProduct=iterator.next();
				rcnt+=Integer.valueOf(aOfProduct.getStockOfProductCount());
			}
			if(rcnt<allcnt){
				JOptionPane.showMessageDialog(null, "产品不足", "操作失败 ", JOptionPane.ERROR_MESSAGE);
			}else{
			//output
				l1=(new StockOfProductManager()).searchStockOfProduct(aOutput.getProductId(), "");
				iterator=l1.iterator();
				while(iterator.hasNext()){
					StockOfProduct aOfProduct=iterator.next();
					if(allcnt>=rcnt){
						allcnt-=rcnt;
						(new StockOfProductManager()).deleteStockOfProduct(aOfProduct);
					}else{
						rcnt-=allcnt;
						aOfProduct.setStockOfProductCount(rcnt.toString());
						try {
							(new StockOfProductManager()).modifyStockOfProduct(aOfProduct, aOfProduct);
						} catch (BusinessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
			//
			reloadProductTable();
			try {
				aOutput.setStockOutputDate(new Date(System.currentTimeMillis()));
				aOutput.setStockOutputFinish(true);
				(new StockOutputManager()).modifyStockOutput(aOutput, aOutput);
			} catch (BusinessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if (e.getSource()==this.btnDelete2){
			int i=outputTable.getSelectedRow();
			StockOutput aOutput=new StockOutput();
			aOutput=outputs.get(i);
			if(aOutput.isStockOutputFinish()==true){
				JOptionPane.showMessageDialog(null, "订单已完成", "操作失败 ", JOptionPane.ERROR_MESSAGE);
			}else{
				(new StockOutputManager()).deleteStockOutput(aOutput);
				reloadoutputTable();
			}
		}else if (e.getSource()==this.btnDelete22){
			int i=outputTable.getSelectedRow();
			StockOutput aOutput=new StockOutput();
			aOutput=outputs.get(i);
			if (JOptionPane.showConfirmDialog(this, "确定删除吗？", "确认",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				(new StockOutputManager()).deleteStockOutput(aOutput);
				reloadoutputTable();
			}
		}
}

}
