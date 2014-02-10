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
			    <span style="padding-left: 20px;">图文标题 :&nbsp; </span>
			    <input  id="title" />
    			 <span style="padding-left: 20px;">图文类型 :&nbsp; </span>
    				 <input type="radio" name="state" value="1" checked="true"><span>单图文</span>
        		 	 <input type="radio" name="state" value="0" id="state"><span>多图文</span>
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
				<th field="title"  width="10%"  align="center">标题</th>
				<th field="picType"  width="5%"  align="center">图文类型</th>
				<th field="state"  width="10%"  align="center">状态</th>
				<th field="description" width="25%" align="center">描述</th>
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
				var title = $.trim($('#title').val());
				var state=1;
				if(document.getElementById("state").checked){
					state=0;
				}
				var queryParams = $('#dg').datagrid('options').queryParams;
				queryParams['weixinPictureForm.title'] = title;
				queryParams['weixinPictureForm.picType'] = state;
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
</script>
</body>
</html>