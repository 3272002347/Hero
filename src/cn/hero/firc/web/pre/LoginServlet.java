
package cn.hero.firc.web.pre;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.hero.firc.entity.Huser;
import cn.hero.firc.entity.Skin;
import cn.hero.firc.service.impl.HeroService;
import cn.hero.firc.service.impl.HuserService;

/**
 * @name 高志曦
 * @impact 作用
 * @date Dec 30, 20182:07:35 PM
 * @version JDK1.7 
 */
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String number=request.getParameter("number");
		String password=request.getParameter("password");
		Huser user=null;
		
            try {
            	
				if(new HuserService().loginUser(number,password )!=null){
					user=new HuserService().loginUser(number,password );
					String data=JSON.toJSONString(user);
					 ServletContext application=this.getServletContext(); 
					 if(application.getAttribute("thingsown")==null){
						 HashMap<Integer, HashMap<Integer,List<Object>>> thingsown=new HashMap<Integer, HashMap<Integer,List<Object>>>();
						 HashMap<Integer, List<Object>> skinsMap=new HashMap<Integer, List<Object>>();
						 skinsMap.put(1, null);
						 skinsMap.put(2, null);
						 thingsown.put(user.getId(),skinsMap);
						 application.setAttribute("thingsown", thingsown);
					 }
					 
					request.getSession().setAttribute("user", user);
					out.write(data);
					
				}else {
					out.write("{\"reg\":\"账号或者密码错误,请重试!\"}");
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
