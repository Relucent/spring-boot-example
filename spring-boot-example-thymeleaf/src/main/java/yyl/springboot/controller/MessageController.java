
package yyl.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import yyl.springboot.model.Message;
import yyl.springboot.service.MessageService;

@Controller
@RequestMapping("/")
public class MessageController {

	@Autowired
	private MessageService messageService;

	@GetMapping
	public String list(Model model) {
		Iterable<Message> messages = messageService.findAll();
		model.addAttribute("messages", messages);
		return "list";
	}

	@GetMapping(params = "form")
	public String form(@ModelAttribute Message message) {
		// 此處 @ModelAttribute 與 model.addAttribute("message", message) 功能類似
		return "form";
	}

	@GetMapping("{id}")
	public String view(@PathVariable Long id, Model model) {
		Message message = messageService.getById(id);
		model.addAttribute("message", message);
		return "view";
	}

	@GetMapping("/modify/{id}")
	public String modify(@ModelAttribute Message message, Model model) {
		message = messageService.getById(message.getId());
		model.addAttribute("message", message);
		return "form";
	}

	// 注意: BindingResult要加在實體後面
	@PostMapping
	public String save(@Valid Message message, BindingResult result, RedirectAttributes redirect, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("message", message);
			model.addAttribute("formErrors", result.getAllErrors());
			return "form";
		}
		message = messageService.save(message);
		redirect.addFlashAttribute("globalMessage", "Successfully created a new message");
		model.addAttribute("message", message);
		return "redirect:/" + message.getId();
	}

	@GetMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") Long id, Model model) {
		messageService.remove(id);
		Iterable<Message> messages = messageService.findAll();
		model.addAttribute("messages", messages);
		return "redirect:/";
	}
}
