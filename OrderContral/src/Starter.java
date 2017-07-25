import java.sql.Connection;
import java.sql.SQLException;

import cn.edu.zucc.ordercontrol.ui.FrmMain;
import cn.edu.zucc.ordercontrol.ui.FrmMain2;
import cn.edu.zucc.ordercontrol.uti.DBUtil;

public class Starter {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testConnection();
		new FrmMain2();
	}
	
	public static void testConnection(){
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			System.out.println("connected!");
		} catch (SQLException e) {
			System.out.println("connect failed!");
			e.printStackTrace();	
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
}
}
