package yyl.springboot.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import yyl.springboot.pojo.User;
import yyl.springboot.sevice.UserService;

public class ShiroRealm extends AuthorizingRealm {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserService userService;

	/** 认证 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 使用的是用户名密码凭据
		if (token instanceof UsernamePasswordToken) {
			return doGetAuthenticationInfo((UsernamePasswordToken) token);
		}
		// 未知类型的凭据，直接返回空(NULL)
		return null;
	}

	/** 鉴权 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 获得认证对象(登陆验证doGetAuthenticationInfo方法中设置的认证对象)

		User user = (User) principals.getPrimaryPrincipal();

		// 基本授权信息对象
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

		// 获得角色信息
		String[] roles = user.getRoles();

		// 获得用户权限
		String[] permissions = user.getPermissions();

		// 将角色信息授权
		for (String role : roles) {
			info.addRole(role);
		}
		// 将资源信息授权
		for (String permission : permissions) {
			info.addStringPermission(permission);
		}

		return info;
	}

	/**
	 * (登陆验证)认证回调函数,登录时调用.
	 * 
	 * @param token 用户名密码凭据
	 * @return 认证信息
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(UsernamePasswordToken token) throws AuthenticationException {
		try {
			// 根据用户名称(登录名)，查询用户信息
			User user = userService.getByUsername(token.getUsername());

			// 如果查询到用户，那么封装用户的认证信息并返回
			if (user != null) {
				return new SimpleAuthenticationInfo(//
						// 1. 认证对象 (可以是任意对象，此处使用自定义的认证对象，放置了一些用户基础数据)
						user,
						// 2. 认证凭据(此处是密码)
						user.getPassword(), //
						// 3. 授权域名称(默认是{当前类名+初始化的序号})
						getName()//
				);
			}
		} catch (AuthenticationException e) {
			throw e;
		} catch (Throwable e) {
			logger.error("!", e);
			throw new AuthenticationException(e);
		}

		// 没有查询到用户，直接返回空(NULL)
		return null;
	}
}