package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.NewsMapper;
import com.csr.csrcheck.pojo.News;
import com.csr.csrcheck.service.NewsService;
import com.csr.csrcheck.service.ex.CompanyException;
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
        }
        return flag;
    }

    @Override
    public News getnewsbyid(Integer id) {
        News news =newsMapper.getnewsbyid(id);
        if(news==null){
            throw new CompanyException("数据为空");
        }
        return news;
    }

    @Override
    public int updateNews(News news) {
        int row=newsMapper.updateNews(news);
        if(row!=1){
            throw new CompanyException("修改失败");
        }
        return row;
    }

    @Override
    public int deleteNews(int id) {
        int row=newsMapper.deleteNews(id);
        if(row!=1){
            throw new CompanyException("删除失败");
        }
        return row;
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
