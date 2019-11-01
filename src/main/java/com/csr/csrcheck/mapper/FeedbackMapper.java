package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Feedback;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/1 16:37
 * @version:
 * @modified By:
 */
public interface FeedbackMapper {

    /**
     * 查询反馈内容后台展示
     * @return
     */
    public List<Feedback> getfeedback();

    /**
     * 小程序添加反馈内容
     * @param feedback
     */
    public Integer addfeedback(@Param(value = "feedback") Feedback feedback);
}
