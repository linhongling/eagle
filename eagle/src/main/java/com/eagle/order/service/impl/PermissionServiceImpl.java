package com.eagle.order.service.impl;

import com.eagle.order.enums.ErrorCodeEnum;
import com.eagle.order.mapper.PermissionMapper;
import com.eagle.order.po.Permission;
import com.eagle.order.po.PermissionExample;
import com.eagle.order.po.WebUser;
import com.eagle.order.service.PermissionService;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.WebUserPermissionDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/4/15
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public WebUserPermissionDO getPermissionByUser(WebUser webUser) {
        List<Permission> permissions = null;
        if("admin".equals(webUser.getAccount())){
            PermissionExample example = new PermissionExample();
            permissions = permissionMapper.selectByExample(example);
        }else {
            permissions = permissionMapper.getPermissionByUser(webUser.getId());
        }
        if(permissions != null) {
            List<String> menuList = new ArrayList<String>();
            List<String> permissionList = new ArrayList<String>();
            for(Permission permission : permissions){
                menuList.add(permission.getMenuCode());
                permissionList.add(permission.getPermissionCode());
            }
            WebUserPermissionDO permissionByUser = new WebUserPermissionDO();
            permissionByUser.setMenuList(menuList);
            permissionByUser.setPermissionList(permissionList);
            return permissionByUser;
        }
        return null;
    }
}
