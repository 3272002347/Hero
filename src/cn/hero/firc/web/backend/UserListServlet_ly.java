package cn.hero.firc.web.backend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.hero.firc.entity.Huser;
import cn.hero.firc.service.impl.HuserService;
import cn.hero.firc.util.Page;

public class UserListServlet_ly extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取页面下标
		String pageNo = request.getParameter("pageNo");
		

		Page<Huser> page = new Page<Huser>();
		page.setPageCount(3);
		if (pageNo!=null) {
			page.setPageNo(Integer.valueOf(pageNo));
		}

		try {
			page = new HuserService().queryHusersPage(null, page);
			// 返回页面，直接输出结果
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			String data = JSON.toJSONString(page);
			out.write(data);
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
