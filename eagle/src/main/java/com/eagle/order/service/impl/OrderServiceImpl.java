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
import com.eagle.order.vo.OrderVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
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
    public ReturnResult<PageInfo<OrderVO>> queryList(QueryData<OrderVO> queryData) {
        PageInfo pageInfo = queryData.getPageInfo();
        OrderVO orderVO = queryData.getParam();
        OrderExample orderExample = new OrderExample();
        orderExample.setOrderByClause("ORDER_DATE DESC");
        OrderExample.Criteria criteria = orderExample.createCriteria();
        if (!Strings.isNullOrEmpty(orderVO.getNo())) {
            criteria.andNoEqualTo(orderVO.getNo());
        }
        if (null != orderVO.getClientId()) {
            criteria.andClientIdEqualTo(orderVO.getClientId());
        }
        if (null != orderVO.getOrderDate()) {
            criteria.andOrderDateEqualTo(orderVO.getOrderDate());
        }
        if (!Strings.isNullOrEmpty(orderVO.getTransferNo())) {
            criteria.andTransferNoEqualTo(orderVO.getTransferNo());
        }
        if (null != orderVO.getTransferCompanyId()) {
            criteria.andTransferCompanyIdEqualTo(orderVO.getTransferCompanyId());
        }
        if (null != orderVO.getReceipt()) {
            criteria.andOrderDateEqualTo(orderVO.getReceipt());
        }
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        List<OrderVO> orders = orderMapper.selectByExampleNew(orderExample);
        PageInfo<OrderVO> resultInfo = new PageInfo<OrderVO>(orders);
        return ReturnResult.ok(resultInfo);
    }

    @Override
    public ReturnResult<OrderVO> exportList(OrderVO orderVO) {
        OrderExample orderExample = new OrderExample();
        orderExample.setOrderByClause("ORDER_DATE ASC");
        OrderExample.Criteria criteria = orderExample.createCriteria();
        if (!Strings.isNullOrEmpty(orderVO.getNo())) {
            criteria.andNoEqualTo(orderVO.getNo());
        }
        if (null != orderVO.getClientId()) {
            criteria.andClientIdEqualTo(orderVO.getClientId());
        }
        if (null != orderVO.getOrderDate()) {
            criteria.andOrderDateEqualTo(orderVO.getOrderDate());
        }
        if (!Strings.isNullOrEmpty(orderVO.getTransferNo())) {
            criteria.andTransferNoEqualTo(orderVO.getTransferNo());
        }
        if (null != orderVO.getTransferCompanyId()) {
            criteria.andTransferCompanyIdEqualTo(orderVO.getTransferCompanyId());
        }
        if (null != orderVO.getReceipt()) {
            criteria.andOrderDateEqualTo(orderVO.getReceipt());
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
