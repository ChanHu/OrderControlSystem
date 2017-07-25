package cn.edu.zucc.ordercontrol.model;

public class Product {
	private String ProductId;
	private String ProductTypeID;
	private String ProductName;
	private String ProductPrice;
	private String ProductIntroduction;
	public String getProductId() {
		return ProductId;
	}
	public void setProductId(String productId) {
		ProductId = productId;
	}
	public String getProductTypeID() {
		return ProductTypeID;
	}
	public void setProductTypeID(String productTypeID) {
		ProductTypeID = productTypeID;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(String productPrice) {
		ProductPrice = productPrice;
	}
	public String getProductIntroduction() {
		return ProductIntroduction;
	}
	public void setProductIntroduction(String productIntroduction) {
		ProductIntroduction = productIntroduction;
	}
	
}
