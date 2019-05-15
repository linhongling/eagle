package com.eagle.order.mapper;

import com.eagle.order.domain.Client;
import com.eagle.order.domain.ClientExample;
import com.eagle.order.vo.ClientInfo;
import com.eagle.order.vo.ClientVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClientMapper {
    int countByExample(ClientExample example);

    int deleteByExample(ClientExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Client record);

    int insertSelective(Client record);

    List<Client> selectByExample(ClientExample example);

    Client selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Client record, @Param("example") ClientExample example);

    int updateByExample(@Param("record") Client record, @Param("example") ClientExample example);

    int updateByPrimaryKeySelective(Client record);

    int updateByPrimaryKey(Client record);

    List<ClientInfo> getClientInfo();

    List<ClientVO> selectByExampleNew(ClientExample example);

    Long getSalesmanIdByClientId(Long id);
}