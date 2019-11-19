package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Company_news;

import java.util.List;

/**
 * @author Karry
 * @create 2019-11-14 10:08
 */
public interface Company_newsMapper {
    List<Company_news> selectAllBycompany_id(int company_id);
}
