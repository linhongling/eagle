package com.eagle.order.mapper;

import com.eagle.order.po.Permission;
import com.eagle.order.po.PermissionExample;
import java.util.List;

import com.eagle.order.vo.PermissionVO;
import com.eagle.order.vo.WebUserPermissionDO;
import org.apache.ibatis.annotations.Param;

public interface PermissionMapper {
    int countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionExample example);

    Permission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    List<Permission> getPermissionByUser(@Param("userId") Long userId);

    List<PermissionVO> permissionList();
}