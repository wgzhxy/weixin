<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/common/easyUiInclude.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>菜单修改</title>
	<script type="text/javascript"  src="${basePath}/easyUi/js/jquery.edatagrid.js"></script>
</head>
<body>
	<div style="padding:10px 80px">
    <div class="ftitle">菜单信息填写</div>
		<form id="fmt"  method="post"  style="padding-left: 20px ;padding-top: 10px">
			<input  name="weixinMenuForm.id"  class="easyui-validatebox"  value="<c:if test="${weixinMenu!=null}">${weixinMenu.id}</c:if>" type="hidden" />		
			<div class="fitem">
				<label>菜单名称:</label>
				<input id="menu-name" name="weixinMenuForm.menuName"  class="easyui-validatebox" value="<c:if test="${weixinMenu!=null}">${weixinMenu.menuName}</c:if>" required="true"  />
			</div>
			<div class="fitem">
				<label>菜单类型:</label>
				<select name="weixinMenuForm.button" onchange="chooseMenuParent(this.value);" id="menu-button">
						<option value="button" selected='true'>一级菜单</option>
						<option value="sub_button">二级菜单</option>
				</select>
			</div>
			<div class="fitem">
				<label>动作类型:</label>
				<select name="weixinMenuForm.type" onchange="chooseMenuType(this.value);" id="menu-type">
						<option value="click" selected='true'>click</option>
						<option value="view">view</option>
				</select>
			</div>
			<div class="fitem">
				<label>是否启用:</label>
				<select name="weixinMenuForm.state" id="menu-state">
						<option value="1">启用</option>
						<option value="0">停用</option>
				</select>
			</div>
			<div class="fitem" style="display:block" id="key-view">
				<label>菜单KEY值:</label>
				<input  name="weixinMenuForm.menuKey"  class="easyui-validatebox"  value="<c:if test="${weixinMenu!=null}">${weixinMenu.menuKey}</c:if>" />
			</div>
			<div class="fitem" style="display:none" id="url-view">
				<label>网页链接:</label>
				<input name="weixinMenuForm.url"  class="easyui-validatebox"  value="<c:if test="${weixinMenu!=null}">${weixinMenu.url}</c:if>" />
			</div>
			<div class="fitem" id="parent-view-edit" style="display:none">
				<label>父级菜单:</label>
				<input class="easyui-combobox"   
				   name="weixinMenuForm.parentId"  
				   url="${basePath}/menus/menuList.do?weixinMenuForm.parentId=0"   
				   valueField="id"   
				   textField="menuName"   
				   panelHeight="auto"  
				   id="parentid-combobox" 
				 /> 
			</div>
		</form>
</div>

<script type="text/javascript">

	//初始化数据
	$(function(){
		var menu_state_tmp="${weixinMenu.state}";
		$("#menu-state").attr("value",menu_state_tmp);
		
		 var menu_button_tmp="${weixinMenu.button}";
		 if(menu_button_tmp==""){
		 	$("#menu-button").attr("value","sub_button");
			$("#parent-view-edit").css("display","block");
			$("#parentid-combobox").combobox("select","${weixinMenu.parentId}");
		}else{
			$("#menu-button").attr("value","button");
			$("#parent-view-edit").css("display","none");
		} 
		
		var menu_type_tmp="${weixinMenu.type}";
		if(menu_type_tmp=="click"){
			$("#key-view").css("display","block");
			$("#url-view").css("display","none");
		}else{
			$("#url-view").css("display","block");
			$("#key-view").css("display","none");
		}
		$("#menu-type").attr("value",menu_type_tmp);
	});

	function edit(){
		var menu_name_old="${weixinMenu.menuName}";
		var menu_name_new=$("#menu-name").val();
		falg=1;
		if(menu_name_old!=menu_name_new){//是否被修改过名称
			falg=2;
		}
	
		$('#fmt').form('submit',{
				url:'${basePath}/menus/menuEdit.do?falg='+falg,
				success: function(data){
					if(data=='100'){
						$.messager.alert('提示信息','您添加的菜单已经存在,不能重复进行添加');
					}else{
						$('#dd-edit').dialog('close');
						$('#table-menu').treegrid("load");
					}
				}
		});
	}

	function chooseMenuParent(value) {
		if(value =='button') {
			$("#parent-view-edit").css('display','none'); 
		}else{
			$("#parent-view-edit").css('display','block');
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
	};
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