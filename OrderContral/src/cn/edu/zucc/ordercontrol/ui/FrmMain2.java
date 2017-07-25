package cn.edu.zucc.ordercontrol.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
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
	
    private JButton Button_Supplier=new JButton("���̹���");
    private JButton Button_Material=new JButton("���Ϲ���");
    private JButton Button_ProductInfo=new JButton("��Ʒ��Ϣ����");
    private JButton Button_ProductForm=new JButton("��Ʒ��ɹ���");
    private JButton Button_productType=new JButton("��Ʒ�������");
    private JButton Button_Customer=new JButton("�����߹���");
    
    private JButton Button_Input=new JButton("�ɹ�����");
    private JButton Button_Output=new JButton("���۹���");
    private JButton Button_Produce=new JButton("����");
    
    private JButton Button_order=new JButton("������ѯ");
    private JButton Button_Stock=new JButton("����ѯ");
    
    JButton button_Function_add=new JButton("����");
    JButton button_Function_modify=new JButton("�޸�");
    JButton button_Function_delete=new JButton("ɾ��");
    JButton button_Function_search=new JButton("��ѯ");
    JTextArea text1=new JTextArea();
 
//	private JPanel statusBar = new JPanel();
    
    
    private Object tblTitleOfSupplier[]={"�����̱��","����������","�����̵�ַ","��������ϵ��","�����̵绰","�����̼��"};
    private Object tbltitleOfMaterial[]={"���ϱ��","�����̱��","��������","���ϼ۸�","���ϼ��"};
    private Object tbltitleOfProduct[]={"���ϱ��","�����̱��","��������","���ϼ۸�","���ϼ��"};
    private Object tbltitleOfProductForm[]={"���ϱ��","�����̱��","��������","���ϼ۸�","���ϼ��"};
    private Object tbltitleOfProductType[]={"���ϱ��","�����̱��","��������","���ϼ۸�","���ϼ��"};
    private Object tbltitleOfCustomer[]={"���ϱ��","�����̱��","��������","���ϼ۸�","���ϼ��"};

    
    List<Supplier> pubs;
	List<Material> pubsOfMaterial;
    
	
	
	private Object tblData[][];
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable dataTable=new JTable(tablmod);
	
	

	
	
	
	
	void reloadSupplierTable() throws BaseException{
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
    
    
	 void reloadMaterialTable() throws BaseException{
		pubsOfMaterial=(new MaterialDao()).loadall();
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
	}
    
    
    
    
    
    
    
    
    
	public FrmMain2(){
		JFrame jf=new JFrame("��������ϵͳ");
		
        jf.setSize(WIDTH,HEIGHT);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����䶥�������Ĺر���

        Toolkit kit=Toolkit.getDefaultToolkit();//���ö����������Ϊ����
        Dimension screenSize=kit.getScreenSize();
        int width=screenSize.width;
        int height=screenSize.height;
        int x=(width-WIDTH)/2;
        int y=(height-HEIGHT)/2;
        jf.setLocation(x,y);
        
        ImageIcon icon=new ImageIcon("src/model/1.png");
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
        //contentPane.setLayout(new GridLayout(0, 1)); // ����Ϊ���񲼾֣�δָ������
		//setFont(new Font("Helvetica", Font.PLAIN, 18));
        contentPane.setLayout(new BorderLayout());
        
        p1.setLayout(new FlowLayout());
		p1.add(new JLabel("                ϵͳ����"));
		p1.add(Button_Supplier);
		p1.add(Button_Material);
		p1.add(Button_ProductInfo);
		p1.add(Button_productType);
		p1.add(Button_ProductForm);
		p1.add(Button_Customer);
		p1.add(new JLabel("                       ��������"));
		p1.add(Button_Input);
		p1.add(Button_Output);
		p1.add(Button_Produce);
		p1.add(new JLabel("                       ��ѯͳ��"));
		p1.add(Button_order);
		p1.add(Button_Stock);
		contentPane.add(p1, "North");
		//jf.pack();
		
		
		JPanel p2=new JPanel();
		p2.setOpaque(false);
		p2.add(button_Function_add);
		p2.add(button_Function_delete);
		p2.add(button_Function_modify);
		p2.add(button_Function_search);
		text1.setColumns(10);
		p2.add(text1);
		contentPane.add(p2,"South");
		
		//this.getContentPane().add(new JScrollPane(this.dataTable), BorderLayout.CENTER);
		JPanel p3=new JPanel();
		JScrollPane aJScrollPane=new JScrollPane(dataTable);
		aJScrollPane.setOpaque(false);
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
						JFrame jf222=new JFrame("����");
				        jf222.setSize(300,300);
				        JPanel contentPane222=new JPanel();
				        contentPane222.setLayout(new FlowLayout());
				        JPanel p111=new JPanel();
				        jf222.setContentPane(contentPane222);
				        TextArea brief222 = new TextArea(5,28);				        
				        brief222.setText(tblData[i][j-1].toString());
				        p111.add(brief222);
				        contentPane222.add(p111, "North");
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
				FrmSupplierAdd aFrmSupplier=new FrmSupplierAdd(this,"���ӹ�����",true);
				aFrmSupplier.setVisible(true);
				
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
				int i=FrmMain2.this.dataTable.getSelectedRow();
				(new SupplierDao()).deleteSupplier(pubs.get(i));
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
		}else if(e.getSource()==this.button_Function_modify){
			if(flag.equals("Supplier")){
				int i=FrmMain2.this.dataTable.getSelectedRow();
				FrmSupplierModify aFrmSupplierModify =new FrmSupplierModify(this,"�������޸�",true,pubs.get(i));
				aFrmSupplierModify.setVisible(true);
				
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
