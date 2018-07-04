package yyl.springboot.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;


/**
 * 自定义的认证提供者
 * @see DaoAuthenticationProvider
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        System.out.println("->CustomAuthenticationProvider.vaildateUser");

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        List<GrantedAuthority> grantedAuths = new ArrayList<>();
        if (vaildateUser(username, password, grantedAuths)) {

            CustomPrincipal principal = new CustomPrincipal(username);

            return new CustomAuthenticationSuccessToken(principal, password, grantedAuths);
        } else {
            return null;
        }
    }


    private boolean vaildateUser(String username, String password,
            List<GrantedAuthority> grantedAuths) {

        System.out.println("username:" + username);
        System.out.println("password:" + password);

        if ("root".equals(username)) {
            return true;
        }


        return false;
    }

    // 配置支持的 Token
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(CustomAuthenticationToken.class);
    }
}
