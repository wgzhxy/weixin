<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/common/easyUiInclude.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>单图文新增</title>
	<script type="text/javascript"  src="${basePath}/easyUi/js/jquery.edatagrid.js"></script>
</head>
<body>
	<div style="padding:10px 80px">
    <div class="ftitle">单图文填写</div>
		<form id="fmt"  method="post"  style="padding-left: 20px ;padding-top: 10px">		
			<div class="fitem">
				<label>链接到:</label>
				<a href="javascript:microPageEvent();">微页面</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
				<a href="javascript:activeLinkEvent();">活动</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
				<a href="javascript:outsideTheChainEvent();">外链</a>
				<input type="hidden" name="weixinArticlesForm.url"  class="easyui-validatebox" />
			</div>
			<div class="fitem" style="display:none" id="outsideTheChain">
				<label>外链:</label>
				<input class="easyui-validatebox" name="weixinArticlesForm.url" />
			</div>
			<div class="fitem">
				<label>标题:</label>
				<input name="weixinArticlesForm.title"  class="easyui-validatebox"  required="true"  />
			</div>
			<div class="fitem">
				<label>封面:</label>
				<div style="padding-left: 90px;padding-top:10px">
					<input class="easyui-validatebox"  id="photo" name="weixinPictureForm.picUrl"  onclick="javascript:showPictureList();" />
					<br />
					<input type="file"  id="indexfile" class="easyui-validatebox"  />
					<br />
					<img  id="indexfilePic"  alt=""  src=""  width="205"  height="100"  /><br/>
				</div>
			</div>
			<div class="fitem">
				<label>摘要:</label>
				<textarea class="textbox" cols=38 rows=8 name="weixinPictureForm.description"></textarea>
			</div>
		</form>
</div>
<!-- 现有图片弹出框 -->
 <div id="dialog-showPictureList" class="easyui-dialog" title="请选择已有的图片信息" closed="true" buttons="#dialog-buttons-pictureList">       
 </div>
 <div id="dialog-buttons-pictureList">
 	<a href="#" class="easyui-linkbutton"  iconCls="icon-ok"  onclick="javascript:getPictureUrl();">确定</a>
 	<a href="#"  class="easyui-linkbutton"  iconCls="icon-cancel"  onclick="javascript:$('#dialog-showPictureList').dialog('close')">关闭</a>
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
				url:'${basePath}/articles/articlesAdd.do',
				success: function(data){
					$('#dialog-single').dialog('close');
					var jsonObj = eval("("+data+")");
					$('#articles-table').datagrid('insertRow',{
						row: {
							id: jsonObj.id,
							title:jsonObj.title,
							status:jsonObj.status,
							createTime:jsonObj.createTime,
							description:jsonObj.description,
							picType:jsonObj.picType,
							modifyTime:jsonObj.modifyTime,
						}
					});
				}
		});
}
 //弹出现有图片的选择
 function showPictureList() {	
	$("#dialog-showPictureList").dialog({
		title: '请查询选择图片素材',
		href:'${basePath}/picture/pictureBase.do?jump=alert',
	    closed: false,
	    width: 700,
	    height: 500,
	    cache: false,
	    modal: true,
	    resizable:true
	});
 }
 //取得选中的图片url地址
 function getPictureUrl(){
 	var row = $("#table-pictureAlert").datagrid("getSelected");
	if(row !=null){
		var pictureUrl=row.pictureUrl;
		$("#photo").val(pictureUrl);
       	$("#indexfile").html(pictureUrl);
   	 	$("#indexfilePic").attr("src", "${basePath}" + pictureUrl);		
    	$("#dialog-showPictureList").dialog('close');
	}else{
		$.messager.alert('温馨提示', '没有选中图片');
	} 
 }


//改变外部链接的属性
function outsideTheChainEvent(){
	$("#outsideTheChain").css('display','');
}
function microPageEvent(){
	$("#outsideTheChain").css('display','none');
}
function activeLinkEvent(){
	$("#outsideTheChain").css('display','none');
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