package com.eagle.order.service;

import com.eagle.order.domain.TransferCompany;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.github.pagehelper.PageInfo;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/4/22
 */
public interface TransferCompanyService {

    ReturnResult<PageInfo<TransferCompany>> queryList(QueryData<TransferCompany> queryData);

}
