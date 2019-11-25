$().ready(function() {
	loadType();
	//loadType2();
	validateRule();
});

$("#save").click(function () {
	 if($("#introduction_controller_id").val()==null||$("#introduction_controller_id").val()==""){
		layer.msg("请输入公司控制人",{icon:6});
	}else {
		if ($("#signupForm").valid()) {
			$.ajax({
				cache: true,
				type: "POST",
				url: "/company/addcompany",
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



