package cn.hero.firc.web.backend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hero.firc.entity.Huser;
import cn.hero.firc.service.IHuserService;
import cn.hero.firc.service.impl.HuserService;

/**
 * @deprecated:添加用户
 * @author 洪骥1
 * @date:2019-1-18
 * @since JDK1.7
 */
public class HuserAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 添加
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取参数值
		request.setCharacterEncoding("utf-8");
		String number = request.getParameter("number");
		String huserName = request.getParameter("huserName");
		String typeid = request.getParameter("typeid");
		String password = request.getParameter("password");
		
		// 构造对象
		Huser huser =new Huser();
		huser.setNumber(number);
		huser.setUsername(huserName);
		huser.setTypeid(Integer.valueOf(typeid));
		huser.setPassword(password);
		
		// 添加
		IHuserService iHuserService=new HuserService();
		try {
			iHuserService.addHuser(huser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 跳转到查询所有用户页面
		request.getRequestDispatcher("backend/userMent-ly.jsp").forward(request,
				response);
		
	}

}
