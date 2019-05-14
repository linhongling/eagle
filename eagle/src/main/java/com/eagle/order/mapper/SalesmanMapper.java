package com.eagle.order.mapper;

import com.eagle.order.domain.Salesman;
import com.eagle.order.domain.SalesmanExample;
import java.util.List;

import com.eagle.order.vo.SalesmanInfo;
import org.apache.ibatis.annotations.Param;

public interface SalesmanMapper {
    int countByExample(SalesmanExample example);

    int deleteByExample(SalesmanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Salesman record);

    int insertSelective(Salesman record);

    List<Salesman> selectByExample(SalesmanExample example);

    Salesman selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Salesman record, @Param("example") SalesmanExample example);

    int updateByExample(@Param("record") Salesman record, @Param("example") SalesmanExample example);

    int updateByPrimaryKeySelective(Salesman record);

    int updateByPrimaryKey(Salesman record);

    List<SalesmanInfo> getSalesmanInfo();
}