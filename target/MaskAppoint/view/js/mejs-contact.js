$(function () {


    // 获取建议消息列表
    /*
     *    从前台传入的json数组
     *    data = null
     *
     */
    $.ajax({
        type: "post",
        url: "http://localhost:8081/Manager/contacts",
        dataType: "json", //返回数据类型
        async : false,
        contentType: 'application/json',
        success: function(data){
            /*
             *    从后台传出的json数组
             *    data = {
             *          "contacts" : {
             *                            "contactId" : contactId ,
                                          "contactName" : contactName ,
                                          "contactUsername" : contactUsername ,
                                          "contactEmail" : contactEmail ,
                                          "contactPhone" : contactPhone ,
                                          "contactMessage" : contactMessage
                                    }
             *      }
             *
             *    contactId                 联系人的id
             *    contactName               联系人的姓名
             *    contactUsername           联系人的用户名
             *    contactEmail              联系人的邮箱
             *    contactPhone              联系人的手机号
             *    contactMessage            联系人的消息
             *
             */
            for ( var i = 0 ; i < data.contacts.length ; i++){
                $("#show_tbody").append("<tr>\n" +
                    "                <td>" + data.contacts[i].contactId + "</td>\n" +
                    "                <td>" + data.contacts[i].contactName + "</td>\n" +
                    "                <td>" + data.contacts[i].contactUsername + "</td>\n" +
                    "                <td>" + data.contacts[i].contactEmail + "</td>\n" +
                    "                <td>" + data.contacts[i].contactPhone + "</td>\n" +
                    "                <td>" + data.contacts[i].contactMessage + "！</td>\n" +
                    "                <td>\n" +
                    "                    <a href=\"javascript:;\" class=\"del\">删除</a>\n" +
                    "                </td>\n" +
                    "            </tr>")
            }
        }
    });

    $('#search_btn').click(function () {
        methods.seachName();
    });

    $('#back_btn').click(function () {
        $('#Ktext').val(' ');
        methods.resectList();
    });

    // 删除按钮，点击删除后，删除相应的td,也删除数据库中的联系人信息
    $('.del').click(function () {
        var delect = $(this);
        var data = { "contactId" : $($(this).parents('td')).siblings()[0].innerText };
        var myJSON = JSON.stringify(data);
        // // 删除选择的建议消息
        /*
         *    从前台传入的json数组
         *    contactId    联系人的id
         *
         */
        $.ajax({
            type: "post",
            url: "http://localhost:8081/Manager/contactDelete",
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

    // 查询ID和姓名
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
    }
};