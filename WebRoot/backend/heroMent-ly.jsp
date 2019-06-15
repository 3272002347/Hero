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

<title>My JSP 'heroMentCss-ly.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="statics/css/heroMentCss-ly.css">

<script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
 $(function(){
	gzxzz(1);
	
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
		var heroname= document.getElementById("heroname");
		var herostory = document.getElementById("herostory");
		var herotypeid = document.getElementById("herotypeid");
		var price = document.getElementById("price");
		var imgsrc = document.getElementById("imgsrc").value;
		if (heroname.value == "") {
			alert("英雄名称不能为空！！");
			return false;
		}else if (herostory.value == "") {
			alert("英雄故事不能为空！！");
			return false;
		} else if (herotypeid.value == "") {
			alert("英雄类型不能为空！！");
			return false;
		} else if (price.value == "") {
			alert("英雄价格不能为空！！");
			return false;
		}else if (imgsrc.length == 0||imgsrc.length == null) {
			alert("英雄图标不能为空！！");
			return false;
		}else{
			alert("验证通过");
			return true;
		}
	}

 function gzxzz(pageNo){
	  $.post("<%=path%>/HeroListServlet_ly",{pageNo:pageNo},function(data){
		  var fenye="";
		  var aa="";
		  var lyzzz=data.resultList;
		  for(var i=0;i<lyzzz.length;i++){
			  aa+="<tr style='text-align: center;'>"
			  +"<td >"+lyzzz[i].id+"</td>"
			  +"<td>"+lyzzz[i].heroname+"</td>"
			  +"<td><img style='width:40px;height:40px;' id='heroimgsrc' src='"+lyzzz[i].imgsrc+"'></td>"
			  +"<td>"+lyzzz[i].htypename+"</td>"
			  +"<td>"+lyzzz[i].price+"</td>"
			  +"<td>"+lyzzz[i].viedoSrc+"</td>"
			  +"<td><a href=''>删除</a><a href='<%=path%>/QueryHeroByIdServlet?id="+lyzzz[i].id+"'>修改</a></td>"
			  +"</tr>";
		  }
		//分页显示
		  fenye+="<a href='javascript:;' onclick='gzxzz(1)'>首页</a>"
		  	  +"<a href='javascript:;' onclick='gzxzz("+[(data.pageNo)-1]+")'>上一页</a>"
		  	  +"<a href='javascript:;' onclick='gzxzz("+[(data.pageNo)+1]+")'>下一页</a>"
		  	  +"<a href='javascript:;' onclick='gzxzz("+data.totalPage+")'>末页</a>";
		  $("#forItem").html(aa);
		  $("#fenyeDiv").html(fenye);
	  },"json")
 };
 
 function deleteHero(heroid){
	 $.get("<%=path%>/HeroDeleteServlet", {
			heroid : heroid
		}, function(data) {
			gzxzz(1);
		})
	};
</script>
</head>

<body>
	<div class="mentClassify-ly">
		<div class="managementHome1-ly">
			<span>管理首页</span>
		</div>
		<div class="managementHome2-ly">
			<span>添加英雄</span>
		</div>
	</div>
	<div class="list-ly">
		<div class="heroList-ly">
			<span>管理首页>></span>
		</div>
		<!--管理首页，添加英雄-->
		<div class="heroTableDiv-ly">
			<form>
				<table cellspacing="0" class="heroTable-ly">
					<thead>
						<tr>
							<th width="10%">英雄id</th>
							<th width="10%">英雄名称</th>
							<th width="10%">英雄图标</th>
							<th width="10%">英雄类型</th>
							<th width="10%">英雄价格</th>
							<th width="10%">视频地址</th>
							<th width="10%">操作</th>
						</tr>
					</thead>
					<tbody id="forItem">
					</tbody>
				</table>
			</form>
			<div id="fenyeDiv"></div>
		</div>
		<!--添加英雄-->
		<div class="heroAddDiv-ly">
			<form onsubmit="return check()" method="post"
				action="<%=path%>/HeroAddServlet">
				<table class="heroAddTable-ly">
					<tr>
						<td>*请输入英雄名称<input type="text" id="heroname" name="heroname" />
						</td>
					</tr>
					<tr>
						<td>*请输入英雄故事<textarea id="herostory" name="herostory" /></textarea>
						</td>
						<br />
					</tr>
					<tr>
						<td>*请输入英雄类型<select id="herotypeid" name="herotypeid">
								<option value="0">--请选择--</option>
								<option value="1">战士</option>
								<option value="2">法师</option>
								<option value="3">坦克</option>
								<option value="4">刺客</option>
								<option value="5">射手</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>*请输入英雄价格<input type="text" id="price" name="price" />
						</td>
					</tr>
					<tr>
						<td>*请输入图标地址<input type="file" id="imgsrc" name="imgsrc"><br />
					</tr>
					<tr>
						<td>*请输入视频地址<input type="file" id="viedoSrc" name="viedoSrc"><br />
					</tr>
				</table>
				<input type="submit" value="提交">
			</form>
		</div>
	</div>

</body>
</html>
