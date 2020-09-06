$(function () {


    // 获取建议消息列表
    /*
     *    从前台传入的json数组
     *    data = null
     *
     */
    $.ajax({
        type: "post",
        url: "http://localhost:8081/Manager/messages",
        dataType: "json", //返回数据类型
        async : false,
        contentType: 'application/json',
        success: function(data){
            /*
             *    从后台传出的json数组
             *    data = {
             *          "messages" : {
             *                  "messageId" : messageId ,
                                "message" : message
             *              },{
             *                  "messageId" : messageId ,
                                "message" : message
             *              }
             *      }
             *
             *    传出的JSON数组，是消息的集合，messages是集合，每个集合包含下列属性
             *
             *    messageId      建议消息的ID
             *    message       建议消息的内容
             *
             */
            for (var  i = 0 ; i < data.messages.length ; i++ ){
                $("#show_tbody").append("<tr>\n" +
                    "                <td colspan=\"2\">" + data.messages[i].messageId + "</td>\n" +
                    "                <td colspan=\"4\">" + data.messages[i].message + "</td>\n" +
                    "                <td>\n" +
                    "                    <a href=\"javascript:;\" class=\"del\">删除</a>\n" +
                    "                </td>\n" +
                    "            </tr>")
            }
        }
    });

    //  查询按钮
    $('#search_btn').click(function () {
        methods.seachMessage();
    });

    //  重置
    $('#back_btn').click(function () {
        $('#Ktext').val(' ');
        methods.resectList();
    });

    // 删除按钮，点击删除后，删除相应的td,也删除数据库中的建议消息
    $('.del').click(function () {
        var delect = $(this);
        var data = { "messageId" : $($(this).parents('td')).siblings()[0].innerText };
        var myJSON = JSON.stringify(data);
        // // 删除选择的建议消息
        /*
         *    从前台传入的json数组
         *
         *    messageId = 消息的id
         *
         */
        $.ajax({
            type: "post",
            url: "http://localhost:8081/Manager/mesDel",
            data : myJSON,
            dataType: "json", //返回数据类型
            contentType: 'application/json',
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
    //  查找ID和建议中的消息，支持模糊查询
    seachMessage: function () {

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
    //  刷新列表
    resectList: function () {
        $('#show_tbody tr').show();
    }
};