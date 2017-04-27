<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<head>
	<base href="<%=basePath%>">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1" />
	<title>确认支付</title>
	<link href="css/mybase.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/common/jquery/jquery-1.9.1.js"></script>
	<style>
		.payTitle{text-align: center;}
		.content{text-align: center;}
		.contentdesc{margin:10px;text-align: center;font-size: 16px;}
	</style>
</head>
<body>

<div style="text-align: center">
	<input type="hidden" value="${orderId}" id="orderId">
	<input type="hidden" value="${orderNo}" id="orderNo">
</div>

<div class="payTitle"><h2>尊敬的用户</h2></div></div>
<div class="content">
	<div class="contentdesc">您将支付<span style="color: red;">${totalFee}</span>元</div>
	<form action="pay/confirmPay/${sign}.html">
		<input type="hidden" value="${orderId}" name="orderId">
		<input type="hidden" value="${orderNo}" name="orderNo">
		<input type="hidden" value="${totalFee}" name="totalFee">
		<input class="layui-btn" type="submit"  value="确认">
	</form>
</div>

</body>
</html>
