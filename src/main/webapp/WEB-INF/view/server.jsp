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
		.emwz{width:100%;text-align: center;margin-left: auto;margin-right: auto;}
		.tbg{background: url("./images/jdbg.png") center no-repeat;background-position: 50% 0px;background-size: 100%; height: 100%;width: 100%;}
		.hbh img{width:19em;}
	</style>
	<title>首页</title>
</head>
<body>
<div class="tbg">
	<div style="height:13em;">

	</div>
	<div style="height:2em;text-align: center;">
		在线客服为您服务
	</div>
	<div class="emwz">
		<img style="width: 12em;" src="images/s_e/1.png">
	</div>
</div>
<jsp:include page="./common/bottom.jsp"></jsp:include>
</body>
</html>
