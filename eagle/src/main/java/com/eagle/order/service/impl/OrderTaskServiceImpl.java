package com.eagle.order.service.impl;

import com.eagle.order.domain.*;
import com.eagle.order.mapper.OrderTaskMapper;
import com.eagle.order.service.OrderTaskService;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.OrderTaskVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/5/28
 */
@Service
public class OrderTaskServiceImpl implements OrderTaskService {

    @Autowired
    private OrderTaskMapper orderTaskMapper;

    @Override
    public ReturnResult<PageInfo<OrderTask>> queryList(QueryData<OrderTaskVO> queryData) {
        PageInfo pageInfo = queryData.getPageInfo();
        OrderTaskVO orderTaskVO = queryData.getParam();
        OrderTaskExample orderTaskExample = new OrderTaskExample();
//        orderTaskExample.setOrderByClause("status DESC, CREATE_DATE DESC");
        OrderTaskExample.Criteria criteria = orderTaskExample.createCriteria();
        if(!Strings.isNullOrEmpty(orderTaskVO.getOrderNO())){
            criteria.andOrderNoEqualTo(orderTaskVO.getOrderNO());
        }
        if (null != orderTaskVO.getStartCreateDate()) {
            criteria.andCreateDateGreaterThanOrEqualTo(orderTaskVO.getStartCreateDate());
            criteria.andCreateDateLessThanOrEqualTo(orderTaskVO.getEndCreateDate());
        }
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        List<OrderTask> orderTaskList = orderTaskMapper.selectByExample(orderTaskExample);
        PageInfo<OrderTask> resultInfo = new PageInfo<OrderTask>(orderTaskList);
        return ReturnResult.ok(resultInfo);
    }

    @Override
    public ReturnResult<OrderTask> getDetail(Long id) {
        OrderTask orderTask = orderTaskMapper.selectByPrimaryKey(id);
        return ReturnResult.ok(orderTask);
    }

    @Override
    public ReturnResult<Integer> saveOrderTask(OrderTask orderTask) {
        orderTask.setCreateDate(new Date());
        int num = orderTaskMapper.insert(orderTask);
        return ReturnResult.ok(num);
    }

    @Override
    public ReturnResult<Integer> updateOrderTask(OrderTask orderTask) {
        orderTask.setModifyDate(new Date());
        int num = orderTaskMapper.updateByPrimaryKey(orderTask);
        return ReturnResult.ok(num);
    }

    @Override
    public ReturnResult<Integer> delete(Long id) {
        int num = orderTaskMapper.deleteByPrimaryKey(id);
        return ReturnResult.ok(num);
    }
}
