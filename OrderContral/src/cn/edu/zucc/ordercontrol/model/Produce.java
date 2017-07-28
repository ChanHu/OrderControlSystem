package cn.edu.zucc.ordercontrol.model;

import java.sql.Date;

public class Produce {
	private String ProduceId;
	private String ProductId;
	private Date ProduceDate;
	private String ProduceCount;
	private boolean ProduceFinish=false;
	
	public boolean isProduceFinish() {
		return ProduceFinish;
	}

	public void setProduceFinish(boolean produceFinish) {
		ProduceFinish = produceFinish;
	}

	public String getProduceId() {
		return ProduceId;
	}

	public void setProduceId(String produceId) {
		ProduceId = produceId;
	}

	public String getProductId() {
		return ProductId;
	}

	public void setProductId(String productId) {
		ProductId = productId;
	}

	public Date getProduceDate() {
		return ProduceDate;
	}

	public void setProduceDate(Date produceDate) {
		ProduceDate = produceDate;
	}

	public String getProduceCount() {
		return ProduceCount;
	}

	public void setProduceCount(String produceCount) {
		ProduceCount = produceCount;
	}

}
