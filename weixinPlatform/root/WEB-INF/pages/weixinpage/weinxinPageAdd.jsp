<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/common/easyUiInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微页面新增</title>
<script src="${basePath}/ckeditorStd/ckeditor.js"></script>
</head>
<body>	
<!-- 微页面新增 -->
<div class="container-fluid">
<div class="row-fluid">
<div class="box span8">
	<div class="box-content well center">
		<form id="fmtAdd" method="post" style="padding-top: 15px">
			<legend><h4>微页面信息填写</h4></legend>
			<div class="fitem">
				<label>页面名称:</label>
				<input style="width: 300px" name="weixinPageInfoVo.pageName" class="easyui-validatebox" required="true" />
			</div>
			<div class="fitem">
				<label>分类:</label>
				<select id="pageClass" name="weixinPageInfoVo.pageClass">
					<c:if test="${pageClass != null}">
						<c:forEach items="${pageClass}" var="class">
							<option value="${class.id}">${class.className}</option>	
						</c:forEach>
					</c:if>		
				</select>&nbsp;&nbsp;<span class="alert alert-info">请选择分类 </span>
			</div>
			<div class="fitem">
				<label>正文标题:</label>
				<input id="pageTitle" style="width: 300px" name="weixinPageInfoVo.pageTitle" class="easyui-validatebox" required="required" />
			</div>
			<div class="fitem">
				<label>副文标题:</label>
				<input id="pageSubtitle" style="width: 250px" name="weixinPageInfoVo.pageSubtitle" />
			</div>
			<div class="fitem">
				<label>富文本正文:</label>
				<div style="padding-left: 80px">
					<textarea id="content" name="weixinPageInfoVo.content" ></textarea>
				</div>
			</div>
			<div class="fitem">
				<label>关联链接:</label>
				<select id="associateLinks" name="weixinPageInfoVo.associateLinks">
					<c:if test="${pageClass != null}">
						<c:forEach items="${pageClass}" var="class">
							<option value="${class.id}">${class.className}</option>	
						</c:forEach>
					</c:if>	
				</select>		
			</div>
			<div class="fitem">
				<label>显示条数:</label>
				<select id="displayNum" name="weixinPageInfoVo.displayNum">			
					<option value="">--请选择--</option>	
					<option value="1">1条</option>
					<option value="2">2条</option>
					<option value="3">3条</option>
					<option value="4">4条</option>
					<option value="5">5条</option>
					<option value="6">6条</option>
				</select>
			</div>
			<br/>
			<div class="fitem" style="padding-left: 130px">
				<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveAdd();">提交</a>&nbsp;&nbsp;
	    		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="back();">返回</a>
			</div>
		</form>
	</div>
</div>
<div class="box span4">
	<div class="box-header well" data-original-title>
		<h4>微页面预览</h4>						
	</div>
	<div class="box-content">
	</div>
</div>
</div>
</div>
<script>
//新增保存
function saveAdd(){
	$('#fmtAdd').form('submit',{
		url:'${basePath}/pagePageSave.do',
		success: function(data){
			var jsonObj = eval("("+data+")");
			if(jsonObj.result=='ok') {
				//$.messager.alert("消息提示", "操作成功!", 1);
				$.messager.confirm('系统提示', '操作成功!', function(r) {
		            if (r) {
		            	window.location.href="${basePath}/pagePageAdd.do";
		            }
		        });
			} else {
				$.messager.alert("消息提示", "操作失败!", 1);
			}
		}
	});
};
function back(){
	window.location.href="${basePath}/pagePageList.do?row=${rows}&page=${page}";
};
CKEDITOR.replace( 'content' );
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
			border-bottom:1px solid #ccc;
		}
		.fitem{
			padding-left: 40px;
			margin-bottom:10px;
		}
		.fitem label{
			display:inline-block;
			width:80px;
			text-align: left;
		}
</style>
</body>
</html>
