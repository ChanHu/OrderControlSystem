
package cn.edu.zucc.ordercontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.edu.zucc.ordercontrol.model.Supplier;
import cn.edu.zucc.ordercontrol.uti.DBUtil;

public class SupplierDao implements ISupplierDao{
	//search
	public Supplier search(String SupplierID) {
		Connection connection=null;
		Supplier aSupplier=null;
		try {
			connection=DBUtil.getConnection();
			String sql="select * from Supplier where Supplierid=?";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			ResultSet rSet=pStatement.executeQuery();
			if(rSet.next())
			{
				aSupplier=new Supplier();
				aSupplier.setSupplierID(rSet.getString(1));
				aSupplier.setSupplierName(rSet.getString(2));
				aSupplier.setSupplierAddress(rSet.getString(3));
				aSupplier.setSupplierContacts(rSet.getString(4));
				aSupplier.setSupplierPhone(rSet.getString(5));
				aSupplier.setSupplierBriefIntroduction(rSet.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  aSupplier;
	}
	
	//loadall
	public List<Supplier> loadall() {
		Connection connection=null;
		List<Supplier> rst=new ArrayList<Supplier>();
		
		
		try {
			connection=DBUtil.getConnection();
			String sql="select * from Supplier";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			ResultSet rSet=pStatement.executeQuery();
			while(rSet.next())
			{
				Supplier aSupplier=new Supplier();
				aSupplier.setSupplierID(rSet.getString(1));
				aSupplier.setSupplierName(rSet.getString(2));
				aSupplier.setSupplierAddress(rSet.getString(3));
				aSupplier.setSupplierContacts(rSet.getString(4));
				aSupplier.setSupplierPhone(rSet.getString(5));
				aSupplier.setSupplierBriefIntroduction(rSet.getString(6));
				rst.add(aSupplier);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rst;
	}
	
	//create
	public boolean CreateSupplier(Supplier Supplier) {
		
		Connection connection=null;
		boolean f=false;
		try {
			connection=DBUtil.getConnection();
			String sql="insert into Supplier values(?,?,?,?,?,?)";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, Supplier.getSupplierID());
			pStatement.setString(2, Supplier.getSupplierName());
			pStatement.setString(3, Supplier.getSupplierAddress());
			pStatement.setString(4, Supplier.getSupplierContacts());
			pStatement.setString(5, Supplier.getSupplierPhone());
			pStatement.setString(6, Supplier.getSupplierBriefIntroduction());
			f=pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}
	//delete
	public boolean deleteSupplier(Supplier Supplier) {
		boolean f=false;
		Connection connection=null;
		
		try {
			connection=DBUtil.getConnection();
			String sql="delete from Supplier where Supplierid= ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, Supplier.getSupplierID());
			f=preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}
	//modify
	public boolean modifySupplier(Supplier Supplier) {
		boolean f=false;
		Connection  connection=null;
		
		try {
			connection=DBUtil.getConnection();
			String sql="update Supplier set SupplierID=?,SupplierName=?, SupplierAddress=?, SupplierContacts=?, SupplierPhone=?, SupplierBriefIntroduction=? where Supplierid =? ";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, Supplier.getSupplierID());
			pStatement.setString(2, Supplier.getSupplierName());
			pStatement.setString(3, Supplier.getSupplierAddress());
			pStatement.setString(4, Supplier.getSupplierContacts());
			pStatement.setString(5, Supplier.getSupplierPhone());
			pStatement.setString(6, Supplier.getSupplierBriefIntroduction());
			pStatement.setString(7, Supplier.getSupplierID());
			f=pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}
	//Ä£ºý²éÑ¯   by name and address
	public List<Supplier> searchSupplier(String Suppliername,String Supplieraddress) {
		List<Supplier> rst=new ArrayList<Supplier>();
		Connection connection=null;
		
		try {
			connection=DBUtil.getConnection();
			String sql="select * from Supplier where Suppliername like ? or Supplieraddress like ?";
			PreparedStatement ps=connection.prepareStatement(sql);
			if(Suppliername!=null)
			{
				ps.setString(1, "%"+Suppliername+"%");
			} else {
				ps.setString(1, "");
			}
			if(Supplieraddress!=null)
			{
				ps.setString(2, "%"+Supplieraddress+"%");
			} else {			
				ps.setString(2, "");
			}
			ResultSet rSet=ps.executeQuery();
			while(rSet.next())
			{
				Supplier aSupplier=new Supplier();
				aSupplier.setSupplierID(rSet.getString(1));
				aSupplier.setSupplierName(rSet.getString(2));
				aSupplier.setSupplierAddress(rSet.getString(3));
				aSupplier.setSupplierContacts(rSet.getString(4));
				aSupplier.setSupplierPhone(rSet.getString(5));
				aSupplier.setSupplierBriefIntroduction(rSet.getString(6));
				rst.add(aSupplier);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rst;
	}
}	
