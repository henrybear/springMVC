<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询用户</title>
<script language="javascript"
	src="http://libs.baidu.com/jquery/1.7.2/jquery.min.js"></script>
</head>
<script language="javascript">
$(document).ready(function(){
	init();
});
var params=new Array();
var arrs = ["id","loginname","password","username","phone","address","bak","bak1","bak2","bak3"];
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
var mainConfig = ["id","loginname","password","username","phone","address"];

function init(){
	var str = "<table border='1' style='border-collapse: collapse;'>";
	for(var i=0;i<mainConfig.length;i++){
		str += "<tr><td align=\"right\"> "+dic[mainConfig[i]]+":</td><td align=\"left\"><input type='"+types[mainConfig[i]]+"' id=\""+mainConfig[i]+"\" name=\""+mainConfig[i]+"\" style=\"width: 200px;\" value=''/></td>	</tr>"
	}
	str += "<tr><td colspan=\"2\" align=\"center\"><input type=\"button\" id=\"btn\" name=\"btn\" value=\"查询\" style=\"width: 100px;\" /></td>	</tr></table>";
	$("#main").html(str);
}

function mod(){
	var radios = document.getElementsByName("caozuo");
	for(var i =0;i<radios.length;i++){
		if(radios[i].checked==true){
			var param = params[i];
			window.location.href="${pageContext.request.contextPath}/user/mod?q="+param.loginname;
			return;
		}
	}
	alert("请选择需要修改的项");
}
function del(){
	var radios = document.getElementsByName("caozuo");
	for(var i =0;i<radios.length;i++){
		if(radios[i].checked==true){
			var param = params[i];
			window.location.href="${pageContext.request.contextPath}/user/del?q="+param.loginname;
			return;
		}
	}
	alert("请选择需要删除的项");
}

function optioned(){
	/* alert("hello world"); */
	var radios = document.getElementsByName("caozuo");
	for(var i =0;i<radios.length;i++){
		if(radios[i].checked==true){
			/* alert("hello world"); */
			var obj = document.getElementById("tr"+i);
			obj.style.backgroundColor="gray";
			return;
		}
	}
}


		$(function(){
			$("#btn").click(function(){
				for(var i=0;i<mainConfig.length;i++){
					param[mainConfig[i]] = $("#"+mainConfig[i]).val();
				}
				
				var n = 0;
				/* alert(JSON.stringify(param)); */
				$.ajax("${pageContext.request.contextPath}/user/search",// 发送请求的URL字符串。
						{
						dataType : "json", // 预期服务器返回的数据类型。
			   			type : "post", //  请求方式 POST或GET
					   contentType:"application/json", //  发送信息至服务器时的内容编码类型
					   // 发送到服务器的数据。
					   data:JSON.stringify(param),
					   async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
					   // 请求成功后的回调函数。
					   success :function(data){
						   var listable = "<table border='1' style='border-collapse: collapse;'><tr align='center'>";
						   for(var i=0;i<arrs.length;i++){
							   listable += "<th>"+dic[arrs[i]]+"</th>";
						   }
						   listable += "</tr>";
						   $.each(data,function(){
								n=n+1; 
							   params.push(this);
							  /*  alert(JSON.stringify(this)); */
							   var opt = this;
							   var row = "<tr align='center' id='tr"+n+"'/>";
							   for(var i=0;i<arrs.length;i++){
								   row += "<td>" + opt[arrs[i]]+"</td>";
							   }
							   row += "<td><input type='radio' id='caozuo"+n+"' name='caozuo' value=\""+n+"\" onclick='optioned();'/></td></tr>";
							   listable = listable+row; 
							   
						   })
					        listable = listable +"<tr><td colspan='11' align='center'><input type='button' value='修改' name='mod' id='mod' onclick='mod()' />&nbsp;&nbsp;<input type='button' value='删除' name='del' id='del' onclick='del()' /></td></tr></table></fieldset>";
					        $("#projectlist").html(listable);
					   },
					   // 请求出错时调用的函数
					   error:function(){
						   alert("数据发送失败");
					   }
				});
				
			});
			
			
		})
	</script>
<body>
	<header> 欢迎【${requestScope.user.loginname }】 <a
		href="${pageContext.request.contextPath}/main">主页</a> <a
		href="${pageContext.request.contextPath}/user/logout">注销</a> </header>
	<fieldset>
		<legend>查询</legend>
		<div id="main" align="center"></div>
	</fieldset>
	<fieldset>
		<legend>查询结果</legend>
		<div align="center" id="projectlist"></div>
	</fieldset>
</body>
</html>