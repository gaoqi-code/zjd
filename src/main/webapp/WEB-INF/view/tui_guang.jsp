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
    <link href="css/mybase.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/common/jquery/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="js/common/ewm/jquery.qrcode.js"></script>
    <script type="text/javascript" src="js/common/ewm/qrcode.js"></script>
    <style type="text/css">
        .emwz{width: 10em;margin-left: auto;margin-right: auto;}
        .fxHeader{text-align: center;color: #ffffff;}
        .fxHeader img{width:15em; margin-bottom: 5px;}
        .tg_font img{width:96%; margin-bottom: 5px;}
        .tbg{background: url("./images/fenxiangbg.png") center no-repeat;background-position: 50% 0px;background-size: 100%; width: 100%; background-color: #ce3911;}
        .fxFoot{text-align: center;color: #ffffff;margin: 0 5px;height: 20em;}
    </style>
    <title>首页</title>
</head>
<body>
<div class="tbg">
    <div style="height:1em;"></div>
    <div class="fxHeader"><img src="./images/header.png"></div>
    <div class="fxHeader tg_font"><img src="./images/tg_font.png"></div>
    <div class="emwz_contant">
        <a id="a_url" href="javascript:void(0);"><div class="emwz" id="emwz"></div>
        </a>
    </div>
    <div class="fxFoot">
        <p>推广二维码，一起拿佣金。</p>
        <p>最高获得10元！！！</p>
    </div>
    <div class="clear"></div>
</div>
<script>
    $(function(){
        var ewmurl = "http://"+window.location.hostname+"/toUser/${userId}/${level}.html";
        $("#a_url").attr("href",ewmurl);
        $('#emwz').qrcode({
            width: 160, //宽度
            height:160, //高度
            text: ewmurl //任意内容
        });
    });
</script>
<jsp:include page="./common/bottom.jsp"></jsp:include>
</body>
</html>
