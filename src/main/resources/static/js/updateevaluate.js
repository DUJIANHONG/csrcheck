
$().ready(function() {
    validateRule();
    loadType();
    loadType2();
    $.ajax({
        type: "POST",
        url: "/evaluate/findEvaluate/" + window.location.search.split("id=")[1],
        dataType: "JSON",
        success: function (data) {
            loadType();
            loadType2();
            $("#accept_no").val(data.data.accept_no);
            $("#english_name").val(data.data.english_name);
            $("#specification").val(data.data.specification);
            $("#agent_type").val(data.data.agent_type);
            $("#adaptation_disease").val(data.data.adaptation_disease);
            $("#id").val(data.data.id);
            $("#company_id").find("option[value=" + data.data.company_id + "]").attr("selected", true).trigger("chosen:updated");
            $("#product_id").find("option[value=" + data.data.product_id + "]").attr("selected", true).trigger("chosen:updated");
        }
    });
});

//更新
$("#update").click(function () {
    if($("#company_id").val()==null||$("#company_id").val()=='') {
        layer.msg("请选择所属企业", {icon: 5,anim:6});
    }else if($("#product_id").val()==null||$("#product_id").val()==''){
        layer.msg("请选择产品",{icon:5,anim:6});
    }else{
        if ($("#signupForm").valid()) {
            $.ajax({
                cache: true,
                type: "POST",
                url: "/evaluate/uppdateEvaluate",
                data: $('#signupForm').serialize(),// 你的formid
                async: false,
                dataType: 'json',
                success: function (data) {
                    if (data.code == 0) {
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
        url : '/evaluate/showcompany',
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
function loadType2(){
    var html = "";
    $.ajax({
        url : '/evaluate/listproduct',
        type:'POST',
        success : function(data) {
            //加载数据
            var list=data.data;
            for (var i = 0; i < list.length; i++) {
                html += '<option value="' + list[i].product_id + '" >' + list[i].product_name + '</option>'
            }
            $(".chosen-select2").append(html);
            $(".chosen-select2").chosen({
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

