package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Clinic;
import com.csr.csrcheck.pojo.Product;
import com.csr.csrcheck.service.ClinicService;
import com.csr.csrcheck.service.ProductService;
import com.csr.csrcheck.service.ex.ClinicException;
import com.csr.csrcheck.util.JsonResult;
import com.csr.csrcheck.util.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequestMapping("clinic")
//@Controller
@RestController
@Slf4j
/**
 * 查药企中的临床
 */
public class ClinicController extends BaseController{
    @Resource
    private ClinicService clinicService;
    @GetMapping("cliniclist")
    public JsonResult<List<Clinic>> Flight_checklist(HttpServletResponse response) throws IOException, ServletException {
        List<Clinic> list = clinicService.getCliniclist();
        if (list==null){
            throw new ClinicException("没有数据");
        }

        return new JsonResult<>(code,OK,list);
    }

    /**
     * 根据产品名称分页查询临床
     * @param pageNum
     * @param pageSize
     * @param product_name
     * @return
     */
    @GetMapping("clinic")
    public JsonResult<Object> clinic(@RequestParam(defaultValue = "1") int pageNum,
                                     @RequestParam(defaultValue = "5") int pageSize, String product_name){
        PageResult pageResult=clinicService.getListpage(pageNum,pageSize,product_name);
        log.info("clinic---------------------------->pageNum:"+pageNum);
        log.info("clinic---------------------------->pageSize:"+pageSize);
        log.info("clinic---------------------------->product_name:"+product_name);
        return new JsonResult<>(code,OK,pageResult);
    }

    /**
     * 添加临床
     * @param clinic
     * @return
     */
    @RequestMapping(path="addclinic", method= RequestMethod.POST)

    public JsonResult<Object> addclinic(Clinic clinic){
        clinicService.addClinic(clinic);
        log.info("add================================>approvals："+clinic);
        return new JsonResult<>(code,OK);
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
        return new JsonResult<>(code,OK,list);
    }

    /**
     * 修改临床
     * @param clinic
     * @return
     */
    @RequestMapping(path="updateclinic", method= RequestMethod.POST)
    public JsonResult<Void> updateclinic(Clinic clinic){
        clinicService.updateClinic(clinic);
        return new JsonResult<>(code,OK);
    }
    /**
     * 根据id查找临床
     * @param id
     * @return
     */
    @RequestMapping(path="findClinicByid/{id}", method= RequestMethod.POST)
    public JsonResult<Clinic> findCompanyByid(@PathVariable(value = "id") int id){
        Clinic list=null;
        try {
            list=clinicService.findclinicByid(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JsonResult<>(code,OK,list);
    }

    /**
     *根据id删除临床信息
     *  @param id
     * @return
     */
    @RequestMapping(path="deleteclinic/{id}", method= RequestMethod.POST)
    public JsonResult<Void> deleteclinic(@PathVariable(value = "id") int id){
        clinicService.deleteclinicByid(id);
        log.info("删除成功-------------------------》id:"+id);
        return new JsonResult<>(code,OK);
    }
}
