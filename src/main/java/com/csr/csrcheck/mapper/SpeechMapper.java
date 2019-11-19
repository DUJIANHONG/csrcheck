package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Other;
import com.csr.csrcheck.pojo.Speech;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-21 9:33
 */
public interface SpeechMapper {

    //查询社会责任报告撰写咨询信息
    public List<Speech> getSpeechList();

    /**
     *根据社会责任报告撰写咨询信息
     *  @param company_name
     * @return
     */
    public List<Speech> getSpeechListpage(@Param(value = "company_name") String company_name);

}
