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
    private JMenu menu_manager=new JMenu("ϵͳ����");
    private JMenu menu_production=new JMenu("��������");
    private JMenu menu_search=new JMenu("��ѯͳ��");
    
    private JMenuItem MenuItem_Supplier=new JMenuItem("���̹���");
    private JMenuItem MenuItem_Material=new JMenuItem("���Ϲ���");
    private JMenuItem MenuItem_ProductInfo=new JMenuItem("��Ʒ��Ϣ����");
    private JMenuItem MenuItem_productType=new JMenuItem("��Ʒ�������");
    private JMenuItem MenuItem_Customer=new JMenuItem("�����߹���");
    
    private JMenuItem MenuItem_Input=new JMenuItem("ԭ���Ϲ���");
    private JMenuItem MenuItem_Output=new JMenuItem("��Ʒ����");
    
    private JMenuItem MenuItem_order=new JMenuItem("������ѯ");
    private JMenuItem MenuItem_Stock=new JMenuItem("����ѯ");
    
 
	private JPanel statusBar = new JPanel();
	public FrmMain(){
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("��������ϵͳ");
		
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
		
		
		
	    //״̬��
	    
	    statusBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    JLabel label=new JLabel("����!");
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
