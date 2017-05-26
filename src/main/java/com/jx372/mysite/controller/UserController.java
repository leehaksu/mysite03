package com.jx372.mysite.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jx372.mysite.service.UserService;
import com.jx372.mysite.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService user;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join()
	{
		return "/user/join";
	}
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute UserVo uservo)
	{
		System.out.println("잘 들어왔지?");
		user.join(uservo);
		return "redirect:/user/joinsuccess";	
	}
	@RequestMapping(value="/joinsuccess")
	public String joinsuccess()
	{
		return "/user/joinsuccess";	
	}
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login()
	{
		return "/user/login";	
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpSession httpsession,Model model,@ModelAttribute UserVo uservo)
	{
		uservo=user.getUser(uservo);
		if(uservo==null)
		{
			model.addAttribute("result", "fail");
			return "/user/login";
		}
		httpsession.setAttribute("authUser", uservo);
		return "redirect:/";	
	}
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modify(Model model,HttpSession authUser)
	{
		UserVo uservo=user.modify((Long)authUser.getAttribute("no"));
		model.addAttribute("Email",uservo.getEmail());
		model.addAttribute("gender",uservo.getGender());
		return "/user/modify";
	}
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(Model model,@PathVariable UserVo uservo)
	{
		return "redirect:/";
	}
	
	
}
