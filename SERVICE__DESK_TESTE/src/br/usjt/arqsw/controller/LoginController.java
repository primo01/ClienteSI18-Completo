package br.usjt.arqsw.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.arqsw.entity.Login;
import br.usjt.arqsw.service.LoginService;


/**
 * 
 * @author Gabriel Ferreira Primo 81618660 SIN3AN-MCA
 */


@Controller
public class LoginController {
	LoginService service;
	
	@Autowired
	public LoginController(LoginService srv){
		this.service = srv;
	}
	
	@RequestMapping("loginForm")
	public String loginForm(){
		return "login";
	}
	
	@RequestMapping("fazer_login")
	public String fazerLogin(Login login, HttpSession session){
		try {
			if(service.validarLogin(login)){
				session.setAttribute(Login.LOGADO, login);
				return "index";
			}
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
		return "redirect:loginForm";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.setAttribute(Login.LOGADO, null);
		return "index";
	}
	
	
}
