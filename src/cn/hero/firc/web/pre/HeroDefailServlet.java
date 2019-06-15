package cn.hero.firc.web.pre;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hero.firc.entity.Equip;
import cn.hero.firc.entity.Hero;
import cn.hero.firc.entity.Skill;
import cn.hero.firc.entity.Skin;
import cn.hero.firc.service.IEquipService;
import cn.hero.firc.service.IHeroServcie;
import cn.hero.firc.service.ISkillService;
import cn.hero.firc.service.ISkinService;
import cn.hero.firc.service.impl.EquipService;
import cn.hero.firc.service.impl.HeroService;
import cn.hero.firc.service.impl.SkillService;
import cn.hero.firc.service.impl.SkinService;

/**
 * @deprecated:根据英雄id查询英雄
 * @author 洪骥1
 * @date:2018-12-29
 * @since JDK1.7
 */
public class HeroDefailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 获取英雄编号
		String id = request.getParameter("id");
		try {
			// 构造英雄对象
			Hero hero = new Hero();
			hero.setId(Integer.valueOf(id));

			// 构造英雄皮肤对象
			Skin skin = new Skin();
			skin.setId(Integer.valueOf(id));

			// 构造英雄皮肤对象
			Skill skill = new Skill();
			skill.setId(Integer.valueOf(id));

			// 查询所属英雄
			IHeroServcie iHeroServcie = new HeroService();

			ISkinService iSkinService = new SkinService();

			ISkillService iSkillService = new SkillService();

			/* 查询所有英雄信息 */
			List<Hero> heroList = iHeroServcie.queryHeros(hero);
			hero = heroList.get(0);

			/* 根据英雄编号查询英雄信息 */
			Hero heros = iHeroServcie.queryByherotypeid(Integer.valueOf(id));

			/* 根据英雄编号查询英雄皮肤信息 */
			List<Skin> skinList = iSkinService.getSkinHeroId(Integer
					.valueOf(id));
			List<Skin> skinsList = iSkinService.getSkinSrcId(Integer
					.valueOf(id));

			/* 根据英雄编号查询英雄技能 */
			List<Skill> skills = iSkillService.SkillId(Integer.valueOf(id));
			// 返回页面
			request.setAttribute("hero", hero);
			request.setAttribute("heros", heros);
			request.setAttribute("skinList", skinList);
			request.setAttribute("skinsList", skinsList);
			request.setAttribute("skills", skills);
			skills.get(0);
			
			request.getRequestDispatcher("pre/info-defail.jsp").forward(
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
