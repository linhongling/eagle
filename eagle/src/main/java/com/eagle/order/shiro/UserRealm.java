package com.eagle.order.shiro;

import com.eagle.order.service.WebUserService;
import com.eagle.order.util.ReturnResult;
import com.eagle.order.vo.WebUserVO;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


public class UserRealm extends AuthorizingRealm {

    @Autowired
    private WebUserService webUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 验证当前登录的Subject
     * LoginController.login()方法中执行Subject.login()时 执行此方法
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String name = token.getUsername();
        String password = String.valueOf(token.getPassword());
        // 从数据库获取对应用户名密码的用户
        ReturnResult<WebUserVO> loginResult = webUserService.login(name, password);
        if (loginResult.getStatus() == 400) {
            throw new AuthenticationException();
        } else {
            WebUserVO webUser = (WebUserVO) loginResult.getData();
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    webUser,
                    webUser.getPassword(),
                    getName()
            );
            return authenticationInfo;
        }
    }
}
