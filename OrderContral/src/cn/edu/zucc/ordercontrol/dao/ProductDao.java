
package cn.edu.zucc.ordercontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.edu.zucc.ordercontrol.model.Product;
import cn.edu.zucc.ordercontrol.uti.DBUtil;

public class ProductDao implements IProductDao{
	//search
	public Product search(String ProductID) {
		Connection connection=null;
		Product aProduct=null;
		try {
			connection=DBUtil.getConnection();
			String sql="select * from Product where ProductId=?";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			ResultSet rSet=pStatement.executeQuery();
			if(rSet.next())
			{
				aProduct=new Product();
				aProduct.setProductId(rSet.getString(1));
				aProduct.setProductTypeID(rSet.getString(2));
				aProduct.setProductName(rSet.getString(3));
				aProduct.setProductPrice(rSet.getString(4));
				aProduct.setProductIntroduction(rSet.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  aProduct;
	}
	
	//loadall
	public List<Product> loadall() {
		Connection connection=null;
		List<Product> rst=new ArrayList<Product>();
		
		
		try {
			connection=DBUtil.getConnection();
			String sql="select * from Product";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			ResultSet rSet=pStatement.executeQuery();
			while(rSet.next())
			{
				Product aProduct=new Product();
				aProduct.setProductId(rSet.getString(1));
				aProduct.setProductTypeID(rSet.getString(2));
				aProduct.setProductName(rSet.getString(3));
				aProduct.setProductPrice(rSet.getString(4));
				aProduct.setProductIntroduction(rSet.getString(5));
			rst.add(aProduct);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rst;
	}
	
	//create
	public boolean CreateProduct(Product Product) {
		
		Connection connection=null;
		boolean f=false;
		try {
			connection=DBUtil.getConnection();
			String sql="insert into Product values(?,?,?,?,?)";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, Product.getProductId());
			pStatement.setString(2, Product.getProductTypeID());
			pStatement.setString(3, Product.getProductName());
			pStatement.setString(4, Product.getProductPrice());
			pStatement.setString(5, Product.getProductIntroduction());
			f=pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}
	//delete
	public boolean deleteProduct(Product Product) {
		boolean f=false;
		Connection connection=null;
		
		try {
			connection=DBUtil.getConnection();
			String sql="delete from Product where Productid= ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, Product.getProductId());
			f=preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}
	//modify
	public boolean modifyProduct(Product Product) {
		boolean f=false;
		Connection  connection=null;
		
		try {
			connection=DBUtil.getConnection();
			String sql="update Product set ProductId=?,ProductTypeID=?, ProductName=?, ProductPrice=?, getProductIntroduction=? where ProductId =? ";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, Product.getProductId());
			pStatement.setString(2, Product.getProductTypeID());
			pStatement.setString(3, Product.getProductName());
			pStatement.setString(4, Product.getProductPrice());
			pStatement.setString(5, Product.getProductIntroduction());
			pStatement.setString(6, Product.getProductId());
			f=pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}
	//Ä£ºý²éÑ¯   by name and address
	public List<Product> searchProduct(String ProductId,String ProductName) {
		List<Product> rst=new ArrayList<Product>();
		Connection connection=null;
		
		try {
			connection=DBUtil.getConnection();
			String sql="select * from Product where ProductId like ? or ProductName like ?";
			PreparedStatement ps=connection.prepareStatement(sql);
			if(ProductId!=null)
			{
				ps.setString(1, "%"+ProductId+"%");
			} else {
				ps.setString(1, "");
			}
			if(ProductName!=null)
			{
				ps.setString(2, "%"+ProductName+"%");
			} else {			
				ps.setString(2, "");
			}
			ResultSet rSet=ps.executeQuery();
			while(rSet.next())
			{
				Product aProduct=new Product();
				aProduct.setProductId(rSet.getString(1));
				aProduct.setProductTypeID(rSet.getString(2));
				aProduct.setProductName(rSet.getString(3));
				aProduct.setProductPrice(rSet.getString(4));
				aProduct.setProductIntroduction(rSet.getString(5));
			rst.add(aProduct);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rst;
	}
}	
