package cn.hero.firc.service.impl;

import java.util.List;

import cn.hero.firc.dao.IUtypeDao;
import cn.hero.firc.dao.impl.UtypeDao;
import cn.hero.firc.entity.Utype;
import cn.hero.firc.service.IUtypeService;
import cn.hero.firc.util.Page;

/**
 * @description:用户类别service
 * @author:章冬蕾
 * @date:2018-12-27上午10:14:40
 * @version JDK1.7
 */
public class UtypeService implements IUtypeService {
	
	IUtypeDao iUtypeDao=new UtypeDao();

	/** 
	 * 查询所有用户类别
	 */
	@Override
	public Page<Utype> queryUtypePage(Utype utype, Page<Utype> page)
			throws Exception {
	
		return this.iUtypeDao.queryUtypePage(utype, page);
	}

	/**
	 * 修改用户类别
	 * @param
	 * @throws Exception
	 */
	@Override
	public void updateUtypes(Utype utype) throws Exception {
		this.iUtypeDao.updateUtypes(utype);
	}
	
	/**
	 * 查询单个 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public Utype getUtypeid(Integer id) throws Exception {
	
		return this.iUtypeDao.getUtypeid(id);
	}

	
	/**
	 * 添加用户类别
	 * @param type
	 * @throws Exception
	 */
	@Override
	public void addUtype(Utype utype) throws Exception {
	         this.iUtypeDao.addUtype(utype);
	}

	/**
	 * 删除用户类别
	 * @param id
	 * @throws Exception
	 */
	@Override
	public void DeleteUtype(Integer id) throws Exception {
		this.iUtypeDao.DeleteUtype(id);
		
	}
	/**
	 * 查询所有用户类别
	 * @param utype
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Utype> queryUtypes(Utype utype) throws Exception {
		return this.iUtypeDao.queryUtypes(utype);
	}

}
