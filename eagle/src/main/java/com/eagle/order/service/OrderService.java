package com.eagle.order.service;

import com.eagle.order.domain.Client;
import com.eagle.order.domain.Order;
import com.eagle.order.domain.Role;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.OrderQuery;
import com.eagle.order.vo.OrderVO;
import com.github.pagehelper.PageInfo;

import java.math.BigDecimal;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/4/15
 */
public interface OrderService {

    ReturnResult<PageInfo<OrderVO>> queryList(QueryData<OrderQuery> queryData);

    ReturnResult<OrderVO> exportList(OrderQuery queryData);

    ReturnResult<BigDecimal> countDirectByDelivery(OrderQuery queryData);

    ReturnResult<Order> getDetail(Long id);

    ReturnResult<Integer> saveOrder(Order order);

    ReturnResult<Integer> updateOrder(Order order);

    ReturnResult<Integer> delete(Long id);

    ReturnResult<String> getDestination();

    ReturnResult<Long> getIdByOrderNo(String orderNo);

    ReturnResult confirmReceipt(Order order);
}
