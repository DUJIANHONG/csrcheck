package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.ContendMapper;
import com.csr.csrcheck.pojo.Contend;
import com.csr.csrcheck.service.ContendService;
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
public class ContendServiceImpl implements ContendService {
    @Resource
    private ContendMapper contendMapper;


    @Override
    public List<Contend> getContendList() {
        List<Contend> list=contendMapper.getContendList();
        if(list==null){
            throw new ApprovalsException("药企核心竞争力动态信息数据不存在");
        }
        return list;
    }

    @Override
    public PageResult getListpage(int pageNum, int pageSize, String company_name) {
        return PageUtils.getPageResult(pageNum,pageSize,getPageInfo(pageNum,pageSize,company_name));
    }

    @Override
    public int addcontend(Contend contend) {
        int row=contendMapper.addcontend(contend);
        if(row!=1){
            throw new CompanyException("增加失败");
        }
        return row;
    }

    @Override
    public int updatecontend(Contend contend) {
        int row=contendMapper.updatecontend(contend);
        if(row!=1){
            throw new CompanyException("修改失败");
        }
        return row;
    }

    @Override
    public int deletecontend(int id) {
        int row=contendMapper.deletecontend(id);
        if(row!=1){
            throw new CompanyException("删除失败");
        }
        return row;
    }

    @Override
    public Contend findcontendByid(int id) {
        return contendMapper.findcontendByid(id);
    }

    /**
     * 调用分页插件完成分页
     * @param pageNum
     * @param pageSize
     * @param company_name
     * @return
     */
    private PageInfo<Contend> getPageInfo(int pageNum,int pageSize,String company_name){
        PageHelper.startPage(pageNum,pageSize);
        List<Contend> list =contendMapper.getContendListpage(company_name);
        if(list==null){
            throw new CompanyException("数据为空");
        }
        return new PageInfo<>(list);
    }
}
