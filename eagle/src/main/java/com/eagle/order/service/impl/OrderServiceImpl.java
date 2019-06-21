package com.eagle.order.service.impl;

import com.eagle.order.domain.Destination;
import com.eagle.order.domain.Order;
import com.eagle.order.domain.OrderExample;
import com.eagle.order.mapper.OrderMapper;
import com.eagle.order.service.DestinationService;
import com.eagle.order.service.OrderService;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.OrderQuery;
import com.eagle.order.vo.OrderVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/4/18
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private DestinationService destinationService;

    private static final int MAX = 6000;

    @Override
    public ReturnResult<PageInfo<OrderVO>> queryList(QueryData<OrderQuery> queryData) {
        PageInfo pageInfo = queryData.getPageInfo();
        OrderQuery orderQuery = queryData.getParam();
        OrderExample orderExample = new OrderExample();
        orderExample.setOrderByClause("ORDER_DATE DESC, o.create_date DESC");
        OrderExample.Criteria criteria = orderExample.createCriteria();
        if (!Strings.isNullOrEmpty(orderQuery.getNo())) {
            criteria.andNoEqualTo(orderQuery.getNo());
        }
        if (null != orderQuery.getClientIds() && orderQuery.getClientIds().size() > 0) {
            criteria.andClientIdIn(orderQuery.getClientIds());
        }
        if (null != orderQuery.getStartOrderDate()) {
            criteria.andOrderDateGreaterThanOrEqualTo(orderQuery.getStartOrderDate());
            criteria.andOrderDateLessThanOrEqualTo(orderQuery.getEndOrderDate());
        }
        if (!Strings.isNullOrEmpty(orderQuery.getTransferNo())) {
            criteria.andTransferNoEqualTo(orderQuery.getTransferNo());
        }
        if (null != orderQuery.getTransferCompanyIds() && orderQuery.getTransferCompanyIds().size() > 0) {
            criteria.andTransferCompanyIdIn(orderQuery.getTransferCompanyIds());
        }
        if (null != orderQuery.getStartReceipt()) {
            criteria.andReceiptGreaterThanOrEqualTo(orderQuery.getStartReceipt());
            criteria.andReceiptLessThanOrEqualTo(orderQuery.getEndReceipt());
        }
        if (null != orderQuery.getSalesManIds() && orderQuery.getSalesManIds().size() > 0) {
            criteria.andSalesmansIdIn(orderQuery.getSalesManIds());
        }
        if (!Strings.isNullOrEmpty(orderQuery.getDeliveryman())) {
            criteria.andDeliverymanEqualTo(orderQuery.getDeliveryman());
        }
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        List<OrderVO> orders = orderMapper.selectByExampleNew(orderExample);
        PageInfo<OrderVO> resultInfo = new PageInfo<OrderVO>(orders);
        return ReturnResult.ok(resultInfo);
    }

    @Override
    public ReturnResult<OrderVO> exportList(OrderQuery orderQuery) {
        OrderExample orderExample = new OrderExample();
        orderExample.setOrderByClause("ORDER_DATE ASC, o.create_date ASC");
        OrderExample.Criteria criteria = orderExample.createCriteria();
        if (!Strings.isNullOrEmpty(orderQuery.getNo())) {
            criteria.andNoEqualTo(orderQuery.getNo());
        }
        if (null != orderQuery.getClientIds() && orderQuery.getClientIds().size() > 0) {
            criteria.andClientIdIn(orderQuery.getClientIds());
        }
        if (null != orderQuery.getStartOrderDate()) {
            criteria.andOrderDateGreaterThanOrEqualTo(orderQuery.getStartOrderDate());
            criteria.andOrderDateLessThanOrEqualTo(orderQuery.getEndOrderDate());
        }
        if (!Strings.isNullOrEmpty(orderQuery.getTransferNo())) {
            criteria.andTransferNoEqualTo(orderQuery.getTransferNo());
        }
        if (null != orderQuery.getTransferCompanyIds() && orderQuery.getTransferCompanyIds().size() > 0) {
            criteria.andTransferCompanyIdIn(orderQuery.getTransferCompanyIds());
        }
        if (null != orderQuery.getStartReceipt()) {
            criteria.andReceiptGreaterThanOrEqualTo(orderQuery.getStartReceipt());
            criteria.andReceiptLessThanOrEqualTo(orderQuery.getEndReceipt());
        }
        if (null != orderQuery.getSalesManIds() && orderQuery.getSalesManIds().size() > 0) {
            criteria.andSalesmansIdIn(orderQuery.getSalesManIds());
        }
        if (!Strings.isNullOrEmpty(orderQuery.getDeliveryman())) {
            criteria.andDeliverymanEqualTo(orderQuery.getDeliveryman());
        }
        int count = orderMapper.countByExampleNew(orderExample);
        if (count > MAX) {
            return ReturnResult.error("超过导出数量上限");
        }
        List<OrderVO> orders = orderMapper.selectByExampleNew(orderExample);
        return ReturnResult.ok(orders);
    }

    @Override
    public ReturnResult<BigDecimal> countDirectByDelivery(OrderQuery orderQuery) {
        OrderExample orderExample = new OrderExample();
        orderExample.setOrderByClause("ORDER_DATE ASC, o.create_date ASC");
        OrderExample.Criteria criteria = orderExample.createCriteria();
        if (!Strings.isNullOrEmpty(orderQuery.getNo())) {
            criteria.andNoEqualTo(orderQuery.getNo());
        }
        if (null != orderQuery.getClientIds() && orderQuery.getClientIds().size() > 0) {
            criteria.andClientIdIn(orderQuery.getClientIds());
        }
        if (null != orderQuery.getStartOrderDate()) {
            criteria.andOrderDateGreaterThanOrEqualTo(orderQuery.getStartOrderDate());
            criteria.andOrderDateLessThanOrEqualTo(orderQuery.getEndOrderDate());
        }
        if (!Strings.isNullOrEmpty(orderQuery.getTransferNo())) {
            criteria.andTransferNoEqualTo(orderQuery.getTransferNo());
        }
        if (null != orderQuery.getTransferCompanyIds() && orderQuery.getTransferCompanyIds().size() > 0) {
            criteria.andTransferCompanyIdIn(orderQuery.getTransferCompanyIds());
        }
        if (null != orderQuery.getStartReceipt()) {
            criteria.andReceiptGreaterThanOrEqualTo(orderQuery.getStartReceipt());
            criteria.andReceiptLessThanOrEqualTo(orderQuery.getEndReceipt());
        }
        if (null != orderQuery.getSalesManIds() && orderQuery.getSalesManIds().size() > 0) {
            criteria.andSalesmansIdIn(orderQuery.getSalesManIds());
        }
        if (!Strings.isNullOrEmpty(orderQuery.getDeliveryman())) {
            criteria.andDeliverymanEqualTo(orderQuery.getDeliveryman());
        }
        BigDecimal bigDecimal = orderMapper.countDirectByDelivery(orderExample);
        return ReturnResult.ok(bigDecimal == null ? 0 : bigDecimal);
    }

    @Override
    public ReturnResult<Order> getDetail(Long id) {
        Order order = orderMapper.selectByPrimaryKey(id);
        return ReturnResult.ok(order);
    }

    @Override
    public ReturnResult<Integer> saveOrder(Order order) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andNoEqualTo(order.getNo());
        List<Order> orders = orderMapper.selectByExample(orderExample);
        if (orders != null && orders.size() > 0) {
            return ReturnResult.error("此运单号重复");
        }
        int num = orderMapper.insert(order);
        this.saveDestination(order);
        return ReturnResult.ok(num);
    }

    @Override
    public ReturnResult<Integer> updateOrder(Order order) {
        int num = orderMapper.updateByPrimaryKey(order);
        this.saveDestination(order);
        return ReturnResult.ok(num);
    }

    @Override
    public ReturnResult<Integer> delete(Long id) {
        int num = orderMapper.deleteByPrimaryKey(id);
        return ReturnResult.ok(num);
    }

    @Override
    public ReturnResult<String> getDestination() {
        List<String> destination = orderMapper.getDestination();
        return ReturnResult.ok(destination);
    }

    @Override
    public ReturnResult<Long> getIdByOrderNo(String orderNo) {
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andNoEqualTo(orderNo);
        List<Order> orders = orderMapper.selectByExample(orderExample);
        if (orders == null || orders.size() == 0) {
            return ReturnResult.error("未获取到订单信息");
        }
        return ReturnResult.ok(orders.get(0).getId());
    }

    private void saveDestination(Order order) {
        if (!Strings.isNullOrEmpty(order.getDestination())) {
            Destination destination = new Destination();
            destination.setDestination(order.getDestination());
            destination.setAddr(order.getAddr());
            destination.setPhone(order.getRecipientPhone());
            destination.setRecipient(order.getRecipient());
            destinationService.saveDestination(destination);
        }
    }

    @Override
    public ReturnResult confirmReceipt(Order order) {
        int num = orderMapper.updateReceipt(order);
        return ReturnResult.ok(num);
    }
}
