package cn.hero.firc.service.impl;

import java.util.List;

import cn.hero.firc.dao.IHuserDao;
import cn.hero.firc.dao.impl.HuserDao;
import cn.hero.firc.entity.Huser;
import cn.hero.firc.service.IHuserService;
import cn.hero.firc.util.Page;

/**
 * @description:用户service
 * @author:章冬蕾
 * @date:2018-12-27上午9:41:46
 * @version JDK1.7
 */
public class HuserService implements IHuserService {

	IHuserDao iHuserDao = new HuserDao();

	/**
	 * 查询所有用户数据
	 */
	@Override
	public Page<Huser> queryHusersPage(Huser huser, Page<Huser> page)
			throws Exception {

		return this.iHuserDao.queryHusersPage(huser, page);
	}


	/**
	 * 修改用户信息
	 * @param huser
	 * @throws Exception
	 */
	@Override
	public void updateHusers(Huser huser) throws Exception {
		this.iHuserDao.updateHusers(huser);
	}


	/**
	 * 查询单个
	 * @param huser
	 * @throws Exception
	 */
	@Override
	public Huser getHusersid(Integer id) throws Exception {
		return this.iHuserDao.getHusersid(id);
	}

	

	/**
	 * 添加用户信息
	 * @param huser
	 * @throws Exception
	 */
	@Override
	public void addHuser(Huser huser) throws Exception {
		this.iHuserDao.addHuser(huser);

	}


	/**
	 * 删除用户信息
	 * @param huser
	 * @throws Exception
	 */
	@Override
	public void deleteHuser(Integer id) throws Exception {
		this.iHuserDao.deleteHuser(id);
		
	}


	/**
	 * @name 名字
	 * @impact 作用 
	 */
	@Override
	public Huser loginUser(String number, String password) throws Exception {
		// TODO Auto-generated method stub
		Huser user=new Huser();
        user.setNumber(number);
        user.setPassword(password);
        Huser huser=this.iHuserDao.loginHuser(user);
        if(huser.getId()!=null){
        	return huser;
        }
		return null;
	}

	/**
	 *查询所有信息
	 * @param htype
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Huser> queryHusers(Huser huser) throws Exception {
		return this.iHuserDao.queryHusers(huser);
	}


	/**
	 * @name 名字
	 * @impact 作用 
	 */
	@Override
	public Huser queryHuserByNumber(String number) throws Exception {
		// TODO Auto-generated method stub
		Huser user=new Huser();
		user.setNumber(number);
		if(this.iHuserDao.queryHusers(user).isEmpty()){
			return null;
		}
		return this.iHuserDao.queryHusers(user).get(0);
	}


	/**
	 * @name 名字
	 * @impact 作用 
	 */
	@Override
	public void rechargeOn(Huser user) throws Exception {
		// TODO Auto-generated method stub
		this.iHuserDao.rechargeOn(user);
	}
}
