package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.service.IndexService;

@Controller
public class LoginController {
	@Autowired
	IndexService loginService;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

}