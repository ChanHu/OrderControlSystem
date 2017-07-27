package cn.edu.zucc.ordercontrol.model;

public class Admin {
	public static Admin currentLoginAdmin = null;

	public static Admin getCurrentLoginAdmin() {
		return currentLoginAdmin;
	}

	public static void setCurrentLoginAdmin(Admin currentLoginAdmin) {
		Admin.currentLoginAdmin = currentLoginAdmin;
	}

	private String AdminId;
	private String AdminName;
	private String AdminPasswd;

	public String getAdminId() {
		return AdminId;
	}

	public void setAdminId(String adminId) {
		AdminId = adminId;
	}

	public String getAdminName() {
		return AdminName;
	}

	public void setAdminName(String adminName) {
		AdminName = adminName;
	}

	public String getAdminPasswd() {
		return AdminPasswd;
	}

	public void setAdminPasswd(String adminPasswd) {
		AdminPasswd = adminPasswd;
	}

}
