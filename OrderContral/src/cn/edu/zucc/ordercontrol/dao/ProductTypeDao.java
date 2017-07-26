
package cn.edu.zucc.ordercontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.edu.zucc.ordercontrol.model.ProductType;
import cn.edu.zucc.ordercontrol.uti.DBUtil;

public class ProductTypeDao implements IProductTypeDao{
	//search
	public ProductType search(String ProductTypeID) {
		Connection connection=null;
		ProductType aProductType=null;
		try {
			connection=DBUtil.getConnection();
			String sql="select * from ProductType where ProductTypeid=?";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, ProductTypeID);
			ResultSet rSet=pStatement.executeQuery();
			if(rSet.next())
			{
				aProductType=new ProductType();
				aProductType.setProductTypeID(rSet.getString(1));
				aProductType.setProductTypeName(rSet.getString(2));
				aProductType.setProductTypeIntroduction(rSet.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  aProductType;
	}
	
	//loadall
	public List<ProductType> loadall() {
		Connection connection=null;
		List<ProductType> rst=new ArrayList<ProductType>();
		
		
		try {
			connection=DBUtil.getConnection();
			String sql="select * from ProductType";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			ResultSet rSet=pStatement.executeQuery();
			while(rSet.next())
			{
				ProductType aProductType=new ProductType();
				aProductType.setProductTypeID(rSet.getString(1));
				aProductType.setProductTypeName(rSet.getString(2));
				aProductType.setProductTypeIntroduction(rSet.getString(3));rst.add(aProductType);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rst;
	}
	
	//create
	public boolean CreateProductType(ProductType ProductType) {
		
		Connection connection=null;
		boolean f=false;
		try {
			connection=DBUtil.getConnection();
			String sql="insert into ProductType values(?,?,?)";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, ProductType.getProductTypeID());
			pStatement.setString(2, ProductType.getProductTypeName());
			pStatement.setString(3, ProductType.getProductTypeIntroduction());
			f=pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}
	//delete
	public boolean deleteProductType(ProductType ProductType) {
		boolean f=false;
		Connection connection=null;
		
		try {
			connection=DBUtil.getConnection();
			String sql="delete from ProductType where ProductTypeid= ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, ProductType.getProductTypeID());
			f=preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}
	//modify
	public boolean modifyProductType(ProductType ProductType) {
		boolean f=false;
		Connection  connection=null;
		
		try {
			connection=DBUtil.getConnection();
			String sql="update ProductType set ProductTypeID=?,ProductTypeName=?, ProductTypeIntroduction=? where getProductTypeID =? ";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, ProductType.getProductTypeID());
			pStatement.setString(2, ProductType.getProductTypeName());
			pStatement.setString(3, ProductType.getProductTypeIntroduction());
			pStatement.setString(4, ProductType.getProductTypeID());
			f=pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}
	//Ä£ºý²éÑ¯   by name and address
	public List<ProductType> searchProductType(String ProductTypeName,String ProductTypeID) {
		List<ProductType> rst=new ArrayList<ProductType>();
		Connection connection=null;
		
		try {
			connection=DBUtil.getConnection();
			String sql="select * from ProductType where ProductTypeNamelike ? or ProductTypeID like ?";
			PreparedStatement ps=connection.prepareStatement(sql);
			if(ProductTypeName!=null)
			{
				ps.setString(1, "%"+ProductTypeName+"%");
			} else {
				ps.setString(1, "");
			}
			if(ProductTypeID!=null)
			{
				ps.setString(2, "%"+ProductTypeID+"%");
			} else {			
				ps.setString(2, "");
			}
			ResultSet rSet=ps.executeQuery();
			while(rSet.next())
			{
				ProductType aProductType=new ProductType();
				aProductType.setProductTypeID(rSet.getString(1));
				aProductType.setProductTypeName(rSet.getString(2));
				aProductType.setProductTypeIntroduction(rSet.getString(3));rst.add(aProductType);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rst;
	}
}	
