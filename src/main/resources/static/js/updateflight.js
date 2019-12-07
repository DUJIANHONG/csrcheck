$(function () {
    loadType();
})

laydate.render({
    elem: '#term_of_validity', //指定元素
    eventElem: '.yx'
    ,trigger: 'click'
});
laydate.render({
    elem: '#publication', //指定元素
    eventElem: '.gb'
    ,trigger: 'click'
});
$().ready(function() {
    validateRule();
    $.ajax({
        type:"POST",
        url:"/flight_check/findflight/"+window.location.search.split("id=")[1],
        dataType: "JSON",
        success:function (data) {
            loadType();
            $("#check_no").val(data.data.check_no);
            $("#punish").val(data.data.punish);
            $("#attention").val(data.data.attention);
            $("#publication").val(data.data.publication);
            $("#term_of_validity").val(data.data.term_of_validity);
            $("#content").val(data.data.content);
            $("#id").val(data.data.id);

            $("#product_id").find("option[value=" + data.data.product_id + "]").attr("selected", true).trigger("chosen:updated");
        }
    })
});

$("#update").click(function () {
    if($("#product_id").val()==null||$("#product_id").val()==''){
        layer.msg("请选择产品",{icon:5,anim:6});
    }else {
        if ($("#signupForm").valid()) {
            $.ajax({
                cache: true,
                type: "POST",
                url: "/flight_check/updateflight",
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
        url : '/flight_check/listproduct',
        type:'POST',
        success : function(data) {
            //加载数据
            var list=data.data;
            for (var i = 0; i < list.length; i++) {
                html += '<option value="' + list[i].product_id + '" >' + list[i].product_name + '</option>'
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


