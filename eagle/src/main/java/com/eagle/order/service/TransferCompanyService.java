package com.eagle.order.service;

import com.eagle.order.domain.Goods;
import com.eagle.order.domain.TransferCompany;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.GoodsInfo;
import com.eagle.order.vo.TransferCoInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/4/22
 */
public interface TransferCompanyService {

    ReturnResult<PageInfo<TransferCompany>> queryList(QueryData<TransferCompany> queryData);

    ReturnResult<TransferCompany> getDtail(Long id);

    ReturnResult<Integer> saveTransferCo(TransferCompany transferCompany);

    ReturnResult<Integer> updateTransferCo(TransferCompany transferCompany);

    ReturnResult<List<TransferCoInfo>> getTransferCoInfoList();

    ReturnResult<Integer> delete(Long id);

}
