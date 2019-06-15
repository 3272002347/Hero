package cn.hero.firc.service;

import java.util.List;

import cn.hero.firc.entity.Srctype;
import cn.hero.firc.util.Page;

/**
 * @description:图标类别service接口
 * @author:章冬蕾
 * @date:2018-12-27上午10:05:27
 * @version JDK1.7
 */
public interface ISrcTypeService {
	
	/**
	 * 分页查询所有图标类别
	 * @param srctype
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public Page<Srctype> querySrctypePage(Srctype srctype, Page<Srctype> page)
			throws Exception;

	/**
	 * 修改图标类别
	 * @param
	 * @throws Exception
	 */
	public void updateSrctypes(Srctype srctype) throws Exception;

	/**
	 * 查询单个 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Srctype getSrctypeid(Integer id) throws Exception;

	/**
	 * 添加图标类别
	 * @param huser
	 * @throws Exception
	 */
	public void addSrctype(Srctype sctype) throws Exception;

	/**
	 * 删除图标类别
	 * @param id
	 * @throws Exception
	 */
	public void DeleteSrctype(Integer id) throws Exception;

	/**
	 * 查询所有图标类别
	 * @param srctype
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Srctype> querySrctype(Srctype srctype) throws Exception;
}
