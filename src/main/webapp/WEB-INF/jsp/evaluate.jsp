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
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/layui.css"  media="all">
</head>
<body>

<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>
                    企业一致性评价信息管理维护 <i class="fa fa-user"></i><small>${userSession.role_name}-
                    ${userSession.user_name} - 您可以通过搜索或者其他的筛选项对企业一致性评价信息进行修改、删除等管理操作。</small>
                </h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <form method="post" action="${pageContext.request.contextPath }/csrht/evaluate">
                    <input type="hidden" name="pageNum" value="1" />
                    <ul>
                        <li>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">企业名称</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input name="company_name" type="text" class="form-control col-md-7 col-xs-12"
                                           value="${cname}">
                                </div>
                            </div>
                        </li>

                        <li>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">产品名称</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input name="product_name" type="text" class="form-control col-md-7 col-xs-12"
                                               value="${pname}">
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
                            <a href="javascript:;" class="btn btn-success btn-sm" id="addevaluate">新增企业一致性评价信息</a>
                            <div style="overflow-x: auto;overflow-y: auto;height: 50%;width: 100%">
                            <table id="datatable-responsive"
                                   class=" table-striped table-bordered dt-responsive nowrap dataTable no-footer dtr-inline collapsed"
                                   role="grid" aria-describedby="datatable-responsive_info"
                                   style="width: 150%;">
                                <thead>
                                <tr role="row">
                                    <th class="sorting_asc" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="First name: activate to sort column descending"
                                        aria-sort="ascending">受理号
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        产品名称
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        英文名称
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        规格
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        剂型
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        适应症
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        企业名称
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
                                        <td tabindex="0" class="sorting_1">${pages.accept_no}</td>
                                        <td>${pages.product.product_name}</td>
                                        <td>${pages.english_name}</td>
                                        <td>${pages.specification}</td>
                                        <td>${pages.agent_type}</td>
                                        <td>${pages.adaptation_disease}</td>
                                        <td>${pages.company.company_name}</td>
                                        <td>
                                            <div class="btn-group">
                                                <button type="button" class="btn btn-danger">点击操作</button>
                                                <button type="button" class="btn btn-danger dropdown-toggle"
                                                        data-toggle="dropdown" aria-expanded="false">
                                                    <span class="caret"></span>
                                                    <span class="sr-only">Toggle Dropdown</span>
                                                </button>
                                                <ul class="dropdown-menu" role="menu">
                                                    <li><a class="updateevaluate" data-toggle="tooltip"
                                                           data-placement="top" title="" updateid="${pages.id}"
                                                           data-original-title="修改公司信息">修改</a></li>
                                                    <li><a class="deleateevaluate" deleateid="${pages.id}" data-toggle="tooltip"
                                                           data-placement="top" title=""
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
<script src="${pageContext.request.contextPath }/js/plugins/layer/layer.min.js"></script>
<script src="${pageContext.request.contextPath }/js/plugins/layer/layer.js"></script>
<script src="${pageContext.request.contextPath }/js/layui.js" charset="utf-8"></script>
<script type="text/javascript">
    //增加弹出层
    $("#addevaluate").on('click',function () {
        layer.open({
            type:2,
            title:'增加一致性评价',
            maxmin:true,
            shadeClose:true,
            anim:2,
            shade:[0.8,'#393D49'],
            area:['800px','600px'],
            content:'/web/addEvaluate.html',
            end:function () {
                location.reload();
            }
        })
    });
    //修改弹出层
    $(".updateevaluate").on('click',function () {
        var obj=$(this);
        console.log(obj.attr("updateid"));
        layer.open({
            type: 2,
            title:'修改一致性评价',
            maxmin:true,
            shadeClose: true,
            anim: 4,
            shade:[0.8,'#393D49'],
            area:['800px','600px'],
            content: '/web/updateEvaluate.html?id='+obj.attr('updateid'),
            end:function () {
                location.reload();
            }
        })
    });
    //删除
    $(".deleateevaluate").on('click',function () {
        var obj=$(this);
        console.log(obj.attr("deleateid"));
        parent.layer.confirm("确定要删除这条记录吗？",{btn:['确定','取消']},function (confirm) {
            layer.close(confirm);
            $.ajax({
                type:"POST",
                url:"/evaluate/deleteEvaluate/"+obj.attr("deleateid"),
                dataType:"json",
                success:function (data) {
                    if(data.code==0){
                        parent.layer.msg("操作成功",{icon:6});
                        location.reload();
                    }else{
                        parent.layer.msg(data.msg);
                    }
                }
            });
        },function (confirms) {
            layer.close(confirms);
            parent.layer.msg("已取消删除");
        });

    });
</script>

</body>
</body>
</html>

