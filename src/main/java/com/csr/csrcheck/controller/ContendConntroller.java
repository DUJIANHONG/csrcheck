package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.pojo.Contend;
import com.csr.csrcheck.service.CompanyService;
import com.csr.csrcheck.service.ContendService;
import com.csr.csrcheck.service.ex.CompanyException;
import com.csr.csrcheck.util.JsonResult;
import com.csr.csrcheck.util.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Karry
 * @create 2019-10-22 14:05
 */
@Slf4j
@RestController
@RequestMapping("contend")
public class ContendConntroller extends BaseController {
    @Resource
    private ContendService contendService;
    @GetMapping("contendlist")
    public JsonResult<List<Contend>> getlistByCompany_id(){
        List<Contend> list = contendService.getContendList();
        return new JsonResult<>(SUCCESS,OK,list);
    }

    /**
     *根据药企名称分页查询药企核心竞争力动态信息
     *  @param pageNum
     * @param pageSize
     * @param company_name
     * @return
     */
    @GetMapping("contend")
    public JsonResult<Object> contend(@RequestParam(defaultValue = "1") int pageNum,
                                      @RequestParam(defaultValue = "5") int pageSize,
                                      String company_name){
        PageResult pageResult=contendService.getListpage(pageNum,pageSize,company_name);
        log.info("contend---------------------------------->pageNum:"+pageNum);
        log.info("contend---------------------------------->pageSize:"+pageSize);
        log.info("contend---------------------------------->company_name:"+company_name);
        return new JsonResult<>(SUCCESS,OK,pageResult);
    }

    /**
     * 增加核心竞争力
     * @param contend
     * @return
     */
    @RequestMapping(path = "addcontend",method = RequestMethod.POST)
    public JsonResult<Void> addcontend(Contend contend){
        contendService.addcontend(contend);
        return new JsonResult<>(SUCCESS,OK);
    }
    /**
     * 修改核心竞争力
     * @param contend
     * @return
     */
    @RequestMapping(path = "updatecontend",method = RequestMethod.POST)
    public JsonResult<Void> updatecontend(Contend contend){
        contendService.updatecontend(contend);
        return new JsonResult<>(SUCCESS,OK);
    }

    /**
     * 删除核心竞争力
     * @param id
     * @return
     */
    @RequestMapping(path = "deletecontend/{id}",method = RequestMethod.POST)
    public JsonResult<Void> deletecontend(@PathVariable(value = "id") int id){
        contendService.deletecontend(id);
        return new JsonResult<>(SUCCESS,OK);
    }

    /**
     * 根据id查看核心竞争力
     * @param id
     * @return
     */
    @RequestMapping(path = "findcontendByid/{id}",method = RequestMethod.POST)
    public JsonResult<Contend> findcontendByid(@PathVariable(value = "id") int id){
        Contend contend=contendService.findcontendByid(id);
        if(contend==null){
            throw new CompanyException("数据为空");
        }
        return new JsonResult<>(SUCCESS,OK,contend);
    }

    @Resource
    private CompanyService companyService;

    /**
     *下拉框展示企业数据
     *  @return
     */
    @RequestMapping(path = "showcompany",method = RequestMethod.POST)
    public JsonResult<List<Company>> showcompany(){
        List<Company> list = companyService.getCommpanylist();
        return new JsonResult<>(SUCCESS,OK,list);
    }
}

