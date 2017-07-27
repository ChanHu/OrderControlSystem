
package cn.edu.zucc.ordercontrol.dao;

import java.util.List;

import cn.edu.zucc.ordercontrol.model.StockInput;

public interface IStockInputDao {
	// search
	public StockInput search(String StockInputID);

	// loadall
	public List<StockInput> loadall();

	// create
	public boolean CreateStockInput(StockInput StockInput);

	// delete
	public boolean deleteStockInput(StockInput StockInput);

	// Ä£ºý²éÑ¯ by name and address
	public List<StockInput> searchStockInput(String StockInputname, String StockInputID);
}
