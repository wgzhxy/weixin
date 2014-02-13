<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/common/easyUiInclude.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>多图文新增</title>
	<script type="text/javascript"  src="${basePath}/easyUi/js/jquery.edatagrid.js"></script>
</head>
<body>
	<div class="container-fluid">
	<div class="row-fluid">
	<div id="content" class="span10">
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-content well center">
							<form class="form-horizontal" id="fmt">
							<legend><h4><i class="icon-th"></i>多图文信息填写</h4></legend>
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
									<input name="weixinArticlesForm.url" class="span6 typeahead"  />
								  </div>
								</div>
								<div class="control-group error">
								  <label class="control-label">标题:</label>
								  <div class="controls">
									<input name="weixinArticlesForm.title" class="span6 typeahead"  />
									<p class="help-inline">建议不多于30字!</p>
								  </div>
								</div>
								<div class="control-group error">
									<label class="control-label">封面:</label>
									<div class="controls">
										<input name="weixinArticlesForm.picUrl" class="span6 typeahead"  id="photo"  onclick="javascript:showMuiltPictureList('0');" />
										<br />
										<input type="file"  id="indexfile" class="span6 typeahead"  />
										<br />
										<img  id="indexfilePic"  alt=""  src=""  class="span5 typeahead"  height="100"  /><br/>
										<p class="help-inline">尺寸建议:720高*400宽!</p>
									</div>
								</div>
								<div id="items1" style="border-top:1px solid #ddd;margin-top:10px;padding-top:20px;">
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
									<input name="url1" class="span6 typeahead"  />
								  </div>
								</div>
								<div class="control-group error">
								  <label class="control-label">标题:</label>
								  <div class="controls">
									<input name="title1" class="span6 typeahead"  />
									<p class="help-inline">建议不多于30字!</p>
								  </div>
								</div>
								<div class="control-group error">
									<label class="control-label">封面:</label>
									<div class="controls">
										<input name="picUrl1" class="span6 typeahead"  id="photo1"  onclick="javascript:showMuiltPictureList('1');" />
										<br />
										<input type="file"  id="indexfile1" class="span6 typeahead"  />
										<br />
										<img  id="indexfilePic1"  alt=""  src=""  class="span5 typeahead"  height="100"  /><br/>
										<p class="help-inline">尺寸建议:720高*400宽!</p>
									</div>
								</div>
								<div id="items">
								</div>
								<div class="">
									<div class="box-content">
										<a href="javascript:additionItemsEvent();" class="btn btn-success">
											<li class="icon-plus icon-white"></li>增加一条
										</a>
									</div>
								</div>
								<div class="form-actions">
									<a href="" class="btn btn-primary">保存</a>
									<a href="" class="btn btn-primary">发送</a>
									<a href="javascript:closedOpenPages();" class="btn">关闭</a>
							   </div>
							</form>
                    	</div>                   
                  </div>
			</div><!--/row-->
<!-- 现有图片弹出框 -->
 <div id="articles-muilt-add-dialog" class="easyui-dialog" title="请选择已有的图片信息" closed="true" buttons="#dialog-buttons">       
 </div>
 <div id="dialog-buttons">
 	<a href="#" class="easyui-linkbutton"  iconCls="icon-ok"  onclick="javascript:getMuiltPictureUrl();">确定</a>
 	<a href="#"  class="easyui-linkbutton"  iconCls="icon-cancel"  onclick="javascript:$('#articles-muilt-add-dialog').dialog('close')">关闭</a>
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
	 
	 fileUpload = new FileParamter();
	 fileUpload.basePath = '${basePath}';
	 fileUpload.uploadFile(fileUpload, $('#indexfile1'), 
			 function(event, queueID, fileObj, response, data) {             
	         	var obj = eval('(' + response + ')');
	        	 if(obj.result == 'ok') {
			         	$("#photo1").val(obj.pic);
			         	$("#indexfile1").html(obj.pic);
			     	 	$("#indexfilePic1").attr("src", "${basePath}" + obj.pic);
		     		} else {
	     			 	$.messager.alert("消息提示", response.result, 1);
	        		}
     		}
	 );
	 var items_array=[2,3,4,5,6,7,8,9];
	 var items_array_tmp=[];
	 var items_count=1;
	 var event_id=0;
//新增保存
function save(){
	$('#fmt').form('submit',{
			url:'${basePath}/articles/articlesAdd.do?picType=2&items_array='+items_array_tmp,
			success: function(data){
				var jsonObj = eval("("+data+")");
			}
	});
}

function additionItemsEvent(){
	if(items_count>=9){
		alert('已经操作最大数量');
		return;
	}
	var event_id=items_array.shift();
	items_array_tmp.push(event_id);
	
	var str='<div style="border-top:1px solid #ddd;margin-top:10px;padding-top:20px;" id="items'+event_id+'">'+
		'<div class="control-group">'+
		  '<label class="control-label">链接到:</label>'+
		  '<div class="controls">'+
			'<a href="javascript:microPageEvent();" class="btn">微页面</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;'+
			'<a href="javascript:activeLinkEvent();" class="btn">活动</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;'+
			'<a href="javascript:outsideTheChainEvent();" class="btn">外链</a>'+
		  '</div>'+
		'</div>'+
		'<div class="control-group" style="display:none" id="outsideTheChain">'+
		  '<label class="control-label">外链:</label>'+
		  '<div class="controls">'+
			'<input name="weixinArticlesForm.url" class="span6 typeahead"  />'+
		  '</div>'+
		'</div>'+
		'<div class="control-group error">'+
		  '<label class="control-label">标题:</label>'+
		  '<div class="controls">'+
			'<input name="title'+event_id+'" class="span6 typeahead"  />'+
			'<p class="help-inline">建议不多于30字!</p>'+
		  '</div>'+
		'</div>'+
		'<div class="control-group error">'+
			'<label class="control-label">封面:</label>'+
			'<div class="controls">'+
				'<input name="picUrl'+event_id+'" class="span6 typeahead"  id="photo'+event_id+'"  onclick="javascript:showPictureList();" />'+
				'<br />'+
				'<input type="file"  id="indexfile'+event_id+'" class="span6 typeahead"  />'+
				'<br />'+
				'<img  id="indexfilePic'+event_id+'"  alt=""  src=""  class="span5 typeahead"  height="100"  /><br/>'+
				'<p class="help-inline">尺寸建议:720高*400宽!</p>'+
			'</div>'+
		'</div>'+
		  '<a class="btn btn-danger" href="javascript:removeItemsEvent(items'+event_id+','+event_id+');"><i class="icon-trash icon-white"></i>删除</a>'+
		'</div>';
	
	$("#items").append(str);
	 fileUpload = new FileParamter();
	 fileUpload.basePath = '${basePath}';
	 fileUpload.uploadFile(fileUpload, $('#indexfile'+event_id), 
			 function(event, queueID, fileObj, response, data) {             
	         	var obj = eval('(' + response + ')');
	        	 if(obj.result == 'ok') {
			         	$("#photo"+event_id).val(obj.pic);
			         	$("#indexfile"+event_id).html(obj.pic);
			     	 	$("#indexfilePic"+event_id).attr("src", "${basePath}" + obj.pic);
		     		} else {
	     			 	$.messager.alert("消息提示", response.result, 1);
	        		}
     		}
	 );
	 items_count++;
}
//删除新增的节点
function removeItemsEvent(obj,dd){
	alert(dd);
	items_array.push(dd);
	delete items_array_tmp[dd];
	items_count--;
	$(obj).remove();
}

function showMuiltPictureList(obj){
	$("#articles-muilt-add-dialog").dialog({
		title: '请查询选择图片素材',
		href:'${basePath}/picture/pictureBase.do?jump=alert',
	    closed: false,
	    width: 700,
	    height: 500,
	    cache: false,
	    modal: true,
	    resizable:true
	});
	event_id=obj;
}

//取得选中的图片url地址
 function getMuiltPictureUrl(){
 	var row = $("#table-pictureAlert").datagrid("getSelected");
	if(row !=null){
		var pictureUrl=row.pictureUrl;
		if(event_id==0){
			$("#photo").val(pictureUrl);
	       	$("#indexfile").html(pictureUrl);
	   	 	$("#indexfilePic").attr("src", "${basePath}" + pictureUrl);	
   	 	}else{
   	 		$("#photo"+event_id).val(pictureUrl);
	       	$("#indexfile"+event_id).html(pictureUrl);
	   	 	$("#indexfilePic"+event_id).attr("src", "${basePath}" + pictureUrl);
	   	}
    	$("#articles-muilt-add-dialog").dialog('close');
	}else{
		$.messager.alert('温馨提示', '没有选中图片');
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
			border-bottom:2px solid #ccc;
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