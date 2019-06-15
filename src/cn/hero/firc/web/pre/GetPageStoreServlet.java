package cn.hero.firc.web.pre;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.hero.firc.entity.Hero;
import cn.hero.firc.service.impl.HeroService;
import cn.hero.firc.util.Page;

/**
 * @name 高志曦
 * @impact 作用
 * @date Dec 29, 20189:44:01 AM
 * @version JDK1.7
 */
public class GetPageStoreServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Page<Hero> page = new Page<Hero>();
		page.setPageNo(Integer.valueOf(request.getParameter("pageNo")));
		page.setPageCount(16);
		try {
			Page<Hero> items = new HeroService().queryHerosPage(null, page);
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
