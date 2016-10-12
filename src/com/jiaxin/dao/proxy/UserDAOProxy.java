package com.jiaxin.dao.proxy;

import com.jiaxin.dao.IUserDao;
import com.jiaxin.dao.UserDao;
import com.jiaxin.dbc.DatabaseConnection;
import com.jiaxin.vo.User;

public class UserDAOProxy implements IUserDao {
	private DatabaseConnection dbc = null;
	private IUserDao dao = null;
	public UserDAOProxy(){
		try {
			dbc = new DatabaseConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao = new UserDao(dbc.getConnection());
		
	}
	

	@Override
	public boolean findLogin(User user) throws Exception {
		boolean flag = false;
		try {
			flag = dao.findLogin(user);
		} catch (Exception e) {
			throw e;
		}finally{
			dbc.close();
		}
		return flag;
		
	}

}
