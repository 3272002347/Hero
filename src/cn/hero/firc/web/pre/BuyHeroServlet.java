package cn.hero.firc.web.pre;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hero.firc.entity.Hero;
import cn.hero.firc.entity.Huser;
import cn.hero.firc.entity.Skin;
import cn.hero.firc.service.IHeroServcie;
import cn.hero.firc.service.ISkinService;
import cn.hero.firc.service.impl.HeroService;
import cn.hero.firc.service.impl.SkinService;

/**
 * @name 高志曦
 * @impact 作用
 * @date Jan 17, 20199:30:14 PM
 * @version JDK1.7 
 */
public class BuyHeroServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String skinid = request.getParameter("id");
		IHeroServcie heroServcie = new HeroService();
		PrintWriter out = response.getWriter();
		try {
			Hero hero =heroServcie.queryById(Integer.valueOf(skinid));
			ServletContext application = this.getServletContext();
			Huser user = (Huser) request.getSession().getAttribute("user");
			// 设置Application属性
			HashMap<Integer, HashMap<Integer, List<Hero>>> thingsown = new HashMap<Integer, HashMap<Integer, List<Hero>>>();
			HashMap<Integer, HashMap<Integer, List<Hero>>> things = (HashMap<Integer, HashMap<Integer, List<Hero>>>) application
					.getAttribute("thingsown");
			HashMap<Integer, List<Hero>> thing = things.get(user.getId());

			List<Hero> heros = new ArrayList<Hero>();
			if (thing.get(2) != null) {
				heros= thing.get(2);
				for (Hero skin2 : thing.get(2)) {
					if (skin2.getId() == hero.getId()) {
						out.write("2");
						out.flush();
						out.close();
						return;
					}
				}
			}
			heros.add(hero);
			thing.put(2, heros);
			thingsown.put(user.getId(), thing);
			application.setAttribute("thingsown", thingsown);
			out.write("1");
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.write("购买失败！");
			e.printStackTrace();
		}

	}

}
