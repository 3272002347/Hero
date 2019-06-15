package cn.hero.firc.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.hero.firc.dao.ISjskilDao;
import cn.hero.firc.dao.impl.SjskilDao;
import cn.hero.firc.entity.Sjskil;
import cn.hero.firc.service.ISjskilService;
import cn.hero.firc.util.MyBatisUtil;
import cn.hero.firc.util.Page;

/**
 * @description:召唤师技能service
 * @author:章冬蕾
 * @date:2018-12-25下午5:11:14
 * @version JDK1.7
 */
public class SjskilService implements ISjskilService {

	private SqlSession sqlSession;
	private ISjskilDao iSjskilDao;

	/**
	 * 分页查询所有召唤师技能
	 * 
	 * @param sjskil
	 * @param page
	 * @return
	 * @throws Exception
	 */

	@Override
	public Page<Sjskil> querySjskilPage(Sjskil sjskil, Page<Sjskil> page)
			throws Exception {
		return this.iSjskilDao.querySjskilPage(sjskil, page);
	}

	/**
	 * 修改召唤师技能
	 * 
	 * @param
	 * @throws Exception
	 */
	@Override
	public void updateSjskils(Sjskil sjskil) throws Exception {
		this.iSjskilDao.updateSjskils(sjskil);
	}

	/**
	 * 查询单个
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public Sjskil getSjskilsid(Integer id) throws Exception {

		return this.iSjskilDao.getSjskilsid(id);
	}

	/**
	 * 添加召唤师技能
	 * 
	 * @param huser
	 * @throws Exception
	 */
	@Override
	public void addSjskil(Sjskil sjskil) throws Exception {
		this.iSjskilDao.addSjskil(sjskil);
	}

	/**
	 * 删除召唤师技能
	 * 
	 * @param id
	 * @throws Exception
	 */
	@Override
	public void deleteSjskil(Integer id) throws Exception {
		this.iSjskilDao.deleteSjskil(id);
	}

	/**
	 * 查询所有召唤师技能
	 */
	@Override
	public List<Sjskil> querySjskil(Sjskil sjskil) throws Exception {

		sqlSession = MyBatisUtil.createSqlSession();
		iSjskilDao = sqlSession.getMapper(ISjskilDao.class);
		List<Sjskil> sjskilList = iSjskilDao.querySjskil(sjskil);

		MyBatisUtil.closeSqlSession(sqlSession);
		return sjskilList;
	}
}
