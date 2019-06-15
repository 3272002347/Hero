package cn.hero.firc.web.pre;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.hero.firc.entity.Hero;
import cn.hero.firc.entity.Huser;
import cn.hero.firc.entity.Skin;

/**
 * @name 高志曦
 * @impact 作用
 * @date Jan 18, 20199:01:27 AM
 * @version JDK1.7 
 */
public class GetUserHerosServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext application = this.getServletContext();
		HashMap<Integer, HashMap<Integer, List<Hero>>> myheroes=(HashMap<Integer, HashMap<Integer, List<Hero>>>) application.getAttribute("thingsown");
		Huser user=(Huser) request.getSession().getAttribute("user");
		HashMap<Integer,  List<Hero>> thingsHero=myheroes.get(user.getId());
		List<Hero> heroes=thingsHero.get(2);
		String json=JSON.toJSONString(heroes);
		PrintWriter out=response.getWriter();
		out.write(json);
		out.flush();
		out.close();
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
