$().ready(function() {
	loadType();
	//loadType2();
	validateRule();
});

$("#save").click(function () {
	 if($("#investor_id").val()==null||$("#investor_id").val()=="") {
		 layer.msg("请输入股东名称", {icon: 6});
	 }
	 else {
		if ($("#signupForm").valid()) {
			$.ajax({
				cache: true,
				type: "POST",
				url: "/stock_alteration/addstock_alteration",
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
		url : '/stock_alteration/listshareholder',
		type:'POST',
		success : function(data) {
			//加载数据
			var list=data.data;
			for (var i = 0; i < list.length; i++) {
				html += '<option value="' + list[i].id + '">' + list[i].shareholder_name + '</option>'
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



