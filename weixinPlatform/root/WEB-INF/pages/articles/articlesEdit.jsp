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
	<div style="padding:10px 80px">
    <div class="ftitle">图片信息填写</div>
		<form id="fmt"  method="post"  style="padding-left: 20px ;padding-top: 10px">		
			<div class="fitem">
				<label>图片名称:</label>
				<input  name="weixinPictureForm.pictureName"  class="easyui-validatebox"  required="true"  />
			</div>
			<div class="fitem">
				<label>所属平台:</label>
				<input  name="weixinPictureForm.platformTag"  class="easyui-validatebox"  required="true"  />
			</div>
			<div class="fitem">
				<label>上传图片:</label>
				<div style="padding-left: 90px;padding-top:10px">
					<input type="file"  id="indexfile" class="easyui-validatebox"  />
					<input type="hidden"  id="photo" name="weixinPictureForm.pictureUrl"   />
					<br />
					<img  id="indexfilePic"  alt=""  src=""  width="205"  height="100"  /><br/>
				</div>
			</div>
		</form>
</div>

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
							modifyTime:jsonObj.modifyTime,
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