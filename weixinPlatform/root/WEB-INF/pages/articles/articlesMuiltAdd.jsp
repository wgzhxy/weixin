<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/common/easyUiInclude.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>图文管理</title>
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
	        		 <a href="#" class="btn btn-primary"  onclick="doSearch()">
	        		 	<i class="icon-search icon-white"></i>开始查询
	        		 </a>
        		 </span>
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
    	<a href="#"  class="easyui-linkbutton"  iconCls="icon-add"  plain="true"  onclick="javascript:jumpNewPage('single');">新增单图文</a>
    	<a href="#"  class="easyui-linkbutton"  iconCls="icon-add"  plain="true"  onclick="javascript:jumpNewPage('multi');">新增多图文</a>
    	<a href="#"  class="easyui-linkbutton"  iconCls="icon-edit"  plain="true"  onclick="javascript:jumpEditPage();">图文修改</a>
    	<a href="#"  class="easyui-linkbutton"  iconCls="icon-remove"  plain="true"  onclick="javascript:$('#dg').edatagrid('destroyRow')">删除</a>
	</div>
	<script type="text/javascript">
	//弹出新增窗口multi:多图文;single:单图文
	function jumpNewPage(obj){
		window.location.href="${basePath}/articles/articlesBase.do?jump="+obj;
	}
	function jumpEditPage(){
		var types=2;
		var row=$("#articles-table").datagrid("getSelected");
		if(row !=null){
			var id=row.id;
			var picType=""+row.picType+"";
			window.location.href="${basePath}/articles/articlesBase.do?jump=edit&weixinArticlesForm.id="+id+"&weixinArticlesForm.picType="+types;
		}else{
			$.messager.alert('温馨提示', '没有选中记录');
			return ;
		}
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