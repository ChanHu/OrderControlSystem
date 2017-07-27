
package cn.edu.zucc.ordercontrol.dao;

import java.util.List;

import cn.edu.zucc.ordercontrol.model.Productform;

public interface IProductformDao {
	// search
	public Productform search(String ProductformID);

	// loadall
	public List<Productform> loadall();

	// create
	public boolean CreateProductform(Productform Productform);

	// delete
	public boolean deleteProductform(Productform Productform);

	// ģ����ѯ by name and address
	public List<Productform> searchProductform(String Productformname, String ProductformID);
}
