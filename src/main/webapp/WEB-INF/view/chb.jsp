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
    <title>首页</title>
    <script type="text/javascript" src="js/common/jquery/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="js/common/layui.js"></script>
    <link href="css/mybase.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
        .emwz{width:100%;margin-left: auto;margin-right: auto;}
        .tbg{background: url("./images/jdbg.png") center no-repeat;background-position: 50% 0px;display: inline-block;background-size: 100%; height: 100%;width: 100%;}
        .hbimg img{width:62px;}
        .hbimg a{position: relative;display: inline-block;}
        .hbimg span{position:absolute;top: 2em;left:0px;width: 99%;text-align: center;color:yellow;}
        .hbimg{margin-right:10px;}
        .hbh{width:352px;margin-left:auto;margin-right:auto;margin-bottom: 1em;}
        .zjhb{width:100%;min-height:345px;background:url("../images/jd-k.png") no-repeat center bottom;background-position: 0px 20px; background-size: 100%;}
        #moneyDiv{color:red;font-size: 25px;font-weight:bold;}
        .moneyTishi{color: #035;  font-size: 14px;  margin-top: 5px;margin-bottom: 5px;   padding: 5px;}
        .closeBtn{float:right;width:2em;}
        .layui-layer{background-color:transparent!important;box-shadow:1px 1px 50px rgba(0,0,0,0)!important;}
    </style>
</head>
<body>
<%--<div id="hb1-1" class="hbimg leftD"><a class="chb-c" href="javascript:void(0);">--%>
    <%--<img src="./images/hb1.gif" /></a>--%>
<%--</div>--%>
<div class="tbg">
<div style="height:14em;">
</div>
    <div class="emwz">
        <div class="hbh">
            <div class="hbimg leftD"><a id="hb1" class="chb-c" href="javascript:void(0);"><img src="./images/jd.png" /><span id="m1"></span></a></div>
            <div class="hbimg leftD"><a id="hb2" class="chb-c" href="javascript:void(0);"><img src="./images/jd.png" /><span id="m2"></span></a></div>
            <div class="hbimg leftD"><a id="hb3" class="chb-c" href="javascript:void(0);"><img src="./images/jd.png" /><span id="m3"></span></a></div>
            <div class="hbimg leftD"><a id="hb4" class="chb-c" href="javascript:void(0);"><img src="./images/jd.png" /><span id="m4"></span></a></div>
            <div class="hbimg leftD" style="margin-right: 0px;"><a id="hb5" class="chb-c" href="javascript:void(0);"><img style="margin-right: 0px;" src="./images/jd.png" /><span id="m5"></span></a></div>
            <div class="clear"></div>
        </div>
        <div class="hbh">
            <div class="hbimg leftD"><a id="hb6" class="chb-c" href="javascript:void(0);"><img src="./images/jd.png" /><span id="m6"></span></a></div>
            <div class="hbimg leftD"><a id="hb7" class="chb-c" href="javascript:void(0);"><img src="./images/jd.png" /><span id="m7"></span></a></div>
            <div class="hbimg leftD"><a id="hb8" class="chb-c" href="javascript:void(0);"><img src="./images/jd.png" /><span id="m8"></span></a></div>
            <div class="hbimg leftD"><a id="hb9" class="chb-c" href="javascript:void(0);"><img src="./images/jd.png" /><span id="m9"></span></a></div>
            <div class="hbimg leftD" style="margin-right: 0px;"><a id="hb10" class="chb-c" href="javascript:void(0);"><img style="margin-right: 0px;" src="./images/jd.png" /><span id="m10"></span></a></div>
            <div class="clear"></div>
        </div>
        <div class="hbh">
            <div class="hbimg leftD"><a id="hb11" class="chb-c" href="javascript:void(0);"><img src="./images/jd.png" /><span id="m11"></span></a></div>
            <div class="hbimg leftD"><a id="hb12" class="chb-c" href="javascript:void(0);"><img src="./images/jd.png" /><span id="m12"></span></a></div>
            <div class="hbimg leftD"><a id="hb13" class="chb-c" href="javascript:void(0);"><img src="./images/jd.png" /><span id="m13"></span></a></div>
            <div class="hbimg leftD"><a id="hb14" class="chb-c" href="javascript:void(0);"><img src="./images/jd.png" /><span id="m14"></span></a></div>
            <div class="hbimg leftD" style="margin-right: 0px;"><a id="hb15" class="chb-c" href="javascript:void(0);"><img style="margin-right: 0px;" src="./images/jd.png" /><span id="m15"></span>
            </a></div>
            <div class="clear"></div>
        </div>
        <div></div>
        <div></div>
    </div>
</div>
<script>
    var layer;
    var data = null;
    var currentId = 0;
    var flag = 0;
    $(function(){
        $(".chb-c").click(function(d){
            var layer = layui.layer;
            if(flag!=0){
                return;
            }
            flag++;
            currentId = $(this).attr("id");
            var secret = "";
            $.get("pay/getMoney.json",{"orderId":${orderId}},function(data){
                if(data.code!=200){
                    var tsContent = '<div style="background-color: #FFF;text-align: center;padding: 2em;">'+data.msg+'<div style="margin-top: 3px;"><a href="product.html">继续</a></div></div>';
                    layer.open({
                        type: 1
                        ,title: false //不显示标题栏
                        ,closeBtn: false
                        ,area: '15em;'
                        ,shade: 0.3
                        ,id: 'LAY_layuipro2' //设定一个id，防止重复弹出
                        ,resize: false
                        ,btnAlign: 'c'
                        ,content: tsContent
                    });
                    return;
                }
                secret = data.obj["secret"];
                $(".hbimg img").attr("src","./images/x-jd-k.png");
                var money = 0;
                for(var i = 1;i<=15;i++){
                    if(currentId!=("hb"+i)){
                        $("#m"+i).html(data.obj["m"+i]);
                    }else{
                        money = data.obj["money"];
                        $("#m"+i).html(data.obj["money"]);
                    }
                }
                var content = '<div class="zjhb"><div><img class="closeBtn layui-layer-btn1" src="images/btn/cha.png" onclick="closeChb();" /><div id="dkHeight" style="text-align: center;padding-top:4em;font-size:22px;width: 80%;margin-left: auto;margin-right: auto;"><div id="moneyDiv">恭喜获得'+money+'元</div><div style="height:7em;"></div><a href="product.html"><img style="width:7em;" src="./images/btn/goon.gif"></a></div></div></div>';
                layer.open({
                    type: 1
                    ,title: false //不显示标题栏
                    ,closeBtn: false
                    ,area: '20em;'
                    ,shade: 0.3
                    ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
                    ,resize: false
                    ,btnAlign: 'c'
                    ,moveType: 1 //拖拽模式，0或者1 ,
                    ,content: content
                    ,success: function(layero){
                        var btn = layero.find('.layui-layer-btn');
                        btn.find('.layui-layer-btn0').attr({
                            href: 'http://www.layui.com/'
                            ,target: '_blank'
                        });
                    }
                });
                $.post("pay/ph.json",{s:secret,totalFee:money,orderId:${orderId},orderNo:"${orderNo}"},function(data){
                    //alert(data.code);
                });
            });

            //,form = layui.form();
            //layer.msg('Hello World');

        });
    });
    layui.define(['layer', 'form'], function(exports){
        var layer = layui.layer;
    });
    function closeChb() {
        layer.closeAll();
    }
    //layui.config({
    //  base: '/res/js/modules/' //你的模块目录
    //}).use('index'); //加载入口


    function chaihongbao(){
        $(".zjhb").attr("class","zjhb-ck");
        for(var i = 1;i<=15;i++){
            if(currentId!=("hb"+i)){
                $("#m"+i).html(data.obj["m"+i]);
            }else{
                money = data.obj["money"];
                $("#m"+i).html(data.obj["money"]);
            }
        }
        $("#dkHeight").css("padding-top",195).css("width","90%");
        $("#moneyDiv").html("恭喜获得"+money+"元");

//        $.get("pay/getMoney.json",{},function(data){
//
//            $(".hbimg img").attr("src","./images/dakai.gif");
//            var money = 0;
//            for(var i = 1;i<=15;i++){
//                if(currentId!=("hb"+i)){
//                    $("#m"+i).html(data.obj["m"+i]);
//                }else{
//                    money = data.obj["money"];
//                    $("#m"+i).html(data.obj["money"]);
//                }
//            }
//            $("#moneyDiv").html(money+"元");
//        });
    }
</script>
<jsp:include page="./common/bottom.jsp"></jsp:include>
</body>
</html>
