package cn.hero.firc.dao;

import java.util.List;

import cn.hero.firc.entity.Huser;
import cn.hero.firc.util.Page;


/**
 * @description:用户数据接口
 * @author:章冬蕾
 * @date:2018-12-27上午9:19:59
 * @version JDK1.7
 */
public interface IHuserDao {
	
	/**
	 * 查询所有信息（分页）
	 * @param huser
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public Page<Huser> queryHusersPage(Huser huser, Page<Huser> page)
			throws Exception;
	/**
	 * 
	 * @name 名字
	 * @impact 登录 
	 * @parameters 参数
	 */
	public Huser loginHuser(Huser huser)throws Exception;
	/**
	 * 
	 * @name 名字
	 * @impact 根据条件查询所有
	 * @parameters 参数
	 */
	public List<Huser> queryHusers(Huser huser)throws Exception;
	/**
	 * 修改用户信息
	 * @param 
	 * @throws Exception
	 */
	public void updateHusers(Huser huser) throws Exception;
	
	/**
	 * 查询单个
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Huser getHusersid(Integer id) throws Exception;
	
	/**
	 * 添加用户信息
	 * @param huser
	 * @throws Exception
	 */
	public void addHuser(Huser huser) throws Exception;
	public void registerUser(Huser user)throws Exception;
	/**
	 * 删除用户信息
	 * @param id
	 * @throws Exception
	 */
	public void deleteHuser(Integer id) throws Exception;
	
    public void rechargeOn(Huser user)throws Exception;
}
