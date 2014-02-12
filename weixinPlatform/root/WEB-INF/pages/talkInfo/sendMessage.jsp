<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/common/easyUiInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信消息发送</title>
<script src="${basePath}/ckeditorStd/ckeditor.js"></script>
</head>
<body>	
<!-- 微信消息发送 -->
<div class="container-fluid">
<div class="row-fluid">
<div class="box span8">
	<div class="box-header well" data-original-title>
		<h3>微信消息发送</h3>						
	</div>
	<div class="box-content">
		<form id="fmt" method="post" style="padding-left: 80px; padding-top: 15px">
			<div class="fitem">
				<label>页面名称:</label>
				<input style="width: 300px" name="addUserForm.username"  class="easyui-validatebox"  required="true"  />
			</div>
			<div class="fitem">
				<label>分类:</label>
				<select id="num">			
					<option value="0">请选择</option>	
					<option value="1">分类二</option>
					<option value="2">分类三</option>
					<option value="3">分类四</option>
					<option value="4">分类五</option>
					<option value="5">分类六</option>
					<option value="6">分类七</option>
				</select>
			</div>
			<div class="fitem">
				<label>正文标题:</label>
				<input id="rpwd" style="width: 280px" name="rpwd"  class="easyui-validatebox"   required="required"  validType="equals['#pwd']" />
			</div>
			<div class="fitem">
				<label>富文本正文:</label>
				<div style="padding-left: 80px">
					<textarea id="contents"  name="cmsForumForm.contents" rows="20" cols="80" ></textarea>
				</div>
			</div>
			<div class="fitem">
				<label>关联链接:</label>
				<select id="num">			
					<option value="0">请选择</option>	
					<option value="1">分类二</option>
					<option value="2">分类三</option>
					<option value="3">分类四</option>
					<option value="4">分类五</option>
					<option value="5">分类六</option>
					<option value="6">分类七</option>
				</select>
			</div>
			<div class="fitem">
				<label>显示条数:</label>
				<select id="num">			
					<option value="0">0条</option>	
					<option value="1">1条</option>
					<option value="2">2条</option>
					<option value="3">3条</option>
					<option value="4">4条</option>
					<option value="5">5条</option>
					<option value="6">6条</option>
				</select>
			</div>
			<br/>
			<div class="fitem" style="padding-left: 130px">
				<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveEdit();">提交</a>&nbsp;&nbsp;
	    		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="window.history.back();">返回</a>
			</div>
		</form>
	</div>
</div>
<div class="box span4">
	<div class="box-header well" data-original-title>
		<h3>shaokui的基本资料</h3>						
	</div>
	<div class="box-content">
	</div>
</div>
</div>
</div>
<script>
//新增保存
function saveAdd(){
		$('#fmt').form('submit',{
				url:'${basePath}/system/user/addUserAction.do',
				success: function(data){
					$('#dd').dialog('close');
					var jsonObj = eval("("+data+")");
					$('#dg').datagrid('insertRow',{
						row: {
							id: jsonObj.id,
							username: jsonObj.username,
							isEnabledDesc: jsonObj.isEnabledDesc,
							departmentName:  jsonObj.departmentName,
							lastLogin: jsonObj.lastLogin,
							createDate: jsonObj.createDate,
						}
					});
				}
		});
};
CKEDITOR.replace( 'contents' );
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
			margin-bottom:10px;
		}
		.fitem label{
			display:inline-block;
			width:80px;
			text-align: left;
		}
</style>
</body>
</html>
