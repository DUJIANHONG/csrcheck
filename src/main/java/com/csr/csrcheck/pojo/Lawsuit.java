package com.csr.csrcheck.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Lawsuit {
    private int id ;//主键（法律诉讼）
    private int  company_id;//相关公司id
    private String  plaintiffs;//原告
    private String court;//法院
    private String casereason;//案由
    private String url;//原文链接地址
    private String caseno;//案号
    private String title;//标题
    private String abstracts;//摘要
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date submittime;//发布时间
    private String lawsuitUrl ;//药企通显示url
    private String casetype;//案件类型
    private String doctype;// 文书类型
    private String agent;//代理人
    private String thirdParties;//第三人
    private String defendants;//被告

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

    public String getPlaintiffs() {
        return plaintiffs;
    }

    public void setPlaintiffs(String plaintiffs) {
        this.plaintiffs = plaintiffs;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }

    public String getCasereason() {
        return casereason;
    }

    public void setCasereason(String casereason) {
        this.casereason = casereason;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCaseno() {
        return caseno;
    }

    public void setCaseno(String caseno) {
        this.caseno = caseno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public Date getSubmittime() {
        return submittime;
    }

    public void setSubmittime(Date submittime) {
        this.submittime = submittime;
    }

    public String getLawsuitUrl() {
        return lawsuitUrl;
    }

    public void setLawsuitUrl(String lawsuitUrl) {
        this.lawsuitUrl = lawsuitUrl;
    }

    public String getCasetype() {
        return casetype;
    }

    public void setCasetype(String casetype) {
        this.casetype = casetype;
    }

    public String getDoctype() {
        return doctype;
    }

    public void setDoctype(String doctype) {
        this.doctype = doctype;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getThirdParties() {
        return thirdParties;
    }

    public void setThirdParties(String thirdParties) {
        this.thirdParties = thirdParties;
    }

    public String getDefendants() {
        return defendants;
    }

    public void setDefendants(String defendants) {
        this.defendants = defendants;
    }
}
