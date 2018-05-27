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
var arrs = ['id','sequence','name','cuscom','customer','custel','cusemail','customer1','custel1','cusemail1','price','rcvmoney','signdate','startdate','enddate','salesmano','salesman','designmano','designman','makermano','maker','contract','qualitycost','bak','bak1','bak2','bak3','bak4','bak5','bak6'];
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
var mainConfig = ['sequence','name','cuscom','customer','custel','cusemail','customer1','custel1','cusemail1','price','rcvmoney','signdate','startdate','enddate','salesmano','salesman','designmano','designman','makermano','maker','qualitycost'];
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

var values = {
		sequence:"",
		name:"",
		cuscom:"",
		customer:"",
		custel:"",
		cusemail:"",
		customer1:"",
		custel1:"",
		cusemail1:"",
		price:"",
		rcvmoney:"",
		signdate:"<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %>",
		startdate:"<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %>",
		enddate:"<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %>",
		salesmano:"",
		salesman:"",
		designmano:"",
		designman:"",
		makermano:"",
		maker:"",
		qualitycost:""
	};
function init(){
	var str = "<fieldset><legend>新增</legend><table border='1' style='border-collapse: collapse;'>";
	for(var i=0;i<mainConfig.length;i++){
		/* str += "<tr><td align=\"right\"> "+dic[arrs[i]]+":</td><td align=\"left\"><input type=\"text\" id=\""+arrs[i]+"\" name=\""+arrs[i]+"\" style=\"width: 200px;\" /></td>	</tr>" */
		str += "<tr><td align=\"right\"> "+dic[mainConfig[i]]+":</td><td align=\"left\"><input type='"+types[mainConfig[i]]+"' id=\""+mainConfig[i]+"\" name=\""+mainConfig[i]+"\" style=\"width: 200px;\" value='"+values[mainConfig[i]]+"'/></td>	</tr>"
	}
	str += "<tr><td colspan=\"2\" align=\"center\"><input type=\"button\" id=\"btn\" name=\"btn\" value=\"新增\" style=\"width: 100px;\" /></td>	</tr></table></fieldset>";
	$("#main").html(str);
}

		$(function(){
			$("#btn").click(function(){
				var param="{";
				for(var i=0;i<mainConfig.length;i++){
					if(mainConfig.length-i>1){
						param +="\""+mainConfig[i]+"\":\""+$("#"+mainConfig[i]).val()+"\","
						}else{
							param +="\""+mainConfig[i]+"\":\""+$("#"+mainConfig[i]).val()+"\"";
						}
				}
				param += "}";
				
				$.ajax("${pageContext.request.contextPath}/project/add",// 发送请求的URL字符串。
						{
						dataType : "json", // 预期服务器返回的数据类型。
			   			type : "post", //  请求方式 POST或GET
					   contentType:"application/json", //  发送信息至服务器时的内容编码类型
					   // 发送到服务器的数据。
					   data: param,
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
									location.href ="${pageContext.request.contextPath}/project/add";
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
	欢迎【${sessionScope.user.username }】
<a href="${pageContext.request.contextPath}/main">主页</a>
<a href="${pageContext.request.contextPath}/user/logout">注销</a>
<div id="main" align="center"></div>
</body>
</html>