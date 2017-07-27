package cn.edu.zucc.ordercontrol.model;

public class Material {
	private String MaterialId;
	private String SupplierID;
	private String MaterialName;
	private String MaterialGuidePrice;
	private String MaterialIntroduction;

	public String getMaterialId() {
		return MaterialId;
	}

	public void setMaterialId(String materialId) {
		MaterialId = materialId;
	}

	public String getSupplierID() {
		return SupplierID;
	}

	public void setSupplierID(String supplierID) {
		SupplierID = supplierID;
	}

	public String getMaterialName() {
		return MaterialName;
	}

	public void setMaterialName(String materialName) {
		MaterialName = materialName;
	}

	public String getMaterialGuidePrice() {
		return MaterialGuidePrice;
	}

	public void setMaterialGuidePrice(String materialGuidePrice) {
		MaterialGuidePrice = materialGuidePrice;
	}

	public String getMaterialIntroduction() {
		return MaterialIntroduction;
	}

	public void setMaterialIntroduction(String materialIntroduction) {
		MaterialIntroduction = materialIntroduction;
	}

}
