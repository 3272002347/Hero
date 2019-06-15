package cn.hero.firc.entity;

/**
 * @description:皮肤
 * @author:章冬蕾
 * @date:2018-12-20下午7:22:08
 * @version JDK1.7
 */
public class Skin {

	private Integer id;
	private String skinname;// 皮肤名称
	private String imgsrc;// 地址
	private Integer skinsrcid;// 地址对应id
	private Integer price;// 价格
	private Integer heroid;// 对应的英雄

	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSkinname() {
		return skinname;
	}

	public void setSkinname(String skinname) {
		this.skinname = skinname;
	}

	public Integer getSkinsrcid() {
		return skinsrcid;
	}

	public void setSkinsrcid(Integer skinsrcid) {
		this.skinsrcid = skinsrcid;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getHeroid() {
		return heroid;
	}

	public void setHeroid(Integer heroid) {
		this.heroid = heroid;
	}

}
