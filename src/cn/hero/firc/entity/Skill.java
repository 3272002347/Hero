package cn.hero.firc.entity;

/**
 * @description:英雄技能
 * @author:章冬蕾
 * @date:2018-12-20下午7:19:33
 * @version JDK1.7
 */
public class Skill {

	private Integer id;
	private String skillname;// 技能名称
	private String addition;// 伤害加成
	private Integer skillsrcid;// 技能图标id
	private Integer heroid; // 英雄id
	private String imgsrc;// 技能图标路径
	private Hero hero;

	public Integer getHeroid() {
		return heroid;
	}

	public void setHeroid(Integer heroid) {
		this.heroid = heroid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSkillname() {
		return skillname;
	}

	public void setSkillname(String skillname) {
		this.skillname = skillname;
	}

	public String getAddition() {
		return addition;
	}

	public void setAddition(String addition) {
		this.addition = addition;
	}

	public Integer getSkillsrcid() {
		return skillsrcid;
	}

	public void setSkillsrcid(Integer skillsrcid) {
		this.skillsrcid = skillsrcid;
	}

	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}


}
