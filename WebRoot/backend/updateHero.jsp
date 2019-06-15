<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateHero.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">




  <body>
    <div class="DisplayDiv">
			<img src="${hero.imgsrc}"/>
			<h2>${hero.heroname}</h2>
		</div>
		<div class="inputDiv">
			<form action="<%=path%>/HeroUpdateServlet?id=${hero.id}" method="post">
			英雄名称：<input  name="heroName" value="${hero.heroname}"/><br /><br />
			英雄价格：<input type="text" name="price" value="${hero.price}"/><br /><br />
			英雄类型：<select name="type" value="${hero.htypename}">
				<option value="1">法师</option>
				<option value="2">战士</option>
				<option value="3">坦克</option>
				<option value="4">辅助</option>
				<option value="5">射手</option>
			</select><br /><br />
			英雄故事：<textarea class="story" name="story" required="required">
			${hero.herostory}
			</textarea><br /><br />
			<input type="submit" value="提交" />
			</form>
		</div>
  </body>
</html>
