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
    <meta charset="utf-8">
    <meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no" name="viewport">
    <meta content="yes" name="apple-mobile-web-app-capable">
    <meta content="black" name="apple-mobile-web-app-status-bar-style">
    <meta content="telephone=no" name="format-detection">
    <meta content="email=no" name="format-detection">
    <title>提示页面</title>
    <link rel="stylesheet" type="text/css" href="css/mybase.css">
    <style type="text/css">
        .errorContent{text-align: center;padding-top: 10em;}
        .errorContent>a{padding: 5px;}
        .errorContent>a:HOVER {background-color: #c40000;color: #FFF;}
    </style>
</head>
<body style="background-color: #FFF;">
<div>
    <div class="errorContent">
        <c:if test="${code == 1000}">
            您的账户余额不足，请<a href="/pay/toChongzhi.html" >充值</a>。
        </c:if>
        <c:if test="${code == 2001}">
            系统检测到您的订单异常，请联系客服！
        </c:if>
        <a href="javascript:history.go(-1);" >返回上一页</a>
    </div>
</div>
</body>
</html>