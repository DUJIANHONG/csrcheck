package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.News;
import com.csr.csrcheck.service.impl.NewsServiceImpl;
import com.csr.csrcheck.util.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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
        return new JsonResult<>(SUCCESS,OK,list);
    }

    @RequestMapping("newApi")
    public String api() throws IOException {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            //拼接参数，转义参数
            String connUrl = "https://www.apiopen.top/journalismApi";

            //创建连接
            URL url = new URL(connUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setUseCaches(false);
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            conn.setInstanceFollowRedirects(false);
            conn.connect();


            //获取并解析数据
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            StringBuffer sb = new StringBuffer();
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;
    }
}
