package br.usjt.arqsw.service;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.usjt.arqsw.dao.LoginDAO;
import br.usjt.arqsw.entity.Login;

/**
 * 
 * @author Gabriel Ferreira Primo 81618660 SIN3AN-MCA
 */


@Service
public class LoginService {
	private LoginDAO dao;
	
	@Autowired
	public LoginService(LoginDAO dao){
		this.dao = dao;
	}
	
	public boolean validarLogin(Login login) throws IOException{
		return dao.validarLogin(login);
	}
}
