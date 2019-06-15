package cn.hero.firc.entity;

/**
 * @description:英雄类别
 * @author:章冬蕾
 * @date:2018-12-20下午7:11:12
 * @version JDK1.7
 */
public class Htype {
	
	private Integer id;
	private String htypename;//英雄类别名称
	private String  postionname;//强势位置
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHtypename() {
		return htypename;
	}
	public void setHtypename(String htypename) {
		this.htypename = htypename;
	}
	public String getPostionname() {
		return postionname;
	}
	public void setPostionname(String postionname) {
		this.postionname = postionname;
	}


}
