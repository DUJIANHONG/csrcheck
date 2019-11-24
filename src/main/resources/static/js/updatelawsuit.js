$(function () {
    loadType();
})
laydate.render({
    elem: '#submittime', //指定元素
    eventElem: '.fa-calendar'
    ,trigger: 'click'
});
$().ready(function() {
    validateRule();
    $.ajax({
        type:"POST",
        url:"/lawsuit/findlawsuit/"+window.location.search.split("id=")[1],
        dataType: "JSON",
        success:function (data) {
            loadType();
            $("#plaintiffs").val(data.data.plaintiffs);
            $("#court").val(data.data.court);
            $("#casereason").val(data.data.casereason);
            $("#url").val(data.data.url);
            $("#caseno").val(data.data.caseno);
            $("#title").val(data.data.title);
            $("#abstracts").val(data.data.abstracts);
            $("#submittime").val(data.data.submittime);
            $("#lawsuitUrl").val(data.data.lawsuitUrl);
            $("#casetype").val(data.data.casetype);
            $("#doctype").val(data.data.doctype);
            $("#agent").val(data.data.agent);
            $("#thirdParties").val(data.data.thirdParties);
            $("#agent").val(data.data.agent);
            $("#defendants").val(data.data.defendants);
            $("#id").val(data.data.id);

            $("#company_id").find("option[value=" + data.data.company_id + "]").attr("selected", true).trigger("chosen:updated");
        }
    })
});

$("#update").click(function () {
    if($("#company_id").val()==null||$("#company_id").val()==''){
        layer.msg("请选择企业",{icon:5,anim:6});
    }else {
        if ($("#signupForm").valid()) {
            $.ajax({
                cache: true,
                type: "POST",
                url: "/lawsuit/updatelawsuit",
                data: $('#signupForm').serialize(),// 你的formid
                async: false,
                dataType: 'json',
                success: function (data) {
                    if (data.state == 2000) {
                        parent.layer.msg("操作成功",{icon:6});
                    } else {
                        parent.layer.alert(data.message)
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
        url : '/lawsuit/showcompany',
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
        }
    });
}


