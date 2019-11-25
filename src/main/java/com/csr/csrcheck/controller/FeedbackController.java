package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Feedback;
import com.csr.csrcheck.service.FeedbackService;
import com.csr.csrcheck.service.ex.CompanyException;
import com.csr.csrcheck.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@Slf4j
public class FeedbackController extends BaseController{

    @Resource
    private FeedbackService feedbackService;
    /**
     *小程序增加反馈
     *  @param feedback
     * @return
     */
    @GetMapping("add")
    public JsonResult<Void> feeedback(Feedback feedback){

        if(feedback.getContent().equals("")||feedback.getInformation().equals("")){
            throw new CompanyException("请输入反馈内容和联系方式");
        }
        String data=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        feedback.setCommitdata(data);
        feedbackService.addfeedback(feedback);
        log.info("add--------------->feedback"+feedback);
        log.info("add--------------->Commitdata"+data);
        return new JsonResult<>(code,OK);
    }


    /**
     *后台展示反馈数据
     *  @return
     */
    @RequestMapping("list")
    public JsonResult<List<Feedback>> list(){
        List<Feedback> list=feedbackService.getfeedback();
        return new JsonResult<>(code,OK,list);
    }
}
