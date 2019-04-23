package com.eagle.order.service.impl;

import com.eagle.order.mapper.ClientMapper;
import com.eagle.order.po.Client;
import com.eagle.order.po.ClientExample;
import com.eagle.order.po.Order;
import com.eagle.order.po.OrderExample;
import com.eagle.order.service.ClientService;
import com.eagle.order.util.CommonBeanUtils;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.ClientVO;
import com.eagle.order.vo.OrderVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/4/22
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public ReturnResult<PageInfo<ClientVO>> queryList(QueryData<ClientVO> queryData) {
        PageInfo pageInfo = queryData.getPageInfo();
        ClientVO clientVO = queryData.getParam();
        ClientExample clientExample = new ClientExample();
        ClientExample.Criteria criteria = clientExample.createCriteria();
        if (!Strings.isNullOrEmpty(clientVO.getName())) {
            criteria.andNameLike("%" + clientVO.getName() + "%");
        }
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        List<Client> clients = clientMapper.selectByExample(clientExample);
        List<ClientVO> ClientVOs = CommonBeanUtils.copyList(clients, ClientVO.class);
        PageInfo<ClientVO> resultInfo = new PageInfo<ClientVO>(ClientVOs);
        return ReturnResult.ok(resultInfo);
    }

    @Override
    public ReturnResult<ClientVO> getDtail(Long id) {
        Client client = clientMapper.selectByPrimaryKey(id);
        ClientVO clientVO = new ClientVO();
        if (client != null) {
            BeanUtils.copyProperties(client, clientVO);
        }
        return ReturnResult.ok(clientVO);
    }

    @Override
    public ReturnResult<Integer> saveClient(Client client) {
        client.setCreateDate(new Date());
        int insert = clientMapper.insert(client);
        return ReturnResult.ok(insert);
    }

    @Override
    public ReturnResult<Integer> updateClient(Client client) {
        client.setModifyDate(new Date());
        int i = clientMapper.updateByPrimaryKey(client);
        return ReturnResult.ok(i);
    }


}
