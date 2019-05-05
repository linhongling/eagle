package com.eagle.order.controller;

import com.eagle.order.domain.Goods;
import com.eagle.order.domain.TransferCompany;
import com.eagle.order.service.TransferCompanyService;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.ClientInfo;
import com.eagle.order.vo.TransferCoInfo;
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

    @RequestMapping("/getTransferCoInfoList")
    public ReturnResult<List<TransferCoInfo>> getTransferCoInfoList(){
        return transferCompanyService.getTransferCoInfoList();
    }

    @RequestMapping("/getDetail")
    public ReturnResult<TransferCompany> getDtail(@RequestBody Long id) {
        if(id == null){
            return ReturnResult.error("参数ID不能为空");
        }
        return transferCompanyService.getDtail(id);
    }

    @RequestMapping("/saveTransferCo")
    public ReturnResult<Integer> saveTransferCo(@RequestBody TransferCompany transferCompany) {
        if(transferCompany == null || StringUtils.isEmpty(transferCompany.getName())) {
            return ReturnResult.error("参数order不能为空");
        }
        return transferCompanyService.saveTransferCo(transferCompany);
    }

    @RequestMapping("/updateTransferCo")
    public ReturnResult<Integer> updateTransferCo(@RequestBody TransferCompany transferCompany) {
        if(transferCompany == null || StringUtils.isEmpty(transferCompany.getName())) {
            return ReturnResult.error("参数order不能为空");
        }
        return transferCompanyService.updateTransferCo(transferCompany);
    }

    @RequestMapping("/delete")
    public ReturnResult<Integer> delete(@RequestBody Long id) {
        if(id == null){
            return ReturnResult.error("参数ID不能为空");
        }
        return transferCompanyService.delete(id);
    }
}
