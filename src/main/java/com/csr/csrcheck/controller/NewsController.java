package com.csr.csrcheck.controller;

import com.csr.csrcheck.controller.ex.*;
import com.csr.csrcheck.pojo.News;
import com.csr.csrcheck.service.ex.CompanyException;
import com.csr.csrcheck.service.impl.NewsServiceImpl;
import com.csr.csrcheck.util.JsonResult;
import com.csr.csrcheck.util.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.apache.commons.io.FilenameUtils;

/**
 * @author Karry
 * @create 2019-10-24 14:44
 */
@RestController
@RequestMapping("news")
@Slf4j
public class NewsController extends BaseController{
    @Resource
    private NewsServiceImpl newsService;

    /**
     * 查询所有新闻
     * @return
     */
    @GetMapping("newlist")
    public JsonResult<List<News>> getAllNews(){
        List<News> list = newsService.getAllNews();
        return new JsonResult<>(SUCCESS,OK,list);
    }

    /**
     *调用api
     *  @return
     * @throws IOException
     */
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

   /* *//**
     *增加新闻
     *  @param news
     * @param multipartFile
     * @param request
     * @return
     *//*
    @RequestMapping("addnews")
    public  JsonResult<Void> addNews(  News news, @RequestParam(value = "multipartFile") MultipartFile multipartFile,
                                      HttpServletRequest request){
        String imgurl=null;
        if (multipartFile.isEmpty()){
            String path=request.getSession().getServletContext().getRealPath("static"+ File.separator+"newsFile");
            log.info("newsFile path:"+path);
            String oldFilename=multipartFile.getOriginalFilename();//原文件名
            String prefix=FilenameUtils.getExtension(oldFilename);//原文件后缀
            int filesize=500000;
            if (multipartFile.getSize()>filesize){ //上传大小不得超过50k
                throw new FileSizeException("上传文件过大");
            }else if (prefix.equalsIgnoreCase("jpg")||prefix.equalsIgnoreCase("jpeg")
                    ||prefix.equalsIgnoreCase("png")||prefix.equalsIgnoreCase("pneg")){//上传图片格式
                String fliename=news.getId()+".jpg";//上传图片命名
                File targetfile=new File(path,fliename);
                if(!targetfile.exists()){
                    targetfile.mkdirs();
                }
                try {
                    multipartFile.transferTo(targetfile);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new FileUploadIOException("上传失败");
                }
                imgurl=request.getContextPath()+"/static/newsFile/"+fliename;
            }else {
                throw  new FileTypeException("格式不正确");
            }
        }
        if(news.getNews_title().equals("")||news.getNews_content().equals("")||news.getImg_url().equals("")){
            throw new com.csr.csrcheck.service.ex.CompanyException("请输入内容");
        }
        news.setImg_url(imgurl);
        newsService.addNews(news);
        return new JsonResult<>(SUCCESS, OK);
    }*/

    /**
     * 分页查询新闻信息
     * @param pageNum
     * @param pageSize
     * @return
     */
/*    @RequestMapping("newspage")
    public JsonResult<Object> listpage(@RequestParam(defaultValue = "1") int pageNum,
                                           @RequestParam(defaultValue = "5") int pageSize){
        PageResult pageResult=newsService.getNewspage(pageNum,pageSize);
        if(pageResult==null){
            throw new CompanyException("没有数据");
        }
        log.info("listpage---------------------------->pageNum"+pageNum);
        log.info("listpage---------------------------->pageSize"+pageSize);
        return new JsonResult<Object>(SUCCESS,OK,pageResult);
    }*/

    /**
     * @description  根据id查找新闻内容
     * @author
     * @date
     * @param id
     * @return
     */
    @GetMapping("byidnews")
    public JsonResult<News> byidnews(@RequestParam(value = "id") Integer id){
        News news=newsService.getnewsbyid(id);
        if(news==null){
            throw new com.csr.csrcheck.service.ex.CompanyException("数据为空");
        }
        if (id==0){
            throw new CompanyException("请输入id");
        }
        log.info("byidnews-------------------------->id"+id);
        return new JsonResult<>(SUCCESS,OK,news);
    }
}
