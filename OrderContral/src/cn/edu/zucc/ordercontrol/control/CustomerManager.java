package cn.edu.zucc.ordercontrol.control;

import java.util.List;

import javax.swing.JOptionPane;

import cn.edu.zucc.ordercontrol.dao.CustomerDao;
import cn.edu.zucc.ordercontrol.model.Customer;
import cn.edu.zucc.ordercontrol.uti.BusinessException;

public class CustomerManager {
	CustomerDao aDao = new CustomerDao();

	public void CreateCustomer(Customer Customer) throws BusinessException {
		// check right
		if (Customer.getCustomerID() == null || Customer.getCustomerID().equals("")) {
			throw new BusinessException("Customer id is null");
		}

		// check exist
		if (search(Customer) != null) {
			throw new BusinessException("Customer id has existed");
		}

		if (aDao.CreateCustomer(Customer))// create
		{
			// ok
			JOptionPane.showMessageDialog(null, "创建成功", "消息提醒", JOptionPane.WARNING_MESSAGE);

		} else {
			// no
			JOptionPane.showMessageDialog(null, "创建失败", "消息提醒", JOptionPane.WARNING_MESSAGE);

		}
	}

	public boolean modifyCustomer(Customer Customer, Customer old) throws BusinessException {
		// check right
		if (!Customer.getCustomerID().equals(old.getCustomerID()) && search(Customer) != null) {
			throw new BusinessException("customer id has existed");
		}

		return aDao.modifyCustomer(Customer);
	}

	public boolean deleteCustomer(Customer Customer) {
		return aDao.deleteCustomer(Customer); // delete
	}

	public Customer search(Customer Customer) throws BusinessException {
		return aDao.search(Customer.getCustomerID());
	}

	public List<Customer> searchCustomer(String Customername, String Customeraddress) {
		return aDao.searchCustomer(Customername, Customeraddress);
	}
}
