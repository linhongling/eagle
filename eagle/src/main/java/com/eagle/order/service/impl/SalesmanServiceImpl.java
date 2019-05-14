package com.eagle.order.service.impl;

import com.eagle.order.domain.Goods;
import com.eagle.order.domain.GoodsExample;
import com.eagle.order.domain.Salesman;
import com.eagle.order.domain.SalesmanExample;
import com.eagle.order.mapper.SalesmanMapper;
import com.eagle.order.service.SalesmanService;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.SalesmanInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/5/14
 */
@Service
public class SalesmanServiceImpl implements SalesmanService {

    @Autowired
    private SalesmanMapper salesmanMapper;

    @Override
    public ReturnResult<PageInfo<Salesman>> queryList(QueryData<Salesman> queryData) {
        PageInfo pageInfo = queryData.getPageInfo();
        Salesman salesman = queryData.getParam();
        SalesmanExample salesmanExample = new SalesmanExample();
        salesmanExample.setOrderByClause("IS_VALIDATE DESC, CREATE_DATE DESC");
        SalesmanExample.Criteria criteria = salesmanExample.createCriteria();
        if (!Strings.isNullOrEmpty(salesman.getName())) {
            criteria.andNameLike("%" + salesman.getName() + "%");
        }
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        List<Salesman> salesmanListList = salesmanMapper.selectByExample(salesmanExample);
        PageInfo<Salesman> resultInfo = new PageInfo<Salesman>(salesmanListList);
        return ReturnResult.ok(resultInfo);
    }

    @Override
    public ReturnResult<Salesman> getDtail(Long id) {
        Salesman salesman = salesmanMapper.selectByPrimaryKey(id);
        return ReturnResult.ok(salesman);
    }

    @Override
    public ReturnResult<Integer> saveSalesman(Salesman salesman) {
        salesman.setCreateDate(new Date());
        int num = salesmanMapper.insert(salesman);
        return ReturnResult.ok(num);
    }

    @Override
    public ReturnResult<Integer> updateSalesman(Salesman salesman) {
        salesman.setModifyDate(new Date());
        int num = salesmanMapper.updateByPrimaryKey(salesman);
        return ReturnResult.ok(num);
    }

    @Override
    public ReturnResult<List<SalesmanInfo>> getSalesmanInfoList() {
        List<SalesmanInfo> salesmanInfo = salesmanMapper.getSalesmanInfo();
        return ReturnResult.ok(salesmanInfo);
    }
}
