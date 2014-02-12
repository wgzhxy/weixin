<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/common/easyUiInclude.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>图片管理</title>
	<script type="text/javascript"  src="${basePath}/easyUi/js/jquery.edatagrid.js"></script>
</head>
<body>
	<div id="tb"  style="padding:6px" title=" 查询条件" class="easyui-panel"  iconCls="icon-search">
 			<div id="row"  style="padding: 7px;">
			    <span style="padding-left: 20px;">图文标题 :&nbsp; </span>
			    <input  id="title" />
    			 <span style="padding-left: 20px;">图文类型 :&nbsp; </span>
    				 <input type="radio" name="state" value="1" checked="true"><span>单图文</span>
        		 	 <input type="radio" name="state" value="2" id="state"><span>多图文</span>
        		 <span style="padding-left: 20px;">
        		 <a href="#" class="btn btn-primary"  onclick="doSearch()"><i class="icon-search icon-white"></i>开始查询</a></span>
		    </div>
	</div>
	<p></p>
	
	<table id="articles-table" title="图片管理" class="easyui-datagrid"  style="width: 100%; height: 400;" idField="id"  
			   toolbar="#toolbar"  rownumbers="false"  fitColumns="true"  pagination="true"  pagePosition = "bottom"  iconCls="icon-reload" 
			   nowrap="false"  striped ="true"  collapsible="false"  remoteSort ="false"   singleSelect="true">
		<thead>
			<tr>
				<th field="ck"  checkbox="true" ></th>
				<th field="id"  width="10%"  align="center">ID</th>
				<th field="title"  width="10%"  align="center">标题</th>
				<th field="picType"  width="10%"  align="center">图文类型</th>
				<th field="status"  width="10%"  align="center">状态</th>
				<th field="description" width="25%" align="center">描述</th>
				<th field="createTime"  width="20%"  align="center">创建时间</th>
				<th field="modifyTime"  width="20%"  align="center">更新时间</th>	
			</tr>
		</thead>
	</table>
	<div id="toolbar">
    	<a href="#"  class="easyui-linkbutton"  iconCls="icon-add"  plain="true"  onclick="javascript:addSingleArticles();">新增单图文</a>
    	<a href="#"  class="easyui-linkbutton"  iconCls="icon-add"  plain="true"  onclick="javascript:addMultiArticles();">新增多图文</a>
    	<a href="#"  class="easyui-linkbutton"  iconCls="icon-edit"  plain="true"  onclick="javascript:editArticles();">图文修改</a>
    	<a href="#"  class="easyui-linkbutton"  iconCls="icon-remove"  plain="true"  onclick="javascript:$('#dg').edatagrid('destroyRow')">删除</a>
	</div>
	<!-- 单图文新增 -->
	<div id="dialog-single"  class="easyui-dialog"  closed="true"   title="单图文新增"  buttons="#dialog-single-buttons" >
	</div>
	<div id="dialog-single-buttons"  style="text-align: center;">
	    <a href="#"  class="easyui-linkbutton"  iconCls="icon-ok"  onclick="save();">保存</a>
	    <a href="#"  class="easyui-linkbutton"  iconCls="icon-ok"  onclick="save();">发送</a>
	    <a href="#"  class="easyui-linkbutton"  iconCls="icon-cancel"  onclick="javascript:$('#dialog-single').dialog('close')">取消</a>
	</div>
	<!-- 多图文新增 -->
	<div id="dialog-multi"  class="easyui-dialog"  closed="true"   title="多图文新增"  buttons="#dialog-multi-buttons" >
	</div>
	<div id="dialog-multi-buttons"  style="text-align: center;">
	    <a href="#"  class="easyui-linkbutton"  iconCls="icon-ok"  onclick="save();">提交</a>
	    <a href="#"  class="easyui-linkbutton"  iconCls="icon-cancel"  onclick="javascript:$('#dialog-multi').dialog('close')">取消</a>
	</div>
	<!-- 图文修改 -->
	<div id="dialog-edit"  class="easyui-dialog"   closed="true"   title="图文修改"  buttons="#dialog-edit-buttons" >
	</div>
	<div id="dialog-edit-buttons"  style="text-align: center;">
	    <a href="#"  class="easyui-linkbutton"  iconCls="icon-ok"  onclick="edit();">提交</a>
	    <a href="#"  class="easyui-linkbutton"  iconCls="icon-cancel"  onclick="javascript:$('#dialog-edit').dialog('close')">取消</a>
	</div>
	<script type="text/javascript">
	//弹出新增窗口
	function addSingleArticles(){
	 	 $('#dialog-single').dialog({
			href: '${basePath}/articles/articlesBase.do?jump=single',
		    title: '单图文',
		    closed: false,
		    iconCls: 'icon-save',
		    width: 800,
		    height: 480,
		    cache: false,
		    modal: true,
		    resizable:true
		});
	}
	//弹出新增窗口
	function addMultiArticles(){
		$('#dialog-single').dialog({
					href: '${basePath}/articles/articlesBase.do?jump=multi',
				    title: '多图文',
				    closed: false,
				    iconCls: 'icon-save',
				    width: 800,
		   			height: 480,
				    cache: false,
				    modal: true,
				    resizable:true
			});
	}
	function editArticles(){
		var row=$("#articles-table").datagrid("getSelected");
		if(row !=null){
			var id=row.id;
			var picType=row.picType;
			var id=row.id;
		}else{
			$.messager.alert('温馨提示', '没有选中记录');
			return ;
		} 
		$('#dialog-edit').dialog({
			href: '${basePath}/articles/articlesBase.do?jump=edit&weixinArticlesForm.id='+id+'&weixinArticlesForm.picType=1',
		    title: '图文修改',
		    closed: false,
		    iconCls: 'icon-edit',
		    width: 800,
		    height: 480,
		    cache: false,
		    modal: true,
		    resizable:true
		});
	}
	
	//搜索功能
		function doSearch() {
				var title = $.trim($('#title').val());
				var state=1;
				if(document.getElementById("state").checked){
					state=2;
				}
				var queryParams = $('#articles-table').datagrid('options').queryParams;
				queryParams['weixinArticlesForm.title'] = title;
				queryParams['weixinArticlesForm.picType'] = state;
				$('#articles-table').datagrid("load");
		};
	    //初使化 edatagrid
		$(function(){
				$('#articles-table').edatagrid({
						url: '${basePath}/articles/articlesList.do',
						destroyUrl: '${basePath}/articles/articlesRemove.do',
						destroyMsg:{
							norecord:{	// when no record is selected
								title:'警告',
								msg:'没有选中记录!'
							},
							confirm:{	// when select a row
								title:'提示',
								msg:'你确认删出记录吗?'
							}
					}
				});
				//初始 datagrid
				$('#articles-table').datagrid({
					nowrap : false,
					height : 500,
					striped : true,
					collapsible : false,
					remoteSort : false,
					pagination : true,
					fitColumns: true,
					rownumbers : false,
				});
		});
</script>
</body>
</html>