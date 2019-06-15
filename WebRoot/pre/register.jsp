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
<title>注册某雄账号</title>
<script type="text/javascript"
	src="<%=path%>/statics/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$(function() {
		$("#my-img").click(function() {
			$("#img-upload").click();
		});
		$("#img-upload").change(
				function() {
					var filePath = $(this).val();
					if (filePath.indexOf("jpg") == -1
							&& filePath.indexOf("png") == -1) {
						alert("上传文件类型有误!");
						return false;
					}
					return change(this, "file-one");
				});

		function change(obj, itemId) {
			var a = URL.createObjectURL(obj.files[0]);
			var urla = obj.files[0];
			$("#my-img").attr("src", URL.createObjectURL(obj.files[0]));
		}

	});
</script>
<link rel="stylesheet" href="<%=path%>/statics/css/register.css"
	type="text/css"></link>
</head>
<body>
	<%@include file="/common/header.jsp"%>
	<div class="main">
		<div class="centerdiv">
			<h1>欢迎注册用户</h1>
			<h3>每一天,乐在沟通</h3>
			<div class="formone">
				<form action="<%=path%>/RegistServlet" method="post"
					enctype="multipart/form-data">
					<input type="text" name="username" placeholder="昵称"><span></span> <br>
					<input type="text" name="number" placeholder="账号"><span></span> <br>
					<input type="password" name="password" placeholder="密码"><span></span> <br>

					<div class="head-img">
						<img src="<%=path%>/statics/images/default.png" id="my-img"
							title="上传头像"> <input type="file" name="file"
							id="img-upload" />
					</div>
					<br> <input type="reset" value="重置"> <input
						class="submit" type="submit" value="提交" />
				</form>
			</div>
		</div>
	</div>
	<%@include file="/common/footer.jsp"%>
</body>
</html>