<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>皮肤商城</title>
<script type="text/javascript"
	src="<%=path%>/statics/js/jquery-1.12.4.js"></script>
<script type="text/javascript"></script>
<link rel="stylesheet" href="<%=path%>/statics/css/index-store.css"
	type="text/css"></link>
</head>
<body>
	<div class="mainbg">
		<%@include file="/common/header.jsp"%>

		<div class="layout contwrap">
			<div class="menu">

				<div class="navico stext">
					<div class="storelogo">
						<img src="<%=path%>/statics/images/storeimg/shoplogo.png"
							class="bikelogo"></img>
					</div>
					<div class="searchbtndiv">
						<img class="searchbtn" alt="搜索"
							src="<%=path%>/statics/images/storeimg/search.png"> <input
							type="text" placeholder="输入道具进行搜索" id="inpt_nav_search_name"
							class="js_btn_click_report">
					</div>
					<div style="float:left; margin-top:30px;margin-left:150px;">
						<img src="<%=path%>/statics/images/logo.png"></img>
					</div>
				</div>
			</div>
			<div class="mainer">
				<div class="mainlist">
					<ul>
						<li>商品列表</li>
						<a href="<%=path%>/HeroStoreServlet">
							<li>英雄</li>
						</a>
						<a href="<%=path%>/SkinStoreServlet">
							<li style="
	background-color: #3C404B;">皮肤</li>
						</a>
					</ul>
				</div>

				<div class="viewlist">
					<div>
						<span class="remind">上架商品:皮肤</span>
					</div>
					<div id="viewDiv" style="height:1200px;width:914px;display:inline-block;">
						<c:forEach var="item" items="${items.resultList }"
							varStatus="status">
							<dl>
								<dt>
									<a
										href="<%=path %>/HeroDefailServlet?id=${item.heroid}"
										target="_blank"> <img src="${item.imgsrc }" width="116"
										height="150"> </a>

								</dt>
								<dd style="text-align:center;">
									<a
										href="<%=path %>/HeroDefailServlet?id=${item.heroid}"
										class="djname" target="_blank" title="冬${item.skinname
											}大礼包"> <strong>${item.skinname
											}</strong> </a>
									<div class="bxlist-t1">
										点卷：<span class="t2 fwb">&nbsp;&nbsp;&nbsp;${item.price
											}</span>
									</div>

									<div class="bxlist-t2 c">
										<a href="<%=path %>/HeroDefailServlet?id=${item.heroid}" class="btn-green buy-now" title="立即购买">立即购买</a>
									</div>
								</dd>
							</dl>
						</c:forEach>
					</div>
					<div class="rightbar">
						<ul>
							<c:forEach varStatus="status" begin="1" end="${items.totalPage }">
								<c:choose>
									<c:when test="${status.count==1 }">
										<li class="rightli" onclick="getpage(1)">首页</li>
									</c:when>
									<c:when test="${status.count==items.totalPage }">
										<li class="rightli" onclick="getpage(${items.totalPage})">
											末页</li>
									</c:when>
									<c:otherwise>
										<li class="rightli" onclick="getpage(${status.count})">
											第${status.count }页</li>
									</c:otherwise>
								</c:choose>
							</c:forEach>


						</ul>
					</div>
				</div>
			</div>
		</div>
		<%@include file="/common/footer.jsp"%>
	</div>
	<script type="text/javascript">
		$(function() {
			$(".rightli").click(function() {
				var rightli = $(".rightli");
				rightli.each(function(index, element) {
					$(element).css("background-color", "#55BFD7");
				});
				$(this).css("background-color", "#4B68A2");
			});
			$(".rightli").hover(function() {
								if ($(this).attr("background-color") != "rgb(85, 191, 215)"
										&& $(this).css("background-color") != "rgb(75, 104, 162)") {
									$(this).css("background-color", "#86ABD8");
								}
							},function() {
								if ($(this).css("background-color") != "rgb(75, 104, 162)") {
									$(this).css("background-color", "#55BFD7");
								}
								});
			
		});
		
		function getpage(pageNo){
			$.post("/HeroWeb/GetPageSkinServlet",{"pageNo":pageNo},function(data){
				var resultlist=data.resultList;
				$("#viewDiv").empty();
				var dlhtml="";
				$.each(resultlist,function(index,value){
					dlhtml+="<dl><dt><a href='/lol/item/14771.shtml?ADTAG=innercop.lol.SY.recommend_new'"
						+"target='_blank'> <img src='"+value.imgsrc+"' width='116'"
						+"height='150'> </a></dt><dd style='text-align:center;'>"
					+"<a href='/lol/item/14771.shtml?ADTAG=innercop.lol.SY.recommend_new'"
						+"class='djname' target='_blank' title='"+value.skinname+"礼包'> <strong>"+value.skinname+""
						+"</strong></a><div class='bxlist-t1'>点卷：<span class='t2 fwb'>&nbsp;&nbsp;&nbsp;"+value.price+""
							+"</span></div><div class='bxlist-t2 c'>"
						+"<a href='' class='btn-green buy-now' title='立即购买'>立即购买</a></div></dd></dl>";
				});
				$("#viewDiv").append(dlhtml);
			},"json");
		}
	</script>
</body>
</html>