package com.csr.csrcheck.service;

import com.csr.csrcheck.mapper.FeedbackMapper;
import com.csr.csrcheck.pojo.Feedback;

import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/1 16:57
 * @version:
 * @modified By:
 */
public interface FeedbackService {

    /**
     * 小程序端增加反馈
     * @param feedback
     * @return
     */
    void addfeedback(Feedback feedback);

    /**
     * 后台展示反馈内容
     * @return
     */
    List<Feedback> getfeedback();
}
