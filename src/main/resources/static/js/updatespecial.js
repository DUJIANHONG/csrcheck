$().ready(function() {
    validateRule();
    loadType();
    $.ajax({
        type:"POST",
        url:"/specialb/findSpecialByid/"+window.location.search.split("id=")[1],
        dataType: "JSON",
        success:function (data) {
            loadType();
            console.log(data.data.title);
            console.log(data.data.content);
            console.log(data.data.release_time);
            $("#title").val(data.data.title);
            $("#content").val(data.data.content);
            $("#release_time").val(data.data.release_time);

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
            url: "/specialb/updatespecial",
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
        url : '/specialb/listcompany',
        type:'POST',
        success : function(data) {
            //加载数据
            var list=data.data;
            for (var i = 0; i < list.length; i++) {
                html += '<option value="' + list[i].id + '" >' + list[i].company_name + '</option>'
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




