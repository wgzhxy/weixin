<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include.jsp"%>
<!DOCTYPE html>
<html>
<head>	
	<meta charset="utf-8">
	<title>微信实时消息</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
	<meta name="author" content="Muhammad Usman">

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
	<link href="css/bootstrap-responsive.css" rel="stylesheet">
	<link href="css/charisma-app.css" rel="stylesheet">
	<link href="css/jquery-ui-1.8.21.custom.css" rel="stylesheet">
	<link href='css/fullcalendar.css' rel='stylesheet'>
	<link href='css/fullcalendar.print.css' rel='stylesheet'  media='print'>
	<link href='css/chosen.css' rel='stylesheet'>
	<link href='css/uniform.default.css' rel='stylesheet'>
	<link href='css/colorbox.css' rel='stylesheet'>
	<link href='css/jquery.cleditor.css' rel='stylesheet'>
	<link href='css/jquery.noty.css' rel='stylesheet'>
	<link href='css/noty_theme_default.css' rel='stylesheet'>
	<link href='css/elfinder.min.css' rel='stylesheet'>
	<link href='css/elfinder.theme.css' rel='stylesheet'>
	<link href='css/jquery.iphone.toggle.css' rel='stylesheet'>
	<link href='css/opa-icons.css' rel='stylesheet'>
	<link href='css/uploadify.css' rel='stylesheet'>

	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->

	<!-- The fav icon -->
	<link rel="shortcut icon" href="img/favicon.ico">

	<!-- x-editable 看这里http://vitalets.github.io/x-editable/-->
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
	<script src="http://code.jquery.com/jquery-2.0.3.min.js"></script> 
	<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<link href="//cdnjs.cloudflare.com/ajax/libs/x-editable/1.5.0/jquery-editable/css/jquery-editable.css" rel="stylesheet"/>
	<script src="//cdnjs.cloudflare.com/ajax/libs/x-editable/1.5.0/jquery-editable/js/jquery-editable-poshytip.min.js"></script>
	<script type="text/javascript">
	    $(document).ready(function() {
	    //toggle `popup` / `inline` mode
	    $.fn.editable.defaults.mode = 'popup';     
	    
	    //make username editable
	    $('#memo').editable({
	           // url: '/post',
	           type: 'text',
	           pk: 1,
	           name: 'username',
	           title: ''
	    });                 
	      
	});
	</script>



		
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
				<a class="brand" href="index.html"> <img alt="Charisma Logo" src="img/logo20.png" /> <span>微信管理平台</span></a>
				
				<div class="btn-group pull-right" >
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="icon-user"></i><span>服务号</span><span class="divider">|</span><span class="hidden-phone"> shaokui</span>
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="#">切换团队</a></li>
						<li><a href="#">账户设置</a></li>
						<li class="divider"></li>
						<li><a href="login.html">退出</a></li>
					</ul>
				</div>
				<!-- user dropdown ends -->
				
				<div class="top-nav nav-collapse">
					<ul class="nav">
						<li><a href="#">微信客服</a></li>
						<li><a href="#">客户管理</a></li>
						<li><a href="#">微页面/表单</a></li>
						<li><a href="#">应用插件</a></li>
						<li><a href="#">营销活动</a></li>						
					</ul>
				</div><!--/.nav-collapse -->
			</div>
		</div>
	</div>
	<!-- topbar ends -->
		<div class="container-fluid">
		<div class="row-fluid">
				
			<!-- left menu starts -->
			<div class="span2 main-menu-span">
				<div class="well nav-collapse sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
						<li class="nav-header hidden-tablet"></li>
						<li><a class="ajax-link" href="index.html"><!-- <i class="icon-home"></i> --><span class="hidden-tablet"> 微信概况</span></a></li>
						<li><a class="ajax-link" href="ui.html"><!-- <i class="icon-eye-open"></i> --><span class="hidden-tablet"> 微信实时消息</span><span class="badge">23</span></a></li>
						<li><a class="ajax-link" href="form.html"><!-- <i class="icon-edit"></i> --><span class="hidden-tablet"> 群发微信</span></a></li>
						<li><a class="ajax-link" href="chart.html"><!-- <i class="icon-list-alt"></i> --><span class="hidden-tablet"> 历史消息</span></a></li>
						<li><a class="ajax-link" href="typography.html"><!-- <i class="icon-font"></i> --><span class="hidden-tablet"> 群发效果统计</span></a></li>
						<li class="nav-header hidden-tablet"></li>
						<li><a class="ajax-link" href="gallery.html"><!-- <i class="icon-picture"></i> --><span class="hidden-tablet"> 图文素材</span></a></li>						
						<li><a class="ajax-link" href="table.html"><!-- <i class="icon-align-justify"></i> --><span class="hidden-tablet"> 自动回复设置</span></a></li>
						<li><a class="ajax-link" href="calendar.html"><!-- <i class="icon-calendar"></i> --><span class="hidden-tablet"> 自定义菜单</span></a></li>
					</ul>
					<label id="for-is-ajax" class="hidden-tablet" for="is-ajax"><input id="is-ajax" type="checkbox"> 显示本页帮助</label>
				</div><!--/.well -->
			</div><!--/span-->
			<!-- left menu ends -->
			
			<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">Warning!</h4>
					<p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
				</div>
			</noscript>
			
			<div id="content" class="span10">
			<!-- content starts -->
			
			<!-- 面包屑样式充公做导航栏吧 -->
			<div>
				<ul class="breadcrumb">
					<li>
						<a href="#">所有消息</a> <span class="divider">|</span>
					</li>
					<li>
						<a href="#">未读</a> <span class="divider">|</span>
					</li>
					<li>
						<a href="#">未回复</a> <span class="divider">|</span>
					</li>
					<li>
						<a href="#">有备注</a> <span class="divider">|</span>
					</li>
					<li>
						<a href="#">已加星</a>
					</li>					
				</ul>
			</div>

			<div class="alert alert-info">
                    <button class="close" data-dismiss="alert" type="button">&times;</button>
                    <p>点击头像或者对话记录，进入到对话看看</p>
                    <p>
                        图文帮助教程： <a href="">如何按管理员备注订阅消息</a> &nbsp;<a href="">如何理解粉丝&ldquo;会员绑定&rdquo;？</a>&nbsp;
                    </p>

                    <p>
                        &ldquo;我的所有信息&rdquo;里面是哪些内容？&nbsp;
                        <br />答：每个管理员都可以订阅自己关注的消息，可以按照&ldquo;会员等级&rdquo;或&ldquo;会员标签&rdquo;或&ldquo;会员消息（特定关键词）&rdquo;或&ldquo;备注内容&rdquo;来订阅。如不设置订阅，默认订阅&ldquo;全部信息&rdquo;。（详见&ldquo;
                        <a href="">管理员设置</a>&rdquo;）&nbsp;
                    </p>

                    <p>
                        &ldquo;备注&rdquo;和&ldquo;加星&rdquo;是针对粉丝这个人还是他说的信息？&nbsp;
                        <br />答：针对于单条信息管理员A打的备注或加星，管理员B也可以看到。
                    </p>
                </div>	

			<div class="row-fluid sortable">
				<div class="box span12">					
					<div class="box-header well" data-original-title>
						<h2><i class="icon-user"></i> Members</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-setting btn-round"><i class="icon-download-alt"></i></a>
							<!-- <a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a> -->
						</div>
					</div>
					<div class="box-content">
						<table class="table table-striped bootstrap-datatable datatable">
							<!-- table-striped table-bordered bootstrap-datatable datatable -->
						  <thead class="">
							  <tr>
								  <th>会员</th>
								  <th></th>
								  <th>信息 （<input type="checkbox">显示自动回复的)</th>
								  <!-- <th>Role</th> -->
								  <!-- <th>时间</th>
								  <th>操作</th> -->
							  </tr>
						  </thead>   
						  <tbody>
							<tr>
								<td class="">
                                    <div class="">
                                    	<div class="">
                                    		<a class="" href ="./talk.html">
                                    			<img src="" width="60" height="60" alt="" />
                                    		</a>
                                    	</div>
                                    </div>
                                </td>
                                <td class="">
                                	<div class="">
                                		<p>
                                			<a class="" href="./talk.html">
                                				shaq
                                			</a>
                                		</p>
                                	</div>
                                </td>
                                <td class="" colspan="3">
                                	<table class="table table-condensed">
                                		<tr class="">
                                			<td class="">
                                				<div class="">
                                					<div class="">
                                						聊天记录3啊啊啊啊啊
                                					</div>
                                					<p class=""></p>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<span>2014-01-17
                                						<br />19:34:10
                                					</span>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<a href="#" id="username" data-type="text" data-placement="right" data-title="输入备注：">备注</a> |
                                					<a href="" >加星</a>
                                					<button class="btn btn-primary noty" data-noty-options='{"text":"提交成功","layout":"topCenter","type":"success","animateOpen": {"opacity": "show"}}'><i class="icon-bell icon-white"></i> </button>
                                				</div>
                                			</td>
                                		</tr>
                                		<tr class="">
                                			<td class="">
                                				<div class="">
                                					<div class="">
                                						聊天记录2啊啊啊啊啊
                                					</div>
                                					<p class=""></p>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<span>2014-01-16
                                						<br />19:34:10
                                					</span>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<a href="#" data-rel="popover" data-content="And here's some amazing content. It's very engaging. right?" title="A Title" data-placement="left">备注</a> |
                                					<a href="">加星</a>
                                					<button class="btn btn-primary noty" data-noty-options='{"text":"提交失败","layout":"topCenter","type":"error","animateOpen": {"opacity": "show"}}'><i class="icon-bell icon-white"></i> </button>
                                				</div>
                                			</td>
                                		</tr>
                                		<tr class="">
                                			<td class="">
                                				<div class="">
                                					<div class="">
                                						聊天记录1啊啊啊啊啊
                                					</div>
                                					<p class=""></p>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<span>2014-01-18
                                						<br />19:34:10
                                					</span>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<a href="">备注</a> |
                                					<a href="">加星</a>
                                				</div>
                                			</td>
                                		</tr>
                                		<tr>
                                			<td class="" colspan="2">
                                				<div class="">
                                					<div class="">
                                						<div class="">
                                							<a target="" href="./talk.html" class="">共有 8 条对话记录 </a>-
                                							<span class="" href="">点击快速回复</span>
                                						</div>
                                					</div> 
                                				</div>
                                			</td>
                                		</tr>
                                	</table>
                                </td>								
							</tr>
							<tr>
								<td class="">
                                    <div class="">
                                    	<div class="">
                                    		<a class="" href ="./talk.html">
                                    			<img src="" width="60" height="60" alt="" />
                                    		</a>
                                    	</div>
                                    </div>
                                </td>
                                <td class="">
                                	<div class="">
                                		<p>
                                			<a class="" href="./talk.html">
                                				shaq
                                			</a>
                                		</p>
                                	</div>
                                </td>
                                <td class="" colspan="3">
                                	<table class="table table-condensed">
                                		<tr class="">
                                			<td class="">
                                				<div class="">
                                					<div class="">
                                						聊天记录3啊啊啊啊啊
                                					</div>
                                					<p class=""></p>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<span>2014-01-17
                                						<br />19:34:10
                                					</span>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<a href="">备注</a> |
                                					<a href="">加星</a>
                                				</div>
                                			</td>
                                		</tr>
                                		<tr class="">
                                			<td class="">
                                				<div class="">
                                					<div class="">
                                						聊天记录2啊啊啊啊啊
                                					</div>
                                					<p class=""></p>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<span>2014-01-16
                                						<br />19:34:10
                                					</span>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<a href="">备注</a> |
                                					<a href="">加星</a>
                                				</div>
                                			</td>
                                		</tr>
                                		<tr class="">
                                			<td class="">
                                				<div class="">
                                					<div class="">
                                						聊天记录1啊啊啊啊啊
                                					</div>
                                					<p class=""></p>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<span>2014-01-18
                                						<br />19:34:10
                                					</span>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<a href="">备注</a> |
                                					<a href="">加星</a>
                                				</div>
                                			</td>
                                		</tr>
                                		<tr>
                                			<td class="" colspan="2">
                                				<div class="">
                                					<div class="">
                                						<div class="">
                                							<a target="" href="./talk.html" class="">共有 8 条对话记录 </a>-
                                							<span class="" href="">点击快速回复</span>
                                						</div>
                                					</div> 
                                				</div>
                                			</td>
                                		</tr>
                                	</table>
                                </td>								
							</tr>
							<tr>
								<td class="">
                                    <div class="">
                                    	<div class="">
                                    		<a class="" href ="./talk.html">
                                    			<img src="" width="60" height="60" alt="" />
                                    		</a>
                                    	</div>
                                    </div>
                                </td>
                                <td class="">
                                	<div class="">
                                		<p>
                                			<a class="" href="./talk.html">
                                				shaq
                                			</a>
                                		</p>
                                	</div>
                                </td>
                                <td class="" colspan="3">
                                	<table class="table table-condensed">
                                		<tr class="">
                                			<td class="">
                                				<div class="">
                                					<div class="">
                                						聊天记录3啊啊啊啊啊
                                					</div>
                                					<p class=""></p>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<span>2014-01-17
                                						<br />19:34:10
                                					</span>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<a href="">备注</a> |
                                					<a href="">加星</a>
                                				</div>
                                			</td>
                                		</tr>
                                		<tr class="">
                                			<td class="">
                                				<div class="">
                                					<div class="">
                                						聊天记录2啊啊啊啊啊
                                					</div>
                                					<p class=""></p>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<span>2014-01-16
                                						<br />19:34:10
                                					</span>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<a href="">备注</a> |
                                					<a href="">加星</a>
                                				</div>
                                			</td>
                                		</tr>
                                		<tr class="">
                                			<td class="">
                                				<div class="">
                                					<div class="">
                                						聊天记录1啊啊啊啊啊
                                					</div>
                                					<p class=""></p>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<span>2014-01-18
                                						<br />19:34:10
                                					</span>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<a href="">备注</a> |
                                					<a href="">加星</a>
                                				</div>
                                			</td>
                                		</tr>
                                		<tr>
                                			<td class="" colspan="2">
                                				<div class="">
                                					<div class="">
                                						<div class="">
                                							<a target="" href="./talk.html" class="">共有 8 条对话记录 </a>-
                                							<span class="" href="">点击快速回复</span>
                                						</div>
                                					</div> 
                                				</div>
                                			</td>
                                		</tr>
                                	</table>
                                </td>								
							</tr>
							<tr>
								<td class="">
                                    <div class="">
                                    	<div class="">
                                    		<a class="" href ="./talk.html">
                                    			<img src="" width="60" height="60" alt="" />
                                    		</a>
                                    	</div>
                                    </div>
                                </td>
                                <td class="">
                                	<div class="">
                                		<p>
                                			<a class="" href="./talk.html">
                                				shaq
                                			</a>
                                		</p>
                                	</div>
                                </td>
                                <td class="" colspan="3">
                                	<table class="table table-condensed">
                                		<tr class="">
                                			<td class="">
                                				<div class="">
                                					<div class="">
                                						聊天记录3啊啊啊啊啊
                                					</div>
                                					<p class=""></p>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<span>2014-01-17
                                						<br />19:34:10
                                					</span>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<a href="">备注</a> |
                                					<a href="">加星</a>
                                				</div>
                                			</td>
                                		</tr>
                                		<tr class="">
                                			<td class="">
                                				<div class="">
                                					<div class="">
                                						聊天记录2啊啊啊啊啊
                                					</div>
                                					<p class=""></p>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<span>2014-01-16
                                						<br />19:34:10
                                					</span>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<a href="">备注</a> |
                                					<a href="">加星</a>
                                				</div>
                                			</td>
                                		</tr>
                                		<tr class="">
                                			<td class="">
                                				<div class="">
                                					<div class="">
                                						聊天记录1啊啊啊啊啊
                                					</div>
                                					<p class=""></p>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<span>2014-01-18
                                						<br />19:34:10
                                					</span>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<a href="">备注</a> |
                                					<a href="">加星</a>
                                				</div>
                                			</td>
                                		</tr>
                                		<tr>
                                			<td class="" colspan="2">
                                				<div class="">
                                					<div class="">
                                						<div class="">
                                							<a target="" href="./talk.html" class="">共有 8 条对话记录 </a>-
                                							<span class="" href="">点击快速回复</span>
                                						</div>
                                					</div> 
                                				</div>
                                			</td>
                                		</tr>
                                	</table>
                                </td>								
							</tr>
							<tr>
								<td class="">
                                    <div class="">
                                    	<div class="">
                                    		<a class="" href ="./talk.html">
                                    			<img src="" width="60" height="60" alt="" />
                                    		</a>
                                    	</div>
                                    </div>
                                </td>
                                <td class="">
                                	<div class="">
                                		<p>
                                			<a class="" href="./talk.html">
                                				shaq
                                			</a>
                                		</p>
                                	</div>
                                </td>
                                <td class="" colspan="3">
                                	<table class="table table-condensed">
                                		<tr class="">
                                			<td class="">
                                				<div class="">
                                					<div class="">
                                						聊天记录1啊啊啊啊啊
                                					</div>
                                					<p class=""></p>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<span>2014-01-18
                                						<br />19:34:10
                                					</span>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<a href="">备注</a> |
                                					<a href="">加星</a>
                                				</div>
                                			</td>
                                		</tr>
                                		<tr>
                                			<td class="" colspan="2">
                                				<div class="">
                                					<div class="">
                                						<div class="">
                                							<a target="" href="./talk.html" class="">共有 8 条对话记录 </a>-
                                							<span class="" href="">点击快速回复</span>
                                						</div>
                                					</div> 
                                				</div>
                                			</td>
                                		</tr>
                                	</table>
                                </td>								
							</tr>
							<tr>
								<td class="">
                                    <div class="">
                                    	<div class="">
                                    		<a class="" href ="./talk.html">
                                    			<img src="" width="60" height="60" alt="" />
                                    		</a>
                                    	</div>
                                    </div>
                                </td>
                                <td class="">
                                	<div class="">
                                		<p>
                                			<a class="" href="./talk.html">
                                				shaq
                                			</a>
                                		</p>
                                	</div>
                                </td>
                                <td class="" colspan="3">
                                	<table class="table table-condensed">
                                		<tr class="">
                                			<td class="">
                                				<div class="">
                                					<div class="">
                                						聊天记录1啊啊啊啊啊
                                					</div>
                                					<p class=""></p>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<span>2014-01-18
                                						<br />19:34:10
                                					</span>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<a href="">备注</a> |
                                					<a href="">加星</a>
                                				</div>
                                			</td>
                                		</tr>
                                		<tr>
                                			<td class="" colspan="2">
                                				<div class="">
                                					<div class="">
                                						<div class="">
                                							<a target="" href="./talk.html" class="">共有 8 条对话记录 </a>-
                                							<span class="" href="">点击快速回复</span>
                                						</div>
                                					</div> 
                                				</div>
                                			</td>
                                		</tr>
                                	</table>
                                </td>								
							</tr>
							<tr>
								<td class="">
                                    <div class="">
                                    	<div class="">
                                    		<a class="" href ="./talk.html">
                                    			<img src="" width="60" height="60" alt="" />
                                    		</a>
                                    	</div>
                                    </div>
                                </td>
                                <td class="">
                                	<div class="">
                                		<p>
                                			<a class="" href="./talk.html">
                                				shaq
                                			</a>
                                		</p>
                                	</div>
                                </td>
                                <td class="" colspan="3">
                                	<table class="table table-condensed">
                                		<tr class="">
                                			<td class="">
                                				<div class="">
                                					<div class="">
                                						聊天记录1啊啊啊啊啊
                                					</div>
                                					<p class=""></p>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<span>2014-01-18
                                						<br />19:34:10
                                					</span>
                                				</div>
                                			</td>
                                			<td class="">
                                				<div class="">
                                					<a href="">备注</a> |
                                					<a href="">加星</a>
                                				</div>
                                			</td>
                                		</tr>
                                		<tr>
                                			<td class="" colspan="2">
                                				<div class="">
                                					<div class="">
                                						<div class="">
                                							<a target="" href="./talk.html" class="">共有 8 条对话记录 </a>-
                                							<span class="" href="">点击快速回复</span>
                                						</div>
                                					</div> 
                                				</div>
                                			</td>
                                		</tr>
                                	</table>
                                </td>								
							</tr>
						  </tbody>
					  </table>            
					</div>
				</div><!--/span-->
			
			</div><!--/row-->

			<div class="row-fluid sortable"></div><!--/row-->
			
			<div class="row-fluid sortable"></div><!--/row-->
			
			<div class="row-fluid sortable"></div><!--/row-->
    
					<!-- content ends -->
			</div><!--/#content.span10-->
				</div><!--/fluid-row-->
				
		<hr>
				<!-- 模态框 -->
		<div class="modal hide fade" id="myModal">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">×</button>
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
			<p class="pull-left">&copy; <a href="" target="_blank">中铁置业</a> 2014</p>
			<p class="pull-right">Powered by: <a href="">微定制</a></p>
		</footer>
		
	</div><!--/.fluid-container-->

	<!-- external javascript
	================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<!-- jQuery -->
	<script src="js/jquery-1.7.2.min.js"></script>
	<!-- jQuery UI -->
	<script src="js/jquery-ui-1.8.21.custom.min.js"></script>
	<!-- transition / effect library -->
	<script src="js/bootstrap-transition.js"></script>
	<!-- alert enhancer library -->
	<script src="js/bootstrap-alert.js"></script>
	<!-- modal / dialog library -->
	<script src="js/bootstrap-modal.js"></script>
	<!-- custom dropdown library -->
	<script src="js/bootstrap-dropdown.js"></script>
	<!-- scrolspy library -->
	<script src="js/bootstrap-scrollspy.js"></script>
	<!-- library for creating tabs -->
	<script src="js/bootstrap-tab.js"></script>
	<!-- library for advanced tooltip -->
	<script src="js/bootstrap-tooltip.js"></script>
	<!-- popover effect library -->
	<script src="js/bootstrap-popover.js"></script>
	<!-- button enhancer library -->
	<script src="js/bootstrap-button.js"></script>
	<!-- accordion library (optional, not used in demo) -->
	<script src="js/bootstrap-collapse.js"></script>
	<!-- carousel slideshow library (optional, not used in demo) -->
	<script src="js/bootstrap-carousel.js"></script>
	<!-- autocomplete library -->
	<script src="js/bootstrap-typeahead.js"></script>
	<!-- tour library -->
	<script src="js/bootstrap-tour.js"></script>
	<!-- library for cookie management -->
	<script src="js/jquery.cookie.js"></script>
	<!-- calander plugin -->
	<script src='js/fullcalendar.min.js'></script>
	<!-- data table plugin -->
	<script src='js/jquery.dataTables.min.js'></script>

	<!-- chart libraries start -->
	<script src="js/excanvas.js"></script>
	<script src="js/jquery.flot.min.js"></script>
	<script src="js/jquery.flot.pie.min.js"></script>
	<script src="js/jquery.flot.stack.js"></script>
	<script src="js/jquery.flot.resize.min.js"></script>
	<!-- chart libraries end -->

	<!-- select or dropdown enhancer -->
	<script src="js/jquery.chosen.min.js"></script>
	<!-- checkbox, radio, and file input styler -->
	<script src="js/jquery.uniform.min.js"></script>
	<!-- plugin for gallery image view -->
	<script src="js/jquery.colorbox.min.js"></script>
	<!-- rich text editor library -->
	<script src="js/jquery.cleditor.min.js"></script>
	<!-- notification plugin -->
	<script src="js/jquery.noty.js"></script>
	<!-- file manager library -->
	<script src="js/jquery.elfinder.min.js"></script>
	<!-- star rating plugin -->
	<script src="js/jquery.raty.min.js"></script>
	<!-- for iOS style toggle switch -->
	<script src="js/jquery.iphone.toggle.js"></script>
	<!-- autogrowing textarea plugin -->
	<script src="js/jquery.autogrow-textarea.js"></script>
	<!-- multiple file upload plugin -->
	<script src="js/jquery.uploadify-3.1.min.js"></script>
	<!-- history.js for cross-browser state change on ajax -->
	<script src="js/jquery.history.js"></script>
	<!-- application script for Charisma demo -->
	<script src="js/charisma.js"></script>
	
		
</body>
</html>
