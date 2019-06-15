package cn.hero.firc.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import cn.hero.firc.dao.IHtypeDao;
import cn.hero.firc.entity.Htype;
import cn.hero.firc.util.Page;

/**
 * @description:英雄类别
 * @author:章冬蕾
 * @date:2018-12-27上午8:46:45
 * @version JDK1.7
 */
public class HtypeDao extends BaseDao implements IHtypeDao {


	/**
	 * 获取总记录数
	 * @return
	 * @throws Exception
	 */
	public Integer queryCount() throws Exception {
		String sql = "select count(*) from htype where 1=1";
		ResultSet resultList = super.query(sql, new Object[] {});

		Integer count = 0;
		while (resultList.next()) {
			count = rs.getInt(1);
		}
		return count;
	}

	
	/**
	 * 修改英雄类别
	 * @param 
	 * @throws Exception
	 */
	@Override
	public void updateHtypes(Htype htype) throws Exception {
		String sql = "UPDATE  htype SET htypename=?,postionname=? WHERE id=?";
		Object[] params = {htype.getHtypename(),htype.getPostionname()};
		edit(sql, params);
	}

	
	/**
	 * 查询单个
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public Htype getHtypesid(Integer id) throws Exception {
		String sql = "select * from htype where id=? ";
		Object[] params = { id };
		ResultSet rs = super.query(sql, params);
		Htype htype2 = new Htype();
		while (rs.next()) {

			htype2.setId(rs.getInt("id"));
			htype2.setHtypename(rs.getString("htypename"));
			htype2.setPostionname(rs.getString("postionname"));
		
		}
		return htype2;
	}
	
	/**
	 * 添加英雄类别
	 * @param htype
	 * @throws Exception
	 */
	@Override
	public void addHtype(Htype htype) throws Exception {
		String sql = "INSERT INTO htype(htypename,postionname) VALUES(?,?)";
		Object[] params = {htype.getHtypename(),htype.getPostionname() };
		edit(sql, params);
	}

	
	/**
	 * 删除英雄类别
	 * @param id
	 * @throws Exception
	 */
	@Override
	public void deleteHtype(Integer id) throws Exception {
		String sql = "delete from htype where id=?";
		Object[] params = {id };
		super.edit(sql, params);
		
	}

	/**
	 * 查询所有英雄类别
	 */
	@Override
	public List<Htype> queryHtypes(Htype htype) throws Exception {
		StringBuffer buffer = new StringBuffer("SELECT * FROM htype where 1=1 ");
		   //组装查询条件
			List<Object> params = new ArrayList<Object>();
			
			ResultSet rs = super.query(buffer.toString(), params.toArray());
			List<Htype> htypeList = new LinkedList<Htype>();
			while (rs.next()) {
				Htype htype2 = new Htype();
				htype2.setId(rs.getInt("id"));
				htype2.setHtypename(rs.getString("htypename"));
				htype2.setPostionname(rs.getString("postionname"));
				htypeList.add(htype2);
			}
			return htypeList;
	}


	/**
	 * 分页查询所有英雄类别
	 */
	@Override
	public Page<Htype> queryHtypesPage(Htype htype, Page<Htype> page)
			throws Exception {
		StringBuffer buffer = new StringBuffer("SELECT * FROM htype where 1=1");
		// 组装查询条件
		List<Object> params = new ArrayList<Object>();

		buffer.append(" limit ?,?");
		params.add((page.getPageNo() - 1) * page.getPageCount());// 设置当前页的起始索引
		params.add(page.getPageCount());// 设置每页要显示的记录数
		ResultSet rs = super.query(buffer.toString(), params.toArray());

		List<Htype> HtypeList = new LinkedList<Htype>();
		while (rs.next()) {
			Htype htype2 = new Htype();
			htype2.setId(rs.getInt("id"));
			htype2.setHtypename(rs.getString("htypename"));
			htype2.setPostionname(rs.getString("postionname"));
			HtypeList.add(htype2);
		}
		// 设置分页参数
		page.setResultList(HtypeList);// 设置每页要显示的记录集合
		page.setTotalCount(queryCount());// 设置总记录数

		return page;
	}

}
