package cn.hero.firc.web.pre;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.hero.firc.entity.Sjskil;
import cn.hero.firc.service.ISjskilService;
import cn.hero.firc.service.impl.SjskilService;

/**
 * @deprecated:查询全部召唤师技能数据
 * @author 洪骥1
 * @date:2018-12-27
 * @since JDK1.7
 */
public class SjskilListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 获取所有召唤师技能信息
			ISjskilService iSjskilService = new SjskilService();
			List<Sjskil> sjskilList = iSjskilService.querySjskil(null);

			// 把召唤师技信息返回页面
			request.setAttribute("sjskilList", sjskilList);
			// 转发，返回页面
			request.getRequestDispatcher("pre/info-spell.jsp").forward(request,
					response);
		} catch (Exception e) {
			e.printStackTrace();
		}	 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
