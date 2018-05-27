<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.henrybear.bean.Project"%>
<%
	Project project =(Project) request.getAttribute("project");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改</title>
<script language="javascript"
	src="http://libs.baidu.com/jquery/1.7.2/jquery.min.js"></script>
</head>
<script type="text/javascript">

var arrs = ['id','sequence','name','cuscom','customer','custel','cusemail','customer1','custel1','cusemail1','price','rcvmoney','signdate','startdate','enddate','salesmano','salesman','designmano','designman','makermano','maker','contract','qualitycost','bak','bak1','bak2','bak3','bak4','bak5','bak6'];
	var maintainArrs = ['sequence','name','cuscom','customer','custel','cusemail','customer1','custel1','cusemail1','price','rcvmoney','signdate','startdate','enddate','salesmano','salesman','designmano','designman','makermano','maker','contract','qualitycost'];
	var param = {};
	var dic = {
			id:"",
			sequence:"工程编号",
			name:"名称",
			cuscom:"客户公司名",
			customer:"客户联系人",
			custel:"客户联系人号码",
			cusemail:"客户联系人邮箱",
			customer1:"客户联系人1",
			custel1:"客户联系人1号码",
			cusemail1:"客户联系人1邮箱",
			price:"工程总价",
			rcvmoney:"已收金额",
			signdate:"签订日期",
			startdate:"启动日期",
			enddate:"截至日期",
			salesmano:"销售人员工号",
			salesman:"销售人员姓名",
			designmano:"设计人员工号",
			designman:"设计人员姓名",
			makermano:"制造人员工号",
			maker:"制造人员姓名",
			contract:"合同名",
			qualitycost:"质量费用",
			bak:"",
			bak1:"",
			bak2:"",
			bak3:"",
			bak4:"",
			bak5:"",
			bak6:""
	};

	var types = {
			sequence:"text",
			name:"text",
			cuscom:"text",
			customer:"text",
			custel:"text",
			cusemail:"text",
			customer1:"text",
			custel1:"text",
			cusemail1:"text",
			price:"text",
			rcvmoney:"text",
			signdate:"date",
			startdate:"date",
			enddate:"date",
			salesmano:"text",
			salesman:"text",
			designmano:"text",
			designman:"text",
			makermano:"text",
			maker:"text",
			qualitycost:"text"
	};

	$(document).ready(function() {
		loading();
		/* alert(getCookie("account")); */
		/* $("#serial").attr("disabled",true); */
	});
	function loading() {
		var t = "<table border='1' style='border-collapse: collapse;'><tr align='center'><th></th><th>修改前</th><th>修改后</th></tr>";
		var t1;
		/* debugger; */
		var result = <%=project.toJson() %>;
		for (var i = 0; i < maintainArrs.length; i++) {
			t1 += "<tr><td>"+ dic[maintainArrs[i]] + "</td>"
			+"<td><input type='"+types[maintainArrs[i]]+"' value='"+result[maintainArrs[i]]+"' disabled='true'></td>"
			+"<td><input type='"+types[maintainArrs[i]]+"' id='"+maintainArrs[i]+"' value='"+result[maintainArrs[i]]+"'></td>"
			+"</tr>";
		}
		t += t1
				+ "<tr><td align='center' colspan='3'><input type='button' value='提交' onclick='onSubmit()'>&nbsp;&nbsp;<input type='button' value='重置' onclick='reSet()'></td></tr></table>"
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
		
		$.ajax("${pageContext.request.contextPath}/project/mod",// 发送请求的URL字符串。
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
						window.location.href="${pageContext.request.contextPath}/project/search";
				   }else{
					   alert(data.message);
						window.location.href="${pageContext.request.contextPath}/project/search";
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

	欢迎【${sessionScope.user.username }】
<a href="${pageContext.request.contextPath}/main">主页</a>
<a href="${pageContext.request.contextPath}/user/logout">注销</a>
	<fieldset>
		<legend>修改</legend>
		<div id="main" align="center"></div>
	</fieldset>
</body>
</html>