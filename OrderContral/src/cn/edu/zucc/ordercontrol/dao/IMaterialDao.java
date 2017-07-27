
package cn.edu.zucc.ordercontrol.dao;

import java.util.List;

import cn.edu.zucc.ordercontrol.model.Material;

public interface IMaterialDao {
	// search
	public Material search(String MaterialID);

	// loadall
	public List<Material> loadall();

	// create
	public boolean CreateMaterial(Material Material);

	// delete
	public boolean deleteMaterial(Material Material);

	// Ä£ºý²éÑ¯ by name and address
	public List<Material> searchMaterial(String Materialname, String MaterialID);
}
