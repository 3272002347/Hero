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

public class AdminLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String number=request.getParameter("number");
		String password=request.getParameter("password");
		
		
		try {
			IHuserService huserService=new HuserService();
			Huser huser2=huserService.loginUser(number, password);
			if (huser2!=null) {
				request.setAttribute("admin", huser2.getUsername());
				request.getRequestDispatcher("backend/HeroManagement.jsp").forward(request, response);
			}else {
				request.setAttribute("message", "不存在此管理员，请重新输入！");
				request.getRequestDispatcher("backend/adminLogin.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
