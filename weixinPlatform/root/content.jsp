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
<!-- content starts -->
<div>
	<ul class="breadcrumb">
		<li>
			<a href="#">Home</a> <span class="divider">/</span>
		</li>
		<li>
			<a href="#">Dashboard</a>
		</li>
	</ul>
</div>
<div class="sortable row-fluid">
	<a data-rel="tooltip" title="6 new members." class="well span3 top-block" href="#">
		<span class="icon32 icon-red icon-user"></span>
		<div>Total Members</div>
		<div>507</div>
		<span class="notification">6</span>
	</a>

	<a data-rel="tooltip" title="4 new pro members." class="well span3 top-block" href="#">
		<span class="icon32 icon-color icon-star-on"></span>
		<div>Pro Members</div>
		<div>228</div>
		<span class="notification green">4</span>
	</a>

	<a data-rel="tooltip" title="$34 new sales." class="well span3 top-block" href="#">
		<span class="icon32 icon-color icon-cart"></span>
		<div>Sales</div>
		<div>$13320</div>
		<span class="notification yellow">$34</span>
	</a>
	
	<a data-rel="tooltip" title="12 new messages." class="well span3 top-block" href="#">
		<span class="icon32 icon-color icon-envelope-closed"></span>
		<div>Messages</div>
		<div>25</div>
		<span class="notification red">12</span>
	</a>
</div>

<div class="row-fluid">
	<div class="box span12">
		<div class="box-header well">
			<h2><i class="icon-info-sign"></i> Introduction</h2>
			<div class="box-icon">
				<a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
				<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
				<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
			</div>
		</div>
		<div class="box-content">
			<h1>Charisma <small>free, premium quality, responsive, multiple skin admin template.</small></h1>
			<p>Its a live demo of the template. I have created Charisma to ease the repeat work I have to do on my projects. Now I re-use Charisma as a base for my admin panel work and I am sharing it with you :)</p>
			<p><b>All pages in the menu are functional, take a look at all, please share this with your followers.</b></p>
			
			<p class="center">
				<a href="http://usman.it/free-responsive-admin-template" class="btn btn-large btn-primary"><i class="icon-chevron-left icon-white"></i> Back to article</a> 
				<a href="http://usman.it/free-responsive-admin-template" class="btn btn-large"><i class="icon-download-alt"></i> Download Page</a>
			</p>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
		
<div class="row-fluid sortable">
	<div class="box span4">
		<div class="box-header well">
			<h2><i class="icon-th"></i> Tabs</h2>
			<div class="box-icon">
				<a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
				<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
				<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
			</div>
		</div>
		<div class="box-content">
			<ul class="nav nav-tabs" id="myTab">
				<li class="active"><a href="#info">Info</a></li>
				<li><a href="#custom">Custom</a></li>
				<li><a href="#messages">Messages</a></li>
			</ul>
			 
			<div id="myTabContent" class="tab-content">
				<div class="tab-pane active" id="info">
					<h3>Charisma <small>a fully featued template</small></h3>
					<p>Its a fully featured, responsive template for your admin panel. Its optimized for tablet and mobile phones. Scan the QR code below to view it in your mobile device.</p> <img alt="QR Code" class="charisma_qr center" src="${basePath}/img/qrcode136.png" />
				</div>
				<div class="tab-pane" id="custom">
					<h3>Custom <small>small text</small></h3>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor.</p>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales at. Nulla tellus elit, varius non commodo eget, mattis vel eros. In sed ornare nulla. Donec consectetur, velit a pharetra ultricies, diam lorem lacinia risus, ac commodo orci erat eu massa. Sed sit amet nulla ipsum. Donec felis mauris, vulputate sed tempor at, aliquam a ligula. Pellentesque non pulvinar nisi.</p>
				</div>
				<div class="tab-pane" id="messages">
					<h3>Messages <small>small text</small></h3>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales at. Nulla tellus elit, varius non commodo eget, mattis vel eros. In sed ornare nulla. Donec consectetur, velit a pharetra ultricies, diam lorem lacinia risus, ac commodo orci erat eu massa. Sed sit amet nulla ipsum. Donec felis mauris, vulputate sed tempor at, aliquam a ligula. Pellentesque non pulvinar nisi.</p>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor.</p>
				</div>
			</div>
		</div>
	</div><!--/span-->
			
	<div class="box span4">
		<div class="box-header well" data-original-title>
			<h2><i class="icon-user"></i> Member Activity</h2>
			<div class="box-icon">
				<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
				<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
			</div>
		</div>
		<div class="box-content">
			<div class="box-content">
				<ul class="dashboard-list">
					<li>
						<a href="#">
							<img class="dashboard-avatar" alt="Usman" src="http://www.gravatar.com/avatar/f0ea51fa1e4fae92608d8affee12f67b.png?s=50"></a>
							<strong>Name:</strong> <a href="#">Usman
						</a><br>
						<strong>Since:</strong> 17/05/2012<br>
						<strong>Status:</strong> <span class="label label-success">Approved</span>                                  
					</li>
					<li>
						<a href="#">
							<img class="dashboard-avatar" alt="Sheikh Heera" src="http://www.gravatar.com/avatar/3232415a0380253cfffe19163d04acab.png?s=50"></a>
							<strong>Name:</strong> <a href="#">Sheikh Heera
						</a><br>
						<strong>Since:</strong> 17/05/2012<br>
						<strong>Status:</strong> <span class="label label-warning">Pending</span>                                 
					</li>
					<li>
						<a href="#">
							<img class="dashboard-avatar" alt="Abdullah" src="http://www.gravatar.com/avatar/46056f772bde7c536e2086004e300a04.png?s=50"></a>
							<strong>Name:</strong> <a href="#">Abdullah
						</a><br>
						<strong>Since:</strong> 25/05/2012<br>
						<strong>Status:</strong> <span class="label label-important">Banned</span>                                  
					</li>
					<li>
						<a href="#">
							<img class="dashboard-avatar" alt="Saruar Ahmed" src="http://www.gravatar.com/avatar/564e1bb274c074dc4f6823af229d9dbb.png?s=50"></a>
							<strong>Name:</strong> <a href="#">Saruar Ahmed
						</a><br>
						<strong>Since:</strong> 17/05/2012<br>
						<strong>Status:</strong> <span class="label label-info">Updates</span>                                  
					</li>
				</ul>
			</div>
		</div>
	</div><!--/span-->
			
	<div class="box span4">
		<div class="box-header well" data-original-title>
			<h2><i class="icon-list-alt"></i> Realtime Traffic</h2>
			<div class="box-icon">
				<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
				<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
			</div>
		</div>
		<div class="box-content">
			<div id="realtimechart" style="height:190px;"></div>
				<p class="clearfix">You can update a chart periodically to get a real-time effect by using a timer to insert the new data in the plot and redraw it.</p>
				<p>Time between updates: <input id="updateInterval" type="text" value="" style="text-align: right; width:5em"> milliseconds</p>
		</div>
	</div><!--/span-->
</div><!--/row-->

<div class="row-fluid sortable">
	<div class="box span4">
		<div class="box-header well" data-original-title>
			<h2><i class="icon-list"></i> Buttons</h2>
			<div class="box-icon">
				<a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
				<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
				<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
			</div>
		</div>
		<div class="box-content buttons">
			<p class="btn-group">
				  <button class="btn">Left</button>
				  <button class="btn">Middle</button>
				  <button class="btn">Right</button>
			</p>
			<p>
				<button class="btn btn-small"><i class="icon-star"></i> Icon button</button>
				<button class="btn btn-small btn-primary">Small button</button>
				<button class="btn btn-small btn-danger">Small button</button>
			</p>
			<p>
				<button class="btn btn-small btn-warning">Small button</button>
				<button class="btn btn-small btn-success">Small button</button>
				<button class="btn btn-small btn-info">Small button</button>
			</p>
			<p>
				<button class="btn btn-small btn-inverse">Small button</button>
				<button class="btn btn-large btn-primary btn-round">Round button</button>
				<button class="btn btn-large btn-round"><i class="icon-ok"></i></button>
				<button class="btn btn-primary"><i class="icon-edit icon-white"></i></button>
			</p>
			<p>
				<button class="btn btn-mini">Mini button</button>
				<button class="btn btn-mini btn-primary">Mini button</button>
				<button class="btn btn-mini btn-danger">Mini button</button>
				<button class="btn btn-mini btn-warning">Mini button</button>
			</p>
			<p>
				<button class="btn btn-mini btn-info">Mini button</button>
				<button class="btn btn-mini btn-success">Mini button</button>
				<button class="btn btn-mini btn-inverse">Mini button</button>
			</p>
		</div>
	</div><!--/span-->
		
	<div class="box span4">
		<div class="box-header well" data-original-title>
			<h2><i class="icon-list"></i> Buttons</h2>
			<div class="box-icon">
				<a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
				<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
				<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
			</div>
		</div>
		<div class="box-content  buttons">
			<p>
				<button class="btn btn-large">Large button</button>
				<button class="btn btn-large btn-primary">Large button</button>
			</p>
			<p>
				<button class="btn btn-large btn-danger">Large button</button>
				<button class="btn btn-large btn-warning">Large button</button>
			</p>
			<p>
				<button class="btn btn-large btn-success">Large button</button>
				<button class="btn btn-large btn-info">Large button</button>
			</p>
			<p>
				<button class="btn btn-large btn-inverse">Large button</button>
			</p>
			<div class="btn-group">
				<button class="btn btn-large">Large Dropdown</button>
				<button class="btn btn-large dropdown-toggle" data-toggle="dropdown"><span class="caret"></span></button>
				<ul class="dropdown-menu">
					<li><a href="#"><i class="icon-star"></i> Action</a></li>
					<li><a href="#"><i class="icon-tag"></i> Another action</a></li>
					<li><a href="#"><i class="icon-download-alt"></i> Something else here</a></li>
					<li class="divider"></li>
					<li><a href="#"><i class="icon-tint"></i> Separated link</a></li>
				</ul>
			</div>
			
		</div>
	</div><!--/span-->
		
	<div class="box span4">
		<div class="box-header well" data-original-title>
			<h2><i class="icon-list"></i> Weekly Stat</h2>
			<div class="box-icon">
				<a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
				<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
				<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
			</div>
		</div>
		<div class="box-content">
			<ul class="dashboard-list">
				<li>
					<a href="#">
						<i class="icon-arrow-up"></i>                               
						<span class="green">92</span>
						New Comments                                    
					</a>
				</li>
			  <li>
				<a href="#">
				  <i class="icon-arrow-down"></i>
				  <span class="red">15</span>
				  New Registrations
				</a>
			  </li>
			  <li>
				<a href="#">
				  <i class="icon-minus"></i>
				  <span class="blue">36</span>
				  New Articles                                    
				</a>
			  </li>
			  <li>
				<a href="#">
				  <i class="icon-comment"></i>
				  <span class="yellow">45</span>
				  User reviews                                    
				</a>
			  </li>
			  <li>
				<a href="#">
				  <i class="icon-arrow-up"></i>                               
				  <span class="green">112</span>
				  New Comments                                    
				</a>
			  </li>
			  <li>
				<a href="#">
				  <i class="icon-arrow-down"></i>
				  <span class="red">31</span>
				  New Registrations
				</a>
			  </li>
			  <li>
				<a href="#">
				  <i class="icon-minus"></i>
				  <span class="blue">93</span>
				  New Articles                                    
				</a>
			  </li>
			  <li>
				<a href="#">
				  <i class="icon-comment"></i>
				  <span class="yellow">254</span>
				  User reviews                                    
				</a>
			  </li>
			</ul>
		</div>
	</div><!--/span-->
</div><!--/row--><!-- content ends -->
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
			alert(nHeight);
			var oEle = document.getElementById("oWnd");
			oEle.style.height = nHeight + 'px';
		}
	</script>
		
</body>
</html>