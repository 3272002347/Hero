<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<link type="text/css" rel="stylesheet" href="statics/css/HeroList.css">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<title>My JSP 'info-heros.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style type="text/css">
.comm-head {
	background: rgba(0, 0, 0, 0.6) !important;
}
</style>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript"
	src="<%=path%>/statics/js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/common.js"></script>


<script>
	$(function() {
		// 	鼠标点入清空
		$("#jSearchHeroInput").focus(function() {
			if (this.value == "请输入您要搜索的英雄名") {
				this.value = "";
			}
			;
			this.style.color = "black";
		});
		// 	鼠标点出加上
		$("#jSearchHeroInput").blur(function() {
			if (this.value == "" || this.value == "请输入您要搜索的英雄名") {
				this.value = "请输入您要搜索的英雄名";
				this.style.color = "#999999";
			}
		});
		//查询
		$("#jSearchHeroInput").change(function() {
			var HeroName = $(this).val();
			location.href="<%=path%>	/HeroListServlet?HeroName=" + HeroName;
		});
	});
</script>
</head>

<body>
	<%@include file="/common/header.jsp"%>
	<div class="comm-topact" style="display:block;">
		<img class="topact-small-img"
			src="<%=path%>/statics/images/info-back.jpg">
	</div>
	<div class="wraper">
		<div class="layout mainer">
			<!--路径导航-->
			<div class="website-path">
				<i class="icon-home"></i> <a href="">英雄联盟首页</a> <i
					class="icon-arrow-2"></i> <a href="<%=path%>/HeroListServlet">游戏资料</a>
				<i class="icon-arrow-2"></i> <a class="here">英雄</a>
			</div>
			<div class="colbox">
				<div id="pageTAB" class="pagetab">
					<ul class="pagetab-list pagetab-list1">
						<li class="p-list1"><a class="pagetab-list-lnk"
							href="<%=path%>/HeroListServlet">英雄</a>
						</li>
						<li class="p-list2"><a class="pagetab-list-lnk"
							href="<%=path%>/EquipListServlet">物品</a></li>
						<li class="p-list3"><a class="pagetab-list-lnk"
							href="<%=path%>/SjskilListServlet">召唤师技能</a></li>
					</ul>
				</div>
				<!-- 英雄列表 -->
				<div class="clearfix info-showbox">
					<!-- 					<ul id="seleteChecklist" class="selete-checklist">
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
								
					</ul> -->
					<div class="searchbox info-searchbox">

						<input id="jSearchHeroInput" class="input-search" type="text"
							value="请输入您要搜索的英雄名"> <span
							class="publicspr tnd btn-search">搜索</span>
					</div>
					<!-- 从数据库查找数据 -->
					<ul id="jSearchHeroDiv" class="imgtextlist">
						<c:forEach items="${heroList}" var="hero" varStatus="status">
							<c:forEach items="${hero.srcList}" var="herois" varStatus="status">
								<li><a href="HeroDefailServlet?id=${hero.id}"
									title="${hero.heroname}"> <img src="${herois.imgsrc}"
										alt="${hero.heroname}">
										<p>${hero.heroname}</p> <span class="sbg"><i
											class="commspr commico-search"></i> </span> </a></li>
							</c:forEach>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/common/footer.jsp"%>
</body>
</html>
