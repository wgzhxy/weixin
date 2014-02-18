<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/common/easyUiInclude.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>预约看房</title>
	<script type="text/javascript"  src="${basePath}/easyUi/js/jquery.edatagrid.js"></script>
</head>
<body>
	<div id="tb"  style="padding:6px" title=" 查询条件" class="easyui-panel"  iconCls="icon-search">
 			<div id="row"  style="padding: 7px;">
			    <span style="padding-left: 20px;">用户名称 :&nbsp; </span>
			    <input  id="userName" />
    			 <span style="padding-left: 20px;">处理状态 :&nbsp; </span>
    				 <input type="radio" name="state" value="0" checked="true"><span>未处理</span>
        		 	 <input type="radio" name="state" value="1" id="state"><span>已处理</span>
        		 <span style="padding-left: 20px;">
        		 <a href="#" class="btn btn-primary"  onclick="doSearch()"><i class="icon-search icon-white"></i>开始查询</a>
        		 </span>
		    </div>
	</div>
	<p></p>
	
	<table id="dg" title="预约看房管理" class="easyui-datagrid"  style="width: 100%; height: 400;" idField="id"  
			   toolbar="#toolbar"  rownumbers="false"  fitColumns="true"  pagination="true"  pagePosition = "bottom"  iconCls="icon-reload" 
			   nowrap="false"  striped ="true"  collapsible="false"  remoteSort ="false"   singleSelect="true">
		<thead>
			<tr>
				<th field="ck"  checkbox="true" ></th>
				<th field="id"  width="10%"  align="center"  height="30px">ID</th>
				<th field="userName"  width="10%"  align="center">用户名称</th>
				<th field="nick" width="10%" align="center">称谓</th>
				<th field="city" width="10%" align="center">常居地</th>
				<th field="reservationStartTime" width="30%" align="center">预约时间</th>
				<th field="mobile"  width="15%"  align="center">联系电话</th>
				<th field="isInitiative"  width="10%"  align="center">主动联系</th>
				<th field="createTime"  width="20%"  align="center">提交时间</th>
				<th field="updateTime"  width="20%"  align="center">处理时间</th>	
			</tr>
		</thead>
	</table>
	<div id="toolbar">
    	<a href="#"  class="easyui-linkbutton"  iconCls="icon-remove"  plain="true"  onclick="javascript:$('#dg').edatagrid('destroyRow')">已处理</a>
	</div>
	<script type="text/javascript">
//搜索功能
function doSearch() {
	var userName = $.trim($('#userName').val());
	var state=0;
	if(document.getElementById("state").checked){
		state=1;
	}
	var queryParams = $('#dg').datagrid('options').queryParams;
	queryParams['weixinFormReservationForm.userName'] = userName;
	queryParams['weixinFormReservationForm.state'] = state;
	$('#dg').datagrid("load");
};
   //初使化 edatagrid
$(function(){
	$('#dg').edatagrid({
			url: '${basePath}/reservation/reservationList.do',
			destroyUrl: '${basePath}/reservation/reservationRemove.do',
			destroyMsg:{
				norecord:{	// when no record is selected
					title:'警告',
					msg:'没有选中记录!'
				},
				confirm:{	// when select a row
					title:'提示',
					msg:'你确认处理该条记录吗?'
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