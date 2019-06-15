package cn.hero.firc.web.pre;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hero.firc.dao.ISkinDao;
import cn.hero.firc.entity.Hero;
import cn.hero.firc.entity.Skin;
import cn.hero.firc.service.IHeroServcie;
import cn.hero.firc.service.ISkinService;
import cn.hero.firc.service.impl.HeroService;
import cn.hero.firc.service.impl.SkinService;
import cn.hero.firc.util.Page;

/**
 * @name 高志曦
 * @impact 作用
 * @date Jan 3, 20199:19:27 AM
 * @version JDK1.7 
 */
public class SkinStoreServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 ISkinService ss=new SkinService();
         Page<Skin> page=new Page<Skin>();
         page.setPageCount(16);
         try {
				Page<Skin> skins=ss.querySkinPage(null, page);
				request.setAttribute("items", skins);
				request.getRequestDispatcher("/pre/store/storeskin.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
