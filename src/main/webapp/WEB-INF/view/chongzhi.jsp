<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1" />
	<meta content="telephone=no" name="format-detection" />
	<title>确认支付</title>
	<link href="/css/mybase.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="/js/common/jquery/jquery-1.9.1.js"></script>
	<style>
		.tbg{background: url("/images/jdbg.png") center no-repeat;background-position: 50% 0px;background-size: 100%; height: 100%;width: 100%;}
		.s_pay_content{padding: 5px 10px;text-align: center;}
		.s_price{padding:10px;}
		.s_price span{width: 20%;border: 1px solid #d6d6d6;padding: 5px 10px;cursor: pointer;}
		.bgRed{background-color: red;}
		.line{margin:10px auto;border-bottom: 2px #8D8D8D solid;width: 98%;}
	</style>

	<script>
		$(function () {
			$(".s_price span").click(function () {
				$("#orderAmt").val($(this).html());
				$(".s_price").find("span").each(function(index,element){
					$(element).removeClass("bgRed");
				});
				$(this).addClass("bgRed");

			});
		});
	</script>
</head>
<body>


<div class="tbg">
	<div style="height:14em;"></div>
	<div class="s_pay_content">
		<div>
			请选择充值金额（元）
		</div>
		<div class="s_price">
			<span class="bgRed">10</span>
			<span>20</span>
			<span>50</span>
			<span>100</span>
			<span>200</span>
		</div>
	</div>

	<div class="line"></div>
	<div></div>
	<form id="testPay" action="/pay/chongzhi.html" method="post" accept-charset="UTF-8" style="border-color: gray; padding-top:5px;text-align: center;">
		<input id="orderAmt" name="orderAmt" type="hidden" value="10" />
		<input id="bankId" name="bankId" type="hidden" value="888C" />
		<input id="remark" name="remark" type="hidden" value="zd" />
		<input id="cardType" name="cardType" type="hidden" value="01" />
		<input id="goodsType" name="goodsType" type="hidden" value="0" />
		<input id="goodsName" name="goodsName" type="hidden" value="ptcz" />
		<input id="submitBtn" type="submit" value="确认" style="width: 60%;background-color: yellow;color: red;padding: 40px;font-size: 16px; border: 1px solid #DDDDDD;"/>
	</form>

</div>


</body>
</html>
