package com.csr.csrcheck.mapper;


import com.csr.csrcheck.pojo.Flight_check;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: dujianhong
 * @date: Created in 2019/10/17 20:12
 * @version:
 * @modified By:
 */
public interface Flight_checkMapper {
    /**
     * 查询查药品中的飞行检查信息
     * @param
     * @return
     */
    public List<Flight_check> getFlight_checklist();
    /**
     * 查询化妆品的飞行检查信息
     * @param
     * @return
     */
    public List<Flight_check> getFlight_checklist2();
    /**
     * 查询医疗器械的飞行检查信息
     * @param
     * @return
     */
    public List<Flight_check> getFlight_checklist3();

    /**
     * 根据企业名称,产品名称、产品类型名称、检查编号、公布日期查询
     * @param company_name
     * @param product_name
     * @param product_t_name
     * @param check_no
     * @param publication
     * @return
     */
    List<Flight_check> getListpage(@Param(value = "company_name") String company_name,
                                   @Param(value = "product_name") String product_name,
                                   @Param(value = "product_t_name") String product_t_name,
                                   @Param(value = "check_no") String check_no,
                                   @Param(value = "publication") String publication);


    /**
     * 增加
     * @param flight_check
     * @return
     */
      int addFlightcheck(Flight_check flight_check);

    /**
     * 修改
     * @param flight_check
     * @return
     */
      int updateFlightcheck(Flight_check flight_check);

    /**
     * 删除
     * @param id
     * @return
     */
      int deleteFlightcheck(int id);

    /**
     * 根据id查找
     * @param id
     * @return
     */
      Flight_check findflightByid(int id);


}
