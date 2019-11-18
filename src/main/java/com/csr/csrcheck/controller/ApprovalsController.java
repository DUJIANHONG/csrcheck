package com.csr.csrcheck.controller;

import com.csr.csrcheck.controller.ex.CompanyException;
import com.csr.csrcheck.pojo.Approvals;
import com.csr.csrcheck.pojo.Approved_by;
import com.csr.csrcheck.pojo.Product;
import com.csr.csrcheck.service.Abnormal_productsService;
import com.csr.csrcheck.service.ApprovalsService;
import com.csr.csrcheck.service.Approved_byService;
import com.csr.csrcheck.service.ProductService;
import com.csr.csrcheck.util.JsonResult;
import com.csr.csrcheck.util.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sun.applet.AppletIOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequestMapping("approvals")
//@Controller
@RestController
@Slf4j
/**
 * 查药企中的批文
 */
public class ApprovalsController extends BaseController{
    @Resource
    private ApprovalsService approvalsService;
    @Resource
    private Abnormal_productsService abnormal_productsService;
    @GetMapping("approvalslist")
    public JsonResult<List<Approvals>> Flight_checklist(HttpServletResponse response) throws IOException, ServletException {
        List<Approvals> list = approvalsService.getApprovalslist();
        if (list==null){
            throw new AppletIOException("批文没有数据");
        }

        return new JsonResult<>(SUCCESS,OK,list);
    }

    /**
     * 产品异常通报
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("page")
    public JsonResult<Object> page(@RequestParam(defaultValue = "1") int pageNum,
                                   @RequestParam(defaultValue = "5") int pageSize,
                                   @RequestParam(value = "name") String name){
        PageResult pageResult=abnormal_productsService.abnormallsitpage(pageNum,pageSize,name);
        if(pageResult==null){
            throw new CompanyException("没有数据");
        }
        return new JsonResult<>(SUCCESS,OK,pageResult);
    }
    /**
     * 查询批文信息
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     */
    @RequestMapping("appro")
    public JsonResult<Object> approvals(@RequestParam(defaultValue = "1") int pageNum,
                            @RequestParam(defaultValue = "5") int pageSize,
                            String name){
        PageResult pageResult=approvalsService.getApprovalslistpage(pageNum,pageSize,name);
        log.info("approvals--------------------------->pageNum:"+pageNum);
        log.info("approvals--------------------------->pageSize:"+pageSize);
        log.info("approvals--------------------------->name:"+name);
        if(pageResult==null){
            throw new CompanyException("没有数据");
        }
        return new JsonResult<Object>(SUCCESS,OK,pageResult);
    }

    /**
     * 添加批文
     * @param approvals
     * @return
     */
    @RequestMapping(path="addapprovals", method= RequestMethod.POST)
    public JsonResult<Object> addapprovals(Approvals approvals){
        approvalsService.addApprovals(approvals);
        log.info("add================================>approvals："+approvals);
        return new JsonResult<>(SUCCESS,OK);
    }


    @Resource
    private ProductService productService;

    /**
     * 下拉框展示产品数据
     * @return
     */
    @RequestMapping(path="listproduct", method= RequestMethod.POST)
    public JsonResult<List<Product>> listproduct(){
        List list=productService.list();
        return new JsonResult<>(SUCCESS,OK,list);
    }

    @Resource
    private Approved_byService approved_byService;

    /**
     * 下拉框展示准字信息
     * @return
     */
    @RequestMapping(path="listapproved_by", method= RequestMethod.POST)
    public JsonResult<List<Approved_by>> listapproved_by(){
        List<Approved_by> list = approved_byService.listApprovde_by();
        return new JsonResult<>(SUCCESS,OK,list);
    }
}
