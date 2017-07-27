package cn.edu.zucc.ordercontrol.control;

import java.util.List;

import javax.swing.JOptionPane;

import cn.edu.zucc.ordercontrol.dao.MaterialDao;
import cn.edu.zucc.ordercontrol.model.Material;
import cn.edu.zucc.ordercontrol.uti.BusinessException;

public class MaterialManager {
	MaterialDao aDao = new MaterialDao();

	// search
	public Material search(String MaterialID) {
		return aDao.search(MaterialID);
	}

	// loadall
	public List<Material> loadall() {
		return aDao.loadall();
	}

	// create
	public void CreateMaterial(Material Material) {
		// check right
		if (Material.getSupplierID() == null || Material.getSupplierID().equals("")) {
			try {
				throw new BusinessException("Materialid is null");
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// check exist
		if (search(Material.getMaterialId()) != null) {
			try {
				throw new BusinessException("Material id has existed");
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (aDao.CreateMaterial(Material))// create
		{
			// ok
			JOptionPane.showMessageDialog(null, "创建成功", "消息提醒", JOptionPane.WARNING_MESSAGE);

		} else {
			// no
			JOptionPane.showMessageDialog(null, "创建失败", "消息提醒", JOptionPane.WARNING_MESSAGE);

		}
	}

	// delete
	public boolean deleteMaterial(Material Material) {
		return aDao.deleteMaterial(Material);
	}

	// modify
	public boolean modifyMaterial(Material Material, Material old) {
		// check right

		if (!Material.getMaterialId().equals(old.getMaterialId()) && search(Material.getMaterialId()) != null) {
			try {
				throw new BusinessException("Material id has existed");
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return aDao.modifyMaterial(Material);
	}

	// 模糊查询 by name and address
	public List<Material> searchMaterial(String MaterialId, String SupplierID) {
		return aDao.searchMaterial(MaterialId, SupplierID);
	}

}
