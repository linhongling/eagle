package com.eagle.order.service.impl;

import com.eagle.order.mapper.ClientMapper;
import com.eagle.order.domain.Client;
import com.eagle.order.domain.ClientExample;
import com.eagle.order.service.ClientService;
import com.eagle.order.util.CommonBeanUtils;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.ClientInfo;
import com.eagle.order.vo.ClientVO;
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
    public ReturnResult<PageInfo<ClientVO>> queryList(QueryData<Client> queryData) {
        PageInfo pageInfo = queryData.getPageInfo();
        Client client = queryData.getParam();
        ClientExample clientExample = new ClientExample();
        clientExample.setOrderByClause("c.IS_VALIDATE DESC, c.CREATE_DATE DESC");
        ClientExample.Criteria criteria = clientExample.createCriteria();
        if (!Strings.isNullOrEmpty(client.getName())) {
            criteria.andNameLike("%" + client.getName() + "%");
        }
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        List<ClientVO> clients = clientMapper.selectByExampleNew(clientExample);
        PageInfo<ClientVO> resultInfo = new PageInfo<ClientVO>(clients);
        return ReturnResult.ok(resultInfo);
    }

    @Override
    public ReturnResult<Client> getDtail(Long id) {
        Client client = clientMapper.selectByPrimaryKey(id);
        return ReturnResult.ok(client);
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

    @Override
    public ReturnResult<List<ClientInfo>> getClientInfoList() {
        List<ClientInfo> clientInfo = clientMapper.getClientInfo();
        return ReturnResult.ok(clientInfo);
    }

    @Override
    public ReturnResult<Integer> delete(Long id) {
        int num = clientMapper.deleteByPrimaryKey(id);
        return ReturnResult.ok(num);
    }

}
