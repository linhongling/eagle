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
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        return ReturnResult.ok(goods);
    }

    @Override
    public ReturnResult<Integer> saveGoods(Goods goods) {
        int num = goodsMapper.insert(goods);
        return ReturnResult.ok(num);
    }

    @Override
    public ReturnResult<Integer> updateGoods(Goods goods) {
        int num = goodsMapper.updateByPrimaryKey(goods);
        return ReturnResult.ok(num);
    }

    @Override
    public ReturnResult<List<GoodsInfo>> getGoodsInfoList() {
        List<GoodsInfo> goodsInfo = goodsMapper.getGoodsInfo();
        return ReturnResult.ok(goodsInfo);
    }

    @Override
    public ReturnResult<Integer> delete(Long id) {
        int num = goodsMapper.deleteByPrimaryKey(id);
        return ReturnResult.ok(num);
    }
}
