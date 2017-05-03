<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
    <script type="text/javascript" src="js/common/jquery/jquery-1.9.1.js"></script>
    <title>首页</title>
</head>
<body>
<div class="tbg">
    <div style="height:5em;">

    </div>
    <a href="/manage/toList.html?dataStatus=1">待提现</a>
    <a href="/manage/toList.html?dataStatus=2">已提现</a>
    <a href="/manage/toList.html?dataStatus=3">提现失败</a>
    <div class="hb_list">
        <table border="1" style="width: 100%;text-align: center;">
            <tr>
                <th>编号</th>
                <th>金额</th>
                <th>申请时间</th>
                <th>操作</th>
            </tr>
            <c:forEach var="cash" items="${list}">
                <tr>
                    <td>${cash.id}</td>
                    <td>${cash.amount}</td>
                    <td><fmt:formatDate value="${cash.addTime}" pattern="yyyy-MM-dd HH:mm" /> </td>
                    <td><a data-amount="${cash.amount}" href="javascript:pizhun(${cash.id});">批准</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<script>
    function pizhun(dataId) {
        if (confirm("您要批准打款吗？")) {
            $.post("/manage/updateWithDaKuan.json",{id:dataId},function (data) {
                if(data.code==200){
                    alert("操作成功！");
                }
            });
        }

    }
</script>
</body>
</html>
