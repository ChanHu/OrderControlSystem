package cn.edu.zucc.ordercontrol.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class FrmMain extends JFrame implements ActionListener {
	private JMenuBar menubar=new JMenuBar(); 
    private JMenu menu_manager=new JMenu("系统管理");
    private JMenu menu_production=new JMenu("生产管理");
    private JMenu menu_search=new JMenu("查询统计");
    
    private JMenuItem MenuItem_Supplier=new JMenuItem("厂商管理");
    private JMenuItem MenuItem_Material=new JMenuItem("材料管理");
    private JMenuItem MenuItem_ProductInfo=new JMenuItem("产品信息管理");
    private JMenuItem MenuItem_productType=new JMenuItem("产品种类管理");
    private JMenuItem MenuItem_Customer=new JMenuItem("消费者管理");
    
    private JMenuItem MenuItem_Input=new JMenuItem("原材料管理");
    private JMenuItem MenuItem_Output=new JMenuItem("产品管理");
    
    private JMenuItem MenuItem_order=new JMenuItem("订单查询");
    private JMenuItem MenuItem_Stock=new JMenuItem("库存查询");
    
 
	private JPanel statusBar = new JPanel();
	public FrmMain(){
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("生产管理系统");
		
		menu_manager.add(MenuItem_Supplier);
		MenuItem_Supplier.addActionListener(this);
		menu_manager.add(MenuItem_Material);
		MenuItem_Material.addActionListener(this);
		menu_manager.add(MenuItem_ProductInfo);
		MenuItem_ProductInfo.addActionListener(this);
		menu_manager.add(MenuItem_productType);
		MenuItem_productType.addActionListener(this);
		menu_manager.add(MenuItem_Customer);
		MenuItem_Customer.addActionListener(this);
		menubar.add(menu_manager);
		
		menu_production.add(MenuItem_Input);
		MenuItem_Input.addActionListener(this);
		menu_production.add(MenuItem_Output);
		MenuItem_Output.addActionListener(this);
		menubar.add(menu_production);
		
		menu_search.add(MenuItem_order);
		MenuItem_order.addActionListener(this);
		menu_search.add(MenuItem_Stock);
		MenuItem_Stock.addActionListener(this);
		menubar.add(menu_search);
		this.setJMenuBar(menubar);
		
		
		
	    //状态栏
	    
	    statusBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    JLabel label=new JLabel("您好!");
	    statusBar.add(label);
	    this.getContentPane().add(statusBar,BorderLayout.SOUTH);
	    this.addWindowListener(new WindowAdapter(){   
	    	public void windowClosing(WindowEvent e){ 
	    		System.exit(0);
             }
        });
	    this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
