<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>在Form表单中使用验证码</title>
		<script type="text/javascript">
		//刷新验证码
		function changeImg(){
			var str = '${pageContext.request.contextPath}/servlet/DrawImage?t='+Math.random();
			//在末尾加Math.random()的作用：
			//如果两次请求地址一样，服务器只会处理第一次请求，第二次请求返回内容和第一次一样。或者说如果地址相同，第一次请求时，将自动缓存，导致第二次不会重复请求了。Math.random()是调用javascript语法中的数学函数，能够产生随机数。
			//末尾加Math.random()使每次请求地址不相同，服务器每次都去做不同的响应。也可以使用new date()时间戳的形式作为参数传递。
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