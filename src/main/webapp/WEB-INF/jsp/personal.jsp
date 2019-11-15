
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<meta charset="utf-8">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="shortcut icon" href="favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/animate.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/font-awesome.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/iCheck/custom.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/cropper.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/gg-bootdo.css" />
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12">
            <div class="ibox">
                <div class="ibox-title" style="padding-bottom: 0;">
                    <h3 class="text-center">个人资料中心</h3>
                    <div class="gg-nav">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#basic_info" data-toggle="tab">基本资料</a></li>
                            <li><a href="#photo_info" data-toggle="tab">头像修改</a></li>
                            <li><a href="#pwd_info" data-toggle="tab">修改密码</a></li>
                            <li><a href="#gl" data-toggle="tab">添加管理员</a></li>
                        </ul>
                    </div>
                </div>
                <div class="tab-content">
                    <!--basic info-->
                    <div class="ibox-content tab-pane fade in active"  id="basic_info">
                        <form class="gg-form" role="form" id="basicInfoForm">
                            <input name="userId" type="hidden" value=""/>
                            <div class="gg-formGroup">
                                <div class="gg-formTitle">
                                    <em class="gg-star">*</em>
                                    <span>用户名:</span>
                                </div>
                                <div class="gg-formDetail">
                                    <input type="text" class="form-control" id="userName" name="user_name" value="${user.user_name}"  placeholder="请输入用户名" />
                                </div>
                            </div>
                            <div class="gg-formGroup">
                                <div class="gg-formTitle">
                                    <em class="gg-star">*</em>
                                    <span>性别:</span>
                                </div>
                                <div class="gg-formDetail">
                                    <div class="radio i-checks">
                                               <label class="radio-inline">
                                                   <input type="radio" name="user_sex" value="1" <c:if test="${user.user_sex==1}">checked="checked"</c:if>/>男
                                               </label>
                                               <label class="radio-inline">
                                                   <input type="radio" name="user_sex" value="2" <c:if test="${user.user_sex==2}">checked="checked"</c:if>/>女
                                               </label>
                                    </div>
                                </div>
                            </div>
                            <div class="gg-formGroup">
                                <div class="gg-formTitle">
                                    <em class="gg-star">*</em>
                                    <span>年龄:</span>
                                </div>
                                <div class="gg-formDetail">
                                    <input type="text" class="form-control" id="age" name="user_age"  value="${user.user_age}" placeholder="请输入年龄" />
                                </div>
                            </div>
                            <div class="gg-formGroup">
                                <div class="gg-formTitle">
                                    <em class="gg-star">*</em>
                                    <span>居住地址:</span>
                                </div>
                                <div class="gg-formDetail">
                                    <input type="text" class="form-control" id="address" name="user_address"  value="${user.user_address}" placeholder="请输入居住地址" />
                                </div>
                            </div>
                        </form>
                        <div class="gg-btnGroup">
                            <button type="button" class="btn btn-sm btn-primary" id="base_save">保存</button>
                        </div>
                    </div>
                    <!--photo_info-->
                    <div class="ibox-content tab-pane fade gg" id="photo_info">
                        <div class="ggcontainer" id="crop-avatar">
                            <form class="avatar-form" action="" enctype="multipart/form-data" method="post">
                                <div class="avatar-body">
                                    <div class="avatar-upload">
                                        <input class="avatar-src" name="avatar_src" type="hidden">
                                        <input class="avatar-data" name="avatar_data" type="hidden">
                                        <label for="avatarInput">选取文件</label>
                                        <input class="avatar-input" id="avatarInput" name="avatar_file" type="file">
                                    </div>
                                    <!-- Crop and preview -->
                                    <div class="row">
                                        <div class="col-md-9">
                                            <div class="avatar-wrapper"></div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="avatar-preview preview-lg"></div>
                                            <div class="avatar-preview preview-md"></div>
                                            <div class="avatar-preview preview-sm"></div>
                                        </div>
                                    </div>

                                    <div class="row avatar-btns">
                                        <div class="col-md-9">
                                            <div class="btn-group">
                                                <button class="btn btn-primary" data-method="rotate" data-option="-90" type="button" title="Rotate -90 degrees">左旋转</button>
                                                <button class="btn btn-primary" data-method="rotate" data-option="-15" type="button">-15°</button>
                                                <button class="btn btn-primary" data-method="rotate" data-option="-30" type="button">-30°</button>
                                                <button class="btn btn-primary" data-method="rotate" data-option="-45" type="button">-45°</button>
                                            </div>
                                            <div class="btn-group">
                                                <button class="btn btn-primary" data-method="rotate" data-option="90" type="button" title="Rotate 90 degrees">右旋转</button>
                                                <button class="btn btn-primary" data-method="rotate" data-option="15" type="button">15°</button>
                                                <button class="btn btn-primary" data-method="rotate" data-option="30" type="button">30°</button>
                                                <button class="btn btn-primary" data-method="rotate" data-option="45" type="button">45°</button>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <button class="btn btn-primary btn-block avatar-save" type="submit">完成裁剪</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            <!-- Loading state -->
                            <div class="loading" aria-label="Loading" role="img" tabindex="-1"></div>
                        </div>
                    </div>
                    <!--pwd_info-->
                    <div class="ibox-content tab-pane fade" id="pwd_info">
                        <form class="gg-form" role="form" id="modifyPwd">
                            <input type="hidden" value=""/>
                            <div class="gg-formGroup">
                                <div class="gg-formTitle">
                                    <em class="gg-star">*</em>
                                    <span>旧密码:</span>
                                </div>
                                <div class="gg-formDetail gg-dashed">
                                    <input type="password" class="form-control gg-border0" id="pwdOld" name="oldPassword" placeholder="请输入旧密码" />
                                    <span class="fa fa-eye gg-faeye" title="鼠标移入显示内容"></span>
                                </div>
                            </div>
                            <div class="gg-formGroup">
                                <div class="gg-formTitle">
                                    <em class="gg-star">*</em>
                                    <span>新密码:</span>
                                </div>
                                <div class="gg-formDetail gg-dashed">
                                    <input type="password" class="form-control gg-border0" id="pwdNew" name="newPassword" placeholder="请输入新密码" />
                                    <span class="fa fa-eye gg-faeye" title="鼠标移入显示内容"></span>
                                </div>
                            </div>
                            <div class="gg-formGroup">
                                <div class="gg-formTitle">
                                    <em class="gg-star">*</em>
                                    <span>确认密码:</span>
                                </div>
                                <div class="gg-formDetail gg-dashed">
                                    <input type="password" class="form-control gg-border0" id="confirm_password" name="confirm_password" placeholder="请确认密码" />
                                    <span class="fa fa-eye gg-faeye" title="鼠标移入显示内容"></span>
                                </div>
                            </div>
                        </form>
                        <div class="gg-btnGroup">
                            <button type="button" class="btn btn-sm btn-primary" id="pwd_save">保存</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/icheck.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/cropper.min.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath }/js/distpicker.data.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/distpicker.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/gg-bootdo.js"></script>
    <!--校验插件-->
    <script src="${pageContext.request.contextPath }/js/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery.validate.extend.js"></script>
    <script src="${pageContext.request.contextPath }/js/messages_zh.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/personal.js"></script>
</body>
</html>
