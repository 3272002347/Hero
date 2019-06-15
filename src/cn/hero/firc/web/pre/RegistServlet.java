package cn.hero.firc.web.pre;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hero.firc.entity.Huser;

/**
 * @name 高志曦
 * @impact 作用
 * @date Jan 16, 201911:40:53 AM
 * @version JDK1.7 
 */
public class RegistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            Huser user=new Huser();
            String filename=request.getParameter("file");
            user.setUsername(request.getParameter("username"));
            user.setNumber(request.getParameter("number"));
            user.setPassword(request.getParameter("password"));
            //user.setUsersrc();
            filename=new String(filename.getBytes("iso-8859-1"),"utf-8");
            String path=super.getServletContext().getRealPath("/myUpload");
            response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(filename,"utf-8"));
            FileInputStream in=new FileInputStream(path+"/"+filename);
            OutputStream os=response.getOutputStream();
            byte[] bytes=new byte[1024];
            int temp=0;
            while ((temp=in.read(bytes))>0) {
				os.write(bytes);
			}
            in.close();
            os.close();
           
	}

}
