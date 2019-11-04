package com.csr.csrcheck.csrhtcontroller;

import com.csr.csrcheck.controller.BaseController;
import com.csr.csrcheck.controller.ex.CompanyException;
import com.csr.csrcheck.controller.ex.FileSizeException;
import com.csr.csrcheck.controller.ex.FileTypeException;
import com.csr.csrcheck.controller.ex.FileUploadIOException;
import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.pojo.News;
import com.csr.csrcheck.service.Abnormal_productsService;
import com.csr.csrcheck.service.CompanyService;
import com.csr.csrcheck.service.ProductService;
import com.csr.csrcheck.service.impl.NewsServiceImpl;
import com.csr.csrcheck.util.Constants;
import com.csr.csrcheck.util.JsonResult;
import com.csr.csrcheck.util.PageResult;
import com.csr.csrcheck.util.PageSupport;
import com.sun.deploy.ui.AppInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/10/27 14:52
 * @version:
 * @modified By:
 */
@RequestMapping("csrht")
@Controller
@Slf4j
public class HTConntroller extends BaseController {

    @Resource
    private CompanyService companyService;
    @Resource
    private ProductService productService;
    @Resource
    private Abnormal_productsService abnormal_productsService;
    @Resource
    private NewsServiceImpl newsService;

    /**
     * 公司信息页面
     *
     * @return
     */
    @RequestMapping("companyjsp")
    public String findCompanyPage(@RequestParam(value = "company_name", required = false) String company_name,
                                  @RequestParam(value = "pageIndex", required = false) String pageIndex,
                                  Model model) {


        log.info("findCompanyPage----------------------->company_name:" + company_name);
        log.info("findCompanyPage----------------------->pageIndex:" + pageIndex);

        List<Company> list = null;
        //页面容量
        int pageSize = Constants.pageSize;
        //当前页码
        Integer currentPageNo = 1;
        if (pageIndex != null) {
            try {
                currentPageNo = Integer.valueOf(pageIndex);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        //总数量
        int totalCount = 0;
        try {
            totalCount = companyService.getCompanyCount(company_name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //总页数
        PageSupport pages = new PageSupport();
        pages.setCurrentPageNo(currentPageNo);
        pages.setPageSize(pageSize);
        pages.setTotalCount(totalCount);
        int totalPageCount = pages.getTotalPageCount();
        //控制首页和尾页
        if (currentPageNo < 1) {
            currentPageNo = 1;
        } else if (currentPageNo > totalPageCount) {
            currentPageNo = totalPageCount;
        }
        try {
            list = companyService.getCommpanylistpage(company_name, currentPageNo, pageSize);
            System.out.println(list.size());
        } catch (Exception e) {
            throw new CompanyException(e);
        }
        model.addAttribute("list", list);
        model.addAttribute("page", pages);
        model.addAttribute("company_name", company_name);
        return "company";
    }

    /**
     * 产品信息页面
     *
     * @param model
     * @param name
     * @return
     */
    @RequestMapping("product")
    public String product(@RequestParam(defaultValue = "1") int pageNum,
                          @RequestParam(defaultValue = "5") int pageSize,
                          Model model, @RequestParam(value = "name", required = false) String name) {
        log.info("product----------------------->pageNum:" + pageNum);
        log.info("product----------------------->pageSize:" + pageSize);
        log.info("product----------------------->name:" + name);
        PageResult pageResult = productService.listpage(pageNum, pageSize, name);
        log.info("product----------------------->totalSize:" + pageResult.getTotalSize());
        if (pageResult == null) {
            throw new CompanyException("没有数据");
        }
        model.addAttribute("page", pageResult);
        model.addAttribute("name", name);
        return "Product";
    }

    /**
     * 产品异常通报页面
     *
     * @param pageNum
     * @param pageSize
     * @param name
     * @param model
     * @return
     */
    @RequestMapping("abnormal")
    public String abnormal(@RequestParam(defaultValue = "1") int pageNum,
                           @RequestParam(defaultValue = "5") int pageSize,
                           @RequestParam(value = "name", required = false) String name,
                           Model model) {
        log.info("abnormal------------------------->pageNum:" + pageNum);
        log.info("abnormal------------------------->pageSize:" + pageSize);
        log.info("abnormal------------------------->name:" + name);
        PageResult pageResult = abnormal_productsService.abnormallsitpage(pageNum, pageSize, name);
        log.info("abnormal------------------------->totalSize" + pageResult.getTotalSize());
        if (pageResult == null) {
            throw new CompanyException("没有数据");
        }
        model.addAttribute("page", pageResult);
        model.addAttribute("name", name);
        return "abnormal";
    }

    /**
     * 增加新闻信息（跳转到新增页面）
     * @param news
     * @return
     */
    @RequestMapping("addnews")
    public String add(@ModelAttribute("news") News news){
        return "addnews";
    }
    /**
     * 保存增加新闻
     *
     * @param news
     * @param multipartFile
     * @param request
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String addNews(News news, @RequestParam(value = "multipartFile") MultipartFile multipartFile,
                          HttpServletRequest request) {
        String imgurl = null;
        if (!multipartFile.isEmpty()) {
            String path = request.getSession().getServletContext().getRealPath( "newsFile");
            log.info("newsFile path:" + path);
            String oldFilename = multipartFile.getOriginalFilename();//原文件名
            String prefix = FilenameUtils.getExtension(oldFilename);//原文件后缀
            int filesize = 500000;
            if (multipartFile.getSize() > filesize) { //上传大小不得超过50k
                request.setAttribute("fileUploadError", Constants.FILEUPLOAD_ERROR_4);
            } else if (prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("jpeg")
                    || prefix.equalsIgnoreCase("png") || prefix.equalsIgnoreCase("pneg")) {//上传图片格式
                String fliename = System.currentTimeMillis()+"_"+new Random().nextInt(1000)  + ".jpg";//上传图片命名
                File targetfile = new File(path, fliename);
                if (!targetfile.exists()) {
                    targetfile.mkdirs();
                }
                try {
                    multipartFile.transferTo(targetfile);
                } catch (IOException e) {
                    e.printStackTrace();
                    request.setAttribute("fileUploadError", Constants.FILEUPLOAD_ERROR_2);
                    return "addnews";
                }
                imgurl = request.getContextPath() + "newsFile/" + fliename;
            } else {
                request.setAttribute("fileUploadError", Constants.FILEUPLOAD_ERROR_3);
                return "addnews";
            }
        }
        news.setImg_url(imgurl);
        newsService.addNews(news);
        return "news";
    }
    /**
     * 分页查询新闻信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("newspage")
    public String listpage(@RequestParam(defaultValue = "1") int pageNum,
                                       @RequestParam(defaultValue = "5") int pageSize,
                           Model model){
        PageResult pageResult=newsService.getNewspage(pageNum,pageSize);
        if(pageResult==null){
            throw new CompanyException("没有数据");
        }
        log.info("listpage---------------------------->pageNum"+pageNum);
        log.info("listpage---------------------------->pageSize"+pageSize);
        model.addAttribute("page",pageResult);
        return "news";
    }
}

