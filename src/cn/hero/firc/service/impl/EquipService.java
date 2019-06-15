package cn.hero.firc.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.hero.firc.dao.IEquipDao;
import cn.hero.firc.dao.impl.EquipDao;
import cn.hero.firc.entity.Equip;
import cn.hero.firc.service.IEquipService;
import cn.hero.firc.util.MyBatisUtil;
import cn.hero.firc.util.Page;

/**
 * @description:装备service
 * @author:章冬蕾
 * @date:2018-12-21上午11:02:05
 * @version JDK1.7
 */
public class EquipService implements IEquipService {

	private SqlSession sqlSession;
	private IEquipDao iEquipDao;

	/**
	 * 查询所有装备
	 * 
	 * @param id
	 * @throws Exception
	 */
	@Override
	public List<Equip> queryEquipsPage(Equip equip) throws Exception {
		// mybaits实例化接口对象
		this.sqlSession = MyBatisUtil.createSqlSession();
		this.iEquipDao = sqlSession.getMapper(IEquipDao.class);
		
		List<Equip> equipList = this.iEquipDao.queryEquipsPage(equip);
		// 关闭
		MyBatisUtil.closeSqlSession(sqlSession);
		return equipList;
	}

	/**
	 * 查询所有装备
	 */

	@Override
	public Page<Equip> queryEquipPage(Equip equip, Page<Equip> page)
			throws Exception {
		return this.iEquipDao.queryEquipsPage(equip, page);
	}

	/**
	 * 修改装备信息
	 * 
	 * @param
	 * @throws Exception
	 */
	@Override
	public void updateEquips(Equip equip) throws Exception {
		this.iEquipDao.updateEquips(equip);

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

		return this.iEquipDao.getEquipsid(id);
	}

	/**
	 * 添加装备
	 * 
	 * @param equip
	 * @throws Exception
	 */
	@Override
	public void addEquip(Equip equip) throws Exception {
		this.iEquipDao.addEquip(equip);

	}

	/**
	 * 删除装备
	 * 
	 * @param id
	 * @throws Exception
	 */
	@Override
	public void deleteEquip(Integer id) throws Exception {
		this.iEquipDao.deleteEquip(id);

	}

}
