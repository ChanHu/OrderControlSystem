package cn.edu.zucc.ordercontrol.control;

import java.util.List;

import javax.swing.JOptionPane;

import cn.edu.zucc.ordercontrol.dao.ProduceDao;
import cn.edu.zucc.ordercontrol.model.Produce;
import cn.edu.zucc.ordercontrol.uti.BusinessException;

public class ProduceManager {
	ProduceDao aDao = new ProduceDao();

	public void CreateProduce(Produce Produce) throws BusinessException {
		// check right
		if (Produce.getProduceId() == null || Produce.getProduceId().equals("")) {
			throw new BusinessException("Produce id is null");
		}

		// check exist
		if (search(Produce) != null) {
			throw new BusinessException("Produceid has existed");
		}

		if (aDao.CreateProduce(Produce))// create
		{
			// ok
			JOptionPane.showMessageDialog(null, "创建成功", "消息提醒", JOptionPane.WARNING_MESSAGE);

		} else {
			// no
			JOptionPane.showMessageDialog(null, "创建失败", "消息提醒", JOptionPane.WARNING_MESSAGE);

		}
	}

	public boolean modifyProduce(Produce Produce, Produce old) throws BusinessException {
		// check right
		if (!Produce.getProduceId().equals(old.getProduceId()) && search(Produce) != null) {
			throw new BusinessException("Produce id has existed");
		}

		return aDao.modifyProduce(Produce);
	}

	public boolean deleteProduce(Produce Produce) {
		return aDao.deleteProduce(Produce); // delete
	}

	public Produce search(Produce Produce) throws BusinessException {
		return aDao.search(Produce.getProduceId());
	}

	public List<Produce> searchProduce(String Produceid, String Productid) {
		return aDao.searchProduce(Produceid, Productid);
	}
}
