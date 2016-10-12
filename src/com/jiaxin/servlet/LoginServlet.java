package com.jiaxin.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiaxin.dao.proxy.UserDAOProxy;
import com.jiaxin.vo.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		List<String> info = new ArrayList<String>();
		if(name ==null ||"".equals(name))
		{
			info.add("用户名不能为空");
			System.out.println("用户名不能为空");
		}
		if(password ==null ||"".equals(password))
		{
			info.add("密码不能为空");
			System.out.println("密码不能为空");
		}
		if(info.size()==0){
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			UserDAOProxy userDaoproxy = new UserDAOProxy();
			try {
				if(userDaoproxy.findLogin(user)){
					info.add("用户登陆成功，欢迎"+user.getName()+"光临！");
				}else{
					info.add("用户登录失败，错误的用户名或密码");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("info", info);
		request.getRequestDispatcher("Login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
