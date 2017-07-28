package cn.edu.zucc.ordercontrol.control;

import java.util.List;

import javax.swing.JOptionPane;

import cn.edu.zucc.ordercontrol.dao.StockOutputDao;
import cn.edu.zucc.ordercontrol.model.StockOutput;
import cn.edu.zucc.ordercontrol.uti.BusinessException;

public class StockOutputManager {
	StockOutputDao aDao = new StockOutputDao();

	public void CreateStockOutput(StockOutput StockOutput) throws BusinessException {
		// check right
		if (StockOutput.getStockOutputID() == null || StockOutput.getStockOutputID().equals("")) {
			throw new BusinessException("StockOutput id is null");
		}

		// check exist
		if (search(StockOutput) != null) {
			throw new BusinessException("StockOutput id has existed");
		}

		if (aDao.CreateStockOutput(StockOutput))// create
		{
			// ok
			JOptionPane.showMessageDialog(null, "创建成功", "消息提醒", JOptionPane.WARNING_MESSAGE);

		} else {
			// no
			JOptionPane.showMessageDialog(null, "创建失败", "消息提醒", JOptionPane.WARNING_MESSAGE);

		}
	}

	public boolean modifyStockOutput(StockOutput StockOutput, StockOutput old) throws BusinessException {
		// check right
		if (!StockOutput.getStockOutputID().equals(old.getStockOutputID()) && search(StockOutput) != null) {
			throw new BusinessException("StockOutput id has existed");
		}

		return aDao.modifyStockOutput(StockOutput);
	}

	public boolean deleteStockOutput(StockOutput StockOutput) {
		return aDao.deleteStockOutput(StockOutput); // delete
	}

	public StockOutput search(StockOutput StockOutput) throws BusinessException {
		return aDao.search(StockOutput.getStockOutputID());
	}

	public List<StockOutput> searchStockOutput(String productid, String StockOutputaddress) {
		return aDao.searchStockOutput(productid, StockOutputaddress);
	}
}
