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
        .tbg{background: url("../images/jdbg.png") center no-repeat;background-position: 50% 0px;background-size: 100%; height: 100%;width: 100%;}
        .errorContent{text-align: center;padding-top: 10em;}
        .errorContent>a{padding: 5px;}
        .errorContent>a:HOVER {background-color: #c40000;color: #FFF;}
    </style>
</head>
<body style="background-color: #FFF;">
<div class="tbg">
    <div style="height:9em;"></div>
    <div class="errorContent">
        <c:if test="${code == 1000}">
            抱歉，您的点券不足，请<a href="/pay/toChongzhi.html" >充值</a>后砸蛋！
        </c:if>
        <c:if test="${code == 2001}">
            系统检测到您的订单异常，请联系客服！
        </c:if>
        <p>剩余点券：${balance}</p>
        <a href="/pay/toChongzhi.html" >立即充值</a>
        <a href="javascript:history.go(-1);" >返回上一页</a>
        <p>注：充值1点券=1积分。点券可提现，1点券=1元</p>
        <p>提现2小时内到账。</p>
    </div>
</div>
<jsp:include page="../common/bottom.jsp"></jsp:include>
</body>
</html>