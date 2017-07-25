package cn.edu.zucc.ordercontrol.control;

import java.util.List;

import javax.swing.JOptionPane;

import cn.edu.zucc.ordercontrol.dao.SupplierDao;
import cn.edu.zucc.ordercontrol.model.Supplier;
import cn.edu.zucc.ordercontrol.uti.BusinessException;

public class SupplierManager {
	SupplierDao aDao= new SupplierDao();
	
	
	
	
	public void  CreateSupplier(Supplier supplier) throws BusinessException {
		//check right
		if(supplier.getSupplierID()==null||supplier.getSupplierID().equals(""))
		{
			throw new BusinessException("supplier id is null");
		}
		
		 if(aDao.CreateSupplier(supplier))//create
		 {
			//ok
			 JOptionPane.showMessageDialog(null, "创建成功", "消息提醒",JOptionPane.WARNING_MESSAGE);
			 
		 }else{
			//no
			 JOptionPane.showMessageDialog(null, "创建失败", "消息提醒",JOptionPane.WARNING_MESSAGE);
			 
		 }
	}
	

	public boolean modifySupplier(Supplier supplier) throws BusinessException {
		//check right
		if(search(supplier)!=null){
			throw new BusinessException("supplies id has existed");
		}
		
		 return aDao.modifySupplier(supplier);
	}
	
	
	public boolean  deleteSupplier(Supplier supplier) {
		 return aDao.deleteSupplier(supplier);		//delete
	}
	
	

	public Supplier search(Supplier supplier) throws BusinessException {
		return aDao.search(supplier.getSupplierID());
	}
	
	
	public List<Supplier> searchSupplier(String suppliername,String supplieraddress) {
		return aDao.searchSupplier(suppliername, supplieraddress);
	}
}
