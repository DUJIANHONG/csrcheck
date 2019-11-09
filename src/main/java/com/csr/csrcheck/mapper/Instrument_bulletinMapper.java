package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Clinic;
import com.csr.csrcheck.pojo.Important_notification;

import java.util.List;

public interface Instrument_bulletinMapper {
    /**
     * 查询医疗器械的重要通报信息
     * @param
     * @return
     */
    public List<Important_notification> getImportant_notificationlist();
}
