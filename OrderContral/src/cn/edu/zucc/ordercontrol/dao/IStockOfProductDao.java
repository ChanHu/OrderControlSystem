
package cn.edu.zucc.ordercontrol.dao;

import java.util.List;

import cn.edu.zucc.ordercontrol.model.StockOfProduct;

public interface IStockOfProductDao {
	//search
	public StockOfProduct search(String StockOfProductID) ;
	//loadall
	public List<StockOfProduct> loadall() ;
		
	//create
	public boolean CreateStockOfProduct(StockOfProduct StockOfProduct) ;
	//delete
	public boolean deleteStockOfProduct(StockOfProduct StockOfProduct) ;
	//Ä£ºý²éÑ¯   by name and address
	public List<StockOfProduct> searchStockOfProduct(String StockOfProductname,String StockOfProductID);
}
