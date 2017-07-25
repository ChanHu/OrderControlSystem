
package cn.edu.zucc.ordercontrol.dao;

import java.util.List;

import cn.edu.zucc.ordercontrol.model.ProductType;

public interface IProductTypeDao {
	//search
	public ProductType search(String ProductTypeID) ;
	//loadall
	public List<ProductType> loadall() ;
		
	//create
	public boolean CreateProductType(ProductType ProductType) ;
	//delete
	public boolean deleteProductType(ProductType ProductType) ;
	//Ä£ºý²éÑ¯   by name and address
	public List<ProductType> searchProductType(String ProductTypename,String ProductTypeID);
}
