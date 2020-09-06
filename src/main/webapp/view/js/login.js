$(function () {

    // 初始化定时器，创建漂浮背景
    initEvent();
    function initEvent() {
        headerClick();
        initBG();
        var index = 0;
        var time = setInterval(function () {
            initBG();
            index++;

            if(index==10){
                clearInterval(time);
            }
        },8000);
    }

    // 初始化头部点击显示
    function headerClick() {
        var index = 0;
        $(".content-header a").click(function () {
            $(this).siblings().addClass("unCurr");
            $(this).removeClass("unCurr");
            $(".box").eq($(this).index()).addClass("show");
            $(".box").eq($(this).index()).siblings().removeClass("show");
        });
    }

    // 初始化背景特效
    function initBG() {
        var left = Math.random()*1200;
        var width = Math.random()*150;
        var height = width;
        var newBlock = document.createElement('div');
        $(newBlock).css({
            width : width,
            height : height,
            backgroundColor : "rgba(255, 255, 255, 0.25)",
            position : "absolute",
            left : left,
            bottom : -250,
            zIndex : -3,
            animation : "animation1 50s infinite ease-out"
        });
        $("body").append(newBlock);
    }

    //登录
    $("#submitBtn").click(function(){
        //序列化，是以键值对的形式发过来的
        /*
         *    从前台传入的json数组
         *    data = { "userName" : userName ,"passWord" : passWord }
         *
         *    userName 登录的用户名
         *    passWord 登录的密码
         *
         */
        var data = {
            'userName' : $('#userName').val(),
            'passWord' : $('#passWord').val(),
        };
        var myJson = JSON.stringify(data);
        $.ajax({
            type: "post",
            url: "http://localhost:8081/Manager/loginSubmit",
            data: myJson,
            dataType: "json", //返回数据类型
            contentType: 'application/json',
            success: function(data){
                /*
                 *    从后台传出的json数组
                 *    data = { "result" : result ,"message" : message }
                 *
                 *    result 是否登录成功
                 *    message 登录失败的原因。密码错误，等
                 *
                 */
                if(data.result){
                    alert('登录成功！')
                    window.parent.location.href = "index.html";
                } else{
                    alert(data.message);
                }
            }
        });
    });

    //注册
    $("#submitBtnRegister").click(function(){
        if($("#registerUserName").val() == ""){
            alert("用户名不能为空！");
        }else if($("#registerPassWord").val() == "" ){
            alert("密码不能为空！");
        }else if($("#check").val() == "" ){
            alert("验证码不能为空！");
        }else{
            /*
             *    从前台传入的json数组
             *    data = { "registerUserName" : registerUserName ,"registerPassWord" : registerPassWord ,"check" : check }
             *
             *    registerUserName      注册的用户名
             *    registerPassWord      注册的密码
             *    check                 注册的验证码，管理系统的需要有验证码，才能对后台管理系统账户进行申请
             *
             */
            var data = {
                'registerUserName' : $('#registerUserName').val(),
                'registerPassWord' : $('#registerPassWord').val(),
                'check' : $('#check').val(),
            };
            var myJson = JSON.stringify(data);
            $.ajax({
                type: "post",
                url: "http://localhost:8081/Manager/register",
                data: myJson,
                dataType: "json", //返回数据类型
                contentType: 'application/json',
                success: function(data){
                    /*
                     *    从后台传出的json数组
                     *    data = { "result" : result , "message" : message}
                     *
                     *    result   是否注册成功
                     *
                     */
                    if(data.result){
                        alert("注册成功！");
                        location.reload();
                    } else{
                        alert(data.message)
                    }
                }
            });
        }


    });

    $("#resetBtn").click(function () {
        $("#userName").val("");
        $("#passWord").val("");
    });
    $("#resetBtnRegister").click(function () {
        $("#registerUserName").val("");
        $("#registerPassWord").val("");
        $("#check").val("");
    });

});