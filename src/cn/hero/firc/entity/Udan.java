package cn.hero.firc.entity;

/**
 * @description:用户段位
 * @author:章冬蕾
 * @date:2018-12-20下午7:30:44
 * @version JDK1.7
 */
public class Udan {

	private Integer id;
	private String danname;// 段位名称
	private Integer dansrcid;// 段位图片

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDanname() {
		return danname;
	}

	public void setDanname(String danname) {
		this.danname = danname;
	}

	public Integer getDansrcid() {
		return dansrcid;
	}

	public void setDansrcid(Integer dansrcid) {
		this.dansrcid = dansrcid;
	}

}
