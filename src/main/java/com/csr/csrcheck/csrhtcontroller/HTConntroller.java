package com.csr.csrcheck.csrhtcontroller;

import com.csr.csrcheck.controller.BaseController;
import com.csr.csrcheck.controller.ex.CompanyException;
import com.csr.csrcheck.controller.ex.FileSizeException;
import com.csr.csrcheck.controller.ex.FileTypeException;
import com.csr.csrcheck.controller.ex.FileUploadIOException;
import com.csr.csrcheck.mapper.Special_bulletinMapper;
import com.csr.csrcheck.pojo.*;
import com.csr.csrcheck.service.*;
import com.csr.csrcheck.service.impl.NewsServiceImpl;
import com.csr.csrcheck.service.impl.RecallServiceImpl;
import com.csr.csrcheck.util.Constants;
import com.csr.csrcheck.util.JsonResult;
import com.csr.csrcheck.util.PageResult;
import com.csr.csrcheck.util.PageSupport;
import com.sun.deploy.ui.AppInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Resource
    private ApprovalsService approvalsService;
    @Resource
    private Business_risksService business_risksService;
    @Resource
    private ClinicService clinicService;
    @Resource
    private ContendService contendService;
    @Resource
    private EvaluateService evaluateService;
    @Resource
    private  Five_SupplierService fiveSupplierService;
    @Resource
    private IFlight_checkService iFlight_checkService;
    @Resource
    private Product_typeService productTypeService;

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
                          HttpServletRequest request,String newsdate) {
        String imgurl = null;
        if (!multipartFile.isEmpty()) {
            String path = request.getSession().getServletContext().getRealPath( "newsFile");
            log.info("newsFile path:" + path);
            String oldFilename = multipartFile.getOriginalFilename();//原文件名
            String prefix = FilenameUtils.getExtension(oldFilename);//原文件后缀
            int filesize = 500000;
            if (multipartFile.getSize() > filesize) { //上传大小不得超过50kB
                request.setAttribute("fileUploadError", Constants.FILEUPLOAD_ERROR_4);
                return "addnews";
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
        try {
            news.setDate(new SimpleDateFormat("yyyy-mm-dd").parse(newsdate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        newsService.addNews(news);
        return "redirect:/csrht/newspage";
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

    /**
     * 查询批文信息
     * @param pageNum
     * @param pageSize
     * @param model
     * @param name
     * @return
     */
    @RequestMapping("approvals")
    public String approvals(@RequestParam(defaultValue = "1") int pageNum,
                            @RequestParam(defaultValue = "5") int pageSize,
                            Model model, String name){
        PageResult pageResult=approvalsService.getApprovalslistpage(pageNum,pageSize,name);
        log.info("approvals--------------------------->pageNum:"+pageNum);
        log.info("approvals--------------------------->pageSize:"+pageSize);
        log.info("approvals--------------------------->name:"+name);
        model.addAttribute("page",pageResult);
        model.addAttribute("name",name);
        return "approvals";
    }
    /**
     * 分页查询经营风险
     * @param pageNum
     * @param pageSize
     * @param company_name
     * @return
     */
    @RequestMapping("bussiness")
    public String bussiness(@RequestParam(defaultValue = "1") int pageNum,
                                        @RequestParam(defaultValue = "5") int pageSize,
                                        String company_name,
                            Model model){
        PageResult pageResult=business_risksService.getListpage(pageNum,pageSize,company_name);
        if(pageResult==null){
            throw new com.csr.csrcheck.service.ex.CompanyException("没有数据");
        }
        model.addAttribute("page",pageResult);
        model.addAttribute("name",company_name);
        log.info("bussiness---------------------------->pageNum:"+pageNum);
        log.info("bussiness---------------------------->pageSize:"+pageSize);
        log.info("bussiness---------------------------->company_name:"+company_name);
        return "bussiness";
    }

    /**
     * 根据产品名称分页查询临床
     * @param pageNum
     * @param pageSize
     * @param product_name
     * @return
     */
    @RequestMapping("clinic")
    public String clinic(@RequestParam(defaultValue = "1") int pageNum,
                                     @RequestParam(defaultValue = "5") int pageSize,
                         String product_name,Model model){
        PageResult pageResult=clinicService.getListpage(pageNum,pageSize,product_name);
        log.info("clinic---------------------------->pageNum:"+pageNum);
        log.info("clinic---------------------------->pageSize:"+pageSize);
        log.info("clinic---------------------------->product_name:"+product_name);
        model.addAttribute("page",pageResult);
        model.addAttribute("name",product_name);
        return "clinic";
    }

    /**
     *根据药企名称分页查询药企核心竞争力动态信息
     *  @param pageNum
     * @param pageSize
     * @param company_name
     * @return
     */
    @RequestMapping("contend")
    public String contend(@RequestParam(defaultValue = "1") int pageNum,
                                      @RequestParam(defaultValue = "5") int pageSize,
                                      String company_name,Model model){
        PageResult pageResult=contendService.getListpage(pageNum,pageSize,company_name);
        log.info("contend---------------------------------->pageNum:"+pageNum);
        log.info("contend---------------------------------->pageSize:"+pageSize);
        log.info("contend---------------------------------->company_name:"+company_name);
        model.addAttribute("page",pageResult);
        model.addAttribute("name",company_name);
        return "contend";
    }
    /**
     * 根据企业名称或者产品名称查询一致性评价信息
     * @param pageNum
     * @param pageSize
     * @param company_name
     * @param product_name
     * @return
     */
    @RequestMapping("evaluate")
    public String evaluate(@RequestParam(defaultValue = "1") int pageNum,
                                       @RequestParam(defaultValue = "5") int pageSize,
                                       String company_name,
                                       String product_name,
                                Model model) {
        PageResult pageResult=evaluateService.getlistpage(pageNum,pageSize,company_name,product_name);
        log.info("evaluate--------------------------->pageNum:"+pageNum);
        log.info("evaluate--------------------------->pageSize:"+pageSize);
        log.info("evaluate--------------------------->company_name:"+company_name);
        log.info("evaluate--------------------------->product_name:"+product_name);
        model.addAttribute("cname",company_name);
        model.addAttribute("pname",product_name);
        model.addAttribute("page",pageResult);
        return "evaluate";
    }
    /**
     *分页查询前五大供应商
     *  @param pageNum
     * @param pageSize
     * @param supplier_name
     * @return
     */
    @RequestMapping("fiveSuppler")
    public String fiveSuppler(@RequestParam(defaultValue = "1") int pageNum,
                                              @RequestParam(defaultValue = "5") int pageSize,
                                              String supplier_name,Model model){
        PageResult pageResult=null;
        try {
            pageResult=fiveSupplierService.getListFive(pageNum,pageSize,supplier_name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("fiveSuppler------------------>pageResult"+pageResult);
        log.info("fiveSuppler------------------>pageNum"+pageNum);
        log.info("fiveSuppler------------------>pageSize"+pageSize);
        log.info("fiveSuppler------------------>supplier_name"+supplier_name);
        model.addAttribute("name",supplier_name);
        model.addAttribute("page",pageResult);
        return"fiveSuppler";
    }

    /**
     * 根据企业名称,产品名称、产品类型名称、检查编号、公布日期查询
     * @param pageNum
     * @param pageSize
     * @param company_name
     * @param product_name
     * @param product_t_name
     * @param check_no
     * @param publication
     * @return
     */
    @RequestMapping("flightcheck")
    public String flightcheck(@RequestParam(defaultValue = "1") int pageNum,
                                          @RequestParam(defaultValue = "5") int pageSize,
                                          String company_name,
                                          String product_name,
                                          String product_t_name,
                                          String check_no,
                                          String publication,
                              Model model){
        PageResult pageResult=iFlight_checkService.getListpage(pageNum,pageSize,company_name,product_name,product_t_name,check_no,publication);
        if(pageResult==null){
            throw new com.csr.csrcheck.service.ex.CompanyException("没有数据");
        }
        List<Product_type> list=productTypeService.getlist();
        if(list==null){
            throw new com.csr.csrcheck.service.ex.CompanyException("数据为空");
        }
        log.info("flightcheck--------------------------->pageNum:"+pageNum);
        log.info("flightcheck--------------------------->pageSize:"+pageSize);
        log.info("flightcheck--------------------------->company_name:"+company_name);
        log.info("flightcheck--------------------------->product_name:"+product_name);
        log.info("flightcheck--------------------------->product_t_name:"+product_t_name);
        log.info("flightcheck--------------------------->check_no:"+check_no);
        log.info("flightcheck--------------------------->publication:"+publication);
        model.addAttribute("page",pageResult);
        model.addAttribute("company_name",company_name);
        model.addAttribute("product_name",product_name);
        model.addAttribute("product_t_name",product_t_name);
        model.addAttribute("check_no",check_no);
        model.addAttribute("publication",publication);
        model.addAttribute("list",list);
        return "flightcheck";
    }
    @Resource
    private Important_notificationService important_notificationService;

    /**
     *根据产品名称分页查询重要通报
     *  @param pageNum
     * @param pageSize
     * @param product_name
     * @param product_t_name
     * @return
     */
    @RequestMapping("important")
    public String  important(@RequestParam(defaultValue = "1") int pageNum,
                                        @RequestParam(defaultValue = "5") int pageSize,
                                        String product_name, String product_t_name,Model model){
        PageResult pageResult=important_notificationService.getimportant_page(pageNum,pageSize,product_name,product_t_name);
        if(pageResult==null){
            throw new CompanyException("数据为空");
        }
        List<Product_type> list=productTypeService.getlist();
        if(list==null){
            throw new com.csr.csrcheck.service.ex.CompanyException("数据为空");
        }
        log.info("important----------------------------->pageNum:"+pageNum);
        log.info("important----------------------------->pageSize:"+pageSize);
        log.info("important----------------------------->product_name:"+product_name);
        log.info("important----------------------------->product_t_name:"+product_t_name);
        model.addAttribute("page",pageResult);
        model.addAttribute("product_name",product_name);
        model.addAttribute("product_t_name",product_t_name);
        model.addAttribute("list",list);
        return "important";
    }
    @Resource
    private LawsuitService lawsuitService;
    /**
     * 根据企业名称、案件类型、文书类型、被告、发布时间 分页查询法律诉讼
     * @param pageNum
     * @param pageSize
     * @param company_name
     * @param casetype
     * @param doctype
     * @param defendants
     * @param submittime
     * @return
     */
    @RequestMapping("lawsuit")
    public String  lawsuit(@RequestParam(defaultValue = "1") int pageNum,
                           @RequestParam(defaultValue = "5") int pageSize,
                           String company_name,
                           String casetype,
                           String doctype,
                           String defendants,
                           String submittime,Model model){
        PageResult pageResult=lawsuitService.getlistpage(pageNum,pageSize,company_name,casetype,doctype,defendants,submittime);
        if(pageResult==null){
            throw new CompanyException("数据为空");
        }
        log.info("lawsuit-------------------------------------->pageNum:"+pageNum);
        log.info("lawsuit-------------------------------------->pageSize:"+pageSize);
        log.info("lawsuit-------------------------------------->company_name:"+company_name);
        log.info("lawsuit-------------------------------------->casetype:"+casetype);
        log.info("lawsuit-------------------------------------->doctype:"+doctype);
        log.info("lawsuit-------------------------------------->defendants:"+defendants);
        log.info("lawsuit-------------------------------------->submittime:"+submittime);
        model.addAttribute("page",pageResult);
        model.addAttribute("company_name",company_name);
        model.addAttribute("casetype",casetype);
        model.addAttribute("doctype",doctype);
        model.addAttribute("defendants",defendants);
        model.addAttribute("submittime",submittime);
        return "lawsuit";
    }
    @Resource
    private RecallServiceImpl recallService;
    /**
     * 根据产品名称，产品类型名称，企业名称分页查询产品召回内容
     * @param pageNum
     * @param pageSize
     * @param company_name
     * @param product_name
     * @param product_t_name
     * @return
     */
    @RequestMapping("recall")
    public String productrecall(@RequestParam(defaultValue = "1") int pageNum,
                                            @RequestParam(defaultValue = "5") int pageSize,
                                            String company_name, String product_name,
                                            String product_t_name,Model model){
        PageResult pageResult=recallService.getlistpage(pageNum,pageSize,company_name,product_name,product_t_name);
        if(pageResult==null){
            throw new CompanyException("没有数据");
        }
        List<Product_type> list=productTypeService.getlist();
        if(list==null){
            throw new com.csr.csrcheck.service.ex.CompanyException("数据为空");
        }
        log.info("productrecall----------------------------------------->pageNum:"+pageNum);
        log.info("productrecall----------------------------------------->pageSize:"+pageSize);
        log.info("productrecall----------------------------------------->company_name:"+company_name);
        log.info("productrecall----------------------------------------->product_name:"+product_name);
        log.info("productrecall----------------------------------------->product_t_name:"+product_t_name);
        model.addAttribute("page",pageResult);
        model.addAttribute("company_name",company_name);
        model.addAttribute("product_name",product_name);
        model.addAttribute("product_t_name",product_t_name);
        model.addAttribute("list",list);
        return "recall";
    }
    @Resource
    private ShareholderService shareholderService;

    /**
     * 根据公司名称、股东名称，股份类型分页查询
     * @param pageNum
     * @param pageSize
     * @param shareholder_name
     * @param share_type
     * @param company_name
     * @param model
     * @return
     */
    @RequestMapping("shareholder")
    public String shareholder(@RequestParam(defaultValue = "1") int pageNum,
                              @RequestParam(defaultValue = "5") int pageSize,String shareholder_name,
                              String share_type,
                              String company_name,Model model){
        PageResult pageResult=shareholderService.getListPage(pageNum,pageSize,shareholder_name,share_type,company_name);
        if(pageResult==null){
            throw  new CompanyException("没有数据");
        }
        model.addAttribute("page",pageResult);
        model.addAttribute("shareholder_name",shareholder_name);
        model.addAttribute("share_type",share_type);
        model.addAttribute("company_name",company_name);
        return "shareholder";
    }
    @Resource
    private Special_bulletinService special_bulletinService;

    /**
     * 根据企业名称和发布时间查询企业特别公告
     * @param release_time
     * @param company_name
     * @param pageNum
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping("special")
    public String special(String release_time, String company_name,
                          @RequestParam(defaultValue = "1") int pageNum,
                          @RequestParam(defaultValue = "5") int pageSize,Model model){
        PageResult pageResult=special_bulletinService.getlistpage(release_time,company_name,pageNum,pageSize);
        if(pageResult==null){
            throw new CompanyException("数据为空");
        }
        model.addAttribute("page",pageResult);
        model.addAttribute("company_name",company_name);
        model.addAttribute("release_time",release_time);
        return "special";
    }

    @Resource
    private Stock_alterationService stock_alterationService;

    /**
     *根据股东名称、股东类型，变更时间查询
     *  @param pageNum
     * @param pageSize
     * @param shareholder_name
     * @param type
     * @param change_time
     * @param model
     * @return
     */
    @RequestMapping("stock")
    public String stock(@RequestParam(defaultValue = "1") int pageNum,
                        @RequestParam(defaultValue = "5") int pageSize,
                        String shareholder_name, String  type, String change_time, Model model) {
        PageResult pageResult=null;
        try {
            pageResult = stock_alterationService.getlistPage(pageNum, pageSize, shareholder_name, type, change_time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("page",pageResult);
        model.addAttribute("type",type);
        model.addAttribute("change_time",change_time);
        model.addAttribute("shareholder_name",shareholder_name);
        log.info("stock------------------------->type:"+type);
        return "stock";
    }
    @Resource
    private IUserService userService;
    @RequestMapping("personal")
    public String personzl(Model model, HttpSession session){
        int id=getUidFromSession(session);
        User  user=userService.finduser(id);
        model.addAttribute("user",user);
        return "personal";
    }
}

