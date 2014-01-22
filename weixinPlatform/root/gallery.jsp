<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>素材管理页面</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
	<meta name="author" content="Muhammad Usman">
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
</head>
<body>
	<div id="content" class="span10">
	<!-- content starts -->	
		
		<!-- 面包 starts -->
		<div>
			<ul class="breadcrumb">
					<li>
						<a href="#">Home</a> <span class="divider">/</span>
					</li>
					<li>
						<a href="#">素材管理</a>
					</li>
				</ul>
		 </div>
		 <!-- 面包 end -->
		 
		 	<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-content">
						<table class="table table-striped">
						<!-- header start -->
							<thead>
							  <tr>
								  <th>素材</th>
								  <th>名称</th>
								  <th>大小</th>
								  <th>上传时间</th>
								  <th>Actions</th>
							  </tr>
						  </thead>   
						<!-- header end -->
						<!-- table body start -->
						<tbody>
							<tr>
								<td>David R</td>
								<td class="center">2012/01/01</td>
								<td class="center">Member</td>
								<td class="center">
									<span class="label label-success">Active</span>
								</td>
								<td class="center">
									<a class="btn btn-success" href="#">
										<i class="icon-zoom-in icon-white"></i>  
										参看                                            
									</a>
									<a class="btn btn-info" href="#">
										<i class="icon-edit icon-white"></i>  
										修改                                            
									</a>
									<a class="btn btn-danger" href="#">
										<i class="icon-trash icon-white"></i> 
										删除
									</a>
								</td>
							</tr>
						<!-- table body end -->
						</table>
					</div>
				</div>
			</div>
	<!-- content ends -->		 
	</div>
</body>
</html>