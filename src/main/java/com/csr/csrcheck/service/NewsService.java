package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.News;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-24 14:41
 */
public interface NewsService {

    //查询所有新闻
    public List<News> getAllNews();
}
