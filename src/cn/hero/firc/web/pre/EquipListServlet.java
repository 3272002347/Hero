package cn.hero.firc.web.pre;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hero.firc.util.Page;
import cn.hero.firc.entity.Equip;
import cn.hero.firc.entity.Hero;
import cn.hero.firc.service.IEquipService;
import cn.hero.firc.service.IHeroServcie;
import cn.hero.firc.service.impl.EquipService;
import cn.hero.firc.service.impl.HeroService;

/**
 * @deprecated:查询全部物品数据
 * @author 洪骥
 * @date:2018-12-27
 * @since JDK1.7
 */
public class EquipListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取参数
		String ItemName = request.getParameter("ItemName");
		try {
			if (ItemName != null) {
				
				ItemName = new String(ItemName.getBytes("iso-8859-1"), "utf-8");
				
				Equip equip = new Equip();
				equip.setEquipment("%"+ItemName+"%");
				// 获取所有物品信息
				IEquipService iEquipService = new EquipService();
				List<Equip> equipList = iEquipService.queryEquipsPage(equip);

				// 把物品信息返回页面
				request.setAttribute("equipList", equipList);
				// 转发，返回页面
				request.getRequestDispatcher("pre/info-item.jsp").forward(
						request, response);
			} else {
				// 获取所有物品信息
				IEquipService iEquipService = new EquipService();
				List<Equip> equipList = iEquipService.queryEquipsPage(null);

				// 把物品信息返回页面
				request.setAttribute("equipList", equipList);
				// 转发，返回页面
				request.getRequestDispatcher("pre/info-item.jsp").forward(
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
