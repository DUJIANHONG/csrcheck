package com.csr.csrcheck.controller;

import com.csr.csrcheck.controller.ex.AppletIOException;
import com.csr.csrcheck.controller.ex.CompanyException;
import com.csr.csrcheck.pojo.*;
import com.csr.csrcheck.service.*;
import com.csr.csrcheck.util.JsonResult;
import com.csr.csrcheck.util.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequestMapping("shareholder")
//@Controller
@RestController
@Slf4j
/**
 * 查药企中的批文
 */
public class ShareholderController extends BaseController{
    @Resource
    private ShareholderService shareholderService;



    /**
     * 添加批文
     * @param shareholder
     * @return
     */
    @RequestMapping(path="addshareholder", method= RequestMethod.POST)
    public JsonResult<Object> addshareholder(Shareholder shareholder){
        shareholderService.addShareholder(shareholder);
        log.info("add================================>approvals："+shareholder);
        return new JsonResult<>(SUCCESS,OK);
    }


    @Resource
    private CompanyService companyService;

    /**
     * 下拉框展示产品数据
     * @return
     */
    @RequestMapping(path="listcompany", method= RequestMethod.POST)
    public JsonResult<List<Company>> listcompany(){
        List list=companyService.list();
        return new JsonResult<>(SUCCESS,OK,list);
    }
    /**
     * 修改股东
     * @param shareholder
     * @return
     */
    @RequestMapping(path="updateshareholder", method= RequestMethod.POST)
    public JsonResult<Void> updateshareholder(Shareholder shareholder){
        shareholderService.updateShareholder(shareholder);
        return new JsonResult<>(SUCCESS,OK);
    }
    /**
     * 根据id查找股东
     * @param id
     * @return
     */
    @RequestMapping(path="findShareholderByid/{id}", method= RequestMethod.POST)
    public JsonResult<Shareholder> findShareholderByid(@PathVariable(value = "id") int id){
        Shareholder list=null;
        try {
            list=shareholderService.findshareholderByid(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JsonResult<>(SUCCESS,OK,list);
    }
    /**
     *根据id删除股东信息
     *  @param id
     * @return
     */
    @RequestMapping(path="deleteshareholder/{id}", method= RequestMethod.POST)
    public JsonResult<Void> deleteshareholder(@PathVariable(value = "id") int id){
        shareholderService.deleteshareholderByid(id);
        log.info("删除成功-------------------------》id:"+id);
        return new JsonResult<>(SUCCESS,OK);
    }
}
