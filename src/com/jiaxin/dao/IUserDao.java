package com.jiaxin.dao;

/*
 * 定义dao接口，查看功能
 */
import com.jiaxin.vo.User;

public interface IUserDao {
	public boolean findLogin(User user) throws Exception;

}
