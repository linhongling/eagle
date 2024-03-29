package com.eagle.order.controller;

import com.eagle.order.domain.Client;
import com.eagle.order.service.ClientService;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.ClientInfo;
import com.eagle.order.vo.ClientVO;
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
@RequestMapping("/web/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping("/queryList")
    public ReturnResult<PageInfo<ClientVO>> queryList(@RequestBody QueryData<Client> queryData){
        ReturnResult<PageInfo<ClientVO>> returnResult = clientService.queryList(queryData);
        return returnResult;
    }

    @RequestMapping("/getDetail")
    public ReturnResult<Client> getDetail(@RequestBody Long id) {
        if(id == null){
            return ReturnResult.error("参数ID不能为空");
        }
        return clientService.getDetail(id);
    }

    @RequestMapping("/saveClient")
    public ReturnResult<Integer> saveClient(@RequestBody Client client) {
        if(client == null || StringUtils.isEmpty(client.getName())) {
            return ReturnResult.error("参数client不能为空");
        }
        return clientService.saveClient(client);
    }

    @RequestMapping("/updateClient")
    public ReturnResult<Integer> updateClient(@RequestBody Client client) {
        if(client == null || StringUtils.isEmpty(client.getName())) {
            return ReturnResult.error("参数client不能为空");
        }
        return clientService.updateClient(client);
    }

    @RequestMapping("/getClientInfoList")
    public ReturnResult<List<ClientInfo>> getClientInfoList(){
        return clientService.getClientInfoList();
    }

    @RequestMapping("/delete")
    public ReturnResult<Integer> delete(@RequestBody Long id) {
        if(id == null){
            return ReturnResult.error("参数ID不能为空");
        }
        return clientService.delete(id);
    }

    @RequestMapping("getSalesmanIdByClientId")
    public ReturnResult<Long> getSalesmanIdByClientId(@RequestBody Long id){
        if(id == null){
            return ReturnResult.error("参数ID不能为空");
        }
        return clientService.getSalesmanIdByClientId(id);
    }
}
