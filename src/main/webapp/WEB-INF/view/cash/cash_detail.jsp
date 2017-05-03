<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1" />
	<link href="/css/mybase.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="/js/common/jquery/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="/js/common/layui.js"></script>
	<style type="text/css">
		.tbg{background: url("../images/jdbg.png") center no-repeat;background-position: 50% 0px;background-size: 100%; height: 100%;width: 100%;}
		.hbh img{width:19em;}
		.hb_list{padding-left:30px;padding-right:30px;}
		.hb_list p{color: #FFF;}
        .op{color: #FFF;line-height: 35px;}
        .aDIV a{color:red;border: 1px solid #dddddd;background-color: yellow;padding: 5px;}
	</style>
	<title>个人中心</title>
</head>
<body>
<div class="tbg">
	<div style="height:13em;"></div>
	<div class="hb_list">
		<input value="${balance}" id="accountBalance" type="hidden">
        <div class="op"><div class="opOper">账户余额：${balance}点券</div></div>
        <div class="op"><div class="opOper">可提资产：${balance}元</div></div>
		<div class="op"><div class="opOper">冻结资产：0元</div></div>
		<div class="op aDIV"><a href="javascript:tixian();">确认转出</a></div>
	</div>

	<div class="hb_list">
		<p>1、每次最小转出10元，每次最多转出5万元</p>
		<p>2、每天最多转4次，每日最多转出20万元</p>
		<p>3、您在平台上转出资金时，第三方支付公司会收取相应的交易手续费，该笔费用目前由本公司承担。</p>
	</div>
</div>
<jsp:include page="../common/bottom.jsp"></jsp:include>
<script type="text/javascript">
	function tixian() {
		var balance = $("#accountBalance").val();
		if(balance<10){
			alert("提现不能少于10点券！");
		}else{
			location.href="/cash/addCash.html";
		}
	}
</script>
</body>
</html>
