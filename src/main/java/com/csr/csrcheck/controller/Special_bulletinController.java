package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.pojo.Shareholder;
import com.csr.csrcheck.pojo.Special_bulletin;
import com.csr.csrcheck.pojo.Stock_alteration;
import com.csr.csrcheck.service.CompanyService;
import com.csr.csrcheck.service.ShareholderService;
import com.csr.csrcheck.service.Special_bulletinService;
import com.csr.csrcheck.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RequestMapping("specialb")
//@Controller
@RestController
@Slf4j
/**
 * 查药企中的特别公告
 */
public class Special_bulletinController extends BaseController{
    @Resource
    private Special_bulletinService special_bulletinService;


    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * 添加特别公告
     * @param special_bulletin
     * @return
     */
    @RequestMapping(path="addspecialb", method= RequestMethod.POST)
    public JsonResult<Object> addspecialb(Special_bulletin special_bulletin, @RequestParam("release_time") String date)throws ParseException{
       special_bulletin.setRelease_time(sdf.parse(date));
        special_bulletinService.addSpecial_bulletin(special_bulletin);
        log.info("add================================>approvals："+special_bulletinService);
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
     * 修改特别公告
     * @param special_bulletin
     * @return
     */
    @RequestMapping(path="updatespecial", method= RequestMethod.POST)
    public JsonResult<Void> updatespecial(Special_bulletin special_bulletin){
        special_bulletinService.updateSpecial_bulletin(special_bulletin);
        return new JsonResult<>(SUCCESS,OK);
    }
    /**
     * 根据id查找特别公告
     * @param id
     * @return
     */
    @RequestMapping(path="findSpecialByid/{id}", method= RequestMethod.POST)
    public JsonResult<Special_bulletin> findStock_alterationByid(@PathVariable(value = "id") int id){
        Special_bulletin list=null;
        try {
            list=special_bulletinService.findspecial_bulletinByid(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JsonResult<>(SUCCESS,OK,list);
    }

    /**
     *根据id删除特别公告信息
     *  @param id
     * @return
     */
    @RequestMapping(path="deletespeciall/{id}", method= RequestMethod.POST)
    public JsonResult<Void> deletespecial(@PathVariable(value = "id") int id){
        special_bulletinService.deletespecial_bulletinByid(id);
        log.info("删除成功-------------------------》id:"+id);
        return new JsonResult<>(SUCCESS,OK);
    }
}
