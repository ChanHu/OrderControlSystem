
package cn.edu.zucc.ordercontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.edu.zucc.ordercontrol.model.OrderOfMaterialinput;
import cn.edu.zucc.ordercontrol.uti.DBUtil;

public class OrderOfMaterialinputDao implements IOrderOfMaterialinputDao{
	//search
	public OrderOfMaterialinput search(String OrderOfMaterialinputID) {
		Connection connection=null;
		OrderOfMaterialinput aOrderOfMaterialinput=null;
		try {
			connection=DBUtil.getConnection();
			String sql="select * from OrderOfMaterialinput where OrderOfMaterialinputid=?";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			ResultSet rSet=pStatement.executeQuery();
			if(rSet.next())
			{
				aOrderOfMaterialinput=new OrderOfMaterialinput();
				aOrderOfMaterialinput.setOrderOfMaterialinputID(rSet.getString(1));			
				aOrderOfMaterialinput.setMaterialId(rSet.getString(2));
				aOrderOfMaterialinput.setInputCount(rSet.getString(3));
				aOrderOfMaterialinput.setInputPrice(rSet.getString(4));
				aOrderOfMaterialinput.setInputDate(rSet.getDate(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  aOrderOfMaterialinput;
	}
	
	//loadall
	public List<OrderOfMaterialinput> loadall() {
		Connection connection=null;
		List<OrderOfMaterialinput> rst=new ArrayList<OrderOfMaterialinput>();
		
		
		try {
			connection=DBUtil.getConnection();
			String sql="select * from OrderOfMaterialinput";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			ResultSet rSet=pStatement.executeQuery();
			while(rSet.next())
			{
				OrderOfMaterialinput aOrderOfMaterialinput=new OrderOfMaterialinput();
				aOrderOfMaterialinput=new OrderOfMaterialinput();
				aOrderOfMaterialinput.setOrderOfMaterialinputID(rSet.getString(1));			
				aOrderOfMaterialinput.setMaterialId(rSet.getString(2));
				aOrderOfMaterialinput.setInputCount(rSet.getString(3));
				aOrderOfMaterialinput.setInputPrice(rSet.getString(4));
				aOrderOfMaterialinput.setInputDate(rSet.getDate(5));
			rst.add(aOrderOfMaterialinput);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rst;
	}
	
	//create
	public boolean CreateOrderOfMaterialinput(OrderOfMaterialinput OrderOfMaterialinput) {
		
		Connection connection=null;
		boolean f=false;
		try {
			connection=DBUtil.getConnection();
			String sql="insert into OrderOfMaterialinput values(?,?,?,?,?)";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, OrderOfMaterialinput.getOrderOfMaterialinputID());
			pStatement.setString(2, OrderOfMaterialinput.getMaterialId());	
			pStatement.setString(3, OrderOfMaterialinput.getInputCount());
			pStatement.setString(4, OrderOfMaterialinput.getInputPrice());
			pStatement.setDate(5, OrderOfMaterialinput.getInputDate());
			f=pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}
	//delete
	public boolean deleteOrderOfMaterialinput(OrderOfMaterialinput OrderOfMaterialinput) {
		boolean f=false;
		Connection connection=null;
		
		try {
			connection=DBUtil.getConnection();
			String sql="delete from OrderOfMaterialinput where OrderOfMaterialinputid= ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, OrderOfMaterialinput.getOrderOfMaterialinputID());
			f=preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}
	//modify
	public boolean modifyOrderOfMaterialinput(OrderOfMaterialinput OrderOfMaterialinput) {
		boolean f=false;
		Connection  connection=null;
		
		try {
			connection=DBUtil.getConnection();
			String sql="update OrderOfMaterialinput set  OrderOfMaterialinputID=?,MaterialId=?, InputCount=?, InputPrice=?, InputDate=? where OrderOfMaterialinputID =? ";
			PreparedStatement pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, OrderOfMaterialinput.getOrderOfMaterialinputID());
			pStatement.setString(2, OrderOfMaterialinput.getMaterialId());	
			pStatement.setString(3, OrderOfMaterialinput.getInputCount());
			pStatement.setString(4, OrderOfMaterialinput.getInputPrice());
			pStatement.setDate(5, OrderOfMaterialinput.getInputDate());
			pStatement.setString(6, OrderOfMaterialinput.getOrderOfMaterialinputID());
			f=pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}
	//Ä£ºý²éÑ¯   by name and address
	public List<OrderOfMaterialinput> searchOrderOfMaterialinput(String MaterialId,String OrderOfMaterialinputID) {
		List<OrderOfMaterialinput> rst=new ArrayList<OrderOfMaterialinput>();
		Connection connection=null;
		
		try {
			connection=DBUtil.getConnection();
			String sql="select * from OrderOfMaterialinput where MaterialId like ? or OrderOfMaterialinputID like ?";
			PreparedStatement ps=connection.prepareStatement(sql);
			if(MaterialId!=null)
			{
				ps.setString(1, "%"+MaterialId+"%");
			} else {
				ps.setString(1, "");
			}
			if(OrderOfMaterialinputID!=null)
			{
				ps.setString(2, "%"+OrderOfMaterialinputID+"%");
			} else {			
				ps.setString(2, "");
			}
			ResultSet rSet=ps.executeQuery();
			while(rSet.next())
			{
				OrderOfMaterialinput aOrderOfMaterialinput=new OrderOfMaterialinput();
				aOrderOfMaterialinput=new OrderOfMaterialinput();
				aOrderOfMaterialinput.setOrderOfMaterialinputID(rSet.getString(1));			
				aOrderOfMaterialinput.setMaterialId(rSet.getString(2));
				aOrderOfMaterialinput.setInputCount(rSet.getString(3));
				aOrderOfMaterialinput.setInputPrice(rSet.getString(4));
				aOrderOfMaterialinput.setInputDate(rSet.getDate(5));
			rst.add(aOrderOfMaterialinput);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rst;
	}
}	
