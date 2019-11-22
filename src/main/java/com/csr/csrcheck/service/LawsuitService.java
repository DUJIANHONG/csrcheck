package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Clinic;
import com.csr.csrcheck.pojo.Lawsuit;
import com.csr.csrcheck.util.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LawsuitService {
    /**
     * 查询法律诉讼
     * @param
     * @return
     */
    public List<Lawsuit> getLawsuitlist();

    /**
     * 根据企业名称、案件类型、文书类型、被告、发布时间 分页查询法律诉讼
     * @param pageNum
     * @param pageSize
     * @param company_name
     * @param casetype
     * @param doctype
     * @param defendants
     * @param submittime
     * @return
     */
    PageResult getlistpage(int pageNum,int pageSize,String company_name,
                          String casetype,
                           String doctype,
                          String defendants,
                          String submittime);

    /**
     * 增加
     * @param lawsuit
     * @return
     */
    int addlawsuit(Lawsuit lawsuit);
    /**
     * 修改
     * @param lawsuit
     * @return
     */
    int updatelawsuit(Lawsuit lawsuit);
    /**
     * 删除
     * @param id
     * @return
     */
    int deletelawsuit(int id);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    Lawsuit findlawsuit(int id);
}
