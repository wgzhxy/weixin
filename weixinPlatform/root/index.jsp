<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<!--
		Charisma v1.0.0

		Copyright 2012 Muhammad Usman
		Licensed under the Apache License v2.0
		http://www.apache.org/licenses/LICENSE-2.0

		http://usman.it
		http://twitter.com/halalit_usman
	-->
	<meta charset="utf-8">
	<title>Free HTML5 Bootstrap Admin Template</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
	<meta name="author" content="Muhammad Usman">

	<!-- The styles -->
	<link id="bs-css" href="${basePath}/css/bootstrap-cerulean.css" rel="stylesheet">
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
	<link href='${basePath}/css/fullcalendar.print.css' rel='stylesheet'  media='print'>
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

	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->

	<!-- The fav icon -->
	<link rel="shortcut icon" href="${basePath}/img/favicon.ico">
		
</head>

<body>
	<!-- topbar starts -->
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				<a class="brand" href="index.jsp"> <img alt="Charisma Logo" src="${basePath}/img/logo20.png" /> <span>Charisma</span></a>
				
				<!-- theme selector starts -->
				<div class="btn-group pull-right theme-container" >
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="icon-tint"></i><span class="hidden-phone"> Change Theme / Skin</span>
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu" id="themes">
						<li><a data-value="classic" href="#"><i class="icon-blank"></i> Classic</a></li>
						<li><a data-value="cerulean" href="#"><i class="icon-blank"></i> Cerulean</a></li>
						<li><a data-value="cyborg" href="#"><i class="icon-blank"></i> Cyborg</a></li>
						<li><a data-value="redy" href="#"><i class="icon-blank"></i> Redy</a></li>
						<li><a data-value="journal" href="#"><i class="icon-blank"></i> Journal</a></li>
						<li><a data-value="simplex" href="#"><i class="icon-blank"></i> Simplex</a></li>
						<li><a data-value="slate" href="#"><i class="icon-blank"></i> Slate</a></li>
						<li><a data-value="spacelab" href="#"><i class="icon-blank"></i> Spacelab</a></li>
						<li><a data-value="united" href="#"><i class="icon-blank"></i> United</a></li>
					</ul>
				</div>
				<!-- theme selector ends -->
				
				<!-- user dropdown starts -->
				<div class="btn-group pull-right" >
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="icon-user"></i><span class="hidden-phone"> admin</span>
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="#">Profile</a></li>
						<li class="divider"></li>
						<li><a href="login.jsp">Logout</a></li>
					</ul>
				</div>
				<!-- user dropdown ends -->
				
				<div class="top-nav nav-collapse">
					<ul class="nav">
						<li><a href="#">Visit Site</a></li>
						<li>
							<form class="navbar-search pull-left">
								<input placeholder="Search" class="search-query span2" name="query" type="text">
							</form>
						</li>
					</ul>
				</div><!--/.nav-collapse -->
			</div>
		</div>
	</div>
	<!-- topbar ends -->
	
	<!-- main begin -->
	<div class="container-fluid">
	<div class="row-fluid">	
	
		<!-- left menu starts -->
		<%@ include file="leftMenu.jsp"%>
		<!-- left menu ends -->
		
		<noscript>
			<div class="alert alert-block span10">
				<h4 class="alert-heading">Warning!</h4>
				<p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
			</div>
		</noscript>
		<!-- main content begin --><!--/#content.span10 begin-->
		<div id="content" class="span10">
			<iframe id="oWnd" style="border: 0px;width: 100%" src="content.jsp" onload="resize()"></iframe>
		</div>
		<!--/#content.span10 end--><!-- main content end -->
	</div><!--/fluid-row-->
	<!-- main end -->	
	
	<hr>
	<div class="modal hide fade" id="myModal">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">Ã</button>
			<h3>Settings</h3>
		</div>
		<div class="modal-body">
			<p>Here settings can be configured...</p>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn" data-dismiss="modal">Close</a>
			<a href="#" class="btn btn-primary">Save changes</a>
		</div>
	</div>

	<footer>
		<p class="pull-left">&copy; <a href="http://usman.it" target="_blank">Muhammad Usman</a> 2012</p>
		<p class="pull-right">Powered by: <a href="http://usman.it/free-responsive-admin-template">Charisma</a></p>
	</footer>
		
	</div><!--/.fluid-container-->

	<!-- external javascript
	================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<!-- jQuery -->
	<script src="${basePath}/js/jquery-1.7.2.min.js"></script>
	<!-- jQuery UI -->
	<script src="${basePath}/js/jquery-ui-1.8.21.custom.min.js"></script>
	<!-- transition / effect library -->
	<script src="${basePath}/js/bootstrap-transition.js"></script>
	<!-- alert enhancer library -->
	<script src="${basePath}/js/bootstrap-alert.js"></script>
	<!-- modal / dialog library -->
	<script src="${basePath}/js/bootstrap-modal.js"></script>
	<!-- custom dropdown library -->
	<script src="${basePath}/js/bootstrap-dropdown.js"></script>
	<!-- scrolspy library -->
	<script src="${basePath}/js/bootstrap-scrollspy.js"></script>
	<!-- library for creating tabs -->
	<script src="${basePath}/js/bootstrap-tab.js"></script>
	<!-- library for advanced tooltip -->
	<script src="${basePath}/js/bootstrap-tooltip.js"></script>
	<!-- popover effect library -->
	<script src="${basePath}/js/bootstrap-popover.js"></script>
	<!-- button enhancer library -->
	<script src="${basePath}/js/bootstrap-button.js"></script>
	<!-- accordion library (optional, not used in demo) -->
	<script src="${basePath}/js/bootstrap-collapse.js"></script>
	<!-- carousel slideshow library (optional, not used in demo) -->
	<script src="${basePath}/js/bootstrap-carousel.js"></script>
	<!-- autocomplete library -->
	<script src="${basePath}/js/bootstrap-typeahead.js"></script>
	<!-- tour library -->
	<script src="${basePath}/js/bootstrap-tour.js"></script>
	<!-- library for cookie management -->
	<script src="${basePath}/js/jquery.cookie.js"></script>
	<!-- calander plugin -->
	<script src='${basePath}/js/fullcalendar.min.js'></script>
	<!-- data table plugin -->
	<script src='${basePath}/js/jquery.dataTables.min.js'></script>

	<!-- chart libraries start -->
	<script src="${basePath}/js/excanvas.js"></script>
	<script src="${basePath}/js/jquery.flot.min.js"></script>
	<script src="${basePath}/js/jquery.flot.pie.min.js"></script>
	<script src="${basePath}/js/jquery.flot.stack.js"></script>
	<script src="${basePath}/js/jquery.flot.resize.min.js"></script>
	<!-- chart libraries end -->

	<!-- select or dropdown enhancer -->
	<script src="${basePath}/js/jquery.chosen.min.js"></script>
	<!-- checkbox, radio, and file input styler -->
	<script src="${basePath}/js/jquery.uniform.min.js"></script>
	<!-- plugin for gallery image view -->
	<script src="${basePath}/js/jquery.colorbox.min.js"></script>
	<!-- rich text editor library -->
	<script src="${basePath}/js/jquery.cleditor.min.js"></script>
	<!-- notification plugin -->
	<script src="${basePath}/js/jquery.noty.js"></script>
	<!-- file manager library -->
	<script src="${basePath}/js/jquery.elfinder.min.js"></script>
	<!-- star rating plugin -->
	<script src="${basePath}/js/jquery.raty.min.js"></script>
	<!-- for iOS style toggle switch -->
	<script src="${basePath}/js/jquery.iphone.toggle.js"></script>
	<!-- autogrowing textarea plugin -->
	<script src="${basePath}/js/jquery.autogrow-textarea.js"></script>
	<!-- multiple file upload plugin -->
	<script src="${basePath}/js/jquery.uploadify-3.1.min.js"></script>
	<!-- history.js for cross-browser state change on ajax -->
	<script src="${basePath}/js/jquery.history.js"></script>
	<!-- application script for Charisma demo -->
	<script src="${basePath}/js/charisma.js"></script>
	<script type="text/javascript">
		function resize(){
			var nHeight = window.document.body.clientHeight;
			var oEle = document.getElementById("oWnd");
			oEle.style.height = nHeight + 'px';
		}
		function changePage(url){
			var oEle = document.getElementById("oWnd");
			oEle.src=url;
		}
	</script>
		
</body>
</html>
