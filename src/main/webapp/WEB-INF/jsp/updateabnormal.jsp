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
    <title>修改产品信息</title>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>修改产品信息</legend>
</fieldset>
<form class="layui-form layui-form-pane" id="abnormalupdate">
    <input type="hidden" name="id" id="id" value="${abnormal.id}" />
    <div class="layui-form-item">
        <label class="layui-form-label">产品名称</label>
        <div class="layui-input-block">
            <select  name="product_id" id="product_id"  lay-verify="required">
                <option value="">请选择</option>
                <c:forEach items="${product }" var="product" varStatus="status" >
                    <option value="${product.product_id }" <c:if test="${product.product_id==abnormal.product_id}">selected="selected"</c:if>>${product.product_name}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label" >包装规格</label>
        <div class="layui-input-block">
            <input type="text" name="packing"  id="packing" value="${abnormal.packing}" autocomplete="off" lay-verify="required" placeholder="包装规格" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">生产日期</label>
        <div class="layui-input-inline">
            <input type="text" name="batch_no"  id="batch_no" value="${abnormal.batch_no}" autocomplete="off" lay-verify="required" placeholder="格式：yyyy/MM/dd" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">标称卫生许可证/批准文号</label>
        <div class="layui-input-block">
            <input type="text" name="approval_no" id="approval_no" value="${abnormal.approval_no}" autocomplete="off"  placeholder="" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">不合格项目</label>
        <div class="layui-input-block">
            <input type="text" name="disqualification" id="disqualification" value="${abnormal.disqualification}" autocomplete="off" placeholder="" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">检验结果</label>
        <div class="layui-input-inline">
            <input type="text" name="inspection_result" id="inspection_result" value="${abnormal.inspection_result}" autocomplete="off" lay-verify="required" placeholder="" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">标准规定</label>
        <div class="layui-input-inline">
            <input type="text" name="standard_code" id="standard_code" value="${abnormal.standard_code}" lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">机构验证</label>
        <div class="layui-input-inline">
            <input type="text" name="agencies_to_verify" value="${abnormal.agencies_to_verify}"  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">结论</label>
        <div class="layui-input-inline">
            <input type="text" name="last" value="${abnormal.last}"  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">出处</label>
        <div class="layui-input-inline">
            <input type="text" name="provenance" value="${abnormal.provenance}"  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
        </div>
        <label style="color: darkred">（此列存放通报excel表存放的路径）</label>
    </div>
    <div class="layui-form-item">
        <input class="layui-btn center-block" lay-submit="" lay-filter=""  id="update" value="提交"/>
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
        $("#update").click(function () {
                if ($("#abnormalupdate").valid()) {
                    $.ajax({
                        cache: true,
                        type: "POST",
                        url: "/abnormal/saveabnormal",
                        data: $('#abnormalupdate').serialize(),// 你的formid
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
