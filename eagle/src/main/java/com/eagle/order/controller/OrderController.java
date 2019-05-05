package com.eagle.order.controller;

import com.eagle.order.domain.Client;
import com.eagle.order.domain.Order;
import com.eagle.order.service.OrderService;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.OrderVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/4/18
 */
@RestController
@RequestMapping("/web/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/queryList")
    public ReturnResult<PageInfo<OrderVO>> queryList(@RequestBody QueryData<OrderVO> queryData){
        ReturnResult<PageInfo<OrderVO>> returnResult = orderService.queryList(queryData);
        return returnResult;
    }

    @RequestMapping("/getDetail")
    public ReturnResult<Order> getDtail(@RequestBody Long id) {
        if(id == null){
            return ReturnResult.error("参数ID不能为空");
        }
        return orderService.getDtail(id);
    }

    @RequestMapping("/saveOrder")
    public ReturnResult<Integer> saveOrder(@RequestBody Order order) {
        if(order == null || StringUtils.isEmpty(order.getNo())) {
            return ReturnResult.error("参数order不能为空");
        }
        return orderService.saveOrder(order);
    }

    @RequestMapping("/updateOrder")
    public ReturnResult<Integer> updateClient(@RequestBody Order order) {
        if(order == null || StringUtils.isEmpty(order.getNo())) {
            return ReturnResult.error("参数order不能为空");
        }
        return orderService.updateOrder(order);
    }

    @RequestMapping("/delete")
    public ReturnResult<Integer> delete(@RequestBody Long id) {
        if(id == null){
            return ReturnResult.error("参数ID不能为空");
        }
        return orderService.delete(id);
    }

}
