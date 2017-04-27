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
	<link href="css/mybase.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
		.emwz{width:100%;margin-left: auto;margin-right: auto;    text-align: center;}
		.tbg{background: url("./images/jdbg.png") center no-repeat;background-position: 50% 0px;background-size: 100%; height: 100%;width: 100%;}
		.hbh{text-align: center;height: 10em;float: left;}
		.hbh img{width: 8em;}
		.tishi{display: flex;margin-top: 6em;float: right;background-color: #000;color: #FFF;padding: 5px 15px;filter:alpha(opacity=70);-moz-opacity:0.7;opacity:0.7;}
		.tishi a{color: #FFF;text-decoration: none;}
		.gdgg{    background-color: #000;
			color: #FFF;
			padding: 5px 15px;
			width: 88%;
			margin-left: auto;
			margin-right: auto;
			filter: alpha(opacity=70);
			-moz-opacity: 0.7;
			opacity: 0.7;    height: 20px;
			line-height: 20px;}
	</style>
	<title>首页</title>
</head>
<body>
<div class="tishi" style="margin-top:2em; float: left;"><a href="javascript:void(0);">ID：${user.id}</a></div>
<div class="tishi" style="margin-top:4em;"><a href="javascript:void(0);">推广赚钱</a></div>
<div class="tbg">
	<div style="height:8em;">
	</div>
	<div class="gdgg"><marquee behavior="scroll" contenteditable="true" onstart="this.firstChild.innerHTML+=this.firstChild.innerHTML;" scrollamount="3">公告：平台免费代理。推广的用户每交易一次，您将收到一笔佣金，最小1元，最高10元！</marquee></div>
	<div style="height:1em;">
	</div>
	<div class="emwz">
		<div style="width: 18em;  margin-left: auto;   margin-right: auto;">
			<div class="hbh" style="margin-right: 2em;">
				<a href="pay/test.html?attach=10yuan&totalFee=10"><img src="./images/btn/pay_10.png" /></a>
			</div>
			<div class="hbh">
				<a href="pay/test.html?attach=20yuan&totalFee=20"><img src="./images/btn/pay_20.png" /></a>
			</div>
			<div class="clear"></div>
			<div class="hbh" style="margin-right: 2em;">
				<a href="pay/test.html?attach=50yuan&totalFee=50"><img src="./images/btn/pay_50.png" /></a>
			</div>
			<div class="hbh">
				<a href="pay/test.html?attach=99yuan&totalFee=99"><img src="./images/btn/pay_99.png" /></a>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</div>
<jsp:include page="./common/bottom.jsp"></jsp:include>
</body>
</html>
