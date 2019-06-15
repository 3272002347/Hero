<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<link rel="stylesheet" type="text/css"
	href="<%=path%>/statics/css/heroCss.css">
<title>My JSP 'HeroManagement.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">



<script type="text/javascript" src="<%=path%>/statics/js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="<%=path%>/statics/js/HeroMentJs-ly.js"></script>
</head>

<body>
	<div class="topDiv">
	<span>欢迎你，${admin }</span>
			<img src="statics/images/ment.jpg" />
		</div>
		<div class="mentDiv-ly">
			<div class="heroDiv-ly">
				<div class="imgSpan-ly">
					<strong>英雄管理</strong>
				</div>
				<div id="h2Title-ly">
					<h2>LOL英雄管理</h2>
					<span>LOL官网视频、赛事、英雄、攻略、新闻搜索内容标签统一管理后台</span>
				</div>
					<a href="backend/heroMent-ly.jsp">立即查看>></a>
			</div>
			<div class="heroDiv-ly">
				<div class="imgSpan-ly">
					<strong>用户管理</strong>
				</div>
				<div id="h2Title-ly">
					<h2>LOL用户管理</h2>
					<span>LOL所有用户统一管理后台</span>
				</div>
					<a href="backend/userMent-ly.jsp">立即查看>></a>
			</div>
			<div class="heroDiv-ly">
				<div class="imgSpan-ly">
					<strong>装备管理</strong>
				</div>
				<div id="h2Title-ly">
					<h2>LOL装备管理</h2>
					<span>LOL所有英雄装备统一管理后台</span>
				</div>
					<a href="backend/equipMent-ly.jsp">立即查看>></a>
			</div>
			
		</div>
</body>
</html>
