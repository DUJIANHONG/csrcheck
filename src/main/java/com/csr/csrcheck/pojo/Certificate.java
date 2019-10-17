package com.csr.csrcheck.pojo;

import java.util.Date;

/**
 * @author Karry
 * @create 2019-10-17 10:09
 */
public class Certificate {
    //证书表

    private int id;                //主键
    private int type_id;           //证书类型
    private String certificate_no; //营业执照编号或者许可证编号
    private String governed_body;  //受管辖机构
    private Date expiration_time;  //证书有效期限

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getCertificate_no() {
        return certificate_no;
    }

    public void setCertificate_no(String certificate_no) {
        this.certificate_no = certificate_no;
    }

    public String getGoverned_body() {
        return governed_body;
    }

    public void setGoverned_body(String governed_body) {
        this.governed_body = governed_body;
    }

    public Date getExpiration_time() {
        return expiration_time;
    }

    public void setExpiration_time(Date expiration_time) {
        this.expiration_time = expiration_time;
    }
}
