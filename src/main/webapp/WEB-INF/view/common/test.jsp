<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--<link rel="stylesheet" type="text/css" href="../../css/mybase.css">--%>

<style style="stylesheet">
	.navcurrent{}
</style>
<div class="wd1000 top">
	<img src="../images/logo.png">
	<div class="cfrx">
		<p style="    font-size: 28px;margin-top: 40px;color: #cb0606;font-weight: bold;">财富热线：020-61059612</p>
	</div>
</div>
<div class="nav">
	<div class="wd1000">
		<ul>
			<li><a class="${index}" href="index.html">首页</a></li>
			<li><a class="${company}" href="company.html">公司概况</a></li>
			<li><a class="${product}" href="product.html">产品介绍</a></li>
			<li><a class="${contact}" href="contact.html">联系方式</a></li>
            <li><a class="${download}" href="download.html">下载中心</a></li>
        </ul>
	</div>
</div>