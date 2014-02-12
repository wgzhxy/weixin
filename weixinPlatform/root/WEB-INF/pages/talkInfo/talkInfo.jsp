<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/common/easyUiInclude.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${weixinMessageLogVo.fromUserName}微信消息管理</title>
	<script type="text/javascript"  src="${basePath}/easyUi/js/method.js"></script>
</head>			
<body>
	<div id="tb"  style="padding:6px" title="(${weixinMessageLogVo.fromUserName})微信消息筛选" class="easyui-panel"  iconCls="icon-search">
		<div id="row"  style="padding: 7px;">
		    <span style="padding-left: 20px;"><input type="checkBox"/>&nbsp;<a href="#">最新</a>&nbsp; </span>
		    <span style="padding-left: 20px; color: blue;"><input type="checkBox"/>&nbsp;<a href="#">最早</a>&nbsp; </span>
		    <span style="padding-left: 20px; color: blue;"><input type="checkBox"/>&nbsp;<a href="#">未读</a>&nbsp; </span>
		    <span style="padding-left: 20px; color: blue;"><input type="checkBox"/>&nbsp;<a href="#">有备注</a>&nbsp; </span>
		    <span style="padding-left: 20px; color: blue;"><input type="checkBox"/>&nbsp;<a href="#">已加星</a>&nbsp; </span>
		    <span style="padding-left: 20px;">内容 :&nbsp; </span>
		    <input  id="search" />
		    <span style="padding-left: 20px;"><a href="#" class="easyui-linkbutton"  onclick="doSearch()">搜索</a></span>	
	    </div>
	</div>
	<p></p>
	<div class="row-fluid sortable">
		<div class="box span9">
			<div class="box-content">					
				<table id="dg" width="100%"></table>
			</div>
		</div>
		<div class="box span3">
				<div class="box-header well" data-original-title>
					<h3>shaokui的基本资料</h3>						
				</div>
				<div class="box-content">
					<!-- 列表组 -->
                       <ul class="list-group">
                           <li class="list-group-item">备注姓名：<a href="#" id="memo" data-type="text" data-placement="right" data-title="输入备注姓名：">编辑</a></li>
                           <li class="list-group-item">会员标签：<a href="#" id="tag" data-type="text" data-placement="right" data-title="输入会员标签：">编辑</a></li>
                           <li class="list-group-item">会员等级：<a href="#" id="status"></a></li>
                           <li class="list-group-item">会员积分：3000&nbsp;<a href="#">调整</a></li>
                           <li class="list-group-item">真实姓名：黄少奎</li>
                           <li class="list-group-item">身份证号码：无信息</li>
                           <li class="list-group-item">手机：13984058002</li>
                           <li class="list-group-item">购房次数：1</li>
                           <li class="list-group-item">来访次数：3</li>
                           <li class="list-group-item">来电次数：10</li>
                           <li class="list-group-item">关注来源：中铁逸都国际</li>
                           <li class="list-group-item">所在地区：中国 贵州 贵阳</li>
                           <li class="list-group-item">关注时间：2014-01-17 22:47:46</li>
                           <li class="list-group-item">最后对话：2014-01-19 22:22:26</li>                            
                       </ul>
                       <!-- 列表组结束 -->    
				</div>
			</div><!--/span-->			
		</div><!--/row-->
	</div>
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
		    //弹出新增窗口
			function sendMsg(){
					$('#dd').dialog({
							href: '${basePath}/addModulePage.do',
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
				var queryParams = $('#dg').datagrid('options').queryParams;
				queryParams['weixinMessageLogVo.msgClass'] = 0;
				queryParams['weixinMessageLogVo.fromUserName'] = '${weixinMessageLogVo.fromUserName}';
				$('#dg').datagrid("load", "${basePath}/message/msgTalkInfo.do");
			};
		
			$(function(){
				$('#dg').datagrid({
						title : "(${weixinMessageLogVo.fromUserName})微信消息管理",
						nowrap : true,
						height : 480,
						url: "${basePath}/message/msgTalkInfo.do?weixinMessageLogVo.msgClass=0&weixinMessageLogVo.fromUserName=${weixinMessageLogVo.fromUserName}",
						striped : true,
						collapsible : false,
						remoteSort : false,
						pagination : true,
						fitColumns: true,
						rownumbers : false,
						singleSelect: true,
						columns:[[
							     {title:'会员',field:'touxiang',width:fixWidth(0.1),rowspan:2,align:'center',
								     formatter:function(val,rec){ 
								    	 return "<a class='' href ='./talk.html'><img style='padding:5px' style='' src='http://www.w3school.com.cn/i/eg_tulip.jpg' alt='" + val + "' width='60px' height='60px'/></a>";
								     }
							     },
							     {title:'昵称',field:'fromUserName',width:fixWidth(0.1),rowspan:2,align:'center'},
							     {title:'信息',field:'content',width:fixWidth(0.3),rowspan:2,align:'center'},
							     {title:'时间',field:'createTime',width:fixWidth(0.15),rowspan:2,align:'center'},
							     {title:'操作',field:'operator',width:fixWidth(0.15),rowspan:2,align:'center',
							    	 formatter:function(val,rec){ 
							    		return '<a href="#" id="memo" data-type="text" data-placement="right" data-title="输入备注">备注</a>'+
							    	 		   ' | <a href="" >加星</a> | <a href="">回复</a>';
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