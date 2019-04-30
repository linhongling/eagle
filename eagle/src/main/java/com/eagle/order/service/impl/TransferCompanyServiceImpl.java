package com.eagle.order.service.impl;

import com.eagle.order.mapper.TransferCompanyMapper;
import com.eagle.order.domain.TransferCompany;
import com.eagle.order.domain.TransferCompanyExample;
import com.eagle.order.service.TransferCompanyService;
import com.eagle.order.util.CommonBeanUtils;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/4/22
 */
@Service
public class TransferCompanyServiceImpl implements TransferCompanyService {

    @Autowired
    private TransferCompanyMapper transferCompanyMapper;

    @Override
    public ReturnResult<PageInfo<TransferCompany>> queryList(QueryData<TransferCompany> queryData) {
        PageInfo pageInfo = queryData.getPageInfo();
        TransferCompany transferCompany = queryData.getParam();
        TransferCompanyExample transferCompanyExample = new TransferCompanyExample();
        TransferCompanyExample.Criteria criteria = transferCompanyExample.createCriteria();
        if(!Strings.isNullOrEmpty(transferCompany.getName())){
            criteria.andNameLike("%" + transferCompany.getName() + "%");
        }
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        List<TransferCompany> transferCompanies = transferCompanyMapper.selectByExample(transferCompanyExample);
        PageInfo<TransferCompany> resultInfo = new PageInfo<TransferCompany>(transferCompanies);
        return ReturnResult.ok(resultInfo);
    }
}
