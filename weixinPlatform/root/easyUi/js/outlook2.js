$(function(){
	InitLeftMenu();
	tabClose();
	tabCloseEven();
})

//初始化左侧
function InitLeftMenu() {

    $(".easyui-accordion").empty();
    var menulist = "";
   
    $.each(_menus.menus, function(i, n) {
        menulist += '<div title="'+n.menuname+'"  icon="icon '+n.icon+'" style="overflow:auto;">';
		menulist += '<ul>';
        $.each(n.menus, function(j, o) {
			menulist += '<li><div><a ref="'+o.menuid+'" href="#" rel="' + o.url + '" ><span class="icon '+o.icon+'" >&nbsp;</span><span class="nav">' + o.menuname + '</span></a></div></li> ';
        })
        menulist += '</ul></div>';
    })

	$(".easyui-accordion").append(menulist);
	
	$('.easyui-accordion li a').click(function(){
		var tabTitle = $(this).children('.nav').text();

		var url = $(this).attr("rel");
		var menuid = $(this).attr("ref");
		var icon = getIcon(menuid,icon);
		
		addTab(tabTitle,url,icon);
		$('.easyui-accordion li div').removeClass("selected");
		$(this).parent().addClass("selected");
	}).hover(function(){
		$(this).parent().addClass("hover");
	},function(){
		$(this).parent().removeClass("hover");
	});
	
	//导航菜单绑定初始化
	$(".easyui-accordion").accordion({animate:false});
}
//获取左侧导航的图标
function getIcon(menuid){
	var icon = 'icon ';
	$.each(_menus.menus, function(i, n) {
		 $.each(n.menus, function(j, o) {
		 	if(o.menuid==menuid){
				icon += o.icon;
			}
		 })
	})
	
	return icon;
}

function addTab(subtitle,url,icon){
	if(!$('#tabs').tabs('exists',subtitle)){
		$('#tabs').tabs('add',{
			title:subtitle,
			content:createFrame(url),
			closable:true,
			icon:icon
		});
	}else{
		$('#tabs').tabs('select',subtitle);
		$('#mm-tabupdate').click();
	}
	tabClose();
}

function createFrame(url)
{
	var s = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
	return s;
}

function tabClose()
{
	/*双击关闭TAB选项卡*/
	$(".tabs-inner").dblclick(function(){
		var subtitle = $(this).children(".tabs-closable").text();
		$('#tabs').tabs('close',subtitle);
	})
	/*为选项卡绑定右键*/
	$(".tabs-inner").bind('contextmenu',function(e){
		$('#mm').menu('show', {
			left: e.pageX,
			top: e.pageY
		});
		
		var subtitle =$(this).children(".tabs-closable").text();
		
		$('#mm').data("currtab",subtitle);
		$('#tabs').tabs('select',subtitle);
		return false;
	});
}
//绑定右键菜单事件
function tabCloseEven()
{
	//刷新
	$('#mm-tabupdate').click(function(){
		var currTab = $('#tabs').tabs('getSelected');
		var url = $(currTab.panel('options').content).attr('src');
		$('#tabs').tabs('update',{
			tab:currTab,
			options:{
				content:createFrame(url)
			}
		})
	})
	//关闭当前
	$('#mm-tabclose').click(function(){
		var currtab_title = $('#mm').data("currtab");
		$('#tabs').tabs('close',currtab_title);
	})
	//全部关闭
	$('#mm-tabcloseall').click(function(){
		$('.tabs-inner span').each(function(i,n){
			var t = $(n).text();
			$('#tabs').tabs('close',t);
		});	
	});
	//关闭除当前之外的TAB
	$('#mm-tabcloseother').click(function(){
		$('#mm-tabcloseright').click();		
		$('#mm-tabcloseleft').click();
	});
	//关闭当前右侧的TAB
	$('#mm-tabcloseright').click(function(){
		var nextall = $('.tabs-selected').nextAll();
		if(nextall.length==0){
			//msgShow('系统提示','后边没有啦~~','error');
			alert('后边没有啦~~');
			return false;
		}
		nextall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			$('#tabs').tabs('close',t);
		});
		return false;
	});
	//关闭当前左侧的TAB
	$('#mm-tabcloseleft').click(function(){
		var prevall = $('.tabs-selected').prevAll();
		if(prevall.length==0){
			alert('到头了，前边没有啦~~');
			return false;
		}
		prevall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			$('#tabs').tabs('close',t);
		});
		return false;
	});

	//退出
	$("#mm-exit").click(function(){
		$('#mm').menu('hide');
	})
}

//弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
function msgShow(title, msgString, msgType) {
	$.messager.alert(title, msgString, msgType);
}

/************************************************************************Index页面********************************************************/

var _menus = {
		basic: [ {
			"menuid" : "1",
			"icon" : "icon-sys",
			"menuname" : "客服查询系统",
			"menus" : [ {
				"menuid" : "11",
				"menuname" : "会员查询",
				"icon" : "icon-member",
				"url" : "../url/urlMenu.do?urlType=member"
			}, {
				"menuid" : "12",
				"menuname" : "账户查询",
				"icon" : "icon-account",
				"url" : "../url/urlMenu.do?urlType=account"
			}, {
				"menuid" : "13",
				"menuname" : "优惠券打印查询",
				"icon" : "icon-print",
				"url" : "../url/urlMenu.do?urlType=print"
			}, {
				"menuid" : "14",
				"menuname" : "优惠券验证查询",
				"icon" : "icon-verify",
				"url" : "../url/urlMenu.do?urlType=verify"
			}, {
				"menuid" : "15",
				"menuname" : "优惠券下载查询",
				"icon" : "icon-download",
				"url" : "../url/urlMenu.do?urlType=download"
			}, {
				"menuid" : "16",
				"menuname" : "短信上行记录",
				"icon" : "icon-smsup",
				"url" : "../url/urlMenu.do?urlType=smsup"
			} , {
				"menuid" : "17",
				"menuname" : "短信下行记录",
				"icon" : "icon-smsdown",
				"url" : "../url/urlMenu.do?urlType=smsdown"
			}  
			]
		} ]/*,
            point: [{
			                "menuid": "20",
			                "icon": "icon-sys",
			                "menuname": "邮件列表",
			                "menus": [{
							                    "menuid": "211",
							                    "menuname": "邮件用途",
							                    "icon": "icon-nav",
							                    "url": "#"
			                				}, {
							                    "menuid": "213",
							                    "menuname": "邮件调整",
							                    "icon": "icon-nav",
							                    "url": "#"
			                				}]
	    			},{
		                "menuid": "21",
		                "icon": "icon-sys",
		                "menuname": "邮件列表",
		                "menus": [{
						                    "menuid": "211",
						                    "menuname": "邮件用途",
						                    "icon": "icon-nav",
						                    "url": "#"
		                				}, {
						                    "menuid": "213",
						                    "menuname": "邮件调整",
						                    "icon": "icon-nav",
						                    "url": "#"
		                				}]
    			}],
    		point1: [{
			                "menuid": "30",
			                "icon": "icon-sys",
			                "menuname": "邮件列表1",
			                "menus": [{
							                    "menuid": "211",
							                    "menuname": "邮件用途1",
							                    "icon": "icon-nav",
							                    "url": "#"
			                				}, {
							                    "menuid": "213",
							                    "menuname": "邮件调整1",
							                    "icon": "icon-nav",
							                    "url": "#"
			                				}]
	
	 					},{
			                "menuid": "31",
			                "icon": "icon-sys",
			                "menuname": "邮件列表2",
			                "menus": [{
							                    "menuid": "211",
							                    "menuname": "邮件用途1",
							                    "icon": "icon-nav",
							                    "url": "#"
			                				}, {
							                    "menuid": "213",
							                    "menuname": "邮件调整1",
							                    "icon": "icon-nav",
							                    "url": "#"
			                				}]
	
	 					}],
	 		point2: [{
			                "menuid": "40",
			                "icon": "icon-sys",
			                "menuname": "邮件列表2",
			                "menus": [{
						                    "menuid": "211",
						                    "menuname": "邮件用途2",
						                    "icon": "icon-nav",
						                    "url": "#"
		                				}, {
						                    "menuid": "213",
						                    "menuname": "邮件调整2",
						                    "icon": "icon-nav",
						                    "url": "#"
		                				}]
						},{
			                "menuid": "41",
			                "icon": "icon-sys",
			                "menuname": "邮件列表2",
			                "menus": [{
							                    "menuid": "211",
							                    "menuname": "邮件用途1",
							                    "icon": "icon-nav",
							                    "url": "#"
			                				}, {
							                    "menuid": "213",
							                    "menuname": "邮件调整1",
							                    "icon": "icon-nav",
							                    "url": "#"
			                				}]
	
	 					}],
			point3: [{
		                "menuid": "50",
		                "icon": "icon-sys",
		                "menuname": "邮件列表3",
		                "menus": [{
					                    "menuid": "501",
					                    "menuname": "邮件用途3",
					                    "icon": "icon-nav",
					                    "url": "#"
	                				}, {
					                    "menuid": "503",
					                    "menuname": "邮件调整3",
					                    "icon": "icon-nav",
					                    "url": "#"
	                				}]
					},{
		                "menuid": "51",
		                "icon": "icon-sys",
		                "menuname": "邮件列表2",
		                "menus": [{
						                    "menuid": "211",
						                    "menuname": "邮件用途1",
						                    "icon": "icon-nav",
						                    "url": "#"
		                				}, {
						                    "menuid": "213",
						                    "menuname": "邮件调整1",
						                    "icon": "icon-nav",
						                    "url": "#"
		                				}]

 					}],
		    point4: [{
	                "menuid": "60",
	                "icon": "icon-sys",
	                "menuname": "邮件列表4",
	                "menus": [{
				                    "menuid": "601",
				                    "menuname": "邮件用途4",
				                    "icon": "icon-nav",
				                    "url": "#"
	            				}, {
				                    "menuid": "603",
				                    "menuname": "邮件调整4",
				                    "icon": "icon-nav",
				                    "url": "#"
	            				}]
				}, {
	                "menuid": "61",
	                "icon": "icon-sys",
	                "menuname": "邮件列表4",
	                "menus": [{
				                    "menuid": "601",
				                    "menuname": "邮件用途4",
				                    "icon": "icon-nav",
				                    "url": "#"
	            				}, {
				                    "menuid": "603",
				                    "menuname": "邮件调整4",
				                    "icon": "icon-nav",
				                    "url": "#"
	            				}],point6: [{
 				    "menuid": "2",
 				    "icon": "icon-sys",
 				    "menuname": "资产管理",
 				    "menus": [{
 				                    "menuid": "31",
 				                    "menuname": "资产信息管理",
 				                    "icon": "icon-nav",
 				                   "url" : "../ecd/asset/getAssetList.do"
 								}]
 				}]
			}]*/
};

//本地时钟
function clockon() {
    var now = new Date();
    var year = now.getFullYear(); //getFullYear getYear
    var month = now.getMonth();
    var date = now.getDate();
    var day = now.getDay();
    var hour = now.getHours();
    var minu = now.getMinutes();
    var sec = now.getSeconds();
    var week;
    month = month + 1;
    if (month < 10) month = "0" + month;
    if (date < 10) date = "0" + date;
    if (hour < 10) hour = "0" + hour;
    if (minu < 10) minu = "0" + minu;
    if (sec < 10) sec = "0" + sec;
    var arr_week = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
    week = arr_week[day];
    var time = "";
    time = year + "年" + month + "月" + date + "日" + " " + hour + ":" + minu + ":" + sec + " " + week;

    $("#bgclock").html(time);

    var timer = setTimeout("clockon()", 200);
}
