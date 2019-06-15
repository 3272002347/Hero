package cn.hero.firc.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:英雄
 * @author:章冬蕾
 * @date:2018-12-20下午7:04:54
 * @version JDK1.7
 */
public class Hero {

	private Integer id;
	private String heroname; // 英雄名称
	private String herostory; // 英雄背景故事
	private Integer price;// 价格
	private String viedoSrc;// 视频地址
	private Integer herotypeid;// 英雄类别
	private String imgsrc;// 英雄图标
	private String htypename;// 英雄类别名称
	private String postionname;// 强势位置
	private List<Src> srcList = new ArrayList<Src>();
	private Htype htype;
	private List<Skill> skillList = new ArrayList<Skill>();

	public Integer getId() {
		return id;
	}

	public String getHeroname() {
		return heroname;
	}

	public String getHerostory() {
		return herostory;
	}

	public Integer getPrice() {
		return price;
	}

	public String getViedoSrc() {
		return viedoSrc;
	}

	public Integer getHerotypeid() {
		return herotypeid;
	}

	public String getImgsrc() {
		return imgsrc;
	}

	public String getHtypename() {
		return htypename;
	}

	public String getPostionname() {
		return postionname;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setHeroname(String heroname) {
		this.heroname = heroname;
	}

	public void setHerostory(String herostory) {
		this.herostory = herostory;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setViedoSrc(String viedoSrc) {
		this.viedoSrc = viedoSrc;
	}

	public void setHerotypeid(Integer herotypeid) {
		this.herotypeid = herotypeid;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

	public void setHtypename(String htypename) {
		this.htypename = htypename;
	}

	public void setPostionname(String postionname) {
		this.postionname = postionname;
	}

	public Htype getHtype() {
		return htype;
	}

	public void setHtype(Htype htype) {
		this.htype = htype;
	}

	public List<Skill> getSkillList() {
		return skillList;
	}

	public void setSkillList(List<Skill> skillList) {
		this.skillList = skillList;
	}

	public List<Src> getSrcList() {
		return srcList;
	}

	public void setSrcList(List<Src> srcList) {
		this.srcList = srcList;
	}

}
