package cn.hero.firc.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.hero.firc.dao.ISjskilDao;
import cn.hero.firc.entity.Sjskil;
import cn.hero.firc.util.Page;

/**
 * @description:显示召唤师技能数据
 * @author:章冬蕾
 * @date:2018-12-25下午5:03:07
 * @version JDK1.7
 */
public class SjskilDao extends BaseDao implements ISjskilDao {

	/**
	 * 查询所有召唤师技能
	 */
	@Override
	public Page<Sjskil> querySjskilPage(Sjskil sjskil, Page<Sjskil> page)
			throws Exception {
		StringBuffer buffer = new StringBuffer("SELECT * FROM sjskil where 1=1");
		// 组装查询条件
		List<Object> params = new ArrayList<Object>();

		buffer.append(" limit ?,?");
		params.add((page.getPageNo() - 1) * page.getPageCount());// 设置当前页的起始索引
		params.add(page.getPageCount());// 设置每页要显示的记录数
		ResultSet rs = super.query(buffer.toString(), params.toArray());

		List<Sjskil> SjskilList = new ArrayList<Sjskil>();
		while (rs.next()) {
			Sjskil sjskil2 = new Sjskil();
			sjskil2.setId(rs.getInt("id"));
			sjskil2.setSjskill(rs.getString("sjskill"));
			sjskil2.setSjrole(rs.getString("sjrole"));
			SjskilList.add(sjskil2);
		}
		// 设置分页参数
		page.setResultList(SjskilList);// 设置每页要显示的记录集合
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
		String sql = "select count(*) from sjskil where 1=1";
		ResultSet resultList = super.query(sql, new Object[] {});

		Integer count = 0;
		while (resultList.next()) {
			count = rs.getInt(1);
		}
		return count;
	}

	/**
	 * 修改召唤师技能
	 * 
	 * @param
	 * @throws Exception
	 */
	@Override
	public void updateSjskils(Sjskil sjskil) throws Exception {
		String sql = "UPDATE  sjskil SET sjskill=?,sjrole=? WHERE id=?";
		Object[] params = { sjskil.getSjskill(), sjskil.getSjrole(),
				sjskil.getId() };
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
	public Sjskil getSjskilsid(Integer id) throws Exception {
		String sql = "select * from sjskil where id=? ";
		Object[] params = { id };
		ResultSet rs = super.query(sql, params);
		Sjskil sjskil2 = new Sjskil();
		while (rs.next()) {

			sjskil2.setId(rs.getInt("id"));
			sjskil2.setSjskill(rs.getString("sjskill"));
			sjskil2.setSjrole(rs.getString("sjrole"));
		}
		return sjskil2;
	}

	/**
	 * 添加召唤师技能
	 * 
	 * @param huser
	 * @throws Exception
	 */
	@Override
	public void addSjskil(Sjskil sjskil) throws Exception {
		String sql = "INSERT INTO sjskil(htypename,postionname) VALUES(?,?)";
		Object[] params = { sjskil.getSjskill(), sjskil.getSjrole() };
		edit(sql, params);
	}

	/**
	 * 删除召唤师技能
	 * 
	 * @param id
	 * @throws Exception
	 */
	@Override
	public void deleteSjskil(Integer id) throws Exception {
		String sql = "delete from htype where id=?";
		Object[] params = { id };
		super.edit(sql, params);

	}

	/**
	 * 查询所有召唤师技能
	 */
	@Override
	public List<Sjskil> querySjskil(Sjskil sjskil) throws Exception {
		StringBuffer buffer = new StringBuffer(
				"SELECT * FROM src AS s,sjskil AS sj WHERE s.corrId=sj.`id`  AND s.`imgtypeid`=4");
		// 组装查询条件
		List<Object> params = new ArrayList<Object>();

		ResultSet rs = super.query(buffer.toString(),params.toArray());

		List<Sjskil> SjskilList = new ArrayList<Sjskil>();
		while (rs.next()) {
			Sjskil sjskil2 = new Sjskil();
			sjskil2.setId(rs.getInt("id"));
			sjskil2.setSjskill(rs.getString("sjskill"));
			sjskil2.setSjrole(rs.getString("sjrole"));
			sjskil2.setImgsrc(rs.getString("imgsrc"));
			sjskil2.setSfjn(rs.getString("sfjn"));
			SjskilList.add(sjskil2);
		}
		return SjskilList;
	}

}
