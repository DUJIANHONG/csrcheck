package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.News;
import com.csr.csrcheck.service.impl.NewsServiceImpl;
import com.csr.csrcheck.util.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Karry
 * @create 2019-10-24 14:44
 */
@RestController
@RequestMapping("news")
public class NewsController extends BaseController{
    @Resource
    private NewsServiceImpl newsService;
    @GetMapping("newlist")
    public JsonResult<List<News>> getAllNews(){
        List<News> list = newsService.getAllNews();
        return new JsonResult<>(SUCCESS,list);
    }
}
