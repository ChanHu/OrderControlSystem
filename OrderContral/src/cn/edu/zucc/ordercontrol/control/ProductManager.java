package cn.edu.zucc.ordercontrol.control;

import java.util.List;

import javax.swing.JOptionPane;

import cn.edu.zucc.ordercontrol.dao.ProductDao;
import cn.edu.zucc.ordercontrol.model.Product;
import cn.edu.zucc.ordercontrol.uti.BusinessException;

public class ProductManager {
	ProductDao aDao = new ProductDao();

	public void CreateProduct(Product Product) throws BusinessException {
		// check right
		if (Product.getProductId() == null || Product.getProductId().equals("")) {
			throw new BusinessException("Product id is null");
		}

		// check exist
		if (search(Product) != null) {
			throw new BusinessException("Product id has existed");
		}

		if (aDao.CreateProduct(Product))// create
		{
			// ok
			JOptionPane.showMessageDialog(null, "创建成功", "消息提醒", JOptionPane.WARNING_MESSAGE);

		} else {
			// no
			JOptionPane.showMessageDialog(null, "创建失败", "消息提醒", JOptionPane.WARNING_MESSAGE);

		}
	}

	public boolean modifyProduct(Product Product, Product old) throws BusinessException {
		// check right
		if (!Product.getProductId().equals(old.getProductId()) && search(Product) != null) {
			throw new BusinessException("Product id has existed");
		}

		return aDao.modifyProduct(Product);
	}

	public boolean deleteProduct(Product Product) {
		return aDao.deleteProduct(Product); // delete
	}

	public Product search(Product Product) throws BusinessException {
		return aDao.search(Product.getProductId());
	}

	public List<Product> searchProduct(String Productname, String Productaddress) {
		return aDao.searchProduct(Productname, Productaddress);
	}
}
