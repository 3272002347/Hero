package cn.hero.firc.service;

import java.util.List;

import cn.hero.firc.entity.Skin;
import cn.hero.firc.util.Page;

/**
 * @description:皮肤service接口
 * @author:章冬蕾
 * @date:2018-12-21上午9:41:10
 * @version JDK1.7
 */
public interface ISkinService {
	
	/**
	 * 查询所有皮肤
	 * 
	 * @param skin
	 * @return
	 * @throws Exception
	 */
	public List<Skin> querySkinList(Skin skin) throws Exception;
	
	/**
	 * 分页查询所有皮肤
	 * @param skin
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public Page<Skin>querySkinPage(Skin skin,Page<Skin> page) throws Exception;
	
	/**
	 * 修改皮肤
	 * @param
	 * @throws Exception
	 */
	public void updateSkins(Skin skin) throws Exception;

	/**
	 * 查询单个 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Skin getSkinsid(Integer id) throws Exception;

	/**
	 * 添加皮肤
	 * @param huser
	 * @throws Exception
	 */
	public void addSkin(Skin skin) throws Exception;

	/**
	 * 删除皮肤
	 * @param id
	 * @throws Exception
	 */
	public void DeleteSkin(Integer id) throws Exception;
	
	/**
	 * 根据英雄查询单个
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<Skin> getSkinHeroId(Integer id) throws Exception;
	
	
	/**
	 * 根据英雄查询单个(大图标)
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<Skin> getSkinSrcId(Integer id) throws Exception;
	public Skin buySkin(Integer id)throws Exception;
}
