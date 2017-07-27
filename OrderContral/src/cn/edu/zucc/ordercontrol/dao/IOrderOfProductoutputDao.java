
package cn.edu.zucc.ordercontrol.dao;

import java.util.List;

import cn.edu.zucc.ordercontrol.model.OrderOfProductoutput;

public interface IOrderOfProductoutputDao {
	// search
	public OrderOfProductoutput search(String OrderOfProductoutputID);

	// loadall
	public List<OrderOfProductoutput> loadall();

	// create
	public boolean CreateOrderOfProductoutput(OrderOfProductoutput OrderOfProductoutput);

	// delete
	public boolean deleteOrderOfProductoutput(OrderOfProductoutput OrderOfProductoutput);

	// Ä£ºý²éÑ¯ by name and address
	public List<OrderOfProductoutput> searchOrderOfProductoutput(String OrderOfProductoutputname,
			String OrderOfProductoutputID);
}
