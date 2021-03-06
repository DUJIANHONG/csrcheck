/*this is basic form validation using for validation person's basic information author:Clara Guo data:2017/07/20*/
$(document).ready(function(){
	$.validator.setDefaults({       
		  submitHandler: function(form) {    
		 		form.submit();    
		}       
	});  
	/*//手机号码验证身份证正则合并：(^\d{15}$)|(^\d{17}([0-9]|X)$)
	jQuery.validator.addMethod("isPhone",function(value,element){
		var length = value.length;
		var phone=/^1[3|4|5|7|8][0-9]\d{8}$/;
		return this.optional(element)||(length == 11 && phone.test(value));
	},"请填写正确的11位手机号");*/
	//电话号码验证
	/*jQuery.validator.addMethod("isTel",function(value,element){
		var tel = /^(0\d{2,3}-)?\d{7,8}$/g;//区号3,4位,号码7,8位
		return this.optional(element) || (tel.test(value));
	},"请填写正确的座机号码");*/
	//用户名校验
	jQuery.validator.addMethod("isName",function(value,element){
		var user_name=/^[a-zA-Z0-9]{2,13}$/;
		return this.optional(element) || (user_name.test(value));
	},"请输入数字或者字母,不包含特殊字符");
	//校验年龄
	jQuery.validator.addMethod("isUser_age",function(value,element){
		var user_age=/^(?:[1-9][0-9]?|1[01][0-9]|120)$/;;
		return this.optional(element) || (user_age).test(value);
	},'请输入数字');
	//居住地址校验
	jQuery.validator.addMethod("isUser_address",function(value,element){
		var user_address=/^[\u4e00-\u9fa5]+$/;
		return this.optional(element) || (user_address.test(value));
	},"请输入中文汉字,不包含特殊字符");


	/*//校验身份证
	jQuery.validator.addMethod("isIdentity",function(value,element){
		var id= /^(\d{15}$|^\d{18}$|^\d{17}(\d|X))$/;
		return this.optional(element) || (id.test(value));
	},"请输入正确的15或18位身份证号,末尾为大写X");
	//校验出生日期
	jQuery.validator.addMethod("isBirth",function(value,element){
		var birth = /^(19|20)\d{2}-(1[0-2]|0?[1-9])-(0?[1-9]|[1-2][0-9]|3[0-1])$/;
		return this.optional(element) || (birth).test(value);
	},"出生日期格式示例2000-01-01");*/


	//校验新旧密码是否相同
	jQuery.validator.addMethod("isdiff",function(){
		var p1=$("#pwdOld").val();
		var p2=$("#pwdNew").val();
		if(p1==p2){
			return false;
		}else{
			 return true;
		}
		});
	//校验新密码和确认密码是否相同
	jQuery.validator.addMethod("issame",function(){
		var p3=$("#confirm_password").val();
		var p4=$("#pwdNew").val();
		if(p3==p4){
			return true;
		}else{
			 return false;
		}
		});
	//校验基础信息表单
	$("#basicInfoForm").validate({
		errorElement:'span',
		errorClass:'help-block error-mes',
		rules:{
			user_name:{
				required:true,
				isName:true
			},
			user_age:{
				required:true,
				isUser_age:true
			},
			user_address:{
				required:true,
				isUser_address:true
			},
		},
		messages:{
			user_name:{
				required:"请输入用户名",
				isName:"姓名只能数字或字母"
			},
			user_age:{
				required:"请输入年龄",
				isUser_age:"年龄只能输入数字"
			},
			user_address:{
				required:"请输入居住地址",
				isUser_address:"居住地址只能输入汉字"
			}
		},
	
		errorPlacement:function(error,element){
			element.next().remove();
			element.closest('.gg-formGroup').append(error);
		},
		
		highlight:function(element){
			$(element).closest('.gg-formGroup').addClass('has-error has-feedback');
		},
		success:function(label){
			var el = label.closest('.gg-formGroup').find("input");
			el.next().remove();
			label.closest('.gg-formGroup').removeClass('has-error').addClass("has-feedback has-success");
			label.remove();
		},
		submitHandler:function(form){
			alert("保存成功!");
		}
	});
	
	//校验修改密码表单
	$("#modifyPwd").validate({
		onfocusout: function(element) { $(element).valid()},
		 debug:false, //表示校验通过后是否直接提交表单
		 onkeyup:false, //表示按键松开时候监听验证
		rules:{
			oldPassword:{
				required:true,
				minlength:6
			},
			newPassword:{
			   required:true,
			   minlength:6,
			   isdiff:true,
			   //issame:true,
		   },
			confirm_password:{
			  required:true,
			  minlength:6,
			  issame:true,
			}
		  
		   },
		messages:{
			oldPassword : {
					 required:'必填',
					 minlength:$.validator.format('密码长度要大于6')
				},
			newPassword:{
				   required:'必填',
				   minlength:$.validator.format('密码长度要大于6'),
				   isdiff:'原密码与新密码不能重复',
				  
			   },
				confirm_password:{
				   required:'必填',
				   minlength:$.validator.format('密码长度要大于6'),
				   issame:'新密码要与确认新密码一致',
				}
		
		},
		errorElement:"mes",
		errorClass:"gg-star",
		errorPlacement: function(error, element) 
		{ 
			element.closest('.gg-formGroup').append(error);

		}
	});
//校验上传图片
	$("#imgform").validate({
		onfocusout: function(element) { $(element).valid()},
		debug:false, //表示校验通过后是否直接提交表单
		onkeyup:false, //表示按键松开时候监听验证
		rules:{
			file:{
				required:true,
			}
		},
		messages:{
			file : {
				required:'请选择图片',

			}
		},
		errorElement:"mes",
		errorClass:"gg-star",
		errorPlacement: function(error, element)
		{
			element.closest('.avatar-input').append(error);

		}
	})
});
//校验添加管理员信息表单
$("#userinfo").validate({
	errorElement:'span',
	errorClass:'help-block error-mes',
	rules:{
		user_name:{
			required:true,
			isName:true
		},
		password:{
			required:true,
			minlength:6
		},
		user_sex:{
			required:true
		},
		user_age:{
			required:true,
			isUser_age:true
		},
		user_address:{
			required:true,
			isUser_address:true
		},
	},
	messages:{
		user_name:{
			required:"请输入用户名",
			isName:"姓名只能数字或字母"
		},
		password:{
			required:"请输入密码",
			minlength:$.validator.format('密码长度要大于6')
		},
		user_sex:{
			required:"请选择性别"
		},
		user_age:{
			required:"请输入年龄",
			isUser_age:"年龄只能输入数字"
		},
		user_address:{
			required:"请输入居住地址",
			isUser_address:"居住地址只能输入汉字"
		}
	},

	errorPlacement:function(error,element){
		element.next().remove();
		element.closest('.gg-formGroup').append(error);
	},

	highlight:function(element){
		$(element).closest('.gg-formGroup').addClass('has-error has-feedback');
	},
	success:function(label){
		var el = label.closest('.gg-formGroup').find("input");
		el.next().remove();
		label.closest('.gg-formGroup').removeClass('has-error').addClass("has-feedback has-success");
		label.remove();
	},
	submitHandler:function(form){
		alert("保存成功!");
	}
});