package cn.hero.firc.web.pre;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hero.firc.entity.Huser;
import cn.hero.firc.service.impl.HuserService;

/**
 * @name 高志曦
 * @impact 作用
 * @date Jan 17, 20199:11:39 PM
 * @version JDK1.7 
 */
public class PayForThingServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
            Huser user=(Huser) request.getSession().getAttribute("user");
            String price=request.getParameter("price");
            user.setAva((user.getAva()-Integer.valueOf(price)));
            HuserService service=new HuserService();
            try {
				service.updateHusers(user);
				out.write("1");
				out.flush();
				out.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				out.write("2");
				out.flush();
				out.close();
				e.printStackTrace();
			}
            
	}

}
