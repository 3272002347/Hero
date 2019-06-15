package cn.hero.firc.web.pre;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hero.firc.service.IHeroServcie;
import cn.hero.firc.service.impl.HeroService;
import cn.hero.firc.entity.Hero;

/**
 * @deprecated:查询全部英雄数据
 * @author 洪骥
 * @date:2018-12-27
 * @since JDK1.7
 */
public class HeroListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 获取参数
			String HeroName = request.getParameter("HeroName");

			if (HeroName != null) {
				HeroName = new String(HeroName.getBytes("iso-8859-1"), "utf-8");

				Hero hero = new Hero();
				hero.setHeroname("%" + HeroName + "%");

				// 获取所有英雄信息
				IHeroServcie iHeroServcie = new HeroService();
				List<Hero> heroList = iHeroServcie.queryHeros(hero);
				// 把英雄信息返回页面
				request.setAttribute("heroList", heroList);
				// 转发，返回页面
				request.getRequestDispatcher("pre/info-heros.jsp").forward(
						request, response);
			} else {
				// 获取所有英雄信息
				IHeroServcie iHeroServcie = new HeroService();
				List<Hero> heroList = iHeroServcie.queryHeros(null);

				// 把英雄信息返回页面
				request.setAttribute("heroList", heroList);
				// 转发，返回页面
				request.getRequestDispatcher("pre/info-heros.jsp").forward(
						request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
