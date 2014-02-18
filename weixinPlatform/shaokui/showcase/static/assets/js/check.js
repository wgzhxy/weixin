function isEmail(str){
       var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
       return reg.test(str);
}

function isIDCard (str) 
{ 
    var isIDCard1 = new Object();
    var isIDCard2 = new Object();
    //身份证正则表达式(15位) 
    isIDCard1=/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/; 
    //身份证正则表达式(18位) 
    isIDCard2=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[A-Z])$/; 
    if (isIDCard1.test(str)||isIDCard2.test(str))
    {    
        return true;
    }
    return false;
}

function isPhoneNumber(number){ 
    var pattern=/(^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$)|(^0{0,1}1[3|4|5|6|7|8|9][0-9]{9}$)/;
    if(pattern.test(number)){ 
        return true; 
    } 
    return false;
}

function isPassword(pwd)    
{    
    var patrn=/^(\w){6,18}$/;    
    if (!patrn.exec(pwd)) {
        return false  
    }
    return true  
}