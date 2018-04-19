package yyl.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * |~ http://localhost:8080/jsp/welcome
 * @deprecated
 */
@Controller
@RequestMapping("/jsp")
public class JspController {

	//|~ /jsp/welcome
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Model mv) {
		mv.addAttribute("message", "hello jsp");
		return "hello/welcome";
	}
}
