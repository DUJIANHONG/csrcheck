package com.csr.csrcheck.pojo;

/**
 * @author Karry
 * @create 2019-10-17 10:19
 */
public class Certificate_type {
    //证书类型表

    private int id;                    //主键
    private String certificate_t_name; //类型名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCertificate_t_name() {
        return certificate_t_name;
    }

    public void setCertificate_t_name(String certificate_t_name) {
        this.certificate_t_name = certificate_t_name;
    }
}
