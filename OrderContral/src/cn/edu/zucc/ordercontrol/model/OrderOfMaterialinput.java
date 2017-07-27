package cn.edu.zucc.ordercontrol.model;

import java.sql.Date;

public class OrderOfMaterialinput {
	private String OrderOfMaterialinputID;
	private String MaterialId;
	private String InputCount;
	private String InputPrice;
	private Date InputDate;

	public String getMaterialId() {
		return MaterialId;
	}

	public void setMaterialId(String materialId) {
		MaterialId = materialId;
	}

	public String getOrderOfMaterialinputID() {
		return OrderOfMaterialinputID;
	}

	public void setOrderOfMaterialinputID(String orderOfMaterialinputID) {
		OrderOfMaterialinputID = orderOfMaterialinputID;
	}

	public String getInputCount() {
		return InputCount;
	}

	public void setInputCount(String inputCount) {
		InputCount = inputCount;
	}

	public String getInputPrice() {
		return InputPrice;
	}

	public void setInputPrice(String inputPrice) {
		InputPrice = inputPrice;
	}

	public Date getInputDate() {
		return InputDate;
	}

	public void setInputDate(Date inputDate) {
		InputDate = inputDate;
	}

}
