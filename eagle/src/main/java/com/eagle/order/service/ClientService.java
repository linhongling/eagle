package com.eagle.order.service;

import com.eagle.order.po.Client;
import com.eagle.order.po.Role;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.ClientVO;
import com.eagle.order.vo.OrderVO;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/4/22
 */
public interface ClientService {

    ReturnResult<PageInfo<ClientVO>> queryList(QueryData<ClientVO> queryData);

    ReturnResult<ClientVO> getDtail(Long id);

    ReturnResult<Integer> saveClient(Client client);

    ReturnResult<Integer> updateClient(Client client);
}
