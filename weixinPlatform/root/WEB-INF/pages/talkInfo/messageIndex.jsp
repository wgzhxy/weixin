<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/common/easyUiInclude.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>微信消息管理</title>
	<script type="text/javascript"  src="${basePath}/easyUi/js/method.js"></script>
</head>			
<body>
	<div id="tb"  style="padding:6px" title="微信消息筛选" class="easyui-panel"  iconCls="icon-search">
 			<div id="row"  style="padding: 7px;">
			    <span style="padding-left: 20px;"><input type="checkBox"/>&nbsp;<a href="#">所有消息</a>&nbsp; </span>
			    <span style="padding-left: 20px; color: blue;"><input type="checkBox"/>&nbsp;<a href="#">未回复</a>&nbsp; </span>
			    <span style="padding-left: 20px; color: blue;"><input type="checkBox"/>&nbsp;<a href="#">未读</a>&nbsp; </span>
			    <span style="padding-left: 20px; color: blue;"><input type="checkBox"/>&nbsp;<a href="#">有备注</a>&nbsp; </span>
			    <span style="padding-left: 20px; color: blue;"><input type="checkBox"/>&nbsp;<a href="#">已加星</a>&nbsp; </span>
		    </div>
		    <div id="row"  style="padding: 7px;">
				<span style="padding-left: 20px;">用户名称 :&nbsp; </span>
			    <input  id="pictureName" />
			    <span style="padding-left: 20px;">内容 :&nbsp; </span>
			    <input  id="pictureName" />
			    <span style="padding-left: 20px;"><a href="#" class="easyui-linkbutton"  onclick="doSearch()">搜索</a></span>
		    </div>
	</div>
	<p></p>
	
	<table id="dg" width="100%">
	</table>
	<!-- 新增 -->
	<div id="dd"  class="easyui-dialog"  style="padding:10px 30px"  closed="true"   title="系统菜单新增"  buttons="#dlg-buttons" >
	</div>
	<div id="dlg-buttons"  style="text-align: right;">
	    <a href="#"  class="easyui-linkbutton"  iconCls="icon-ok"  onclick="savereg();">提交</a>
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
			function editModule() {
				var row = $('#dg').datagrid('getSelected');
				if (row) {
						if(row.id == '') {
							$.messager.show({  
					                title: '警告',  
					                msg: '所选记录ID为空，不能进行编辑操作!',  
					                showType: 'slide'  
			            	});  
			            	return;
						}
						var index = $('#dg').datagrid('getRowIndex', row);
						$('#de').dialog({
								href: '${basePath}/system/module/editModulePage.do?moduleForm.id=' + row.id + "&index=" + index ,
							    title: '编辑权限实体',
							    closed: false,
							    iconCls: 'icon-save',
							    width: 500,
							    height: 480,
							    cache: false,
							    modal: true,
							    resizable:true
						});
				} else {
					$.messager.show({  
			                title: '警告',  
			                msg: '请选择要操作的记录!.',  
			                timeout: 2000,  
			                showType: 'slide'  
		            });  
				}
			}
		    //弹出新增窗口
			function sendMsg(val){
					$('#dd').dialog({
							href: '${basePath}/message/msgsendMessage.do',
						    title: '发送微信消息',
						    closed: false,
						    iconCls: 'icon-save',
						    width: 500,
						    height: 480,
						    cache: false,
						    modal: true,
						    resizable:true
					});
			}
	
			function doSearch() {
				var queryParams = $('#dg').datagrid('options').queryParams;
				queryParams['weixinMessageLogVo.msgClass'] = 0;
				$('#dg').datagrid("load", "${basePath}/message/msgManagerIndex.do");
			};
			
			$(function(){
				$('#dg').datagrid({
						idField : "id",
						title : "微信消息管理",
						iconCls: 'icon-reload',
						nowrap : true,
						height : 450,
						url: "${basePath}/message/msgManagerIndex.do?weixinMessageLogVo.msgClass=0",
						striped : true,
						collapsible : false,
						remoteSort : false,
						pagination : true,
						fitColumns: true,
						rownumbers : false,
						singleSelect: true,
						columns:[[
							     {title:'消息ID',field:'msgId',width:fixWidth(0.1),rowspan:2,align:'center'},
							     {title:'会员名称',field:'fromUserName',width:fixWidth(0.1),rowspan:2,align:'center',
								     formatter:function(val,rec){ 
								    	 return "<a href='${basePath}/message/msgTalkInfo.do?weixinMessageLogVo.fromUserName=" + val + "'>" + val + "</a>";
								     }
							     },
							     {title:'消息内容',field:'content',width:fixWidth(0.3),rowspan:2,align:'center'},
							     {title:'消息时间',field:'createTime',width:fixWidth(0.15),rowspan:2,align:'center'},
							     {title:'操作',field:'operator',width:fixWidth(0.15),rowspan:2,align:'center',
							    	 formatter:function(val,){ 
							    		return '<a href="#" id="memo" data-type="text" data-placement="right" data-title="输入备注">备注</a>'+
							    	 		   ' | <a href="">加星</a> | <a href="javascript:sendMsg('+ val + rec +');">回复</a>';
							     	 }
							     }  
			    				]],
						onLoadSuccess:function(){
						}
				});
		});
	</script>
</body>
</html>
