<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>

    <title>新增产品召回</title>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">

</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>增加产品召回信息</legend>
</fieldset>
<form class="layui-form layui-form-pane" id="recalladd">

    <div class="layui-form-item">
        <label class="layui-form-label">关联产品</label>
        <div class="layui-input-inline">
            <select name="product_id" id="product_id"  lay-verify="required">
                <option value="">请选择</option>
                <c:forEach items="${product }" var="product" varStatus="status" >
                    <option value="${product.product_id }" >${product.product_name}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" >关键词备注</label>
        <div class="layui-input-block">
            <input type="text" name="keywords_remarks"  id="keywords_remarks" autocomplete="off" lay-verify="required" placeholder="" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">召回内容</label>
        <div class="layui-input-inline">
            <input type="text" name="recall_content" id="recall_content" autocomplete="off" lay-verify="required" placeholder="" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <input class="layui-btn center-block" lay-submit="" lay-filter=""  id="save" value="提交"/>
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
                if($("#recalladd").valid()){
                    $.ajax({
                        type: "POST",
                        url: "/recall/saveaddrecall",
                        data: $('#recalladd').serialize(),
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