package cn.hero.firc.web.backend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hero.firc.entity.Hero;
import cn.hero.firc.service.IHeroServcie;
import cn.hero.firc.service.impl.HeroService;

public class HeroUpdateServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		String heroName=request.getParameter("heroName");
		String price=request.getParameter("price");
		String type=request.getParameter("type");
		String story=request.getParameter("story");
		
		Hero hero=new Hero();
		hero.setHeroname(heroName);
		hero.setHerostory(story);
		hero.setId(Integer.valueOf(id));
		hero.setHerotypeid(Integer.valueOf(type));
		hero.setPrice(Integer.valueOf(price));
		
		try {
			IHeroServcie heroServcie=new HeroService();
			heroServcie.updateHero(hero);
			request.getRequestDispatcher("backend/heroMent-ly.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
