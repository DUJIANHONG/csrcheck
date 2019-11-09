package com.csr.csrcheck.pojo;

public class Business_risks {
    private int id ;//主键（经营风险表）
    private int risk_type;//风险分类
    private String title ;//标题
    private String describe;//描述
    private int  type_id;//风险类型（例：1-严重违法，3-失信（人）公司，5-被执行（人）公司，）
    private int company_id;//关联公司的id

    /**
     * 自定义字段
     * @return
     */
    private String risk_classify_name ;//风险分类的名称
    private String  risk_type_name ;//风险类型名称
    private String company_name;        //公司名称

    private  Company company;     //公司
    private Risk_type risktype;   //风险类型
    private Risk_classify risk_classify;//风险分类

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Risk_type getRisktype() {
        return risktype;
    }

    public void setRisktype(Risk_type risktype) {
        this.risktype = risktype;
    }

    public Risk_classify getRisk_classify() {
        return risk_classify;
    }

    public void setRisk_classify(Risk_classify risk_classify) {
        this.risk_classify = risk_classify;
    }

    public String getRisk_classify_name() {
        return risk_classify_name;
    }

    public void setRisk_classify_name(String risk_classify_name) {
        this.risk_classify_name = risk_classify_name;
    }

    public String getRisk_type_name() {
        return risk_type_name;
    }

    public void setRisk_type_name(String risk_type_name) {
        this.risk_type_name = risk_type_name;
    }

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

    public int getRisk_type() {
        return risk_type;
    }

    public void setRisk_type(int risk_type) {
        this.risk_type = risk_type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }
}
