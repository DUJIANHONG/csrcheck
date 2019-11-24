<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
    <!--    &lt;!&ndash;10秒刷新一次页面&ndash;&gt;
        <meta http-equiv="refresh" content="0.1">-->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>CSR</title>
    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../css/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../css/green.css" rel="stylesheet">
    <!-- bootstrap-progressbar -->
    <link href="../css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- JQVMap -->
    <link href="../css/jqvmap.min.css" rel="stylesheet"/>
    <link href="../css/dropzone.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="../css/custom.min.css" rel="stylesheet">

    <!-- add local/css 2016-8-18 -->
    <link href="../css/appinfoadd.css" rel='stylesheet'>
    <link href="../css/appinfolist.css" rel='stylesheet'>
    <%--<link rel="stylesheet" href="../layui/css/layui.css" media="all">--%>
    <link href="../Content/Layui-KnifeZ/css/layui.css" rel="stylesheet" />
    <style>
        .fa-calendar {
            position: absolute;
            top: -0.5px;
            right: 20px;
            margin-top: 5px;
            cursor: pointer;
            font-size: 20px;
            color: #1E9FFF;
        }
    </style>
</head>
<body>
<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>新增新闻信息 <i class="fa fa-user"></i><small>${userSession.role_name}-${userSession.user_name}</small>
                </h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <!-- <div class="item form-group">
                         <label class="control-label col-md-3 col-sm-3 col-xs-12" ></label>
                         <div class="col-md-6 col-sm-6 col-xs-12">
                           <form action="uploadlogo" class="dropzone" style="height:100px;">
                           </form>
                      <div class="clearfix"></div>
                   </div>
                     </div> -->
                <div class="clearfix"></div>
                <form class="form-horizontal form-label-left" id="newsid" enctype="multipart/form-data"
                      action="/csrht/add" method="post">
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">新闻标题 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="news_title" class="form-control col-md-7 col-xs-12"
                                   data-validate-length-range="20" data-validate-words="1" name="news_title"
                                   required="required"
                                   placeholder="请输入新闻标题" type="text">
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">新闻副标题 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="subheading" class="form-control col-md-7 col-xs-12"
                                   data-validate-length-range="20" data-validate-words="1" name="subheading"
                                   required="required"
                                   placeholder="请输入新闻副标题" type="text">
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">原创作者<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="news_name" class="form-control col-md-7 col-xs-12"
                                   data-validate-length-range="20" data-validate-words="1" name="news_name"
                                   required="required"
                                   placeholder="请输入原创作者" type="text">
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">原创作者职位<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="position" class="form-control col-md-7 col-xs-12"
                                   data-validate-length-range="20" data-validate-words="1" name="position"
                                   required="required"
                                   placeholder="请输入原创作者职位" type="text">
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">新闻日期<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="newsdate" class="form-control col-md-7 col-xs-12"
                                   data-validate-length-range="20" data-validate-words="1" name="newsdate"
                                   required="required"
                                   placeholder="请选择新闻日期">
                            <i class="fa fa-calendar" aria-hidden="true"></i>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">新闻内容 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <textarea id="news_content" class="form-control col-md-7 col-xs-12" required="required"
                                      data-validate-length-range="20" data-validate-words="1" name="news_content"
                                      rows="10px">
                            </textarea>
                        </div>
                    </div>


                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">新闻图片 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="file" class="form-control col-md-7 col-xs-12" name="multipartFile"
                                   required="required" id="multipartFile"/>
                            <span style="color:red;">${fileUploadError }</span>
                        </div>
                    </div>
                    <div class="ln_solid"></div>
                    <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                            <button id="send" type="submit" class="btn btn-success">保存</button>
                            <button type="reset" class="btn btn-primary">清空</button>
                            <button type="button" class="btn btn-danger" onclick="javascript :history.back(-1);">返回
                            </button>
                            <br/><br/>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- jQuery -->
<script src="../js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="../js/fastclick.js"></script>
<!-- NProgress -->
<script src="../js/nprogress.js"></script>
<!-- jQuery custom content scroller -->
<script src="../js/jquery.mCustomScrollbar.concat.min.js"></script>
<!-- Custom Theme Scripts -->
<script src="../js/dropzone.js"></script>
<!--<script src="js/rollpage.js"></script>-->
<script src="../js/jquery.min.js"></script>
<script src="../js/rollpage.js"></script>
<%--<script src="../layui/layui.js" charset="utf-8"></script>--%>
<script src="../Content/Layui-KnifeZ/layui.js"></script>
<script src="../Content/ace/ace.js"></script>
<script>
    layui.use(['laydate','layedit'], function () {
        var laydate = layui.laydate,
            layedit=layui.layedit;

        //执行一个laydate实例
        laydate.render({
            elem: '#newsdate' //指定元素
            , eventElem: '.fa-calendar'
            , trigger: 'click'
        });

        layedit.build('news_content',{
            tool: [
                'html'//源码模式
                ,'undo','redo' //撤销重做--实验功能，不推荐使用
                ,'code', 'strong', 'italic', 'underline', 'del',
                ,'addhr' //添加水平线
                ,'|', 'fontFomatt','fontfamily','fontSize', //段落格式，字体样式，字体颜色
                'colorpicker', 'fontBackColor'//字体颜色，字体背景色
                ,'face', '|', 'left', 'center', 'right', '|', 'link', 'unlink',
                 'image' ,//原版上传图片
                'images'//多图上传
                ,'image_alt'//上传图片拓展
                ,'attachment'//上传附件
                ,'video' //视频上传
                ,'anchors' //锚点
                , '|', 'table'//插入表格
                ,'customlink'//插入自定义链接
                ,'fullScreen',//全屏
                 'preview'//预览
    ]
        }); //建立编辑器
    });
</script>
</body>
</html>