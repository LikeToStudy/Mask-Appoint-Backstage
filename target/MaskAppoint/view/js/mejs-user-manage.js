$(function () {

    // 获取用户列表
    /*
     *    从前台传入的json数组
     *    data = null
     *
     */
    $.ajax({
        type: "post",
        url: "http://localhost:8081/Manager/getAllUser",
        dataType: "json", //返回数据类型
        async : false,
        contentType: "application/json",
        success: function(data){
            /*
             *    从后台传出的json数组
             *    data = {
             *          "users" : {
             *                          "userId" : userId ,
             *                          "userName" : userName ,
             *                          "userSex" : userSex,
             *                          "userBirth" : userBirth,
             *                          "userPhone" : userPhone,
             *                          "userNation" : userNation,
             *                          "userAddress" : userAddress,
             *                          "userPhoneNumber" : userPhoneNumber,
             *                          "userEmail" : userEmail,
             *                  }
             *      }
             *
             *    传出的JSON数组，是消息的集合，users是集合，每个集合包含下列属性
             *
             *    userId            用户的id
             *    userName          用户的姓名
             *    userSex           用户的性别
             *    userBirth         用户的出生日期
             *    userPhone         用户的绑定手机号
             *    userNation        用户的民族
             *    userAddress       用户的收件地址
             *    userPhoneNumber   用户的收件号码
             *    userEmail         用户的邮箱
             *
             *
             */
            for ( var i = 0 ; i < data.users.length ; i++){
                $("#show_tbody").append("<tr>\n" +
                    "                <td>" + data.users[i].userId + "</td>\n" +
                    "                <td>" + data.users[i].userName + "</td>\n" +
                    "                <td>" + data.users[i].userSex + "</td>\n" +
                    "                <td>" + data.users[i].userBirth + "</td>\n" +
                    "                <td>" + data.users[i].userPhone + "</td>\n" +
                    "                <td>" + data.users[i].userNation + "</td>\n" +
                    "                <td>" + data.users[i].userAddress + "</td>\n" +
                    "                <td>" + data.users[i].userPhoneNumber + "</td>\n" +
                    "                <td>" + data.users[i].userEmail + "</td>\n" +
                    "                <td>\n" +
                    "                    <a href=\"#\" class=\"edit\">编辑</a>\n" +
                    "                    <a href=\"#\" class=\"del\">删除</a>\n" +
                    "                </td>\n" +
                    "            </tr>")
            }
        }
    });

    $('#add_btn').click(function () {

        //判断是添加还是修改
        if($("#userId").val() != null){

            // 点击添加按钮，把相关产品信息进行修改进入数据库中
            var data = {
                "userId" : $("#userId").val(),
                "userSex" : $("#userSex").val(),
                "userBirth" : $("#userBirth").val(),
                "userPhone" : $("#userPhone").val(),
                "userNation" : $("#userNation").val(),
                "userAddress" : $("#userAddress").val(),
                "userPhoneNumber" : $("#userPhoneNumber").val(),
                "userEmail" : $("#userEmail").val(),
            };
            var myJSON = JSON.stringify(data);
            // // 添加产品信息
            /*
             *    从前台传入的json数组
             *    userId            用户的id
             *    userSex           用户的性别
             *    userBirth         用户的出生日期
             *    userPhone         用户的绑定手机号
             *    userNation        用户的民族
             *    userAddress       用户的收件地址
             *    userPhoneNumber   用户的收件号码
             *    userEmail         用户的邮箱
             *
             */
            $.ajax({
                type: "post",
                url: "http://localhost:8081/Manager/modifyInfo",
                data : myJSON,
                dataType: "json", //返回数据类型
                contentType: "application/json",
                success: function(data){
                    /*
                     *    从后台传出的json数组
                     *    data = { "result" : result }
                     *
                     *    result        修改成功返回true,否则返回false
                     *
                     */
                    if(data.result){
                        alert("修改成功！");
                    }else{
                        alert("修改失败，系统繁忙，请稍后再试！");
                    }
                }
            });

        }else {

            // 添加用户信息
            var data = {
                "userId": $("#userId").val(),
                "userName": $("#userName").val(),
                "userSex": $("#userSex").val(),
                "userBirth": $("#userBirth").val(),
                "userPhone": $("#userPhone").val(),
                "userNation": $("#userNation").val(),
                "userAddress": $("#userAddress").val(),
                "userPhoneNumber": $("#userPhoneNumber").val(),
                "userEmail": $("#userEmail").val(),
            };
            var myJSON = JSON.stringify(data);
            // // 添加产品信息
            /*
             *    从前台传入的json数组
             *    userId            用户的id
             *    userName          用户的姓名
             *    userSex           用户的性别
             *    userBirth         用户的出生日期
             *    userPhone         用户的绑定手机号
             *    userNation        用户的民族
             *    userAddress       用户的收件地址
             *    userPhoneNumber   用户的收件号码
             *    userEmail         用户的邮箱
             *
             */
            $.ajax({
                type: "post",
                url: "http://localhost:8081/Manager/addUser",
                data: myJSON,
                dataType: "json", //返回数据类型
                contentType: "application/json",
                success: function (data) {
                    /*
                     *    从后台传出的json数组
                     *    data = { "result" : result }
                     *
                     *    result        添加成功返回true,否则返回false
                     *
                     */
                    if (data.result) {
                        alert("添加成功！");
                    } else {
                        alert("添加失败，系统繁忙，请稍后再试！");
                    }
                }
            });
        }
        methods.addHandle();
    });

    $('#show_tbody').on('click','.edit', function () {
        trIndex = $('.edit', '#show_tbody').index($(this));
        addEnter = false;
        $(this).parents('tr').addClass('has_case');
        methods.editHandle(trIndex);
    })

    $('#search_btn').click(function () {
        methods.seachId();
    });

    $('#back_btn').click(function () {
        $('#Ktext').val(' ');
        methods.resectList();
    })

    $('.del').click(function () {
        $(this).parents('tr').remove();
    });

    $('.edit').click(function () {
        $('#userId').attr("disabled","disabled");
        $('#userName').attr("disabled","disabled");
    });

    $('#renyuan').on('hide.bs.modal',function() {
        addEnter = true;
        $('#show_tbody tr').removeClass('has_case');
        $('#xztb input').val(' ');
        $('#xztb select').find('option:first').prop('selected', true)
    });

    $("#new_add").click(function () {
        $('#userId').attr("disabled",false);
        $('#userName').attr("disabled",false);
    });

    // 删除按钮，点击删除后，删除相应的td,也删除数据库中的产品信息
    $('.del').click(function () {
        var data = { "userId" : $($(this).parents('td')).siblings()[0].innerText };
        var myJSON = JSON.stringify(data);
        // // 删除选择的建议消息
        /*
         *    从前台传入的json数组
         *    userId    用户的id
         *
         */
        $.ajax({
            type: "post",
            url: "http://localhost:8081/Manager/delUser",
            data : myJSON,
            dataType: "json", //返回数据类型
            contentType : "application/json",
            success: function(data){
                /*
                 *    从后台传出的json数组
                 *    data = { "result" : result }
                 *
                 *    result        删除成功返回true,否则返回false
                 *
                 */
                if(data.result){
                    alert("删除成功！");
                    $(this).parents('tr').remove();
                }else{
                    alert("删除失败，系统繁忙，请稍后再试！");
                }
            }
        });
    });

});

var addEnter = true,
    noRepeat = true,
    jobArr = [],
    phoneArr = [],
    tdStr = '',
    trIndex,
    hasNullMes = false,
    tarInp = $('#xztb input');

var methods = {

    addHandle: function (the_index) {
        hasNullMes = false;
        methods.checkMustMes();
        if (hasNullMes) {
            return;
        }
        if (addEnter) {
            methods.checkRepeat();
            if (noRepeat) {
                methods.setStr();
                $('#show_tbody').append('<tr>' + tdStr + '</tr>');
                $('#renyuan').modal('hide');
            }
        }else{
            methods.setStr();
            $('#show_tbody tr').eq(trIndex).empty().append(tdStr);
            $('#renyuan').modal('hide');
        }
    },
    editHandle: function (the_index) {

        var tar = $('#show_tbody tr').eq(the_index);
        var nowConArr = [];
        for (var i=0; i<tar.find('td').length-1;i++) {
            var a = tar.children('td').eq(i).html();
            nowConArr.push(a);
        }

        $('#renyuan').modal('show');

        for (var j=0;j<tarInp.length;j++) {
            tarInp.eq(j).val(nowConArr[j])
        }

    },
    setStr: function () {

        tdStr = '';
        for (var a=0; a<tarInp.length; a++) {
            tdStr+= '<td>' + tarInp.eq(a).val() + '</td>'
        }
        tdStr+= '<td><a href="#" class="edit">编辑</a> <a href="#" class="del">删除</a></td>';

    },
    // 查询ID和姓名
    seachId: function () {
        var a = $('#show_tbody tr');
        var nameVal = $('#Ktext').val().trim();
        var nameStr = '',
            nameArr = [];
        var idStr = '',
            idArr = [];

        if (nameVal==='') {
            bootbox.alert({
                title: "来自Mask Appointment的提示",
                message: "搜索内容不能为空",
                closeButton:false
            });
            return;
        }

        for (var c=0;c<a.length;c++) {
            var txt = $('td:first', a.eq(c)).html().trim();
            var idTxt = $('td:nth-child(2)', a.eq(c)).html().trim();
            nameArr.push(txt);
            idArr.push(idTxt);
        }

        a.hide();
        for (var i=0;i<nameArr.length;i++) {
            if (nameArr[i].indexOf(nameVal)>-1) {
                a.eq(i).show();
            }
        }
        for (var i=0;i<idArr.length;i++) {
            if (idArr[i].indexOf(nameVal)>-1) {
                a.eq(i).show();
            }
        }
    },
    resectList: function () {
        $('#show_tbody tr').show();
    },
    checkMustMes: function () {

        if ($('#userId').val().trim()==='') {
            bootbox.alert({
                title: "来自Mask Appointment的提示",
                message: "ID为必选项，请填写",
                closeButton:false
            });
            hasNullMes = true;
            return
        }
        if ($('#userName').val().trim()==='') {
            bootbox.alert({
                title: "来自Mask Appointment的提示",
                message: "姓名为必选项，请填写",
                closeButton:false
            });
            hasNullMes = true;
            return
        }
        if ($('#userSex').val().trim()==='') {
            bootbox.alert({
                title: "来自Mask Appointment的提示",
                message: "性别为必选项，请填写",
                closeButton:false
            })
            hasNullMes = true;
            return
        }
        if ($('#userBirth').val().trim()==='') {
            bootbox.alert({
                title: "来自Mask Appointment的提示",
                message: "出生日期为必选项，请填写",
                closeButton:false
            })
            hasNullMes = true;
            return
        }
        if ($('#userPhone').val().trim()==='') {
            bootbox.alert({
                title: "来自Mask Appointment的提示",
                message: "手机号为必选项，请填写",
                closeButton:false
            })
            hasNullMes = true;
            return
        }
        if ($('#userNation').val().trim()==='') {
            bootbox.alert({
                title: "来自Mask Appointment的提示",
                message: "民族为必选项，请填写",
                closeButton:false
            })
            hasNullMes = true;
            return
        }
        if ($('#userAddress').val().trim()==='') {
            bootbox.alert({
                title: "来自Mask Appointment的提示",
                message: "收件地址为必选项，请填写",
                closeButton:false
            })
            hasNullMes = true;
            return
        }
        if ($('#userPhoneNumber').val().trim()==='') {
            bootbox.alert({
                title: "来自Mask Appointment的提示",
                message: "收件手机号为必选项，请填写",
                closeButton:false
            })
            hasNullMes = true;
            return
        }
    },
    // 测试ID和手机好是否重复
    checkRepeat: function () {

        jobArr = [], phoneArr = [];

        for (var i = 0; i<$('#show_tbody tr:not(".has_case")').length;i++) {
            var par = '#show_tbody tr:not(".has_case"):eq(' + i + ')';
            var a = $('td:eq(0)', par).html().trim(),
                b = $('td:eq(4)', par).html().trim();
            jobArr.push(a);
            phoneArr.push(b);
        }
        var userId = $('#userId').val().trim();
        var userPhone = $('#userPhone').val().trim();

        if (jobArr.indexOf(userId)>-1) {
            noRepeat = false;
            bootbox.alert({
                title: "来自Mask Appointment的提示",
                message: "ID重复了，请重新输入",
                closeButton:false
            });
            return;
        }
        if (phoneArr.indexOf(userPhone)>-1) {
            noRepeat = false;
            bootbox.alert({
                title: "来自Mask Appointment的提示",
                message: "绑定手机号重复了，请重新输入",
                closeButton:false
            });
            return;
        }
        noRepeat = true;
    }
}