package cn.hero.firc.service.impl;

import java.util.List;

import cn.hero.firc.dao.ISrcTypeDao;
import cn.hero.firc.dao.impl.SrcTypeDao;
import cn.hero.firc.entity.Srctype;
import cn.hero.firc.service.ISrcTypeService;
import cn.hero.firc.util.Page;

/**
 * @description:图标类别service
 * @author:章冬蕾
 * @date:2018-12-27上午10:06:02
 * @version JDK1.7
 */
public class SrcTypeService implements ISrcTypeService {

	ISrcTypeDao iSrcTypeDao = new SrcTypeDao();

	/**
	 * 查询所有图标类别
	 */
	@Override
	public Page<Srctype> querySrctypePage(Srctype srctype, Page<Srctype> page)
			throws Exception {
		
		return this.iSrcTypeDao.querySrctypePage(srctype, page);
	}

	
	/**
	 * 修改图标类别
	 * @param
	 * @throws Exception
	 */
	@Override
	public void updateSrctypes(Srctype srctype) throws Exception {
		this.iSrcTypeDao.updateSrctypes(srctype);
		
	}

	/**
	 * 查询单个 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public Srctype getSrctypeid(Integer id) throws Exception {
		return this.iSrcTypeDao.getSrctypeid(id);
	}

	
	/**
	 * 添加图标类别
	 * @param huser
	 * @throws Exception
	 */
	@Override
	public void addSrctype(Srctype sctype) throws Exception {
		this.iSrcTypeDao.addSrctype(sctype);
		
	}

	/**
	 * 删除图标类别
	 * @param id
	 * @throws Exception
	 */
	@Override
	public void DeleteSrctype(Integer id) throws Exception {
		this.iSrcTypeDao.DeleteSrctype(id);
		
	}

	/**
	 * 查询所有图标类别
	 * @param srctype
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Srctype> querySrctype(Srctype srctype) throws Exception {
	
		return this.iSrcTypeDao.querySrctype(srctype);
	}

}
