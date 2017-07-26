
package cn.edu.zucc.ordercontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.edu.zucc.ordercontrol.model.StockOfProduct;
import cn.edu.zucc.ordercontrol.uti.DBUtil;

public class StockOfProductDao implements IStockOfProductDao{
	//search
	public StockOfProduct search(String StockOfProductID) {
		Connection connection=null;
		StockOfProduct aStockOfProduct=null;
		try {
			connection=DBUtil.getConnection();
			String sql="select * from StockOfProduct where StockOfProductid=?";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, StockOfProductID);
			ResultSet rSet=pStatement.executeQuery();
			if(rSet.next())
			{
				aStockOfProduct=new StockOfProduct();
				aStockOfProduct.setStockOfProductID(rSet.getString(1));
				aStockOfProduct.setProductId(rSet.getString(2));
				aStockOfProduct.setStockOfProductCount(rSet.getString(3));
				aStockOfProduct.setStockOfProductAddress(rSet.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  aStockOfProduct;
	}
	
	//loadall
	public List<StockOfProduct> loadall() {
		Connection connection=null;
		List<StockOfProduct> rst=new ArrayList<StockOfProduct>();
		
		
		try {
			connection=DBUtil.getConnection();
			String sql="select * from StockOfProduct";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			ResultSet rSet=pStatement.executeQuery();
			while(rSet.next())
			{
				StockOfProduct aStockOfProduct=new StockOfProduct();
				aStockOfProduct.setStockOfProductID(rSet.getString(1));
				aStockOfProduct.setProductId(rSet.getString(2));
				aStockOfProduct.setStockOfProductCount(rSet.getString(3));
				aStockOfProduct.setStockOfProductAddress(rSet.getString(4));
			rst.add(aStockOfProduct);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rst;
	}
	
	//create
	public boolean CreateStockOfProduct(StockOfProduct StockOfProduct) {
		
		Connection connection=null;
		boolean f=false;
		try {
			connection=DBUtil.getConnection();
			String sql="insert into StockOfProduct values(?,?,?,?)";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, StockOfProduct.getStockOfProductID());
			pStatement.setString(2, StockOfProduct.getProductId());
			pStatement.setString(3, StockOfProduct.getStockOfProductCount());
			pStatement.setString(4, StockOfProduct.getStockOfProductAddress());
			f=pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}
	//delete
	public boolean deleteStockOfProduct(StockOfProduct StockOfProduct) {
		boolean f=false;
		Connection connection=null;
		
		try {
			connection=DBUtil.getConnection();
			String sql="delete from StockOfProduct where StockOfProductid= ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, StockOfProduct.getStockOfProductID());
			f=preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}
	//modify
	public boolean modifyStockOfProduct(StockOfProduct StockOfProduct) {
		boolean f=false;
		Connection  connection=null;
		
		try {
			connection=DBUtil.getConnection();
			String sql="update StockOfProduct set StockOfProductID=?,ProductId=?, StockOfProductCount=?, StockOfProductAddress=? where StockOfProductid =? ";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, StockOfProduct.getStockOfProductID());
			pStatement.setString(2, StockOfProduct.getProductId());
			pStatement.setString(3, StockOfProduct.getStockOfProductCount());
			pStatement.setString(4, StockOfProduct.getStockOfProductAddress());
			pStatement.setString(5, StockOfProduct.getStockOfProductID());
			f=pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}
	//Ä£ºý²éÑ¯   by name and address
	public List<StockOfProduct> searchStockOfProduct(String StockOfProductID,String ProductId) {
		List<StockOfProduct> rst=new ArrayList<StockOfProduct>();
		Connection connection=null;
		
		try {
			connection=DBUtil.getConnection();
			String sql="select * from StockOfProduct where StockOfProductID like ? or ProductId like ?";
			PreparedStatement ps=connection.prepareStatement(sql);
			if(StockOfProductID!=null)
			{
				ps.setString(1, "%"+StockOfProductID+"%");
			} else {
				ps.setString(1, "");
			}
			if(ProductId!=null)
			{
				ps.setString(2, "%"+ProductId+"%");
			} else {			
				ps.setString(2, "");
			}
			ResultSet rSet=ps.executeQuery();
			while(rSet.next())
			{
				StockOfProduct aStockOfProduct=new StockOfProduct();
				aStockOfProduct.setStockOfProductID(rSet.getString(1));
				aStockOfProduct.setProductId(rSet.getString(2));
				aStockOfProduct.setStockOfProductCount(rSet.getString(3));
				aStockOfProduct.setStockOfProductAddress(rSet.getString(4));
			rst.add(aStockOfProduct);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rst;
	}
}	
