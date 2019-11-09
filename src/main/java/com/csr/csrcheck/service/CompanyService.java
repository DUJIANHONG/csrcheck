package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.util.PageResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/10/15 11:22
 * @version:
 * @modified By:
 */
public interface CompanyService {
    /**
     * 查询公司信息
     * @param
     * @return
     */
    public List<Company> getCommpanylist();


    /**
     *根据公司名称模糊查询公司信息
     *  @param company_name
     * @return
     */
    public List<Company> getCommpanylistbyname(@Param(value = "company_name") String company_name);

    /**
     *  分页查询接口
     *  这里统一封装了分页请求和结果，避免直接引入具体框架的分页对象, 如MyBatis或JPA的分页对象
     *  从而避免因为替换ORM框架而导致服务层、控制层的分页接口也需要变动的情况，替换ORM框架也不会
     *  影响服务层以上的分页接口，起到了解耦的作用
     * @param
     * @return PageResult 自定义，统一分页查询结果
     */
    PageResult findPage(int pageNum,int pageSize,String company_name);

    /**
     * 根据公司名称模糊分页查询后台展示
     * @param company_name
     * @param currentPageNo
     * @param pageSize
     * @return
     */
    List<Company> getCommpanylistpage(@Param(value = "company_name") String company_name,
                                      @Param(value = "currentPageNo") Integer currentPageNo,
                                      @Param(value = "pageSize") Integer pageSize);


    /**
     * 查询公司数量
     * @param company_name
     * @return
     */
    int getCompanyCount(@Param(value = "company_name") String company_name);


    //查询公司特别公告
    public List<Special_bulletin> getAll();
}
