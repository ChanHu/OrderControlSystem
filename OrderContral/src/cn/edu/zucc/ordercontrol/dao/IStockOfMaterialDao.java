
package cn.edu.zucc.ordercontrol.dao;

import java.util.List;

import cn.edu.zucc.ordercontrol.model.StockOfMaterial;

public interface IStockOfMaterialDao {
	// search
	public StockOfMaterial search(String StockOfMaterialID);

	// loadall
	public List<StockOfMaterial> loadall();

	// create
	public boolean CreateStockOfMaterial(StockOfMaterial StockOfMaterial);

	// delete
	public boolean deleteStockOfMaterial(StockOfMaterial StockOfMaterial);

	// Ä£ºý²éÑ¯ by name and address
	public List<StockOfMaterial> searchStockOfMaterial(String StockOfMaterialname, String StockOfMaterialID);
}
