<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>微信后台管理系统</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
	<meta name="author" content="Muhammad Usman">
	<!-- The styles -->
	<%@ include file="/WEB-INF/pages/common/include.jsp"%>
	<link id="bs-css" href="${basePath}/css/bootstrap-cerulean.css" rel="stylesheet">
	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->

	<!-- The fav icon -->
	<link rel="shortcut icon" href="${basePath}/img/favicon.ico">
		
</head>
<body>
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				<a class="brand" href="index.html"> <img alt="Charisma Logo" src="${basePath}/img/logo20.png" /> <span>微信管理平台</span></a>
				
				<div class="btn-group pull-right" >
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="icon-user"></i><span>服务号</span><span class="divider">|</span><span class="hidden-phone">weidingzhi</span>
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="#">切换团队</a></li>
						<li><a href="#">账户设置</a></li>
						<li class="divider"></li>
						<li><a href="login.jsp">退出</a></li>
					</ul>
				</div>
				<!-- user dropdown ends -->
				<div class="top-nav nav-collapse" style="left:40px;">
					<ul class="nav">
						<li><a href="#">微信客服</a></li>
						<li><a href="#">客户管理</a></li>
						<li><a href="#">微页面/表单</a></li>
						<li><a href="#">应用插件</a></li>
						<li><a href="#">营销活动</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
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
			<!-- main content begin -->
			<div id="content" class="span10" style="width:1110px;">
				<iframe src ="content.jsp" frameborder="0" marginheight="0" marginwidth="0" frameborder="0" scrolling="auto" id="ifm" name="ifm" onload="javascript:resize();" width="100%"></iframe>
			</div>
			<!-- main content end -->
		</div><!--/fluid-row-->
		<!-- main end -->	
	</div><!--/.fluid-container-->
	<footer>
		<div style="">
		©2014&nlsp;&nlsp;&nlsp;<a href="#">weidingzhi</a>
		</div>
	</footer>
	<script type="text/javascript">
		function resize(){
			var nHeight = window.document.body.clientHeight;
			var oEle = document.getElementById("ifm");
			oEle.style.height = nHeight + 'px';
		}
		
		function changePage(url){
			var oEle = document.getElementById("ifm");
			oEle.src=url;
		}
	</script>
	<script language="javascript" type="text/javascript"> 
		function dyniframesize(down) {
			var pTar = null; 
			if (document.getElementById){ 
				pTar = document.getElementById(down); 
			}else{ 
				eval('pTar = ' + down + ';'); 
			} 
			if (pTar && !window.opera){
				//begin resizing iframe 
				pTar.style.display="block" 
				if (pTar.contentDocument && pTar.contentDocument.body.offsetHeight){ 
					pTar.height = pTar.contentDocument.body.offsetHeight +20; 
					pTar.width = pTar.contentDocument.body.scrollWidth+20; 
				} else if (pTar.Document && pTar.Document.body.scrollHeight){ 
					pTar.height = pTar.Document.body.scrollHeight; 
					pTar.width = pTar.Document.body.scrollWidth; 
				} 
			} 
		} 
	</script> 
<%@ include file="/WEB-INF/pages/common/jsInclude.jsp"%>
</body>
</html>