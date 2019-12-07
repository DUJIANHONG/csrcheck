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
    <title>修改产品重要通报信息</title>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>修改产品重要通报信息</legend>
</fieldset>
<form class="layui-form layui-form-pane" id="importantupdate">
    <input type="hidden" name="id" id="id" value="${important.id}" />
    <div class="layui-form-item">
        <label class="layui-form-label">产品名称</label>
        <div class="layui-input-block">
            <select  name="product_id" id="product_id"  lay-verify="required">
                <option value="">请选择</option>
                <c:forEach items="${product }" var="product" varStatus="status" >
                    <option value="${product.product_id }" <c:if test="${product.product_id==important.product_id}">selected="selected"</c:if>>${product.product_name}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label" >标题</label>
        <div class="layui-input-inline">
            <input type="text" name="title"  id="title" value="${important.title}"  autocomplete="off"  placeholder="标题" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">通报内容</label>
        <div class="layui-input-inline">
            <input type="text" name="content"  id="content" value="${important.content}" autocomplete="off" lay-verify="required" placeholder="" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">发布日期</label>
        <div class="layui-input-block">
            <input type="text" name="release_time" id="release_time" value="${important.release_time}" lay-verify="required" autocomplete="off"  placeholder="" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <input class="layui-btn center-block" lay-submit="" id="update" value="提交"/>
    </div>
</form>


<script type="text/javascript" src="${pageContext.request.contextPath }/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/layui/lay/modules/form.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/layui/lay/modules/layer.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/layui/lay/modules/jquery.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.min.js"></script>
<script>
    layui.use(['laydate'], function() {
        var laydate = layui.laydate;

        laydate.render({
            elem: '#release_time' //指定元素
        });
    });

    $(function () {
        $("#update").click(function () {
                if ($("#importantupdate").valid()) {
                    $.ajax({
                        cache: true,
                        type: "POST",
                        url: "/important_notific/saveimportant",
                        data: $('#importantupdate').serialize(),// 你的formid
                        async: false,
                        dataType: 'json',
                        success: function (data) {
                            if (data.code == 0) {
                                parent.layer.msg("修改成功");
                            } else {
                                parent.layer.msg(data.msg);
                            }
                        },error:function () {
                            parent.layer.msg("错误");
                        }
                    });
                }else {
                    parent.layer.msg("出现不可预期的问题！");
                }
        });
    });
</script>
</body>
</html>
