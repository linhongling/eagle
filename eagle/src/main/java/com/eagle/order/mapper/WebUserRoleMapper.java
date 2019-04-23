package com.eagle.order.mapper;

import com.eagle.order.po.WebUserRole;
import com.eagle.order.po.WebUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebUserRoleMapper {
    int countByExample(WebUserRoleExample example);

    int deleteByExample(WebUserRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WebUserRole record);

    int insertSelective(WebUserRole record);

    List<WebUserRole> selectByExample(WebUserRoleExample example);

    WebUserRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WebUserRole record, @Param("example") WebUserRoleExample example);

    int updateByExample(@Param("record") WebUserRole record, @Param("example") WebUserRoleExample example);

    int updateByPrimaryKeySelective(WebUserRole record);

    int updateByPrimaryKey(WebUserRole record);
}