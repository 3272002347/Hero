package cn.hero.firc.dao;

import java.util.List;
import cn.hero.firc.entity.Udan;
import cn.hero.firc.util.Page;

/**
 * @description:查看所有段位
 * @author:章冬蕾
 * @date:2018-12-24下午2:59:58
 * @version JDK1.7
 */
public interface IUdanDao {

	/**
	 * 分页查询所有段位
	 * @param udan
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public Page<Udan> queryUdanPage(Udan udan, Page<Udan> page)
			throws Exception;
	
	/**
	 * 修改段位
	 * @param
	 * @throws Exception
	 */
	public void updateUdans(Udan udan) throws Exception;

	/**
	 * 查询单个 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Udan getSrctypeid(Integer id) throws Exception;

	/**
	 * 添加段位
	 * @param huser
	 * @throws Exception
	 */
	public void addUdan(Udan udan) throws Exception;

	/**
	 * 删除段位
	 * @param id
	 * @throws Exception
	 */
	public void DeleteUdan(Integer id) throws Exception;

	/**
	 * 查询所有段位
	 * @param udan
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Udan> queryUdans(Udan udan) throws Exception;
}
