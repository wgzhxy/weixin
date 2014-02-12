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
	<div style="padding:10px 80px">
    <div class="ftitle">多图文填写</div>
		<form id="fmtmuilt"  method="post"  style="padding-left: 20px ;padding-top: 10px">
			<div class="fitem">
				<label>链接到:</label>
				<a href="javascript:microPageEvent();">微页面</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
				<a href="javascript:activeLinkEvent();">活动</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
				<a href="javascript:outsideTheChainEvent();">外链</a>
			</div>
			<div class="fitem" style="display:none" id="outsideTheChain">
				<label>外链:</label>
				<input name="weixinArticlesForm.url" class="easyui-validatebox"  />
			</div>
			<div class="fitem">
				<label>标题:</label>
				<input name="weixinArticlesForm.title"  class="easyui-validatebox"  required="true"  />
			</div>
			<div class="fitem">
				<label>封面:</label>
				<div style="padding-left: 90px;padding-top:10px">
					<input name="weixinArticlesForm.picUrl" class="easyui-validatebox"  id="photo"  onclick="javascript:showMuiltPictureList(0);" />
					<br />
					<input type="file"  id="indexfile" class="easyui-validatebox"  />
					<br />
					<img  id="indexfilePic"  alt=""  src=""  width="205"  height="100"  /><br/>
				</div>
			</div>
			<div class="fitem">
				<label>摘要:</label>
				<textarea class="textbox" cols="38" rows="8" name="weixinArticlesForm.description"></textarea>
			</div>
			
			<div id="items">
			</div>
			<div class="ftitle" style="text-align: center;">
				<a href="javascript:additionItemsEvent();" class="btn btn-success"><li class="icon-plus icon-white"></li>增加一条</a>
			</div>
		</form>
</div>
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
	 var items_array=[1,2,3,4,5,6,7,8,9];
	 var items_array_tmp=[];
	 var items_count=1;
	 var event_id=0;
//新增保存
function save(){
		$('#fmtmuilt').form('submit',{
				url:'${basePath}/articles/articlesAdd.do?picType=2&items_array='+items_array_tmp,
				success: function(data){
					$('#dialog-multi').dialog('close');
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

function additionItemsEvent(){
	if(items_count>=9){
		alert('已经操作最大数量');
		return;
	}
	var event_id=items_array.shift();
	items_array_tmp.push(event_id);
	var str='<div id="items'+event_id+'"><div class="fitem">'+
				'<label>链接到:</label>'+
				'<a href="javascript:microPageEvent();">微页面</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;'+
				'<a href="javascript:activeLinkEvent();">活动</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;'+
				'<a href="javascript:outsideTheChainEvent();">外链</a>'+
			'</div>'+
			'<div class="fitem" style="display:none" id="outsideTheChain">'+
				'<label>外链:</label>'+
				'<input name="url'+event_id+'" class="easyui-validatebox"  />'+
			'</div>'+
			'<div class="fitem">'+
				'<label>标题:</label>'+
				'<input name="title'+event_id+'"  class="easyui-validatebox"  required="true"  />'+
			'</div>'+
			'<div class="fitem">'+
				'<label>封面:</label>'+
				'<div style="padding-left: 90px;padding-top:10px">'+
					'<input name="picUrl'+event_id+'" class="easyui-validatebox"  id="photo'+event_id+'" onclick="javascript:showMuiltPictureList('+event_id+');" />'+
					'<br />'+
					'<input type="file"  id="indexfile'+event_id+'" class="easyui-validatebox"  />'+
					'<br />'+
					'<img  id="indexfilePic'+event_id+'"  alt=""  src=""  width="205"  height="100"  /><br/>'+
				'</div>'+
			'</div><div style="text-align: center;"><a class="btn btn-danger" href="javascript:removeItemsEvent(items'+event_id+','+event_id+');"><i class="icon-trash icon-white"></i>删除</a><div></div>';
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