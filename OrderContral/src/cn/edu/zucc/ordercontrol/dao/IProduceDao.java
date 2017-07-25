
package cn.edu.zucc.ordercontrol.dao;

import java.util.List;

import cn.edu.zucc.ordercontrol.model.Produce;

public interface IProduceDao {
	//search
	public Produce search(String ProduceId) ;
	//loadall
	public List<Produce> loadall() ;
		
	//create
	public boolean CreateProduce(Produce Produce) ;
	//delete
	public boolean deleteProduce(Produce Produce) ;
	//Ä£ºý²éÑ¯   by name and address
	public List<Produce> searchProduce(String ProduceId,String ProductId);
}
