package cn.hero.firc.service.impl;

import java.util.List;

import cn.hero.firc.dao.IUdanDao;
import cn.hero.firc.dao.impl.UdanDao;
import cn.hero.firc.entity.Udan;
import cn.hero.firc.service.IUdanService;
import cn.hero.firc.util.Page;

/**
 * @description:用户段位service
 * @author:章冬蕾
 * @date:2018-12-25下午3:06:39
 * @version JDK1.7
 */
public class UdanService implements IUdanService {

	IUdanDao iUdanDao = new UdanDao();

	

	/**
	 * 分页查询所有装备
	 * @param udan
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@Override
	public Page<Udan> queryEquipPage(Udan udan, Page<Udan> page)
			throws Exception {
		return this.iUdanDao.queryUdanPage(udan, page);
	}


	/**
	 * 修改段位
	 * @param
	 * @throws Exception
	 */
	@Override
	public void updateUdans(Udan udan) throws Exception {
		this.iUdanDao.updateUdans(udan);
		
	}

	/**
	 * 查询单个 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public Udan getSrctypeid(Integer id) throws Exception {
		return this.iUdanDao.getSrctypeid(id);
	}
	/**
	 * 添加段位
	 * @param huser
	 * @throws Exception
	 */
	@Override
	public void addUdan(Udan udan) throws Exception {
		this.iUdanDao.addUdan(udan);
	}

	
	/**
	 * 删除段位
	 * @param id
	 * @throws Exception
	 */
	@Override
	public void DeleteUdan(Integer id) throws Exception {
		this.iUdanDao.DeleteUdan(id);
	}

	/**
	 * 查询所有段位
	 * @param udan
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Udan> queryUdans(Udan udan) throws Exception {
		return this.iUdanDao.queryUdans(udan);
	}

	

}
