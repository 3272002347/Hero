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

public class UpdateHuserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String username=request.getParameter("username");
		String number=request.getParameter("number");
		
		Huser huser=new Huser();
		huser.setId(Integer.valueOf(id));
		huser.setNumber(number);
		huser.setPassword(password);
		huser.setUsername(username);
		
		try {
			IHuserService huserService=new HuserService();
			huserService.updateHusers(huser);
			request.getRequestDispatcher("/backend/userMent-ly.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
