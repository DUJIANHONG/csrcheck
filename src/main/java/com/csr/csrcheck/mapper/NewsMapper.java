package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-24 14:25
 */
public interface NewsMapper {

    //查询所有新闻
    public List<News> getAllNews();

    /**
     * 增加新闻信息
     * @param news
     * @return
     */
    public Integer addNews(News news);


    /**
     *根据id 查找新闻内容
     *  @param id
     * @return
     */
    public News getnewsbyid(@Param(value = "id") Integer id);

    /**
     * 修改
     * @param news
     * @return
     */
    int updateNews(News news);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteNews(int id);
}
