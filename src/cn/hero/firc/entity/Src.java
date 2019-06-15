package cn.hero.firc.entity;

/**
 * @description:图标
 * @author:章冬蕾
 * @date:2018-12-20下午7:26:12
 * @version JDK1.7
 */
public class Src {

	private Integer id;
	private String imgsrc;// 图标地址
	private Integer imgtypeid;// 图标类别
	private Integer corrId; //映射id
	private String heroName;//英雄

	public Integer getCorrId() {
		return corrId;
	}

	public void setCorrId(Integer corrId) {
		this.corrId = corrId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

	public Integer getImgtypeid() {
		return imgtypeid;
	}

	public void setImgtypeid(Integer imgtypeid) {
		this.imgtypeid = imgtypeid;
	}

	public String getHeroName() {
		return heroName;
	}

	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}

}
