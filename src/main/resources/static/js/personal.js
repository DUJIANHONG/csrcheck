
/**
 * 基本信息提交
 */
$("#base_save").click(function () {
    if($("#basicInfoForm").valid()){
            $.ajax({
                cache : true,
                type : "POST",
                url :"/users/change_user",
                data : $('#basicInfoForm').serialize(),
                async : false,
                success : function(data) {
                    if (data.state == 2000) {
                        parent.layer.msg("更新成功");
                    } else {
                        parent.layer.alert(data.message)
                    }
                }
            });
        }

});
/**
 * 修改密码
 */
$("#pwd_save").click(function () {
    if($("#modifyPwd").valid()){
        $.ajax({
            cache : true,
            type : "POST",
            url :"/users/change_password",
            data : $('#modifyPwd').serialize(),
            async : false,
            success : function(json) {
                if (json.state==2000) {
                    parent.layer.alert("更新密码成功",function(){window.location.href="/web/login.html";});
                } else {
                    parent.layer.alert(json.message)
                }
            }
        });
    }
});
