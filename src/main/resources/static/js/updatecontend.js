laydate.render({
    elem: '#time', //指定元素
    eventElem: '.fa-calendar'
    ,trigger: 'click'
});
$().ready(function() {
    validateRule();
    loadType();
    $.ajax({
        type: "POST",
        url: "/contend/findcontendByid/" + window.location.search.split("id=")[1],
        dataType: "JSON",
        success: function (data) {
            loadType();
            console.log(data.data.company_id);
            console.log(data.data.content);
            console.log(data.data.time);
            console.log(data.data.title);
            $("#title").val(data.data.title);
            $("#id").val(data.data.id);
            $("#content").val(data.data.content);
            $("#time").val(data.data.time);
            $("#company_id").find("option[value=" + data.data.company_id + "]").attr("selected", true).trigger("chosen:updated");
        }
    });
});

//更新
$("#update").click(function () {
    if($("#company_id").val()==null||$("#company_id").val()=='') {
        layer.msg("请选择所属企业", {icon: 5,anim:6});
    } else{
        if ($("#signupForm").valid()) {
            $.ajax({
                cache: true,
                type: "POST",
                url: "/contend/updatecontend",
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
        url : '/contend/showcompany',
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


