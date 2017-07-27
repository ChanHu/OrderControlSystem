
package cn.edu.zucc.ordercontrol.dao;

import java.util.List;

import cn.edu.zucc.ordercontrol.model.OrderOfMaterialinput;

public interface IOrderOfMaterialinputDao {
	// search
	public OrderOfMaterialinput search(String OrderOfMaterialinputID);

	// loadall
	public List<OrderOfMaterialinput> loadall();

	// create
	public boolean CreateOrderOfMaterialinput(OrderOfMaterialinput OrderOfMaterialinput);

	// delete
	public boolean deleteOrderOfMaterialinput(OrderOfMaterialinput OrderOfMaterialinput);

	// Ä£ºý²éÑ¯ by name and address
	public List<OrderOfMaterialinput> searchOrderOfMaterialinput(String OrderOfMaterialinputname,
			String OrderOfMaterialinputID);
}
