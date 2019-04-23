package com.eagle.order.service.impl;

import com.eagle.order.mapper.TransferCompanyMapper;
import com.eagle.order.po.Client;
import com.eagle.order.po.ClientExample;
import com.eagle.order.po.TransferCompany;
import com.eagle.order.po.TransferCompanyExample;
import com.eagle.order.service.TransferCompanyService;
import com.eagle.order.util.CommonBeanUtils;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.ClientVO;
import com.eagle.order.vo.TransferCompanyVO;
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
    public ReturnResult<PageInfo<TransferCompanyVO>> queryList(QueryData<TransferCompanyVO> queryData) {
        PageInfo pageInfo = queryData.getPageInfo();
        TransferCompanyVO transferCompanyVO = queryData.getParam();
        TransferCompanyExample transferCompanyExample = new TransferCompanyExample();
        TransferCompanyExample.Criteria criteria = transferCompanyExample.createCriteria();
        if(!Strings.isNullOrEmpty(transferCompanyVO.getName())){
            criteria.andNameLike("%" + transferCompanyVO.getName() + "%");
        }
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        List<TransferCompany> transferCompanies = transferCompanyMapper.selectByExample(transferCompanyExample);
        List<TransferCompanyVO> transferCompanyVOS = CommonBeanUtils.copyList(transferCompanies, TransferCompanyVO.class);
        PageInfo<TransferCompanyVO> resultInfo = new PageInfo<TransferCompanyVO>(transferCompanyVOS);
        return ReturnResult.ok(resultInfo);
    }
}
