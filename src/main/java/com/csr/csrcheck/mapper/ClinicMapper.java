package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Clinic;
import com.csr.csrcheck.pojo.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClinicMapper {
    /**
     * 查询临床信息
     * @param
     * @return
     */
    public List<Clinic> getCliniclist( );


    public List<Clinic> getCliniclistpage(@Param(value = "product_name") String product_name);

    /**
     * 增加临床
     * @param clinic
     * @return
     */
    public int addClinic(Clinic clinic);
    /**
     *查询id和名称
     *  @return
     */
    List<Company> list();

    /**
     * 修改临床信息
     * @param clinic
     * @return
     */
    int updateClinic(Clinic clinic);

    /**
     * 根据id查找临床
     * @param id
     * @return
     */
    Clinic findclinicByid(int id);

    /**
     *根据id删除临床
     *  @param id
     * @return
     */
    int deleteclinicByid(int id);
}
