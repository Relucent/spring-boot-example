package yyl.spring.boot.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter(urlPatterns = "/filter/", filterName = "helloFilter")
public class HelloFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		response.getWriter().append("helloFilter:" + request.getRequestURI());
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("helloFilter init");
	}

	@Override
	public void destroy() {
	}

}
