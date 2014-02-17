<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/common/bootstrapInclude.jsp"%>
<%@ include file="/WEB-INF/pages/common/easyUiInclude.jsp"%>
<!DOCTYPE html>
<html lang="utf-8">
    <head>
        <meta charset="utf-8">
        <title>VIP预约看房</title>
        <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <meta http-equiv="Access-Control-Allow-Origin" content="*">
    </head>
    <body>
         <div class="header">
            <div class="container">
                <div class="row">
                    <div class="logo span4" style="text-align:left;padding: 10px 10px 0px 10px;">
                        <h3>中铁置业大客户中心</h3>
                        <h4>电话:400-123-4567</h4>
                    </div>
                </div>
            </div>
        </div>

        <div class="common-container container" style="padding-left: 0px; padding-right: 0px;">
            <div class="row">
                <div class="common span6">
                    <form class="form-horizontal" id="fmt">
                        <label for="weixinFormReservationForm.nick">称谓</label>
                        <div style="text-align: left;">
                            <label style="display: inline;">
                            	<input type="radio" name="weixinFormReservationForm.nick" id="gender" value="1" checked="checked">先生</label>
                            &nbsp;&nbsp;&nbsp;
                            <label style="display: inline;">
                            	<input type="radio" name="weixinFormReservationForm.nick" id="gender" value="0">女士</label>
                        </div>
                        <label for="name">姓名</label>
                        <input type="text" name="weixinFormReservationForm.userName" placeholder="请输入您的姓名" class="easyui-validatebox span4"  required="true" />
                        <label for="contact">联系电话</label>
                        <input type="text" name="weixinFormReservationForm.mobile" placeholder="请输入您的联系电话"  class="easyui-validatebox span4"  required="true" />
                        <label for="appointmenttime">预约时间</label>
                         <div style="text-align: left;">
                            <label style="display: inline;">
                            	<input type="radio" name="appointmenttime" id="thisweek"  checked="checked" onclick="selectWeek();">本周</label>
                            &nbsp;&nbsp;&nbsp;
                            <label style="display: inline;">
                            	<input type="radio" name="appointmenttime" id="nextweek" onclick="selectWeek();">下周</label>
                            <div style="margin-top:10px;">
                                <div style="float:left; width: 90%;">
                                    <input type="text" class="easyui-datetimebox" style="height:30px;" name="weixinFormReservationForm.reservationStartTime" id="reservationStartTime">
                                    <br>
                                    	<h4>-</h4>
                                     <br>
                                    <input type="text" class="easyui-datetimebox" style="height:30px;" name="weixinFormReservationForm.reservationEndTime" id="reservationEndTime">
                                </div>
                            </div>
                        </div>
                        <div class="span6">
	                        <label><input type="checkbox" name="weixinFormReservationForm.isInitiative" id="isInitiative" />我希望顾问联系我来确定时间</label>
                        </div>
                        <div style="text-align:center">
                        	<a class="btn btn-primary btn-large" onclick="javascript:save();">确认提交</a>
                       	</div>
                    </form>
                </div>
            </div>
        </div>
<script type="text/javascript">
function save(){
	if(document.getElementById("isInitiative").checked){
		$('#isInitiative').val('1');
	}else{
		$('#isInitiative').val('0');
	}
	 $('#fmt').form('submit',{
			url:'${basePath}/reservation/reservationAdd.do',
			success:function(result){
				if(result=='e'||result=='2'){
					$.messager.alert('提示信息','系统有点问题,请稍后重试!');
					return ;
				}
				if(result==0){
					$.messager.alert('提示信息','数据添加成功!');
					return ;
				}
			}
	}); 
};
function selectWeek(){
	var date = new Date();
	if(document.getElementById("thisweek").checked){
		$('#reservationStartTime').datetimebox('setValue',date.toLocaleTimeString());
		$('#reservationEndTime').datetimebox('setValue',getThisWeekLastDay());
	};
	if(document.getElementById("nextweek").checked){
		$('#reservationStartTime').datetimebox('setValue','2013-01-01');
		$('#reservationEndTime').datetimebox('setValue','2013-01-01');
	};
};
	
function getThisWeekLastDay(){   
  var now=new Date();//获取当前日期
  var day=now.getDay();
  var weekLastDay=new Date(now/1000+86400*(6-day));
  return weekLastDay.toLocaleString();
}; 
</script>       
</body>
</html>