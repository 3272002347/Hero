<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'info-heroType.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <!-- 英雄列表 -->
				<div class="clearfix info-showbox">
					<ul id="seleteChecklist" class="selete-checklist">
						<li class="selete-item current"><span class="ms-radio"><i
								class="i"></i> </span><label data-id="">所有英雄</label></li>
						<li class="selete-item"><span class="ms-radio"><i
								class="i"></i> </span><label data-id="Fighter">战士</label></li>
						<li class="selete-item"><span class="ms-radio"><i
								class="i"></i> </span><label data-id="Mage">法师</label></li>
						<li class="selete-item"><span class="ms-radio"><i
								class="i"></i> </span><label data-id="Assassin">刺客</label></li>
						<li class="selete-item"><span class="ms-radio"><i
								class="i"></i> </span><label data-id="Tank">坦克</label></li>
						<li class="selete-item"><span class="ms-radio"><i
								class="i"></i> </span><label data-id="Marksman">射手</label></li>
						<li class="selete-item"><span class="ms-radio"><i
								class="i"></i> </span><label data-id="Support">辅助</label></li>
					</ul>
					<!-- 		<div class="searchbox info-searchbox">
						<input id="jSearchHeroInput" class="input-search" type="text"
							value="请输入您要搜索的英雄名"
							onfocus="if(this.value=='请输入您要搜索的英雄名'){this.value=''};this.style.color='black';"
							onblur="if(this.value==''||this.value=='请输入您要搜索的英雄名')
	{this.value='请输入您要搜索的英雄名';this.style.color='#999999';}">
						<span class="publicspr tnd btn-search">搜索</span>
					</div> -->

					<div class="searchbox info-searchbox">
						<input id="jSearchHeroInput" class="input-search" type="text"
							value="请输入您要搜索的英雄名"> <span class="publicspr tnd btn-search">搜索</span>
        </div>
					
					<!-- 从数据库查找数据 -->
					<ul id="jSearchHeroDiv" class="imgtextlist">
						<c:forEach items="${herotypeidList}" var="herotypeidList" varStatus="status">
							<li><a href="HeroByServlet?id=${herotypeidList.id}"
								title="${herotypeidList.heroname}"> <img src="${herotypeidList.imgsrc}"
									alt="${herotypeidList.heroname}">
									<p>${herotypeidList.heroname}</p> <span class="sbg"><i
										class="commspr commico-search"></i> </span> </a>
							</li>
						</c:forEach>
					</ul>
				</div>
	
  </body>
</html>
