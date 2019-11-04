package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.News;
import com.csr.csrcheck.util.PageResult;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-24 14:41
 */
public interface NewsService {

    //查询所有新闻
    public List<News> getAllNews();

    /**
     *分页查询新闻信息
     *  @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult getNewspage(int pageNum, int pageSize);

    /**
     * 增加新闻信息
     * @param news
     * @return
     */
    public boolean addNews(News news);

}
