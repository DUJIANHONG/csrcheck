package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Product;

import java.util.List;

public interface MilitaryMapper {
    /**
     * 查询医疗器械中的国产器械信息
     * @return
     */
    public List<Product> getMilitarylist();
    /**
     * 查询医疗器械中的进口器械信息
     * @return
     */
    public List<Product> getMilitarylist2();

}
