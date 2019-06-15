package cn.hero.firc.web.pre;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

/**
 * @name 高志曦
 * @impact 作用
 * @date Jan 10, 20198:47:50 AM
 * @version JDK1.7 
 */
public class GetUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
             PrintWriter out=response.getWriter();
	         String json=JSON.toJSONString(request.getSession().getAttribute("user"));
	         out.write(json);
	         out.flush();
	         out.close();
	}

}
