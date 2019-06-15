<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>点卷充值</title>
<script type="text/javascript"
	src="<%=path%>/statics/js/jquery-1.12.4.js"></script>
<script type="text/javascript"></script>
<link rel="stylesheet" href="<%=path%>/statics/css/recharge.css"
	type="text/css"></link>
<style>
.service p:first-of-type {
	margin-top: 32px;
	margin-left: -10px;
	margin-right: -10px;
	font-size: 18px;
	color: #313131;
}
.head-nav-hover{
height:120px !important;
}
.service p:nth-of-type(2) {
	margin-top: 30px;
	margin-bottom: 110px;
}
</style>
<link rel="stylesheet" href="<%=path%>/statics/css/underlineAnimate.css"
	type="text/css"></link>
</head>
<body>
	<%@include file="/common/header.jsp"%>
	<div id="container" style="padding-top:30px;">
		<div class="wrap">
			<div id="pay_frame" style="height: 755px; width: 990px;">
				<div class="cp-sidebar-l">
					<div class="about">
						<div class="about__img service">
							<img src="<%=path%>/statics/images/logo.png" width="90"
								height="40">
							<p>英雄联盟点卷</p>
							<a href="<%=path%>/welcome.jsp" class="underlineAnimate"
								id="sidebar_homeUrl" target="_blank"><%=path%>/welcome.jsp</a>
							<p>冷静冷静，你问题的根源在于：充没充够钱。</p>
							<label for="checkbox2"> <input id="checkbox2" checked
								type="checkbox" name="auto1"> 同意 <a href="javascript:;"
								id="sidebar_term" target="_blank"><span
									id="sidebar_homeName">某雄联盟</span>玩家条例</a> </label>
						</div>
					</div>
				</div>
				<div class="cp-main">
					<div id="order_info">
						<div class="prop">
							<div class="account" style="position:relative;z-index:100">
								<div class="account-area">
									<span style="font-size: 14px;">充值账号:</span><input
										class="writenumber" type="text"
										<c:if test="${not empty user }">value="${user.number }"</c:if>
										<c:if test="${ empty user}"> placeholder="请选择需要充值的账号！"</c:if> />
										<span>请输入需要充值的账号</span>
								</div>
							</div>
							<div style="margin-bottom:0; width:560px; height:140px;"
								class="goods style5">
								<div class="goods-items" title="50元购买5000英雄联盟点券">
									<div class="total">
										<p style="text-align:center;">
											<img class="service__logo" alt="" title=""
												src="//midas.gtimg.cn/midas/images/logo/lol/24.png"> <span
												class="service__num">5000</span>
										</p>
										<div class="relative-to-total">
										<p style="display:inline-block;"><em class="money">50</em> <span class="unit">元</span></p>
									</div>
									<i class="icon-corner-checked"></i>
									</div>
									
								</div>
								<div class="goods-items" title="100元购买10000英雄联盟点券">
								<div class="total">
										<p style="text-align:center;">
											<img class="service__logo" alt="" title=""
												src="//midas.gtimg.cn/midas/images/logo/lol/24.png"> <span
												class="service__num">10000</span>
										</p>
										<div class="relative-to-total">
										<p style="display:inline-block;"><em class="money">100</em> <span class="unit">元</span></p>
									</div>
									<i class="icon-corner-checked"></i>
									</div></div>
								
								<div class="goods-items" title="200元购买20000英雄联盟点券">
								<div class="total">
										<p style="text-align:center;">
											<img class="service__logo" alt="" title=""
												src="//midas.gtimg.cn/midas/images/logo/lol/24.png"> <span
												class="service__num">20000</span>
										</p>
										<div class="relative-to-total">
										<p style="display:inline-block;"><em class="money">200</em> <span class="unit">元</span></p>
									</div>
									<i class="icon-corner-checked"></i>
									</div></div>
								<div class="goods-items" title="请输入您想要购买的点券数量">
								<div class="total">
										<p style="text-align:center;">
											<img class="service__logo" alt="" title=""
												src="//midas.gtimg.cn/midas/images/logo/lol/24.png"><input class="form-input form-input--s form-input--no-border service__input service__input-cn"  placeholder="其他数量">
										</p>
										<div class="relative-to-total">
										<p style="display:inline-block;"><em class="moneyI"></em> <span class="unit">元</span></p>
									</div>
									<i class="icon-corner-checked"></i>
									</div>
								</div>
								<p class="tips icon-tips goods-tips"><i class="icon-txt">充值数量必须是100的倍数</i></p>
							</div>
						</div>
					</div>
					<div class="pay-area">
					<span class="endprice">充值账号:${user.number }</span><span></span>&nbsp;&nbsp;&nbsp;<a hidefocus="true" class="btn btn-default" href="javascript:;">立即充值</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<%@include file="/common/footer.jsp"%>
</body>
<script type="text/javascript">
	$(function(){
		function getError(XMLHttpRequest, textStatus, errorThrown) {
		    // 通常 textStatus 和 errorThrown 之中
		    // 只有一个会包含信息
		     // 调用本次AJAX请求时传递的options参数
		     alert(textStatus);
		}
		var price=0;
		var flag=true;
		$(".writenumber").focusin(function(){
			$(".account-area span:last").text("");
		});
		$(".btn-default").click(function(){
			if($(".writenumber").val()==""){
				$(".account-area span:last").css({"display":"inline-block","font-size":"14px","color":"red"});
				$(".account-area input").focus();
				return false;
			}
			if(price==0){
				alert("请选择要充值的数量");
				return false;
			}
			var number=$(".account-area input").val();
			$.ajax({
				   type:"post",
				   url: "/HeroWeb/NumberCheckServlet",
				   data:{"number":number},
				   dataType:"text",
				   success: function(data){
					   if(data=="1"){
							$(".account-area span:last").text("此账号不存在");
							$(".account-area span:last").css({"display":"inline-block","font-size":"14px","color":"red"});
							flag=false;
							
						}else{
							toRecharge(number,price);
						}
				   },error:getError
				});
			
			if(flag==false){
				return false;
			}
			
		});
		function toRecharge(number,price){
			if(confirm("确认充值吗?\r\n本次充值的账号为:"+number+"\r\n本次充值金额为:"+price+"")){
				$.post("/HeroWeb/RechargeServlet",{"price":price,"number":number},function(data){
					if(data=="充值成功！"){
						if(confirm("是否继续充值？")){
							window.location.reload();
						}else{
							location.href="<%=path%>/welcome.jsp";
						}
					}else{
						alert("充值失败,请联系管理员！");
					}
				},"text");
			}
		}
		$(".service__input-cn").change(function(){
			var test=Number($(this).val());
			var ss=$.type(test);
			if($.type(test)!="number"||isNaN(test)){
				$(this).val("");
				$(".moneyI").html("");
			}else{
				var money=test/100;
				$(".moneyI").html(money);
				price=$("div[class*='goods-items']").eq(3).children(".total").children("p:first").children("input").val();
				$(".endprice+span").empty();
				$(".endprice+span").append("&nbsp;&nbsp;&nbsp;充值数:"+price+"&nbsp;&nbsp;&nbsp;");
			}
			
		});
		
		$("div[class*='goods-items']").click(function(){
			price=$(this).children(".total").children("p:first").children(".service__num").text();
			if(price==""){
				price=$(this).children(".total").children("p:first").children("input").val();
			}
			$(".endprice+span").empty();
			$(".endprice+span").append("&nbsp;&nbsp;&nbsp;充值数:"+price+"&nbsp;&nbsp;&nbsp;");
			$("div[class*='goods-items']").removeClass("checked");
			$("div[class*='goods-items']").children(".total").children(".icon-corner-checked").css("display", "none");
			$(this).addClass("checked");
			var temp = $(this).children(".total").children(".icon-corner-checked");
			$(this).children(".total").children(".icon-corner-checked").css("display", "inline-block");
		});
		$("div[class*='goods-items']:first").trigger("click");
		
		$("input[placeholder='其他数量']").focusin(function(){
			$(".goods-tips").css("display","inline-block");
		}).focusout(function(){
			$(".goods-tips").css("display","none");
		});
		
		function mustlogin(){
			if("${user}"==null||"${user}"==undefined||"${user}"==""){
				$("#loginbutton").trigger("click");
			}
		}
		mustlogin();
		$(".writenumber").change(function(){
			var ss=$(this).val();
			$(".endprice").html("充值帐号:"+$(this).val());
		})
		
		$("#loginButton").click(function(){
			getNumberToDo();
		});
		});
	function getNumberToDo(){
		$.post("<%=path%>/GetUserServlet", function(data) {
			var numbers = data.number;
			$(".writenumber").val(numbers);
		}, "json");
		
	}
	</script>
</html>