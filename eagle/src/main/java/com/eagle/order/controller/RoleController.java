package com.eagle.order.controller;

import com.eagle.order.po.Role;
import com.eagle.order.po.RoleExample;
import com.eagle.order.po.WebUserExample;
import com.eagle.order.service.RoleService;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/4/17
 */
@RestController
@RequestMapping("/web/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/query-list")
    public ReturnResult queryList(@RequestBody QueryData<RoleExample> queryData){
        ReturnResult returnResult = roleService.queryList(queryData);
        return returnResult;
    }

    @RequestMapping("/save-or-update")
    public ReturnResult saveOrUpdate(@RequestBody Role role){
        ReturnResult returnResult = roleService.saveOrUpdate(role);
        return returnResult;
    }

    @RequestMapping("/delete/{id}")
    public ReturnResult delete(@PathVariable int id){
        ReturnResult returnResult = roleService.delete(id);
        return returnResult;
    }

    @RequestMapping("/permission-list")
    public ReturnResult permissionList(){
        return roleService.permissionList();
    }
}
