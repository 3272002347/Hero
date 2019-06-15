package cn.hero.firc.dao;

import java.util.List;

import cn.hero.firc.entity.Hero;
import cn.hero.firc.entity.Skill;
import cn.hero.firc.util.Page;

/**
 * @description:英雄数据访问接口
 * @author:19138
 * @date:2018-12-20
 * @version JDK1.7
 */
public interface IHeroDao {
	/**
	 * 查询所有英雄信息
	 * @return
	 */
	public List<Hero> queryHeros(Hero hero) throws Exception;

	/**
	 * 查询所有信息（分页）
	 * @param hero
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public Page<Hero> queryHerosPage(Hero hero, Page<Hero> page)
			throws Exception;
	
	/**
	 * 添加英雄信息
	 * @param hero
	 * @throws Exception
	 */
	public void addHeros(Hero hero) throws Exception;
	
	/**
	 * 查询英雄分类
	 * @param herotypeid
	 * @return
	 * @throws Exception
	 */
	public Hero queryByherotypeid(Integer herotypeid) throws Exception;
	
	/**
	 * 根据英雄查技能
	 * 
	 * @param skill
	 * @return
	 * @throws Exception
	 */
	public List<Skill> SkillId(Integer id) throws Exception;

	
	/**
	 * 删除英雄
	 * @param heroid
	 * @throws Exception
	 */
	public void deleteHero(Integer heroid) throws Exception;
	
	/**
	 * 修改英雄
	 * @param hero
	 * @throws Exception
	 */
	public void updateHero(Hero hero) throws Exception;
	
}
