package cn.edu.zucc.ordercontrol.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.ordercontrol.control.MaterialManager;
import cn.edu.zucc.ordercontrol.control.SupplierManager;
import cn.edu.zucc.ordercontrol.dao.MaterialDao;
import cn.edu.zucc.ordercontrol.dao.SupplierDao;
import cn.edu.zucc.ordercontrol.model.Material;
import cn.edu.zucc.ordercontrol.model.Supplier;
import cn.edu.zucc.ordercontrol.uti.BaseException;

public class FrmMain2 extends JDialog implements ActionListener {
	static final int WIDTH=1500;
    static final int HEIGHT=800;
    String flag=null;
	
    private JButton Button_Supplier=new JButton("厂商");
    private JButton Button_Material=new JButton("材料");
    private JButton Button_ProductInfo=new JButton("产品信息");
    private JButton Button_ProductForm=new JButton("产品组成");
    private JButton Button_productType=new JButton("产品种类");
    private JButton Button_Customer=new JButton("消费者");
    
    private JButton Button_Input=new JButton("采购");
    private JButton Button_Output=new JButton("出售");
    private JButton Button_Produce=new JButton("生产");
    
    private JButton Button_order=new JButton("订单查询");
    private JButton Button_Stock=new JButton("库存查询");
    
    JButton button_Function_add=new JButton("增加");
    JButton button_Function_modify=new JButton("修改");
    JButton button_Function_delete=new JButton("删除");
    JButton button_Function_search=new JButton("查询");
    JTextArea text1=new JTextArea();
    JTextArea text2=new JTextArea();
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

	
	
	
	void reloadSupplierTable() throws BaseException{
		if(text1.getText().equals("name"))
			text1.setText("");
		if(text2.getText().equals("address"))
			text2.setText("");
		if(text1.getText().equals("")&&text2.getText().equals(""))
			pubs=(new SupplierDao()).loadall();
		else 
			pubs=(new SupplierManager()).searchSupplier(text1.getText(), text2.getText());
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
		if(text1.getText()==null||text1.getText().equals(""))
			text1.setText("name");
		if(text2.getText()==null||text2.getText().equals(""))
			text2.setText("address");
		this.dataTable.validate();
		this.dataTable.repaint();
	}
    
	void reloadMaterialTable() throws BaseException{
		if(text1.getText().equals("MaterialId"))
			text1.setText("");
		if(text2.getText().equals("SupplierID"))
			text2.setText("");
		if(text1.getText().equals("")&&text2.getText().equals(""))
			pubsOfMaterial=(new MaterialDao()).loadall();
		else 
			pubsOfMaterial=(new MaterialManager()).searchMaterial(text1.getText(), text2.getText());
		
		tblData =new Object[pubsOfMaterial.size()][5];
		for(int i=0;i<pubsOfMaterial.size();i++){
			tblData[i][0]=pubsOfMaterial.get(i).getMaterialId()+"";
			tblData[i][1]=pubsOfMaterial.get(i).getSupplierID();
			tblData[i][2]=pubsOfMaterial.get(i).getMaterialName();
			tblData[i][3]=pubsOfMaterial .get(i).getMaterialGuidePrice()+"";
			tblData[i][4]=pubsOfMaterial .get(i).getMaterialIntroduction();
		}
		tablmod.setDataVector(tblData,tbltitleOfMaterial);
		this.dataTable.validate();
		this.dataTable.repaint();
		
		
		if(text1.getText()==null||text1.getText().equals(""))
		text1.setText("MaterialId");
		if(text2.getText()==null||text2.getText().equals(""))
		text2.setText("SupplierID");

	}

    
    
    
    
    
    
    
	private JDialog dlgLogin=null;
	private JPanel statusBar = new JPanel();
	
	public FrmMain2(){
		JFrame jf=new JFrame("生产管理系统");
		
		dlgLogin=new FrmLogin(this,"登陆",true);
		dlgLogin.setVisible(true);
        jf.setSize(WIDTH,HEIGHT);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置其顶层容器的关闭性

        Toolkit kit=Toolkit.getDefaultToolkit();//设置顶层容器框架为居中
        Dimension screenSize=kit.getScreenSize();
        int width=screenSize.width;
        int height=screenSize.height;
        int x=(width-WIDTH)/2;
        int y=(height-HEIGHT)/2;
        jf.setLocation(x,y);
        
        ImageIcon icon=new ImageIcon("src/model/1.jpg");
        JLabel label=new JLabel(icon);  
        label.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
        jf.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));  
        JPanel j=(JPanel)jf.getContentPane();  
        j.setOpaque(false); 
        
        
        
        JPanel contentPane=new JPanel();
        contentPane.setLayout(new FlowLayout());
        JPanel p1=new JPanel();
        jf.setContentPane(contentPane);
        
		p1.setOpaque(false);
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
		p2.setLayout(new FlowLayout());

		JPanel p22=new JPanel();
		
		
		
		statusBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    JLabel label211=new JLabel("您好!   "+FrmLogin.currentAdmin.getAdminName()+"!   是时候展现你真正的技术了！                                                                                                             ");
	    statusBar.add(label211);
	    statusBar.setOpaque(false);
		
		
		p22.setLayout(new FlowLayout());
		p22.add(button_Function_add);
		p22.add(button_Function_delete);
		p22.add(button_Function_modify);
		p22.add(button_Function_search);
		text1.setColumns(10);
		text2.setColumns(10);
		p22.add(text1);
		p22.add(text2);
		p22.setOpaque(false);
		
		

		
		
		p2.add(statusBar);
		p2.add(p22);
		p2.setOpaque(false);
	    contentPane.add(p2,"South");
		
		
		
		
		
		
		
		//this.getContentPane().add(new JScrollPane(this.dataTable), BorderLayout.CENTER);
		JPanel p3=new JPanel();
		p3.setLayout(new BorderLayout());
		JScrollPane aJScrollPane=new JScrollPane(dataTable);
		aJScrollPane.setBackground(getBackground());
		aJScrollPane.setMaximumSize(screenSize);
		p3.add(aJScrollPane);
		p3.setOpaque(false);
		contentPane.add(p3,"Center");
		
		
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
		
		 this.dataTable.addMouseListener(new MouseAdapter (){

				public void mouseClicked(MouseEvent e) {
					int i=FrmMain2.this.dataTable.getSelectedRow();
					if(i<0) {
						return;
					}
					int j=FrmMain2.this.dataTable.getSelectedColumn();
					j++;
					if(j==FrmMain2.this.dataTable.getColumnCount())
					{
						JFrame jf222=new JFrame("详情");
				        jf222.setSize(250,250);
				        Toolkit kit=Toolkit.getDefaultToolkit();//设置顶层容器框架为居中
				        Dimension screenSize=kit.getScreenSize();
				        int width=screenSize.width;
				        int height=screenSize.height;
				        int x=(width-250)/2;
				        int y=(height-250)/2;
				        jf222.setLocation(x, y);
				        JPanel contentPane222=new JPanel();
				        contentPane222.setLayout(new BorderLayout());
				        JPanel p111=new JPanel();
				        jf222.setContentPane(contentPane222);
				        TextArea brief222 = new TextArea(5,28);				        
				        brief222.setText(tblData[i][j-1].toString());
				        brief222.setSize(300,300);
				        p111.add(brief222);
				        contentPane222.add(p111);
				        jf222.setVisible(true);
					}
					//zhanshi
					//System.out.println(i);
					
				}
		    	
		  });
		
		
		
		contentPane.setOpaque(false);
		jf.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.Button_Supplier)
		{
			flag="Supplier";
			text1.setText("name");text2.setText("address");
			try {
				reloadSupplierTable();
				
			} catch (BaseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else if (e.getSource()==this.Button_Material)
		{
			flag="Material";
			text1.setText("MaterialId");text2.setText("SupplierID");
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
				FrmSupplierAdd aFrmSupplier=new FrmSupplierAdd(this,"增加供货商",true);
				aFrmSupplier.setVisible(true);
				if(aFrmSupplier.getPub()!=null)
				{
					try {
						reloadSupplierTable();
					} catch (BaseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}else if(flag.equals("Material")){
				FrmMaterialAdd add=new FrmMaterialAdd(this,"增加材料",true);
				add.setVisible(true);
				if(add.getPub()!=null)
				{
					try {
						reloadMaterialTable();
					} catch (BaseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
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
				int i=FrmMain2.this.dataTable.getSelectedRow();
				(new SupplierManager()).deleteSupplier(pubs.get(i));
				try {
					reloadSupplierTable();
				} catch (BaseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(flag.equals("Material")){
				int i=FrmMain2.this.dataTable.getSelectedRow();
				(new MaterialManager()).deleteMaterial(pubsOfMaterial.get(i));
				try {
					reloadMaterialTable();
				} catch (BaseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
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
				int i=FrmMain2.this.dataTable.getSelectedRow();
				FrmSupplierModify aFrmSupplierModify =new FrmSupplierModify(this,"供货商修改",true,pubs.get(i));
				aFrmSupplierModify.setVisible(true);
				if(aFrmSupplierModify.getaSupplier()!=null)
				{
					try {
						reloadSupplierTable();
					} catch (BaseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			
			}else if(flag.equals("Material")){
				int i=FrmMain2.this.dataTable.getSelectedRow();
				FrmMaterialModify aFrmMaterialModify= new FrmMaterialModify(this,"材料修改",true,pubs.get(i));
				aFrmMaterialModify.setVisible(true);
				if(aFrmMaterialModify.getaSupplier()!=null)
				{
					try {
						reloadSupplierTable();
					} catch (BaseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
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
				try {
					reloadSupplierTable();
				} catch (BaseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
