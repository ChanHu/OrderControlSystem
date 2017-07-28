package cn.edu.zucc.ordercontrol.control;

import java.util.List;

import javax.swing.JOptionPane;

import cn.edu.zucc.ordercontrol.dao.ProductformDao;
import cn.edu.zucc.ordercontrol.model.Productform;
import cn.edu.zucc.ordercontrol.uti.BusinessException;

public class ProductFormManager {
	ProductformDao aDao = new ProductformDao();

	public void CreateProductform(Productform ProductForm) throws BusinessException {

		if (aDao.CreateProductform(ProductForm))// create
		{
			// ok
			JOptionPane.showMessageDialog(null, "创建成功", "消息提醒", JOptionPane.WARNING_MESSAGE);

		} else {
			// no
			JOptionPane.showMessageDialog(null, "创建失败", "消息提醒", JOptionPane.WARNING_MESSAGE);

		}
	}

	public boolean modifyProductform(Productform Productform) throws BusinessException {

		return aDao.modifyProductform(Productform);
	}

	public boolean deleteform(Productform Productform) {
		return aDao.deleteProductform(Productform); // delete
	}

	public Productform search(Productform Productform) throws BusinessException {
		return aDao.search(Productform.getProductId());
	}

	public List<Productform> searchform(String productid, String materialid) {
		return aDao.searchProductform(productid, materialid);
	}
}
