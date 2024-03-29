package com.eagle.order.controller;

import com.eagle.order.domain.OrderTask;
import com.eagle.order.service.OrderTaskService;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.OrderTaskVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/web/orderTask")
public class OrderTaskController {

    @Autowired
    private OrderTaskService orderTaskService;

    @PostMapping("/getList")
    public ReturnResult<PageInfo<OrderTask>> queryList(@RequestBody QueryData<OrderTaskVO> queryData) {
        ReturnResult<PageInfo<OrderTask>> returnResult = orderTaskService.queryList(queryData);
        return returnResult;
    }

    @GetMapping("/{id}")
    public ReturnResult<OrderTask> getDetail(@PathVariable("id") Long id) {
        if (id == null) {
            return ReturnResult.error("参数ID不能为空");
        }
        return orderTaskService.getDetail(id);
    }

    @PostMapping
    public ReturnResult<Integer> save(@RequestBody OrderTask orderTask) {
        if (StringUtils.isEmpty(orderTask.getTaskDesc())) {
            return ReturnResult.error("问题描述不能为空");
        }
        if (StringUtils.isEmpty(orderTask.getOrderNo())) {
            return ReturnResult.error("订单号不能为空");
        }
        return orderTaskService.saveOrderTask(orderTask);
    }

    @PutMapping("/{id}")
    public ReturnResult<Integer> update(@RequestBody OrderTask orderTask) {
        if (StringUtils.isEmpty(orderTask.getTaskDesc())) {
            return ReturnResult.error("问题描述不能为空");
        }
        if (StringUtils.isEmpty(orderTask.getOrderNo())) {
            return ReturnResult.error("订单号不能为空");
        }
        return orderTaskService.updateOrderTask(orderTask);
    }

    @DeleteMapping("/{id}")
    public ReturnResult<Integer> delete(@PathVariable("id") Long id) {
        if (id == null) {
            return ReturnResult.error("参数ID不能为空");
        }
        return orderTaskService.delete(id);
    }

    @PostMapping("/updateTaskStatus")
    public ReturnResult<Integer> updateTaskStatus(@RequestBody Long id) {
        if (id == null) {
            return ReturnResult.error("参数ID不能为空");
        }
        return orderTaskService.updateTaskStatus(id);
    }

    @GetMapping("/getUnFinishTask")
    public ReturnResult<List<OrderTask>> getUnFinishTask(){
        return orderTaskService.getUnFinishTask();
    }
}
