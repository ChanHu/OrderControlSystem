
package cn.edu.zucc.ordercontrol.dao;

import java.util.List;

import cn.edu.zucc.ordercontrol.model.Supplier;

public interface ISupplierDao {
	//search
	public Supplier search(String SupplierID) ;
	//loadall
	public List<Supplier> loadall() ;
		
	//create
	public boolean CreateSupplier(Supplier Supplier) ;
	//delete
	public boolean deleteSupplier(Supplier Supplier) ;
	//Ä£ºý²éÑ¯   by name and address
	public List<Supplier> searchSupplier(String Suppliername,String SupplierID);
}
