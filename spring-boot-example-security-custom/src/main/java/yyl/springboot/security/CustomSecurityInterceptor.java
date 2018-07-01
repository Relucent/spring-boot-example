package yyl.springboot.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component("securityInterceptor")
public class CustomSecurityInterceptor {


    public boolean check(Authentication authentication, HttpServletRequest request) {

        System.out.println("@check URI " + request.getRequestURI());

         
        // 获取到Principal对象
        Object principal = authentication.getPrincipal();

        // 未授权
        if (principal == null) {
            return false;
        }
        // 未知的用户信息
        if (!(principal instanceof CustomPrincipal)) {
            return false;
        }
        
        CustomPrincipal ud = (CustomPrincipal) principal;

        // 此处可以获得用户的权限信息，从而判断用户是否能有访问权限
        System.out.println(ud.getUsername());

        return true;
    }
}

