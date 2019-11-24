$().ready(function() {
    //loadType();
    validateRule();
    $.ajax({
        type:"POST",
        url:"/company/findCompanyByid/"+window.location.search.split("id=")[1],
        dataType: "JSON",
        success:function (data) {
            console.log(data.data.introduction_controller_id);
            console.log(data.data.company_name);
            console.log(data.data.company_address);
            console.log(data.data.type_ownership);
            console.log(data.data.main_business);
            console.log(data.data.strategic_focus);
            console.log(data.data.listed_unlisted);
            console.log(data.data.ten_shareholders);
            console.log(data.data.production);
            console.log(data.data.organization);
            console.log(data.data.company_ranking);
            $("#company_name").val(data.data.company_name);
            $("#company_address").val(data.data.company_address);
            $("#type_ownership").val(data.data.type_ownership);
            $("#main_business").val(data.data.main_business);
            $("#strategic_focus").val(data.data.strategic_focus);
           /* $("#listed_unlisted").val(data.data.listed_unlisted);*/
            $("#ten_shareholders").val(data.data.ten_shareholders);
            $("#production").val(data.data.production);
            $("#organization").val(data.data.organization);
            $("#company_ranking").val(data.data.company_ranking);
            $("#id").val(data.data.id);
            //单选框的赋值方法
            $("input[name='listed_unlisted'][value='"+data.data.listed_unlisted+"']").attr("checked",true);
            // loadType2();
            loadType();
        }
    })
});

$("#update").click(function () {
    if($("#introduction_controller_id").val()==null||$("#introduction_controller_id").val()==""){
        layer.msg("请输入公司控制人",{icon:6});
    }else {
        if ($("#signupForm").valid()) {
            $.ajax({
                cache: true,
                type: "POST",
                url: "/company/updatecompany",
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
        url : '/company/listactual',
        type:'POST',
        success : function(data) {
            //加载数据
            var list=data.data;
            for (var i = 0; i < list.length; i++) {
                html += '<option value="' + list[i].id + '">' + list[i].con_name + '</option>'
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




