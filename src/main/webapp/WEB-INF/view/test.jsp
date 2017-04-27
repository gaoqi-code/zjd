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
        .errorContent{text-align: center;}
        .errorContent>a{}
        .errorContent>a:HOVER {background-color: #c40000;color: #FFF;}
    </style>
</head>
<body style="background-color: #FFF;">
<div style="min-height: 300px;">
    <div class="errorContent">
        <c:if test="${code == 1000}">
            您的账户余额不足，请充值。
        </c:if>
        <c:if test="${code == 2001}">
            系统检测到您的订单异常，请联系客服！
        </c:if>
        <a href="javascript:history.go(-1);" >返回上一页</a>
    </div>
</div>
</body>
</html>