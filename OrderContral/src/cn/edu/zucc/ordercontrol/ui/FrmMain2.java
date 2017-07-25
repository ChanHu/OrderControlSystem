package cn.edu.zucc.ordercontrol.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.ordercontrol.dao.MaterialDao;
import cn.edu.zucc.ordercontrol.dao.SupplierDao;
import cn.edu.zucc.ordercontrol.model.Material;
import cn.edu.zucc.ordercontrol.model.Supplier;
import cn.edu.zucc.ordercontrol.uti.BaseException;

public class FrmMain2 extends JFrame implements ActionListener {
	static final int WIDTH=1500;
    static final int HEIGHT=800;
    String flag=null;
	private JMenuBar menubar=new JMenuBar(); 
	
	
	
	
    private JButton Button_Supplier=new JButton("厂商管理");
    private JButton Button_Material=new JButton("材料管理");
    private JButton Button_ProductInfo=new JButton("产品信息管理");
    private JButton Button_ProductForm=new JButton("产品组成管理");
    private JButton Button_productType=new JButton("产品种类管理");
    private JButton Button_Customer=new JButton("消费者管理");
    
    private JButton Button_Input=new JButton("采购管理");
    private JButton Button_Output=new JButton("出售管理");
    private JButton Button_Produce=new JButton("生产");
    
    private JButton Button_order=new JButton("订单查询");
    private JButton Button_Stock=new JButton("库存查询");
    
    JButton button_Function_add=new JButton("增加");
    JButton button_Function_modify=new JButton("修改");
    JButton button_Function_delete=new JButton("删除");
    JButton button_Function_search=new JButton("查询");
    JTextField text1=new JTextField();
 
//	private JPanel statusBar = new JPanel();
    
    
    private Object tblTitleOfSupplier[]={"供货商编号","供货商名称","供货商地址","供货商联系人","供货商电话","供货商简介"};
    private Object tbltitleOfMaterial[]={"材料编号","供货商编号","材料名字","材料价格","材料简介"};
    private Object tbltitleOfProduct[]={"材料编号","供货商编号","材料名字","材料价格","材料简介"};
    private Object tbltitleOfProductForm[]={"材料编号","供货商编号","材料名字","材料价格","材料简介"};
    private Object tbltitleOfProductType[]={"材料编号","供货商编号","材料名字","材料价格","材料简介"};
    private Object tbltitleOfCustomer[]={"材料编号","供货商编号","材料名字","材料价格","材料简介"};

    
    List<Supplier> pubs;
	List<Material> pubsOfMaterial;
    
	
	
	private Object tblData[][];
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable dataTable=new JTable(tablmod);
	
	private void reloadSupplierTable() throws BaseException{
		pubs=(new SupplierDao()).loadall();
		tblData =new Object[pubs.size()][6];
		for(int i=0;i<pubs.size();i++){
			tblData[i][0]=pubs.get(i).getSupplierID()+"";
			tblData[i][1]=pubs.get(i).getSupplierName();
			tblData[i][2]=pubs.get(i).getSupplierAddress();
			tblData[i][3]=pubs.get(i).getSupplierContacts()+"";
			tblData[i][4]=pubs.get(i).getSupplierPhone();
			tblData[i][5]=pubs.get(i).getSupplierBriefIntroduction();
		}
		tablmod.setDataVector(tblData,tblTitleOfSupplier);
		this.dataTable.validate();
		this.dataTable.repaint();
	}
    
    
	private void reloadMaterialTable() throws BaseException{
		pubsOfMaterial=(new MaterialDao()).loadall();
		tblData =new Object[pubs.size()][5];
		for(int i=0;i<pubs.size();i++){
			tblData[i][0]=pubsOfMaterial.get(i).getMaterialId()+"";
			tblData[i][1]=pubsOfMaterial.get(i).getSupplierID();
			tblData[i][2]=pubsOfMaterial.get(i).getMaterialName();
			tblData[i][3]=pubsOfMaterial .get(i).getMaterialGuidePrice()+"";
			tblData[i][4]=pubsOfMaterial .get(i).getMaterialIntroduction();
		}
		tablmod.setDataVector(tblData,tbltitleOfMaterial);
		this.dataTable.validate();
		this.dataTable.repaint();
	}
    
    
    
    
    
    
    
    
    
	public FrmMain2(){
		JFrame jf=new JFrame("生产管理系统");
        jf.setSize(WIDTH,HEIGHT);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置其顶层容器的关闭性

        Toolkit kit=Toolkit.getDefaultToolkit();//设置顶层容器框架为居中
        Dimension screenSize=kit.getScreenSize();
        int width=screenSize.width;
        int height=screenSize.height;
        int x=(width-WIDTH)/2;
        int y=(height-HEIGHT)/2;
        jf.setLocation(x,y);
        
        
        
        
        
        
        JPanel contentPane=new JPanel();
        contentPane.setLayout(new FlowLayout());
        JPanel p1=new JPanel();
        jf.setContentPane(contentPane);
		
		
		
        //contentPane.setLayout(new GridLayout(0, 1)); // 设置为网格布局，未指定行数
		//setFont(new Font("Helvetica", Font.PLAIN, 18));
        contentPane.setLayout(new BorderLayout());
        
        p1.setLayout(new FlowLayout());
		p1.add(new JLabel("                系统管理"));
		p1.add(Button_Supplier);
		p1.add(Button_Material);
		p1.add(Button_ProductInfo);
		p1.add(Button_productType);
		p1.add(Button_ProductForm);
		p1.add(Button_Customer);
		p1.add(new JLabel("                       生产管理"));
		p1.add(Button_Input);
		p1.add(Button_Output);
		p1.add(Button_Produce);
		p1.add(new JLabel("                       查询统计"));
		p1.add(Button_order);
		p1.add(Button_Stock);
		contentPane.add(p1, "North");
		//jf.pack();
		
		
		JPanel p2=new JPanel();

		p2.add(button_Function_add);
		p2.add(button_Function_delete);
		p2.add(button_Function_modify);
		p2.add(button_Function_search);
		text1.setColumns(10);
		p2.add(text1);
		contentPane.add(p2,"South");
		
		//this.getContentPane().add(new JScrollPane(this.dataTable), BorderLayout.CENTER);
		contentPane.add(new JScrollPane(dataTable),"Center");
		
		
		Button_Supplier.addActionListener(this);
		Button_Material.addActionListener(this);
		Button_ProductInfo.addActionListener(this);
		Button_productType.addActionListener(this);
		Button_ProductForm.addActionListener(this);
		Button_Customer.addActionListener(this);
		Button_Input.addActionListener(this);
		Button_Output.addActionListener(this);
		Button_order.addActionListener(this);
		Button_Stock.addActionListener(this);
		Button_Produce.addActionListener(this);
		button_Function_add.addActionListener(this);
		button_Function_delete.addActionListener(this);
		button_Function_modify.addActionListener(this);
		button_Function_search.addActionListener(this);
		
		
		
		
		
		jf.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.Button_Supplier)
		{
			flag="Supplier";
			try {
				reloadSupplierTable();
				
			} catch (BaseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else if (e.getSource()==this.Button_Material)
		{
			flag="Material";
			
			try {
				reloadMaterialTable();
			} catch (BaseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if (e.getSource()==this.Button_ProductInfo){
			flag="ProductInfo";
		}else if (e.getSource()==this.Button_productType){
			flag="ProductType";
		}else if (e.getSource()==this.Button_Customer){
			flag="Customer";
		}else if (e.getSource()==this.Button_Input){
			flag="Input";
		}else if (e.getSource()==this.Button_Output){
			flag="OutPut";
		}else if (e.getSource()==this.Button_order){
			flag="Order";
		}else if (e.getSource()==this.Button_Stock){
			flag="Stock";
		}else if(e.getSource()==this.button_Function_add){
			if(flag.equals("Supplier")){
				
			}else if(flag.equals("Material")){
				
			}else if(flag.equals("ProductInfo")){
				
			}else if(flag.equals("ProductType")){
				
			}else if(flag.equals("Customer")){
				
			}else if(flag.equals("Input")){
				
			}else if(flag.equals("OutPut")){
				
			}else if(flag.equals("Order")){
				
			}else if(flag.equals("Stock")){
				
			}
			
		}else if(e.getSource()==this.button_Function_delete){
			if(flag.equals("Supplier")){
				
			}else if(flag.equals("Material")){
				
			}else if(flag.equals("ProductInfo")){
				
			}else if(flag.equals("ProductType")){
				
			}else if(flag.equals("Customer")){
				
			}else if(flag.equals("Input")){
				
			}else if(flag.equals("OutPut")){
				
			}else if(flag.equals("Order")){
				
			}else if(flag.equals("Stock")){
				
			}
		}else if(e.getSource()==this.button_Function_modify){
			if(flag.equals("Supplier")){
				
			}else if(flag.equals("Material")){
				
			}else if(flag.equals("ProductInfo")){
				
			}else if(flag.equals("ProductType")){
				
			}else if(flag.equals("Customer")){
				
			}else if(flag.equals("Input")){
				
			}else if(flag.equals("OutPut")){
				
			}else if(flag.equals("Order")){
				
			}else if(flag.equals("Stock")){
				
			}
		}else if(e.getSource()==this.button_Function_search)
		{
			if(flag.equals("Supplier")){
				
			}else if(flag.equals("Material")){
				
			}else if(flag.equals("ProductInfo")){
				
			}else if(flag.equals("ProductType")){
				
			}else if(flag.equals("Customer")){
				
			}else if(flag.equals("Input")){
				
			}else if(flag.equals("OutPut")){
				
			}else if(flag.equals("Order")){
				
			}else if(flag.equals("Stock")){
				
			}
		}
	}
}
