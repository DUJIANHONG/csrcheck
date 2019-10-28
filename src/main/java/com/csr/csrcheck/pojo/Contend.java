package com.csr.csrcheck.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Contend {
    private int  id;//竞争力ID
    private int company_id;//公司ID
    private String  technology;//具备创新的技术
    private String  talent ; //具备创新能力的人才
    private String  culture ;//优秀的企业文化
    private String   supervise;//企业的规范化管理
    private String   resource;//资源竞争分析
    private String   rival;//竞争对手分析
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date time ;//时间
    private String   outline ;//点击查看竞争力信息

    /**
     * 自定义字段
     * @return
     */
    private String company_name;        //公司名称

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getTalent() {
        return talent;
    }

    public void setTalent(String talent) {
        this.talent = talent;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getSupervise() {
        return supervise;
    }

    public void setSupervise(String supervise) {
        this.supervise = supervise;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getRival() {
        return rival;
    }

    public void setRival(String rival) {
        this.rival = rival;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }
}
