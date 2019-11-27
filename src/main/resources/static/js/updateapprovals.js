$(function () {
    loadType();
})
$(document).ready(function () {
    loadType2();
})
$().ready(function() {
    validateRule();
    $.ajax({
        type:"POST",
        url:"/approvals/findApprovalsByid/"+window.location.search.split("id=")[1],
        dataType: "JSON",
        success:function (data) {
            console.log(data.data.approval_no);
            console.log(data.data.approval_num);
            $("#approval_no").val(data.data.approval_no);
            $("#approval_num").val(data.data.approval_num);
            $("#id").val(data.data.id);
            var product=data.data.product_id;
            var approved=data.data.approved_by;
            loadType2();
            loadType();
            $("#product_id").find("option[value=" + product + "]").attr("selected", true).trigger("chosen:updated");
            $("#approved_by").find("option[value=" + approved + "]").attr("selected", true).trigger("chosen:updated");
            /*$("#product_id option[value='"+product+"']").attr("selected",true);
            $("#approved_by option[value='"+approved+"']").attr("selected",true);*/
        }
    })
});

$("#update").click(function () {
    if($("#product_id").val()==null||$("#product_id").val()==""){
        layer.msg("请选择产品",{icon:5,anim:6});
    }else if($("#approved_by").val()==null||$("#approved_by").val()==""){
        layer.msg("请选择所属准字",{icon:5,anim:6});
    }else {
        if ($("#signupForm").valid()) {
            $.ajax({
                cache: true,
                type: "POST",
                url: "/approvals/updateapprovals",
                data: $('#signupForm').serialize(),// 你的formid
                async: false,
                dataType: 'json',
                success: function (data) {
                    if (data.code == 0) {
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
        url : '/approvals/listproduct',
        type:'POST',
        success : function(data) {
            //加载数据
            var list=data.data;
            for (var i = 0; i < list.length; i++) {
                html += '<option value="' + list[i].product_id + '" >' + list[i].product_name + '</option>'
            }
            $("#product_id").append(html);
            $("#product_id").chosen({
                maxHeight : 200
            });
        }
    });
}
//加载所属准字
function loadType2(){
    var html = "";
    $.ajax({
        url : '/approvals/listapproved_by',
        type:'POST',
        success : function(data) {
            //加载数据
            var list=data.data;
            for (var i = 0; i < list.length; i++) {
                html += '<option value="' + list[i].id + '" >' + list[i].approved_t_name + '</option>'
            }
            $("#approved_by").append(html);
            $("#approved_by").chosen({
                maxHeight : 200
            });
        }
    });
}


