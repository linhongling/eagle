package com.eagle.order.controller;

import com.eagle.order.service.OrderService;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.OrderVO;
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
@RequestMapping("/web/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/queryList")
    public ReturnResult<PageInfo<OrderVO>> queryList(@RequestBody QueryData<OrderVO> queryData){
        ReturnResult<PageInfo<OrderVO>> returnResult = orderService.queryList(queryData);
        return returnResult;
    }

}
