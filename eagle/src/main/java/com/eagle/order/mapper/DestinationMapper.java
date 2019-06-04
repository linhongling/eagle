package com.eagle.order.mapper;

import com.eagle.order.domain.Destination;
import com.eagle.order.domain.DestinationExample;
import java.util.List;

import com.eagle.order.vo.DestinationInfo;
import org.apache.ibatis.annotations.Param;

public interface DestinationMapper {
    int countByExample(DestinationExample example);

    int deleteByExample(DestinationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Destination record);

    int insertSelective(Destination record);

    List<Destination> selectByExample(DestinationExample example);

    Destination selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Destination record, @Param("example") DestinationExample example);

    int updateByExample(@Param("record") Destination record, @Param("example") DestinationExample example);

    int updateByPrimaryKeySelective(Destination record);

    int updateByPrimaryKey(Destination record);

    List<DestinationInfo> getDestinationList();
}