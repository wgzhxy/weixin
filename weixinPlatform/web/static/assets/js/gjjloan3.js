function gjjloan3(obj)
{
var dkye=0;//所需要偿还的余额
var dkzqs=0;//贷款总期数
var gdhke=0;//固定还款额
var sxhke=0;//所需还款额
var sxhky=0; //所需要的还款月数
var zhhke=0;//最后还款额
var zglx=0;//总共利息
var dylx=0 ; //当月利息
var syqs=0;
syqs=Number(obj.lx8_sy.value);
dkye=Number(obj.lx7.value);
if(dkye<=0 || dkye >780000 || isNaN(dkye) )
{
	alert("贷款余额输入不正确");
	return;
}
var ll;   //月利率
if(obj.lx8[1].checked)
{ll=Math.round( 1000000 * l6_30/12 ) / 1000000;}
else
{ll=Math.round( 1000000 * l1_5/12 ) / 1000000;}
/*if(dkzqs<=0 || dkzqs>360 || isNaN(dkzqs))
{
	alert("贷款总期数不正确!");
	return;
}*/

gdhke=Number(obj.lx9.value);
if( Number(syqs) <= 0  || isNaN(syqs))
{
	alert("请输入正确的剩于期数!");
	return;
}
if( Number(gdhke) <= 0  || isNaN(gdhke))
{
	alert("请输入正确的固定还款额!");
	return;
}

var first_lx=Math.round( dkye * ll *100 ) /100 ;
if (first_lx > gdhke)
{alert('固定还款额必须大于首月利息 '+first_lx);obj.lx9.focus();obj.lx9.select();return;}
var yjqs=0;//Math.ceil(dkye/gdhke);
var sxhky=0;
for(var i=1;i<syqs;i++){
     //需要还款月+1
     sxhky =sxhky + 1;
     //计算一个月的利息
     dylx = Math.round( dkye * ll *100 ) /100 ;
     //累计利息
     zglx = zglx+dylx;
//Math.round ((zglx + dylx) *100) /100 ;

      if (dkye + dylx >= gdhke  )
       {
		  if(dkye + dylx == gdhke)zhhke= dkye +  dylx;
          dkye = Math.round((dkye-( gdhke - dylx ))*100)/100;
//Math.round(  (dkye - ( gdhke - dylx ))*100  ) /100;
       }
      else
       {
	   zhhke= dkye +  dylx;
	   dkye=-1;
        break;
       }

}
if(dkye>0){
	sxhky =sxhky + 1;
	dylx = Math.round( dkye * ll *100 ) /100 ;
	zglx = zglx+dylx;
	zhhke= dkye +  dylx
}


if (sxhky > syqs)
   {
      alert("输入不正确,请重新核对贷款余额和月固定还款额!"+sxhky);
      return;
   }



    obj.lx10.value=sxhky ;
    obj.lx11.value=Format(zhhke,2);
    obj.lx12.value=Format(zglx,2) ;
      //如果剩余本金+利息< 固定还款额度   ==> 还款结束  ->最后期还款额

}