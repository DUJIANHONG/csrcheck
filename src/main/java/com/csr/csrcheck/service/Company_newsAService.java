package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Company_news;

import java.util.List;

/**
 * @author Karry
 * @create 2019-11-14 10:21
 */
public interface Company_newsAService {
    List<Company_news> selectAllBycompany_id(int company_id);
}
