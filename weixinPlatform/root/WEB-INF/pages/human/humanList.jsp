<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/common/easyUiInclude.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>人工服务</title>
	<script type="text/javascript"  src="${basePath}/easyUi/js/jquery.edatagrid.js"></script>
</head>
<body>
	<div id="tb"  style="padding:6px" title="查询条件" class="easyui-panel"  iconCls="icon-search">
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
	
	<table id="dg" title="人工服务" class="easyui-datagrid"  idField="id"  
			   rownumbers="false"  fitColumns="true"  pagination="true"  pagePosition = "bottom"  iconCls="icon-reload" 
			   nowrap="false"  striped ="true"  collapsible="false"  remoteSort ="false"   singleSelect="true" url="${basePath}/human/humanList.do">
		<thead>
			<tr>
				<th field="ck"  checkbox="true" ></th>
				<th field="id"  width="10%"  align="center"  height="30px">ID</th>
				<th field="userName"  width="10%"  align="center">用户名称</th>
				<th field="openId" width="10%" align="center">微信昵称</th>
				<th field="mobile"  width="15%"  align="center">联系电话</th>
				<th field="email" width="10%" align="center">邮箱地址</th>
				<th field="questionType" width="10%" align="center">问题类型</th>
				<th field="questionContents"  width="20%"  align="center">具体问题</th>
				<th field="replyContents"  width="20%"  align="center">处理意见</th>
				<th field="createTime"  width="20%"  align="center">提交时间</th>
				<th field="updateTime"  width="20%"  align="center">处理时间</th>	
				<th field="opt" formatter='optFormater' width="10%" align="center">操作</th>
			</tr>
		</thead>
	</table>
	
	<div id="workOrderProccess"  class="easyui-dialog"  style="padding:10px 30px"  closed="true"   title="更改工单状态"  buttons="#dlg-buttons_edit" >
		<form id="workFmt" method="post">
		<div class="fitem">
			<table>
				<tr>
					<td>处理状态:</td>
					<td>
						<select  name="weixinFormHumanServicesForm.state"  class="accordion-header-selected" id="handleState" >
							<option value="1">已处理</option>
							<option value="0">未处理</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>处理描述:</td>
					<td>
						<textarea rows="8" cols="50" name="weixinFormHumanServicesForm.replyContents"></textarea>	
					</td>
				</tr>
			</table>
		</div>
	</form>
	</div>
	<div id="dlg-buttons_edit"  style="text-align:center;">
	    <a href="#"  class="easyui-linkbutton"  iconCls="icon-ok"  onclick="javascript:changeWorkOrderStatus();">提交</a>
	    <a href="#" style="padding-left: 20px;"  class="easyui-linkbutton"  iconCls="icon-cancel"  onclick="javascript:$('#workOrderProccess').dialog('close')">取消</a>
	</div>
<script type="text/javascript">
function optFormater(value,row,index){
	var opt = '<a href="#" onclick="workOrderProccess('+row.id+')">【工单处理】</a>';
	return opt;
};
//搜索功能
function doSearch() {
	var userName = $.trim($('#userName').val());
	var state=0;
	if(document.getElementById("state").checked){
		state=1;
	}
	var queryParams = $('#dg').datagrid('options').queryParams;
	queryParams['weixinFormHumanServicesForm.userName'] = userName;
	queryParams['weixinFormHumanServicesForm.state'] = state;
	$('#dg').datagrid("load");
};
function workOrderProccess(obj){
	$('#workOrderProccess').dialog({
	    title: '更改工单状态',
	    closed: false,
		collapsible : true, 
	    iconCls: 'icon-save',
	    width: 400,
	    height: 300,
	    cache: false,
	    modal: true,
	    resizable:true
	});
};
//更改工单状态信息保存
function changeWorkOrderStatus(){
	var url="";
	var row = $('#dg').datagrid('getSelected');
	if (row){
		url = '${basePath}/human/humanRemove.do?weixinFormHumanServicesForm.id='+row.id;
	}else{
		$.messager.show({
			title: '信息提示',
			msg: '请至少先选择一条记录！'
		});
		return;
	}
	$('#workFmt').form('submit',{
		url: url,
		onSubmit: function(){
			return $(this).form('validate');
		},
		success: function(result){
			if (result=='0'){
				$('#workOrderProccess').dialog('close');
				$('#dg').datagrid('reload');
			} else {
				$.messager.alert('信息提示','服务器有点小问题,请重新提交.','warning');
			}
		}
	});
}
//初始 datagrid
$('#dg').datagrid({
	height : 500
});
</script>
</body>
</html>