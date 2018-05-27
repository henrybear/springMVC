<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.henrybear.bean.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	User user = (User) request.getAttribute("user");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除</title>
<script language="javascript"
	src="http://libs.baidu.com/jquery/1.7.2/jquery.min.js"></script>
</head>
<script type="text/javascript">

	var arrs = ["id","loginname","password","username","phone","address","bak","bak1","bak2","bak3"];
	var maintainArrs = ["loginname","password","username","phone","address","bak","bak1","bak2","bak3"];
	var param = {
			id:"",
			loginname:"",
			password:"",
			username:"",
			phone:"",
			address:"",
			bak:"",
			bak1:"",
			bak2:"",
			bak3:""
	};
	var dic = {
			id:"编号",
			loginname:"登录帐号",
			password:"密码",
			username:"用户名",
			phone:"电话号码",
			address:"地址",
			bak:"bak",
			bak1:"bak1",
			bak2:"bak2",
			bak3:"bak3"
	};

	var types = {
			id:"text",
			loginname:"text",
			password:"password",
			username:"text",
			phone:"text",
			address:"text",
			bak:"date",
			bak1:"date",
			bak2:"text",
			bak3:"date"
	};

	$(document).ready(function() {
		loading();
		/* alert(getCookie("account")); */
		/* $("#serial").attr("disabled",true); */
	});
	function loading() {
		var t = "<table border='1' style='border-collapse: collapse;'><tr align='center'><th></th><th>修改前</th></tr>";
		var t1;
		var result = <%=user.toJson()%>;
		for (var i = 0; i < maintainArrs.length; i++) {
			t1 += "<tr><td>"+ dic[maintainArrs[i]] + "</td>"
			+"<td><input type='"+types[maintainArrs[i]]+"' id='"+maintainArrs[i]+"' value='"+result[maintainArrs[i]]+"' disabled='true'></td>"
			+"</tr>";
		}
		t += t1
				+ "<tr><td align='center' colspan='2'><input type='button' value='提交' onclick='onSubmit()'>&nbsp;&nbsp;<input type='button' value='重置' onclick='reSet()'></td></tr></table>"
		$("#main").html(t);
	}
	
	function reSet(){
		loading();
	}
	
	function onSubmit(){
		var param="{";
		for(var i=0;i<maintainArrs.length;i++){
			if(maintainArrs.length-i>1){
				param +="\""+maintainArrs[i]+"\":\""+$("#"+maintainArrs[i]).val()+"\","
				}else{
					param +="\""+maintainArrs[i]+"\":\""+$("#"+maintainArrs[i]).val()+"\"";
				}
		}
		param += "}";
		/* alert(param); */
		
		$.ajax("${pageContext.request.contextPath}/user/del",// 发送请求的URL字符串。
				{
				dataType : "json", // 预期服务器返回的数据类型。
	   			type : "post", //  请求方式 POST或GET
			   contentType:"application/json", //  发送信息至服务器时的内容编码类型
			   // 发送到服务器的数据。
			   data:param,
			   async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
			   // 请求成功后的回调函数。
			   success :function(data){
				   if(data.status == 0){
					   alert(data.message);
						window.location.href="${pageContext.request.contextPath}/user/search";
				   }else{
					   alert(data.message);
						window.location.href="${pageContext.request.contextPath}/user/search";
				   }
			   },
			   // 请求出错时调用的函数
			   error:function(){
				   alert("数据发送失败");
			   }
		});
	}
	
</script>
<body>
<a href="${pageContext.request.contextPath}/main">主页</a>
<a href="${pageContext.request.contextPath}/user/logout">注销</a>
	<fieldset>
		<legend>修改</legend>
		<div id="main" align="center"></div>
	</fieldset>
</body>
</html>