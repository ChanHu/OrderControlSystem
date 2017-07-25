
package cn.edu.zucc.ordercontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.edu.zucc.ordercontrol.model.Productform;
import cn.edu.zucc.ordercontrol.uti.DBUtil;

public class ProductformDao implements IProductformDao{
	//search
	public Productform search(String ProductformID) {
		Connection connection=null;
		Productform aProductform=null;
		try {
			connection=DBUtil.getConnection();
			String sql="select * from Productform where ProductId=?";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			ResultSet rSet=pStatement.executeQuery();
			if(rSet.next())
			{
				aProductform=new Productform();
				aProductform.setProductId(rSet.getString(1));
				aProductform.setMaterialId(rSet.getString(2));
				aProductform.setMaterialcount(rSet.getString(3));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  aProductform;
	}
	
	//loadall
	public List<Productform> loadall() {
		Connection connection=null;
		List<Productform> rst=new ArrayList<Productform>();
		
		
		try {
			connection=DBUtil.getConnection();
			String sql="select * from Productform";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			ResultSet rSet=pStatement.executeQuery();
			while(rSet.next())
			{
				Productform aProductform=new Productform();
				aProductform.setProductId(rSet.getString(1));
				aProductform.setMaterialId(rSet.getString(2));
				aProductform.setMaterialcount(rSet.getString(3));
				rst.add(aProductform);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rst;
	}
	
	//create
	public boolean CreateProductform(Productform Productform) {
		
		Connection connection=null;
		boolean f=false;
		try {
			connection=DBUtil.getConnection();
			String sql="insert into Productform values(?,?,?)";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, Productform.getProductId());
			pStatement.setString(2, Productform.getMaterialId());
			pStatement.setString(3, Productform.getMaterialcount());
			f=pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}
	//delete
	public boolean deleteProductform(Productform Productform) {
		boolean f=false;
		Connection connection=null;
		
		try {
			connection=DBUtil.getConnection();
			String sql="delete from Productform where Productid= ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, Productform.getProductId());
			f=preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}
	//modify
	public boolean modifyProductform(Productform Productform) {
		boolean f=false;
		Connection  connection=null;
		
		try {
			connection=DBUtil.getConnection();
			String sql="update Productform set ProductId=?,MaterialId=?, Materialcount=? where ProductId =? ";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, Productform.getProductId());
			pStatement.setString(2, Productform.getMaterialId());
			pStatement.setString(3, Productform.getMaterialcount());
			pStatement.setString(4, Productform.getProductId());
			f=pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}
	//Ä£ºý²éÑ¯   by name and address
	public List<Productform> searchProductform(String ProductId,String MaterialId) {
		List<Productform> rst=new ArrayList<Productform>();
		Connection connection=null;
		
		try {
			connection=DBUtil.getConnection();
			String sql="select * from Productform where ProductId like ? or MaterialId like ?";
			PreparedStatement ps=connection.prepareStatement(sql);
			if(ProductId!=null)
			{
				ps.setString(1, "%"+ProductId+"%");
			} else {
				ps.setString(1, "");
			}
			if(MaterialId!=null)
			{
				ps.setString(2, "%"+MaterialId+"%");
			} else {			
				ps.setString(2, "");
			}
			ResultSet rSet=ps.executeQuery();
			while(rSet.next())
			{
				Productform aProductform=new Productform();
				aProductform.setProductId(rSet.getString(1));
				aProductform.setMaterialId(rSet.getString(2));
				aProductform.setMaterialcount(rSet.getString(3));
				rst.add(aProductform);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rst;
	}
}	
