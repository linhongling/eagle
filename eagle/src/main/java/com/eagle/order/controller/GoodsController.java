package com.eagle.order.controller;

import com.eagle.order.domain.Goods;
import com.eagle.order.service.GoodsService;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/4/18
 */
@RestController
@RequestMapping("/web/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/queryList")
    public ReturnResult<PageInfo<Goods>> queryList(@RequestBody QueryData<Goods> queryData){
        ReturnResult<PageInfo<Goods>> returnResult = goodsService.queryList(queryData);
        return returnResult;
    }
}
