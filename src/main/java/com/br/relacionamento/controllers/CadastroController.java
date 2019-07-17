package com.br.relacionamento.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.relacionamento.models.Login;
import com.br.relacionamento.models.Usuario;
import com.br.relacionamento.services.LoginService;


@Controller
public class CadastroController {

	@Autowired
	LoginService loginService;

	@GetMapping("/")
	public ModelAndView mostrar() {
		ModelAndView modelAndView = new ModelAndView("home.html");
		return modelAndView;
	}

	@PostMapping("/")
	public ModelAndView salvarUsuarios(@Valid Usuario user, BindingResult bindingUser, @Valid Login login,
			BindingResult bindingLogin) {
		ModelAndView modelAndView = new ModelAndView("home.html");

		if (bindingUser.hasErrors() || bindingLogin.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			for (ObjectError objectError : bindingUser.getAllErrors()) {
				erros.add(objectError.getDefaultMessage());
			}
			for (ObjectError objectError : bindingLogin.getAllErrors()) {
				erros.add(objectError.getDefaultMessage());
			}
			modelAndView.addObject("erros", erros);
		} else {
			modelAndView.addObject("erros", loginService.salvarLogin(login, user));
			
		}
		return modelAndView;

	}
}