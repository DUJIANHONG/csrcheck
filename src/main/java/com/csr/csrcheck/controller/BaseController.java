package com.csr.csrcheck.controller;

import com.csr.csrcheck.controller.ex.CompanyException;
import com.csr.csrcheck.controller.ex.ProductException;
import com.csr.csrcheck.controller.ex.*;
import com.csr.csrcheck.service.ex.*;
import com.csr.csrcheck.util.JsonResult;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * @description: 控制器类的基类
 * @author: Administrator
 * @date: Created in 2019/10/16 17:12
 * @version:
 * @modified By:
 */
public class BaseController {

    /**
     * @description 响应成功的标识码
     * @date
     * @param null
     * @return
     */
    public static final int code = 0;


    /**
     * 响应成功的提示
     */
    public static final String OK="json响应成功";

    /**
     * 从Session中获取当前登录的用户的id
     * @param session Session对象
     * @return 当前登录的用户的id
     */
    protected Integer getUidFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("user_id").toString());
    }

    /**
     * 从Session中获取当前登录的用户名
     * @param session Session对象
     * @return 当前登录的用户名
     */
    protected String getUsernameFromSession(HttpSession session) {

        return session.getAttribute("user_name").toString();
    }

    @ExceptionHandler({ServiceException.class, FileUploadException.class})
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> jr = new JsonResult<>(e);

        if (e instanceof UsernameConflictException) {
            // 4000-用户名冲突异常，例如：注册时用户名已经被占用
            jr.setcode(4000);
        } else if (e instanceof UserNotFoundException) {
            // 4001-用户数据不存在
            jr.setcode(4001);
        } else if (e instanceof PasswordNotMatchException) {
            // 4002-验证密码失败
            jr.setcode(4002);
        } else if (e instanceof InsertException) {
            // 5000-插入数据异常
            jr.setcode(5000);
        } else if (e instanceof UpdateException) {
            // 5001-更新数据异常
            jr.setcode(5001);
        } else if (e instanceof FileEmptyException) {
            // 6000-上传的文件为空，例如：没有选择文件，或选择的文件是0字节的
            jr.setcode(6000);
        } else if (e instanceof FileSizeException) {
            // 6001-上传的文件大小超出了限制
            jr.setcode(6001);
        } else if (e instanceof FileTypeException) {
            // 6002-上传的文件类型超出了限制
            jr.setcode(6002);
        } else if (e instanceof FileUploadStateException) {
            // 6003-上传文件状态异常，可能文件已经被移动或删除，无法继续访问该文件
            jr.setcode(6003);
        } else if (e instanceof FileUploadIOException) {
            // 6004-上传文件时出现读写错误
            jr.setcode(6004);
        }else if (e instanceof ProductException) {
            // 6005-产品异常
            jr.setcode(6005);
        }else if (e instanceof ProductNotFoundException) {
            // 6006-产品找不到异常
            jr.setcode(6006);
        }else if (e instanceof Flight_checkException) {
            // 6007-飞行查询异常
            jr.setcode(6007);
        }else if (e instanceof ClinicException) {
            // 6008-临床数据查询异常
            jr.setcode(6008);
        }else if (e instanceof ClinicException) {
            // 6009-一致性数据查询异常
            jr.setcode(6009);
        }else if (e instanceof ApprovalsException) {
            // 7001-批文数据查询异常
            jr.setcode(7001);
        }else if(e instanceof CompanyException){
            jr.setcode(7002);
            //7003-核心人员关联企业异常
        }else if(e instanceof Actual_controllerException){
            jr.setcode(7003);
            //7004-法律诉讼异常
        }else if(e instanceof LawsuitException){
            jr.setcode(7004);
        }
        return jr;
    }


}