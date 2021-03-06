package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Actual_controller;
import com.csr.csrcheck.pojo.Approvals;
import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.pojo.Special_bulletin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/10/14 16:23
 * @version:
 * @modified By:
 */
public interface CompanyMapper {

    /**
     * 查询公司信息
     * @param
     * @return
     */
    public List<Company> getCommpanylist( );

    /**
     * 根据公司名称模糊查询
     * @param company_name
     * @return
     */
    public List<Company> getCommpanylistbyname(@Param(value = "company_name") String company_name);

    /**
     * 分页查询所有信息(公司名称模糊查询)
     * @return
     */
    public List<Company> getCompanyPage(@Param(value = "company_name") String company_name);

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


    //查询公司特别公告
    public List<Special_bulletin> getAll();



    /**
     * 查询公司数量
     * @param company_name
     * @return
     */
     int getCompanyCount(@Param(value = "company_name") String company_name);

    /**
     * 下拉框显示公司信息
     * @return
     */
    List<Company> getCommpanyByid();
    /**
     * 增加批文
     * @param company
     * @return
     */
    public int addCommpany(Company company);

    /**
     *查询id和名称
     *  @return
     */
    List<Company> list();

    /**
     * 修改公司信息
     * @param company
     * @return
     */
    int updateCompany(Company company);

    /**
     * 根据id查找公司
     * @param id
     * @return
     */
    Company findcompanyByid(int id);

    /**
     *根据id删除公司
     *  @param id
     * @return
     */
    int deletecompanyByid(int id);
}
