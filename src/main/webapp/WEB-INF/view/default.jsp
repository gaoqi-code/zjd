<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta name="Generator" content="EditPlus®">
    <meta name="Keywords" content="">
    <meta name="Description" content="">
    <meta name="viewport" content="width=device-width,initial-scale=1" />
    <script type="text/javascript" src="js/common/jquery/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="js/common/layer.js"></script>
    <link href="css/mybase.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
        .defaultPageCss{text-align: center;}
    </style>
    <title>首页</title>
</head>
<body>

<div class="defaultPageCss">
    <div style="height: 3em;"></div>
    <div><img src="./js/common/css/modules/layer/default/loading-0.gif"></div>
    <div>登录过期，正在重新登录...</div>
</div>
<script>
//    location.href="http://test.open580.com/toUser/0/0.html";
location.href="http://192.168.1.102/toUser/0/0.html";
</script>
</body>
</html>
