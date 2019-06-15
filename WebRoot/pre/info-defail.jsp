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

<link type="text/css" rel="stylesheet"
	href="statics/css/HeroDetails.css">

<title>My JSP 'info-defail.jsp' starting page</title>

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
<script>
	//点击某一个技能或皮肤就当前选中显示边框
	var skinprice = 0;
	function payfSkin(){
		$.post("<%=path%>/PayForThingServlet",{"price":skinprice},function(data){
            if(data=="1"){
            	alert("购买成功！");
            	window.location.reload();
            }else if(data=="2"){
            	alert("购买失败，请联系管理员！");
            }
			
		});
	}
	$(function() {
		var realskinname=0;
		function buyheroes(){
			$.post("<%=path%>/BuyHeroServlet",{"id":skinid},function(data){
				if(data=="1"){
					payfSkin();
					closeBuy();
				}else if(data=="2"){
                 alert("已经拥有此道具，无需重新购买！");
				}else{
					alert("购买失败，请联系管理员！");
				}
					
				
			});
			
		}
		function buyskins(){
			$.post("<%=path%>/BuyThingsServlet",{"id":skinid},function(data){
				if(data=="1"){
					payfSkin();
					closeBuy();
				}else if(data=="2"){
                 alert("已经拥有此道具，无需重新购买！");
				}else{
					alert("购买失败，请联系管理员！");
				}
					
				
			});
		}
		
		var skinid=0;
		
		var skinname="";
		var skinSrc="";
		$("#DATAspellsNAV li,#skinNAV li").click(function() {
			$(this).show().addClass("current");
			$(this).siblings().removeClass("current");
		});
		$("#skinNAV li").click(function() {
			skinprice = $(this).children("input").val();
			skinname=$(this).children("input").attr("skinname");
			skinSrc=$(this).children("input").attr("skinSrc");
			
			if ($(this).index() != 0) {
				skinid=$(this).children("input").attr("skinid");
				$("#defailBuy").removeClass();
				$("#defailBuy").addClass("buy-now");
				$("#defailBuy").text("购买皮肤");
				$(".gettobuy").unbind( "click" );
				$(".gettobuy").click(function(){buyskins();});
			} else {
				skinid=$(this).children("input").attr("heroid");
				$("#defailBuy").addClass("commspr commbtn-buy");
				$("#defailBuy").text("购买英雄");
				$(".gettobuy").unbind( "click" );
				$(".gettobuy").click(function(){buyheroes();});
			}
		});
		$("#DATAspellsNAV li:first,#skinNAV li:first").trigger("click");
		$("#defailBuy").click(function() {
							document.getElementById("hidebg_hj").style.display = "block";//隐藏隐藏层
							document.getElementById("hidebox_hj").style.display = "block"; //隐藏弹出层
							document.getElementById("hidebg_hj").style.height = $(
									document.body).height()
									+ "px"; //设置隐藏层的高度为当前页面高度
									$(".hideviewleft img").attr("src","<%=path%>/" + skinSrc + "");
							$(".hideviewleft img").attr("title", skinname);
							realskinname = skinname;
							realskinname = realskinname.substring(0, skinname
									.indexOf("图标"));
							$(".hideviewleft span").text(realskinname);
							var price = 0;
							if ("${user.ava}" != "") {
								price = "${user.ava}";
								price = parseInt(price);
							}
							$(".ownava").text(price);
							if (skinprice > price) {
								alert("余额不足了哟！");
								$(".gettobuy").attr("disabled", "false");
							}
							price = price - skinprice;
							$(".buyafter").text(price);
							$(".hideviewright span").not(".buyafter,.ownava")
									.html(skinprice);
						});
	});
	// 	英雄技能
	function showSkll(id) {
		$("#skll_" + id).show();
		$("#skll_" + id).siblings().hide();
	}
	// 	英雄皮肤
	function showSkin(id) {
		$("#skin_" + id).show();
		$("#skin_" + id).siblings().hide();

		$("#skinName_" + id).show();
		$("#skinName_" + id).siblings().hide();

	}
	//购买英雄
	function clickHero() {
		var heross = document.getElementById("heros");
		heros.style.display = "block"; //显示隐藏层

		heros.style.height = document.body.clientHeight + "px"; //设置隐藏层的高度为当前页面高度
		document.getElementById("hidebox").style.display = "block"; //显示弹出层
		//$("#userNumber").focus();
	}
	function closeBuy() {
		document.getElementById("hidebg_hj").style.display = "none";
	}
</script>
</head>

<body>
	<%@include file="/common/header.jsp"%>
	<div id="hidebg_hj" class="hidebg_hj">
		<div id="hidebox_hj" class="hidebox_hj">
			<h1>
				购买道具 <a onclick="closeBuy()" class="closebuy">x</a>
			</h1>
			<div class="viewtobuy">
				<div class="hideviewleft">
					<img title="" src=""> <span></span>
				</div>
				<div class="hideviewright">
					价格:&nbsp;&nbsp;<span></span><br> 您剩余的点卷:<span class="ownava"></span><br>购买后所剩:<span
						class="buyafter"></span><br> <input type="button"
						class="gettobuy" value="立即购买"><a
						href="<%=path%>/pre/recharge.jsp">前往充值</a>
				</div>
			</div>


		</div>
	</div>
	<div class="comm-topact" style="display:block;">
		<img class="topact-small-img"
			src="<%=path%>/statics/images/info-back.jpg">
	</div>
	<div id="heros" class="heros"></div>
	<div class="wraper">
		<div class="layout mainer">
			<!--路径导航-->
			<div class="website-path">
				<i class="icon-home"></i> <a href="">英雄联盟首页</a> <i
					class="icon-arrow-2"></i> <a href="<%=path%>/HeroListServlet">游戏资料</a>
				<i class="icon-arrow-2"></i> <a href="<%=path%>/HeroListServlet">全部英雄</a>
				<i class="icon-arrow-2"></i> <a class="here" id="DATAnametitle">${hero.heroname}</a>
			</div>
			<div class="infodefail">
				<div id="defailDATA" class="defail-data">
					<h1 id="DATAname">${hero.heroname}</h1>
					<h2 id="DATAtitle">${hero.heroname}</h2>
					<div id="DATAtags" class="defail-tags">
						<span>${heros.htype.postionname}</span><span>${heros.htype.htypename}</span>
					</div>
					<dl id="DATAinfo" class="defail-stat">
						<dt>物理攻击</dt>
						<dd>
							<i class="up up1" title="8" style="width:80%"></i>
						</dd>
						<dt>魔法攻击</dt>
						<dd>
							<i class="up up2" title="3" style="width:30%"></i>
						</dd>
						<dt>防御能力</dt>
						<dd>
							<i class="up up3" title="4" style="width:40%"></i>
						</dd>
						<dt>上手难度</dt>
						<dd>
							<i class="up up4" title="4" style="width:40%"></i>
						</dd>
					</dl>
					<div class="defail-buy">
						<a id="defailBuy" href="javascript:;" onclick="return clickHero()"
							class="commspr commbtn-buy">购买英雄</a>
					</div>
				</div>
				<span class="sbg"></span>
				<div class="defail-skin">
					<!-- 英雄皮肤大图 -->
					<ul id="skinBG" class="defail-skin-bg">
						<c:forEach items="${skinsList}" var="skin" varStatus="status">
							<li id="skin_${status.index + 1}" title="${skin.skinname}"><img
								src="${skin.imgsrc}" alt="${skin.skinname}"></li>
						</c:forEach>
					</ul>
					<div class="defail-skin-nav">
						<!-- 英雄皮肤名称 -->
						<div class="defail-skin-name">
							<c:forEach items="${skinsList}" var="skin" varStatus="status">
								<span id="skinName_${status.index+1 }">${skin.skinname}</span>
							</c:forEach>
						</div>
						<ul id="skinNAV">
							<!-- 英雄皮肤小图标 -->
							<c:forEach items="${skinList}" var="skin" varStatus="status">

								<li class="" onclick="showSkin('${status.index + 1}')"><input
									type="hidden" skinid="${skin.id }" heroid="${skin.heroid }"
									skinsrc="${skin.imgsrc }" skinname="${skin.skinname }"
									id="skinprice_${status.index}" value="${skin.price }">
									<a title="${skin.skinname}"><img src="${skin.imgsrc}"
										alt="${skin.skinname}" width="60" height="60"> <span
										class="sbor"></span> </a>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
			<div class="clearfix">
				<div class="infoleftcont">
					<h4 class="infotitle">背景故事</h4>
					<div class="colbox bgstroy">
						<div id="DATAlore">${hero.herostory}</div>
					</div>
					<h4 class="infotitle">技能介绍</h4>
					<ul id="DATAspellsNAV" class="infotab">
						<c:forEach items="${skills}" var="skill">
							<c:forEach begin="0" end="${skill.skillList.size()}"
								varStatus="hStatus">
								<li class="" onclick="showSkll('${hStatus.index + 1}')"><img
									src="${skill.srcList[hStatus.index].imgsrc}"
									alt="${skill.skillList[hStatus.index].skillname}" />
								</li>
							</c:forEach>
						</c:forEach>
					</ul>
					<div id="DATAspells" class="colbox infoskillbox">
						<c:forEach items="${skills}" var="skill" varStatus="status">
							<c:forEach items="${skill.skillList}" var="skillii"
								varStatus="status">
								<div id="skll_${status.index + 1}" class="skilltitle">
									<h5>${skillii.skillname}</h5>
									<em> <c:choose>
											<c:when test="${status.index == 0}">被动</c:when>
											<c:when test="${status.index == 1}">Q</c:when>
											<c:when test="${status.index == 2}">W</c:when>
											<c:when test="${status.index == 3}">E</c:when>
											<c:when test="${status.index == 4}">R</c:when>
											<c:otherwise>??</c:otherwise>
										</c:choose> 技能</em>
									<p>${skillii.addition}</p>
								</div>
							</c:forEach>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/common/footer.jsp"%>
</body>
</html>
