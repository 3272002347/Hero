package cn.hero.firc.web.pre;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.print.attribute.standard.MediaSize.Other;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hero.firc.entity.Hero;
import cn.hero.firc.entity.Huser;
import cn.hero.firc.entity.Skin;
import cn.hero.firc.service.ISkinService;
import cn.hero.firc.service.impl.SkinService;

/**
 * @name 高志曦
 * @impact 作用
 * @date Jan 17, 20196:15:33 PM
 * @version JDK1.7
 */
public class BuyThingsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String skinid = request.getParameter("id");
		ISkinService iSkinService = new SkinService();
		PrintWriter out = response.getWriter();
		try {
			Skin skin = iSkinService.buySkin(Integer.valueOf(skinid));
			ServletContext application = this.getServletContext();
			Huser user = (Huser) request.getSession().getAttribute("user");
			// 设置Application属性
			HashMap<Integer, HashMap<Integer, List<Skin>>> thingsown = new HashMap<Integer, HashMap<Integer, List<Skin>>>();
			HashMap<Integer, HashMap<Integer, List<Skin>>> things = (HashMap<Integer, HashMap<Integer, List<Skin>>>) application
					.getAttribute("thingsown");
			HashMap<Integer, List<Skin>> thing = things.get(user.getId());
			List<Skin> skins = new ArrayList<Skin>();
			if (thing.get(1) != null) {
				skins= thing.get(1);
				for (Skin skin2 : thing.get(1)) {
					if (skin2.getId() == skin.getId()) {
						out.write("2");
						out.flush();
						out.close();
						return;
					}
				}
			}
			skins.add(skin);
			thing.put(1, skins);
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
