$().ready(function() {
    validateRule();
    loadType();
    $.ajax({
        type:"POST",
        url:"/stock_alteration/findStock_alterationByid/"+window.location.search.split("id=")[1],
        dataType: "JSON",
        success:function (data) {
            loadType();
            console.log(data.data.type);
            console.log(data.data.ratio_after);
            console.log(data.data.ratio_before);
            console.log(data.data.share_change);
            console.log(data.data.increase_decrease);
            console.log(data.data.change_time);
            $("#type").val(data.data.type);
            $("#ratio_after").val(data.data.ratio_after);
            $("#ratio_before").val(data.data.ratio_before);
            $("#share_change").val(data.data.share_change);
            $("#increase_decrease").val(data.data.increase_decrease);
            $("#change_time").val(data.data.change_time);
            $("#id").val(data.data.id);

           // loadType2();

            $("#investor_id").find("option[value=" + data.data.investor_id + "]").attr("selected", true).trigger("chosen:updated");
            $("input[name='type'][value='"+data.data.type+"']").attr("checked",true);$("input[name='type']")
        }
    })
});

$("#update").click(function () {
    if($("#investor_id").val()==null||$("#investor_id").val()=="") {
        layer.msg("请输入股东名称", {icon: 6});
    }
    else {
    if ($("#signupForm").valid()) {
        $.ajax({
            cache: true,
            type: "POST",
            url: "/stock_alteration/updatestock_alteration",
            data: $('#signupForm').serialize(),// 你的formid
            async: false,
            dataType: 'json',
            success: function (data) {
                if (data.state == 2000) {
                    parent.layer.msg("操作成功");
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
//加载产品
function loadType(){
    var html = "";
    $.ajax({
        url : '/stock_alteration/listshareholder',
        type:'POST',
        success : function(data) {
            //加载数据
            var list=data.data;
            for (var i = 0; i < list.length; i++) {
                html += '<option value="' + list[i].id + '">' + list[i].shareholder_name + '</option>'
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




