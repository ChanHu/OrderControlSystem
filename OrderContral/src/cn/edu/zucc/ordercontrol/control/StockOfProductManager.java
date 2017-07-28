package cn.edu.zucc.ordercontrol.control;

import java.util.List;

import javax.swing.JOptionPane;

import cn.edu.zucc.ordercontrol.dao.StockOfProductDao;
import cn.edu.zucc.ordercontrol.model.StockOfProduct;
import cn.edu.zucc.ordercontrol.uti.BusinessException;

public class StockOfProductManager {
	StockOfProductDao aDao = new StockOfProductDao();

	public void CreateStockOfProduct(StockOfProduct StockOfProduct) throws BusinessException {
		// check right
		if (StockOfProduct.getStockOfProductID() == null || StockOfProduct.getStockOfProductID().equals("")) {
			throw new BusinessException("StockOfProduct id is null");
		}

		// check exist
		if (search(StockOfProduct) != null) {
			throw new BusinessException("supplies id has existed");
		}

		if (aDao.CreateStockOfProduct(StockOfProduct))// create
		{
			// ok
			JOptionPane.showMessageDialog(null, "创建成功", "消息提醒", JOptionPane.WARNING_MESSAGE);

		} else {
			// no
			JOptionPane.showMessageDialog(null, "创建失败", "消息提醒", JOptionPane.WARNING_MESSAGE);

		}
	}

	public boolean modifyStockOfProduct(StockOfProduct StockOfProduct, StockOfProduct old) throws BusinessException {
		// check right
		if (!StockOfProduct.getStockOfProductID().equals(old.getStockOfProductID()) && search(StockOfProduct) != null) {
			throw new BusinessException("StockOfProduct id has existed");
		}

		return aDao.modifyStockOfProduct(StockOfProduct);
	}

	public boolean deleteStockOfProduct(StockOfProduct StockOfProduct) {
		return aDao.deleteStockOfProduct(StockOfProduct); // delete
	}

	public StockOfProduct search(StockOfProduct StockOfProduct) throws BusinessException {
		return aDao.search(StockOfProduct.getStockOfProductID());
	}

	public List<StockOfProduct> searchStockOfProduct(String productid, String StockOfProductaddress) {
		return aDao.searchStockOfProduct(productid, StockOfProductaddress);
	}
}
