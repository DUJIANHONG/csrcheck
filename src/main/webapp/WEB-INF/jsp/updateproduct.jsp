-+<%--
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
    <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>修改产品信息</legend>
</fieldset>
<form class="layui-form layui-form-pane" id="productupdate">
    <input type="hidden" id="product_id"/>
    <div class="layui-form-item">
        <label class="layui-form-label">所属公司</label>

        <div class="layui-input-block">
            <select  name="company_id" id="company_id"  lay-verify="required">
                <option value="">请选择</option>
                <c:forEach items="${company }" var="company" varStatus="status" >
                    <option value="${company.id }">${company.company_name}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">产品类型</label>
        <div class="layui-input-inline">
            <select name="product_type_id" id="product_type_id"  lay-verify="required">
                <option value="">请选择</option>
                <c:forEach items="${typelist }" var="type" varStatus="status" >
                    <option value="${type.id }" lay-verify="required" onclick="product_type">${type.product_t_name}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" >产品名称</label>
        <div class="layui-input-block">
            <input type="text" name="product_name"  id="product_name" autocomplete="off" lay-verify="required" placeholder="请输产品名称" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">产品领域</label>
        <div class="layui-input-inline">
            <input type="text" name="product_territory" id="product_territory" autocomplete="off" lay-verify="required" placeholder="例：药品；化妆品；医疗器械" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item" pane="">
        <label class="layui-form-label">在研/上市</label>
        <div class="layui-input-inline">
            <input type="radio" name="study_appear" value="1" title="在研" checked="">
            <input type="radio" name="study_appear" id="shangshi" value="2" title="上市">
        </div>
    </div>
    <div class="layui-form-item" pane="">
        <label class="layui-form-label">合法/不合法</label>
        <div class="layui-input-block">
            <input type="radio" name="iflegal" value="1" title="合法" checked="">
            <input type="radio" name="iflegal" value="2" title="不合法">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">注册分类</label>
        <div class="layui-input-block">
            <input type="text" name="registered" id="registered" autocomplete="off" placeholder="例：化1，化2，化3，化4，化5，老化6" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">阶段编号</label>
        <div class="layui-input-inline">
            <select name="stage_no" id="stage_no" >
                <option value="null">请选择</option>
                <c:forEach items="${stages }" var="stages" varStatus="status" >
                    <option value="${stages.id }" >${stages.stage_name}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">专利号</label>
        <div class="layui-input-block">
            <input type="text" name="patent_no" id="patent_no" autocomplete="off" placeholder="" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">专利类型</label>
        <div class="layui-input-inline">
            <select name="patent_t_id" id="patent_t_id" disabled="disabled">
                <option value="null">请选择</option>
                <c:forEach items="${patent }" var="patent" varStatus="status" >
                    <option value="${patent.id }">${patent.patent_t_name}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">准字号</label>
        <div class="layui-input-inline">
            <input type="text" name="approvals_no" id="approvals_no" autocomplete="off" lay-verify="required" placeholder="" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item" pane="">
        <label class="layui-form-label">国产/进口</label>
        <div class="layui-input-inline">
            <input type="radio" name="domestic_import" value="1" title="国产" checked="">
            <input type="radio" name="domestic_import" value="2" title="进口">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">产品生产地</label>
        <div class="layui-input-inline">
            <input type="text" name="yieldly" id="yieldly" lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">有效日期</label>
        <div class="layui-input-inline">
            <input type="text" name="term_of_validity"  id="date1" autocomplete="off" lay-verify="required" placeholder="格式：yyyy/MM/dd" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <input class="layui-btn center-block" lay-submit="" lay-filter="*"  id="save" value="提交"/>
    </div>
</form>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/layui.js"></script>
<script>
    $(function () {
        $.ajax({
            type: "POST",
            url: "/product/updateproduct/" + window.location.search.split("id=")[1],
            dataType: "JSON",
            success: function (params) {
                console.log(params.data.product_id);
                $("#product_name").val(params.data.product_name);
                $("#id").val(params.data.id);

            }
        });
    });
</script>
</body>
</html>
