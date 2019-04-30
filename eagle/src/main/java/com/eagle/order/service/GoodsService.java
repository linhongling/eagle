package com.eagle.order.service;

import com.eagle.order.domain.Goods;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.github.pagehelper.PageInfo;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/4/22
 */
public interface GoodsService {

    ReturnResult<PageInfo<Goods>> queryList(QueryData<Goods> queryData);

    ReturnResult<Goods> getDtail(Long id);

    ReturnResult<Integer> saveClient(Goods goods);

    ReturnResult<Integer> updateClient(Goods goods);
}
