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
 * @date Jan 14, 201910:16:59 AM
 * @version JDK1.7 
 */
public class NumberCheckServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            String number=request.getParameter("number");
            PrintWriter out=response.getWriter();
            try {
				Huser user=new HuserService().queryHuserByNumber(number);
				if(user==null){
					out.write("1");
				}else {
					out.write("OK");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				out.flush();
				out.close();
			}
            
            
	}

}
