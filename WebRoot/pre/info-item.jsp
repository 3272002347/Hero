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

<title>My JSP 'info-item.jsp' starting page</title>

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
		// 	鼠标点入清空
		$("#jSearchItemInput").focus(function() {
			if (this.value == "请输入您要搜索的物品名") {
				this.value = "";
			}
			;
			this.style.color = "black";
		});
		// 	鼠标点出加上
		$("#jSearchItemInput").blur(function() {
			if (this.value == "" || this.value == "请输入您要搜索的物品名") {
				this.value = "请输入您要搜索的物品名";
				this.style.color = "#999999";
			}
		});
		//查询
		$("#jSearchItemInput").change(function() {
			var ItemName = $(this).val();
			location.href=
			"<%=path%>/EquipListServlet?ItemName=" + ItemName;
		});
	});
	//鼠标悬浮上
	function equipShow(id, element) {
		$("#popPupItem_" + id).show();
		//获取鼠标当前位置
		$("#popPupItem_" + id).css({
			"top" : $(element).offset().top + "px",
			"left" : $(element).offset().left + $(element).width() + "px"
		});
	}
	//鼠标移出
	function equipHide(id) {
		$("#popPupItem_" + id).hide();
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
				<i class="icon-arrow-2"></i> <a class="here">物品</a>
			</div>
			<div class="colbox">
				<div id="pageTAB" class="pagetab">
					<ul class="pagetab-list pagetab-list2">
						<li class="p-list1"><a class="pagetab-list-lnk"
							href="<%=path%>/HeroListServlet">英雄</a>
						</li>
						<li class="p-list2"><a class="pagetab-list-lnk"
							href="<%=path%>/EquipListServlet">物品</a>
						</li>
						<li class="p-list3"><a class="pagetab-list-lnk"
							href="<%=path%>/SjskilListServlet">召唤师技能</a>
						</li>
					</ul>
				</div>

				<!-- 英雄列表 -->
				<div class="clearfix info-showbox">
					<div class="searchbox info-searchbox">
						<input id="jSearchItemInput" class="input-search" type="text"
							value="请输入您要搜索的物品名"> <span
							class="publicspr tnd btn-search">搜索</span>
					</div>
					<div id="seleteCheckItemSec" class="colbox selete-seccheck"
						style="display:none"></div>


					<ul id="jSearchItemDiv" class="imgtextlist">
						<c:forEach items="${equipList}" var="equip" varStatus="status">
							<li data-title="${status.index + 100}" class="Etypename"
								onmouseover="equipShow('${status.index + 100}', this)"
								onmouseout="equipHide('${status.index + 100}')"><a> <img
									src="${equip.src.imgsrc}" alt="${equip.equipment}">
									<p>${equip.equipment}</p> <span class="sbg"> <i
										class="commspr commico-search"></i> </span> </a></li>
						</c:forEach>
					</ul>
				</div>
				<!-- end 英雄列表 -->
			</div>

		</div>
	</div>
	<c:forEach items="${equipList}" var="equip" varStatus="status">
		<div id="popPupItem_${status.index + 100}" class="poppup-item"
			style="display: none;">
			<div id="itemFromTop">
				<div class="item-title">
					<img src="${equip.src.imgsrc}" alt="">
					<h4>${equip.equipment}</h4>
				</div>
				<div class="item-desc">
					<stats>${equip.etypename}</stats>
				</div>
			</div>
			<div id="itemFromTree" class="item-from"></div>
		</div>
	</c:forEach>
	<%@include file="/common/footer.jsp"%>
</body>
</html>
