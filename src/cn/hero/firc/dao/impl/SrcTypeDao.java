package cn.hero.firc.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cn.hero.firc.dao.ISrcTypeDao;
import cn.hero.firc.entity.Srctype;
import cn.hero.firc.util.Page;

/**
 * @description:显示图标类别数据
 * @author:章冬蕾
 * @date:2018-12-27上午10:00:42
 * @version JDK1.7
 */
public class SrcTypeDao extends BaseDao implements ISrcTypeDao {

	/**
	 * 分页显示所有图标类别
	 */
	@Override
	public Page<Srctype> querySrctypePage(Srctype srctype, Page<Srctype> page)
			throws Exception {
		StringBuffer buffer = new StringBuffer(
				"SELECT * FROM srctype where 1=1");
		// 组装查询条件
		List<Object> params = new ArrayList<Object>();

		buffer.append(" limit ?,?");
		params.add((page.getPageNo() - 1) * page.getPageCount());// 设置当前页的起始索引
		params.add(page.getPageCount());// 设置每页要显示的记录数
		ResultSet rs = super.query(buffer.toString(), params.toArray());

		List<Srctype> srcList = new LinkedList<Srctype>();
		while (rs.next()) {
			Srctype srctype2 = new Srctype();
			srctype2.setId(rs.getInt("id"));
			srctype2.setImgtypename(rs.getString("imgtypename"));
			srcList.add(srctype2);
		}
		// 设置分页参数
		page.setResultList(srcList);// 设置每页要显示的记录集合
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
		String sql = "select count(*) from srctype where 1=1";
		ResultSet resultList = super.query(sql, new Object[] {});

		Integer count = 0;
		while (resultList.next()) {
			count = rs.getInt(1);
		}
		return count;
	}

	
	/**
	 * 修改图标类别
	 * @param
	 * @throws Exception
	 */
	@Override
	public void updateSrctypes(Srctype srctype) throws Exception {
		String sql = "UPDATE  srctype SET imgtypename=? WHERE id=?";
		Object[] params = { srctype.getImgtypename(),srctype.getId()};
		edit(sql, params);
	}

	/**
	 * 查询单个 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public Srctype getSrctypeid(Integer id) throws Exception {
		String sql = "select * from srctype where id=? ";
		Object[] params = { id };
		ResultSet rs = super.query(sql, params);
		Srctype srctype2 = new Srctype();
		while (rs.next()) {	
			srctype2.setId(rs.getInt("id"));
			srctype2.setImgtypename(rs.getString("imgtypename"));
		}
		return srctype2;
	}

	

	/**
	 * 添加图标类别
	 * @param huser
	 * @throws Exception
	 */
	@Override
	public void addSrctype(Srctype sctype) throws Exception {
		String sql = "INSERT INTO sctype(imgtypename) VALUES(?)";
		Object[] params = {sctype.getImgtypename()};
		edit(sql, params);
		
	}

	/**
	 * 删除图标类别
	 * @param id
	 * @throws Exception
	 */
	@Override
	public void DeleteSrctype(Integer id) throws Exception {
		String sql = "delete from sctype where id=?";
		Object[] params = { id };
		super.edit(sql, params);
	}

	
	/**
	 * 显示所有图标类别
	 */
	@Override
	public List<Srctype> querySrctype(Srctype srctype) throws Exception {
		StringBuffer buffer = new StringBuffer("SELECT * FROM srctype where 1=1 ");
		   //组装查询条件
			List<Object> params = new ArrayList<Object>();
			
			ResultSet rs = super.query(buffer.toString(), params.toArray());
			List<Srctype> srctypeList = new LinkedList<Srctype>();
			while (rs.next()) {
				Srctype srctype2 = new Srctype();
				srctype2.setId(rs.getInt("id"));
				srctype2.setImgtypename(rs.getString("imgtypename"));
				srctypeList.add(srctype2);
			}
			return srctypeList;
	}

}
