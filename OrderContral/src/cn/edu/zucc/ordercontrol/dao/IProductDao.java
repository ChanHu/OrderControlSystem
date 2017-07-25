
package cn.edu.zucc.ordercontrol.dao;

import java.util.List;

import cn.edu.zucc.ordercontrol.model.Product;

public interface IProductDao {
	//search
	public Product search(String ProductID) ;
	//loadall
	public List<Product> loadall() ;
		
	//create
	public boolean CreateProduct(Product Product) ;
	//delete
	public boolean deleteProduct(Product Product) ;
	//ģ����ѯ   by name and address
	public List<Product> searchProduct(String Productname,String ProductID);
}
