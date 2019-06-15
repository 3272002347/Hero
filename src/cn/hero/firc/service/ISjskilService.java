package cn.hero.firc.service;

import java.util.List;

import cn.hero.firc.entity.Sjskil;
import cn.hero.firc.util.Page;

/**
 * @description:召唤师技能service接口
 * @author:章冬蕾
 * @date:2018-12-25下午5:10:31
 * @version JDK1.7
 */
public interface ISjskilService {
	
	/**
	 * 分页查询所有召唤师技能
	 * @param sjskil
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public Page<Sjskil>querySjskilPage(Sjskil sjskil,Page<Sjskil> page) throws Exception;

	/**
	 * 查询所有召唤师技能
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Sjskil>querySjskil(Sjskil sjskil) throws Exception;
	
	/**
	 * 修改召唤师技能
	 * @param 
	 * @throws Exception
	 */
	public void updateSjskils(Sjskil sjskil) throws Exception;
	
	/**
	 * 查询单个
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Sjskil getSjskilsid(Integer id) throws Exception;
	
	
	/**
	 * 添加召唤师技能
	 * @param huser
	 * @throws Exception
	 */
	public void addSjskil(Sjskil sjskil) throws Exception;
	
	/**
	 * 删除召唤师技能
	 * @param id
	 * @throws Exception
	 */
	public void deleteSjskil(Integer id) throws Exception;
	
	

}
