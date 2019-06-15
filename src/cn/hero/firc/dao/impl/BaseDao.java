package cn.hero.firc.dao.impl;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * @description: JDBC操作数据库通用父类
 * @author: Administrator
 * @date: 2018-8-21
 * @version JDK1.7
 */
public class BaseDao {

	protected static Connection connection;
	protected PreparedStatement ps;
	protected ResultSet rs;

	static {
		try {
			//读取数据库配置文件（只读取一次）
			String fileName = "resources/database.properties";
			InputStream inputStream = BaseDao.class.getClassLoader()
					.getResourceAsStream(fileName);
			Properties properties = new Properties();
			properties.load(inputStream);

			//读取配置文件当中的内容
			String drirver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");

			//1、加载数据库驱动
			Class.forName(drirver);

			//2、创建数据库连接
			connection = DriverManager.getConnection(url, user, password);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭数据库连接
	 * @throws Exception
	 */
	public void closeConnection() throws Exception {
		//后打开的先关闭
		if (rs != null) {
			rs.close();
		}

		if (ps != null) {
			ps.close();
		}

		if (connection != null) {
			connection.close();
		}
	}

	/**
	 * 增删改操作
	 * @param sql 要操作的SQL语句
	 * @param params 参数值数组
	 * @throws Exception
	 */
	public void edit(String sql,Object... params) throws Exception {
		this.ps = this.connection.prepareStatement(sql);

		//设置参数值
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
		}

		this.ps.executeUpdate();
	}

	/**
	 * 查询操作
	 * @param sql 要查询的SQL语句
	 * @param params 参数值数组
	 * @return ResultSet
	 * @throws Exception
	 */
	public ResultSet query(String sql, Object... params) throws Exception {
		this.ps = this.connection.prepareStatement(sql);

		//设置参数值
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
		}

		this.rs = this.ps.executeQuery();
		return rs;
	}

}
