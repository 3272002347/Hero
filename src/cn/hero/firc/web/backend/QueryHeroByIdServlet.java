package cn.hero.firc.web.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hero.firc.entity.Hero;
import cn.hero.firc.service.IHeroServcie;
import cn.hero.firc.service.impl.HeroService;

public class QueryHeroByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		
		Hero hero=new Hero();
		hero.setId(Integer.valueOf(id));
		
		try {
			IHeroServcie heroServcie=new HeroService();
			List<Hero> list=heroServcie.queryHeros(hero);
			
			Hero hero2=list.get(0);
			request.setAttribute("hero", hero2);
			request.getRequestDispatcher("backend/updateHero.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
