package cn.hero.firc.entity;

/**
 * @description:用户
 * @author:章冬蕾
 * @date:2018-12-20下午7:13:56
 * @version JDK1.7
 */
public class Huser {

	private Integer id;
	private String number;// 账号
	private String password;// 密码
	private Integer typeid;// 类别id
	private Integer ava;// 点卷
	private Integer danid;// 段位
    private String username;//用户名
    private String danname;//段位名
    private String dansrc;//段位图片地址
    private String usersrc;//用户头像地址
	public String getUsersrc() {
		return usersrc;
	}

	public void setUsersrc(String usersrc) {
		this.usersrc = usersrc;
	}

	public String getDanname() {
		return danname;
	}

	public void setDanname(String danname) {
		this.danname = danname;
	}

	public String getDansrc() {
		return dansrc;
	}

	public void setDansrc(String dansrc) {
		this.dansrc = dansrc;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public Integer getAva() {
		return ava;
	}

	public void setAva(Integer ava) {
		this.ava = ava;
	}

	public Integer getDanid() {
		return danid;
	}

	public void setDanid(Integer danid) {
		this.danid = danid;
	}

}
