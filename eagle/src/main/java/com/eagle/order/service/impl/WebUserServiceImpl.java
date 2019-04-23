package com.eagle.order.service.impl;


import com.eagle.order.mapper.RoleMapper;
import com.eagle.order.mapper.WebUserMapper;
import com.eagle.order.mapper.WebUserRoleMapper;
import com.eagle.order.po.*;
import com.eagle.order.service.PermissionService;
import com.eagle.order.service.WebUserService;
import com.eagle.order.util.CommonBeanUtils;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.WebUserPermissionDO;
import com.eagle.order.vo.WebUserVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WebUserServiceImpl implements WebUserService {

    @Autowired
    private WebUserMapper webUserMapper;
    @Autowired
    private WebUserRoleMapper webUserRoleMapper;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RoleMapper roleMapper;


    /*@Override
    public ReturnResult login(String account, String password) {
        WebUser webUser = webUserMapper.login(account, DigestUtils.md5DigestAsHex(password.getBytes()));
        if (webUser != null) {
            return ReturnResult.ok(webUser);
        }
        return ReturnResult.build(400, "用户名或密码错误");
    }*/

    @Override
    public ReturnResult login(String account, String password) {
        WebUserExample webUserExample = new WebUserExample();
        WebUserExample.Criteria criteria = webUserExample.createCriteria();
        criteria.andAccountEqualTo(account);
        criteria.andPasswordEqualTo(DigestUtils.md5DigestAsHex(password.getBytes()));
        List<WebUser> webUser = webUserMapper.selectByExample(webUserExample);
        if (webUser != null && webUser.size() > 0) {
            WebUserVO webUserVO = new WebUserVO();
            BeanUtils.copyProperties(webUser.get(0), webUserVO);
            WebUserPermissionDO permission = permissionService.getPermissionByUser(webUser.get(0));
            if (permission != null) {
                webUserVO.setUserPermission(permission);
            }
            return ReturnResult.ok(webUserVO);
        }
        return ReturnResult.error("用户名或密码错误");
    }

    @Override
    public ReturnResult queryList(QueryData<WebUserVO> queryData) {
        PageInfo pageInfo = queryData.getPageInfo();
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        WebUserVO param = queryData.getParam();
        WebUserExample webUserExample = new WebUserExample();
        WebUserExample.Criteria criteria = webUserExample.createCriteria();
        if (!Strings.isNullOrEmpty(param.getAccount())) {
            criteria.andAccountLike("%" + param.getAccount() + "%");
        }
        if (!Strings.isNullOrEmpty(param.getNickname())) {
            criteria.andNicknameLike("%" + param.getNickname() + "%");
        }
        List<WebUser> webUserList = webUserMapper.selectByExample(webUserExample);
        List<WebUserVO> webUserVOList = new ArrayList<>();
        if (webUserList != null) {
            webUserVOList = CommonBeanUtils.copyList(webUserList, WebUserVO.class);
            for (WebUserVO webUserVO : webUserVOList) {
                List<Role> roleList = roleMapper.selectByUserId(webUserVO.getId());
                StringBuilder roles = new StringBuilder();
                Long[] roleIds = new Long[roleList.size()];
                for (int i = 0; i < roleList.size(); i++) {
                    if (i != 0) {
                        roles.append(",");
                    }
                    roles.append(roleList.get(i).getRoleName());
                    roleIds[i] = roleList.get(i).getId();
                }
                webUserVO.setRoleIds(roleIds);
                webUserVO.setRoles(roles.toString());
            }
        }

        PageInfo<WebUserVO> resultInfo = new PageInfo<WebUserVO>(webUserVOList);
        return ReturnResult.ok(resultInfo);
    }

    @Override
    @Transactional
    public ReturnResult saveOrUpdate(WebUser webUser) {
        if (webUser.getId() == null) {
            String password = webUser.getPassword();
            webUser.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
            webUser.setCreateTime(new Date());
            webUser.setUpdateTime(new Date());
            webUserMapper.insert(webUser);
        } else {
            if (webUser.getPassword() != null) {
                String password = webUser.getPassword();
                webUser.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
            }
            webUser.setUpdateTime(new Date());
            webUserMapper.updateByPrimaryKeySelective(webUser);
        }
        return ReturnResult.ok();
    }

    @Override
    @Transactional
    public ReturnResult delete(Long id) {
        webUserMapper.deleteByPrimaryKey(id);
        return ReturnResult.ok();
    }

    @Override
    @Transactional
    public ReturnResult assignRole(WebUserVO webUserVO) {
        Long[] roleIds = webUserVO.getRoleIds();
        WebUserRoleExample webUserRoleExample = new WebUserRoleExample();
        WebUserRoleExample.Criteria criteria = webUserRoleExample.createCriteria();
        criteria.andWebUserIdEqualTo(webUserVO.getId());
        webUserRoleMapper.deleteByExample(webUserRoleExample);
        for (Long roleId : roleIds) {
            WebUserRole webUserRole = new WebUserRole();
            webUserRole.setRoleId(roleId);
            webUserRole.setWebUserId(webUserVO.getId());
            webUserRoleMapper.insert(webUserRole);
        }
        return ReturnResult.ok();
    }

}
