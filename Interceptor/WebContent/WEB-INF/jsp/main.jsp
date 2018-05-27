<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<style type="text/css">
	table{border-collapse:collapse;border-spacing:0;border-left:1px solid #888;border-top:1px solid #888;background:#efefef;}
	th,td{border-right:1px solid #888;border-bottom:1px solid #888;padding:5px 15px;}
	th{font-weight:bold;background:#ccc;}
</style>
</head>
<body>
<header>
<a href="${pageContext.request.contextPath}/user/useradd">增加用户</a>
<a href="${pageContext.request.contextPath}/user/search">查询用户</a>
<a href="${pageContext.request.contextPath}/user/logout">注销</a>
</header>
<h3>欢迎【${sessionScope.user.username }】</h3>
<div>
	<ul style="list-style-type:none">
		<li><a href="http://192.168.2.214:8080${pageContext.request.contextPath}/project/add">项目新增</a></li>
		<li><a href="http://192.168.2.214:8080${pageContext.request.contextPath}/project/search">项目查询</a></li>
		<li><a href="${pageContext.request.contextPath}/quality">质量跟进</a></li>
		<li><a href="${pageContext.request.contextPath}/cost">费用查询</a></li>
		<li><a href="${pageContext.request.contextPath}/deadline">进度查询</a></li>
	</ul>
</div>

</table>
</body>
</html>