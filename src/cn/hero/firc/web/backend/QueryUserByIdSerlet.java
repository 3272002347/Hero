package cn.hero.firc.web.backend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.model.core.ID;

import cn.hero.firc.entity.Huser;
import cn.hero.firc.service.IHuserService;
import cn.hero.firc.service.impl.HuserService;

public class QueryUserByIdSerlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		
		try {
			IHuserService huserService=new HuserService();
			Huser huser=huserService.getHusersid(Integer.valueOf(id));
			
			request.setAttribute("user", huser);
			request.getRequestDispatcher("/backend/updateUser.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
