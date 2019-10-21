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
    private int approval_no;    //批文号

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

    public int getApproval_no() {
        return approval_no;
    }

    public void setApproval_no(int approval_no) {
        this.approval_no = approval_no;
    }
}
