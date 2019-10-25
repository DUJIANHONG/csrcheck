package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.NewsMapper;
import com.csr.csrcheck.pojo.News;
import com.csr.csrcheck.service.NewsService;
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
}
