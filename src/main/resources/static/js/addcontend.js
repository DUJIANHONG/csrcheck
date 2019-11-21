laydate.render({
    elem: '#time' //指定元素
});
$().ready(function() {
    loadType();
    validateRule();
});
//添加
$("#save").click(function () {
     if($("#company_id").val()==null||$("#company_id").val()=='') {
        layer.msg("请选择所属企业", {icon: 5,anim:6});
    }else {
        if ($("#signupForm").valid()) {
            $.ajax({
                cache: true,
                type: "POST",
                url: "/business_risks/addbussiness",
                data: $('#signupForm').serialize(),// 你的formid
                async: false,
                dataType: 'json',
                success: function (data) {
                    if (data.state == 2000) {
                        parent.layer.msg("操作成功", {icon: 1});
                    } else {
                        parent.layer.alert(data.msg)
                    }

                }
            });
        }
    }
})
function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules : {
            name : {
                required : true
            }
        },
        messages : {
            name : {
                required : icon + ""
            }
        }
    })
}
//企业信息
function loadType(){
    var html = "";
    $.ajax({
        url : '/contend/showcompany',
        type:'POST',
        success : function(data) {
            //加载数据
            var list=data.data;
            for (var i = 0; i < list.length; i++) {
                html += '<option value="' + list[i].id + '">' + list[i].company_name + '</option>'
            }
            $(".chosen-select").append(html);
            $(".chosen-select").chosen({
                maxHeight : 200
            });
            //点击事件
            $('.chosen-select').on('change', function(e, params) {
                console.log(params.selected);
                var opt = {
                    query : {
                        type : params.selected,
                    }
                }
                $('#exampleTable').bootstrapTable('refresh', opt);
            });
        }
    });
}



