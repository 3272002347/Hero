package cn.hero.firc.service;

import java.util.List;

import cn.hero.firc.entity.Src;
import cn.hero.firc.util.Page;


/**
 * @description:显示图标路径service接口
 * @author:章冬蕾
 * @date:2018-12-27上午9:51:49
 * @version JDK1.7
 */
public interface ISrcService {
	
	
	/**
	 * 分页查询所有图标路径
	 * @param src
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public Page<Src> querySrcPage(Src src, Page<Src> page)
			throws Exception;

	/**
	 * 修改图标路径
	 * @param
	 * @throws Exception
	 */
	public void updateSrcs(Src src) throws Exception;

	/**
	 * 查询单个 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Src getSrcid(Integer id) throws Exception;

	/**
	 * 添加图标路径
	 * @param huser
	 * @throws Exception
	 */
	public void addSrc(Src src) throws Exception;

	/**
	 * 删除图标路径
	 * @param id
	 * @throws Exception
	 */
	public void DeleteSrc(Integer id) throws Exception;
	

	/**
	 * 查询所有图标路径
	 * @param src
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Src> querySrc(Src src) throws Exception;

}
