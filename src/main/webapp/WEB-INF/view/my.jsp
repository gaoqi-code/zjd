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
	<style type="text/css">
		.tbg{background: #d6d6d6 url(/images/my_bg.png) no-repeat 0 top;height:100%;background-size:100%;}
		.top{position: relative;text-align: center;}
		.yuInfo{color: #FFF;}
		.myheader{max-width:100px;max-height:100px;border-radius: 50%; margin: 10px 0px;}
		.hb_list{ margin-top: 65px;}
		.op{height: 40px;line-height: 40px;margin-top: 20px;   }
		.op:after{content: '';clear: both;}
		.opImg{float: left;margin-top: 7px;margin-left: 10px;margin-right: 10px;width: 28px;}
		.opOper{float: left;}
	</style>
	<title>个人中心</title>
</head>
<body>
<div class="tbg">
	<div class="top">
		<img class="myheader" src="/images/portrait.jpg">
		<div class="yuInfo">余额：${balance}元</div>
	</div>
	<div class="hb_list">
		<div class="op"><div class="opImg"><img src="/images/icon/cz.png" /></div><div class="opOper"><a href="/pay/toChongzhi.html">我要充值</a></div></div>
		<div class="op"><div class="opImg"><img src="/images/icon/tx.png" /></div><div class="opOper">我要提现</div></div>
	</div>
</div>
<jsp:include page="./common/bottom.jsp"></jsp:include>
</body>
</html>