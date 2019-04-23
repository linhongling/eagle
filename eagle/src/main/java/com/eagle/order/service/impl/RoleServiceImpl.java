package com.eagle.order.service.impl;

import com.eagle.order.mapper.PermissionMapper;
import com.eagle.order.mapper.RoleMapper;
import com.eagle.order.po.Role;
import com.eagle.order.po.RoleExample;
import com.eagle.order.service.RoleService;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.PermissionVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/4/15
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public ReturnResult queryList(QueryData<RoleExample> queryData) {
        PageInfo pageInfo = queryData.getPageInfo();
        RoleExample param = queryData.getParam();
        if (pageInfo == null) {
            List<Role> roleList = roleMapper.selectByExample(param);
            return ReturnResult.ok(roleList);
        }
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        List<Role> roleList = roleMapper.selectByExampleNew(param);
        PageInfo<Role> resultInfo = new PageInfo<Role>(roleList);
        return ReturnResult.ok(resultInfo);
    }

    @Override
    @Transactional
    public ReturnResult saveOrUpdate(Role role) {
        if (role.getId() == null) {
            role.setCreateTime(new Date());
            role.setUpdateTime(new Date());
            roleMapper.insert(role);
        } else {
            role.setUpdateTime(new Date());
            roleMapper.updateByPrimaryKey(role);
        }
        return ReturnResult.ok();
    }

    @Override
    @Transactional
    public ReturnResult delete(int id) {
        roleMapper.deleteByPrimaryKey(id);
        return ReturnResult.ok();
    }

    @Override
    public ReturnResult permissionList(){
        List<PermissionVO> permissionVOList = permissionMapper.permissionList();
        return ReturnResult.ok(permissionVOList);
    }
}
