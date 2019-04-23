package com.eagle.order.service;

import com.eagle.order.po.Role;
import com.eagle.order.po.RoleExample;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/4/15
 */
public interface RoleService {

    ReturnResult queryList(QueryData<RoleExample> queryData);

    ReturnResult saveOrUpdate(Role role);

    ReturnResult delete(int id);

    ReturnResult permissionList();
}
