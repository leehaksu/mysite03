package com.jx372.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jx372.mysite.service.UserService;
import com.jx372.mysite.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join()
	{
		return "/user/join";
	}
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute UserVo uservo)
	{
		System.out.println("잘 들어왔지?");
		userService.join(uservo);
		return "redirect :/user/joinsuccess";	
	}
}
