<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path =request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>官网</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <script type="text/javascript" src="<%=path %>/statics/js/jquery-1.12.4.js"></script></head>
  <style type="text/css">
html, body, div, p, img, a {
	margin: 0 auto;
	padding: 0;
}
html, body {
	height: 100%;
}
.drag_div img{
margin-top:25px !important;
display:block;

}
body {
	padding: 0px 20px;
	box-sizing: border-box;
	font-family: "微软雅黑";
	font-size: 14px;
	background-color: #252525;
}
.img_100 img {
	width: 100%;
	max-width: 100%;
}

.margin_bottom_15 {
	margin-bottom: 15px;
}
.text_center {
	text-align: center;
}
.drag_div {
	margin-top: 30px ;
	width: 1300px;
	height: 760px;
	overflow: hidden;
	position: relative;
}
.drag_div>div {
	background: #fff;
	padding: 5px;
	box-sizing: border-box;
	overflow: hidden;
}
.drag_div>div.one {
	position: absolute;
	top: 0;
	left: 0;
	width: 20%;
	height: 240px;
}
.drag_div>div.two {
	position: absolute;
	top: 260px;
	left: 0;
	width: 20%;
	height: 240px;
}
.drag_div>div.three {
	position: absolute;
	top: 520px;
	left: 0;
	width: 20%;
	height: 240px;
}
.drag_div>div.four {
	position: absolute;
	top: 0px;
	left: 21%;
	width: 37%;
	height: 760px;
}
.drag_div>div.five {
	position: absolute;
	top: 0px;
	left: 59%;
	width: 20%;
	height: 280px;
}
.drag_div>div.six {
	position: absolute;
	top: 300px;
	left: 59%;
	width: 20%;
	height: 220px;
}
.drag_div>div.seven {
	position: absolute;
	top: 540px;
	left: 59%;
	width: 20%;
	height: 220px;
}
.drag_div>div.eight {
	position: absolute;
	top: 0px;
	left: 80%;
	width: 20%;
	height: 280px;
}
.drag_div>div.nine {
	position: absolute;
	top: 300px;
	left: 80%;
	width: 20%;
	height: 220px;
}
.drag_div>div.ten {
	position: absolute;
	top: 540px;
	left: 80%;
	width: 20%;
	height: 220px;
}
.drag_div>div.one img, .drag_div>div.two img, .drag_div>div.three img {
	width: 100%;
	height: 180px;
}
.drag_div>div.four img {
	width: 100%;
	height: 700px;
}
.drag_div>div.five img, .drag_div>div.eight img {
	width: 100%;
	height: 220px;
}
.drag_div>div.six img, .drag_div>div.seven img, .drag_div>div.nine img, .drag_div>div.ten img {
	width: 100%;
	height: 160px;
}
.drag_div img{
 width:80% !important;
 margin:0 auto;
 cursor:pointer;
 height:80% !important;
}
.drag_div img:hover{
margin-top:0 !important;
width:100% !important;
height:100% !important;
transition:all .3s ease-in .1s;
}
</style>
  <body>
  <%@include file="/common/header.jsp" %>
  
  <div class="drag_div" id="drag_div">
  <div class="one">
<<<<<<< .mine
   <a href="<%=path %>/"><img src="statics/images/a4.png" title="点卷充值"></a> 
=======
   <a href="<%=path %>/pre/recharge.jsp"><img src="<%=path %>/statics/images/recharge.png" title="点卷充值"></a> 
>>>>>>> .r563
  </div>
  <div class="two">
   <a href="<%=path %>/HeroStoreServlet"> <img src="<%=path %>/statics/images/hero.jpg" title="英雄商城"></a> 
  </div>
  <div class="three">
  <a href="<%=path %>/SkinStoreServlet"><img src="<%=path %>/statics/images/skins.jpg" title="皮肤商城"></a>
  </div>
  <div class="four">
  <a href="<%=path%>/HeroListServlet"><img src="<%=path %>/statics/images/heroinfo.jpg" title="英雄资料"></a> 
  </div>
  <div class="five">
<a href="<%=path%>/EquipListServlet"><img src="<%=path %>/statics/images/wupin.jpg" title="物品资料"></a>
  </div>
  <div class="six">
    <a href="<%=path%>/SjskilListServlet"><img src="<%=path %>/statics/images/uskill.jpg" title="召唤师技能介绍"></a>
  </div>
  <div class="seven">
    <a href="<%=path %>/register.jsp"><img src="<%=path %>/statics/images/register.jpg" title="注册账号"></a>
  </div>
  <div class="eight">
   <a href="<%=path %>/pre/User-consult.jsp"><img src="<%=path %>/statics/images/about.jpg" title="关于我们"></a>
  </div>
  <div class="nine">
  <a href="<%=path %>/pre/User-consult.jsp"> <img src="<%=path %>/statics/images/usermust.png" title="用户协议"></a>
  </div>
  <div class="ten">
 <a href="<%=path %>/welcome.jsp"><img src="<%=path %>/statics/images/back.png" title="返回首页"></a>
  </div>
</div>
 <%@include file="/common/footer.jsp" %>
</body>
</html>
