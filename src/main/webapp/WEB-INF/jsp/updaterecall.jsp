<%--
|';lk6rej--=00000000000000000
  Created/* by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/23
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改产品召回</title>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>修改产品召回信息</legend>
</fieldset>
<form class="layui-form layui-form-pane" id="recallupdate">
    <input type="hidden" name="id" id="id" value="${recall.id}"/>

    <div class="layui-form-item">
        <label class="layui-form-label">关联产品</label>
        <div class="layui-input-inline">
            <select name="product_id" id="product_id"  lay-verify="required">
                <option value="">请选择</option>
                <c:forEach items="${product }" var="product" varStatus="status" >
                    <option value="${product.product_id }" <c:if test="${product.product_id==recall.product_id}">selected="selected"</c:if>>${product.product_name}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" >关键词备注</label>
        <div class="layui-input-block">
            <input type="text" name="keywords_remarks"  id="keywords_remarks" value="${recall.keywords_remarks}" autocomplete="off" lay-verify="required" placeholder="" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">召回内容</label>
        <div class="layui-input-block">
            <input type="text" name="recall_content" id="recall_content" value="${recall.recall_content}" autocomplete="off" lay-verify="required" placeholder="" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <input class="layui-btn center-block" lay-submit="" lay-filter=""  id="save" value="提交"/>
    </div>
</form>


<script type="text/javascript" src="${pageContext.request.contextPath }/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/layui/lay/modules/form.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/layui/lay/modules/layer.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/layui/lay/modules/jquery.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.min.js"></script>
<script>
    $(function () {
        $("#save").click(function () {
                if ($("#recallupdate").valid()) {
                    $.ajax({
                        cache: true,
                        type: "POST",
                        url: "/recall/saverecall",
                        data: $('#recallupdate').serialize(),// 你的formid
                        async: false,
                        dataType: 'json',
                        success: function (data) {
                            if (data.code == 0) {
                                parent.layer.msg("修改成功");
                            } else {
                                parent.layer.alert(data.msg)
                            }
                        }
                    });
                }
        })
    });

</script>
</body>
</html>
