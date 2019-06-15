package cn.hero.firc.web.backend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hero.firc.entity.Equip;
import cn.hero.firc.service.IEquipService;
import cn.hero.firc.service.impl.EquipService;


/**
 * @description:添加装备
 * @author:章冬蕾
 * @date:2019-1-19上午11:17:59
 * @version JDK1.7
 */
public class EquipAddServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		       // 获取参数值
				request.setCharacterEncoding("utf-8");
				String equipment = request.getParameter("equipment");
				String etypename = request.getParameter("etypename");
				String esrcid = request.getParameter("esrcid");

				// 构造对象
				Equip equip = new Equip();
				equip.setEquipment(equipment);
				equip.setEtypename(etypename);
				equip.setEsrcid(Integer.valueOf(esrcid));

				// 添加
				IEquipService iEquipService = new EquipService();
		
				try {
					iEquipService.addEquip(equip);
			
				} catch (Exception e) {
					e.printStackTrace();
				}

				// 跳转到查询所有用户页面
				request.getRequestDispatcher("equipMent-ly.jsp").forward(
						request, response);
			}

	}


