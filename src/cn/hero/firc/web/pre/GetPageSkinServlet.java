package cn.hero.firc.web.pre;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hero.firc.entity.Hero;
import cn.hero.firc.entity.Skin;
import cn.hero.firc.service.impl.HeroService;
import cn.hero.firc.service.impl.SkinService;
import cn.hero.firc.util.Page;

import com.alibaba.fastjson.JSON;

/**
 * @name 高志曦
 * @impact 作用
 * @date Jan 3, 201910:59:17 AM
 * @version JDK1.7 
 */
public class GetPageSkinServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Page<Skin> page = new Page<Skin>();
		page.setPageNo(Integer.valueOf(request.getParameter("pageNo")));
		page.setPageCount(16);
		try {
			Page<Skin> items = new SkinService().querySkinPage(null,page);
			PrintWriter out = response.getWriter();
			String json = JSON.toJSONString(items);
			out.print(json);
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
