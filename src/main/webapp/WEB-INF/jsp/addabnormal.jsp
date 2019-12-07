<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>

    <title>新增产品异常</title>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">

</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>增加产品异常信息</legend>
</fieldset>
<form class="layui-form layui-form-pane" id="abnormaladd">
    <div class="layui-form-item">
        <label class="layui-form-label">产品名称</label>
        <div class="layui-input-block">
            <select  name="product_id" id="product_id"  lay-verify="required">
                <option value="">请选择</option>
                <c:forEach items="${product }" var="product" varStatus="status" >
                    <option value="${product.product_id }">${product.product_name}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label" >包装规格</label>
        <div class="layui-input-block">
            <input type="text" name="packing"  id="packing"  autocomplete="off"  placeholder="包装规格" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">生产日期</label>
        <div class="layui-input-inline">
            <input type="text" name="batch_no"  id="batch_no" autocomplete="off" lay-verify="required" placeholder="格式：yyyy/MM/dd" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">标称卫生许可证/批准文号</label>
        <div class="layui-input-block">
            <input type="text" name="approval_no" id="approval_no" lay-verify="required" autocomplete="off"  placeholder="" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">不合格项目</label>
        <div class="layui-input-block">
            <input type="text" name="disqualification" id="disqualification" lay-verify="required" autocomplete="off" placeholder="" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">检验结果</label>
        <div class="layui-input-inline">
            <input type="text" name="inspection_result" id="inspection_result" autocomplete="off" lay-verify="required" placeholder="" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">标准规定</label>
        <div class="layui-input-inline">
            <input type="text" name="standard_code" id="standard_code" lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">机构验证</label>
        <div class="layui-input-inline">
            <input type="text" name="agencies_to_verify"  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">结论</label>
        <div class="layui-input-inline">
            <input type="text" name="last"  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">出处</label>
        <div class="layui-input-inline">
            <input type="text" name="provenance"  placeholder="" autocomplete="off" class="layui-input">
        </div>
        <label style="color: darkred">（此列存放通报excel表存放的路径）</label>
    </div>
    <div class="layui-form-item">
        <input class="layui-btn center-block" lay-submit="" lay-filter="*"  id="save" value="提交"/>
    </div>
</form>


<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/layui/lay/modules/form.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/layui/lay/modules/layer.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/layui/lay/modules/jquery.js" charset="utf-8"></script>
 <script>



    $("#save").click(function () {
        if($("#abnormaladd").valid()){
            $.ajax({
                type: "POST",
                url: "/abnormal/saveaddabnormal",
                data: $('#abnormaladd').serialize(),
                async: false,
                dataType: 'json',
                success: function (data) {
                    if (data.code == 0) {
                        parent.layer.alert("添加成功");
                    } else {
                        parent.layer.alert(data.msg)
                    }
                }
            });
        }
    });



</script>

</body>
</html>