$(function () {

    // 获取产品列表
    /*
     *    从前台传入的json数组
     *    data = null
     *
     */
    $.ajax({
        type: "post",
        async : false,
        url: "http://localhost:8081/Manager/getAllPro",
        dataType: "json", //返回数据类型
        contentType : "application/json",
        success: function(data){
            /*
             *    从后台传出的json数组
             *    data = {
             *          "products" : {
             *                              "productId" : id ,
             *                              "productName" : name ,
             *                              "productStock" : username
             *                      }
             *      }
             *
             *    传出的JSON数组，是消息的集合，products是集合，每个集合包含下列属性
             *
             *    productId          产品的id
             *    productName        产品的名称
             *    productStock       产品的库存
             *
             *
             */
            for ( var i = 0 ; i < data.products.length ; i++){
                $("#show_tbody").append("<tr>\n" +
                    "                <td>" + data.products[i].productId + "</td>\n" +
                    "                <td colspan=\"2\">" + data.products[i].productName + "</td>\n" +
                    "                <td colspan=\"1\">" + data.products[i].productStock + "</td>\n" +
                    "                <td>\n" +
                    "                    <a href=\"javascript:;\" class=\"edit\">编辑</a>\n" +
                    "                </td>\n" +
                    "            </tr>")
            }
        }
    });

    // 添加或者修改信息
    $('#add_btn').click(function () {
        // 添加产品
        var data = {
            "productId" : $("#productId").val(),
            "productStock" : $("#productStock").val()
        };
        var myJSON = JSON.stringify(data);
        // // 添加产品信息
        /*
             *    从前台传入的json数组
             *    productId       产品的id
             *    productStock    产品的库存
             *
             */
        $.ajax({
            type: "post",
            url: "http://localhost:8081/Manager/updateStock",
            data : myJSON,
            dataType: "json", //返回数据类型
            contentType : "application/json",
            success: function(data){
                /*
                             *    从后台传出的json数组
                             *    data = { "result" : result }
                             *
                             *    result        添加成功返回true,否则返回false
                             *
                             */
                if(data.result){
                    alert("添加成功！");
                    methods.addHandle();
                }else{
                    alert("添加失败，系统繁忙，请稍后再试！");
                }
            }
        });
    });

    $('#show_tbody').on('click','.edit', function () {
        trIndex = $('.edit', '#show_tbody').index($(this));
        addEnter = false;
        $(this).parents('tr').addClass('has_case');
        methods.editHandle(trIndex);
    });

    // 修改信息的时候，无法修改ID和产品名称
    $(".edit").click(function () {
       $("#productId").attr("disabled","disabled");
       $("#productName").attr("disabled","disabled");
    });

    // 添加的时候，可以修改ID和产品名称
    // $("#new_add").click(function () {
    //     $('#productId').attr("disabled",false);
    //     $('#productName').attr("disabled",false);
    // });

    $('#search_btn').click(function () {
        methods.seachName();
        methods.seachId();
    });

    $('#back_btn').click(function () {
        $('#Ktext').val(' ');
        methods.resectList();
    });

    $('#renyuan').on('hide.bs.modal',function() {
        addEnter = true;
        $('#show_tbody tr').removeClass('has_case');
        $('#xztb input').val(' ');
        $('#xztb select').find('option:first').prop('selected', true)
    });




});

var addEnter = true,
    noRepeat = true,
    productIdArr = [],
    productNameArr = [],
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
        tdStr+= '<td>' + tarInp.eq(0).val() + '</td>';
        tdStr+= '<td colspan="2">' + tarInp.eq(1).val() + '</td>';
        tdStr+= '<td colspan="1">' + tarInp.eq(2).val() + '</td>';
        tdStr+= '<td><a href="#" class="edit">编辑</a></td>';

    },
    // 查找ID或者名字
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
    },
    checkMustMes: function () {

        if ($('#productId').val().trim()==='') {
            bootbox.alert({
                title: "来自Mask Appointment的提示",
                message: "产品ID为必选项，请填写",
                closeButton:false
            })
            hasNullMes = true;
            return
        }
        if ($('#productName').val().trim()==='') {
            bootbox.alert({
                title: "来自Mask Appointment的提示",
                message: "产品名称为必选项，请填写",
                closeButton:false
            })
            hasNullMes = true;
            return
        }
        if ($('#productStock').val().trim()==='') {
            bootbox.alert({
                title: "来自Mask Appointment的提示",
                message: "产品库存为必选项，请填写",
                closeButton:false
            })
            hasNullMes = true;
            return
        }

    },
    // 测试是否存在对应的ID和名称
    checkRepeat: function () {

        productIdArr = [], productNameArr = [];

        for (var i = 0; i<$('#show_tbody tr:not(".has_case")').length;i++) {
            var par = '#show_tbody tr:not(".has_case"):eq(' + i + ')';
            var a = $('td:eq(0)', par).html().trim(),
                b = $('td:eq(1)', par).html().trim();
            productIdArr.push(a);
            productNameArr.push(b);
        }
        var productId = $('#productId').val().trim(),
            productName = $('#productName').val().trim();
        noRepeat = true;
    }
}