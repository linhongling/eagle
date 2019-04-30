package com.eagle.order.service;

import com.eagle.order.domain.Role;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.OrderVO;
import com.github.pagehelper.PageInfo;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/4/15
 */
public interface OrderService {

    ReturnResult<PageInfo<OrderVO>> queryList(QueryData<OrderVO> queryData);

    ReturnResult<Boolean> saveOrUpdate(Role role);

    ReturnResult<Boolean> delete(int id);
}
