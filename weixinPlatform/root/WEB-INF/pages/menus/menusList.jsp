<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/common/easyUiInclude.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>微信平台菜单管理</title>
    <script type="text/javascript"  src="${basePath}/easyUi/js/jquery.edatagrid.js"></script>
</head>
<body>
	<div id="tb"  style="padding:6px;text-align:center" title="查询条件" class="easyui-panel"  iconCls="icon-search">
	       <a href="#" class="btn btn-primary"  onclick="javascript:doSearchMenusList();">
	       		<i class="icon-search icon-white"></i>开始查询
	       </a>
	       <a href="#" class="btn btn-primary"  onclick="javascript:doPushToWeixin();">
	       		<i class="icon-save icon-white"></i>创建菜单
	       </a>
	</div>
    	<table id="table-menu" 
    		   title="菜单列表" 
    		   class="easyui-treegrid"  
    		   idField="id"  
			   rownumbers="false"  
			   treeField="menuName" 
			   fitColumns="true"  
			   pagination=false  
			   iconCls="icon-reload" 
			   nowrap="false"  
			   striped ="true"  
			   url="${basePath}/menus/menuTreeGrid.do" 
			   collapsible="false"  
			   remoteSort ="false"  
			   toolbar="#toolbar"  
			   singleSelect="true">
        <thead>
            <tr>
            	<th field="id" width="10%" align="center">ID</th>
                <th field="menuName" width="20%" align="center">菜单名称</th>
                <th field="type" width="10%" align="center">动作类型</th>
                <th field="button" width="10%" align="center">父级菜单</th>
                <th field="subButton" width="10%" align="center">子级菜单</th>
                <th field="menuKey" width="10%" align="center">菜单KEY值</th>
                <th field="url" width="20%" align="center">网页链接</th>
                <th field="parentId" width="10%" align="center">父菜单ID</th>
                <th field="state" width="10%" align="center">菜单状态</th>
            </tr>
        </thead>
    </table>
    <div id="toolbar">
    	<a href="#"  class="easyui-linkbutton"  iconCls="icon-add"  plain="true"  onclick="javascript:addMenus();">新建菜单</a>
    	<a href="#"  class="easyui-linkbutton"  iconCls="icon-edit"  plain="true"  onclick="javascript:editMenus();">菜单修改</a>
	</div>
	
	<!-- 新增 -->
	<div id="dd-save"  class="easyui-dialog"  style="padding: 10px"  closed="true"   title="菜单新增"  buttons="#dlg-save-buttons" >
	</div>
	<div id="dlg-save-buttons"  style="text-align: right;">
	    <a href="#"  class="easyui-linkbutton"  iconCls="icon-ok"  onclick="save();">提交</a>
	    <a href="#"  class="easyui-linkbutton"  iconCls="icon-cancel"  onclick="javascript:$('#dd-save').dialog('close')">取消</a>
	</div>
	<!--修改-->
	<div id="dd-edit"  class="easyui-dialog"  style="padding: 10px"  closed="true"   title="菜单修改"  buttons="#dlg-edit-buttons" >
	</div>
	<div id="dlg-edit-buttons"  style="text-align: right;">
	    <a href="#"  class="easyui-linkbutton"  iconCls="icon-ok"  onclick="edit();">提交</a>
	    <a href="#"  class="easyui-linkbutton"  iconCls="icon-cancel"  onclick="javascript:$('#dd-edit').dialog('close')">取消</a>
	</div>
    <script>
        function doSearchMenusList(){
			$('#table-menu').treegrid("load");
        };
        
        function doPushToWeixin(){
        	
        };
        
  function addMenus(){
		$('#dd-save').dialog({
			href: '${basePath}/menus/menuBase.do?jump=add',
		    title: '新增菜单',
		    closed: false,
		    iconCls: 'icon-save',
		    width: 500,
		    height: 480,
		    cache: false,
		    modal: true,
		    resizable:true
		});
	};
	
	function editMenus(){
		var node = $("#table-menu").treegrid("getSelected");
		$('#dd-edit').dialog({
			href: '${basePath}/menus/menuBase.do?jump=edit&id='+node.id,
		    title: '修改菜单',
		    closed: false,
		    iconCls: 'icon-edit',
		    width: 500,
		    height: 480,
		    cache: false,
		    modal: true,
		    resizable:true
		});
	};
    </script>
</body>
</html>