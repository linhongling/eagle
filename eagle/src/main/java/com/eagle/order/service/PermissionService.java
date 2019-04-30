package com.eagle.order.service;

import com.eagle.order.domain.WebUser;
import com.eagle.order.vo.WebUserPermissionDO;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/4/15
 */
public interface PermissionService {

    WebUserPermissionDO getPermissionByUser(WebUser webUser);
}
