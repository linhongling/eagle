package com.eagle.order.mapper;

import com.eagle.order.domain.TransferCompany;
import com.eagle.order.domain.TransferCompanyExample;
import java.util.List;

import com.eagle.order.vo.GoodsInfo;
import com.eagle.order.vo.TransferCoInfo;
import org.apache.ibatis.annotations.Param;

public interface TransferCompanyMapper {
    int countByExample(TransferCompanyExample example);

    int deleteByExample(TransferCompanyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TransferCompany record);

    int insertSelective(TransferCompany record);

    List<TransferCompany> selectByExample(TransferCompanyExample example);

    TransferCompany selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TransferCompany record, @Param("example") TransferCompanyExample example);

    int updateByExample(@Param("record") TransferCompany record, @Param("example") TransferCompanyExample example);

    int updateByPrimaryKeySelective(TransferCompany record);

    int updateByPrimaryKey(TransferCompany record);

    List<TransferCoInfo> getTransferCoInfo();
}