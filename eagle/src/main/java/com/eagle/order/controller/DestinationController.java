package com.eagle.order.controller;

import com.eagle.order.domain.Destination;
import com.eagle.order.service.DestinationService;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.DestinationInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/6/3
 */
@RestController
@RequestMapping("/web/destination")
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @GetMapping
    public ReturnResult<List<DestinationInfo>> getList() {
        return destinationService.getList();
    }

    @PostMapping("/queryList")
    public ReturnResult<PageInfo<Destination>> queryList(@RequestBody QueryData<Destination> queryData) {
        return destinationService.queryList(queryData);
    }

    @PostMapping
    public ReturnResult<Integer> save(@RequestBody Destination destination) {
        return destinationService.saveDestination(destination);
    }

    @PutMapping("/{id}")
    public ReturnResult<Integer> update(@RequestBody Destination destination){
        return destinationService.updateDestination(destination);
    }

    @GetMapping("/{id}")
    public ReturnResult<Destination> getDetail(@PathVariable("id") Long id){
        return destinationService.getDestination(id);
    }

    @DeleteMapping("/{id}")
    public ReturnResult<Integer> deleteDestination(@PathVariable("id") Long id){
        return destinationService.deleteDestination(id);
    }

}
