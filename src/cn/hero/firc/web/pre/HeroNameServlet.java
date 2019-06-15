package cn.hero.firc.web.pre;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.hero.firc.entity.Hero;
import cn.hero.firc.service.IHeroServcie;
import cn.hero.firc.service.impl.HeroService;

/**
 * @deprecated:根据英雄名称查询英雄
 * @author 洪骥1
 * @date:2019-1-11
 * @since JDK1.7
 */
public class HeroNameServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取参数
		String HeroName = request.getParameter("HeroName");
		HeroName = new String(HeroName.getBytes("iso-8859-1"), "utf-8");

		Hero hero = new Hero();
		hero.setHeroname(HeroName);
		try {
			// 根据英雄名称获取英雄信息
			IHeroServcie iHeroServcie = new HeroService();
			List<Hero> hero1 = iHeroServcie.queryHeros(hero);
			String msggString = JSON.toJSONString(hero1);
			// 返回页面，直接输出结果
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write(msggString);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
