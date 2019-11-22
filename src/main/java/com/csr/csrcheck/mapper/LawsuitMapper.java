package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Clinic;
import com.csr.csrcheck.pojo.Lawsuit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LawsuitMapper {
    /**
     * 查询法律诉讼
     * @param
     * @return
     */
    public List<Lawsuit> getLawsuitlist();

    /**
     * 根据企业名称、案件类型、文书类型、被告、发布时间 分页查询法律诉讼
     * @param company_name
     * @param casetype
     * @param doctype
     * @param defendants
     * @param submittime
     * @return
     */
    List<Lawsuit> getListpage(@Param(value = "company_name") String company_name,
                              @Param(value = "casetype") String casetype,
                              @Param(value = "doctype") String doctype,
                              @Param(value = "defendants") String defendants,
                              @Param(value = "submittime") String submittime);

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
