package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.ApprovalsMapper;
import com.csr.csrcheck.pojo.Approvals;
import com.csr.csrcheck.service.ApprovalsService;
import com.csr.csrcheck.service.ex.ApprovalsException;
import com.csr.csrcheck.service.ex.CompanyException;
import com.csr.csrcheck.util.PageResult;
import com.csr.csrcheck.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ApprovalsServiceImpl implements ApprovalsService {
    @Resource
    private ApprovalsMapper approvalsMapper;
    @Override
    public List<Approvals> getApprovalslist() {
        List<Approvals> list=approvalsMapper.getApprovalslist();
        if(list==null){
            throw new ApprovalsException("临床数据不存在");
        }
        return list;
    }

    /**
     *根据产品名称查询批文信息&分页查询
     *  @param pageNum
     * @param pageSize
     * @param product_name
     * @return
     */
    @Override
    public PageResult getApprovalslistpage(int pageNum, int pageSize, String product_name) {
        return PageUtils.getPageResult(pageNum,pageSize,getpageinfo(pageNum,pageSize,product_name));
    }

    /**
     * 增加批文
     * @param approvals
     */
    @Override
    public void addApprovals(Approvals approvals) {
        int row=approvalsMapper.addApprovals(approvals);
        if(row!=1){
            throw new CompanyException("增加失败");
        }
    }

    /**
     * 修改批文
     * @param approvals
     * @return
     */
    @Override
    public int updateApprovals(Approvals approvals) {
       int row =approvalsMapper.updateApprovals(approvals);
       if (row!=1){
           throw new CompanyException("修改失败");
       }
        return row;
    }

    /**
     * 根据id查找批文
     * @param id
     * @return
     */
    @Override
    public Approvals findapprovalsByid(int id) {
        Approvals list=approvalsMapper.findapprovalsByid(id);
        if(list==null){
            throw new CompanyException("数据为空");
        }
        return list;
    }

    @Override
    public int deleteapprovalsByid(int id) {
        int row=approvalsMapper.deleteapprovalsByid(id);
        if(row!=1){
            throw new CompanyException("删除失败");
        }
        return row;
    }

    /**
     * 调用分页插件完成分页
     * @param pageNum
     * @param pageSize
     * @param product_name
     * @return
     */
    private PageInfo<Approvals> getpageinfo(int pageNum,int pageSize,String product_name){
        PageHelper.startPage(pageNum,pageSize);
        List<Approvals> list=approvalsMapper.getpage(product_name);
        if(list==null){
            throw new CompanyException("没有数据");
        }
        return new PageInfo<Approvals>(list);
    }
}
