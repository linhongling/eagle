package com.eagle.order.mapper;

import com.eagle.order.po.WebUser;
import com.eagle.order.po.WebUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebUserMapper {
    int countByExample(WebUserExample example);

    int deleteByExample(WebUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WebUser record);

    int insertSelective(WebUser record);

    List<WebUser> selectByExample(WebUserExample example);

    WebUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WebUser record, @Param("example") WebUserExample example);

    int updateByExample(@Param("record") WebUser record, @Param("example") WebUserExample example);

    int updateByPrimaryKeySelective(WebUser record);

    int updateByPrimaryKey(WebUser record);

    WebUser login(@Param("account") String account,@Param("password") String password);

    List<WebUser> selectByExampleNew(WebUserExample example);
}