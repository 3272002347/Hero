package cn.hero.firc.web.pre;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @name 高志曦
 * @impact 作用
 * @date Jan 4, 20199:47:55 AM
 * @version JDK1.7 
 */
public class LoginOutServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            request.getSession().removeAttribute("user");
            PrintWriter out=response.getWriter();
            out.write("注销成功");
            out.flush();
            out.close();
	}

}
