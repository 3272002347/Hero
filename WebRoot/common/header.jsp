<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="<%=path%>/statics/css/common.css"
	type="text/css"></link>
<script type="text/javascript">
function getUserInfo(){
	  var number="${user.number}";
	  var password="${user.password}";
	  $.post("<%=path%>/LoginServlet",{number:number,password:password},function(data){
		 // alert(data);
		 // tologin(data.dansrc,data.username,data.ava);
	  });
}
  $(function(){
	
	  getUserInfo();
	 function isLogined(){
		 if("${user}"!=null&&"${user}"!=undefined&&"${user}"!=""){
			tologin("${user.dansrc}","${user.username}","${user.ava}");
		 }
	 }
	 isLogined();
	 $(".head-nav").mouseover(function(){
		 $(".head-nav-hover").fadeIn("fast");
	 });
	 $(".comm-head").mouseleave(function(){
		 $(".head-nav-hover").fadeOut("fast");
	 });
	  $(".head-userinfo-normal").hover(function(){
		  $(".head-app-hover").fadeIn("fast");
	  },function(){
		  $(".head-app-hover").fadeOut("fast");
	  });
  });
  function clickLogin(){
	  var hideobj=document.getElementById("hidebg");
	   hidebg.style.display="block";  //显示隐藏层
	   
	   hidebg.style.height=document.body.clientHeight+"px";  //设置隐藏层的高度为当前页面高度
	   document.getElementById("hidebox").style.display="block";  //显示弹出层
	   $("#userNumber").focus();
  }
  
  $(document).keyup(function(event){
	  if($("#hidebox").css("display")!="none"){
		  if(event.keyCode ==13){
			    $("#loginButton").trigger("click");
			  }
	  }
	  
	});
  function clickLoginOut(){
	  if(confirm("确认注销吗?")){
		  $.post("<%=path%>/LoginOutServlet",function(data){
			  alert(data);
			  $(".head-app-hover img:first").attr("src","<%=path%>/statics/images/default(1).png");
			  $(".head-app-hover .username").html("");
			  $(".head-app-hover .ava").text("");
		   document.getElementById("logined").style.display="none";
		   document.getElementById("tologin").style.display="block";  
		  });
	  }
	  
  }
  function tologin(dansrc,username,ava){

	   document.getElementById("hidebg").style.display="none";//隐藏隐藏层
	   document.getElementById("hidebox").style.display="none";  //隐藏弹出层
	   document.getElementById("logined").style.display="inline";
	   document.getElementById("tologin").style.display="none";
	   $(".head-app-hover img:first").attr("src","<%=path%>/"+dansrc);
	   $(".head-app-hover .ava").text(ava);
	   $(".username").html(username);
	   $(".logined-name").html(username);
	   $("#userNumber").val("");
	   $("#userPassWord").val("");
  }
 
  function clickReg(){
	  var number=$("#userNumber").val();
	  var password=$("#userPassWord").val();
	  
	  if(number!=null&&number!=undefined&&number!=""&&password!=null&&password!=undefined&&password!=""){
		  $.post("<%=path%>/LoginServlet",{number:number,password:password},function(data){
			  if(data.reg!="账号或者密码错误,请重试!"){
				   alert("登录成功！");
				   window.location.reload();
				   //tologin(data.dansrc,data.username,data.ava);
			  }else{
				  alert(data.reg);
			  }
		  },"json");
	  }else{
		  alert("账号或密码未输入！");
	  }
	  
  }
  function tempNotOp(){
	  alert("此功能暂未开放!");
  }
  function clickX(){
	  document.getElementById("hidebg").style.display="none";
  }
  function intoPersonal(){
	  var userstate=$("#logined").css("display");
	  if(userstate=="none"){
		  alert("请先登录！");
		  return false;
	  }else{
		  location.href="<%=path %>/pre/personinfo.jsp";
	  }
  }
  </script>
<header>
	<div id="hidebg" class="hidebg">
		<div id="hidebox" class="hidebox">
			<h1>
				账号密码登录 <a onclick="clickX()" class="x">x</a>
			</h1>
			<div style="position:relative;top:35px;left:130px;margin:0 auto;">
				<input type="text" id="userNumber" placeholder="请输入您的账号"><br>
				<input type="password" id="userPassWord" placeholder="请输入您的密码"><br>
				<input type="button" id="loginButton" onclick="clickReg();" value="登录"><br>
					<a href="<%=path%>/pre/register.jsp"><input type="button" onclick="" value="注册"></a>
					
				<%--post提交 --%>
			</div>
		</div>
	</div>
	<div class="comm-head">
		<div class="head-normal">
			<!--logo-->
			<a class="logo" href="https://lol.qq.com/" title="英雄联盟官网"> <img
				src="<%=path%>/statics/images/logo.png" width="132" height="49"
				alt="英雄联盟"> </a>
			<!--官网导航-->
			<ul class="head-nav">
				<li><a href="HeroListServlet" target="_blank"> <span
						class="head-nav-title">游戏资料</span> <span class="head-nav-subtitle">GAME
							INFO</span> </a>
				</li>
				<li><a href="<%=path%>/HeroStoreServlet" target="_blank"> <span
						class="head-nav-title">商城</span> <span class="head-nav-subtitle">STORE</span>
				</a>
				</li>
				<li><a onclick="tempNotOp()"> <span class="head-nav-title">社区互动</span> <span
						class="head-nav-subtitle">COMMUNITY</span> </a>
				</li>
				<li><a href="https://lpl.qq.com/" target="_blank"
					onclick="pgvSendClick({hottag:&#39;v3.top.subnav.match.lpl&#39;})"
					title="LPL赛事官网"> <span class="head-nav-title">赛事官网</span> <span
						class="head-nav-subtitle">ESPORTS</span> </a>
				</li>
				<li><a> <span class="head-nav-title">自助系统</span> <span
						class="head-nav-subtitle">SYSTEM</span> </a>
				</li>
			</ul>
			<!--玩家信息-->
			<div class="head-userinfo-normal">
				<div class="head-userinfo-avatar">
					<img src="<%=path%>/statics/images/default.png" width="36"
						height="auto" alt="玩家头像"> <span></span> <a
						href="javascript:;" onclick="intoPersonal()" target="_blank"
						class="herf-mask" title="个人中心"></a>
				</div>
				<div class="head-userinfo-brief">
					<p id="tologin" class="unlogin">
						亲爱的召唤师，欢迎<a href="javascript:;" id="loginbutton" onclick="clickLogin()">登录</a>
					</p>
					<p id="logined" class="logined" style="display: none;">
						<a class="logined-name">${user.username }</a><a
							class="logined-logout" href="javascript:;" onclick="clickLoginOut()">[注销]</a>
					</p>
				</div>

			</div>
			<div class="head-app-hover">
				<img style=＂-moz-opacity:0.5; filter:alpha(opacity=50);＂ src="<%=path%>/statics/images/default(1).png" width="140" height="101"></img> <a
					class="username"> <%--召唤师名字 登录后的user里取username--%>  </a>
					<div class="divava">点卷:<a class="ava"></a></div> <a
					style="float:left;display:block; color:#7B7C7D;position:absolute;bottom:45px;">官网个人信息显示略有延迟，仅供参考!</a>
				<img class="polo" src="<%=path%>/statics/images/polo.gif" alt="魄罗"
					width="50" height="50">
			</div>

			<!--登录hover-->
			<div class="head-login-hover">
				<div class="unlogin">
					<p class="p2">官网个人信息显示略有延迟，仅供参考</p>
				</div>
				<div class="logined" style="display: none;">
					<%--已经登录过后显示注销按钮 --%>
					<div class="logined-top">
						<a class="select-area" href="javascript:T_Login.changeArea()"></a>
						<a class="user-name"></a>
					</div>

					<p class="p2">官网个人信息显示略有延迟，仅供参考</p>
				</div>
				<a href="<%=path %>/pre/personinfo.jsp"
					class="href-gouserhome">进入个人中心<i class="more-arrow"></i> </a>

			</div>
		</div>
		<div class="head-nav-hover">
			<nav>
				<ul class="head-nav-hover-ul">
					<li><a href="<%=path%>/HeroListServlet">英雄</a><a
						href="<%=path%>/EquipListServlet">物品</a><a
						href="<%=path%>/SjskilListServlet">召唤师技能</a></li>
					<li><a href="<%=path%>/pre/recharge.jsp">点卷充值</a><a href="<%=path%>/HeroStoreServlet">道聚城</a>
					</li>
					<li><a>赠送英雄</a><a>赠送皮肤</a>
					</li>
					<li><a>赠送英雄</a><a>赠送皮肤</a>
					</li>
					<li><a href="<%=path%>/pre/User-consult.jsp">关于我们</a>
					<a href="<%=path%>/pre/register.jsp">注册账号</a>
					</li>
				</ul>
			</nav>
		</div>

	</div>

</header>
