<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>在Form表单中使用验证码</title>
		<script type="text/javascript">
		//刷新验证码
		function changeImg(){
			var str = '${pageContext.request.contextPath}/servlet/DrawImage?t='+Math.random();
			document.getElementById('validateCodeImg').src=str;
		}
		</script>
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/servlet/CheckServlet" method="post">
			验证码：<input type="text" name="validateCode"/>
			<img src="${pageContext.request.contextPath}/servlet/DrawImage" id="validateCodeImg" onclick="changeImg()">
			<!-- <a href="javascript:void(0)" onclick="changeImg()">看不清，换一张</a> 
			javascript:void(0) 当用户链接时，void(0) 计算为 0，但 Javascript 上没有任何效果
			去掉href 又不能显示超链接了 -->
			<a href="javascript:changeImg()">看不清，换一张</a>
			<br/>
			<input type="submit" value="提交">
		</form>
	</body>
</html>