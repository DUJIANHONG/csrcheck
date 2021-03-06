package com.csr.csrcheck.pojo;

/**
 * @author Karry
 * @create 2019-10-21 16:11
 */
public class Approvals {
    //批文表

    private int id;             //主键
    private int approval_num;   //批文编号
    private int product_id;     //关联产品id
    private String approval_no;    //批文号
    private int approved_by;    //所属准字

    /**
     * 自定义字段
     * @return
     */
   /* private String approved_t_name;  //准字类型名称
    private String product_name;        //产品名称
    private String company_name;        //公司名称*/

    private Approved_by approvedby;    //准字类型
    private Product product;           //产品
    private Company company;

    public Approved_by getApprovedby() {
        return approvedby;
    }

    public void setApprovedby(Approved_by approvedby) {
        this.approvedby = approvedby;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

  /*  public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getApproved_t_name() {
        return approved_t_name;
    }

    public void setApproved_t_name(String approved_t_name) {
        this.approved_t_name = approved_t_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApproval_num() {
        return approval_num;
    }

    public void setApproval_num(int approval_num) {
        this.approval_num = approval_num;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getApproval_no() {
        return approval_no;
    }

    public void setApproval_no(String approval_no) {
        this.approval_no = approval_no;
    }

    public int getApproved_by() {
        return approved_by;
    }

    public void setApproved_by(int approved_by) {
        this.approved_by = approved_by;
    }
}
