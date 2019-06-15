package cn.hero.firc.service.impl;

import java.util.List;

import cn.hero.firc.dao.ISrcDao;
import cn.hero.firc.dao.impl.SrcDao;
import cn.hero.firc.entity.Src;
import cn.hero.firc.service.ISrcService;
import cn.hero.firc.util.Page;

/**
 * @description:显示图标路径service
 * @author:章冬蕾
 * @date:2018-12-27上午9:52:20
 * @version JDK1.7
 */
public class SrcService implements ISrcService {

	ISrcDao iSrcDao = new SrcDao();

	/** 
	 * 查询所有图标路径
	 */
	@Override
	public Page<Src> querySrcPage(Src src, Page<Src> page) throws Exception {

		return this.iSrcDao.querySrcPage(src, page);
	}

	/**
	 * 修改图标路径
	 * @param
	 * @throws Exception
	 */
	@Override
	public void updateSrcs(Src src) throws Exception {
		this.iSrcDao.updateSrcs(src);
		
	}

	
	/**
	 * 查询单个 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public Src getSrcid(Integer id) throws Exception {
		
		return this.getSrcid(id);
	}

	
	/**
	 * 添加图标路径
	 * @param huser
	 * @throws Exception
	 */
	@Override
	public void addSrc(Src src) throws Exception {
		this.iSrcDao.addSrc(src);
		
	}

	
	/**
	 * 删除图标路径
	 * @param id
	 * @throws Exception
	 */
	@Override
	public void DeleteSrc(Integer id) throws Exception {
		  this.iSrcDao.DeleteSrc(id);
		
	}

	/**
	 * 查询所有图标路径
	 * @param src
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Src> querySrc(Src src) throws Exception {

		return this.iSrcDao.querySrc(src);
	}


	
	

}
