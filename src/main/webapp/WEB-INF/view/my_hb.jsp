<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<head>
	<base href="<%=basePath%>">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1" />
	<link href="css/mybase.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/common/jquery/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="js/common/layui.js"></script>
	<style type="text/css">
		.emwz{width:100%;text-align: center;margin-left: auto;margin-right: auto;}
		.tbg{background: url("./images/jdbg.png") center no-repeat;background-position: 50% 0px;background-size: 100%; height: 100%;width: 100%;}
		.hb_list{height:2em;text-align: center;}
		.hb_list table{width:90%;}
		.hbh img{width:18em;}
	</style>
	<title>首页</title>
</head>
<body>
<div class="tbg">
	<div style="height:13em;">

	</div>
	<div class="hb_list">
		<table>
			<tr>
				<th>获得时间</th><th>金额</th>
			</tr>
			<c:forEach var="hb" items="${hbList}">
			<tr>
			<td><fmt:formatDate value="${hb.addTime}" pattern="yyyy-MM-dd HH:mm" /> </td><td>${hb.totalFee}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</div>
<jsp:include page="./common/bottom.jsp"></jsp:include>
<script type="text/javascript">
	$(function () {
		setTimeout("ajaxstatus()", 500);
	});
	layui.define(['layer', 'form'], function(exports){
		var layer = layui.layer;
	});
	function ajaxstatus() {
		var url = "pay/getUserOrderInfo.json";
		$.get(url,{},function(data){
					if(data.code==200){
						var orderId = data.obj.id;
						var orderNo = data.obj.orderNo;
						var tsContent = '<div style="background-color: #FFF;text-align: center;padding: 2em;"><a href="pay/toChb.html?orderId='+orderId+'&orderNo='+orderNo+'">您有一个红包还未打开</a></div>';
						layer.open({
							type: 1
							,title: "提示信息" //不显示标题栏
							,closeBtn: false
							,area: '15em;'
							,shade: 0.3
							,id: 'LAY_layuipro2' //设定一个id，防止重复弹出
							,resize: false
							,btnAlign: 'c'
							,content: tsContent
						});
						return;
					}
				}
		);
	}
</script>
</body>
</html>
