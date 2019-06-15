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
<title>个人中心</title>
<script type="text/javascript"
	src="<%=path%>/statics/js/jquery-1.12.4.js"></script>
	
<link rel="stylesheet" href="<%=path%>/statics/css/personio.css"
	type="text/css"></link>
<script type="text/javascript">
	$(function(){
			$(".underlineAnimate:first").children(".Chinese").css("color", "#0baac0");
		
		getUserHero();
		function getUserSrc(){
			$(".English:first").css("color","#0baac0");
			var logend="${user}";
			if(logend==""){
				alert("请先登录！");
				location.href="<%=path%>/welcome.jsp";
			}
			var userimg="${user.usersrc}";
			if(userimg==""){
				$("#communityHead").attr("src","<%=path%>/statics/images/default.png");
			}
		}
		getUserSrc();
		$("#J_logout").click(function() {
			$(".logined-logout").trigger("click");
		});
		$(".underlineAnimate").click(function() {
			$(".English").css("color", "#444");
			$(".Chinese").css("color", "#444");
			$(this).children(".English").css("color", "#0baac0");
			$(this).children(".Chinese").css("color", "#0baac0");
		});
		function getUserHero(){
			$.get("<%=path%>/GetUserHerosServlet",function(data){
				$(".userdetails").empty();
				var myhtml="";
				if(data=="null"){
					myhtml="<div style='width:400px;height:400px; margin:0 auto;margin-top:130px;'>"
					+"<img src='<%=path%>/statics/images/emotion.png' width='100px' height='100px'>"
					+"<div style='float:right;'>"
						+"<h1>未拥有任何英雄哦！</h1><a href='<%=path%>/pre/store/store.jsp' class='tobuy'>前往购买</a>"
					+"</div></div>";
					$(".userdetails").append(myhtml);
					return;
				}
				
				$.each(data,function(index,value){
					myhtml+="<dl><dt><a href='<%=path%>/HeroDefailServlet?id="+value.id+"'> <img src='<%=path%>/"+value.imgsrc+"' width='122'"
					+"height='150'> </a></dt><dd style='text-align:center;'>"
					+"<a href='/lol/item/14771.shtml?ADTAG=innercop.lol.SY.recommend_new'"
					+"class='djname' title='"+value.heroname+"'> <strong>"+value.heroname+"</strong> </a>"
				    +"<div class='bxlist-t2 c'>"
					+"<a href='' class='btn-green buy-now' title='查看详情'>查看英雄信息</a>"
				    +"</div></dd></dl>";
				});
				
				$(".userdetails").append(myhtml);
			},"json");
		}
		function getUserSkins(){
			$.post("<%=path%>/GeuUserSkinsServlet",function(data){
				var myhtml="";
				$(".userdetails").empty();
				if(data=="null"){
					myhtml="<div style='width:400px;height:400px; margin:0 auto;margin-top:130px;'>"
					+"<img src='<%=path%>/statics/images/emotion.png' width='100px' height='100px'>"
					+"<div style='float:right;'>"
						+"<h1>未拥有任何皮肤哦！</h1><a href='<%=path%>/pre/store/storeskin.jsp' class='tobuy'>前往购买</a>"
					+"</div></div>";
					$(".userdetails").append(myhtml);
					return;
				}
				
				$.each(data,function(index,value){
					myhtml+="<dl><dt><a href='<%=path%>/HeroDefailServlet?id="+value.id+"'> <img src='<%=path%>/"+value.imgsrc+"' width='122'"
					+"height='150'> </a></dt><dd style='text-align:center;'>"
					+"<a href='<%=path%>/HeroDefailServlet?id="+value.id+"'"
					+"class='djname' title='"+value.heroname+"'> <strong>"+value.heroname+"</strong> </a>"
				    +"<div class='bxlist-t2 c'>"
					+"<a href='' class='btn-green buy-now' title='查看详情'>查看英雄信息</a>"
				    +"</div></dd></dl>";
				});
				
				$(".userdetails").append(myhtml);
			});
		}
		$(".nav-3 a:first").click(function(){
			getUserHero();
		});
		$(".nav-3 a:last").click(function(){
			getUserSkins();
		});
	});
	
</script>
</head>
<body>
	//<%@include file="/common/header.jsp"%>
	<div class="main">
		<div class="main-container">
			<!--页面路径start-->
			<div class="navi">
				<i class="icon-home"></i> <a href="<%=path%>/welcome.jsp">英雄联盟首页</a>
				<i class="icon-arrow-nav"></i> <span>社区个人中心</span>
			</div>
			<div class="userinfo" style="display: block;">
				<div class="user-head">
					<div class="user-head-bg"></div>
					<div class="user-head-img">
						<img src="<%=path %>/${user.usersrc }" id="communityHead">
					</div>
				</div>
				<div class="user-datum">
					<div class="d-wrap-0">
						<span class="name" id="communityName">${user.username }</span> <i
							id="communityGender" class="icon-man"></i>
						<div class="operation">
							<a href="javascript:T_Login.logout()" id="J_logout" style="">
								<i class="icon-cancel"></i> <span>注销</span> </a>
						</div>
					</div>
					<div class="d-wrap-2" style="">
						<a> <span><i class="icon-currency"></i>我的段位</span> <span
							class="num" id="mengCoinNum">${user.danname }</span> </a> <a
							href="javascript:cimi.TGDialogS('dynamic')"
							onclick="pgvSendClick({hottag:'v3.space.index.user.dynamic'});">
							<span>我的点卷</span> <span class="num" id="dynamicNum">${user.ava
								}</span> </a>
					</div>
				</div>
			</div>
			<div class="user-nav nav-3" style="display: block;">
				<a href="javascript:;" onclick="" class="underlineAnimate hoveron"> <span
					class="Chinese" >我的英雄</span> <span class="English">OWENED
						HEROES</span> </a> <a href="javascript:;" onclick="" class="underlineAnimate">
					<span class="Chinese">我的皮肤</span> <span class="English">OWENED
						SKIN</span> </a>

			</div>
			<div class="userdetails" style="display:block;">
				
					
			</div>
		</div>
	</div>
	<%@include file="/common/footer.jsp"%>
</body>
</html>