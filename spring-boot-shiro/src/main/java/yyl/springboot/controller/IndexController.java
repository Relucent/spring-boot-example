package yyl.springboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping({ "/", "index" })
	public String index() {
		return "/index";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) throws Exception {
		
		System.out.println("/login");

		// 登录失败从request中获取shiro处理的异常信息。
		// shiroLoginFailure:就是shiro异常类的全类名.
		String exception = (String) request.getAttribute("shiroLoginFailure");
		System.out.println("exception=" + exception);
		String msg = "";
		if (exception != null) {
			if (UnknownAccountException.class.getName().equals(exception)) {
				System.out.println("UnknownAccountException -- > 账号不存在：");
				msg = "UnknownAccountException -- > 账号不存在：";
			} else if (IncorrectCredentialsException.class.getName().equals(exception)) {
				System.out.println("IncorrectCredentialsException -- > 密码不正确：");
				msg = "IncorrectCredentialsException -- > 密码不正确：";
			} else if ("kaptchaValidateFailed".equals(exception)) {
				System.out.println("kaptchaValidateFailed -- > 验证码错误");
				msg = "kaptchaValidateFailed -- > 验证码错误";
			} else {
				msg = "else >> " + exception;
				System.out.println("else -- >" + exception);
			}
		}
		model.addAttribute("msg", msg);
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			return "redirect:/index";
		}
		return "login";
	}

	@RequiresPermissions("permission:page1")
	@RequestMapping("/page1")
	public String page1() {
		
		System.out.println("HomeController.page1()");
		
		return "page1";
	}

	// @RequiresPermissions("permission:page2")
	@RequestMapping("/page2")
	public String page2() {
		return "page2";
	}

	@RequiresPermissions("permission:page3")
	@RequestMapping("/page3")
	public String page3() {
		return "page3";
	}

	@RequestMapping("/403")
	public String unauthorizedRole() {
		return "403";
	}

}