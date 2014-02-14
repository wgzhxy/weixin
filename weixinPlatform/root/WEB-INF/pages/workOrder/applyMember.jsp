<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/common/easyUiInclude.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>会员申请管理</title>
	<script type="text/javascript"  src="${basePath}/easyUi/js/method.js"></script>
</head>			
<body>
	<div id="tb"  style="padding:6px" title="微信消息筛选" class="easyui-panel"  iconCls="icon-search">
		    <div id="row"  style="padding: 7px;">
		    	<span style="padding-left: 20px;"><input type="checkBox"/>&nbsp;<a href="#">已经发布</a>&nbsp; </span>
				<span style="padding-left: 20px;">标题 :&nbsp; </span>
			    <input  id="pictureName" />
			    <span style="padding-left: 20px;"><a href="#" class="easyui-linkbutton"  onclick="doSearch()">搜索</a></span>
		    </div>
	</div>
	<p></p>
	
	<table id="dg" width="100%"></table>
	<div id="dlg-buttons"  style="text-align: left;">
	    <a href="#"  class="easyui-linkbutton"  iconCls="icon-add"  onclick="addPage();">新建微页面</a>
	</div>
	<!-- 新增 -->
	<div id="dd"  class="easyui-dialog"  style="padding:10px 30px" closed="true" title="系统菜单新增"  buttons="#dlg-buttons_add" >
	</div>
	<div id="dlg-buttons_add"  style="text-align: right;">
	    <a href="#"  class="easyui-linkbutton"  iconCls="icon-ok"  onclick="saveAdd();">提交</a>
	    <a href="#"  class="easyui-linkbutton"  iconCls="icon-cancel"  onclick="javascript:$('#dd').dialog('close')">取消</a>
	</div>
	
	<!-- 编辑 -->
	<div id="de"  class="easyui-dialog"  style="padding:10px 30px"  closed="true"   title="系统菜单编辑"  buttons="#dlg-buttons_edit" >
	</div>
	<div id="dlg-buttons_edit"  style="text-align: right;">
	    <a href="#"  class="easyui-linkbutton"  iconCls="icon-ok"  onclick="saveEdit();">提交</a>
	    <a href="#"  class="easyui-linkbutton"  iconCls="icon-cancel"  onclick="javascript:$('#de').dialog('close')">取消</a>
	</div>
	<script type="text/javascript">
			//编辑
			function editPage(id) {
				//href: '${basePath}/pagePageEdit.do?moduleForm.id=' + row.id + "&index=" + index ,
				window.location.href="${basePath}/pagePageEdit.do?weixinPageInfoVo.id=" + id;
			}
			//删出
			function deletePage(id) {
				//href: '${basePath}/pagePageEdit.do?moduleForm.id=' + row.id + "&index=" + index ,
				$.messager.confirm('系统提示', '确定删出吗?', function(r) {
		            if (r) {
		            	window.location.href="${basePath}/pagePageDelete.do?weixinPageInfoVo.id=" + id;
		            }
		        });
			}
			//查询链接
			function viewPage(id) {
				//href: '${basePath}/pagePageEdit.do?moduleForm.id=' + row.id + "&index=" + index ,
				window.location.href="${basePath}/pagePageEdit.do?weixinPageInfoVo.id=" + id;
			}
		    //弹出新增窗口
			function addPage(){
		    	window.location.href="${basePath}/pagePageAdd.do";
			}
	
			function doSearch() {
				var queryParams = $('#dg').datagrid('options').queryParams;
				queryParams['weixinPageInfoVo.platformTag'] = 0;
				$('#dg').datagrid("load", "${basePath}/pagePageList.do");
			};
			
			$(function(){
				$('#dg').datagrid({
						idField : "id",
						title : "微信页面管理",
						iconCls: 'icon-reload',
						nowrap : false,
						toolbar: '#dlg-buttons',
						height : 450,
						url: "${basePath}/pagePageList.do?weixinPageInfoVo.platformTag=0",
						striped : true,
						collapsible : false,
						remoteSort : false,
						pagination : true,
						fitColumns: true,
						rownumbers : false,
						singleSelect: true,
						columns:[[
							     {title:'ID',field:'id',width:fixWidth(0.1),rowspan:2,align:'center'},
							     {title:'标题',field:'pageTitle',width:fixWidth(0.2),rowspan:2,align:'center'},
							     {title:'内容',field:'content',width:fixWidth(0.3),rowspan:2,align:'center'},
							     {title:'创建时间',field:'createTime',width:fixWidth(0.15),rowspan:2, align:'center'},
							     {title:'操作',field:'operator',width:fixWidth(0.15),rowspan:2,align:'center'}
			    				]],
						onLoadSuccess:function(){
						}
				});
		});
	</script>
</body>
</html>
