package cn.hero.firc.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import cn.hero.firc.dao.IHuserDao;
import cn.hero.firc.entity.Huser;
import cn.hero.firc.util.Page;

/**
 * @description:显示用用户数据
 * @author:章冬蕾
 * @date:2018-12-27上午9:21:20
 * @version JDK1.7
 */
public class HuserDao extends BaseDao implements IHuserDao {

	/**
	 * 查询所有用户数据
	 */
	@Override
	public Page<Huser> queryHusersPage(Huser huser, Page<Huser> page)
			throws Exception {
		StringBuffer buffer = new StringBuffer("SELECT * FROM huser AS h,udan AS d,src s WHERE h.danid=d.id AND d.dansrcid=s.id");
		// 组装查询条件
		List<Object> params = new ArrayList<Object>();
		
		if (huser!=null) {
			if (huser.getId() != 0 && !"".equals(huser.getId())) {
				buffer.append(" and h.heroname like ?");
				params.add("%"+huser.getId()+"%");
			}
			if (huser.getNumber() != null && !"".equals(huser.getNumber())) {
				buffer.append(" and h.number like ?");
				params.add("%"+huser.getNumber()+"%");
			}
			if (huser.getUsername() != null && !"".equals(huser.getUsername())) {
				buffer.append(" and h.username like ?");
				params.add("%"+huser.getId()+"%");
			}
		}

		buffer.append(" limit ?,?");
		params.add((page.getPageNo() - 1) * page.getPageCount());// 设置当前页的起始索引
		params.add(page.getPageCount());// 设置每页要显示的记录数
		ResultSet rs = super.query(buffer.toString(), params.toArray());

		List<Huser> HuserList = new LinkedList<Huser>();
		while (rs.next()) {
			Huser huser2 = new Huser();
			huser2.setId(rs.getInt("id"));
			huser2.setNumber(rs.getString("number"));
			huser2.setPassword(rs.getString("password"));
			huser2.setUsername(rs.getString("username"));
			huser2.setTypeid(rs.getInt("typeid"));
			huser2.setAva(rs.getInt("ava"));
			huser2.setDanid(rs.getInt("danid"));
			huser2.setDanname(rs.getString("danname"));
			huser2.setDansrc(rs.getString("imgsrc"));
			HuserList.add(huser2);
		}
		// 设置分页参数
		page.setResultList(HuserList);// 设置每页要显示的记录集合
		page.setTotalCount(queryCount());// 设置总记录数

		return page;
	}

	/**
	 * 获取总记录数
	 * @return
	 * @throws Exception
	 */
	public Integer queryCount() throws Exception {
		String sql = "select count(*) from huser where 1=1";
		ResultSet resultList = super.query(sql);

		Integer count = 0;
		while (resultList.next()) {
			count = rs.getInt(1);
		}
		return count;
	}

	/**
	 * 修改用户信息
	 * 
	 * @param
	 * @throws Exception
	 */
	@Override
	public void updateHusers(Huser huser) throws Exception {
		String sql = "UPDATE  huser SET number=?,password=?,username=? WHERE id=?";
		Object[] params = { huser.getNumber(), huser.getPassword(),huser.getUsername(),huser.getId() };
		edit(sql, params);
	}

	/**
	 * 查询单个
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public Huser getHusersid(Integer id) throws Exception {
		String sql = "select * from huser where id=? ";
		Object[] params = { id };
		ResultSet rs = super.query(sql, params);
		Huser huser2 = new Huser();
		while (rs.next()) {
			huser2.setUsername(rs.getString("username"));
			huser2.setId(rs.getInt("id"));
			huser2.setNumber(rs.getString("number"));
			huser2.setPassword(rs.getString("password"));
			huser2.setTypeid(rs.getInt("typeid"));
			huser2.setAva(rs.getInt("ava"));
			huser2.setDanid(rs.getInt("danid"));
		}
		return huser2;
	}

	/**
	 * 添加用户信息
	 * @param huser
	 * @throws Exception
	 */
	@Override
	public void addHuser(Huser huser) throws Exception {
		String sql = "INSERT INTO huser(number,username,`password`,typeid) VALUES(?,?,?,?)";
		Object[] params = { huser.getNumber(),huser.getUsername(), huser.getPassword(),
				huser.getTypeid() };
		edit(sql, params);
	}
	/**
	 * 删除用户信息
	 * @param huser
	 * @throws Exception
	 */
	@Override
	public void deleteHuser(Integer id) throws Exception {
		String sql = "delete from huser where id=?";
		Object[] params = {id };
		super.edit(sql, params);
		
	}

	/**
	 * @name 名字
	 * @impact 作用 
	 */
	@Override
	public List<Huser> queryHusers(Huser huser) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer("SELECT * FROM huser AS h,udan AS d,src s WHERE h.danid=d.id AND d.dansrcid=s.id");
		// 组装查询条件
		List<Object> params = new ArrayList<Object>();
        if (huser!=null) {
        	// 加上查询条件
        				if (huser.getNumber() != null && !"".equals(huser.getNumber())) {
        					buffer.append(" and Number=?");
        					params.add(huser.getNumber());
        				}
        				if (huser.getPassword() != null && !"".equals(huser.getPassword())) {
        					buffer.append(" and password=?");
        					params.add(huser.getPassword());
        				}
		}
		
		ResultSet rs = super.query(buffer.toString(), params.toArray());

		List<Huser> HuserList = new LinkedList<Huser>();
		while (rs.next()) {
			Huser huser2 = new Huser();
			huser2.setId(rs.getInt("id"));
			huser2.setNumber(rs.getString("number"));
			huser2.setPassword(rs.getString("password"));
			huser2.setUsername(rs.getString("username"));
			huser2.setTypeid(rs.getInt("typeid"));
			huser2.setAva(rs.getInt("ava"));
			huser2.setDanid(rs.getInt("danid"));
			huser2.setDanname(rs.getString("danname"));
			huser2.setDansrc(rs.getString("imgsrc"));
			HuserList.add(huser2);
		}
		return HuserList;
	}

	/**
	 * @name 名字
	 * @impact 作用 
	 */
	@Override
	public Huser loginHuser(Huser huser) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer("SELECT * FROM userdan where 1=1");
		// 组装查询条件
		List<Object> params = new ArrayList<Object>();
        if (huser!=null) {
        	// 加上查询条件
        				if (huser.getNumber() != null && !"".equals(huser.getNumber())) {
        					buffer.append(" and `Number`=?");
        					params.add(huser.getNumber());
        				}
        				if (huser.getPassword() != null && !"".equals(huser.getPassword())) {
        					buffer.append(" and `password`=?");
        					params.add(huser.getPassword());
        				}
		}
		
		ResultSet rs = super.query(buffer.toString(), params.toArray());
		Huser huser2 =null;
		while (rs.next()) {
			huser2=new Huser();
			huser2.setId(rs.getInt("id"));
			huser2.setNumber(rs.getString("number"));
			huser2.setPassword(rs.getString("password"));
			huser2.setUsername(rs.getString("username"));
			huser2.setTypeid(rs.getInt("typeid"));
			huser2.setAva(rs.getInt("ava"));
			huser2.setDanid(rs.getInt("danid"));
			huser2.setDanname(rs.getString("danname"));
			huser2.setDansrc(rs.getString("usrc"));
		}
		return huser2;
	}

	/**
	 * @name 名字
	 * @impact 作用 
	 */
	@Override
	public void rechargeOn(Huser user) throws Exception {
		// TODO Auto-generated method stub
        String sql="update `huser` set ava=? where `number`=? ";
        ArrayList<Object> parsms=new ArrayList<Object>();
        parsms.add(user.getAva());
        parsms.add(user.getNumber());
        super.edit(sql, parsms.toArray());
	}

	@Override
	public void registerUser(Huser user) throws Exception {
		// TODO Auto-generated method stub
		
	}
   
}
