package cn.hero.firc.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cn.hero.firc.dao.IUdanDao;
import cn.hero.firc.entity.Udan;
import cn.hero.firc.util.Page;

/**
 * @description:显示用户段位
 * @author:章冬蕾
 * @date:2018-12-24下午4:11:27
 * @version JDK1.7
 */
public class UdanDao extends BaseDao implements IUdanDao {

	/**
	 * 分页查询用户段位
	 */
	@Override
	public Page<Udan> queryUdanPage(Udan udan, Page<Udan> page)
			throws Exception {
		StringBuffer buffer = new StringBuffer("SELECT * FROM udan where 1=1");
		// 组装查询条件
		List<Object> params = new ArrayList<Object>();

		buffer.append(" limit ?,?");
		params.add((page.getPageNo() - 1) * page.getPageCount());// 设置当前页的起始索引
		params.add(page.getPageCount());// 设置每页要显示的记录数
		ResultSet rs = super.query(buffer.toString(), params.toArray());

		List<Udan> udanList = new LinkedList<Udan>();
		while (rs.next()) {
			Udan udan2 = new Udan();
			udan2.setId(rs.getInt("id"));
			udan2.setDanname(rs.getString("danname"));
			udan2.setDansrcid(rs.getInt("dansrcid"));
			udanList.add(udan2);
		}
		// 设置分页参数
		page.setResultList(udanList);// 设置每页要显示的记录集合
		page.setTotalCount(queryCount());// 设置总记录数

		return page;
	}

	/**
	 * 获取总记录数
	 * @return
	 * @throws Exception
	 */
	public Integer queryCount() throws Exception {
		String sql = "select count(*) from udan where 1=1";
		ResultSet resultList = super.query(sql, new Object[] {});

		Integer count = 0;
		while (resultList.next()) {
			count = rs.getInt(1);
		}
		return count;
	}

	

	/**
	 * 修改段位
	 * @param
	 * @throws Exception
	 */
	@Override
	public void updateUdans(Udan udan) throws Exception {
		String sql = "UPDATE  udan SET danname=?,dansrcid=? WHERE id=?";
		Object[] params = {udan.getDanname(),udan.getDansrcid(),udan.getId()};
		edit(sql, params);
	}

	
	/**
	 * 查询单个 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public Udan getSrctypeid(Integer id) throws Exception {
		String sql = "select * from udan where id=? ";
		Object[] params = { id };
		ResultSet rs = super.query(sql, params);
		Udan udan2 = new Udan();
		while (rs.next()) {	
			udan2.setId(rs.getInt("id"));
			udan2.setDanname(rs.getString("danname"));
			udan2.setDansrcid(rs.getInt("dansrcid"));
		}
		return udan2;
	}

	
	/**
	 * 添加段位
	 * @param huser
	 * @throws Exception
	 */
	@Override
	public void addUdan(Udan udan) throws Exception {
		String sql = "INSERT INTO udan(danname,dansrcid) VALUES(?,?)";
		Object[] params = {udan.getDanname(),udan.getDansrcid()};
		edit(sql, params);
		
	}

	
	/**
	 * 删除段位
	 * @param id
	 * @throws Exception
	 */
	@Override
	public void DeleteUdan(Integer id) throws Exception {
		String sql = "delete from udan where id=?";
		Object[] params = { id };
		super.edit(sql, params);
	}

	/**
	 * 查询用户段位
	 */
	@Override
	public List<Udan> queryUdans(Udan udan) throws Exception {
		StringBuffer buffer = new StringBuffer("SELECT * FROM udan where 1=1 ");
		   //组装查询条件
			List<Object> params = new ArrayList<Object>();
			
			ResultSet rs = super.query(buffer.toString(), params.toArray());
			List<Udan> udanList = new LinkedList<Udan>();
			while (rs.next()) {
				Udan udan2 = new Udan();
				udan2.setId(rs.getInt("id"));
				udan2.setDanname(rs.getString("danname"));
				udan2.setDansrcid(rs.getInt("dansrcid"));
				udanList.add(udan2);
			}
			return udanList;
	}
}
