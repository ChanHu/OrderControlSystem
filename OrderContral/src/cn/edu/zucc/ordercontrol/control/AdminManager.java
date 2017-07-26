package cn.edu.zucc.ordercontrol.control;

import javax.swing.JOptionPane;

import cn.edu.zucc.ordercontrol.dao.AdminDao;
import cn.edu.zucc.ordercontrol.model.Admin;
import cn.edu.zucc.ordercontrol.uti.BusinessException;

public class AdminManager {
	AdminDao aDao=new AdminDao();

	public Admin reg(String adminid, String pwd1, String pwd2,String name) {
		// TODO Auto-generated method stub
		Admin admin=null;
		if(!pwd1.equals(pwd2)){
			JOptionPane.showMessageDialog(null,  "���벻һ��","������ʾ",JOptionPane.ERROR_MESSAGE);
			try {
				throw new BusinessException("���벻һ��");
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(aDao.search(adminid)!=null){
			JOptionPane.showMessageDialog(null,  "�˺��Ѵ���","������ʾ",JOptionPane.ERROR_MESSAGE);
			try {
				throw new BusinessException("�˺��Ѵ���");
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Admin aaAdmin=new Admin();
		aaAdmin.setAdminId(adminid);
		aaAdmin.setAdminPasswd(pwd2);
		aaAdmin.setAdminName(name);
		if(aDao.CreateAdmin(aaAdmin)){
			admin=aaAdmin;
		}
		return admin;
	}

}
