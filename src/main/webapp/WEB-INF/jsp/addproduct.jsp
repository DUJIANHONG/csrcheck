<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>

    <title>新增产品</title>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/xadmin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/layui/layui.js" charset="utf-8"></script>

</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>增加产品信息</legend>
</fieldset>
<form class="layui-form layui-form-pane" action="/product/saveproduct">

    <div class="layui-form-item">
        <label class="layui-form-label">所属公司</label>
        <div class="layui-input-block">
            <select  name="company_id" id="company_id" lay-filter="aihao" >
                <option value="null">请选择</option>
                <c:forEach items="${company }" var="company" varStatus="status" >
                    <option value="${company.id }" lay-verify="required">${company.company_name}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">产品类型</label>
        <div class="layui-input-inline">
            <select name="product_type_id" id="product_type_id" lay-filter="aihao" lay-verify="required">
                <option value="null">请选择</option>
                <c:forEach items="${typelist }" var="type" varStatus="status" >
                    <option value="${type.id }" lay-verify="required">${type.product_t_name}</option>
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
            <input type="radio" name="study_appear" value="2" title="上市">
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
            <input type="text" name="registered" autocomplete="off" placeholder="例：化1，化2，化3，化4，化5，老化6" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">阶段编号</label>
        <div class="layui-input-inline">
            <select name="stage_no" id="stage_no" lay-filter="aihao">
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
            <select name="patent_t_id" id="patent_t_id" lay-filter="aihao">
                <option value=null>请选择</option>
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
            <input type="date" name="term_of_validity" autocomplete="off" placeholder="格式：yyyy-MM-dd" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <button class="layui-btn" type="submit" lay-submit="" id="add" lay-filter="demo1">提交</button>
    </div>
</form>



<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date1'
        });


        //自定义验证规则
        form.verify({
            title: function(value){
                if(value.length < 5){
                    return '标题至少得5个字符啊';
                }
            }
            ,pass: [
                /^[\S]{6,12}$/
                ,'密码必须6到12位，且不能出现空格'
            ]
            ,content: function(value){
                layedit.sync(editIndex);
            }
            ,text:function (value) {
                if (value == null){
                    return '内容不能为空！';
                }
            }
        });



        $("#add").click(function () {
            $.ajax({
                url:"product/saveproduct",    //请求的url地址
                dataType:"json",   //返回格式为json
                async:true,//请求是否异步，默认为异步，这也是ajax重要特性
                type:"GET",   //请求方式
                success:function(result){
                    if(result = 1){
                        parent.layer.msg("添加成功！");
                    } else{
                        parent.layer.msg("添加失败！");
                    }
                },
                error:function(){
                    parent.layer.msg("出现错误！");
                }
            });

        });
    });

</script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/xadmin.js"></script>
</body>
</html>