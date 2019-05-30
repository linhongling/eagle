package com.eagle.order.mapper;

import com.eagle.order.domain.OrderTask;
import com.eagle.order.domain.OrderTaskExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderTaskMapper {
    int countByExample(OrderTaskExample example);

    int deleteByExample(OrderTaskExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderTask record);

    int insertSelective(OrderTask record);

    List<OrderTask> selectByExample(OrderTaskExample example);

    OrderTask selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderTask record, @Param("example") OrderTaskExample example);

    int updateByExample(@Param("record") OrderTask record, @Param("example") OrderTaskExample example);

    int updateByPrimaryKeySelective(OrderTask record);

    int updateByPrimaryKey(OrderTask record);

    int updateTaskStatus(Long id);
}