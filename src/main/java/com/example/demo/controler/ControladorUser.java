package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.interfaceService.IUsuarioService;
import com.example.demo.modelo.User;

@Controller
@RequestMapping
public class ControladorUser {
	
	@Autowired
	private IUsuarioService service;
	

	@GetMapping({"/","/index"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

}
