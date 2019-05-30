package com.eagle.order.service;

import com.eagle.order.domain.OrderTask;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.OrderTaskVO;
import com.github.pagehelper.PageInfo;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/4/15
 */
public interface OrderTaskService {

    ReturnResult<PageInfo<OrderTask>> queryList(QueryData<OrderTaskVO> queryData);

    ReturnResult<OrderTask> getDetail(Long id);

    ReturnResult<Integer> saveOrderTask(OrderTask orderTask);

    ReturnResult<Integer> updateOrderTask(OrderTask orderTask);

    ReturnResult<Integer> delete(Long id);

    ReturnResult<Integer> updateTaskStatus(Long id);
}
