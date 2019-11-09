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

    List<Lawsuit> getListpage(@Param(value = "company_name") String company_name,
                              @Param(value = "casetype") String casetype,
                              @Param(value = "doctype") String doctype,
                              @Param(value = "defendants") String defendants,
                              @Param(value = "submittime") String submittime);
}
