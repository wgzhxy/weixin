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
	<%@ include file="/WEB-INF/pages/common/miniInclude.jsp"%>
	<link id="bs-css" href="${basePath}/css/bootstrap-cerulean.css" rel="stylesheet">
	<style type="text/css">
	  body {
		padding-bottom: 40px;
	  }
	  .sidebar-nav {
		padding: 9px 0;
	  }
	</style>
	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<!-- The fav icon -->
	<link rel="shortcut icon" href="${basePath}/img/favicon.ico">
	<style type="text/css">
		html,body {
			/*<定义html和body高度都为100%，即显式定义html和body高度>*/
    		height:100%;
		}
	</style>
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
						<li><a href="${basePath}/indexLoginOut.do">退出</a></li>
					</ul>
				</div>
				<!-- user dropdown ends -->
				
				<div class="top-nav nav-collapse">
					<ul class="nav" style="left:30px;">
						<c:if test="${menuParent != null}">
							<c:forEach var="menu" items="${menuParent}">
								<li><a href="javascript:changeMenu('${menu.id}');">${menu.menuName}</a></li>
							</c:forEach>
						</c:if>
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
		
			<!-- left menu start -->
			<div class="span2 main-menu-span">
				<div class="well nav-collapse sidebar-nav" id="leftMenu">
					<ul class="nav nav-tabs nav-stacked main-menu">
						<li class="nav-header hidden-tablet">菜单列表</li>
						<li><a class="ajax-link" href="javascript:changePage('${basePath}/message/msgManagerIndex.do');"><i class="icon-home"></i><span class="hidden-tablet">微信概况</span></a></li>
						<li><a class="ajax-link" href="javascript:changePage('ui.jsp');"><i class="icon-eye-open"></i><span class="hidden-tablet">微信实时消息</span><span class="badge">23</span></a></li>
						<li><a class="ajax-link" href="javascript:changePage('menuAdd.jsp');"><i class="icon-edit"></i><span class="hidden-tablet">微信群发</span></a></li>
						<li><a class="ajax-link" href="javascript:changePage('chart.jsp');"><i class="icon-list-alt"></i><span class="hidden-tablet">历史消息</span></a></li>
						<li><a class="ajax-link" href="javascript:changePage('chart.jsp');"><i class="icon-font"></i><span class="hidden-tablet">群发效果统计</span></a></li>
						<li><a class="ajax-link" href="javascript:changePage('gallery.jsp');"><i class="icon-picture"></i><span class="hidden-tablet">图文素材</span></a></li>
						<li><a class="ajax-link" href="javascript:changePage('table.jsp');"><i class="icon-align-justify"></i><span class="hidden-tablet">自动回复设置</span></a></li>
						<li><a class="ajax-link" href="javascript:changePage('table.jsp');"><i class="icon-calendar"></i><span class="hidden-tablet">自定义菜单</span></a></li>
					</ul>
				</div><!--/.well -->
			</div><!--/span-->
			<!-- left menu ends -->
			<!-- main content begin -->
			<div id="content" class="span10" style="width: 81%;">
				<iframe src ="content.jsp" frameborder="0" marginheight="0" marginwidth="0" frameborder="0" scrolling="no" id="ifm" name="ifm" width="100%"></iframe>
			</div>
			<!-- main content end -->
		</div><!--/fluid-row-->
		<!-- main end -->	
	</div><!--/.fluid-container-->
	<script type="text/javascript">
		function changePage(url){
			var oEle = document.getElementById("ifm");
			oEle.height = 0;
			oEle.src=url;
		}
		function changeMenu(parentId) {
			$.ajax({
				type:'post',			//可选get
				url:'${basePath}/indexListSecondMenu.do',		//这里是接收数据的PHP程序
				data:'parentId=' + parentId,				//传给PHP的数据，多个参数用&连接 data='dsa'
				dataType:'text',		//服务器返回的数据类型 可选XML ,Json jsonp script html text等
				success:function(data){
					//这里是ajax提交成功后，PHP程序返回的数据处理函数。msg是返回的数据，数据类型在dataType参数里定义！
					var newMenu = "<ul class=\"nav nav-tabs nav-stacked main-menu\"><li class=\"nav-header hidden-tablet\">菜单列表</li>";
					var dataObj=eval("("+data+")");
					for(var i=0; i<dataObj.length; i++) {
						newMenu += "<li><a class=\"ajax-link\" href=\"javascript:changePage('${basePath}" + dataObj[i].url + "');\"><i class=\""+dataObj[i].iconCls+"\"></i><span class=\"hidden-tablet\">" + dataObj[i].text + "</span></a></li>";
					}
					newMenu += "</ul>";
					$("#leftMenu").html(newMenu);
				},
				error:function(e){
					alert(e);
				}
			});
		}
	</script>
	<script language="javascript" type="text/javascript"> 
		function reinitIframe(){
			var iframe = document.getElementById("ifm");
			try{
				var bHeight = iframe.contentWindow.document.body.scrollHeight;
				var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
				var height = Math.max(bHeight, dHeight);
				iframe.height = height;
			}catch (ex){}
		}
		window.setInterval("reinitIframe()", 200);
	</script> 
<%@ include file="/WEB-INF/pages/common/jsInclude.jsp"%>
</body>
</html>
