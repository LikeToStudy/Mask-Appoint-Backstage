$(function () {


    // 获取预约记录
    /*
     *    从前台传入的json数组
     *    data = null
     *
     */
    $.ajax({
        type: "post",
        url: "http://localhost:8081/Manager/getAllAppoint",
        async : false,
        dataType: "json", //返回数据类型
        contentType: "application/json",
        success: function(data){
            /*
             *    从后台传出的json数组
             *    data = {
             *
             *          "appointments" : {  "userId" : userId ,
             *                              "userName" : userName ,
             *                              "appointmentTime" : appointmentTime ,
             *                              "appointmentSpeed" : appointmentSpeed }
             *       }
             *
             *    传出的JSON数组，是预约结果的集合，appointments是集合，每个集合包含下列属性
             *
             *    appointmentId             预约ID
             *    userName                 用户的姓名
             *    appointmentTime           预约的时间
             *    appointmentSpeed         预约的进度
             *
             */
            for (var i=0 ; i<data.appointments.length ; i++){
                $("#show_tbody").append("<tr>\n" +
                    "                <td colspan=\"1\">" + data.appointments[i].appointmentId + "</td>\n" +
                    "                <td colspan=\"1\">" + data.appointments[i].userName + "</td>\n" +
                    "                <td colspan=\"2\">" + data.appointments[i].appointmentTime + "</td>\n" +
                    "                <td colspan=\"2\">" + data.appointments[i].appointmentSpeed + "</td>\n" +
                    "                <td>\n" +
                    "                    <a href=\"javascript:;\" class=\"del\">删除</a>\n" +
                    "                </td>\n" +
                    "            </tr>")
            }
        }
    });

    $('#show_tbody').on('click','.edit', function () {
        trIndex = $('.edit', '#show_tbody').index($(this));
        addEnter = false;
        $(this).parents('tr').addClass('has_case');
        methods.editHandle(trIndex);
    })

    $('#search_btn').click(function () {
        methods.seachName();
    })

    $('#back_btn').click(function () {
        $('#Ktext').val(' ');
        methods.resectList();
    })

    // 删除按钮，点击删除后，删除相应的td,也删除数据库中的建议消息
    $('.del').click(function () {
        var delect = $(this);
        var data = {
            "appointmentId" : $($(this).parents('td')).siblings()[0].innerText,
        };
        var myJSON = JSON.stringify(data);
        // // 删除选择的建议消息
        /*
         *    从前台传入的json数组
         *
         *    appointmentId     预约记录的Id
         *
         */
        $.ajax({
            type: "post",
            url: "http://localhost:8081/Manager/delAppoint",
            data : myJSON,
            dataType: "json", //返回数据类型
            contentType: "application/json",
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
                    delect.parents('tr').remove();
                }else{
                    alert("删除失败，系统繁忙，请稍后再试！");
                }
            }
        });
    });

});

var methods = {

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
        for (var p=0;p<tarSel.length;p++) {
            var the_p = p+tarInp.length;
            tarSel.eq(p).val(nowConArr[the_p]);
        }

    },
    // 搜索ID和姓名
    seachName: function () {
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
            var txt = $('td:nth-child(2)', a.eq(c)).html().trim();
            var idTxt = $('td:nth-child(3)', a.eq(c)).html().trim();
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
    }
};