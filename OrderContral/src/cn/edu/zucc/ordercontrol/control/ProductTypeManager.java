package cn.edu.zucc.ordercontrol.control;

import java.util.List;

import javax.swing.JOptionPane;

import cn.edu.zucc.ordercontrol.dao.ProductTypeDao;
import cn.edu.zucc.ordercontrol.model.ProductType;
import cn.edu.zucc.ordercontrol.uti.BusinessException;

public class ProductTypeManager {
	ProductTypeDao aDao = new ProductTypeDao();

	public void CreateProductType(ProductType ProductType) throws BusinessException {
		// check right
		if (ProductType.getProductTypeID() == null || ProductType.getProductTypeID().equals("")) {
			throw new BusinessException("ProductType id is null");
		}

		// check exist
		if (search(ProductType) != null) {
			throw new BusinessException("ProductType id has existed");
		}

		if (aDao.CreateProductType(ProductType))// create
		{
			// ok
			JOptionPane.showMessageDialog(null, "创建成功", "消息提醒", JOptionPane.WARNING_MESSAGE);

		} else {
			// no
			JOptionPane.showMessageDialog(null, "创建失败", "消息提醒", JOptionPane.WARNING_MESSAGE);

		}
	}

	public boolean modifyProductType(ProductType ProductType, ProductType old) throws BusinessException {
		// check right
		if (!ProductType.getProductTypeID().equals(old.getProductTypeID()) && search(ProductType) != null) {
			throw new BusinessException("ProductType id has existed");
		}
		//System.out.println(ProductType.getProductTypeName());
		return aDao.modifyProductType(ProductType);
	}

	public boolean deleteProductType(ProductType ProductType) {
		return aDao.deleteProductType(ProductType); // delete
	}

	public ProductType search(ProductType ProductType) throws BusinessException {
		return aDao.search(ProductType.getProductTypeID());
	}

	public List<ProductType> searchProductType(String ProductTypename, String ProductTypeaddress) {
		return aDao.searchProductType(ProductTypename, ProductTypeaddress);
	}
}
