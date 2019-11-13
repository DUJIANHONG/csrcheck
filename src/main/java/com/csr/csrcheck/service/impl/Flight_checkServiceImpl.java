package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.Flight_checkMapper;
import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.pojo.Flight_check;
import com.csr.csrcheck.service.IFlight_checkService;
import com.csr.csrcheck.service.ex.CompanyException;
import com.csr.csrcheck.service.ex.Flight_checkException;
import com.csr.csrcheck.util.PageResult;
import com.csr.csrcheck.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class Flight_checkServiceImpl implements IFlight_checkService {
    @Resource
    private Flight_checkMapper flight_checkMapper;
    @Override
    public List<Flight_check> getFlight_checklist() {
        List<Flight_check> list=flight_checkMapper.getFlight_checklist();
        if(list==null){
            throw new Flight_checkException("药企中的数据不存在");
        }
        return list;
    }

    @Override
    public List<Flight_check> getFlight_checklist2() {
        List<Flight_check> list=flight_checkMapper.getFlight_checklist2();
        if(list==null){
            throw new Flight_checkException("化妆品中的数据不存在");
        }
        return list;
    }

    @Override
    public List<Flight_check> getFlight_checklist3() {
        List<Flight_check> list=flight_checkMapper.getFlight_checklist3();
        if(list==null){
            throw new Flight_checkException("化妆品中的数据不存在");
        }
        return list;
    }

    @Override
    public PageResult getListpage(int pageNum, int pageSize,String company_name, String product_name,
                                  String product_t_name, String check_no, String publication) {
        return PageUtils.getPageResult(pageNum,pageSize,getPageInfo(pageNum,pageSize,company_name,product_name,product_t_name,check_no,publication));
    }


    /**
     * 调用分页插件完成分页
     * @param pageNum
     * @param pageSize
     * @param company_name
     * @param product_name
     * @param product_t_name
     * @param check_no
     * @param publication
     * @return
     */
    private PageInfo<Flight_check> getPageInfo(
                                                int pageNum,
                                               int pageSize,
                                                String company_name,
                                                String product_name,
                                                String product_t_name,
                                                String check_no,
                                                String publication ){
        PageHelper.startPage(pageNum,pageSize);
        List<Flight_check> list=flight_checkMapper.getListpage(company_name,product_name,product_t_name,check_no,publication);
        if(list==null){
            throw new CompanyException("没有数据");
        }
        return new PageInfo<>(list);
    }

}
