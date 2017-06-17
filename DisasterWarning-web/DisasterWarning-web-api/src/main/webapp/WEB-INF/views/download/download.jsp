<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>下载</title>
<link href="${ctx}/css/jsp/download/sos.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
</head>

<body>

<div class="main-sos">
		<div class="sos-left">
			<div class="sosimg"><img src="${ctx}/css/jsp/images/download/sj.png"/></div>
		</div>
		<div class="sos-right">
			<div class="sossize">
				<ul>
					<li>点击“扫一扫”，对准二维码扫描框；</li>
					<li>扫描成功之后，选用手机浏览器打开下载地址并下载；</li>
					<li>下载之后可直接安装该应用。</li>
				</ul>
				<div class="qrcode qrl">
					<div class="qr-box"><img src="${ctx}/css/jsp/images/download/ewm.png"/></div>
					<div class="qrsize"><s></s><small>|</small>Android</div>
				</div>
				<!-- <div class="qrcode qrr">
					<div class="qr-box"><img src="${ctx}/css/jsp/images/download/android.png"/></div>
					<div class="qrsize"><i></i><span>|</span>iPhone</div> -->
				</div>
			</div>
		</div>
	<div style="clear: both;"></div>
	<!-- <div class="sosbottom">
		<img src="${ctx}/css/jsp/images/download/down.png"/>
	</div> -->
</div>
</body>
</html>