package com.csr.csrcheck.service;


import com.csr.csrcheck.pojo.Abnormal_products;
import com.csr.csrcheck.pojo.Product;

import java.util.List;

public interface MilitaryService {
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

    /**
     * 查询医疗器械合法厂家
     */
    public List<Product> getAllLegitimate_producers(int product_t_id);

    /**
     * 查询医疗器械不合格通报
     */
    public List<Abnormal_products> getAllabnormal_products(int product_t_id);
}
