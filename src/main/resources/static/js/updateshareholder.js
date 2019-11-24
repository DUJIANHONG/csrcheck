$().ready(function() {
    validateRule();
    loadType();
    $.ajax({
        type:"POST",
        url:"/shareholder/findShareholderByid/"+window.location.search.split("id=")[1],
        dataType: "JSON",
        success:function (data) {
            loadType();
            console.log(data.data.shareholder_name);
            console.log(data.data.share_type);
            console.log(data.data.number_of_shares);
            console.log(data.data.proportion);
            $("#shareholder_name").val(data.data.shareholder_name);
            $("#share_type").val(data.data.share_type);
            $("#number_of_shares").val(data.data.number_of_shares);
            $("#proportion").val(data.data.proportion);
            $("#id").val(data.data.id);

            $("#company_id").find("option[value=" + data.data.company_id + "]").attr("selected", true).trigger("chosen:updated");
        }
    })
});

$("#update").click(function () {
    if($("#company_id").val()==null||$("#company_id").val()==""){
        layer.msg("请输入企业名称",{icon:6});
    }else {
    if ($("#signupForm").valid()) {
        $.ajax({
            cache: true,
            type: "POST",
            url: "/shareholder/updateshareholder",
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

function loadType(){
    var html = "";
    $.ajax({
        url : '/shareholder/listcompany',
        type:'POST',
        success : function(data) {
            //加载数据
            var list=data.data;
            for (var i = 0; i < list.length; i++) {
                html += '<option value="' + list[i].id + '">' + list[i].company_name + '</option>'
            }
            $("#company_id").append(html);
            $("#company_id").chosen({
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




