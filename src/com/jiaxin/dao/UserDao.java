package com.jiaxin.dao;

import java.sql.*;


import com.jiaxin.vo.User;

public class UserDao implements IUserDao {
	private Connection con = null;
	private PreparedStatement ps = null;
	public UserDao(Connection con){
		this.con = con;
	}

	@Override
	public boolean findLogin(User user) throws Exception {
		boolean flag = false;
		try {
			String sql = "select name from t_user where name =? and password = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ResultSet rset = ps.executeQuery();
			if(rset.next()){
				user.setName(rset.getString(1));
				flag = true;
			}
		} catch (Exception e) {
			throw e;
		}finally{
			//¹Ø±Õ²Ù×÷
			if(ps!=null)
				try {
					ps.close();
				} catch (Exception e) {
					throw e;
				}
		}
		return flag;	
	}

}
