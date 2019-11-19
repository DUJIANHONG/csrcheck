
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
                        parent.layer.msg("更新成功",{icon:6});
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
                    parent.layer.alert("更新密码成功,请重新登录",function(){window.location.href="/web/login.html";});
                } else {
                    parent.layer.alert(json.message)
                }
            }
        });
    }
});

//修改头像

$("#update").click(function () {
    if($("#imgform").valid()){
        var formData = new FormData($("#imgform")[0]);
        $.ajax({
            cache : true,
            type : "POST",
            url :"/users/change_Img",
            data :formData,
            async : false,
            //ajax2.0可以不用设置请求头，但是jq帮我们自动设置了，这样的话需要我们自己取消掉
            contentType:false,
            //取消帮我们格式化数据，是什么就是什么
            processData:false,
            success : function(json) {
                if (json.state==2000) {
                    parent.layer.alert("更新头像成功")
                } else {
                    parent.layer.msg(json.message)
                }
            }
        });
    }
})
//增加管理员
$("#save").click(function () {
    if($("#userinfo").valid()){
        $.ajax({
            cache : true,
            type : "POST",
            url :"/users/adduser",
            data :$("#userinfo").serialize(),
            async : false,
            success : function(json) {
                if (json.state==2000) {
                    parent.layer.alert("增加成功")
                } else {
                    parent.layer.msg(json.message)
                }
            }
        });
    }
})
//预览上传头像
$(function () {
    $("input:file").change(function(){
        var reader = new FileReader();		//获取一个FileReader类
        var file = this.files[0];			//获取用户选择的文件
        reader.readAsDataURL(file);			//开始读取指定Blob（二进制文件）中的内容。一旦完成，立即触发 loadend 事件，并且该对象的 result 属性中将包含一个 data: URL 格式的字符串以表示所读取文件的内容。
        reader.onloadend = function(){
            $("img").attr("src", reader.result);
        }
    })
})

