package cn.hero.firc.web.pre;

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
import cn.hero.firc.util.Page;

/**
 * @name 高志曦
 * @impact 作用
 * @date Dec 27, 201811:31:17 AM
 * @version JDK1.7 
 */
public class HeroStoreServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            IHeroServcie hs=new HeroService();
            Page<Hero> page=new Page<Hero>();
            page.setPageCount(16);
            try {
				Page<Hero> heros=hs.queryHerosPage(null, page);
				request.setAttribute("items", heros);
				request.getRequestDispatcher("/pre/store/store.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
