package cn.hero.firc.service;

import java.util.List;

import cn.hero.firc.entity.Equip;
import cn.hero.firc.util.Page;

/**
 * @description:装备service接口
 * @author:章冬蕾
 * @date:2018-12-21上午11:01:25
 * @version JDK1.7
 */
public interface IEquipService {

	/**
	 * 分页查询所有装备
	 * 
	 * @param equip
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public Page<Equip> queryEquipPage(Equip equip, Page<Equip> page)
			throws Exception;

	/**
	 * 查询所有装备
	 * 
	 * @param equip
	 * @return
	 * @throws Exception
	 */
	public List<Equip> queryEquipsPage(Equip equip) throws Exception;
	
	/**
	 * 修改装备信息
	 * 
	 * @param
	 * @throws Exception
	 */
	public void updateEquips(Equip equip) throws Exception;

	/**
	 * 查询单个
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Equip getEquipsid(Integer id) throws Exception;

	/**
	 * 添加装备
	 * 
	 * @param equip
	 * @throws Exception
	 */
	public void addEquip(Equip equip) throws Exception;

	/**
	 * 删除装备
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteEquip(Integer id) throws Exception;
	
}
