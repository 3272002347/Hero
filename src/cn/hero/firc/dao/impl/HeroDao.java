package cn.hero.firc.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.hero.firc.dao.IHeroDao;
import cn.hero.firc.entity.Hero;
import cn.hero.firc.util.Page;

/**
 * @description:英雄数据访问实现类
 * @author:19138
 * @date:2018-12-20
 * @version JDK1.7
 */
public class HeroDao extends BaseDao implements IHeroDao {

	/**
	 * 查询所有英雄信息
	 * 
	 * @return 英雄集合
	 */
	@Override
	public List<Hero> queryHeros(Hero hero) throws Exception {
		StringBuffer sql = new StringBuffer(
				"SELECT * FROM src AS s,hero AS	h WHERE s.corrId=h.`id` AND	s.`imgtypeid`=1");
		// 查询条件集合
		List<Object> params = new ArrayList<Object>();

		// 判断传入的参数不为空
		if (hero != null) {
			// 加上查询条件
			if (hero.getHeroname() != null && !"".equals(hero.getHeroname())) {
				sql.append(" and h.heroname like ?");
				params.add("%" + hero.getHeroname() + "%");
			}
			if (hero.getHerostory() != null && !"".equals(hero.getHerostory())) {
				sql.append(" and h.herostory=?");
				params.add(hero.getHerostory());
			}
			if (hero.getHerotypeid() != null
					&& !"".equals(hero.getHerotypeid())) {
				sql.append(" and h.herotypeid=?");
				params.add(hero.getHerotypeid());
			}
			if (hero.getId() != 0) {
				sql.append(" and h.id=?");
				params.add(hero.getId());
			}
			if (hero.getViedoSrc() != null && !"".equals(hero.getViedoSrc())) {
				sql.append(" and h.viedoSrc=?");
				params.add(hero.getViedoSrc());
			}
		}

		// 调用父类查询方法返回结果集
		ResultSet rs = super.query(sql.toString(), params.toArray());

		List<Hero> Herolist = new ArrayList<Hero>();

		while (rs.next()) {
			Hero hero2 = new Hero();
			hero2.setHeroname(rs.getString("heroname"));
			hero2.setHerostory(rs.getString("herostory"));
			hero2.setHerotypeid(rs.getInt("herotypeid"));
			hero2.setId(rs.getInt("id"));
			hero2.setPrice(rs.getInt("price"));
			hero2.setViedoSrc(rs.getString("viedoSrc"));
			hero2.setImgsrc(rs.getString("imgsrc"));
			Herolist.add(hero2);
		}
		return Herolist;
	}

	/**
	 * 查询所有信息（分页）
	 * 
	 * @param hero
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@Override
	public Page<Hero> queryHerosPage(Hero hero, Page<Hero> page)
			throws Exception {
		StringBuffer sql = new StringBuffer(
				"SELECT * FROM src AS s,hero AS h,htype AS t WHERE s.corrId=h.`id`  AND s.`imgtypeid`=1 AND t.id=h.herotypeid order by h.id asc");

		StringBuffer buffer = new StringBuffer(sql);

		// 查询条件集合
		List<Object> params = new ArrayList<Object>();

		// 判断传入的参数不为空
		if (hero != null) {
			// 加上查询条件
			if (hero.getHeroname() != null && !"".equals(hero.getHeroname())) {
				sql.append(" and h.heroname=?");
				params.add(hero.getHeroname());
			}
			if (hero.getHerostory() != null && !"".equals(hero.getHerostory())) {
				sql.append(" and  and h.herostory=?");
				params.add(hero.getHerostory());
			}
			if (hero.getHerotypeid() != null
					&& !"".equals(hero.getHerotypeid())) {
				sql.append(" and h.herotypeid=?");
				params.add(hero.getHerotypeid());
			}
			if (hero.getId() != 0 && !"".equals(hero.getId())) {
				sql.append(" and h.id=?");
				params.add(hero.getId());
			}
			if (hero.getPrice() != 0 && !"".equals(hero.getPrice())) {
				sql.append(" and h.price=?");
				params.add(hero.getPrice());
			}
			if (hero.getViedoSrc() != null && !"".equals(hero.getViedoSrc())) {
				sql.append(" and h.viedoSrc=?");
				params.add(hero.getViedoSrc());
			}
		}

		// 排序
		buffer.append(" limit ?,?");
		params.add((page.getPageNo() - 1) * page.getPageCount());// 设置当前页的起始索引
		params.add(page.getPageCount());// 设置每页要显示的记录数

		ResultSet rs = super.query(buffer.toString(), params.toArray());

		List<Hero> Herolist = new ArrayList<Hero>();

		while (rs.next()) {
			Hero hero2 = new Hero();
			hero2.setHeroname(rs.getString("heroname"));
			hero2.setHerostory(rs.getString("herostory"));
			hero2.setHerotypeid(rs.getInt("herotypeid"));
			hero2.setId(rs.getInt("id"));
			hero2.setPrice(rs.getInt("price"));
			hero2.setViedoSrc(rs.getString("viedoSrc"));
			hero2.setImgsrc(rs.getString("imgsrc"));
			hero2.setHtypename(rs.getString("htypename"));
			hero2.setPostionname(rs.getString("PostionName"));
			Herolist.add(hero2);
		}

		// 设置分页参数
		page.setResultList(Herolist);// 设置每页要显示的记录集合
		page.setTotalCount(this.queryCount());// 设置总记录数

		return page;
	}

	/**
	 * 查询所有英雄行数
	 * 
	 * @return
	 * @throws Exception
	 */
	private Integer queryCount() throws Exception {
		String sql = "SELECT count(1) FROM `hero`";
		ResultSet rs = super.query(sql);

		Integer count = 0;
		while (rs.next()) {
			count = rs.getInt(1);
		}
		return count;
	}

	/**
	 * 添加英雄信息
	 * 
	 * @param hero
	 * @throws Exception
	 */
	@Override
	public void addHeros(Hero hero) throws Exception {
		String sql = "INSERT INTO hero (heroname,herostory,price,viedoSrc,herotypeid) VALUES(?,?,?,?,?)";
		Object[] params = { hero.getHeroname(), hero.getHerostory(),
				hero.getPrice(), hero.getViedoSrc(), hero.getHerotypeid() };
		super.edit(sql, params);
	}

	/**
	 * 查询英雄分类
	 * 
	 * @param herotypeid
	 * @return
	 * @throws Exception
	 */
	@Override
	public Hero queryByherotypeid(Integer herotypeid) throws Exception {

		String sql = "SELECT h.*,t.* FROM `hero` h,htype t WHERE h.herotypeid=t.id AND h.`id`=?";
		Object[] params = { herotypeid };
		ResultSet rs = super.query(sql, params);
		Hero hero2 = new Hero();
		while (rs.next()) {
			hero2.setHeroname(rs.getString("heroname"));
			hero2.setHerostory(rs.getString("herostory"));
			hero2.setHerotypeid(rs.getInt("herotypeid"));
			hero2.setId(rs.getInt("id"));
			hero2.setPrice(rs.getInt("price"));
			hero2.setViedoSrc(rs.getString("viedoSrc"));
			hero2.setHtypename(rs.getString("htypename"));
			hero2.setPostionname(rs.getString("postionname"));
		}
		return hero2;
	}

	@Override
	public void updateHero(Hero hero) throws Exception {
		String sql = "UPDATE hero SET heroname=?,herostory=?,price=?,herotypeid=? WHERE id=?";
		Object[] params = { hero.getHeroname(), hero.getHerostory(),
				hero.getPrice(), hero.getHerotypeid(), hero.getId() };
		super.edit(sql, params);
	}

	@Override
	public void deleteHero(Integer heroid) throws Exception {
		// TODO Auto-generated method stub

	}
}
