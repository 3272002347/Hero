package cn.hero.firc.service;

import java.util.List;

import cn.hero.firc.entity.Hero;
import cn.hero.firc.entity.Skill;
import cn.hero.firc.util.Page;

public interface IHeroServcie {
	/**
	 * 查询所有英雄信息
	 * 
	 * @return
	 */
	public List<Hero> queryHeros(Hero hero) throws Exception;

	/**
	 * 查询所有信息（分页）
	 * 
	 * @param hero
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public Page<Hero> queryHerosPage(Hero hero, Page<Hero> page)
			throws Exception;

	/**
	 * 添加英雄信息
	 * 
	 * @param hero
	 * @throws Exception
	 */
	public void addHeros(Hero hero) throws Exception;

	/**
	 * 查询英雄分类
	 * 
	 * @param herotypeid
	 * @return
	 * @throws Exception
	 */
	public Hero queryByherotypeid(Integer herotypeid) throws Exception;

	public Hero queryById(Integer id) throws Exception;

	/**
	 * 修改英雄
	 * 
	 * @param hero
	 * @throws Exception
	 */
	public void updateHero(Hero hero) throws Exception;
}
