package cn.hero.firc.web.backend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hero.firc.entity.Hero;
import cn.hero.firc.entity.Src;
import cn.hero.firc.service.IHeroServcie;
import cn.hero.firc.service.IHuserService;
import cn.hero.firc.service.ISrcService;
import cn.hero.firc.service.impl.HeroService;
import cn.hero.firc.service.impl.HuserService;
import cn.hero.firc.service.impl.SrcService;

/**
 * @deprecated:添加英雄
 * @author 洪骥1
 * @date:2019-1-18
 * @since JDK1.7
 */
public class HeroAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	/**
	 * 添加
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取参数值
		request.setCharacterEncoding("utf-8");
		String heroname = request.getParameter("heroname");
		String herostory = request.getParameter("herostory");
		String herotypeid = request.getParameter("herotypeid");
		String price = request.getParameter("price");
		String viedoSrc = request.getParameter("viedoSrc");

		// 把这个图标加到src表
		String imgsrc = request.getParameter("imgsrc");
		// 构造对象
		Src src  = new Src();
		src.setImgsrc("statics/images/heroimg/addHero/"+imgsrc);
		src.setHeroName(heroname);

		// 构造对象
		Hero hero = new Hero();
		hero.setHeroname(heroname);
		hero.setHerostory(herostory);
		hero.setHerotypeid(Integer.valueOf(herotypeid));
		hero.setPrice(Integer.valueOf(price));
		hero.setViedoSrc(viedoSrc);

		// 添加
		IHeroServcie iHeroServcie = new HeroService();
		ISrcService iSrcService=new SrcService();
		try {
			
			iHeroServcie.addHeros(hero);
			iSrcService.addSrc(src);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 跳转到查询所有用户页面
		request.getRequestDispatcher("backend/heroMent-ly.jsp").forward(
				request, response);
	}

}
