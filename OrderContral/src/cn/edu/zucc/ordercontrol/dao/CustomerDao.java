
package cn.edu.zucc.ordercontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.edu.zucc.ordercontrol.model.Customer;
import cn.edu.zucc.ordercontrol.uti.DBUtil;

public class CustomerDao implements ICustomerDao {
	// search
	public Customer search(String CustomerID) {
		Connection connection = null;
		Customer aCustomer = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from Customer where Customerid=?";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, CustomerID);
			ResultSet rSet = pStatement.executeQuery();
			if (rSet.next()) {
				aCustomer = new Customer();
				aCustomer.setCustomerID(rSet.getString(1));
				aCustomer.setCustomerName(rSet.getString(2));
				aCustomer.setCustomerAddresss(rSet.getString(3));
				aCustomer.setCustomerContacts(rSet.getString(4));
				aCustomer.setCustomerPhone(rSet.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aCustomer;
	}

	// loadall
	public List<Customer> loadall() {
		Connection connection = null;
		List<Customer> rst = new ArrayList<Customer>();

		try {
			connection = DBUtil.getConnection();
			String sql = "select * from Customer";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet rSet = pStatement.executeQuery();
			while (rSet.next()) {
				Customer aCustomer = new Customer();
				aCustomer.setCustomerID(rSet.getString(1));
				aCustomer.setCustomerName(rSet.getString(2));
				aCustomer.setCustomerAddresss(rSet.getString(3));
				aCustomer.setCustomerContacts(rSet.getString(4));
				aCustomer.setCustomerPhone(rSet.getString(5));
				rst.add(aCustomer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rst;
	}

	// create
	public boolean CreateCustomer(Customer Customer) {

		Connection connection = null;
		boolean f = false;
		try {
			connection = DBUtil.getConnection();
			String sql = "insert into Customer values(?,?,?,?,?)";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, Customer.getCustomerID());
			pStatement.setString(2, Customer.getCustomerName());
			pStatement.setString(3, Customer.getCustomerAddresss());
			pStatement.setString(4, Customer.getCustomerContacts());
			pStatement.setString(5, Customer.getCustomerPhone());
			f = pStatement.execute();
			f = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	// delete
	public boolean deleteCustomer(Customer Customer) {
		boolean f = false;
		Connection connection = null;

		try {
			connection = DBUtil.getConnection();
			String sql = "delete from Customer where Customerid= ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, Customer.getCustomerID());
			f = preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return f;
	}

	// modify
	public boolean modifyCustomer(Customer Customer) {
		boolean f = false;
		Connection connection = null;

		try {
			connection = DBUtil.getConnection();
			String sql = "update Customer set CustomerID=?,CustomerName=?, CustomerAddresss=?, CustomerContacts=?, CustomerPhone=? where Customerid =? ";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, Customer.getCustomerID());
			pStatement.setString(2, Customer.getCustomerName());
			pStatement.setString(3, Customer.getCustomerAddresss());
			pStatement.setString(4, Customer.getCustomerContacts());
			pStatement.setString(5, Customer.getCustomerPhone());
			pStatement.setString(6, Customer.getCustomerID());
			f = pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return f;
	}

	// Ä£ºý²éÑ¯ by name and address
	public List<Customer> searchCustomer(String CustomerName, String Customeraddress) {
		List<Customer> rst = new ArrayList<Customer>();
		Connection connection = null;

		try {
			connection = DBUtil.getConnection();
			String sql = "select * from Customer where CustomerName like ? or Customeraddresss like ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			if (CustomerName != null && !CustomerName.equals("")) {
				ps.setString(1, "%" + CustomerName + "%");
			} else {
				ps.setString(1, "");
			}
			if (Customeraddress != null && Customeraddress.equals("")) {
				ps.setString(2, "%" + Customeraddress + "%");
			} else {
				ps.setString(2, "");
			}
			ResultSet rSet = ps.executeQuery();
			while (rSet.next()) {
				Customer aCustomer = new Customer();
				aCustomer.setCustomerID(rSet.getString(1));
				aCustomer.setCustomerName(rSet.getString(2));
				aCustomer.setCustomerAddresss(rSet.getString(3));
				aCustomer.setCustomerContacts(rSet.getString(4));
				aCustomer.setCustomerPhone(rSet.getString(5));
				rst.add(aCustomer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rst;
	}
}
