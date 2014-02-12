
jQuery(document).ready(function() {
    /*
        初始化城市数据
    */
    $("#city").citySelect({
        prov:"贵州", 
        city:"贵阳",
        dist:"云岩区",
        nodata:"none"
    }); 
    /*
        Get verify code
    */
    //重新获取验证码
    var wait = 60;  
    get_code_time = function (o) {  
        if (wait == 0) {  
            o.removeAttribute("disabled");  
            o.value = "获取验证码";  
            wait = 60;  
        } else {  
            o.setAttribute("disabled", true);  
            o.value = wait + "秒后\n重新获取";  
            wait--;  
            setTimeout(function() {  
                get_code_time(o)  
            }, 1000)  
        }  
    }

    verify_phone_number = function (number) {
        if(number == '') {
            return false;
        }
        return true;
    }

    $('#getVerifyCodeButton').click(function() {
        var root = $('.common form');
        root.find("label[for='mobilephone']").html('手机号码');
        var number = root.find('input#mobilephone').val();
        if (verify_phone_number(number) === true) {
            var o = this;
            get_code_time(o);
        } else{
            root.find("label[for='mobilephone']").append("<span style='display:none' class='red'>-请检查您输入的手机号是否正确</span>");
            root.find("label[for='mobilephone'] span").fadeIn('medium');
        };
        /*
        $.ajax({
            url:"",
            type:"post",
            data: {},
            dataType: "json",
            success: function (data) {
                if(data.status == 1 && data.code == 200){
                    alert("验证码已发送至您的手机");
                    get_code_time(o);
                } else {
                    if(data.msg != ""){
                        alert(data.msg);
                    } else {
                        alert("短信验证码发送失败");
                    }
                }
            },
            error: function (data) {
                if(data.status == 0) {
                    alert(data.msg);
                } else {
                    alert("短信验证码发送失败");
                }
            }
        });
        */
    });

    /*
        Form validation
    */
    $('.common form').submit(function(){
        $(this).find("label[for='firstname']").html('First Name');
        $(this).find("label[for='lastname']").html('Last Name');
        $(this).find("label[for='username']").html('Username');
        $(this).find("label[for='email']").html('Email');
        $(this).find("label[for='password']").html('设置服务密码');
        ////
        var firstname = $(this).find('input#firstname').val();
        var lastname = $(this).find('input#lastname').val();
        var username = $(this).find('input#username').val();
        var email = $(this).find('input#email').val();
        var password = $(this).find('input#password').val();
        if(firstname == '') {
            $(this).find("label[for='firstname']").append("<span style='display:none' class='red'> - Please enter your first name.</span>");
            $(this).find("label[for='firstname'] span").fadeIn('medium');
            return false;
        }
        if(lastname == '') {
            $(this).find("label[for='lastname']").append("<span style='display:none' class='red'> - Please enter your last name.</span>");
            $(this).find("label[for='lastname'] span").fadeIn('medium');
            return false;
        }
        if(username == '') {
            $(this).find("label[for='username']").append("<span style='display:none' class='red'> - Please enter a valid username.</span>");
            $(this).find("label[for='username'] span").fadeIn('medium');
            return false;
        }
        if(email == '') {
            $(this).find("label[for='email']").append("<span style='display:none' class='red'> - Please enter a valid email.</span>");
            $(this).find("label[for='email'] span").fadeIn('medium');
            return false;
        }
        if(password == '') {
            $(this).find("label[for='password']").append("<span style='display:none' class='red'>-密码为6-18位的数字或字母</span>");
            $(this).find("label[for='password'] span").fadeIn('medium');
            return false;
        }
    });


});


