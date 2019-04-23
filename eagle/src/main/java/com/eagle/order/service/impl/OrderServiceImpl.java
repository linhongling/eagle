package com.eagle.order.service.impl;

import com.eagle.order.mapper.OrderMapper;
import com.eagle.order.po.Order;
import com.eagle.order.po.OrderExample;
import com.eagle.order.po.Role;
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

    @Override
    public ReturnResult<PageInfo<OrderVO>> queryList(QueryData<OrderVO> queryData) {
        PageInfo pageInfo = queryData.getPageInfo();
        OrderVO orderVO = queryData.getParam();
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        if(!Strings.isNullOrEmpty(orderVO.getNo())){
            criteria.andNoEqualTo(orderVO.getNo());
        }
        if(null != orderVO.getClientId()){
            criteria.andClientIdEqualTo(orderVO.getClientId());
        }
        if(null != orderVO.getOrderDate()){
            criteria.andOrderDateEqualTo(orderVO.getOrderDate());
        }
        if(!Strings.isNullOrEmpty(orderVO.getTransferNo())){
            criteria.andTransferNoEqualTo(orderVO.getTransferNo());
        }
        if(null != orderVO.getTransferCompanyId()){
            criteria.andTransferCompanyIdEqualTo(orderVO.getTransferCompanyId());
        }
        if(null != orderVO.getReceipt()){
            criteria.andOrderDateEqualTo(orderVO.getReceipt());
        }
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        List<Order> orders = orderMapper.selectByExample(orderExample);
        List<OrderVO> orderVOS = CommonBeanUtils.copyList(orders, OrderVO.class);
        PageInfo<OrderVO> resultInfo = new PageInfo<OrderVO>(orderVOS);
        return ReturnResult.ok(resultInfo);
    }

    @Override
    public ReturnResult<Boolean> saveOrUpdate(Role role) {
        return null;
    }

    @Override
    public ReturnResult<Boolean> delete(int id) {
        return null;
    }

}
