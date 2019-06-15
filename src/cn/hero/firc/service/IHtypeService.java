package cn.hero.firc.service;

import java.util.List;

import cn.hero.firc.entity.Htype;
import cn.hero.firc.util.Page;

/**
 * @description:英雄类别service接口
 * @author:章冬蕾
 * @date:2018-12-27上午8:58:29
 * @version JDK1.7
 */
public interface IHtypeService {

	/**
	 * 查询所有信息（分页）
	 * @param htype
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public Page<Htype> queryHerosPage(Htype htype, Page<Htype> page)
			throws Exception;
	
	/**
	 * 修改英雄类别
	 * @param 
	 * @throws Exception
	 */
	public void updateHtypes(Htype htype) throws Exception;
	
	/**
	 * 查询单个
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Htype getHtypesid(Integer id) throws Exception;
	
	
	/**
	 * 添加英雄类别
	 * @param htype
	 * @throws Exception
	 */
	public void addHtype(Htype htype) throws Exception;
	
	/**
	 * 删除英雄类别
	 * @param id
	 * @throws Exception
	 */
	public void deleteHtype(Integer id) throws Exception;
	
	/**
	 *查询所有信息
	 * @param htype
	 * @return
	 * @throws Exception
	 */
	public List<Htype> queryHtypes(Htype htype) throws Exception;


}
