package cn.hero.firc.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:装备
 * @author:章冬蕾
 * @date:2018-12-20下午6:53:06
 * @version JDK1.7
 */
public class Equip {

	private Integer id;
	private String equipment;// 装备介绍
	private String etypename;// 装备名称
	private Integer esrcid; // 装备图标
	private String imgsrc; // 图标
	private Src src;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public String getEtypename() {
		return etypename;
	}

	public void setEtypename(String etypename) {
		this.etypename = etypename;
	}

	public Integer getEsrcid() {
		return esrcid;
	}

	public void setEsrcid(Integer esrcid) {
		this.esrcid = esrcid;
	}

	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

	public Src getSrc() {
		return src;
	}

	public void setSrc(Src src) {
		this.src = src;
	}

}
