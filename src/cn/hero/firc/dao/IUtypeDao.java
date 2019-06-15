package cn.hero.firc.dao;

import java.util.List;
import cn.hero.firc.entity.Utype;
import cn.hero.firc.util.Page;

/**
 * @description:用户类别接口
 * @author:章冬蕾
 * @date:2018-12-27上午10:08:57
 * @version JDK1.7
 */
public interface IUtypeDao {
	
	/**
	 * 分页查询所有用户类别
	 * @param utype
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public Page<Utype> queryUtypePage(Utype utype, Page<Utype> page)
			throws Exception;
	/**
	 * 修改用户类别
	 * @param
	 * @throws Exception
	 */
	public void updateUtypes(Utype utype) throws Exception;

	/**
	 * 查询单个 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Utype getUtypeid(Integer id) throws Exception;

	/**
	 * 添加用户类别
	 * @param type
	 * @throws Exception
	 */
	public void addUtype(Utype utype) throws Exception;

	/**
	 * 删除用户类别
	 * @param id
	 * @throws Exception
	 */
	public void DeleteUtype(Integer id) throws Exception;
	
	/**
	 * 查询所有用户类别
	 * @param utype
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Utype> queryUtypes(Utype utype) throws Exception;

}
