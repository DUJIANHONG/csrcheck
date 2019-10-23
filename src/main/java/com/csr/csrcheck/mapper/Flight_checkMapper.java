package com.csr.csrcheck.mapper;


import com.csr.csrcheck.pojo.Flight_check;

import java.util.List;

/**
 * @description:
 * @author: dujianhong
 * @date: Created in 2019/10/17 20:12
 * @version:
 * @modified By:
 */
public interface Flight_checkMapper {
    /**
     * 查询查药品中的飞行检查信息
     * @param
     * @return
     */
    public List<Flight_check> getFlight_checklist();
    /**
     * 查询化妆品的飞行检查信息
     * @param
     * @return
     */
    public List<Flight_check> getFlight_checklist2();
}
