package cn.hero.firc.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.hero.firc.dao.IEquipDao;
import cn.hero.firc.dao.IHeroDao;
import cn.hero.firc.dao.impl.HeroDao;
import cn.hero.firc.entity.Hero;
import cn.hero.firc.service.IHeroServcie;
import cn.hero.firc.util.MyBatisUtil;
import cn.hero.firc.util.Page;

public class HeroService implements IHeroServcie {

	private SqlSession sqlSession;

	private IHeroDao heroDao;

	/**
	 * 查询所有英雄信息
	 * 
	 * @return
	 */
	@Override
	public List<Hero> queryHeros(Hero hero) throws Exception {

		sqlSession = MyBatisUtil.createSqlSession();
		heroDao = sqlSession.getMapper(IHeroDao.class);

		List<Hero> heroList = heroDao.queryHeros(hero);

		MyBatisUtil.closeSqlSession(sqlSession);
		return heroList;
	}

	/**
	 * 查询所有信息（分页）
	 * 
	 * @param hero
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@Override
	public Page<Hero> queryHerosPage(Hero hero, Page<Hero> page)
			throws Exception {
		return this.heroDao.queryHerosPage(hero, page);
	}

	/**
	 * 添加英雄信息
	 * 
	 * @param hero
	 * @throws Exception
	 */
	@Override
	public void addHeros(Hero hero) throws Exception {
		this.heroDao.addHeros(hero);
	}

	/**
	 * 查询英雄分类
	 * 
	 * @param herotypeid
	 * @return
	 * @throws Exception
	 */
	@Override
	public Hero queryByherotypeid(Integer herotypeid) throws Exception {

		sqlSession = MyBatisUtil.createSqlSession();
		heroDao = sqlSession.getMapper(IHeroDao.class);
		Hero hero = heroDao.queryByherotypeid(herotypeid);
		MyBatisUtil.closeSqlSession(sqlSession);
		return hero;
	}

	/**
	 * @name 名字
	 * @impact 作用
	 */
	@Override
	public Hero queryById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Hero hero = new Hero();
		hero.setId(id);
		return heroDao.queryHeros(hero).get(0);
	}

	@Override
	public void updateHero(Hero hero) throws Exception {
		this.heroDao.updateHero(hero);
	}


}
