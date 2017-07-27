
package cn.edu.zucc.ordercontrol.dao;

import java.util.List;

import cn.edu.zucc.ordercontrol.model.Customer;

public interface ICustomerDao {
	// search
	public Customer search(String CustomerID);

	// loadall
	public List<Customer> loadall();

	// create
	public boolean CreateCustomer(Customer Customer);

	// delete
	public boolean deleteCustomer(Customer Customer);

	// Ä£ºý²éÑ¯ by name and address
	public List<Customer> searchCustomer(String Customername, String CustomerID);
}
