
package cn.edu.zucc.ordercontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.edu.zucc.ordercontrol.model.Material;
import cn.edu.zucc.ordercontrol.uti.DBUtil;

public class MaterialDao implements IMaterialDao{
	//search
	public Material search(String MaterialID) {
		Connection connection=null;
		Material aMaterial=null;
		try {
			connection=DBUtil.getConnection();
			String sql="select * from Material where Materialid=?";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			ResultSet rSet=pStatement.executeQuery();
			if(rSet.next())
			{
				aMaterial=new Material();
				aMaterial.setMaterialId(rSet.getString(1));
				aMaterial.setSupplierID(rSet.getString(2));
				aMaterial.setMaterialName(rSet.getString(3));
				aMaterial.setMaterialGuidePrice(rSet.getString(4));
				aMaterial.setMaterialIntroduction(rSet.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  aMaterial;
	}
	
	//loadall
	public List<Material> loadall() {
		Connection connection=null;
		List<Material> rst=new ArrayList<Material>();
		
		
		try {
			connection=DBUtil.getConnection();
			String sql="select * from Material";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			ResultSet rSet=pStatement.executeQuery();
			while(rSet.next())
			{
				Material aMaterial=new Material();
				aMaterial=new Material();
				aMaterial.setMaterialId(rSet.getString(1));
				aMaterial.setSupplierID(rSet.getString(2));
				aMaterial.setMaterialName(rSet.getString(3));
				aMaterial.setMaterialGuidePrice(rSet.getString(4));
				aMaterial.setMaterialIntroduction(rSet.getString(5));
			rst.add(aMaterial);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rst;
	}
	
	//create
	public boolean CreateMaterial(Material Material) {
		
		Connection connection=null;
		boolean f=false;
		try {
			connection=DBUtil.getConnection();
			String sql="insert into Material values(?,?,?,?,?)";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, Material.getMaterialId());
			pStatement.setString(2, Material.getSupplierID());
			pStatement.setString(3, Material.getMaterialName());
			pStatement.setString(4, Material.getMaterialGuidePrice());
			pStatement.setString(5, Material.getMaterialIntroduction());
			f=pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}
	//delete
	public boolean deleteMaterial(Material Material) {
		boolean f=false;
		Connection connection=null;
		
		try {
			connection=DBUtil.getConnection();
			String sql="delete from Material where Materialid= ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, Material.getMaterialId());
			f=preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}
	//modify
	public boolean modifyMaterial(Material Material) {
		boolean f=false;
		Connection  connection=null;
		
		try {
			connection=DBUtil.getConnection();
			String sql="update Material set MaterialId=?,SupplierID=?, MaterialName=?, MaterialGuidePrice=?, MaterialIntroduction=? where MaterialId =? ";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, Material.getMaterialId());
			pStatement.setString(2, Material.getSupplierID());
			pStatement.setString(3, Material.getMaterialName());
			pStatement.setString(4, Material.getMaterialGuidePrice());
			pStatement.setString(5, Material.getMaterialIntroduction());
			pStatement.setString(6, Material.getMaterialId());
			f=pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}
	//Ä£ºý²éÑ¯   by name and address
	public List<Material> searchMaterial(String MaterialId,String SupplierID) {
		List<Material> rst=new ArrayList<Material>();
		Connection connection=null;
		
		try {
			connection=DBUtil.getConnection();
			String sql="select * from Material where MaterialId like ? or SupplierID like ?";
			PreparedStatement ps=connection.prepareStatement(sql);
			if(MaterialId!=null)
			{
				ps.setString(1, "%"+MaterialId+"%");
			} else {
				ps.setString(1, "");
			}
			if(SupplierID!=null)
			{
				ps.setString(2, "%"+SupplierID+"%");
			} else {			
				ps.setString(2, "");
			}
			ResultSet rSet=ps.executeQuery();
			while(rSet.next())
			{
				Material aMaterial=new Material();
				aMaterial=new Material();
				aMaterial.setMaterialId(rSet.getString(1));
				aMaterial.setSupplierID(rSet.getString(2));
				aMaterial.setMaterialName(rSet.getString(3));
				aMaterial.setMaterialGuidePrice(rSet.getString(4));
				aMaterial.setMaterialIntroduction(rSet.getString(5));
			rst.add(aMaterial);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rst;
	}
}	
