package cn.hero.firc.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.hero.firc.dao.ISkinDao;
import cn.hero.firc.dao.impl.SkinDao;
import cn.hero.firc.entity.Skin;
import cn.hero.firc.service.ISkinService;
import cn.hero.firc.util.MyBatisUtil;
import cn.hero.firc.util.Page;

/**
 * @description:皮肤service
 * @author:章冬蕾
 * @date:2018-12-21上午9:46:47
 * @version JDK1.7
 */
public class SkinService implements ISkinService {

	private SqlSession sqlSession;
	private ISkinDao iSkinDao;

	/**
	 * 分页查询所有皮肤
	 */
	@Override
	public Page<Skin> querySkinPage(Skin skin, Page<Skin> page)
			throws Exception {

		return this.iSkinDao.querySkinPage(skin, page);
	}

	/**
	 * 修改皮肤
	 * 
	 * @param
	 * @throws Exception
	 */
	@Override
	public void updateSkins(Skin skin) throws Exception {

		this.iSkinDao.updateSkins(skin);
	}

	/**
	 * 添加皮肤
	 * 
	 * @param huser
	 * @throws Exception
	 */
	@Override
	public void addSkin(Skin skin) throws Exception {
		this.iSkinDao.addSkin(skin);

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

		return this.iSkinDao.getSkinsid(id);
	}

	/**
	 * 删除皮肤
	 * 
	 * @param id
	 * @throws Exception
	 */
	@Override
	public void DeleteSkin(Integer id) throws Exception {
		this.iSkinDao.DeleteSkin(id);

	}

	/**
	 * 查询皮肤
	 * 
	 * @param skin
	 * @throws Exception
	 */
	@Override
	public List<Skin> querySkinList(Skin skin) throws Exception {
		return this.iSkinDao.querySkinList(skin);
	}

	/**
	 * 根据英雄查询单个根据英雄查询(小图标)
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Skin> getSkinHeroId(Integer id) throws Exception {
		sqlSession = MyBatisUtil.createSqlSession();
		iSkinDao = sqlSession.getMapper(ISkinDao.class);

		List<Skin> skinList = iSkinDao.getSkinHeroId(id);

		MyBatisUtil.closeSqlSession(sqlSession);
		return skinList;
	}

	/**
	 * 根据英雄查询单个根据英雄查询(大图标)
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Skin> getSkinSrcId(Integer id) throws Exception {
		sqlSession = MyBatisUtil.createSqlSession();
		iSkinDao = sqlSession.getMapper(ISkinDao.class);

		List<Skin> skinList = iSkinDao.getSkinSrcId(id);

		MyBatisUtil.closeSqlSession(sqlSession);

		return skinList;
	}

	/**
	 * @name 名字
	 * @impact 作用
	 */
	@Override
	public Skin buySkin(Integer id) throws Exception {
		// TODO Auto-generated method stub

		return iSkinDao.buySkinbyid(id);
	}
}
