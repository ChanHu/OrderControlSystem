package cn.edu.zucc.ordercontrol.uti;

public class DbException extends BaseException {
	public DbException(java.lang.Throwable ex) {
		super("Êý¾Ý¿â²Ù×÷´íÎó£º" + ex.getMessage());
	}
}
