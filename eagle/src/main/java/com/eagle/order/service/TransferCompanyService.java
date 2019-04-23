package com.eagle.order.service;

import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.TransferCompanyVO;
import com.github.pagehelper.PageInfo;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/4/22
 */
public interface TransferCompanyService {

    ReturnResult<PageInfo<TransferCompanyVO>> queryList(QueryData<TransferCompanyVO> queryData);

}
