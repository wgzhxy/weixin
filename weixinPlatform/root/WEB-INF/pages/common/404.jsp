<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value='<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + request.getContextPath()%>' />

<!DOCTYPE html>
<html>
<head>
<title>移折通</title>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<meta name="description" content="移折通贵阳市站，贵阳市最早，口碑最好的电子优惠券！提供各种餐饮美食优惠券、休闲娱乐优惠券、美容美体优惠券、运动健身优惠券及生活服务优惠券，优惠券经常更新。" />
<meta name="keywords" content="贵阳市 优惠券,电子优惠券,折扣,团购,移折通" />
<style type="text/css">
.btnGoIndex{border:none;width:105px;height:32px;background:none;
background-image:url('${basePath}/images/bg_index.png');display:inline-block;margin-left:20px;}
.returnBack{width:105px;height:32px;display:inline-block;background-image:url('${basePath}/images/back.png');margin-left:20px;}
.responsiveImg{width:100%;min-width:100%;vertical-align: top;}
.tc{text-align:center;}
</style>
</head>
<body>
	<div style="padding:40px 10px;">
		<img src="${basePath}/images/404.png" alt="404"  class="responsiveImg"  />
		<p class="tc">
			<a href="#" onclick="history.back();return false;" class="returnBack" ></a>
			<a href="${basePath}"  class="btnGoIndex"></a>
		</p>
	</div>
</body>
</html>