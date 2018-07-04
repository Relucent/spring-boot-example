package yyl.springboot.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication auth) throws IOException, ServletException {

        System.out.println("CustomAuthenticationSuccessHandler.onAuthenticationSuccess");

        String ajaxHeader = ((HttpServletRequest) request).getHeader("X-Requested-With");
        boolean isAjax = "XMLHttpRequest".equals(ajaxHeader);

        System.out.println("login-success:" + auth.getPrincipal());

        if (isAjax) {
            response.getWriter().print("{\"success\":true");
            response.getWriter().flush();
        } else {
            response.sendRedirect("/index");
        }
    }
}
