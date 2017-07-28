
package cn.edu.zucc.ordercontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.edu.zucc.ordercontrol.model.Admin;
import cn.edu.zucc.ordercontrol.uti.DBUtil;

public class AdminDao {
	// search
	public Admin search(String AdminID) {
		Connection connection = null;
		Admin aAdmin = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from Admin where Adminid=?";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, AdminID);
			ResultSet rSet = pStatement.executeQuery();
			if (rSet.next()) {
				aAdmin = new Admin();
				aAdmin.setAdminId(rSet.getString(1));
				aAdmin.setAdminName(rSet.getString(2));
				aAdmin.setAdminPasswd(rSet.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aAdmin;
	}

	// loadall
	public List<Admin> loadall() {
		Connection connection = null;
		List<Admin> rst = new ArrayList<Admin>();

		try {
			connection = DBUtil.getConnection();
			String sql = "select * from Admin";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet rSet = pStatement.executeQuery();
			while (rSet.next()) {
				Admin aAdmin = new Admin();
				aAdmin.setAdminId(rSet.getString(1));
				aAdmin.setAdminName(rSet.getString(2));
				aAdmin.setAdminPasswd(rSet.getString(3));
				rst.add(aAdmin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rst;
	}

	// create
	public boolean CreateAdmin(Admin Admin) {

		Connection connection = null;
		boolean f = false;
		try {
			connection = DBUtil.getConnection();
			String sql = "insert into Admin values(?,?,?)";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, Admin.getAdminId());
			pStatement.setString(2, Admin.getAdminName());
			pStatement.setString(3, Admin.getAdminPasswd());
			f = pStatement.execute();
			f = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	// delete
	public boolean deleteAdmin(Admin Admin) {
		boolean f = false;
		Connection connection = null;

		try {
			connection = DBUtil.getConnection();
			String sql = "delete from Admin where Adminid= ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, Admin.getAdminId());
			f = preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return f;
	}

	// modify
	public boolean modifyAdmin(Admin Admin) {
		boolean f = false;
		Connection connection = null;

		try {
			connection = DBUtil.getConnection();
			String sql = "update Admin set  AdminId=?, AdminName=?, AdminPasswd=? where AdminId =? ";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, Admin.getAdminId());
			pStatement.setString(2, Admin.getAdminName());
			pStatement.setString(3, Admin.getAdminPasswd());
			pStatement.setString(4, Admin.getAdminId());
			f = pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return f;
	}

	// Ä£ºý²éÑ¯ by name and address
	public List<Admin> searchAdmin(String AdminId, String AdminName) {
		List<Admin> rst = new ArrayList<Admin>();
		Connection connection = null;

		try {
			connection = DBUtil.getConnection();
			String sql = "select * from Admin where AdminId like ? or AdminName like ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			if (AdminId != null&&!AdminId.equals("")) {
				ps.setString(1, "%" + AdminId + "%");
			} else {
				ps.setString(1, "");
			}
			if (AdminName != null&&!AdminName.equals("")) {
				ps.setString(2, "%" + AdminName + "%");
			} else {
				ps.setString(2, "");
			}
			ResultSet rSet = ps.executeQuery();
			while (rSet.next()) {
				Admin aAdmin = new Admin();
				aAdmin.setAdminId(rSet.getString(1));
				aAdmin.setAdminName(rSet.getString(2));
				aAdmin.setAdminPasswd(rSet.getString(3));
				rst.add(aAdmin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rst;
	}
}
