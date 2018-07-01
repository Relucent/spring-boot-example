package yyl.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String doDefault() {
        System.out.println("@/");
        return "redirect:/index";
    }

    @GetMapping("/login")
    public String login() {
        System.out.println("@/login");
        return "/login";
    }


    @GetMapping("/index")
    public String index() {
        System.out.println("@/index");
        return "/index";
    }

    @GetMapping("/page1")
    public String page1() {
        System.out.println("@/page1");
        return "page1";
    }


    @GetMapping("/page2")
    public String page2() {
        System.out.println("@/page2");
        return "page2";
    }

    @GetMapping("/page3")
    public String page3() {
        System.out.println("@/page3");
        return "page3";
    }

    @GetMapping("/403")
    public String unauthorizedRole() {
        System.out.println("@/403");
        return "403";
    }

}
