package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.News;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-24 14:25
 */
public interface NewsMapper {

    //查询所有新闻
    public List<News> getAllNews();

}
