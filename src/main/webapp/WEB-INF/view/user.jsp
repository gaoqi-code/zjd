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
    <title>正在加载</title>
    <script type="text/javascript" src="js/common/jquery/jquery-1.9.1.js"></script>
</head>
<body>
<script>
    location.href="${url}";
</script>
</body>
</html>
