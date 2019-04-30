package com.eagle.order.controller;

import com.eagle.order.domain.TransferCompany;
import com.eagle.order.service.TransferCompanyService;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/4/22
 */
@RestController
@RequestMapping("/web/transferCompany")
public class TransferCompanyController {

    @Autowired
    private TransferCompanyService transferCompanyService;

    @RequestMapping("/queryList")
    public ReturnResult<PageInfo<TransferCompany>> queryList(@RequestBody QueryData<TransferCompany> queryData){
        ReturnResult<PageInfo<TransferCompany>> returnResult = transferCompanyService.queryList(queryData);
        return returnResult;
    }
}
