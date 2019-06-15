<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>My JSP 'userMent.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="statics/css/userMentCss-ly.css">

<script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
  $(function(){
		
		ajaxShow(1);
		
		$(".mentClassify-ly div").click(function(){
			$(this).parent().children().css("background-color","whitesmoke");
			$(this).css("background-color","lightsteelblue");
			var neirong=$(this).children().text();
			$(".heroList-ly span").text(neirong+">>");
		});
		
		$(".managementHome1-ly").click(function(){
			$(".heroTableDiv-ly").css("display","block");
			$(".heroAddDiv-ly").css("display","none");
		});
		
		$(".managementHome2-ly").click(function(){
			$(".heroTableDiv-ly").css("display","none");
			$(".heroAddDiv-ly").css("display","block");
		});
	});
// 	添加非空验证
	function check() {
		var number= document.getElementById("number");
		var huserName = document.getElementById("huserName");
		var password = document.getElementById("password");
		var passWord = document.getElementById("passWord");
		if (number.value == "") {
			alert("账号不能为空,并且只能是数字！！");
			return false;
		}else if (huserName.value == "") {
			alert("用户名不能为空！！");
			return false;
		} else if (password.value == "") {
			alert("密码不能为空！！");
			return false;
		} else if (password.value !=passWord.value) {
			alert("两次密码不一致！！");
			return false;
		} else{
			return true;
		}
	}
	
  function ajaxShow(pageNo){
	  $.post("<%=path%>	/UserListServlet_ly",
						{
							pageNo : pageNo
						},
						function(data) {
							var fenye = "";
							var aa = "";
							var lyzzz = data.resultList;
							for ( var i = 0; i < lyzzz.length; i++) {
								//拼接字符串，显示数据
								aa += "<tr style='text-align: center;'>"
										+ "<td>"
										+ lyzzz[i].id
										+ "</td>"
										+ "<td>"
										+ lyzzz[i].number
										+ "</td>"
										+ "<td >"
										+ lyzzz[i].username
										+ "</td>"
										+ "<td><img style='width:40px;height:40px;' id='duanimgsrc' src='<%=path%>/"+lyzzz[i].dansrc+"'></td>"
										+ "<td><a href=''>删除</a><a href='<%=path%>/QueryUserByIdSerlet?id="+lyzzz[i].id+"'>修改</a></td>"
										+ "</tr>" + "<tr>";
							}

							//分页显示
							fenye += "<a href='javascript:;' onclick='ajaxShow(1)'>首页</a>"
									+ "<a href='javascript:;' onclick='ajaxShow("
									+ [ (data.pageNo) - 1 ]
									+ ")'>上一页</a>"
									+ "<a href='javascript:;' onclick='ajaxShow("
									+ [ (data.pageNo) + 1 ]
									+ ")'>下一页</a>"
									+ "<a href='javascript:;' onclick='ajaxShow("
									+ data.totalPage + ")'>末页</a>";

							$("#userInfo").html(aa);
							$("#fenyeDiv").html(fenye);
						}, "json");
	};
</script>
</head>

<body>
	<div class="mentClassify-ly">
		<div class="managementHome1-ly">
			<span>管理首页</span>
		</div>
		<div class="managementHome2-ly">
			<span>添加用户</span>
		</div>
	</div>
	<div class="list-ly">
		<div class="heroList-ly">
			<span>管理首页>></span>
		</div>
		<!--管理首页，添加英雄-->
		<div class="heroTableDiv-ly">
			<form name="from" id="from">
				&nbsp;&nbsp;&nbsp;请输入用户名或者账号：<input type="text" name="condition-ly"
					id="tiaojian-ly" /><br /> <br /> <input type="submit" value="查询" />
				<table cellspacing="0" class="heroTable-ly">
					<thead>
						<tr>
							<th width="10%">用户id</th>
							<th width="10%">账号</th>
							<th width="10%">用户昵称</th>
							<th width="10%">段位名称</th>
							<th width="10%">操作</th>
						</tr>
					</thead>
					<tbody id="userInfo">

					</tbody>
				</table>
			</form>
			<div id="fenyeDiv"></div>
		</div>
		<!-- 添加用户 -->
		<div class="heroAddDiv-ly">
			<form onsubmit="return check()" method="post"
		action="<%=path %>/HuserAddServlet">
				<table>
					<tr>
						<td>账号:<input id="number" name="number">
						</td>
					</tr>
					<tr>
						<td>用户名:<input id="huserName" name="huserName">
						</td>
					</tr>
					<tr>
						<td><input id="typeid" name="typeid" type="radio" value="1" checked="checked" />用户 <input
							id="typeid" name="typeid" type="radio" value="2" />管理员</td>
					</tr>
					<tr>
						<td>密码:<input id="password" name="password"></input></td>
					</tr>
					<tr>
						<td>确认密码:<input id="passWord" name="passWord"></input></td>
					</tr>
					
				</table>
				<input type="submit" value="提交" />
			</form>
		</div>
	</div>
</body>
</html>
