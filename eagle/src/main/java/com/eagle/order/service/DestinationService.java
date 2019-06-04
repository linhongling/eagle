package com.eagle.order.service;

import com.eagle.order.domain.Destination;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.DestinationInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/6/3
 */
public interface DestinationService {

    ReturnResult<List<DestinationInfo>> getList();

    ReturnResult<PageInfo<Destination>> queryList(QueryData<Destination> queryData);

    ReturnResult<Integer> saveDestination(Destination destination);

    ReturnResult<Integer> updateDestination(Destination destination);

    ReturnResult<Integer> deleteDestination(Long id);

    ReturnResult<Destination> getDestination(Long id);
}
