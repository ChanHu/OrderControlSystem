package cn.edu.zucc.ordercontrol.control;

import java.util.List;

import javax.swing.JOptionPane;

import cn.edu.zucc.ordercontrol.dao.StockInputDao;
import cn.edu.zucc.ordercontrol.model.StockInput;
import cn.edu.zucc.ordercontrol.uti.BusinessException;

public class StockInputManager {
	StockInputDao aDao = new StockInputDao();

	public void CreateStockInput(StockInput StockInput) throws BusinessException {
		// check right
		if (StockInput.getStockInputID() == null || StockInput.getStockInputID().equals("")) {
			throw new BusinessException("StockInput id is null");
		}

		// check exist
		if (search(StockInput) != null) {
			throw new BusinessException("StockInput id has existed");
		}

		if (aDao.CreateStockInput(StockInput))// create
		{
			// ok
			JOptionPane.showMessageDialog(null, "创建成功", "消息提醒", JOptionPane.WARNING_MESSAGE);

		} else {
			// no
			JOptionPane.showMessageDialog(null, "创建失败", "消息提醒", JOptionPane.WARNING_MESSAGE);

		}
	}

	public boolean modifyStockInput(StockInput StockInput, StockInput old) throws BusinessException {
		// check right
		if (!StockInput.getStockInputID().equals(old.getStockInputID()) && search(StockInput) != null) {
			throw new BusinessException("StockInput id has existed");
		}

		return aDao.modifyStockInput(StockInput);
	}

	public boolean deleteStockInput(StockInput StockInput) {
		return aDao.deleteStockInput(StockInput); // delete
	}

	public StockInput search(StockInput StockInput) throws BusinessException {
		return aDao.search(StockInput.getStockInputID());
	}

	public List<StockInput> searchStockInput(String materialid, String StockInputaddress) {
		return aDao.searchStockInput(materialid, StockInputaddress);
	}
}
