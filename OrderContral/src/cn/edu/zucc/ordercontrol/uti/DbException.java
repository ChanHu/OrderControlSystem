package cn.edu.zucc.ordercontrol.uti;

public class DbException extends BaseException {
	public DbException(java.lang.Throwable ex) {
		super("���ݿ��������" + ex.getMessage());
	}
}
