<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加用户</title>
<script language="javascript"
	src="http://libs.baidu.com/jquery/1.7.2/jquery.min.js"></script>
</head>
<script language="javascript">
$(document).ready(function(){
	init();
	$("#id").attr("disabled",true);
});
var arrs = ["id","loginname","password","username","phone","address","bak","bak1","bak2","bak3"];
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
var mainConfig = {
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

var values = {
		id:"",
		loginname:"",
		password:"",
		username:"",
		phone:"",
		address:"",
		bak:"<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %>",
		bak1:"<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %>",
		bak2:"",
		bak3:"<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %>"
};
function init(){
	var str = "<fieldset><legend>新增</legend><table border='1' style='border-collapse: collapse;'>";
	for(var i=0;i<arrs.length;i++){
		/* str += "<tr><td align=\"right\"> "+dic[arrs[i]]+":</td><td align=\"left\"><input type=\"text\" id=\""+arrs[i]+"\" name=\""+arrs[i]+"\" style=\"width: 200px;\" /></td>	</tr>" */
		str += "<tr><td align=\"right\"> "+dic[arrs[i]]+":</td><td align=\"left\"><input type='"+types[arrs[i]]+"' id=\""+arrs[i]+"\" name=\""+arrs[i]+"\" style=\"width: 200px;\" value='"+values[arrs[i]]+"'/></td>	</tr>"
	}
	str += "<tr><td colspan=\"2\" align=\"center\"><input type=\"button\" id=\"btn\" name=\"btn\" value=\"新增\" style=\"width: 100px;\" /></td>	</tr></table></fieldset>";
	$("#main").html(str);
}

		$(function(){
			$("#btn").click(function(){
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
				param.id = $("#id").val();
				param.loginname = $("#loginname").val();
				param.password = $("#password").val();
				param.username = $("#username").val();
				param.phone = $("#phone").val();
				param.address = $("#address").val();
				param.bak = $("#bak").val();
				param.bak1 = $("#bak1").val();
				param.bak2 = $("#bak2").val();
				param.bak3 = $("#bak3").val();
				
				for(var i=0;i<arrs.length;i++){
					mainConfig[arrs[i]] = $("#"+arrs[i]).val();
				}
				/* alert(mainConfig); */
				
				$.ajax("${pageContext.request.contextPath}/user/useradd",// 发送请求的URL字符串。
						{
						dataType : "json", // 预期服务器返回的数据类型。
			   			type : "post", //  请求方式 POST或GET
					   contentType:"application/json", //  发送信息至服务器时的内容编码类型
					   // 发送到服务器的数据。
					   data:JSON.stringify(mainConfig),
					   async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
					   // 请求成功后的回调函数。
					   success :function(msg){
							var flag = msg.flag;
							var retcode = msg.status;
							var retMsg = msg.message;
							/* alert(msg.flag+" "+retcode+" "+retMsg); */ 
							if(retcode == 0){
								var r=confirm(retMsg+"，是否继续添加？");
								if (r==true){
									location.href ="${pageContext.request.contextPath}/user/useradd";
								}
								else{
									location.href ="${pageContext.request.contextPath}/main";
								}
							}else{
								alert("导入失败，"+msg.retMsg);
								location.href ="${pageContext.request.contextPath}/user/useradd";
							}
					   },
					   // 请求出错时调用的函数
					   error:function(){
						   alert("数据发送失败");
					   }
				});
				
			})
		})
	</script>
<body>
<a href="${pageContext.request.contextPath}/main">主页</a>
<a href="${pageContext.request.contextPath}/user/logout">注销</a>
<div id="main" align="center"></div>
</body>
</html>