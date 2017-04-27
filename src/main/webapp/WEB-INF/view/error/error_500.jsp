<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>好友饭</title>
    <link rel="stylesheet" type="text/css" href="css/mybase.css">
    <style type="text/css">
    	.errorContent{width:731px;height: 426px;position:relative; background-image: url('images/error/error_500.jpg');margin:60px auto}
    	.errorContent>a{position: absolute;right: 125px;bottom: 125px;font-size: 30px;}
    	.errorContent>a:HOVER {background-color: #c40000;color: #FFF;}
    </style>
</head>
<body style="background-color: #FFF;">
<div>
    500
<div class="errorContent">
<a href="javascript:history.go(-1);" >返回上一页</a>
</div>
</div>
</body>
</html>