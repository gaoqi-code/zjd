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
    <title>投诉</title>
    <link href="css/mybase.css" rel="stylesheet" type="text/css" />
    <style>
        .accusation-title{width: 100%;line-height:35px;height:35px;background-color: #f2f2f2;padding-top: 10px;padding-bottom: 10px;}
        .accusation-title span{display:inline-block;margin-left:5px;}
        .accusation{width: 100%;}
        .accusation ul{margin-left: auto;margin-right:auto;width: 90%;}
        .accusation li{ border-bottom: solid darkgrey 1px;padding:10px 6px;list-style: none;}
        .accusation a{text-decoration: none; }
    </style>
</head>
<body>
<div class="accusation-title"><span>请选择投诉原因</span></div>
<div class="accusation">
    <ul>
        <li>&#xe617;&nbsp;<a data-id="1" href="nologin/toAccusation2/101.html" class="accType">欺诈</a></li>
        <li>&#xe617;&nbsp;<a data-id="1" href="nologin/toAccusation2/102.html" class="accType">色情</a></li>
        <li>&#xe617;&nbsp;<a data-id="1" href="nologin/toAccusation2/103.html" class="accType">诱导行为</a></li>
        <li>&#xe617;&nbsp;<a data-id="1" href="nologin/toAccusation2/103.html" class="accType">不实信息</a></li>
        <li>&#xe617;&nbsp;<a data-id="1" href="nologin/toAccusation2/103.html" class="accType">违法犯罪</a></li>
        <li>&#xe617;&nbsp;<a data-id="1" href="nologin/toAccusation2/103.html" class="accType">骚扰</a></li>
        <li>&#xe617;&nbsp;<a data-id="1" href="nologin/toAccusation2/103.html" class="accType">违规声明原创</a></li>
        <li>&#xe617;&nbsp;<a data-id="1" href="nologin/toAccusation2/103.html" class="accType">未经授权的文章内容</a></li>
        <li>&#xe617;&nbsp;<a data-id="1" href="nologin/toAccusation2/103.html" class="accType">侵权（冒充他人、侵犯名誉等）</a></li>
        <li>&#xe617;&nbsp;<a data-id="1" href="nologin/toAccusation2/103.html" class="accType">其他</a></li>
    </ul>
</div>
</body>
</html>
