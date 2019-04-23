package com.eagle.order.controller;

import com.eagle.order.entity.User;
import com.eagle.order.po.WebUser;
import com.eagle.order.po.WebUserExample;
import com.eagle.order.service.PermissionService;
import com.eagle.order.service.WebUserService;
import com.eagle.order.service.impl.WebUserServiceImpl;
import com.eagle.order.util.QueryData;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.WebUserVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/4/15
 */
@RestController
@RequestMapping("/web")
public class WebUserController {

    private static Logger logger = LoggerFactory.getLogger(WebUserController.class);

    @Autowired
    private WebUserService webUserService;

    @RequestMapping("/to-login")
    public ReturnResult toLogin() {
        return ReturnResult.build(500, "登录标识已过期，请重新登录");
    }

    @RequestMapping("/is-online")
    public ReturnResult isOnline() {
        WebUserVO user = (WebUserVO) SecurityUtils.getSubject().getPrincipal();
        if (user == null) {
            return ReturnResult.build(500, "登录标识已过期，请重新登录");
        }
        return ReturnResult.ok(user);
    }

    @RequestMapping("/login")
    public ReturnResult login(@RequestParam String account, @RequestParam String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
        token.setRememberMe(true);
        try {
            subject.login(token);
            WebUserVO webUser = (WebUserVO) SecurityUtils.getSubject().getPrincipal();
            return ReturnResult.ok(webUser);
        } catch (AuthenticationException e) {
            logger.error(e.getMessage());
            return ReturnResult.build(400, "用户名或密码错误");
        }
    }

    @RequestMapping("/logout")
    public ReturnResult logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ReturnResult.ok();
    }

    @RequestMapping(value = "/query-list")
    public ReturnResult queryList(@RequestBody QueryData<WebUserVO> queryData){
        ReturnResult returnResult = webUserService.queryList(queryData);
        return returnResult;
    }

    @RequestMapping("/save-or-update")
    public ReturnResult saveOrUpdate(@RequestBody WebUser webUser){
        ReturnResult returnResult = webUserService.saveOrUpdate(webUser);
        return returnResult;
    }


    @RequestMapping("/delete/{id}")
    public ReturnResult delete(@PathVariable Long id){
        ReturnResult returnResult = webUserService.delete(id);
        return returnResult;
    }

    @RequestMapping("/assign-role")
    public ReturnResult assignRole(@RequestBody WebUserVO webUserVO){
        ReturnResult returnResult = webUserService.assignRole(webUserVO);
        return returnResult;
    }
}
