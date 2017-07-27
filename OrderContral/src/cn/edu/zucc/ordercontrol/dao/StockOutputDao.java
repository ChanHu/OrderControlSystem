
package cn.edu.zucc.ordercontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.edu.zucc.ordercontrol.model.StockOutput;
import cn.edu.zucc.ordercontrol.uti.DBUtil;

public class StockOutputDao implements IStockOutputDao {
	// search
	public StockOutput search(String StockOutputID) {
		Connection connection = null;
		StockOutput aStockOutput = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from StockOutput where StockOutputid=?";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, StockOutputID);
			ResultSet rSet = pStatement.executeQuery();
			if (rSet.next()) {
				aStockOutput = new StockOutput();
				aStockOutput.setProductId(rSet.getString(1));
				aStockOutput.setStockOutputID(rSet.getString(2));
				aStockOutput.setStockOutputDate(rSet.getDate(3));
				aStockOutput.setStockOutputCount(rSet.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aStockOutput;
	}

	// loadall
	public List<StockOutput> loadall() {
		Connection connection = null;
		List<StockOutput> rst = new ArrayList<StockOutput>();

		try {
			connection = DBUtil.getConnection();
			String sql = "select * from StockOutput";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet rSet = pStatement.executeQuery();
			while (rSet.next()) {
				StockOutput aStockOutput = new StockOutput();
				aStockOutput.setProductId(rSet.getString(1));
				aStockOutput.setStockOutputID(rSet.getString(2));
				aStockOutput.setStockOutputDate(rSet.getDate(3));
				aStockOutput.setStockOutputCount(rSet.getString(4));
				rst.add(aStockOutput);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rst;
	}

	// create
	public boolean CreateStockOutput(StockOutput StockOutput) {

		Connection connection = null;
		boolean f = false;
		try {
			connection = DBUtil.getConnection();
			String sql = "insert into StockOutput values(?,?,?,?)";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, StockOutput.getProductId());
			pStatement.setString(2, StockOutput.getStockOutputID());
			pStatement.setDate(3, StockOutput.getStockOutputDate());
			pStatement.setString(4, StockOutput.getStockOutputCount());
			f = pStatement.execute();
			f = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	// delete
	public boolean deleteStockOutput(StockOutput StockOutput) {
		boolean f = false;
		Connection connection = null;

		try {
			connection = DBUtil.getConnection();
			String sql = "delete from StockOutput where StockOutputid= ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, StockOutput.getStockOutputID());
			f = preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return f;
	}

	// modify
	public boolean modifyStockOutput(StockOutput StockOutput) {
		boolean f = false;
		Connection connection = null;

		try {
			connection = DBUtil.getConnection();
			String sql = "update StockOutput set ProductId=?,StockOutputID=?, StockOutputDate=?, StockOutputCount=? where StockOutputID =? ";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, StockOutput.getProductId());
			pStatement.setString(2, StockOutput.getStockOutputID());
			pStatement.setDate(3, StockOutput.getStockOutputDate());
			pStatement.setString(4, StockOutput.getStockOutputCount());
			pStatement.setString(5, StockOutput.getStockOutputID());
			f = pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return f;
	}

	// Ä£ºý²éÑ¯ by name and address
	public List<StockOutput> searchStockOutput(String ProductId, String StockOutputID) {
		List<StockOutput> rst = new ArrayList<StockOutput>();
		Connection connection = null;

		try {
			connection = DBUtil.getConnection();
			String sql = "select * from StockOutput where ProductId like ? or StockOutputID like ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			if (ProductId != null) {
				ps.setString(1, "%" + ProductId + "%");
			} else {
				ps.setString(1, "");
			}
			if (StockOutputID != null) {
				ps.setString(2, "%" + StockOutputID + "%");
			} else {
				ps.setString(2, "");
			}
			ResultSet rSet = ps.executeQuery();
			while (rSet.next()) {
				StockOutput aStockOutput = new StockOutput();
				aStockOutput.setProductId(rSet.getString(1));
				aStockOutput.setStockOutputID(rSet.getString(2));
				aStockOutput.setStockOutputDate(rSet.getDate(3));
				aStockOutput.setStockOutputCount(rSet.getString(4));
				rst.add(aStockOutput);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rst;
	}
}
