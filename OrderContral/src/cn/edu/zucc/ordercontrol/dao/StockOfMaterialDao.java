
package cn.edu.zucc.ordercontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.edu.zucc.ordercontrol.model.StockOfMaterial;
import cn.edu.zucc.ordercontrol.uti.DBUtil;

public class StockOfMaterialDao implements IStockOfMaterialDao{
	//search
	public StockOfMaterial search(String StockOfMaterialID) {
		Connection connection=null;
		StockOfMaterial aStockOfMaterial=null;
		try {
			connection=DBUtil.getConnection();
			String sql="select * from StockOfMaterial where StockOfMaterialId=?";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			ResultSet rSet=pStatement.executeQuery();
			if(rSet.next())
			{
				aStockOfMaterial=new StockOfMaterial();
				aStockOfMaterial.setStockOfMaterialId(rSet.getString(1));
				aStockOfMaterial.setMaterialId(rSet.getString(2));
				aStockOfMaterial.setStockOfMaterialCount(rSet.getString(3));
				aStockOfMaterial.setStockOfMaterialAddress(rSet.getString(4));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  aStockOfMaterial;
	}
	
	//loadall
	public List<StockOfMaterial> loadall() {
		Connection connection=null;
		List<StockOfMaterial> rst=new ArrayList<StockOfMaterial>();
		
		
		try {
			connection=DBUtil.getConnection();
			String sql="select * from StockOfMaterial";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			ResultSet rSet=pStatement.executeQuery();
			while(rSet.next())
			{
				StockOfMaterial aStockOfMaterial=new StockOfMaterial();
				aStockOfMaterial.setStockOfMaterialId(rSet.getString(1));
				aStockOfMaterial.setMaterialId(rSet.getString(2));
				aStockOfMaterial.setStockOfMaterialCount(rSet.getString(3));
				aStockOfMaterial.setStockOfMaterialAddress(rSet.getString(4));rst.add(aStockOfMaterial);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rst;
	}
	
	//create
	public boolean CreateStockOfMaterial(StockOfMaterial StockOfMaterial) {
		
		Connection connection=null;
		boolean f=false;
		try {
			connection=DBUtil.getConnection();
			String sql="insert into StockOfMaterial values(?,?,?,?)";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, StockOfMaterial.getStockOfMaterialId());
			pStatement.setString(2, StockOfMaterial.getMaterialId());
			pStatement.setString(3, StockOfMaterial.getStockOfMaterialCount());
			pStatement.setString(4, StockOfMaterial.getStockOfMaterialAddress());
			f=pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}
	//delete
	public boolean deleteStockOfMaterial(StockOfMaterial StockOfMaterial) {
		boolean f=false;
		Connection connection=null;
		
		try {
			connection=DBUtil.getConnection();
			String sql="delete from StockOfMaterial where StockOfMaterialid= ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, StockOfMaterial.getStockOfMaterialId());
			f=preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}
	//modify
	public boolean modifyStockOfMaterial(StockOfMaterial StockOfMaterial) {
		boolean f=false;
		Connection  connection=null;
		
		try {
			connection=DBUtil.getConnection();
			String sql="update StockOfMaterial set StockOfMaterialId=?,MaterialId=?, StockOfMaterialCount=?, StockOfMaterialAddress=? where StockOfMaterialId =? ";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, StockOfMaterial.getStockOfMaterialId());
			pStatement.setString(2, StockOfMaterial.getMaterialId());
			pStatement.setString(3, StockOfMaterial.getStockOfMaterialCount());
			pStatement.setString(4, StockOfMaterial.getStockOfMaterialAddress());
			pStatement.setString(5, StockOfMaterial.getStockOfMaterialId());
			f=pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}
	//Ä£ºý²éÑ¯   by name and address
	public List<StockOfMaterial> searchStockOfMaterial(String MaterialId,String StockOfMaterialId) {
		List<StockOfMaterial> rst=new ArrayList<StockOfMaterial>();
		Connection connection=null;
		
		try {
			connection=DBUtil.getConnection();
			String sql="select * from StockOfMaterial where MaterialId like ? or StockOfMaterialId like ?";
			PreparedStatement ps=connection.prepareStatement(sql);
			if(MaterialId!=null)
			{
				ps.setString(1, "%"+MaterialId+"%");
			} else {
				ps.setString(1, "");
			}
			if(StockOfMaterialId!=null)
			{
				ps.setString(2, "%"+StockOfMaterialId+"%");
			} else {			
				ps.setString(2, "");
			}
			ResultSet rSet=ps.executeQuery();
			while(rSet.next())
			{
				StockOfMaterial aStockOfMaterial=new StockOfMaterial();
				aStockOfMaterial.setStockOfMaterialId(rSet.getString(1));
				aStockOfMaterial.setMaterialId(rSet.getString(2));
				aStockOfMaterial.setStockOfMaterialCount(rSet.getString(3));
				aStockOfMaterial.setStockOfMaterialAddress(rSet.getString(4));rst.add(aStockOfMaterial);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rst;
	}
}	
