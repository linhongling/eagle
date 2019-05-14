package com.eagle.order.service;

import com.eagle.order.domain.Goods;
import com.eagle.order.domain.Salesman;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.GoodsInfo;
import com.eagle.order.vo.SalesmanInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/4/22
 */
public interface SalesmanService {

    ReturnResult<PageInfo<Salesman>> queryList(QueryData<Salesman> queryData);

    ReturnResult<Salesman> getDtail(Long id);

    ReturnResult<Integer> saveSalesman(Salesman salesman);

    ReturnResult<Integer> updateSalesman(Salesman salesman);

    ReturnResult<List<SalesmanInfo>> getSalesmanInfoList();
}
