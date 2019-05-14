package com.eagle.order.controller;

import com.eagle.order.domain.Goods;
import com.eagle.order.domain.Salesman;
import com.eagle.order.service.SalesmanService;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.GoodsInfo;
import com.eagle.order.vo.SalesmanInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/4/18
 */
@RestController
@RequestMapping("/web/salesman")
public class SalesmanController {

    @Autowired
    private SalesmanService salesmanService;

    @RequestMapping("/queryList")
    public ReturnResult<PageInfo<Salesman>> queryList(@RequestBody QueryData<Salesman> queryData){
        ReturnResult<PageInfo<Salesman>> returnResult = salesmanService.queryList(queryData);
        return returnResult;
    }

    @RequestMapping("/getSalesmanInfoList")
    public ReturnResult<List<SalesmanInfo>> getSalesmanInfoList(){
        return salesmanService.getSalesmanInfoList();
    }

    @RequestMapping("/getDetail")
    public ReturnResult<Salesman> getDtail(@RequestBody Long id) {
        if(id == null){
            return ReturnResult.error("参数ID不能为空");
        }
        return salesmanService.getDtail(id);
    }

    @RequestMapping("/saveSalesman")
    public ReturnResult<Integer> saveSalesman(@RequestBody Salesman salesman) {
        if(salesman == null || StringUtils.isEmpty(salesman.getName())) {
            return ReturnResult.error("参数salesman不能为空");
        }
        return salesmanService.saveSalesman(salesman);
    }

    @RequestMapping("/updateSalesman")
    public ReturnResult<Integer> updateSalesman(@RequestBody Salesman salesman) {
        if(salesman == null || StringUtils.isEmpty(salesman.getName())) {
            return ReturnResult.error("参数salesman不能为空");
        }
        return salesmanService.updateSalesman(salesman);
    }
}
