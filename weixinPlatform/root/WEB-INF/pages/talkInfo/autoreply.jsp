<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/common/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增权限实体</title>
</head>
<body>	
<!-- 用户新增 -->
<div style="padding:10px 30px">
    <div class="ftitle">权限实体信息填写</div>
		<form id="fmt"  method="post"  style="padding-left: 20px ;padding-top: 10px">		
			<div class="fitem">
				<label>权限实体名称:</label>
				<input  name="moduleForm.name"  class="easyui-validatebox"  required="true"  />
			</div>
			<div class="fitem">
				<label>权限类型:</label>
				<input type="radio"  name="moduleForm.type"  value="false" checked="checked" />菜单权限
				<input type="radio"  name="moduleForm.type"  value="true" />执行权限
			</div>
			<div class="fitem">
				<label>功能权限编码:</label>
				<input  name="moduleForm.code"  class="easyui-validatebox"  />
			</div>
			<div class="fitem">
				<label>菜单选择:</label>
				<select class="easyui-combotree"  name="moduleForm.menuId"   id="menuId"  url="${basePath}/system/menu/menuQueryForComboTree.do"  style="width:200px;"></select>
			</div>
			<div class="fitem">
				<label>权限匹配:</label>
				<textarea rows="5"  id="description"  cols="35"  class="easyui-validatebox"  required="true"   name="moduleForm.patternUrl"  ></textarea>
			</div>
			<div class="fitem">
				<label>是否启用:</label>
				<input type="radio"  name="moduleForm.extends1"  value="1" checked="checked" />启用
				<input type="radio"  name="moduleForm.extends1"  value="2" />禁用
			</div>
			<div class="fitem">
				<label>权限描述:</label>
				<textarea rows="3"  id="description"  cols="35"  name="moduleForm.description"></textarea>
			</div>
		</form>
</div>
<script>
//新增保存
function savereg(){
		$('#fmt').form('submit',{
				url:'${basePath}/system/module/addModuleAction.do',
				success: function(data){
					$('#dd').dialog('close');
					var jsonObj = eval("("+data+")");
					$('#dg').datagrid('insertRow',{
						row: {
							id: jsonObj.id,
							name: jsonObj.name,
							description: jsonObj.description,
							code: jsonObj.code,
							patternUrl: jsonObj.patternUrl,
							updateDate:  jsonObj.updateDate,
							createDate: jsonObj.createDate,
						}
					});
				}
		});
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
