package cn.hero.firc.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.hero.firc.dao.IEquipDao;
import cn.hero.firc.entity.Equip;
import cn.hero.firc.util.MyBatisUtil;
import cn.hero.firc.util.Page;

/**
 * @description:显示装备数据（分页）
 * @author:章冬蕾
 * @date:2018-12-21上午10:54:27
 * @version JDK1.7
 */
public class EquipDao extends BaseDao implements IEquipDao {
	

	/**
	 * 获取总记录数
	 * 
	 * @return
	 * @throws Exception
	 */
	public Integer queryCount() throws Exception {
		String sql = "select count(*) from equip where 1=1";
		ResultSet resultList = super.query(sql, new Object[] {});

		Integer count = 0;
		while (resultList.next()) {
			count = rs.getInt(1);
		}
		return count;
	}

	/**
	 * 修改装备信息
	 * 
	 * @param
	 * @throws Exception
	 */
	@Override
	public void updateEquips(Equip equip) throws Exception {
		String sql = "UPDATE  equip SET equipment=?,etypename=?,esrcid=? WHERE id=?";
		Object[] params = { equip.getEquipment(), equip.getEtypename(),
				equip.getEsrcid(), equip.getId() };
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
	public Equip getEquipsid(Integer id) throws Exception {
		String sql = "select * from equip where id=? ";
		Object[] params = { id };
		ResultSet rs = super.query(sql, params);
		Equip equip2 = new Equip();
		while (rs.next()) {
			equip2.setId(rs.getInt("id"));
			equip2.setEquipment(rs.getString("equipment"));
			equip2.setEtypename(rs.getString("etypename"));
			equip2.setEsrcid(rs.getInt("esrcid"));
		}
		return equip2;
	}

	/**
	 * 添加装备
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public void addEquip(Equip equip) throws Exception {
		String sql = "INSERT INTO equip(equipment,etypename,esrcid) VALUES(?,?,?)";
		Object[] params = { equip.getEquipment(), equip.getEtypename(),
				equip.getEsrcid() };
		edit(sql, params);
	}

	/**
	 * 删除装备
	 * 
	 * @param id
	 * @throws Exception
	 */
	@Override
	public void deleteEquip(Integer id) throws Exception {
		String sql = "delete from equip where id=?";
		Object[] params = { id };
		super.edit(sql, params);

	}

	/**
	 * 查询所有装备
	 */
	@Override
	public Page<Equip> queryEquipsPage(Equip equip, Page<Equip> page)
			throws Exception {
		StringBuffer buffer = new StringBuffer("SELECT * FROM equip where 1=1");
		// 组装查询条件
		List<Object> params = new ArrayList<Object>();

		buffer.append(" limit ?,?");
		params.add((page.getPageNo() - 1) * page.getPageCount());// 设置当前页的起始索引
		params.add(page.getPageCount());// 设置每页要显示的记录数
		ResultSet rs = super.query(buffer.toString(), params.toArray());

		List<Equip> equipList = new LinkedList<Equip>();
		while (rs.next()) {
			Equip equip2 = new Equip();
			equip2.setId(rs.getInt("id"));
			equip2.setEquipment(rs.getString("equipment"));
			equip2.setEtypename(rs.getString("etypename"));
			equip2.setEsrcid(rs.getInt("esrcid"));
			equipList.add(equip2);
		}
		// 设置分页参数
		page.setResultList(equipList);// 设置每页要显示的记录集合
		page.setTotalCount(queryCount());// 设置总记录数

		return page;
	}

	/**
	 * 查询所有装备
	 */
	@Override
	public List<Equip> queryEquipsPage(Equip equip) throws Exception {
		StringBuffer sql = new StringBuffer(
				"SELECT * FROM equip AS e ,src AS s WHERE e.`esrcid`=s.`id`");

		// 查询条件集合
		List<Object> params = new ArrayList<Object>();
		// 判断传入的参数不为空
		if (equip != null) {
			// 加上查询条件
			if (equip.getEquipment() != null && !"".equals(equip.getEquipment())) {
				sql.append(" and e.equipment like ?");
				params.add("%" + equip.getEquipment() + "%");
			}
		}
		// 调用父类查询方法返回结果集
		ResultSet rs = super.query(sql.toString(), params.toArray());

		List<Equip> equipList = new ArrayList<Equip>();

		while (rs.next()) {
			Equip equip2 = new Equip();
			equip2.setId(rs.getInt("id"));
			equip2.setEquipment(rs.getString("equipment"));
			equip2.setEtypename(rs.getString("etypename"));
			equip2.setEsrcid(rs.getInt("esrcid"));
			equip2.setImgsrc(rs.getString("imgsrc"));
			equipList.add(equip2);
		}
		return equipList;
	}
}
