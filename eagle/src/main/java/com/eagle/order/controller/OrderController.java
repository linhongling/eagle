package com.eagle.order.controller;

import com.eagle.order.domain.Client;
import com.eagle.order.domain.Order;
import com.eagle.order.service.OrderService;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.OrderQuery;
import com.eagle.order.vo.OrderVO;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
    public ReturnResult<PageInfo<OrderVO>> queryList(@RequestBody QueryData<OrderQuery> queryData) {
        ReturnResult<PageInfo<OrderVO>> returnResult = orderService.queryList(queryData);
        return returnResult;
    }

    @RequestMapping("/exportList")
    public ReturnResult<OrderVO> exportList(@RequestBody OrderQuery queryData) {
        ReturnResult<OrderVO> returnResult = orderService.exportList(queryData);
        return returnResult;
    }

    @RequestMapping("/getDetail")
    public ReturnResult<Order> getDetail(@RequestBody Long id) {
        if (id == null) {
            return ReturnResult.error("参数ID不能为空");
        }
        return orderService.getDetail(id);
    }

    @RequestMapping("/saveOrder")
    public ReturnResult<Integer> saveOrder(@RequestBody Order order) {
        if (order == null || StringUtils.isEmpty(order.getNo())) {
            return ReturnResult.error("参数order不能为空");
        }
        return orderService.saveOrder(order);
    }

    @RequestMapping("/updateOrder")
    public ReturnResult<Integer> updateOrder(@RequestBody Order order) {
        if (order == null || StringUtils.isEmpty(order.getNo())) {
            return ReturnResult.error("参数order不能为空");
        }
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/{id}")
    public ReturnResult<Integer> delete(@PathVariable("id") Long id) {
        if (id == null) {
            return ReturnResult.error("参数ID不能为空");
        }
        return orderService.delete(id);
    }

    @PostMapping("/getIdByOrderNo")
    public ReturnResult<Long> getIdByOrderNo(@RequestBody String orderNo) {
        if (Strings.isNullOrEmpty(orderNo)) {
            return ReturnResult.error("参数orderNo不能为空");
        }
        return orderService.getIdByOrderNo(orderNo);
    }
}
