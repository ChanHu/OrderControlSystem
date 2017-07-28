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
			String sql = "select * from Produce where Produceid=?";
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
			String sql = "select * from Produce";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet rSet = pStatement.executeQuery();
			while (rSet.next()) {
				Produce aProduce = new Produce();
				aProduce = new Produce();
				aProduce.setProduceId(rSet.getString(1));
				aProduce.setProductId(rSet.getString(2));
				aProduce.setProduceDate(rSet.getDate(3));
				aProduce.setProduceCount(rSet.getString(4));
				aProduce.setProduceFinish(rSet.getBoolean(5));
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
			String sql = "insert into Produce values(?,?,?,?,?)";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, Produce.getProduceId());
			pStatement.setString(2, Produce.getProductId());
			pStatement.setDate(3, Produce.getProduceDate());
			pStatement.setString(4, Produce.getProduceCount());
			pStatement.setBoolean(5, false);
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
			String sql = "delete from Produce where Produceid= ?";
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
	public boolean modifyProduce(Produce produce) {
		boolean f = false;
		Connection connection = null;

		try {
			connection = DBUtil.getConnection();
			String sql = "update Produce set ProduceId=?,ProductId=?, ProduceDate=?, ProduceCount=?,ProduceFinish=? where ProduceId =? ";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, produce.getProduceId());
			pStatement.setString(2, produce.getProductId());
			pStatement.setDate(3, produce.getProduceDate());
			pStatement.setString(4, produce.getProduceCount());
			pStatement.setBoolean(5, produce.isProduceFinish());
			pStatement.setString(6, produce.getProduceId());
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
			String sql = "select * from Produce where ProduceId like ? or ProductId like ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			if (ProduceId != null&&!ProduceId.equals("")) {
				ps.setString(1, "%" + ProduceId + "%");
			} else {
				ps.setString(1, "");
			}
			if (ProductId != null&&!ProductId.equals("")) {
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
				aProduce.setProduceFinish(rSet.getBoolean(5));
				rst.add(aProduce);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rst;
	}

}
