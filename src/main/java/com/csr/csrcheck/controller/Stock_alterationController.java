package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.*;
import com.csr.csrcheck.service.CompanyService;
import com.csr.csrcheck.service.ShareholderService;
import com.csr.csrcheck.service.Special_bulletinService;
import com.csr.csrcheck.service.Stock_alterationService;
import com.csr.csrcheck.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RequestMapping("stock_alteration")
//@Controller
@RestController
@Slf4j
/**
 * 查药企中的批文
 */

public class Stock_alterationController extends BaseController{
    @Resource
    private Stock_alterationService stock_alterationService;


    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

/**
     * 添加股权变更
     * @param stock_alteration
     * @return
     */

    @RequestMapping(path="addstock_alteration", method= RequestMethod.POST)
    public JsonResult<Object> addspecialb(Stock_alteration stock_alteration, @RequestParam("change_time") String date)throws ParseException {
        stock_alteration.setChange_time(sdf.parse(date));
        stock_alterationService.addStock_alteration(stock_alteration);
        log.info("add================================>approvals："+stock_alteration);
        return new JsonResult<>(SUCCESS,OK);
    }


    @Resource
    private ShareholderService shareholderService;


    /**
     * 下拉框展示产品数据
     * @return
     */
    @RequestMapping(path="listshareholder", method= RequestMethod.POST)
    public JsonResult<List<Shareholder>> listshareholder(){
        List list=shareholderService.list();
        return new JsonResult<>(SUCCESS,OK,list);
    }
    /**
     * 修改股权变更
     * @param stock_alteration
     * @return
     */
    @RequestMapping(path="updatestock_alteration", method= RequestMethod.POST)
    public JsonResult<Void> updatestock_alteration(Stock_alteration stock_alteration){
        stock_alterationService.updateStock_alteration(stock_alteration);
        return new JsonResult<>(SUCCESS,OK);
    }
    /**
     * 根据id查找股权变更
     * @param id
     * @return
     */
    @RequestMapping(path="findStock_alterationByid/{id}", method= RequestMethod.POST)
    public JsonResult<Stock_alteration> findStock_alterationByid(@PathVariable(value = "id") int id){
        Stock_alteration list=null;
        try {
            list=stock_alterationService.findstock_alterationByid(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JsonResult<>(SUCCESS,OK,list);
    }

    /**
     *根据id删除股权变更信息
     *  @param id
     * @return
     */
    @RequestMapping(path="deletestock_alteration/{id}", method= RequestMethod.POST)
    public JsonResult<Void> deletestock_alteration(@PathVariable(value = "id") int id){
        stock_alterationService.deletestock_alterationByid(id);
        log.info("删除成功-------------------------》id:"+id);
        return new JsonResult<>(SUCCESS,OK);
    }

}
