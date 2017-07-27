
package cn.edu.zucc.ordercontrol.dao;

import java.util.List;

import cn.edu.zucc.ordercontrol.model.Product;

public interface IProductDao {
	// search
	public Product search(String ProduceId);

	// loadall
	public List<Product> loadall();

	// create
	public boolean CreateProduct(Product Product);

	// delete
	public boolean deleteProduct(Product Product);

	// Ä£ºý²éÑ¯ by name and address
	public List<Product> searchProduct(String ProductName, String ProductId);
}
