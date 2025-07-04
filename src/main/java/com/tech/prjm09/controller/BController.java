package com.tech.prjm09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.command.BCommand;
import com.tech.command.BContentCommand;
import com.tech.command.BDeleteCommand;
import com.tech.command.BListCommand;
import com.tech.command.BModifyCommand;
import com.tech.command.BModifyViewCommand;
import com.tech.command.BReplyCommand;
import com.tech.command.BReplyViewCommand;
import com.tech.command.BWriteCommand;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BController {
	BCommand command;
	
	@RequestMapping("/list")
	private String list(Model model) {
		System.out.println("list()");
		command=new BListCommand();
		command.execute(model);
				
		return "list";

	}
	
	@RequestMapping("/write_view")
	private String write_view(Model model) {
		
		return "write_view";
	}
	
	@RequestMapping("/write")
	private String write(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		command=new BWriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	private String content_view(HttpServletRequest request,Model model) {
		model.addAttribute("request", request);
		command=new BContentCommand();
		command.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping("/modify_view")
	private String modify_view(HttpServletRequest request,Model model) {
		model.addAttribute("request", request);
		command=new BModifyViewCommand();
		command.execute(model);
		
		return "modify_view";
	}
	
	@RequestMapping("/modify")
	private String modify(HttpServletRequest request,Model model) {
		model.addAttribute("request", request);
		command=new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	private String reply_view(HttpServletRequest request,Model model) {
		model.addAttribute("request", request);
		command=new BReplyViewCommand();
		command.execute(model);
		
		return "reply_view";
	}

	@RequestMapping("/reply")
	private String reply(HttpServletRequest request,Model model) {
		model.addAttribute("request", request);
		command=new BReplyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	private String delete(HttpServletRequest request,Model model) {
		model.addAttribute("request", request);
		command=new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	
}
