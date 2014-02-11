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
	<div id="tb"  style="padding:6px" title=" 查询条件" class="easyui-panel"  iconCls="icon-search">
 			<div id="row"  style="padding: 7px;">
			    <span style="padding-left: 20px;">图片名称 :&nbsp; </span>
			    <input  id="pictureName" />
    			 <span style="padding-left: 20px;">图片状态 :&nbsp; </span>
    				 <input type="radio" name="state" value="1" checked="true"><span>有效</span>
        		 	 <input type="radio" name="state" value="0" id="state"><span>无效</span>
        		 <span style="padding-left: 20px;"><a href="#" class="easyui-linkbutton"  onclick="doSearch()">开始查询</a></span>
		    </div>
	</div>
	<p></p>
	
	<table id="dg" title="图片管理" class="easyui-datagrid"  style="width: 100%; height: 400;" idField="id"  
			   toolbar="#toolbar"  rownumbers="false"  fitColumns="true"  pagination="true"  pagePosition = "bottom"  iconCls="icon-reload" 
			   nowrap="false"  striped ="true"  collapsible="false"  remoteSort ="false"   singleSelect="false">
		<thead>
			<tr>
				<th field="ck"  checkbox="true" ></th>
				<th field="id"  width="10%"  align="center"  height="30px">ID</th>
				<th field="pictureName"  width="25%"  align="center">图片名称</th>
				<th field="pictureUrl" formatter='customLogo' width="25%" align="center">图片</th>
				<th field="state"  width="10%"  align="center">图片状态</th>
				<th field="createTime"  width="20%"  align="center">创建时间</th>
				<th field="modifyTime"  width="20%"  align="center">更新时间</th>	
			</tr>
		</thead>
	</table>
	<div id="toolbar">
    	<a href="#"  class="easyui-linkbutton"  iconCls="icon-add"  plain="true"  onclick="javascript:addPicture();">新增</a>
    	<a href="#"  class="easyui-linkbutton"  iconCls="icon-remove"  plain="true"  onclick="javascript:$('#dg').edatagrid('destroyRow')">删除</a>
	</div>
	<!-- 新增 -->
	<div id="dd"  class="easyui-dialog"  style="padding: 10px"  closed="true"   title="图片新增"  buttons="#dlg-buttons" >
	</div>
	<div id="dlg-buttons"  style="text-align: right;">
	    <a href="#"  class="easyui-linkbutton"  iconCls="icon-ok"  onclick="save();">提交</a>
	    <a href="#"  class="easyui-linkbutton"  iconCls="icon-cancel"  onclick="javascript:$('#dd').dialog('close')">取消</a>
	</div>
	<script type="text/javascript">
	//弹出新增窗口
	function addPicture(){
					$('#dd').dialog({
							href: '${basePath}/picture/pictureBase.do?jump=add',
						    title: '新增图片',
						    closed: false,
						    iconCls: 'icon-save',
						    width: 500,
						    height: 480,
						    cache: false,
						    modal: true,
						    resizable:true
					});
	}
	//搜索功能
		function doSearch() {
				var pictureName = $.trim($('#pictureName').val());
				var state=1;
				if(document.getElementById("state").checked){
					state=0;
				}
				var queryParams = $('#dg').datagrid('options').queryParams;
				queryParams['weixinPictureForm.pictureName'] = pictureName;
				queryParams['weixinPictureForm.state'] = state;
				$('#dg').datagrid("load");
		};
	    //初使化 edatagrid
		$(function(){
				$('#dg').edatagrid({
						url: '${basePath}/picture/pictureList.do',
						destroyUrl: '${basePath}/picture/pictureRemove.do',
						destroyMsg:{
							norecord:{	// when no record is selected
								title:'警告',
								msg:'没有选中记录!'
							},
							confirm:{	// when select a row
								title:'提示',
								msg:'你确认删出记录吗?'
							}
					}
				});
				//初始 datagrid
				$('#dg').datagrid({
					nowrap : false,
					height : 500,
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