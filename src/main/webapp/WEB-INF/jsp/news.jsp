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
    <style type="text/css">
        *{
            margin: 0;
            padding:0;
        }
        .wrap{
            width: 600px;
            margin: 0px auto;

        }
        .menu{
            width: 600px;
            height: 30px;
            background: cornflowerblue;
            position: sticky;
            top:0px;
        }
        .menu ul li{
            float: left;
            list-style-type: none;
            padding: 0 40px;
        }
        .content ul li img:hover{
            transform: scale(1.2);/*当鼠标移动到图片上时实现放大功能*/
        }
        .content ul li{
            height: 100px;
            overflow: hidden;
            border-bottom: 1px solid lavender;
            background: white;
            list-style-type: none;
            transition-duration: 0.5s;
            margin: 10px 10px 5px 0;

        }
        .content ul li:hover{
            background-color: lavender;
            transition-duration: 0.5s;
        }
        .content .left{
            overflow: hidden;/*隐藏溢出图片内容*/
            transition-duration: 0.5s;
            width: 140px;
            height:80px;
            /*background: green;*/
            float: left;
            margin-right:20px;
        }
        .content .right{
            width:400px ;
            float: left;
            /*background: pink;*/
        }
        .right_top{
            height:60px;
        }
        .right_bottom{
            margin_top:50px;
        }
        .right_bottom_left span{
            color: darkgray;
            font-size: 12px;
        }
    </style>
</head>
<body>

<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>
                    新闻信息管理维护 <i class="fa fa-user"></i><small>
                    ${userSession.user_name}</small>
                </h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content" style="display: none">
                <form method="post" action="${pageContext.request.contextPath }">
                    <input type="hidden" name="pageNum" value="1" />
                    <ul>
                    <li>
                        <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12"></label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input name="name" type="text" class="form-control col-md-7 col-xs-12"
                                       value="">
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
                    <div class="wrap">
                        <div class="content">
                            <ul>
                            <c:forEach var="pages" items="${page.content}" varStatus="status">
                                <li>
                                    <div class="left"><img src="../../${pages.img_url}" alt=""></div>
                                    <div class="right">
                                        <div class="right_top">
                                            <h3>${pages.news_title}</h3>
                                        </div>
                                        <div class="right_bottom">
                                            <div class="right_bottom_left">
                                                <span>${pages.news_name}</span>  <span>${pages.position}</span><span>|</span> <span><fmt:formatDate value="${pages.date}" type="date"/></span>
                                                <span style="color: red;float: right" newsid="${pages.id}" class="btn">查看新闻详情 >>>></span>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </c:forEach>
                            </ul>
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
<script>
  $(".btn").click(function () {
      var obj = $(this);
      window.location.href="/web/news.html?id="+obj.attr("newsid");
  })

</script>
</body
</body>
</html>

