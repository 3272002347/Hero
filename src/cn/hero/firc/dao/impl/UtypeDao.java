package cn.hero.firc.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cn.hero.firc.dao.IUtypeDao;
import cn.hero.firc.entity.Utype;
import cn.hero.firc.util.Page;

/**
 * @description:显示类别分类
 * @author:章冬蕾
 * @date:2018-12-27上午10:10:37
 * @version JDK1.7
 */
public class UtypeDao extends BaseDao implements IUtypeDao {

	
	/**
	 * 分页类别分类
	 */
	@Override
	public Page<Utype> queryUtypePage(Utype utype, Page<Utype> page)
			throws Exception {
		StringBuffer buffer = new StringBuffer("SELECT * FROM utype where 1=1");
		// 组装查询条件
		List<Object> params = new ArrayList<Object>();

		buffer.append(" limit ?,?");
		params.add((page.getPageNo() - 1) * page.getPageCount());// 设置当前页的起始索引
		params.add(page.getPageCount());// 设置每页要显示的记录数
		ResultSet rs = super.query(buffer.toString(), params.toArray());

		List<Utype> utypeList = new LinkedList<Utype>();
		while (rs.next()) {
			Utype utype2 = new Utype();
			utype2.setId(rs.getInt("id"));
			utype2.setTypename(rs.getString("typename"));
			utypeList.add(utype2);
		}
		// 设置分页参数
		page.setResultList(utypeList);// 设置每页要显示的记录集合
		page.setTotalCount(queryCount());// 设置总记录数
	
		return page;
	}
	/**
	 * 获取总记录数 
	 * @return
	 * @throws Exception
	 */
	public Integer queryCount() throws Exception {
		String sql = "select count(*) from utype where 1=1";
		ResultSet resultList = super.query(sql, new Object[] {});

		Integer count = 0;
		while (resultList.next()) {
			count = rs.getInt(1);
		}
		return count;
	}

	

	/**
	 * 修改用户类别
	 * @param
	 * @throws Exception
	 */
	@Override
	public void updateUtypes(Utype utype) throws Exception {
		String sql = "UPDATE  utype SETtypename=? WHERE id=?";
		Object[] params = {utype.getTypename(),utype.getId()};
		edit(sql, params);
	}

	/**
	 * 查询单个 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public Utype getUtypeid(Integer id) throws Exception {
		String sql = "select * from utype where id=? ";
		Object[] params = { id };
		ResultSet rs = super.query(sql, params);
		Utype utype2 = new Utype();
		while (rs.next()) {	
			utype2.setId(rs.getInt("id"));
			utype2.setTypename(rs.getString("typename"));
		}
		return utype2;
	}

	/**
	 * 添加用户类别
	 * @param huser
	 * @throws Exception
	 */
	@Override
	public void addUtype(Utype utype) throws Exception {
		String sql = "INSERT INTO utype(typename) VALUES(?)";
		Object[] params = {utype.getTypename()};
		edit(sql, params);
	}

	
	/**
	 * 删除用户类别
	 * @param id
	 * @throws Exception
	 */
	@Override
	public void DeleteUtype(Integer id) throws Exception {
		String sql = "delete from utype where id=?";
		Object[] params = { id };
		super.edit(sql, params);
	}
	

	/**
	 * 类别分类
	 */
	@Override
	public List<Utype> queryUtypes(Utype utype) throws Exception {
		StringBuffer buffer = new StringBuffer("SELECT * FROM utype where 1=1");
		   //组装查询条件
			List<Object> params = new ArrayList<Object>();
			
			ResultSet rs = super.query(buffer.toString(), params.toArray());
			List<Utype> utypeList = new LinkedList<Utype>();
			while (rs.next()) {
				Utype utype2 = new Utype();
				utype2.setId(rs.getInt("id"));
				utype2.setTypename(rs.getString("typename"));
				utypeList.add(utype2);
			}
			return utypeList;
	}

}
