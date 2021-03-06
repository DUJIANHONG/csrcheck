<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>CSR</title>
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${pageContext.request.contextPath }/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="${pageContext.request.contextPath }/css/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="${pageContext.request.contextPath }/css/green.css" rel="stylesheet">
    <!-- bootstrap-progressbar -->
    <link href="${pageContext.request.contextPath }/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- JQVMap -->
    <link href="${pageContext.request.contextPath }/css/jqvmap.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath }/css/dropzone.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="${pageContext.request.contextPath }/css/custom.min.css" rel="stylesheet">

    <!-- add local/css 2016-8-18 -->
    <link href="${pageContext.request.contextPath }/css/appinfoadd.css" rel='stylesheet'>
    <link href="${pageContext.request.contextPath }/css/appinfolist.css" rel='stylesheet'>
</head>
<body>

<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>
                    产品异常通报信息管理维护 <i class="fa fa-user"></i><small>${userSession.role_name}-
                    ${userSession.user_name} - 您可以通过搜索或者其他的筛选项对产品异常通报的信息进行修改、删除等管理操作。</small>
                </h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <form method="post" action="${pageContext.request.contextPath }/csrht/abnormal">
                    <input type="hidden" name="pageNum" value="1" />
                    <ul>
                        <li>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">产品名称</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input name="name" type="text" class="form-control col-md-7 col-xs-12"
                                           value="${name}">
                                </div>
                            </div>
                        </li>
                        <li>
                            <button type="submit" class="btn btn-primary"> 查 &nbsp;&nbsp;&nbsp;&nbsp;询</button>
                        </li>
                    </ul>
                </form>
            </div>
        </div>
    </div>
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_content">
                <p class="text-muted font-13 m-b-30"></p>
                <div id="datatable-responsive_wrapper"
                     class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <button type="submit" id="addabnormal" class="btn btn-primary" >新增产品</button>
                                </div>
                            </div>
                            <div style="overflow-x: auto;overflow-y: auto;width: 100%;height: 50%">
                                <table id="datatable-responsive"
                                       class=" table-striped table-bordered dt-responsive nowrap dataTable no-footer dtr-inline collapsed"
                                       role="grid" aria-describedby="datatable-responsive_info"
                                       style="width: 120%;">
                                    <thead>
                                    <tr role="row">
                                        <th hidden>主键id</th>
                                        <th hidden>产品id</th>
                                        <th class="sorting_asc" tabindex="0"
                                            aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                            aria-label="First name: activate to sort column descending"
                                            aria-sort="ascending">产品名称
                                        </th>
                                        <th class="sorting" tabindex="0"
                                            aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                            aria-label="Last name: activate to sort column ascending">
                                            包装规格
                                        </th>
                                        <th class="sorting" tabindex="0"
                                            aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                            aria-label="Last name: activate to sort column ascending">
                                            批号/生产日期
                                        </th>
                                        <th class="sorting" tabindex="0"
                                            aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                            aria-label="Last name: activate to sort column ascending">
                                            标称卫生许可证/批准文号
                                        </th>
                                        <th class="sorting" tabindex="0"
                                            aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                            aria-label="Last name: activate to sort column ascending">
                                            不合格项目
                                        </th>
                                        <th class="sorting" tabindex="0"
                                            aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                            aria-label="Last name: activate to sort column ascending">
                                            检验结果
                                        </th>
                                        <th class="sorting" tabindex="0"
                                            aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                            aria-label="Last name: activate to sort column ascending">
                                            标准规定
                                        </th>
                                        <th class="sorting" tabindex="0"
                                            aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                            aria-label="Last name: activate to sort column ascending">
                                            机构验证
                                        </th>
                                        <th class="sorting" tabindex="0"
                                            aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                            aria-label="Last name: activate to sort column ascending">
                                            结论
                                        </th>
                                        <th class="sorting" tabindex="0"
                                            aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                            aria-label="Last name: activate to sort column ascending">
                                            出处
                                        </th>
                                        <th class="sorting" tabindex="0"
                                            aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                            style="width: 124px;"
                                            aria-label="Last name: activate to sort column ascending">
                                            操作
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="pages" items="${page.content}" varStatus="status">
                                        <tr role="row" class="odd">
                                            <td hidden>${pages.id}</td>
                                            <td hidden>${pages.product_id}</td>
                                            <td tabindex="0" class="sorting_1">${pages.product.product_name}</td>
                                            <td>${pages.packing}</td>
                                            <td>${pages.batch_no}</td>
                                            <td>${pages.approval_no}</td>
                                            <td>${pages.disqualification}</td>
                                            <td>${pages.inspection_result}</td>
                                            <td>${pages.standard_code}</td>
                                            <td>${pages.agencies_to_verify}</td>
                                            <td>${pages.last}</td>
                                            <td>${pages.provenance}</td>
                                            <td>
                                                <div class="btn-group">
                                                    <button type="button" class="btn btn-danger">点击操作</button>
                                                    <button type="button" class="btn btn-danger dropdown-toggle"
                                                            data-toggle="dropdown" aria-expanded="false">
                                                        <span class="caret"></span>
                                                        <span class="sr-only">Toggle Dropdown</span>
                                                    </button>
                                                    <ul class="dropdown-menu" role="menu">
                                                        <li><a class="modifyAppInfo update" data-toggle="tooltip"
                                                               data-placement="top" title="" common="${pages.id}"
                                                               data-original-title="修改公司信息">修改</a></li>
                                                        <li><a class="deleteApp delete" data-toggle="tooltip"
                                                               data-placement="top" title="" common="${pages.id}"
                                                               data-original-title="删除公司信息">删除</a></li>
                                                    </ul>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!--分页开始-->
                    <div class="row" id="row">
                        <div class="col-sm-5">
                            <div class="dataTables_info" id="datatable-responsive_info" role="status"
                                 aria-live="polite">共<span>${page.totalSize}</span>条记录<span>${page.pageNum }/${page.totalPages }</span>页
                            </div>
                        </div>
                        <div class="col-sm-7">
                            <div class="dataTables_paginate paging_simple_numbers" id="datatable-responsive_paginate">
                                <ul class="pagination">
                                    <c:if test="${page.pageNum > 1}">
                                        <li class="paginate_button previous"><a
                                                href="javascript:page_nav2(document.forms[0],1);"
                                                aria-controls="datatable-responsive" data-dt-idx="0"
                                                tabindex="0">首页</a>
                                        </li>
                                        <li class="paginate_button "><a
                                                href="javascript:page_nav2(document.forms[0],${page.pageNum-1});"
                                                aria-controls="datatable-responsive" data-dt-idx="1"
                                                tabindex="0">上一页</a>
                                        </li>
                                    </c:if>
                                    <c:if test="${page.pageNum < page.totalPages }">
                                        <li class="paginate_button "><a
                                                href="javascript:page_nav2(document.forms[0],${page.pageNum+1 });"
                                                aria-controls="datatable-responsive" data-dt-idx="1"
                                                tabindex="0">下一页</a>
                                        </li>
                                        <li class="paginate_button next"><a
                                                href="javascript:page_nav2(document.forms[0],${page.totalPages });"
                                                aria-controls="datatable-responsive" data-dt-idx="7"
                                                tabindex="0">最后一页</a>
                                        </li>
                                    </c:if>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!--分页结束-->
                </div>
            </div>
        </div>
    </div>
</div>
<!-- jQuery -->
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="${pageContext.request.contextPath }/js/fastclick.js"></script>
<!-- NProgress -->
<script src="${pageContext.request.contextPath }/js/nprogress.js"></script>
<!-- jQuery custom content scroller -->
<script src="${pageContext.request.contextPath }/js/jquery.mCustomScrollbar.concat.min.js"></script>
<!-- Custom Theme Scripts -->
<%--<script src="${pageContext.request.contextPath }/js/custom.min.js"></script>--%>
<script src="${pageContext.request.contextPath }/js/dropzone.js"></script>
<!--<script src="js/rollpage.js"></script>-->
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/js/rollpage.js"></script>
<script src="${pageContext.request.contextPath }/js/plugins/layer/layer.js"></script>
<script type="application/javascript">
    $(function () {
        $("#addabnormal").click(function () {
            layer.open({
                type: 2,
                title: '新增产品异常',
                shadeClose: true,
                maxmin: true, //开启最大化最小化按钮
                area: ['893px', '600px'],
                anim: 1,
                content: '/abnormal/addabnormal',
                end: function () {
                    location.reload();
                }
            });
        });
        $(".update").click(function () {
            var obj=$(this);
            console.log(obj.attr('common'));
            layer.open({
                type: 2,
                title: '修改产品',
                shadeClose: true,
                maxmin: true, //开启最大化最小化按钮
                area: ['893px', '600px'],
                anim: 1,
                content: '/abnormal/updateabnormal/'+obj.attr("common"),
                end: function () {
                    location.reload();
                }
            });
        });
         $(".delete").click(function () {
             var obj=$(this);
             console.log(obj.attr('common'));
             layer.confirm('您确认删除吗？', {
                 btn: ['删除','取消'] //按钮
             }, function(){
                 $.ajax({
                     type: "POST",
                     url: "/abnormal/deleteabnormal/"+obj.attr("common"),
                     dataType: 'json',
                     success: function (data) {
                         if (data.code == 0) {
                             parent.layer.msg("删除成功", {icon: 1});
                             location.reload();
                         } else {
                             parent.layer.alert(data.msg);
                         }
                     }
                 });
             }, function(){
                 layer.msg('您取消了删除', {
                     time: 1000, //2s后自动关闭
                 });
                 parent.layer.close();
             });
         });
    });
</script>
</body>
</html>

