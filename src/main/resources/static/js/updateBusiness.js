$().ready(function() {
    loadType();
    loadType2();
    loadType3();
    validateRule();

    $.ajax({
        type: "POST",
        url: "/business_risks/getbussinessbyid/" + window.location.search.split("id=")[1],
        dataType: "JSON",
        success: function (data) {
            loadType();
            loadType2();
            loadType3();
            console.log(data.data.risk_type);
            console.log(data.data.type_id);
            console.log(data.data.company_id);
            console.log(data.data.describe);
            console.log(data.data.title);
            $("#title").val(data.data.title);
            $("#describe").val(data.data.describe);
            $("#id").val(data.data.id);
            $("#company_id").find("option[value=" + data.data.company_id + "]").attr("selected", true).trigger("chosen:updated");
            $("#risk_type").find("option[value=" + data.data.risk_type + "]").attr("selected", true).trigger("chosen:updated");
            $("#type_id").find("option[value=" + data.data.type_id + "]").attr("selected", true).trigger("chosen:updated");
            }
    });
});

//更新
$("#update").click(function () {
    if($("#risk_type").val()==null||$("#risk_type").val()==''){
        layer.msg("请选择风险分类",{icon:5,anim:6});
    }else if($("#type_id").val()==null||$("#type_id").val()==''){
        layer.msg("请选择风险类型",{icon:5,anim:6});
    }else if($("#company_id").val()==null||$("#company_id").val()=='') {
        layer.msg("请选择所属企业", {icon: 5,anim:6});
    } else{
        if ($("#signupForm").valid()) {
            $.ajax({
                cache: true,
                type: "POST",
                url: "/business_risks/updatebussiness",
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
        url : '/business_risks/getcompany',
        type:'POST',
        success : function(data) {
            //加载数据
            var list=data.data;
            for (var i = 0; i < list.length; i++) {
                html += '<option value="' + list[i].id + '" selected="">' + list[i].company_name + '</option>'
            }
            $(".chosen-select").append(html);
            $(".chosen-select").chosen({
                maxHeight : 200
            });
        }
    });
}
//风险分类
function loadType2(){
    var html = "";
    $.ajax({
        url : '/business_risks/getriskclassify',
        type:'POST',
        success : function(data) {
            //加载数据
            var list=data.data;
            for (var i = 0; i < list.length; i++) {
                html += '<option value="' + list[i].id + '" selected="">' + list[i].risk_classify_name + '</option>'
            }
            $(".chosen-select2").append(html);
            $(".chosen-select2").chosen({
                maxHeight : 200
            });
        }
    });
}
//风险类型
function loadType3(){
    var html = "";
    $.ajax({
        url : '/business_risks/getsriktype',
        type:'POST',
        success : function(data) {
            //加载数据
            var list=data.data;
            for (var i = 0; i < list.length; i++) {
                html += '<option value="' + list[i].id + '" selected="">' + list[i].risk_type_name + '</option>'
            }
            $(".chosen-select3").append(html);
            $(".chosen-select3").chosen({
                maxHeight : 200
            });
            //点击事件
            $('.chosen-select3').on('change', function(e, params) {
                console.log(params.selected);
            });
        }
    });
}



