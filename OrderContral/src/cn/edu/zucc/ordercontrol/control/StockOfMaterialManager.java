package cn.edu.zucc.ordercontrol.control;

import java.util.List;

import javax.swing.JOptionPane;

import cn.edu.zucc.ordercontrol.dao.StockOfMaterialDao;
import cn.edu.zucc.ordercontrol.model.StockOfMaterial;
import cn.edu.zucc.ordercontrol.uti.BusinessException;

public class StockOfMaterialManager {
	StockOfMaterialDao aDao = new StockOfMaterialDao();

	public void CreateStockOfMaterial(StockOfMaterial StockOfMaterial) throws BusinessException {
		// check right
		if (StockOfMaterial.getStockOfMaterialId()== null || StockOfMaterial.getStockOfMaterialId().equals("")) {
			throw new BusinessException("StockOfMaterial id is null");
		}

		// check exist
		if (search(StockOfMaterial) != null) {
			throw new BusinessException("supplies id has existed");
		}

		if (aDao.CreateStockOfMaterial(StockOfMaterial))// create
		{
			// ok
			JOptionPane.showMessageDialog(null, "创建成功", "消息提醒", JOptionPane.WARNING_MESSAGE);

		} else {
			// no
			JOptionPane.showMessageDialog(null, "创建失败", "消息提醒", JOptionPane.WARNING_MESSAGE);

		}
	}

	public boolean modifyStockOfMaterial(StockOfMaterial StockOfMaterial, StockOfMaterial old) throws BusinessException {
		// check right
		if (!StockOfMaterial.getStockOfMaterialId().equals(old.getStockOfMaterialId()) && search(StockOfMaterial) != null) {
			throw new BusinessException("supplies id has existed");
		}

		return aDao.modifyStockOfMaterial(StockOfMaterial);
	}

	public boolean deleteStockOfMaterial(StockOfMaterial StockOfMaterial) {
		return aDao.deleteStockOfMaterial(StockOfMaterial); // delete
	}

	public StockOfMaterial search(StockOfMaterial StockOfMaterial) throws BusinessException {
		return aDao.search(StockOfMaterial.getStockOfMaterialId());
	}

	public List<StockOfMaterial> searchStockOfMaterial(String Materialid, String StockOfMaterialaddress) {
		return aDao.searchStockOfMaterial(Materialid, StockOfMaterialaddress);
	}
}
