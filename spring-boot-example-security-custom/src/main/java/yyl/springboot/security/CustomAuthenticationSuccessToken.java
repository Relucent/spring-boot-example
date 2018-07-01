package yyl.springboot.security;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 * 自定义认证令牌(可以和登录使用同一个令牌，此处是为了清晰一些)
 * @see UsernamePasswordAuthenticationToken
 */
@SuppressWarnings("serial")
public class CustomAuthenticationSuccessToken extends CustomAuthenticationToken {
    
    public CustomAuthenticationSuccessToken(Object principal, Object credentials,
            Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }

}
