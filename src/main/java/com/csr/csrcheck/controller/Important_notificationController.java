package com.csr.csrcheck.controller;

import com.csr.csrcheck.controller.ex.CompanyException;
import com.csr.csrcheck.pojo.Important_notification;
import com.csr.csrcheck.pojo.Product;
import com.csr.csrcheck.service.Important_notificationService;
import com.csr.csrcheck.service.impl.Important_notificationServiceImpl;
import com.csr.csrcheck.util.JsonResult;
import com.csr.csrcheck.util.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/9 15:17
 * @version:
 * @modified By:
 */
@Controller
@Slf4j
@RequestMapping("important_notific")
public class Important_notificationController extends BaseController {

    @Resource
    private Important_notificationServiceImpl important_notificationService;

    /**
     *根据产品名称分页查询重要通报
     *  @param pageNum
     * @param pageSize
     * @param product_name
     * @param product_t_name
     * @return
     */
    @ResponseBody
    @RequestMapping("important")
    public JsonResult<Object> important(@RequestParam(defaultValue = "1") int pageNum,
                                        @RequestParam(defaultValue = "5") int pageSize,
                                        String product_name, String product_t_name){
        PageResult pageResult=important_notificationService.getimportant_page(pageNum,pageSize,product_name,product_t_name);
        if(pageResult==null){
            throw new CompanyException("数据为空");
        }
        log.info("important----------------------------->pageNum:"+pageNum);
        log.info("important----------------------------->pageSize:"+pageSize);
        log.info("important----------------------------->product_name:"+product_name);
        log.info("important----------------------------->product_t_name:"+product_t_name);
        return new JsonResult<>(code,OK,pageResult);
    }
    /**
     * 跳转到添加页面
     * @param model
     * @return
     */
    @RequestMapping("addimportant")
    public String selectproduct(Model model){
        List<Product> list = important_notificationService.selectproduct();
        model.addAttribute("product",list);
        return "addimportant";
    }

    /**
     * 保存新增产品重要通报信息
     * @param important_notification
     * @return
     */
    @ResponseBody
    @RequestMapping(path="saveaddimportant", method= RequestMethod.POST)
    public JsonResult<Void> addimportant(Important_notification important_notification){
        int result = important_notificationService.addimportant(important_notification);
        if (result == 1){
            log.info("添加产品重要通报信息成功！");
        }else {
            log.info("出现问题！");
        }
        return new JsonResult<>(code,OK);
    }

    /**
     * 根据id查询要修改的信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(path = "updateimportant/{id}", method = RequestMethod.GET)
    public String updateAbnormal(@PathVariable(value = "id") int id, Model model) {
        Important_notification important_notification = important_notificationService.selectByimportant_id(id);
        List<Product> product = important_notificationService.selectproduct();
        model.addAttribute("important",important_notification);
        model.addAttribute("product",product);
        return "updateimportant";
    }

    /**
     * 保存修改产品重要通报信息
     * @param important_notification
     * @return
     */
    @ResponseBody
    @RequestMapping(path="saveimportant", method= RequestMethod.POST)
    public JsonResult<Void> updateimportant(Important_notification important_notification) {
        int result = important_notificationService.updateimportant(important_notification);
        if (result == 1){
            log.info("修改成功");
        }else {
            log.info("修改失败");
        }
        return new JsonResult<>(code,OK);
    }
    /**
     * 根据产品重要通报id删除
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(path = "deleteimportant/{id}", method = RequestMethod.POST)
    public JsonResult<Object> deleteimportant( @PathVariable(value = "id") int id) {
        int result = important_notificationService.deleteimportantByid(id);
        if (result ==1){
            log.info("删除成功！");
        }else {
            log.info("删除失败！");
        }
        return new JsonResult<>(code,OK);
    }
}
