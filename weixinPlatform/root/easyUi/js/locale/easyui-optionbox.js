///js操作cookie

//通用的弹出选项框 父窗口：div，访问路径:rul
function addOptionBox(div,url,title,fckid)
{
	//弹出新增窗口
	var addType = $("."+fckid).val();
	$('#'+div).dialog({
			href: url+addType,
		    title: title,
		    closed: false,
		    iconCls: 'icon-save',
		    width: 1000,
		    height: 550,
		    cache: false,
		    modal: true,
		    resizable:true
	});
}