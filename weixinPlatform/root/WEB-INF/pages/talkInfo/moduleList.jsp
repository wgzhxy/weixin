<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/common/easyUiInclude.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>权限实体管理</title>
	<script type="text/javascript"  src="${basePath}/easyUi/js/jquery.edatagrid.js"></script>
</head>
<body>
	<div id="tb"  style="padding:6px" title=" 查询条件" class="easyui-panel"  iconCls="icon-search">
 			<div id="row"  style="padding: 7px;">
			    <span style="padding-left: 20px;">权限实体名称 :&nbsp; </span>
			    <input  id="name" />
			    <span style="padding-left: 20px;">权限模型描述 :&nbsp; </span>
			    <input  id="description"/>
			    <span style="padding-left: 20px;"><a href="#" class="easyui-linkbutton"  onclick="doSearch()">开始查询</a></span>
		    </div>
	</div>
	<p></p>
	
	<table id="dg" title="权限实体管理" class="easyui-datagrid"  url="${basePath}/system/module/listModules.do"  style="width: 100%; height: 380px"  idField="id"
			   toolbar="#toolbar"  rownumbers="false"  fitColumns="true"  pagination="true"  pagePosition = "bottom"  iconCls="icon-reload"
			   singleSelect="false">
		<thead>
			<tr>
				<th field="ck"  checkbox="true" ></th>
				<th field="id"  width="10%"  align="center"  height="30px">ID</th>
				<th field="name"  width="20%"  align="center">权限实体名称</th>
				<th field="patternUrl"  width="20%"  align="left">权限匹配</th>
				<th field="description"  width="20%"  align="left">描述</th>
				<th field="updateDate"  width="15%"  align="center">更新时间</th>
				<th field="createDate"  width="15%"  align="center">创建时间</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar" >
    	<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"  onclick="addModule();">新增</a>
    	<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"  onclick="javascript:$('#dg').edatagrid('destroyRow')">删除</a>
    	<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"  onclick="editModule();">编辑</a>
	</div>
	
	<!-- 新增 -->
	<div id="dd"  class="easyui-dialog"  style="padding:10px 30px"  closed="true"   title="系统菜单新增"  buttons="#dlg-buttons" >
	</div>
	<div id="dlg-buttons"  style="text-align: right;">
	    <a href="#"  class="easyui-linkbutton"  iconCls="icon-ok"  onclick="savereg();">提交</a>
	    <a href="#"  class="easyui-linkbutton"  iconCls="icon-cancel"  onclick="javascript:$('#dd').dialog('close')">取消</a>
	</div>
	
	<!-- 编辑 -->
	<div id="de"  class="easyui-dialog"  style="padding:10px 30px"  closed="true"   title="系统菜单编辑"  buttons="#dlg-buttons_edit" >
	</div>
	<div id="dlg-buttons_edit"  style="text-align: right;">
	    <a href="#"  class="easyui-linkbutton"  iconCls="icon-ok"  onclick="saveEdit();">提交</a>
	    <a href="#"  class="easyui-linkbutton"  iconCls="icon-cancel"  onclick="javascript:$('#de').dialog('close')">取消</a>
	</div>
	<script type="text/javascript">
			//编辑
			function editModule() {
				var row = $('#dg').datagrid('getSelected');
				if (row) {
						if(row.id == '') {
							$.messager.show({  
					                title: '警告',  
					                msg: '所选记录ID为空，不能进行编辑操作!',  
					                showType: 'slide'  
			            	});  
			            	return;
						}
						var index = $('#dg').datagrid('getRowIndex', row);
						$('#de').dialog({
								href: '${basePath}/system/module/editModulePage.do?moduleForm.id=' + row.id + "&index=" + index ,
							    title: '编辑权限实体',
							    closed: false,
							    iconCls: 'icon-save',
							    width: 500,
							    height: 480,
							    cache: false,
							    modal: true,
							    resizable:true
						});
				} else {
					$.messager.show({  
			                title: '警告',  
			                msg: '请选择要操作的记录!.',  
			                timeout: 2000,  
			                showType: 'slide'  
		            });  
				}
			}
		    //弹出新增窗口
			function addModule(){
					$('#dd').dialog({
							href: '${basePath}/system/module/addModulePage.do',
						    title: '新增权限实体',
						    closed: false,
						    iconCls: 'icon-save',
						    width: 500,
						    height: 480,
						    cache: false,
						    modal: true,
						    resizable:true
					});
			}
	
			function doSearch() {
				var name = $.trim($('#name').val());
				var description = $.trim($('#description').val());
				var queryParams = $('#dg').datagrid('options').queryParams;
				queryParams['moduleForm.name'] = name;
				queryParams['moduleForm.description'] = description;
				$('#dg').datagrid("load");
			};
		
			$(function(){
				$('#dg').edatagrid({
					url: '${basePath}/system/module/listModules.do',
					destroyUrl: '${basePath}/system/module/delModuleAction.do',
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
							nowrap : false,
							height : 380,
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