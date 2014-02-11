<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/common/easyUiInclude.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>微信消息管理</title>
	<script type="text/javascript"  src="${basePath}/easyUi/js/jquery.edatagrid.js"></script>
</head>			
<body>
	<div id="tb"  style="padding:6px" title="微信消息筛选" class="easyui-panel"  iconCls="icon-search">
 			<div id="row"  style="padding: 7px;">
			    <span style="padding-left: 20px;"><a href="#"><font color="blue">所有消息</font></a>&nbsp; </span>
			    <span style="padding-left: 20px; color: blue;"><a href="#"><font color="blue">未回复</font></a>&nbsp; </span>
			    <span style="padding-left: 20px; color: blue;"><a href="#"><font color="blue">未读</font></a>&nbsp; </span>
			    <span style="padding-left: 20px; color: blue;"><a href="#"><font color="blue">有备注</font></a>&nbsp; </span>
			    <span style="padding-left: 20px; color: blue;"><a href="#"><font color="blue">已加星</font></a>&nbsp; </span>
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
	
	<table id="dg" title="微信消息管理" class="easyui-datagrid"  url="${basePath}/system/module/listModules.do"  style="width: 100%; height: 380px"  idField="id"
		   rownumbers="false"  fitColumns="true"  pagination="true"  pagePosition = "bottom"  iconCls="icon-reload"
		   singleSelect="false">
		<thead>
			<tr>
				<th field="ck"  checkbox="true" ></th>
				<th field="id"  width="10%"  align="center"  height="30px">ID</th>
				<th field="name"  width="20%"  align="center">会员名称</th>
				<th field="patternUrl"  width="40%"  align="center">消息内容</th>
				<th field="updateDate"  width="15%"  align="center">消息时间</th>
				<th field="createDate"  width="15%"  align="center">操作</th>
			</tr>
		</thead>
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
			function addModule(){
					$('#dd').dialog({
							href: '${basePath}/system/module/addModulePage.do',
						    title: '新增权限实体',
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
				var name = $.trim($('#name').val());
				var description = $.trim($('#description').val());
				var queryParams = $('#dg').datagrid('options').queryParams;
				queryParams['moduleForm.name'] = name;
				queryParams['moduleForm.description'] = description;
				$('#dg').datagrid("load");
			};
		
			$(function(){
				$('#dg').edatagrid({
					url: '${basePath}/system/module/listModules.do',
					destroyUrl: '${basePath}/system/module/delModuleAction.do',
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
				
				$('#dg').datagrid({
							nowrap : false,
							height : 480,
							striped : true,
							collapsible : false,
							remoteSort : false,
							pagination : true,
							fitColumns: true,
							rownumbers : false,
				});
				
				 var fileUpload = new FileParamter();
				 fileUpload.basePath = '${basePath}';
				 fileUpload.uploadFile(fileUpload, $('#indexfile'), 
						 function(event, queueID, fileObj, response, data) {             
					 		//上传完成后的操作
					    	var obj = eval('(' + response + ')');
					        if(obj.result == 'ok') {
					        	$("#photo").val(obj.pic); //indexPicname
					        	$("#indexPicname").html(obj.pic);
					    	 	$("#indexfilePic").attr("src", "${basePath}" + obj.pic);
					    	} else {
					    		 $.messager.alert("消息提示", response.result, 1);
					        }
					 	}
				 );
				 var fileUpload = new FileParamter();
				 fileUpload.basePath = '${basePath}';
				 fileUpload.uploadFile(fileUpload, $('#titlefile'), 
						 function(event, queueID, fileObj, response, data) {             
					 		//上传完成后的操作
				         	var obj = eval('(' + response + ')');
				        	 if(obj.result == 'ok') {
						         	$("#listPhoto").val(obj.pic);
						         	$("#titlePicname").html(obj.pic);
						     	 	$("#titlefilePic").attr("src", "${basePath}" + obj.pic);
					     		} else {
				     			 	$.messager.alert("消息提示", response.result, 1);
				        		}
			     		}
				 );
				CKEDITOR.replace( 'contents' );
	});
	</script>
</body>
</html>