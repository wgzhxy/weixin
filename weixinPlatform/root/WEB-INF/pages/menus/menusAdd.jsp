<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/common/easyUiInclude.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>菜单新增</title>
	<script type="text/javascript"  src="${basePath}/easyUi/js/jquery.edatagrid.js"></script>
</head>
<body>
	<div style="padding:10px 80px">
    <div class="ftitle">菜单信息填写</div>
		<form id="fmt"  method="post"  style="padding-left: 20px ;padding-top: 10px">
			<div class="fitem">
				<label>菜单名称:</label>
				<input  name="weixinMenuForm.menuName"  class="easyui-validatebox"  required="true"  />
			</div>
			<div class="fitem">
				<label>菜单类型:</label>
				<select name="weixinMenuForm.button" onchange="chooseMenuParent(this.value);" >
						<option value="button" selected='true'>一级菜单</option>
						<option value="sub_button">二级菜单</option>
				</select>
			</div>
			<div class="fitem">
				<label>动作类型:</label>
				<select name="weixinMenuForm.type" onchange="chooseMenuType(this.value);" >
						<option value="click" selected='true'>click</option>
						<option value="view">view</option>
				</select>
			</div>
			<div class="fitem" style="display:block" id="key-view">
				<label>菜单KEY值:</label>
				<input  name="weixinMenuForm.menuKey"  class="easyui-validatebox"  />
			</div>
			<div class="fitem" style="display:none" id="url-view">
				<label>网页链接:</label>
				<input name="weixinMenuForm.url"  class="easyui-validatebox"   />
			</div>
			<div class="fitem" id="parent-view" style="display:none">
				<label>父级菜单:</label>
				<input class="easyui-combobox"   
				   name="weixinMenuForm.parentId"  
				   url="${basePath}/menus/menuList.do?weixinMenuForm.parentId=0"   
				   valueField="id"   
				   textField="menuName"   
				   panelHeight="auto"  
				   /> 
			</div>
		</form>
</div>

<script type="text/javascript">
	function save(){
		$('#fmt').form('submit',{
				url:'${basePath}/menus/menuAdd.do',
				success: function(data){
					if(data=='100'){
						$.messager.alert('提示信息','您添加的菜单已经存在,不能重复进行添加');
					}else{
						$('#dd-save').dialog('close');
						$('#table-menu').treegrid("load");
					}
				}
		});
	}

	function chooseMenuParent(value) {
		if(value =='button') {
			$("#parent-view").css('display','none'); 
		}else{
			$("#parent-view").css('display','block');
		}
	};
	
	function chooseMenuType(value) {
		if(value =='click') {
			$("#key-view").css('display','block'); 
			$("#url-view").css('display','none');
		}else{
			$("#url-view").css('display','block');
			$("#key-view").css('display','none'); 
		}
	}
</script>
<style type="text/css">
		#fm {
			margin:0;
			padding:1px 30px;
		}
		.ftitle{
			font-size:14px;
			font-weight:bold;
			padding:5px 0;
			margin-bottom:10px;
			border-bottom:1px solid #ccc;
		}
		.fitem{
			margin-bottom:5px;
		}
		.fitem label{
			display:inline-block;
			width:80px;
		}
</style>
</body>
</html>