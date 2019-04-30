package com.eagle.order.service;

import com.eagle.order.domain.WebUser;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.WebUserVO;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/4/15
 */
public interface WebUserService {

    ReturnResult login(String account, String password);

    ReturnResult queryList(QueryData<WebUserVO> queryData);

    ReturnResult saveOrUpdate(WebUser webUser);

    ReturnResult delete(Long id);

    ReturnResult assignRole(WebUserVO webUserVO);
}
