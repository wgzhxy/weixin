var _menus = {
	basic : [ {
		"menuid" : "10",
		"icon" : "icon-sys",
		"menuname" : "基础数据",
		"menus" : [ {
			"menuid" : "111",
			"menuname" : "返利扣率设置",
			"icon" : "icon-nav",
			"url" : "point/rebateRule.action"
		}, {
			"menuid" : "113",
			"menuname" : "分账规则维护",
			"icon" : "icon-nav",
			"url" : "sa/splitAccountRule.action"
		}, {
			"menuid" : "115",
			"menuname" : "联名卡合作渠道",
			"icon" : "icon-nav",
			"url" : "bk/cooperationChannel.action"
		}, {
			"menuid" : "117",
			"menuname" : "保险公司管理",
			"icon" : "icon-nav",
			"url" : "im/insuranceCompany.action"
		}, {
			"menuid" : "119",
			"menuname" : "商户系统外信息对照",
			"icon" : "icon-nav",
			"url" : "em/enterpriseChannelObtend.action"
		} ]
	}, {
		"menuid" : "20",
		"icon" : "icon-sys",
		"menuname" : "测试一",
		"menus" : [ {
			"menuid" : "211",
			"menuname" : "测试一11",
			"icon" : "icon-nav",
			"url" : "point/pointPurpose.action"
		}, {
			"menuid" : "213",
			"menuname" : "测试一22",
			"icon" : "icon-nav",
			"url" : "point/adjustment-list.action"
		} ]
	} ],
	point : [{
		"menuid" : "20",
		"icon" : "icon-sys",
		"menuname" : "积分管理",
		"menus" : [ {
			"menuid" : "211",
			"menuname" : "积分用途",
			"icon" : "icon-nav",
			"url" : "point/pointPurpose.action"
		}, {
			"menuid" : "213",
			"menuname" : "积分调整",
			"icon" : "icon-nav",
			"url" : "point/adjustment-list.action"
		} ]

	}]
};

// 设置登录窗口
function openPwd() {
	$('#w').window( {
		title : '修改密码',
		width : 300,
		modal : true,
		shadow : true,
		closed : true,
		height : 160,
		resizable : false
	});
}
// 关闭登录窗口
function closePwd() {
	$('#w').window('close');
}

// 修改密码
function serverLogin() {
	var $newpass = $('#txtNewPass');
	var $rePass = $('#txtRePass');

	if ($newpass.val() == '') {
		msgShow('系统提示', '请输入密码！', 'warning');
		return false;
	}
	if ($rePass.val() == '') {
		msgShow('系统提示', '请在一次输入密码！', 'warning');
		return false;
	}

	if ($newpass.val() != $rePass.val()) {
		msgShow('系统提示', '两次密码不一至！请重新输入', 'warning');
		return false;
	}

	$.post('/ajax/editpassword.ashx?newpass=' + $newpass.val(), function(msg) {
		msgShow('系统提示', '恭喜，密码修改成功！<br>您的新密码为：' + msg, 'info');
		$newpass.val('');
		$rePass.val('');
		close();
	});

}

$(function() {

	openPwd();

	$('#editpass').click(function() {
		$('#w').window('open');
	});

	$('#btnEp').click(function() {
		serverLogin();
	});

	$('#btnCancel').click(function() {
		closePwd();
	});

	$('#loginOut, #mm-exit').click(function() {
		$.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {
			if (r) {
				location.href = 'j_spring_security_logout';
			}
		});
	});
});