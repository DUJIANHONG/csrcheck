package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.LawsuitMapper;
import com.csr.csrcheck.pojo.Lawsuit;
import com.csr.csrcheck.service.LawsuitService;
import com.csr.csrcheck.service.ex.CompanyException;
import com.csr.csrcheck.service.ex.LawsuitException;
import com.csr.csrcheck.util.PageResult;
import com.csr.csrcheck.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LawsuitServiceImpl implements LawsuitService {
    @Resource
    private LawsuitMapper lawsuitMapper;




    @Override
    public List<Lawsuit> getLawsuitlist() {
        List<Lawsuit> list=lawsuitMapper.getLawsuitlist();
        if(list==null){
            throw new LawsuitException("法律诉讼不存在");
        }
        return list;
    }

    /**
     * 根据企业名称、案件类型、文书类型、被告、发布时间 分页查询法律诉讼
     * @param pageNum
     * @param pageSize
     * @param company_name
     * @param casetype
     * @param doctype
     * @param defendants
     * @param submittime
     * @return
     */
    @Override
    public PageResult getlistpage(int pageNum, int pageSize, String company_name, String casetype, String doctype, String defendants, String submittime) {
        return PageUtils.getPageResult(pageNum,pageSize,getPageInfo(pageNum,pageSize,company_name,casetype,doctype,defendants,submittime));
    }

    @Override
    public List<Lawsuit> getlistpages(String company_name, String casetype, String doctype, String defendants, String submittime) {
        List<Lawsuit> list=lawsuitMapper.getListpage(company_name,casetype,doctype,defendants,submittime);
        if(list==null){
            throw new CompanyException("数据为空");
        }
        return list;
    }

    @Override
    public int addlawsuit(Lawsuit lawsuit) {
        int row = lawsuitMapper.addlawsuit(lawsuit);
        if(row!=1){
            throw new CompanyException("增加失败");
        }
        return row;
    }

    @Override
    public int updatelawsuit(Lawsuit lawsuit) {
        int row = lawsuitMapper.updatelawsuit(lawsuit);
        if (row != 1) {
            throw new CompanyException("修改失败");
        }
        return row;
    }

    @Override
    public int deletelawsuit(int id) {
        int row = lawsuitMapper.deletelawsuit(id);
        if (row != 1) {
            throw new CompanyException("删除失败");
        }
        return row;
    }

    @Override
    public Lawsuit findlawsuit(int id) {
        return lawsuitMapper.findlawsuit(id);
    }

    @Override
    public int count() {
        return lawsuitMapper.count();
    }


    /**
     *调用分页插件完成分页
     *  @param pageNum
     * @param pageSize
     * @param company_name
     * @param casetype
     * @param doctype
     * @param defendants
     * @param submittime
     * @return
     */
    private PageInfo<Lawsuit> getPageInfo(int pageNum, int pageSize, String company_name, String casetype,
                                          String doctype, String defendants, String submittime){
        PageHelper.startPage(pageNum,pageSize);
        List<Lawsuit> list=lawsuitMapper.getListpage(company_name,casetype,doctype,defendants,submittime);
        if (list==null) {
            throw new CompanyException("数据为空");
        }
        return new PageInfo<>(list);
    }
}
