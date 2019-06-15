package cn.hero.firc.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.hero.firc.dao.IHeroDao;
import cn.hero.firc.dao.ISkillDao;
import cn.hero.firc.dao.impl.SkillDao;
import cn.hero.firc.entity.Skill;
import cn.hero.firc.service.ISkillService;
import cn.hero.firc.util.MyBatisUtil;
import cn.hero.firc.util.Page;

/**
 * @description:召唤技能service
 * @author:章冬蕾
 * @date:2018-12-24下午2:07:45
 * @version JDK1.7
 */
public class SkillService implements ISkillService {

	private SqlSession sqlSession;
	private ISkillDao iSkillDao;
	private IHeroDao iHeroDao;

	/**
	 * 查询所有召唤技能
	 */
	@Override
	public Page<Skill> querySkillPage(Skill skill, Page<Skill> page)
			throws Exception {
		return this.iSkillDao.querySkillPage(skill, page);
	}

	/**
	 * 修改英雄类别
	 * 
	 * @param
	 * @throws Exception
	 */
	@Override
	public void updateSkills(Skill skill) throws Exception {

		this.iSkillDao.updateSkills(skill);

	}

	/**
	 * 查询单个
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public Skill getSkillsid(Integer id) throws Exception {
		return this.iSkillDao.getSkillsid(id);
	}

	/**
	 * 添加英雄技能
	 * 
	 * @param huser
	 * @throws Exception
	 */
	@Override
	public void addSkill(Skill skill) throws Exception {

		this.iSkillDao.addSkill(skill);

	}

	/**
	 * 删除英雄技能
	 * 
	 * @param id
	 * @throws Exception
	 */
	@Override
	public void Skill(Integer id) throws Exception {
		this.iSkillDao.Skill(id);

	}

	/**
	 * 查询英雄技能
	 * 
	 * @param skill
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Skill> querySkills(Skill skill) throws Exception {
		return this.iSkillDao.querySkills(skill);
	}

	/**
	 * 根据英雄查技能
	 * 
	 * @param id
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Skill> SkillId(Integer id) throws Exception {

		sqlSession = MyBatisUtil.createSqlSession();
		iHeroDao = sqlSession.getMapper(IHeroDao.class);
		List<Skill> skillList = iHeroDao.SkillId(id);
		MyBatisUtil.closeSqlSession(sqlSession);
		return skillList;
	}

}
