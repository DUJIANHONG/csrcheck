package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Flight_check;

import java.util.List;

public interface IFlight_checkService {
    /**
     * 查询飞行检查信息
     * @param
     * @return
     */
    public List<Flight_check> getFlight_checklist();
}
