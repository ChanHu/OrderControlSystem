
package cn.edu.zucc.ordercontrol.dao;

import java.util.List;

import cn.edu.zucc.ordercontrol.model.Admin;

public interface IAdminDao {
	// search
	public Admin search(String AdminID);

	// loadall
	public List<Admin> loadall();

	// create
	public boolean CreateAdmin(Admin Admin);

	// delete
	public boolean deleteAdmin(Admin Admin);

	// Ä£ºý²éÑ¯ by name and address
	public List<Admin> searchAdmin(String Adminname, String AdminID);
}
