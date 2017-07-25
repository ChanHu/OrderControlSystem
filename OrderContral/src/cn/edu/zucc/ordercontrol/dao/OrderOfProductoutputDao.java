
package cn.edu.zucc.ordercontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.edu.zucc.ordercontrol.model.OrderOfProductoutput;
import cn.edu.zucc.ordercontrol.uti.DBUtil;

public class OrderOfProductoutputDao implements IOrderOfProductoutputDao{
	//search
	public OrderOfProductoutput search(String OrderOfProductoutputID) {
		Connection connection=null;
		OrderOfProductoutput aOrderOfProductoutput=null;
		try {
			connection=DBUtil.getConnection();
			String sql="select * from OrderOfProductoutput where OrderOfProductoutputid=?";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			ResultSet rSet=pStatement.executeQuery();
			if(rSet.next())
			{
				aOrderOfProductoutput=new OrderOfProductoutput();
				aOrderOfProductoutput.setProductId(rSet.getString(1));
				aOrderOfProductoutput.setCustomerID(rSet.getString(2));
				aOrderOfProductoutput.setOrderOfOPID(rSet.getString(3));
				aOrderOfProductoutput.setOutputCount(rSet.getString(4));
				aOrderOfProductoutput.setOutputDate(rSet.getDate(5));
				aOrderOfProductoutput.setOutputPrice(rSet.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  aOrderOfProductoutput;
	}
	
	//loadall
	public List<OrderOfProductoutput> loadall() {
		Connection connection=null;
		List<OrderOfProductoutput> rst=new ArrayList<OrderOfProductoutput>();
		
		
		try {
			connection=DBUtil.getConnection();
			String sql="select * from OrderOfProductoutput";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			ResultSet rSet=pStatement.executeQuery();
			while(rSet.next())
			{
				OrderOfProductoutput aOrderOfProductoutput=new OrderOfProductoutput();
				aOrderOfProductoutput=new OrderOfProductoutput();
				aOrderOfProductoutput.setProductId(rSet.getString(1));
				aOrderOfProductoutput.setCustomerID(rSet.getString(2));
				aOrderOfProductoutput.setOrderOfOPID(rSet.getString(3));
				aOrderOfProductoutput.setOutputCount(rSet.getString(4));
				aOrderOfProductoutput.setOutputDate(rSet.getDate(5));
				aOrderOfProductoutput.setOutputPrice(rSet.getString(6));
			rst.add(aOrderOfProductoutput);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rst;
	}
	
	//create
	public boolean CreateOrderOfProductoutput(OrderOfProductoutput OrderOfProductoutput) {
		
		Connection connection=null;
		boolean f=false;
		try {
			connection=DBUtil.getConnection();
			String sql="insert into OrderOfProductoutput values(?,?,?,?,?,?)";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, OrderOfProductoutput.getProductId());
			pStatement.setString(2, OrderOfProductoutput.getCustomerID());
			pStatement.setString(3, OrderOfProductoutput.getOrderOfOPID());
			pStatement.setString(4, OrderOfProductoutput.getOutputCount());
			pStatement.setDate(5, OrderOfProductoutput.getOutputDate());
			pStatement.setString(6, OrderOfProductoutput.getOutputPrice());
			f=pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}
	//delete
	public boolean deleteOrderOfProductoutput(OrderOfProductoutput OrderOfProductoutput) {
		boolean f=false;
		Connection connection=null;
		
		try {
			connection=DBUtil.getConnection();
			String sql="delete from OrderOfProductoutput where OrderOfOPID= ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, OrderOfProductoutput.getOrderOfOPID());
			f=preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}
	//modify
	public boolean modifyOrderOfProductoutput(OrderOfProductoutput OrderOfProductoutput) {
		boolean f=false;
		Connection  connection=null;
		
		try {
			connection=DBUtil.getConnection();
			String sql="update OrderOfProductoutput set ProductId=?,CustomerID=?, OrderOfOPID=?, getOutputCount=?, OutputDate=?, OutputPrice=? where ProductId =? ";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, OrderOfProductoutput.getProductId());
			pStatement.setString(2, OrderOfProductoutput.getCustomerID());
			pStatement.setString(3, OrderOfProductoutput.getOrderOfOPID());
			pStatement.setString(4, OrderOfProductoutput.getOutputCount());
			pStatement.setDate(5, OrderOfProductoutput.getOutputDate());
			pStatement.setString(6, OrderOfProductoutput.getOutputPrice());
			pStatement.setString(7, OrderOfProductoutput.getProductId());
			f=pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}
	//Ä£ºý²éÑ¯   by name and address
	public List<OrderOfProductoutput> searchOrderOfProductoutput(String ProductId,String OutputDate) {
		List<OrderOfProductoutput> rst=new ArrayList<OrderOfProductoutput>();
		Connection connection=null;
		
		try {
			connection=DBUtil.getConnection();
			String sql="select * from OrderOfProductoutput where ProductId like ? or OutputDate like ?";
			PreparedStatement ps=connection.prepareStatement(sql);
			if(ProductId!=null)
			{
				ps.setString(1, "%"+ProductId+"%");
			} else {
				ps.setString(1, "");
			}
			if(OutputDate!=null)
			{
				ps.setString(2, "%"+OutputDate+"%");
			} else {			
				ps.setString(2, "");
			}
			ResultSet rSet=ps.executeQuery();
			while(rSet.next())
			{
				OrderOfProductoutput aOrderOfProductoutput=new OrderOfProductoutput();
				aOrderOfProductoutput=new OrderOfProductoutput();
				aOrderOfProductoutput.setProductId(rSet.getString(1));
				aOrderOfProductoutput.setCustomerID(rSet.getString(2));
				aOrderOfProductoutput.setOrderOfOPID(rSet.getString(3));
				aOrderOfProductoutput.setOutputCount(rSet.getString(4));
				aOrderOfProductoutput.setOutputDate(rSet.getDate(5));
				aOrderOfProductoutput.setOutputPrice(rSet.getString(6));
			rst.add(aOrderOfProductoutput);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rst;
	}
}	
