<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'equipMent-ly.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0‘">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  <script type="text/javascript" src="<%=path %>/statics/js/jquery-1.12.4.js"></script>
  <script type="text/javascript" src="<%=path %>/statics/js/equipMentJs-ly.js"></script>
  <link rel="stylesheet" href="<%=path %>/statics/css/equipMentCss-ly.css" type="text/css"></link>
  
  </head>  
   <script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
 <script type="text/javascript" >
 $(function(){
	 gzxzz(1);
	 
	 $(".mentClassify-ly div").click(function(){
			$(this).parent().children().css("background-color","whitesmoke");
			$(this).css("background-color","lightsteelblue");
			var neirong=$(this).children().text();
			$(".heroList-ly span").text(neirong+">");
		});
		
		$(".managementHome1-ly").click(function(){
			$(".heroAddDiv-ly").css("display","none");
		});
		
		$(".managementHome2-ly").click(function(){
			$(".heroAddDiv-ly").css("display","block");
		});
		
		
	});
 function gzxzz(pageNo){
	  $.post("<%=path%>/EquipAjaxServlet",{pageNo:pageNo},function(data){
		  var fenye="";
		  var aa="";
		  var lyzzz=data.resultList;
		  for(var i=0;i<lyzzz.length;i++){
			  aa+="<tr style='text-align: center;'>"
			  +"<td >"+lyzzz[i].id+"</td>"
			  +"<td>"+lyzzz[i].equipment+"</td>"
			  +"<td>"+lyzzz[i].etypename+"</td>"
			  +"<td>"+lyzzz[i].esrcid+"</td>"
			  +"<td><a href=''>删除</a><a href='<%=path%>/QueryEquipByIdServlet?id="+lyzzz[i].id+"'>修改</a></td>"
			  +"</tr>";
		  }
		//分页显示
		  fenye+="<a href='javascript:;' onclick='gzxzz(1)'>首页</a>"
		  	  +"<a href='javascript:;' onclick='gzxzz("+[(data.pageNo)-1]+")'>上一页</a>"
		  	  +"<a href='javascript:;' onclick='gzxzz("+[(data.pageNo)+1]+")'>下一页</a>"
		  	  +"<a href='javascript:;' onclick='gzxzz("+data.totalPage+")'>末页</a>";
		  	  
		  $("#forItem").html(aa);
		  $("#fenyeDiv").html(fenye);
	  },"json");
 };
  </script>
  <body>
    <div class="mentClassify-ly">
			<div class="managementHome1-ly">
				<span>管理首页</span>
			</div>
		</div>
		<div class="list-ly">
			<div class="heroList-ly"><span>管理首页</span></div>
			<!--管理首页，添加装备-->
			<div class="heroTableDiv-ly">
				<form>
					<table cellspacing="0" class="heroTable-ly">
						<thead>
							<tr>
								<th width="10%">装备id</th>
								<th width="10%">装备名称</th>
								<th width="10%">装备类型</th>
								<th width="10%">装备图片</th>
								<th width="10%">操作</th>
							</tr>
						</thead>
							<tbody id="forItem">
							</tbody>
					</table>
				</form>
				<div id="fenyeDiv">	
				</div>
				
				<!--添加装备-->
		<div class="heroAddDiv-ly">
			<form onsubmit="return check()" method="post"
				action="<%=path%>/EquipAddServlet">
				<table class="heroAddTable-ly">
					<tr>
						<td>*请输入装备名称<input type="text" id="equipment" name="equipment" />
						</td>
					</tr>
					<tr>
						<td>*请输入装备类型<input type="text" id="etypename" name="etypename" />
						</td>
					</tr>
					<tr>
						<td>*请输入装备图片<input type="text" id="esrcid" name="esrcid" />					
						</td>
					</tr>
				</table>
				<input type="submit" value="提交">
			</form>
			</div>
		</div>
  </body>
</html>
