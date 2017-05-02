<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1" />
	<title>确认支付</title>
	<%--<script type="text/javascript" src="/js/common/jquery/jquery-1.9.1.js"></script>--%>
</head>
<body onload="autoSubmit();">
<form id="myForm"  action="http://pay.open580.com/pay/payOrder.do" method="post"  accept-charset="UTF-8" style="display:none;">
	<input id="orderNo" name="orderNo" type="text" value="${formParam.orderNo}" />
	<table border="1px">
		<tr>
			<td>sign</td>
			<td><input id="sign" name="sign" type="text" value="${formParam.sign}" /></td>
		</tr>
		<tr>
			<td>orderAmt</td>
			<td><input id="orderAmt" name="orderAmt" type="text" value="${formParam.orderAmt}" /></td>
		</tr>
		<tr>
			<td>curType</td>
			<td><input id="curType" name="curType" type="text" value="${formParam.curType}" /></td>
		</tr>
		<tr>
			<td>bankId</td>
			<td><input id="bankId" name="bankId" type="text" value="${formParam.bankId}" /></td>
		</tr>
		<tr>
			<td>returnURL</td>
			<td><input id="returnURL" name="returnURL" type="text"  value="${formParam.returnURL}" /></td>
		</tr>
		<tr>
			<td>notifyURL</td>
			<td><input id="notifyURL" name="notifyURL" type="text"   value="${formParam.notifyURL}" /></td>
		</tr>
		<tr>
			<td>remark</td>
			<td><input id="remark" name="remark" type="text" value="${formParam.remark}" /></td>
		</tr>
		<tr>
			<td>cardType</td>
			<td><input id="cardType" name="cardType" type="text" value="${formParam.cardType}" /></td>
		</tr>
		<tr>
			<td>userId</td>
			<td><input id="userId" name="userId" type="text"value="${formParam.userId}" /></td>
		</tr>
		<tr>
			<td>goodsType</td>
			<td><input id="goodsType" name="goodsType" type="text"
					   value="${formParam.goodsType}" /></td>
		</tr>
		<tr>
			<td>goodsName</td>
			<td><input id="goodsName" name="goodsName" type="text" value="${formParam.goodsName}" /></td>
		</tr>
	</table>
	<p>
		<input id="submitBtn" type="submit" />
	</p>
</form>
<script>
	function autoSubmit(){
		document.getElementById("myForm").submit();
	}
</script>
</body>
</html>
