package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Feedback;
import com.csr.csrcheck.service.FeedbackService;
import com.csr.csrcheck.util.JsonResult;
import net.sf.json.JSON;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/1 17:12
 * @version:
 * @modified By:
 */
@RequestMapping("feeedback")
@RestController
public class FeedbackController extends BaseController{

    @Resource
    private FeedbackService feedbackService;

    @GetMapping("add")
    public JsonResult<Void> feeedback(Feedback feedback){
        feedbackService.addfeedback(feedback);
        return new JsonResult<>(SUCCESS,OK);
    }

    public JsonResult<List<Feedback>> list(){
        List<Feedback> list=feedbackService.getfeedback();
        return new JsonResult<>(SUCCESS,OK,list);
    }
}
