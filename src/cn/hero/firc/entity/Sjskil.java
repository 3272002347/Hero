package cn.hero.firc.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:召唤师技能
 * @author:章冬蕾
 * @date:2018-12-20下午7:17:07
 * @version JDK1.7
 */
public class Sjskil {

	private Integer id;
	private String sjskill;// 召唤师技能名称
	private String sjrole;// 技能作用
	private String imgsrc;// 召唤师技能图标
	private String sfjn;// 召唤师技能展示
	private Src src;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSjskill() {
		return sjskill;
	}

	public void setSjskill(String sjskill) {
		this.sjskill = sjskill;
	}

	public String getSjrole() {
		return sjrole;
	}

	public void setSjrole(String sjrole) {
		this.sjrole = sjrole;
	}

	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

	public String getSfjn() {
		return sfjn;
	}

	public void setSfjn(String sfjn) {
		this.sfjn = sfjn;
	}

	public Src getSrc() {
		return src;
	}

	public void setSrc(Src src) {
		this.src = src;
	}

}
