
package cn.edu.zucc.ordercontrol.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.edu.zucc.ordercontrol.model.StockInput;
import cn.edu.zucc.ordercontrol.uti.DBUtil;

public class StockInputDao implements IStockInputDao {
	// search
	public StockInput search(String StockInputID) {
		Connection connection = null;
		StockInput aStockInput = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from StockInput where StockInputid=?";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, StockInputID);
			ResultSet rSet = pStatement.executeQuery();
			if (rSet.next()) {
				aStockInput = new StockInput();
				aStockInput.setMaterialId(rSet.getString(1));
				aStockInput.setStockInputID(rSet.getString(2));
				aStockInput.setStockInputDate(rSet.getDate(3));
				aStockInput.setStockInputCount(rSet.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aStockInput;
	}

	// loadall
	public List<StockInput> loadall() {
		Connection connection = null;
		List<StockInput> rst = new ArrayList<StockInput>();

		try {
			connection = DBUtil.getConnection();
			String sql = "select * from StockInput";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet rSet = pStatement.executeQuery();
			while (rSet.next()) {
				StockInput aStockInput = new StockInput();
				aStockInput.setMaterialId(rSet.getString(1));
				aStockInput.setStockInputID(rSet.getString(2));
				aStockInput.setStockInputDate(rSet.getDate(3));
				aStockInput.setStockInputCount(rSet.getString(4));
				aStockInput.setStockInputFinish(rSet.getBoolean(5));
				rst.add(aStockInput);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rst;
	}

	// create
	public boolean CreateStockInput(StockInput StockInput) {

		Connection connection = null;
		boolean f = false;
		try {
			connection = DBUtil.getConnection();
			String sql = "insert into StockInput values(?,?,?,?,?)";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, StockInput.getMaterialId());
			pStatement.setString(2, StockInput.getStockInputID());
			pStatement.setDate(3, null);
			pStatement.setString(4, StockInput.getStockInputCount());
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
	public boolean deleteStockInput(StockInput StockInput) {
		boolean f = false;
		Connection connection = null;

		try {
			connection = DBUtil.getConnection();
			String sql = "delete from StockInput where StockInputid= ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, StockInput.getStockInputID());
			f = preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return f;
	}

	// modify
	public boolean modifyStockInput(StockInput StockInput) {
		boolean f = false;
		Connection connection = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "update StockInput set MaterialId=?,StockInputID=?,StockInputDate=?, StockInputCount=? ,StockInputFinish =? where StockInputID =? ";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, StockInput.getMaterialId());
			pStatement.setString(2, StockInput.getStockInputID());
			pStatement.setDate(3, new Date(System.currentTimeMillis()));
			pStatement.setString(4, StockInput.getStockInputCount());
			pStatement.setBoolean(5, StockInput.isStockInputFinish());
			System.out.println(StockInput.isStockInputFinish());
			System.out.println(StockInput.getStockInputID());
			pStatement.setString(6, StockInput.getStockInputID());
			f = pStatement.execute();
			pStatement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return f;
	}

	// Ä£ºý²éÑ¯ by name and address
	public List<StockInput> searchStockInput(String MaterialId, String StockInputID) {
		List<StockInput> rst = new ArrayList<StockInput>();
		Connection connection = null;

		try {
			connection = DBUtil.getConnection();
			String sql = "select * from StockInput where MaterialId like ? or StockInputID like ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			if (MaterialId != null&&!MaterialId.equals("")) {
				ps.setString(1, "%" + MaterialId + "%");
			} else {
				ps.setString(1, "");
			}
			if (StockInputID != null&&!StockInputID.equals("")) {
				ps.setString(2, "%" + StockInputID + "%");
			} else {
				ps.setString(2, "");
			}
			ResultSet rSet = ps.executeQuery();
			while (rSet.next()) {
				StockInput aStockInput = new StockInput();
				aStockInput.setMaterialId(rSet.getString(1));
				aStockInput.setStockInputID(rSet.getString(2));
				aStockInput.setStockInputDate(rSet.getDate(3));
				aStockInput.setStockInputCount(rSet.getString(4));
				aStockInput.setStockInputFinish(rSet.getBoolean(5));
				rst.add(aStockInput);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rst;
	}
}
