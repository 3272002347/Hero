package cn.hero.firc.web.pre;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hero.firc.entity.Hero;
import cn.hero.firc.service.IHeroServcie;
import cn.hero.firc.service.impl.HeroService;

public class HeroByServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String herotypeid = request.getParameter("herotypeid");

		try {
			Hero hero = new Hero();
			hero.setId(Integer.valueOf(id));

			IHeroServcie iHeroServcie = new HeroService();
			Hero herotypeidList = iHeroServcie.queryByherotypeid(Integer
					.valueOf(herotypeid));

			// 把英雄信息返回页面
			request.setAttribute("herotypeidList", herotypeidList);
			// 转发，返回页面
			request.getRequestDispatcher("pre/info-heroType.jsp").forward(
					request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
