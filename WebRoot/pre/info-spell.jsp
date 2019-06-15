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

<title>My JSP 'info-spell.jsp' starting page</title>

<link type="text/css" rel="stylesheet" href="statics/css/HeroList.css">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript"
	src="<%=path%>/statics/js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script>
	$(function() {
		$("#spellList li").click(function() {
			$("span").addClass("sbg");
			$("span").removeClass("sbg");
			$(this).children("span").addClass("sbg");
			$(this).show().addClass("current");
			$(this).siblings().removeClass("current");
		});
		$("#spellList li:first").trigger("click");

	});
	function showSjskil(id) {
		$("#spellDefail_" + id).show();
		$("#spellDefail_" + id).siblings("div[id*='spellDefail_']").hide();
	}
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
				<i class="icon-arrow-2"></i> <a class="here">召唤师技能</a>
			</div>
			<div class="colbox">
				<div id="pageTAB" class="pagetab">
					<ul class="pagetab-list pagetab-list3">
						<li class="p-list1"><a class="pagetab-list-lnk"
							href="<%=path%>/HeroListServlet">英雄</a></li>
						<li class="p-list2"><a class="pagetab-list-lnk"
							href="<%=path%>/EquipListServlet">物品</a></li>
						<li class="p-list3"><a class="pagetab-list-lnk"
							href="<%=path%>/SjskilListServlet">召唤师技能</a></li>
					</ul>
				</div>

				<!-- 召唤师技能列表 -->
				<div class="clearfix info-showbox">
					<ul id="spellList" class="imgtextlist spell-list">
						<c:forEach items="${sjskilList}" var="sjskil" varStatus="status">
							<li id="SummonerBarrier" class=""
								onclick="showSjskil('${status.index + 1}')"><img
								src="${sjskil.src.imgsrc }" alt="${sjskil.sjskill}">
								<p>${sjskil.sjskill}</p> <span class=""></span>
							</li>
						</c:forEach>
					</ul>
					<c:forEach items="${sjskilList}" var="sjskil" varStatus="status">
						<div id="spellDefail_${status.index + 1}" class="spell-defail">
							<div class="spell-title">
								<img src="${sjskil.imgsrc }" alt="${sjskil.sjskill}">
								<h4>${sjskil.sjskill}</h4>
								<p class="cons">
									召唤师等级：<span>1</span>级
								</p>
							</div>
							<div class="spell-desc">${sjskil.sjrole}</div>
							<div>
								<img src="${sjskil.sfjn }" alt="${sjskil.sjskill}">
							</div>
						</div>

					</c:forEach>
				</div>
			</div>
		</div>
		<%@include file="/common/footer.jsp"%>
</body>
</html>
