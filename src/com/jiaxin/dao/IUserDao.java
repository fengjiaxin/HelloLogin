package com.jiaxin.dao;

/*
 * ����dao�ӿڣ��鿴����
 */
import com.jiaxin.vo.User;

public interface IUserDao {
	public boolean findLogin(User user) throws Exception;

}
