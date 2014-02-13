<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/common/easyUiInclude.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>单图文修改</title>
	<script type="text/javascript"  src="${basePath}/easyUi/js/jquery.edatagrid.js"></script>
</head>
<body>
	<div class="container-fluid">
	<div class="row-fluid">
	<div id="content" class="span10">
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-content well center">
							<form class="form-horizontal">
							<legend><h4><i class="icon-th"></i>单图文信息填写</h4></legend>
								<input  type="hidden" name="weixinArticlesForm.id" value="<c:if test="${weixinArticles!=null}">${weixinArticles.id}</c:if>" />	
								<div class="control-group">
								  <label class="control-label">链接到:</label>
								  <div class="controls">
									<a href="javascript:microPageEvent();" class="btn">微页面</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
									<a href="javascript:activeLinkEvent();" class="btn">活动</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
									<a href="javascript:outsideTheChainEvent();" class="btn">外链</a>
								  </div>
								</div>
								<div class="control-group" style="display:none" id="outsideTheChain">
								  <label class="control-label">外链:</label>
								  <div class="controls">
									<input name="weixinArticlesForm.url" class="span6 typeahead"  value="<c:if test="${weixinArticles!=null}">${weixinArticles.url}</c:if>" />
								  </div>
								</div>
								<div class="control-group error">
								  <label class="control-label">标题:</label>
								  <div class="controls">
									<input name="weixinArticlesForm.title" class="span6 typeahead" value="<c:if test="${weixinArticles!=null}">${weixinArticles.title}</c:if>" />
									<p class="help-inline">建议不多于30字!</p>
								  </div>
								</div>
								<div class="control-group error">
									<label class="control-label">封面:</label>
									<div class="controls">
										<input name="weixinArticlesForm.picUrl" class="span6 typeahead"  id="photo"  value="<c:if test="${weixinArticles!=null}">${weixinArticles.picUrl}</c:if>" onclick="javascript:showPictureList();" />
										<br />
										<input type="file"  id="indexfile" class="span6 typeahead"  />
										<br />
										<img  id="indexfilePic"  alt=""  src="${basePath}<c:if test="${weixinArticles!=null}">${weixinArticles.picUrl}</c:if>"   class="span5 typeahead"  height="100"  /><br/>
										<p class="help-inline">尺寸建议:720高*400宽!</p>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">摘要:</label>
									 <div class="controls">
										<textarea rows="5" class="span6 typeahead" name="weixinArticlesForm.description"><c:if test="${weixinArticles!=null}">${weixinArticles.description}</c:if></textarea>
							  		</div>
								</div>
								<div class="form-actions">
									<a href="" class="btn btn-primary">修改</a>
									<a href="" class="btn btn-primary">发送</a>
									<a href="javascript:closedOpenPages();" class="btn">关闭</a>
							   </div>
							</form>
                    	</div>                   
                  </div>
			</div><!--/row-->
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
	function edit(){
		$('#fmt').form('submit',{
				url:'${basePath}/articles/articlesEdit.do',
				success:function(data){
					var jsonObj = eval("("+data+")");
				}
		});
	}
 //弹出现有图片的选择
 function showPictureList() {	
	$("#dialog-showPictureList").dialog({
		title: '请查询选择图片素材',
		href:'${basePath}/picture/pictureBase.do?jump=alert',
	    closed: false,
	    width: 600,
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
 
 function closedOpenPages(){
		window.location.href="${basePath}/articles/articlesBase.do?jump=list";	
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