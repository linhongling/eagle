package com.eagle.order.service;

import com.eagle.order.domain.Client;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.ClientInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/4/22
 */
public interface ClientService {

    ReturnResult<PageInfo<Client>> queryList(QueryData<Client> queryData);

    ReturnResult<Client> getDtail(Long id);

    ReturnResult<Integer> saveClient(Client client);

    ReturnResult<Integer> updateClient(Client client);

    ReturnResult<List<ClientInfo>> getClientInfoList();

    ReturnResult<Integer> delete(Long id);
}
