//获取当前日期和时间，格式为：yyyy-MM-dd HH:mm:ss
function getdata() {
	var datetime = new Date();
	var year = datetime.getFullYear();
	var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
	var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
	var hour = datetime.getHours() < 10 ? "0" + datetime.getHours() : datetime.getHours();
	var minute = datetime.getMinutes() < 10 ? "0" + datetime.getMinutes(): datetime.getMinutes();
	var second = datetime.getSeconds() < 10 ? "0" + datetime.getSeconds(): datetime.getSeconds();
	return year + "-" + month + "-" + date + " " + hour + ":" + minute + ":"+ second;
}
//给页面的input绑定键盘回车键向应提交查询。页面的查询方法必须为这个名称doSearch()
function keyup() {
	$(':input').bind('keyup', function(event) {
		if (event.keyCode == "13") {
			doSearch();//回车后要调用 的函数
		}
	});
}

//table列自适应table总宽度，按百分比形式,精度有损失，最好把页面宽度多留一点像素
function fixWidth(percent)  
{  
    var abcd=Math.floor(document.body.clientWidth * percent);    
    return abcd ;  
}

//自动调整jquery easyui dialog 的大小表名要是tt，如果不是tt请到下面加入
$(window).resize(function(){
	$('#tt').datagrid('resize');
	var tabdatagr=$('#tc');
	if(tabdatagr!=null&&tabdatagr!="")
	{
	$('#tc').datagrid('resize');
	}
	
});
