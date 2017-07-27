package cn.edu.zucc.ordercontrol.model;

public class StockOfProduct {
	private String StockOfProductID;
	private String ProductId;
	private String StockOfProductCount;
	private String StockOfProductAddress;

	public String getStockOfProductID() {
		return StockOfProductID;
	}

	public void setStockOfProductID(String stockOfProductID) {
		StockOfProductID = stockOfProductID;
	}

	public String getProductId() {
		return ProductId;
	}

	public void setProductId(String productId) {
		ProductId = productId;
	}

	public String getStockOfProductCount() {
		return StockOfProductCount;
	}

	public void setStockOfProductCount(String stockOfProductCount) {
		StockOfProductCount = stockOfProductCount;
	}

	public String getStockOfProductAddress() {
		return StockOfProductAddress;
	}

	public void setStockOfProductAddress(String stockOfProductAddress) {
		StockOfProductAddress = stockOfProductAddress;
	}

}
