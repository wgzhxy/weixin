<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/common/bootstrapInclude.jsp"%>
<%@ include file="/WEB-INF/pages/common/easyUiInclude.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>VIP预约看房</title>
        <meta name="viewport" content="target-densitydpi=device-dpi, width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <meta http-equiv="Access-Control-Allow-Origin" content="*">
    </head>
    <body>
         <div class="header">
            <div class="container">
                <div class="row">
                    <div class="logo span4" style="text-align: left; padding: 10px 10px 0px 10px;">
                        <p>中铁置业大客户中心</p>
                        <p>电话：400-123-4567</p>
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
                            <label style="display: inline;"><input type="radio" name="weixinFormReservationForm.nick" id="gender" value="先生" checked="checked">先生</label>
                            &nbsp;&nbsp;&nbsp;
                            <label style="display: inline;"><input type="radio" name="weixinFormReservationForm.nick" id="gender" value="女士">女士</label>
                        </div>
                        <label for="name">姓名</label>
                        <input type="text" id="name" name="weixinFormReservationForm.userName" placeholder="请输入您的姓名">
                        <label for="contact">联系电话</label>
                        <input type="text" id="contact" name="weixinFormReservationForm.mobile" placeholder="请输入您的联系电话">
                        <label for="appointmenttime">预约时间</label>
                         <div style="text-align: left;">
                            <label style="display: inline;"><input type="radio" name="appointmenttime" id="thisweek"  checked="checked">本周</label>
                            &nbsp;&nbsp;&nbsp;
                            <label style="display: inline;"><input type="radio" name="appointmenttime" id="nextweek">下周</label>
                            <div style="margin-top:10px;">
                                <div style="float:left; width: 90%;">
                                    <input type="text" class="easyui-datetimebox span4" name="weixinFormReservationForm.reservationStartTime" id="reservationStartTime">
                                    <br> 
                                    <strong>-</strong>
                                     <br> 
                                    <input type="text" class="easyui-datetimebox span4" name="weixinFormReservationForm.reservationEndTime" id="reservationEndTime">
                                </div>
                                <br>
                            </div>
                        </div>
                        <div>
	                        <label>
	                        	<input type="checkbox" name="weixinFormReservationForm.isInitiative"/>我希望顾问联系我来确定时间
	                        </label>
                        </div>
                        <button type="submit" onlick="javascript:save();">确认提交</button>
                    </form>
                </div>
            </div>
        </div>
<script type="text/javascript">
	function save(){
		$('#fmt').form('submit',{
				url:'${basePath}/articles/articlesAdd.do',
				success:function(result){
					alert(result);
					if(result==e||result==2){
						alert('系统有点问题,请稍后重试!');
						return ;
					}
					if(result==0){
						alert('数据添加成功!');
						return ;
					}
				}
		});
	};
</script>       
</body>
</html>