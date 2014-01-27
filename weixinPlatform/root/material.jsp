<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include.jsp"%>
<!DOCTYPE>
<html>
  <head>
    <title>图文管理界面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<!-- The styles -->
	<link id="bs-css" href="css/bootstrap-cerulean.css" rel="stylesheet">
	<style type="text/css">
	  body {
		padding-bottom: 40px;
	  }
	  .sidebar-nav {
		padding: 9px 0;
	  }
	</style>
	<link href="${basePath}/css/bootstrap-responsive.css" rel="stylesheet">
	<link href="${basePath}/css/charisma-app.css" rel="stylesheet">
	<link href="${basePath}/css/jquery-ui-1.8.21.custom.css" rel="stylesheet">
	<link href='${basePath}/css/fullcalendar.css' rel='stylesheet'>
	<link href='${basePath}/css/fullcalendar.print.css' rel='stylesheet' media='print'>
	<link href='${basePath}/css/chosen.css' rel='stylesheet'>
	<link href='${basePath}/css/uniform.default.css' rel='stylesheet'>
	<link href='${basePath}/css/colorbox.css' rel='stylesheet'>
	<link href='${basePath}/css/jquery.cleditor.css' rel='stylesheet'>
	<link href='${basePath}/css/jquery.noty.css' rel='stylesheet'>
	<link href='${basePath}/css/noty_theme_default.css' rel='stylesheet'>
	<link href='${basePath}/css/elfinder.min.css' rel='stylesheet'>
	<link href='${basePath}/css/elfinder.theme.css' rel='stylesheet'>
	<link href='${basePath}/css/jquery.iphone.toggle.css' rel='stylesheet'>
	<link href='${basePath}/css/opa-icons.css' rel='stylesheet'>
	<link href='${basePath}/css/uploadify.css' rel='stylesheet'>
	
  </head>
  <body>
   	<div id="content" class="span10">
   		<div class="row-fluid">
				<div class="box span12">
					<div class="box-header well">
						<h2><i class="icon-picture"></i>图文管理</h2>
					</div>
					<div class="box-content">
						<div class="sortable row-fluid">
								<a data-rel="tooltip" class="well span6 top-block" href="article_detail.html">
									<span class="icon32 icon-color icon-envelope-closed"></span>
									<div>+单图文消息</div>
								</a>

								<a data-rel="tooltip" class="well span6 top-block" href="article_mul_detail.html">
									<span class="icon32 icon-color icon-envelope-closed"></span>
									<div>+多图文消息</div>
								</a>
						 </div>
						<p class="center"></p>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
	</div>
  </body>
</html>