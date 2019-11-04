package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.NewsMapper;
import com.csr.csrcheck.pojo.News;
import com.csr.csrcheck.service.NewsService;
import com.csr.csrcheck.service.ex.CompanyException;
import com.csr.csrcheck.service.ex.InsertException;
import com.csr.csrcheck.util.PageRequest;
import com.csr.csrcheck.util.PageResult;
import com.csr.csrcheck.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Karry
 * @create 2019-10-24 14:42
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Resource
    private NewsMapper newsMapper;
    @Override
    public List<News> getAllNews() {
        return newsMapper.getAllNews();
    }

    @Override
    public PageResult getNewspage(int pageNum, int pageSize) {
        return PageUtils.getPageResult(pageNum,pageSize,getpageinfo(pageNum,pageSize));
    }

    @Override
    public boolean addNews(News news) {
        Boolean flag=false;
        Integer row=newsMapper.addNews(news);
        if(row>0) {
            flag = true;
        }else{
            throw new InsertException("增加失败");
        }
        if(news.getNews_title().equals("")||news.getNews_content().equals("")||news.getImg_url().equals("")){
            throw new CompanyException("请输入内容");
        }
        return true;
    }

    /**
     * 调用分页插件完成分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    private PageInfo<News> getpageinfo(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<News> list=newsMapper.getAllNews();
        return new PageInfo<News>(list);
    }
}
