package cn.edu.zucc.ordercontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.ordercontrol.model.Produce;
import cn.edu.zucc.ordercontrol.uti.DBUtil;

public class ProduceDao implements IProduceDao {

	public Produce search(String ProduceID) {
		Connection connection = null;
		Produce aProduce = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from Supplier where Supplierid=?";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, ProduceID);
			ResultSet rSet = pStatement.executeQuery();
			if (rSet.next()) {
				aProduce = new Produce();
				aProduce.setProduceId(rSet.getString(1));
				aProduce.setProductId(rSet.getString(2));
				aProduce.setProduceDate(rSet.getDate(3));
				aProduce.setProduceCount(rSet.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aProduce;
	}

	// loadall
	public List<Produce> loadall() {
		Connection connection = null;
		List<Produce> rst = new ArrayList<Produce>();

		try {
			connection = DBUtil.getConnection();
			String sql = "select * from Supplier";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet rSet = pStatement.executeQuery();
			while (rSet.next()) {
				Produce aProduce = new Produce();
				aProduce = new Produce();
				aProduce.setProduceId(rSet.getString(1));
				aProduce.setProductId(rSet.getString(2));
				aProduce.setProduceDate(rSet.getDate(3));
				aProduce.setProduceCount(rSet.getString(4));
				rst.add(aProduce);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rst;
	}

	// create
	public boolean CreateProduce(Produce Produce) {

		Connection connection = null;
		boolean f = false;
		try {
			connection = DBUtil.getConnection();
			String sql = "insert into Supplier values(?,?,?,?)";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, Produce.getProduceId());
			pStatement.setString(2, Produce.getProductId());
			pStatement.setDate(3, Produce.getProduceDate());
			pStatement.setString(4, Produce.getProduceCount());
			f = pStatement.execute();
			f = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	// delete
	public boolean deleteProduce(Produce Produce) {
		boolean f = false;
		Connection connection = null;

		try {
			connection = DBUtil.getConnection();
			String sql = "delete from Supplier where Supplierid= ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, Produce.getProduceId());
			f = preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return f;
	}

	// modify
	public boolean modifyProduce(Produce Produce) {
		boolean f = false;
		Connection connection = null;

		try {
			connection = DBUtil.getConnection();
			String sql = "update Supplier set ProduceId=?,ProductId=?, ProduceDate=?, ProduceCount=?,where ProduceId =? ";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, Produce.getProduceId());
			pStatement.setString(2, Produce.getProductId());
			pStatement.setDate(3, Produce.getProduceDate());
			pStatement.setString(4, Produce.getProduceCount());
			pStatement.setString(5, Produce.getProduceId());
			f = pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return f;
	}

	// Ä£ºý²éÑ¯ by name and address
	public List<Produce> searchProduce(String ProduceId, String ProductId) {
		List<Produce> rst = new ArrayList<Produce>();
		Connection connection = null;

		try {
			connection = DBUtil.getConnection();
			String sql = "select * from Supplier where Suppliername like ? or Supplieraddress like ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			if (ProduceId != null) {
				ps.setString(1, "%" + ProduceId + "%");
			} else {
				ps.setString(1, "");
			}
			if (ProductId != null) {
				ps.setString(2, "%" + ProductId + "%");
			} else {
				ps.setString(2, "");
			}
			ResultSet rSet = ps.executeQuery();
			while (rSet.next()) {
				Produce aProduce = new Produce();
				aProduce = new Produce();
				aProduce.setProduceId(rSet.getString(1));
				aProduce.setProductId(rSet.getString(2));
				aProduce.setProduceDate(rSet.getDate(3));
				aProduce.setProduceCount(rSet.getString(4));
				rst.add(aProduce);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rst;
	}

}
