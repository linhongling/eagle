package com.eagle.order.mapper;

import com.eagle.order.domain.Order;
import com.eagle.order.domain.OrderExample;

import java.math.BigDecimal;
import java.util.List;

import com.eagle.order.vo.OrderVO;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    int countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<OrderVO> selectByExampleNew(OrderExample example);

    int countByExampleNew(OrderExample example);

    BigDecimal countDirectByDelivery(OrderExample example);

    List<String> getDestination();

    int updateReceipt(Order order);
}