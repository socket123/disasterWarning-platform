<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../commons/easyui-taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- <link rel="shortcut icon" type="image/ico" href="${ctx}/ic.ico">  -->
<head>
<meta name="referrer" content="always">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
<meta name="format-detection" content="telephone=no"/>
<link rel="stylesheet" type="text/css" href="../../css/jsp/download/style.css"/>
<link rel="stylesheet" type="text/css" href="../../css/jsp/download/ds.css"/>
<script type="text/javascript" src="${ctx}/resources/jquery/jquery-1.7.1.js"></script>
<title>东胜IOS下载</title>
</head>
<body>
<div class="page">	
	<div class="d-head">数字东胜</div>
	<div class="d-pic">
		<img src="${ctx}/css/jsp/images/download/logo@2x.png"/>		
	</div>
	<a class="d-a" href="itms-services://?action=download-manifest&url=https://raw.githubusercontent.com/Lianyinglei/Me/master/szds.plist">点击安装</a>
	<ul class="d-ul">
		<li>安装之后，请按Home键在桌面查看；</li>
		<li>本App采用苹果企业级证书开发，iOS7及以上操作系统需要证书受信；</li>
		<li>具体受信操作设置如下（设置—通用—描述文件或设置管理）。</li>
	</ul>
	<div class="ds-img">
		<div class="ds-one"><img src="${ctx}/css/jsp/images/download/01@2x.png"/></div>
		<div class="ds-one ds-two"><img src="${ctx}/css/jsp/images/download/02@2x.png"/></div>
		<div class="ds-one"><img src="${ctx}/css/jsp/images/download/03@2x.png"/></div>
	</div>
	<!--遮罩层-->
	<div class="x-box" onclick="javascript:$('.x-box').hide();">
		<div class="box-size"><img src="${ctx}/css/jsp/images/download/sm@2x.png"/></div>
	</div>
</div>
<script type="text/javascript">
$("body").on('click',function(event){
	$('.x-box').hide();
});
</script>
</body>
</html>