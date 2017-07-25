package cn.edu.zucc.ordercontrol.model;

import java.sql.Date;

public class OrderOfProductoutput {
	private String ProductId;
	private String CustomerID;
	private String OrderOfOPID;
	private String OutputCount;
	private Date OutputDate;
	private String OutputPrice;
	public String getProductId() {
		return ProductId;
	}
	public void setProductId(String productId) {
		ProductId = productId;
	}
	public String getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}
	public String getOrderOfOPID() {
		return OrderOfOPID;
	}
	public void setOrderOfOPID(String orderOfOPID) {
		OrderOfOPID = orderOfOPID;
	}
	public String getOutputCount() {
		return OutputCount;
	}
	public void setOutputCount(String outputCount) {
		OutputCount = outputCount;
	}
	public Date getOutputDate() {
		return OutputDate;
	}
	public void setOutputDate(Date outputDate) {
		OutputDate = outputDate;
	}
	public String getOutputPrice() {
		return OutputPrice;
	}
	public void setOutputPrice(String outputPrice) {
		OutputPrice = outputPrice;
	}
	
}
