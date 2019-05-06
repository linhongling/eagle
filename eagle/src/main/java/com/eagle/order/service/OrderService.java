package com.eagle.order.service;

import com.eagle.order.domain.Client;
import com.eagle.order.domain.Order;
import com.eagle.order.domain.Role;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.OrderVO;
import com.github.pagehelper.PageInfo;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/4/15
 */
public interface OrderService {

    ReturnResult<PageInfo<OrderVO>> queryList(QueryData<OrderVO> queryData);

    ReturnResult<OrderVO> exportList(OrderVO orderVO);

    ReturnResult<Order> getDtail(Long id);

    ReturnResult<Integer> saveOrder(Order order);

    ReturnResult<Integer> updateOrder(Order order);

    ReturnResult<Integer> delete(Long id);
}
