package cn.hero.firc.service.impl;

import java.util.List;

import cn.hero.firc.dao.IHtypeDao;
import cn.hero.firc.dao.impl.HtypeDao;
import cn.hero.firc.entity.Htype;
import cn.hero.firc.service.IHtypeService;
import cn.hero.firc.util.Page;

/**
 * @description:英雄类别service
 * @author:章冬蕾
 * @date:2018-12-27上午8:59:12
 * @version JDK1.7
 */
public class HtypeService implements IHtypeService {

	IHtypeDao iHtypeDao = new HtypeDao();

	/**
	 * 查询所有英雄类别
	 */
	@Override
	public Page<Htype> queryHerosPage(Htype htype, Page<Htype> page)
			throws Exception {
		return this.iHtypeDao.queryHtypesPage(htype, page);
	}

	
	/**
	 * 修改英雄类别
	 * @param 
	 * @throws Exception
	 */
	@Override
	public void updateHtypes(Htype htype) throws Exception {
          this.iHtypeDao.updateHtypes(htype);
		
	}

	
	/**
	 * 查询单个
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public Htype getHtypesid(Integer id) throws Exception {
		
		return this.iHtypeDao.getHtypesid(id);
	}

	
	/**
	 * 添加英雄类别
	 * @param htype
	 * @throws Exception
	 */
	@Override
	public void addHtype(Htype htype) throws Exception {
		this.iHtypeDao.addHtype(htype);
		
	}

	
	/**
	 * 删除英雄类别
	 * @param id
	 * @throws Exception
	 */
	@Override
	public void deleteHtype(Integer id) throws Exception {           
		this.iHtypeDao.deleteHtype(id);
		
	}

	/**
	 *查询所有信息
	 * @param htype
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Htype> queryHtypes(Htype htype) throws Exception {
		return this.iHtypeDao.queryHtypes(htype);
	}

}
