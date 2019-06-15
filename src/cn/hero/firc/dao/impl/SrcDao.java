package cn.hero.firc.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cn.hero.firc.dao.ISrcDao;
import cn.hero.firc.entity.Src;
import cn.hero.firc.util.Page;

/**
 * @description:显示图标路径
 * @author:章冬蕾
 * @date:2018-12-27上午9:47:45
 * @version JDK1.7
 */
public class SrcDao extends BaseDao implements ISrcDao {

	/**
	 * 分页查询所有图标路径
	 */
	@Override
	public Page<Src> querySrcPage(Src src, Page<Src> page) throws Exception {
		StringBuffer buffer = new StringBuffer("SELECT * FROM src where 1=1");
		// 组装查询条件
		List<Object> params = new ArrayList<Object>();

		buffer.append(" limit ?,?");
		params.add((page.getPageNo() - 1) * page.getPageCount());// 设置当前页的起始索引
		params.add(page.getPageCount());// 设置每页要显示的记录数
		ResultSet rs = super.query(buffer.toString(), params.toArray());

		List<Src> srcList = new LinkedList<Src>();
		while (rs.next()) {
			Src src2 = new Src();
			src2.setId(rs.getInt("id"));
			src2.setImgsrc(rs.getString("imgsrc"));
			src2.setImgtypeid(rs.getInt("imgtypeid"));
			srcList.add(src2);
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
		String sql = "select count(*) from src where 1=1";
		ResultSet resultList = super.query(sql, new Object[] {});

		Integer count = 0;
		while (resultList.next()) {
			count = rs.getInt(1);
		}
		return count;
	}

	/**
	 * 修改图标路径
	 * @param
	 * @throws Exception
	 */
	@Override
	public void updateSrcs(Src src) throws Exception {
		String sql = "UPDATE  src SET imgsrc=?,imgtypeid=?,corrId=? WHERE id=?";
		Object[] params = {src.getImgsrc(),src.getImgtypeid(),src.getCorrId()};
		edit(sql, params);
	}

	/**
	 * 查询单个 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public Src getSrcid(Integer id) throws Exception {
		String sql = "select * from src where id=? ";
		Object[] params = { id };
		ResultSet rs = super.query(sql, params);
		Src src2 = new Src();
		while (rs.next()) {

			src2.setId(rs.getInt("id"));
			src2.setImgsrc(rs.getString("imgsrc"));
			src2.setImgtypeid(rs.getInt("imgtypeid"));
			src2.setCorrId(rs.getInt("corrId"));
		}
		return src2;
	}

	/**
	 * 添加图标路径
	 * @param huser
	 * @throws Exception
	 */
	@Override
	public void addSrc(Src src) throws Exception {
		
		String sql = "INSERT INTO src(corrId,imgtypeid,imgsrc) VALUES((SELECT id FROM hero WHERE heroname=?),'1',?)";
		Object[] params = {src.getHeroName(),src.getImgsrc()};
		edit(sql, params);

	}

	/**
	 * 删除图标路径
	 * @param id
	 * @throws Exception
	 */
	@Override
	public void DeleteSrc(Integer id) throws Exception {
		String sql = "delete from src where id=?";
		Object[] params = { id };
		super.edit(sql, params);
		
	}

	/**
	 * 查询所有图标路径
	 */
	@Override
	public List<Src> querySrc(Src src) throws Exception {
		StringBuffer buffer = new StringBuffer("SELECT * FROM src where 1=1 ");
		   //组装查询条件
			List<Object> params = new ArrayList<Object>();
			
			ResultSet rs = super.query(buffer.toString(), params.toArray());
			List<Src> srcList = new LinkedList<Src>();
			while (rs.next()) {
				Src src2 = new Src();
				src2.setId(rs.getInt("id"));
				src2.setImgsrc(rs.getString("imgsrc"));
				src2.setImgtypeid(rs.getInt("imgtypeid"));
				srcList.add(src2);
			}
			return srcList;
	}

}
