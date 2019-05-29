package com.eagle.order.service;

import com.eagle.order.domain.Goods;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.ClientInfo;
import com.eagle.order.vo.GoodsInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/4/22
 */
public interface GoodsService {

    ReturnResult<PageInfo<Goods>> queryList(QueryData<Goods> queryData);

    ReturnResult<Goods> getDetail(Long id);

    ReturnResult<Integer> saveGoods(Goods goods);

    ReturnResult<Integer> updateGoods(Goods goods);

    ReturnResult<List<GoodsInfo>> getGoodsInfoList();

    ReturnResult<Integer> delete(Long id);
}
