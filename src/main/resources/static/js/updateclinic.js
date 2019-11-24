$().ready(function() {
    loadType();
    validateRule();
    $.ajax({
        type:"POST",
        url:"/clinic/findClinicByid/"+window.location.search.split("id=")[1],
        dataType: "JSON",
        success:function (data) {
            loadType();
            console.log(data.data.record_number);
            console.log(data.data.adaptation_disease);
            console.log(data.data.record_date);
            $("#record_number").val(data.data.record_number);
            $("#adaptation_disease").val(data.data.adaptation_disease);
            $("#record_date").val(data.data.record_date);
            $("#id").val(data.data.id);
            $("#product_id").find("option[value=" + data.data.product_id + "]").attr("selected", true).trigger("chosen:updated");

        }
    })
});

$("#update").click(function () {
    if($("#product_id").val()==null||$("#product_id").val()==""){
        layer.msg("请输入药品名称",{icon:6});
    }else {
        if ($("#signupForm").valid()) {
            $.ajax({
                cache: true,
                type: "POST",
                url: "/clinic/updateclinic",
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
        url : '/clinic/listproduct',
        type:'POST',
        success : function(data) {
            //加载数据
            var list=data.data;
            for (var i = 0; i < list.length; i++) {
                html += '<option value="' + list[i].product_id + '">' + list[i].product_name + '</option>'
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




