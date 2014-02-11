<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/common/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑权限实体</title>
</head>
<body>	
<!-- 用户新增 -->
<div style="padding:10px 30px">
    <div class="ftitle">权限实体信息填写</div>
		<form id="editFmt"  method="post"  style="padding-left: 20px ;padding-top: 10px">		
			<input type="hidden"  name="moduleForm.id"  value="<c:if test="${vo !=null}">${vo.id }</c:if>" />
			 <input type="hidden"  id="index"  value="${index}" />
			<div class="fitem">
				<label>权限实体名称:</label>
				<input  name="moduleForm.name"  value="<c:if test="${vo !=null}">${vo.name }</c:if>"  class="easyui-validatebox"  required="true"  />
			</div>
			<div class="fitem">
				<label>权限类型:</label>
				<input type="radio"  name="moduleForm.type"  value="false"  <c:if test="${vo !=null && vo.type == false}">checked="checked"</c:if> />菜单权限
				<input type="radio"  name="moduleForm.type"  value="true"  <c:if test="${vo !=null && vo.type == true}">checked="checked"</c:if> />执行权限
			</div>
			<div class="fitem">
				<label>功能权限编码:</label>
				<input  name="moduleForm.code"  value="<c:if test="${vo !=null}">${vo.code }</c:if>"   />
			</div>
			<div class="fitem">
				<label>菜单选择:</label>
				<input  name="moduleForm.menuId"  class="easyui-combotree"   value="<c:if test="${vo !=null}">${vo.menuId }</c:if>"   url="${basePath}/system/menu/menuQueryForComboTree.do"   class="easyui-validatebox" />
			</div>
			<div class="fitem">
				<label>权限匹配:</label>
				<input id="patternUrl"  size="32"  class="easyui-validatebox"  required="true"   name="moduleForm.patternUrl"  value="<c:if test="${vo !=null}">${vo.patternUrl }</c:if>"  />
			</div>
			<div class="fitem">
				<label>是否启用:</label>
				<input type="radio"  name="moduleForm.extends1"  value="1"  <c:if test="${vo !=null and vo.extend1 == '1'}">checked="checked"</c:if> />启用
				<input type="radio"  name="moduleForm.extends1"  value="2"  <c:if test="${vo !=null and vo.extend1 == '2'}">checked="checked"</c:if> />禁用
			</div>
			<div class="fitem">
				<label>权限描述:</label>
				<textarea rows="5"  id="description"  cols="30"  name="moduleForm.description"><c:if test="${vo !=null}">${vo.description }</c:if></textarea>
			</div>
		</form>
</div>
<script>
//新增保存
function saveEdit(){
		$('#editFmt').form('submit',{
				url:'${basePath}/system/module/editModuleAction.do',
				success: function(data){
					$('#de').dialog('close');
					var jsonObj = eval("("+data+")");
					$('#dg').datagrid('updateRow', {
						index: $("#index").val(),
						row: {
							id: jsonObj.id,
							name: jsonObj.name,
							description: jsonObj.description,
							patternUrl: jsonObj.patternUrl,
							code: jsonObj.code,
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
