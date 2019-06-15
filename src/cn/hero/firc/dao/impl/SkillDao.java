package cn.hero.firc.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cn.hero.firc.dao.ISkillDao;
import cn.hero.firc.entity.Skill;
import cn.hero.firc.util.Page;

/**
 * @description:英雄技能(显示数据)
 * @author:章冬蕾
 * @date:2018-12-24下午1:57:44
 * @version JDK1.7
 */
public class SkillDao extends BaseDao implements ISkillDao {

	/**
	 * 分页查询所有英雄技能
	 */
	@Override
	public Page<Skill> querySkillPage(Skill skill, Page<Skill> page)
			throws Exception {
		StringBuffer buffer = new StringBuffer("SELECT * FROM skill where 1=1");
		// 组装查询条件
		List<Object> params = new ArrayList<Object>();

		buffer.append(" limit ?,?");
		params.add((page.getPageNo() - 1) * page.getPageCount());// 设置当前页的起始索引
		params.add(page.getPageCount());// 设置每页要显示的记录数
		ResultSet rs = super.query(buffer.toString(), params.toArray());

		List<Skill> SkillList = new LinkedList<Skill>();
		while (rs.next()) {
			Skill skill2 = new Skill();
			skill2.setId(rs.getInt("id"));
			skill2.setSkillname(rs.getString("skillname"));
			skill2.setAddition(rs.getString("addition"));
			skill2.setSkillsrcid(rs.getInt("skillsrcid"));
			SkillList.add(skill2);
		}
		// 设置分页参数
		page.setResultList(SkillList);// 设置每页要显示的记录集合
		page.setTotalCount(queryCount());// 设置总记录数

		return page;
	}

	/**
	 * 获取总记录数
	 * 
	 * @return
	 * @throws Exception
	 */
	public Integer queryCount() throws Exception {
		String sql = "select count(*) from skill where 1=1";
		ResultSet resultList = super.query(sql, new Object[] {});

		Integer count = 0;
		while (resultList.next()) {
			count = rs.getInt(1);
		}
		return count;
	}

	/**
	 * 修改英雄技能
	 * 
	 * @param
	 * @throws Exception
	 */
	@Override
	public void updateSkills(Skill skill) throws Exception {
		String sql = "UPDATE  skill SET skillname=?,addition=? skillsrcid=? ,heroid=?  WHERE id=?";
		Object[] params = { skill.getSkillname(), skill.getAddition(),
				skill.getSkillsrcid(), skill.getHeroid() };
		edit(sql, params);
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
		String sql = "select * from skill where id=? ";
		Object[] params = { id };
		ResultSet rs = super.query(sql, params);
		Skill skill2 = new Skill();
		while (rs.next()) {

			skill2.setId(rs.getInt("id"));
			skill2.setSkillname(rs.getString("skillname"));
			skill2.setAddition(rs.getString("addition"));
			skill2.setSkillsrcid(rs.getInt("skillsrcid"));
			skill2.setHeroid(rs.getInt("heroid"));
		}
		return skill2;
	}

	/**
	 * 添加英雄技能
	 * 
	 * @param huser
	 * @throws Exception
	 */
	@Override
	public void addSkill(Skill skill) throws Exception {
		String sql = "INSERT INTO skill(skillname,addition,skillsrcid,heroid) VALUES(?,?,?,?)";
		Object[] params = { skill.getSkillname(), skill.getAddition(),
				skill.getSkillsrcid(), skill.getHeroid() };
		edit(sql, params);
	}

	/**
	 * 删除英雄技能
	 * 
	 * @param id
	 * @throws Exception
	 */
	@Override
	public void Skill(Integer id) throws Exception {
		String sql = "delete from skill where id=?";
		Object[] params = { id };
		super.edit(sql, params);
	}

	/**
	 * 查询所有英雄技能
	 */
	@Override
	public List<Skill> querySkills(Skill skill) throws Exception {
		StringBuffer buffer = new StringBuffer("SELECT * FROM skill where 1=1");
		// 组装查询条件
		List<Object> params = new ArrayList<Object>();

		ResultSet rs = super.query(buffer.toString(), params.toArray());
		List<Skill> skillList = new LinkedList<Skill>();
		while (rs.next()) {
			Skill skill2 = new Skill();
			skill2.setId(rs.getInt("id"));
			skill2.setSkillname(rs.getString("skillname"));
			skill2.setAddition(rs.getString("addition"));
			skill2.setSkillsrcid(rs.getInt("skillsrcid"));
			skillList.add(skill2);
		}
		return skillList;
	}

	/**
	 * 根据英雄查技能
	 */
	@Override
	public List<Skill> SkillId(Integer id) throws Exception {
		String sql = "SELECT * FROM skill AS s ,hero AS h ,src AS sr WHERE s.heroid= h.`id` AND s.skillsrcid=sr.id AND s.heroid= ?";
		Object[] params = { id };
		ResultSet rs = super.query(sql, params);
		List<Skill> skillList = new LinkedList<Skill>();
		while (rs.next()) {
			Skill skill2 = new Skill();
			skill2.setId(rs.getInt("id"));
			skill2.setSkillname(rs.getString("skillname"));
			skill2.setAddition(rs.getString("addition"));
			skill2.setSkillsrcid(rs.getInt("skillsrcid"));
			skill2.setImgsrc(rs.getString("imgsrc"));
			skillList.add(skill2);
		}
		return skillList;
	}
}
