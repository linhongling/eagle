package com.eagle.order.service.impl;

import com.eagle.order.domain.Client;
import com.eagle.order.mapper.OrderMapper;
import com.eagle.order.domain.Order;
import com.eagle.order.domain.OrderExample;
import com.eagle.order.domain.Role;
import com.eagle.order.service.OrderService;
import com.eagle.order.util.CommonBeanUtils;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.OrderQuery;
import com.eagle.order.vo.OrderVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import org.apache.commons.collections.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private static final int MAX = 6000;

    @Override
    public ReturnResult<PageInfo<OrderVO>> queryList(QueryData<OrderQuery> queryData) {
        PageInfo pageInfo = queryData.getPageInfo();
        OrderQuery orderQuery = queryData.getParam();
        OrderExample orderExample = new OrderExample();
        orderExample.setOrderByClause("ORDER_DATE DESC");
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
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        List<OrderVO> orders = orderMapper.selectByExampleNew(orderExample);
        PageInfo<OrderVO> resultInfo = new PageInfo<OrderVO>(orders);
        return ReturnResult.ok(resultInfo);
    }

    @Override
    public ReturnResult<OrderVO> exportList(OrderQuery orderQuery) {
        OrderExample orderExample = new OrderExample();
        orderExample.setOrderByClause("ORDER_DATE ASC");
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
        int count = orderMapper.countByExample(orderExample);
        if(count > MAX){
            return ReturnResult.error("超过导出数量上限");
        }
        List<OrderVO> orders = orderMapper.selectByExampleNew(orderExample);
        return ReturnResult.ok(orders);
    }

    @Override
    public ReturnResult<Order> getDtail(Long id) {
        Order order = orderMapper.selectByPrimaryKey(id);
        return ReturnResult.ok(order);
    }

    @Override
    public ReturnResult<Integer> saveOrder(Order order) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andNoEqualTo(order.getNo());
        List<Order> orders = orderMapper.selectByExample(orderExample);
        if(orders != null && orders.size() > 0){
            return ReturnResult.error("此运单号重复");
        }
        int num = orderMapper.insert(order);
        return ReturnResult.ok(num);
    }

    @Override
    public ReturnResult<Integer> updateOrder(Order order) {
        int num = orderMapper.updateByPrimaryKey(order);
        return ReturnResult.ok(num);
    }

    @Override
    public ReturnResult<Integer> delete(Long id) {
        int num = orderMapper.deleteByPrimaryKey(id);
        return ReturnResult.ok(num);
    }

}
