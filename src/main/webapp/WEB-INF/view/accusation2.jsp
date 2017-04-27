<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no" name="viewport">
    <meta content="yes" name="apple-mobile-web-app-capable">
    <meta content="black" name="apple-mobile-web-app-status-bar-style">
    <meta content="telephone=no" name="format-detection">
    <meta content="email=no" name="format-detection">
    <title>投诉</title>
    <link href="css/mybase.css" rel="stylesheet" type="text/css" />
    <style>
        .accusation-title{width: 100%;line-height:35px;height:35px;background-color: #f2f2f2;padding-top: 10px;padding-bottom: 10px;border-bottom: 1px solid #b6b6b6;}
        .accusation-title span{display:inline-block;margin-left:5px;}
        .accusation{width: 100%;}
        .accusation ul{margin-left: auto;margin-right:auto;width: 90%;}
        .accusation li{ border-bottom: solid darkgrey 1px;padding:10px 6px;list-style: none;}
        .accusation a{text-decoration: none; }
        .layui-btn{padding: 10px;}
    </style>
</head>
<body class="c_center">
<div class="accusation-title"><span>请输入投诉原因</span></div>
<form type="post" action="nologin/addAccusation.html">
    <input name="categoryCode" type="hidden" value="${categoryCode}">
<div class="accusation">
<textarea name="desc" style="width:98%;border:0px;height:100px;border-bottom: 1px solid #b6b6b6;resize: vertical;" placeholder="请输入投诉内容"></textarea>
</div>
<button type="submit" class="layui-btn" style="width: 95%;">确定</button>
</form>
</body>
</html>
