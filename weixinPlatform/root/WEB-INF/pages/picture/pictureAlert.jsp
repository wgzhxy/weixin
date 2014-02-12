<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/common/easyUiInclude.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>图片管理</title>
	<script type="text/javascript"  src="${basePath}/easyUi/js/jquery.edatagrid.js"></script>
</head>
<body>
	<div id="picture-tb"  style="padding:6px" title=" 查询条件" class="easyui-panel"  iconCls="icon-search">
 			<div  style="padding: 7px;">
			    <span style="padding-left: 20px;">图片名称 :&nbsp; </span>
			    <input  id="pictureName" />
    			 <span style="padding-left: 20px;">图片状态 :&nbsp; </span>
    				 <input type="radio" name="state" value="1" checked="true"><span>有效</span>
        		 	 <input type="radio" name="state" value="0" id="picture-state"><span>无效</span>
        		 <span style="padding-left: 20px;">
        		 <a href="#" class="btn btn-primary"  onclick="doSearchAlert()"><i class="icon-search icon-white"></i>开始查询</a>
        		 </span>
		    </div>
	</div>
	<p></p>
	
	<table id="table-pictureAlert" title="图片管理" class="easyui-datagrid"  style="width: 100%; height: 400;"  
			   rownumbers="false"  fitColumns="true"  pagination="true"  pagePosition = "bottom"  iconCls="icon-reload" 
			   nowrap="false"  striped ="true"  collapsible="false"  remoteSort ="false" singleSelect="true">
		<thead>
			<tr>
				<th field="ck"  checkbox="true" ></th>
				<th field="pictureName"  width="10%"  align="center">图片名称</th>
				<th field="pictureUrl" formatter='customLogo' width="20%" align="center">图片</th>
				<th field="createTime"  width="15%"  align="center">创建时间</th>
			</tr>
		</thead>
	</table>
	<script type="text/javascript">
		//搜索功能
		function doSearchAlert() {
				var pictureName = $.trim($('#pictureName').val());
				var state=1;
				if(document.getElementById("picture-state").checked){
					state=0;
				}
				var queryParams = $('#table-pictureAlert').datagrid('options').queryParams;
				queryParams['weixinPictureForm.pictureName'] = pictureName;
				queryParams['weixinPictureForm.state'] = state;
				$('#table-pictureAlert').datagrid("load");
		};
	    //初使化 edatagrid
		$(function(){
				$('#table-pictureAlert').edatagrid({
					url: '${basePath}/picture/pictureList.do'
				});
				//初始 datagrid
				$('#table-pictureAlert').datagrid({
					nowrap : false,
					height:300,
					width:600,
					striped : true,
					collapsible : false,
					remoteSort : false,
					pagination : true,
					fitColumns: true,
					rownumbers : false,
				});
		});
		
		function customLogo(value,row,index){
			var custom = '<img  id="logo"  alt=""  src="${basePath}'+value+'"  style="width:200px;height:100px;float:left" />';
			return custom;
		};
</script>
</body>
</html>