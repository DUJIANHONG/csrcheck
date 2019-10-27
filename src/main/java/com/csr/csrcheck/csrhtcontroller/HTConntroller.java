package com.csr.csrcheck.csrhtcontroller;

import com.csr.csrcheck.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/10/27 14:52
 * @version:
 * @modified By:
 */
@RequestMapping("csrht")
@Controller
public class HTConntroller extends BaseController {

    /**
     * 公司信息页面
     * @return
     */
    @RequestMapping("company")
    public String Company(){
        return "company";
    }

}
