<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminLogin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="statics/css/login.css">

  </head>
  
  <body>
   	<div id="img">
   			<span>管理员登录</span>
			<img src="statics/images/ment.jpg" />
		</div>
		<div class="login">
		<span style="color:red">${message}</span>
		<form action="<%=path %>/AdminLoginServlet" method="post" id="formlogin">
			账号：<input type="text" name="number" required="required"><br /> 
			密码：<input type="text" name="password" required="required"><br />
			<input type="submit" class="inputLogin" value="登录">
		</form>
		</div>
  </body>
</html>
