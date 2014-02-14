<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/common/easyUiInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加微信消息备注</title>
<script src="${basePath}/ckeditorStd/ckeditor.js"></script>
</head>
<body>	
<!-- 微信消息发送 -->
<div class="container-fluid">
<div class="row-fluid">
<div class="box span5">
	<div class="box-content">
		<br/>
		<form id="fmtmuilt" method="post">
			<div>
				<textarea style="width: 300px;" cols="50" rows="8" name="weixinArticlesForm.description"></textarea>
			</div>
		</form>
	</div>
</div>
</div>
</div>
<script>
//新增保存
function saveAdd(){
	$('#fmtmuilt').form('submit',{
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
