package cn.hero.firc.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cn.hero.firc.dao.ISkinDao;
import cn.hero.firc.entity.Skin;
import cn.hero.firc.util.Page;

/**
 * @description:显示数据
 * @author:章冬蕾
 * @date:2018-12-21上午10:19:44
 * @version JDK1.7
 */
public class SkinDao extends BaseDao implements ISkinDao {

	/**
	 * 查询全部
	 */
	@Override
	public List<Skin> querySkinList(Skin skin) throws Exception {
		StringBuffer buffer = new StringBuffer("SELECT * FROM skin where 1=1");
		// 组装查询条件
		List<Object> params = new ArrayList<Object>();

		ResultSet rs = super.query(buffer.toString(), params.toArray());

		List<Skin> skinList = new LinkedList<Skin>();
		while (rs.next()) {
			Skin skin2 = new Skin();
			skin2.setId(rs.getInt("id"));
			skin2.setSkinname(rs.getString("skinname"));
			skin2.setSkinsrcid(rs.getInt("skinsrcid"));
			skin2.setPrice(rs.getInt("price"));
			skin2.setHeroid(rs.getInt("heroid"));
			skinList.add(skin2);
		}
		return skinList;
	}

	/**
	 * 分页查询所有
	 */
	@Override
	public Page<Skin> querySkinPage(Skin skin, Page<Skin> page)
			throws Exception {
		StringBuffer buffer = new StringBuffer(
				"SELECT * FROM skinimp WHERE 1=1 AND skinname LIKE '%图标%'");
		// 组装查询条件
		List<Object> params = new ArrayList<Object>();

		buffer.append(" limit ?,?");
		params.add((page.getPageNo() - 1) * page.getPageCount());// 设置当前页的起始索引
		params.add(page.getPageCount());// 设置每页要显示的记录数
		ResultSet rs = super.query(buffer.toString(), params.toArray());

		List<Skin> skinList = new LinkedList<Skin>();
		while (rs.next()) {
			Skin skin2 = new Skin();
			skin2.setId(rs.getInt("id"));
			String skinname = rs.getString("skinname");
			if (skinname.indexOf("图标") >= 8) {
				skinname = skinname.substring(0, 8) + "...";
			} else {
				skinname = skinname.substring(0, skinname.indexOf("图标"));
			}
			skin2.setSkinname(skinname);
			skin2.setImgsrc(rs.getString("imgsrc"));
			skin2.setSkinsrcid(rs.getInt("skinsrcid"));
			skin2.setPrice(rs.getInt("price"));
			skin2.setHeroid(rs.getInt("heroid"));
			skinList.add(skin2);
		}
		// 设置分页参数
		page.setResultList(skinList);// 设置每页要显示的记录集合
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
		String sql = "select count(*) from skin where 1=1 AND skinname LIKE '%图标%'";
		ResultSet resultList = super.query(sql, new Object[] {});

		Integer count = 0;
		while (resultList.next()) {
			count = rs.getInt(1);
		}
		return count;
	}

	/**
	 * 修改皮肤
	 * 
	 * @param
	 * @throws Exception
	 */
	@Override
	public void updateSkins(Skin skin) throws Exception {
		String sql = "UPDATE  skin SET skinname=?,skinsrcid=?,price=?,heroid=? WHERE id=?";
		Object[] params = { skin.getSkinname(), skin.getSkinsrcid(),
				skin.getPrice(), skin.getId() };
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
	public Skin getSkinsid(Integer id) throws Exception {
		String sql = "select * from skin where id=? ";
		Object[] params = { id };
		ResultSet rs = super.query(sql, params);
		Skin skin2 = new Skin();
		while (rs.next()) {

			skin2.setId(rs.getInt("id"));
			skin2.setSkinname(rs.getString("skinname"));
			skin2.setSkinsrcid(rs.getInt("skinsrcid"));
			skin2.setPrice(rs.getInt("price"));
			skin2.setHeroid(rs.getInt("heroid"));
		}
		return skin2;
	}

	/**
	 * 添加皮肤
	 * 
	 * @param huser
	 * @throws Exception
	 */
	@Override
	public void addSkin(Skin skin) throws Exception {
		String sql = "INSERT INTO skin(skinname,skinsrcid,price,heroid) VALUES(?,?,?,?)";
		Object[] params = { skin.getSkinname(), skin.getSkinsrcid(),
				skin.getPrice(), skin.getHeroid() };
		edit(sql, params);
	}

	/**
	 * 删除皮肤
	 * 
	 * @param id
	 * @throws Exception
	 */
	@Override
	public void DeleteSkin(Integer id) throws Exception {
		String sql = "delete from skin where id=?";
		Object[] params = { id };
		super.edit(sql, params);
	}

	/**
	 * 根据英雄查询(小图标)
	 * 
	 * @param id
	 * @throws Exception
	 */
	@Override
	public List<Skin> getSkinHeroId(Integer id) throws Exception {
		String sql = "SELECT * FROM skin AS s,src AS sr WHERE   s.skinsrcid=sr.`id` AND s.`heroid`=? AND s.skinname LIKE '%图标%'";
		Object[] params = { id };
		ResultSet rs = super.query(sql, params);
		List<Skin> skinList = new LinkedList<Skin>();
		while (rs.next()) {
			Skin skin2 = new Skin();
			skin2.setId(rs.getInt("id"));
			skin2.setSkinname(rs.getString("skinname"));
			skin2.setSkinsrcid(rs.getInt("skinsrcid"));
			skin2.setPrice(rs.getInt("price"));
			skin2.setHeroid(rs.getInt("heroid"));
			skin2.setImgsrc(rs.getString("imgsrc"));
			skinList.add(skin2);
		}
		return skinList;
	}

	/**
	 * 根据英雄查询(大图标)
	 * 
	 * @param id
	 * @throws Exception
	 */
	@Override
	public List<Skin> getSkinSrcId(Integer id) throws Exception {
		String sql = "SELECT * FROM skin AS s,src AS sr WHERE   s.skinsrcid=sr.`id` AND s.`heroid`=? AND s.skinname Not LIKE '%图标%'";
		Object[] params = { id };
		ResultSet rs = super.query(sql, params);
		List<Skin> skinList = new LinkedList<Skin>();
		while (rs.next()) {
			Skin skin2 = new Skin();
			skin2.setId(rs.getInt("id"));
			skin2.setSkinname(rs.getString("skinname"));
			skin2.setSkinsrcid(rs.getInt("skinsrcid"));
			skin2.setPrice(rs.getInt("price"));
			skin2.setHeroid(rs.getInt("heroid"));
			skin2.setImgsrc(rs.getString("imgsrc"));
			skinList.add(skin2);
		}
		return skinList;
	}

	/**
	 * @name 名字
	 * @impact 作用 
	 */
	@Override
	public Skin buySkinbyid(Integer id) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from ownthing where id =?";
		List<Object> parasms=new ArrayList<Object>();
		parasms.add(id);
		ResultSet rs=super.query(sql, parasms.toArray());
		Skin skin=new Skin();
		if (rs.next()) {
			skin.setId(rs.getInt("id"));
			skin.setHeroid(rs.getInt("heroid"));
			skin.setImgsrc(rs.getString("imgsrc"));
			skin.setPrice(rs.getInt("price"));
			skin.setSkinname(rs.getString("skinname"));
			skin.setSkinsrcid(rs.getInt("skinsrcid"));
		}
		return skin;
	}
}
