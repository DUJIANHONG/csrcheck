package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Flight_check;
import com.csr.csrcheck.util.PageResult;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface IFlight_checkService {
    /**
     * 查询飞行检查信息
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
   PageResult getListpage( int pageNum,
                           int pageSize,
                            String company_name,
                            String product_name,
                            String product_t_name,
                            String check_no,
                           String publication);

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
