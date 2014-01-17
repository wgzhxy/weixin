<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="span2 main-menu-span">
	<div class="well nav-collapse sidebar-nav">
		<ul class="nav nav-tabs nav-stacked main-menu">
			<li class="nav-header hidden-tablet">Main</li>
			<li><a class="ajax-link" href="javascript:changePage('index.jsp');"><i class="icon-home"></i><span class="hidden-tablet"> Dashboard</span></a></li>
			<li><a class="ajax-link" href="javascript:changePage('ui.jsp');"><i class="icon-eye-open"></i><span class="hidden-tablet"> UI Features</span></a></li>
			<li><a class="ajax-link" href="javascript:changePage('form.jsp');"><i class="icon-edit"></i><span class="hidden-tablet"> Forms</span></a></li>
			<li><a class="ajax-link" href="javascript:changePage('chart.jsp');"><i class="icon-list-alt"></i><span class="hidden-tablet"> Charts</span></a></li>
			<li><a class="ajax-link" href="javascript:changePage('typography.jsp');"><i class="icon-font"></i><span class="hidden-tablet"> Typography</span></a></li>
			<li><a class="ajax-link" href="javascript:changePage('gallery.jsp');"><i class="icon-picture"></i><span class="hidden-tablet"> Gallery</span></a></li>
			<li class="nav-header hidden-tablet">Sample Section</li>
			<li><a class="ajax-link" href="javascript:changePage('table.jsp');"><i class="icon-align-justify"></i><span class="hidden-tablet"> Tables</span></a></li>
			<li><a class="ajax-link" href="javascript:changePage('calendar.jsp');"><i class="icon-calendar"></i><span class="hidden-tablet"> Calendar</span></a></li>
			<li><a class="ajax-link" href="javascript:changePage('grid.jsp');"><i class="icon-th"></i><span class="hidden-tablet"> Grid</span></a></li>
			<li><a class="ajax-link" href="javascript:changePage('file-manager.jsp');"><i class="icon-folder-open"></i><span class="hidden-tablet"> File Manager</span></a></li>
			<li><a href="javascript:changePage('tour.jsp');"><i class="icon-globe"></i><span class="hidden-tablet"> Tour</span></a></li>
			<li><a class="ajax-link" href="javascript:changePage('icon.jsp');"><i class="icon-star"></i><span class="hidden-tablet"> Icons</span></a></li>
			<li><a href="javascript:changePage('error.jsp');"><i class="icon-ban-circle"></i><span class="hidden-tablet"> Error Page</span></a></li>
			<li><a href="javascript:changePage('login.jsp');"><i class="icon-lock"></i><span class="hidden-tablet"> Login Page</span></a></li>
		</ul>
		<label id="for-is-ajax" class="hidden-tablet" for="is-ajax"><input id="is-ajax" type="checkbox"> Ajax on menu</label>
	</div><!--/.well -->
</div><!--/span-->
