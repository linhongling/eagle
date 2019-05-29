package com.eagle.order.controller;

import com.eagle.order.domain.Goods;
import com.eagle.order.domain.Order;
import com.eagle.order.service.GoodsService;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.ClientInfo;
import com.eagle.order.vo.GoodsInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping("/getGoodsInfoList")
    public ReturnResult<List<GoodsInfo>> getGoodsInfoList(){
        return goodsService.getGoodsInfoList();
    }

    @RequestMapping("/getDetail")
    public ReturnResult<Goods> getDetail(@RequestBody Long id) {
        if(id == null){
            return ReturnResult.error("参数ID不能为空");
        }
        return goodsService.getDetail(id);
    }

    @RequestMapping("/saveGoods")
    public ReturnResult<Integer> saveGoods(@RequestBody Goods goods) {
        if(goods == null || StringUtils.isEmpty(goods.getName())) {
            return ReturnResult.error("参数goods不能为空");
        }
        return goodsService.saveGoods(goods);
    }

    @RequestMapping("/updateGoods")
    public ReturnResult<Integer> updateGoods(@RequestBody Goods goods) {
        if(goods == null || StringUtils.isEmpty(goods.getName())) {
            return ReturnResult.error("参数goods不能为空");
        }
        return goodsService.updateGoods(goods);
    }

    @RequestMapping("/delete")
    public ReturnResult<Integer> delete(@RequestBody Long id) {
        if(id == null){
            return ReturnResult.error("参数ID不能为空");
        }
        return goodsService.delete(id);
    }
}
