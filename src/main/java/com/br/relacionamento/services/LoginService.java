package com.br.relacionamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.relacionamento.models.Login;
import com.br.relacionamento.models.Usuario;
import com.br.relacionamento.repositories.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	public Iterable<Login> mostrarLogin(){
		return loginRepository.findAll();
	}
		public String salvarLogin(Login login, Usuario usuario) {
			login.setUsuario(usuario);
			loginRepository.save(login);
			return "Login Cadastrado";
		}
	}


