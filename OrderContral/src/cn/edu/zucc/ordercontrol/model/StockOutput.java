package cn.edu.zucc.ordercontrol.model;

import java.sql.Date;

public class StockOutput {
	private String ProductId;
	private String StockOutputID;
	private Date StockOutputDate;
	private String StockOutputCount;
	public String getProductId() {
		return ProductId;
	}
	public void setProductId(String productId) {
		ProductId = productId;
	}
	public String getStockOutputID() {
		return StockOutputID;
	}
	public void setStockOutputID(String stockOutputID) {
		StockOutputID = stockOutputID;
	}
	public Date getStockOutputDate() {
		return StockOutputDate;
	}
	public void setStockOutputDate(Date stockOutputDate) {
		StockOutputDate = stockOutputDate;
	}
	public String getStockOutputCount() {
		return StockOutputCount;
	}
	public void setStockOutputCount(String stockOutputCount) {
		StockOutputCount = stockOutputCount;
	}
}
