<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/common/easyUiInclude.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>微信页面分类管理</title>
	<script type="text/javascript"  src="${basePath}/easyUi/js/jquery.edatagrid.js"></script>
	<script type="text/javascript"  src="${basePath}/easyUi/js/method.js"></script>
</head>			
<body>
	<div id="tb"  style="padding:6px" title="微信消息筛选" class="easyui-panel"  iconCls="icon-search">
		    <div id="row"  style="padding: 7px;">
		    	<span style="padding-left: 20px;"><input type="checkBox"/>&nbsp;<a href="#">所有分类</a>&nbsp; </span>
				<span style="padding-left: 20px;">标题 :&nbsp; </span>
			    <input  id="pictureName" />
			    <span style="padding-left: 20px;"><a href="#" class="easyui-linkbutton"  onclick="doSearch()">搜索</a></span>
		    </div>
	</div>
	<p></p>
	<table id="dg" width="100%"></table>
	<!-- 编辑 -->
	<div id="dlg-buttons_edit"  style="text-align: left;">
	    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"  onclick="javascript:$('#dg').edatagrid('addRow')">新增</a>
    	<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"  onclick="javascript:$('#dg').edatagrid('destroyRow')">删除</a>
    	<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"  onclick="javascript:$('#dg').edatagrid('saveRow')">保存</a>
    	<a href="#" class="easyui-linkbutton" iconCls="icon-undo" plain="true"  onclick="javascript:$('#dg').edatagrid('cancelRow')">取消</a>
	</div>
	<script type="text/javascript">
			function doSearch() {
				var queryParams = $('#dg').datagrid('options').queryParams;
				queryParams['weixinPageClassVo.urlType'] = '0';
				$('#dg').datagrid("load");
			};
			
			$(function(){
				$('#dg').edatagrid({
					url: '${basePath}/pagePageClassList.do',
					saveUrl: '${basePath}/pagePageClassSave.do',
					updateUrl: '${basePath}/pagePageClassSave.do',
					destroyUrl: '${basePath}/pagePageClassDelete.do',
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
				
				$('#dg').datagrid({
						idField : "id",
						title : "微信页面管理",
						iconCls: 'icon-reload',
						nowrap : true,
						height : 450,
						striped : true,
						collapsible : false,
						remoteSort : false,
						pagination : true,
						fitColumns: true,
						rownumbers : false,
						singleSelect: true,
						ulr: '${basePath}/pagePageClassList.do?weixinPageClassVo.urlType=0',
						toolbar: '#dlg-buttons_edit',
						columns:[[
								 {title:'ID',field:'id',width:fixWidth(0.2),rowspan:2,align:'center'},
							     {title:'分类名称',field:'className',width:fixWidth(0.15),rowspan:2,align:'center', editor:{type:'validatebox',options:{required:true}}},
							     {title:'排序',field:'type',width:fixWidth(0.15),rowspan:2,align:'center',editor:{type:'validatebox',options:{required:false}}},
							     {title:'分类简介',field:'classDesc',width:fixWidth(0.3),rowspan:2,align:'center', editor:{type:'validatebox',options:{required:false}}},
							     {title:'创建时间',field:'createTime',width:fixWidth(0.15),rowspan:2,align:'center'}			    				
							    ]],
						onLoadSuccess:function(){
						}
				});
		});
	</script>
</body>
</html>
