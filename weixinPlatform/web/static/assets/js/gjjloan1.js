function isIdCardNo(sNo){
 sNo = sNo.toString()
  if (sNo.length==18)
    {

  var a,b,c
  if (!isInt(sNo.substr(0,17))) {return false}

  a=parseInt(sNo.substr(0,1))*7+parseInt(sNo.substr(1,1))*9+parseInt(sNo.substr(2,1))*10;
  a=a+parseInt(sNo.substr(3,1))*5+parseInt(sNo.substr(4,1))*8+parseInt(sNo.substr(5,1))*4;
  a=a+parseInt(sNo.substr(6,1))*2+parseInt(sNo.substr(7,1))*1+parseInt(sNo.substr(8,1))*6;
  a=a+parseInt(sNo.substr(9,1))*3+parseInt(sNo.substr(10,1))*7+parseInt(sNo.substr(11,1))*9;
  a=a+parseInt(sNo.substr(12,1))*10+parseInt(sNo.substr(13,1))*5+parseInt(sNo.substr(14,1))*8;
  a=a+parseInt(sNo.substr(15,1))*4+parseInt(sNo.substr(16,1))*2;
  b=a%11;

  if (b==2)
  {
	  c=sNo.substr(17,1);
   //c=sNo.substr(17,1).toUpperCase();
  }
  else
  {
   c=parseInt(sNo.substr(17,1));
  }

  switch(b)
  {
   case 0: if ( c!=1 ) {return false;}break;
   case 1: if ( c!=0 ) {return false;}break;
   case 2: if ( c!="X") {return false;}break;
   case 3: if ( c!=9 ) {return false;}break;
   case 4: if ( c!=8 ) {return false;}break;
   case 5: if ( c!=7 ) {return false;}break;
   case 6: if ( c!=6 ) {return false;}break;
   case 7: if ( c!=5 ) {return false;}break;
   case 8: if ( c!=4 ) {return false;}break;
   case 9: if ( c!=3 ) {return false;}break;
   case 10: if ( c!=2 ){return false}
  }
 }
 else
 {
  if (!isInt(sNo)) {return false}
 }

 switch(sNo.length){
  case 15: if (isValidDate(sNo.substr(6,2),sNo.substr(8,2),sNo.substr(10,2))) {return true}
  case 18: if (isValidDate(sNo.substr(6,4),sNo.substr(10,2),sNo.substr(12,2))) {return true}
  }
 return false
}
function isValidDate(iY, iM, iD) { var undefined
  if ( iY != undefined && !isNaN(iY) && iY >=0 && iY<=9999 &&
       iM != undefined && !isNaN(iM) && iM >=1   && iM<=12   &&
       iD != undefined && !isNaN(iD) && iD >=1   && iD<=31  )  {
       if (iY<50) iY = 2000+iY; else if (iY<100) iY=1900+iY;
    if (iM == 2  && (isLeapYear(iY)  && iD > 29 || !isLeapYear(iY) && iD>28) ||
        iD == 31 && (iM<7 && iM%2==0 || iM>7 && iM%2==1) )
  return false
 else return true      }
 else  return false }

function isLeapYear(year)
{
if((year%4==0&&year%100!=0)||(year%400==0))
{
return true;
}

return false;
}
function isEmpty (str) {
if ((str==null)||(str.length==0)) return true;
else return(false);
}
function isInt (theStr) {
var flag = true;

if (isEmpty(theStr)) { flag=false; }
else
{ for (var i=0; i<theStr.length; i++) {
if (theStr.substring(i,i+1) ==".") {
flag = false; break;
}
}
}
return(flag);
}
function isnumeric(p)
{
 if (p == "")
  return false;
 var l = p.length;
 var count=0;
 for(var i=0; i<l; i++)
 {
  var digit = p.charAt(i);
  if(digit == "." )
 {
    ++count;
    if(count>1) return false;
   }
  else if(digit < "0" || digit > "9")
  return false;
 }
 return true;
}
function Format(num,dotLen) {

    var dot=0
    var num1=0
//change by liyugen
    if (typeof dotLen=="undefined")
        dot=2
    else
        dot=dotLen
    if (isNaN(parseFloat(num)))
        return 0
    else
        num1=parseFloat(num)
    var n1=Math.pow(10,dot)
    if (n1==0)
        var iValue= Math.round(num1)
    else
        var iValue=    Math.round(num1*n1)/n1
  var sValue = iValue.toString();
  if (sValue.indexOf(".") == -1)
  {
      sValue = sValue + ".00";
  }
  else
  {
      if (sValue.indexOf(".") == sValue.length - 1)
      {
          sValue = sValue + "00";
      }
      else if (sValue.indexOf(".") == sValue.length - 2)
      {
          sValue = sValue + "0";
      }
  }
return sValue
}
function c_id_card(obj){
var id_card=obj.id_card.value;//身份证
var age=0;
age_qx.innerText='';
if(id_card.length>0)
{
if(!isInt(id_card)){alert('身份证号码必须是数字');return false;}
if(id_card.length!=15 && id_card.length!=18){alert('身份证号码长度为15或18位');return false;}
if(!isIdCardNo(id_card)){alert('请输入正确的身份证号码');return false;}
var  a=new  Date();
var  y=Number(a.getFullYear());
if(id_card.length==15){age=y-Number('19'+id_card.substr(6,2));}else{age=y-Number(id_card.substr(6,4));}
var max_qx=70-age;if(max_qx>30){max_qx=30;}
age_qx.innerText='最长贷款'+max_qx+'年';
}
}
function gjjloan1(obj)
{
  var gryjce;//住房公积金个人月缴存额
  var poyjce;//配偶住房公积金个人月缴存额
  var grjcbl;//缴存比例
  var pojcbl;//配偶缴存比例
  var xy;//个人信用
  var fwzj;//房屋总价
  var fwxz;//房屋性质
  var dknx;//贷款申请年限
  var syhk;//首月还款额

  var dked;//需要贷款额度
  var hkfs;//还款方式
  var bxhj;//本息合计
  var bxhj2;//本息合计等本金

//中间变量
 var gbl;
 var jtysr;//家庭月收入
 var r;//月还款
 var gjjdka;//住房公积金贷款额度a
 var gjjdkb;//住房公积金贷款额度b
 var gjjdkc;//住房公积金贷款额度c

 gryjce=obj.mount2.value;
if(gryjce<=0){alert('住房公积金个人月缴存额不能为空,请输入');
                     obj.mount2.value='';obj.mount2.focus();return;}

 poyjce=obj.mount3.value;
 if(poyjce.length>0 && !isnumeric(poyjce))
{alert("配偶月缴存额录入不正确");return;}

if (obj.jcbl.value=="" || !isInt(obj.jcbl.value) || Number(obj.jcbl.value)<=0 ||Number(obj.jcbl.value)>=100)
{
	alert("缴存比例不正确");return;
}
if (poyjce.length>0 &&(obj.p_bl.value=="" || !isInt(obj.p_bl.value) || Number(obj.p_bl.value)<=0||Number(obj.p_bl.value)>=100) )
{
	alert("配偶缴存比例不正确");return;
}
grjcbl=obj.jcbl.value/100;
pojcbl=obj.p_bl.value/100;
/*
if (obj.xz[0].checked==true){fwxz=0.9;}
else {fwxz=0.95;}
*/
if (obj.xz[0].checked==true){fwxz=0.9;}
else {fwxz=0.8;}

if (obj.xy[0].checked==true){xy=1.3;}
else if(obj.xy[1].checked==true){xy=1.15;}
else {xy=1;}

 fwzj=obj.mount.value;

if(fwzj<=0){alert('＂房屋评估价值或实际购房款＂不能为空,请输入');
                     obj.mount.value='';return;}

 dknx=Math.round(obj.mount10.value);

if(dknx<=0){alert('贷款申请年限不能为空,请输入');
                     obj.mount10.value='';return;}
if(dknx>30){alert('贷款申请年限不能大于30年,请重新输入');
                     obj.mount10.value='';return;}
                     var bcv=0;
                     if (dknx>5)
                     {
                      bcv=Math.round( 1000000 * l6_30/12 ) / 1000000;
                    }else{
                    	 bcv=Math.round( 1000000 * l1_5/12 ) / 1000000;
                    	}
r=adv_format((10000*bcv*Math.pow(1+bcv,12*dknx))/(Math.pow(1+bcv,12*dknx)-1),2);

if(poyjce.length>0)
{
	jtysr=Math.ceil((gryjce/grjcbl+poyjce/pojcbl)*10)/10;
}
else
{
	jtysr=Math.ceil((gryjce/grjcbl)*10)/10;
}
if(jtysr<=400){alert('家庭月收入低于400，不符合贷款条件');
                     return;}

gjjdka=Math.min(Math.round((jtysr-400)/r*10000*10)/10,800000);
gjjdkb=Math.round(gjjdka*xy*10)/10;
gjjdkc=Math.round(fwzj*fwxz*10)/10;
//obj.ze2.value=gjjdka; //jtysr;
obj.ze2.value=Math.floor(Math.min(gjjdkb,gjjdkc)/10000*10)/10;
zgdk=obj.ze2.value; //最高贷款额度

//计算申请的最高贷款额度

/*
说明
家庭月收入＝住房公积金个人月缴存额÷缴存比例+配偶住房公积金个人月缴存额÷缴存比例

住房公积金贷款额度a＝（家庭月收入－400）÷等额均还月还款额每万元月还款额，且不大于40万元

对于个人信用等级为AAA的，住房公积金贷款额度b＝住房公积金贷款额度a×130％

对于个人信用等级为AA的，住房公积金贷款额度b＝住房公积金贷款额度a×115％

对于个人信用等级其它的，住房公积金贷款额度b＝住房公积金贷款额度a

对房屋性质为商品房期房的，住房公积金贷款额度c＝房屋总价×90％

对房屋性质为其它的，住房公积金贷款额度c＝房屋总价×95％

最高贷款额度d＝min（b，c）

等额均还还款公式：

等额本金还款公式

首月还款额=P/（n×12）+借款总额×I

其中：P为贷款本金，I为月利率，n为贷款年限。

  */

}
function adv_format(value,num)   //四舍五入
    {
    var a_str = formatnumber(value,num);
    var a_int = parseFloat(a_str);
    if (value.toString().length>a_str.length)
        {
        var b_str = value.toString().substring(a_str.length,a_str.length+1)
        var b_int = parseFloat(b_str);
        if (b_int<5)
            {
            return a_str
            }
        else
            {
            var bonus_str,bonus_int;
            if (num==0)
                {
                bonus_int = 1;
                }
            else
                {
                bonus_str = "0."
                for (var i=1; i<num; i++)
                    bonus_str+="0";
                bonus_str+="1";
                bonus_int = parseFloat(bonus_str);
                }
            a_str = formatnumber(a_int + bonus_int, num)
            }
        }
        return a_str
    }
function formatnumber(value,num)    //直接去尾
    {
    var a,b,c,i
    a = value.toString();
    b = a.indexOf('.');
    c = a.length;
    if (num==0)
        {
        if (b!=-1)
            a = a.substring(0,b);
        }
    else
        {
        if (b==-1)
            {
            a = a + ".";
            for (i=1;i<=num;i++)
                a = a + "0";
            }
        else
            {
            a = a.substring(0,b+num+1);
            for (i=c;i<=b+num;i++)
                a = a + "0";
            }
        }
    return a
    }