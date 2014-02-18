<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/common/easyUiInclude.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>图片新增</title>
	<script type="text/javascript"  src="${basePath}/easyUi/js/jquery.edatagrid.js"></script>
</head>
<body>
		<form class="form-horizontal" id="fmt">
			<legend><h4><i class="icon-th"></i>单图文信息填写</h4></legend>	
			<div class="control-group">
				<label class="control-label">图片名称:</label>
				<div class="controls">
					<input  name="weixinPictureForm.pictureName"  class="easyui-validatebox"  required="true"  />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">所属平台:</label>
				<div class="controls">
					<input  name="weixinPictureForm.platformTag"  class="easyui-validatebox"  required="true"  />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">上传图片:</label>
				<div class="controls">
					<input type="file"  id="indexfile" class="easyui-validatebox"  />
					<br />
					<input type="hidden"  id="photo" name="weixinPictureForm.pictureUrl"   />
					<br />
					<img  id="indexfilePic"  alt=""  src=""  class="span3"  height="100"  /><br/>
				</div>
			</div>
		</form>
<script type="text/javascript">
var fileUpload = new FileParamter();
	 fileUpload.basePath = '${basePath}';
	 fileUpload.uploadFile(fileUpload, $('#indexfile'), 
			 function(event, queueID, fileObj, response, data) {             
	         	var obj = eval('(' + response + ')');
	        	 if(obj.result == 'ok') {
			         	$("#photo").val(obj.pic);
			         	$("#indexfile").html(obj.pic);
			     	 	$("#indexfilePic").attr("src", "${basePath}" + obj.pic);
		     		} else {
	     			 	$.messager.alert("消息提示", response.result, 1);
	        		}
     		}
	 );
//新增保存
function save(){
		$('#fmt').form('submit',{
				url:'${basePath}/picture/pictureAdd.do',
				success: function(data){
					$('#dd').dialog('close');
					var jsonObj = eval("("+data+")");
					$('#dg').datagrid('insertRow',{
						row: {
							id: jsonObj.id,
							pictureName:jsonObj.pictureName,
							state:jsonObj.state,
							createTime:jsonObj.createTime,
							pictureUrl:jsonObj.pictureUrl,
							modifyTime:'',
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