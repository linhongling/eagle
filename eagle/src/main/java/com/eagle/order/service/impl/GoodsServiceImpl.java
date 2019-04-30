package com.eagle.order.service.impl;

import com.eagle.order.domain.Goods;
import com.eagle.order.domain.GoodsExample;
import com.eagle.order.mapper.GoodsMapper;
import com.eagle.order.service.GoodsService;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.GoodsInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/4/30
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public ReturnResult<PageInfo<Goods>> queryList(QueryData<Goods> queryData) {
        PageInfo pageInfo = queryData.getPageInfo();
        Goods goods = queryData.getParam();
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        if (!Strings.isNullOrEmpty(goods.getName())) {
            criteria.andNameLike("%" + goods.getName() + "%");
        }
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        PageInfo<Goods> resultInfo = new PageInfo<Goods>(goodsList);
        return ReturnResult.ok(resultInfo);
    }

    @Override
    public ReturnResult<Goods> getDtail(Long id) {
        return null;
    }

    @Override
    public ReturnResult<Integer> saveClient(Goods goods) {
        return null;
    }

    @Override
    public ReturnResult<Integer> updateClient(Goods goods) {
        return null;
    }

    @Override
    public ReturnResult<List<GoodsInfo>> getGoodsInfoList() {
        return null;
    }
}
