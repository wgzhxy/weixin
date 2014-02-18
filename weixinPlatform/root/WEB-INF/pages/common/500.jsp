<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value='<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + request.getContextPath()%>' />

<!DOCTYPE html>
<html>
<head>
<title>微定制</title>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
</head>
<body>
	<div style="padding:40px 10px;">
		<p class="tc">
			<a href="#" onclick="history.back();return false;" class="returnBack" ></a>
			<a href="${basePath}"  class="btnGoIndex"></a>
		</p>
	</div>
</body>
</html>