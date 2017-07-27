
package cn.edu.zucc.ordercontrol.dao;

import java.util.List;

import cn.edu.zucc.ordercontrol.model.StockOutput;

public interface IStockOutputDao {
	// search
	public StockOutput search(String StockOutputID);

	// loadall
	public List<StockOutput> loadall();

	// create
	public boolean CreateStockOutput(StockOutput StockOutput);

	// delete
	public boolean deleteStockOutput(StockOutput StockOutput);

	// Ä£ºý²éÑ¯ by name and address
	public List<StockOutput> searchStockOutput(String StockOutputname, String StockOutputID);
}
