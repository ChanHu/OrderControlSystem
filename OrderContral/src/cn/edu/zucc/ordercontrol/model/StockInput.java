package cn.edu.zucc.ordercontrol.model;

import java.sql.Date;

public class StockInput {
	private String MaterialId;
	private String StockInputID;
	private Date StockInputDate;
	private String StockInputCount;

	public String getMaterialId() {
		return MaterialId;
	}

	public void setMaterialId(String materialId) {
		MaterialId = materialId;
	}

	public String getStockInputID() {
		return StockInputID;
	}

	public void setStockInputID(String stockInputID) {
		StockInputID = stockInputID;
	}

	public Date getStockInputDate() {
		return StockInputDate;
	}

	public void setStockInputDate(Date stockInputDate) {
		StockInputDate = stockInputDate;
	}

	public String getStockInputCount() {
		return StockInputCount;
	}

	public void setStockInputCount(String stockInputCount) {
		StockInputCount = stockInputCount;
	}

}
