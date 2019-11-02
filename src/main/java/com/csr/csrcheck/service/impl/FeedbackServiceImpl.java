package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.FeedbackMapper;
import com.csr.csrcheck.pojo.Feedback;
import com.csr.csrcheck.service.FeedbackService;
import com.csr.csrcheck.service.ex.CompanyException;
import com.csr.csrcheck.service.ex.InsertException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/1 17:01
 * @version:
 * @modified By:
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Resource
    private FeedbackMapper feedbackMapper;

    @Override
    public void addfeedback(Feedback feedback) {
        if(feedback.getContent().equals("")||feedback.getInformation().equals("")){
            throw new CompanyException("请输入反馈内容和联系方式");
        }
        Integer row=feedbackMapper.addfeedback(feedback);
        if (row!=1){
            throw new InsertException("增加失败");
        }
    }

    @Override
    public List<Feedback> getfeedback() {
        List<Feedback> list=null;
        try {
            list=feedbackMapper.getfeedback();
        } catch (Exception e) {
            throw new CompanyException("数据为空");
        }
        return list;
    }
}
