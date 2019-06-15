package cn.hero.firc.dao;

import java.util.List;
import cn.hero.firc.entity.Skill;
import cn.hero.firc.util.Page;

/**
 * @description:英雄技能
 * @author:章冬蕾
 * @date:2018-12-24下午1:52:50
 * @version JDK1.7
 */
public interface ISkillDao {

	/**
	 * 分页查询英雄技能
	 * 
	 * @param skill
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public Page<Skill> querySkillPage(Skill skill, Page<Skill> page)
			throws Exception;

	/**
	 * 修改英雄技能
	 * 
	 * @param
	 * @throws Exception
	 */
	public void updateSkills(Skill skill) throws Exception;

	/**
	 * 查询单个
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Skill getSkillsid(Integer id) throws Exception;

	/**
	 * 添加英雄技能
	 * 
	 * @param huser
	 * @throws Exception
	 */
	public void addSkill(Skill skill) throws Exception;

	/**
	 * 删除英雄技能
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void Skill(Integer id) throws Exception;

	/**
	 * 查询英雄技能
	 * 
	 * @param skill
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Skill> querySkills(Skill skill) throws Exception;

	
}
