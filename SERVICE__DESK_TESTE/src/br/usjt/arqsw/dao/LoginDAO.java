package br.usjt.arqsw.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Login;



/**
 * 
 * @author Gabriel Ferreira Primo 81618660 SIN3AN-MCA
 */


@Repository
public class LoginDAO {
	
	@PersistenceContext
	EntityManager manager;
	
	public boolean validarLogin(Login login) throws IOException{
		
		String jpql = "select u from Login where u.nome = :user and u.senha = :pass";
		Query query = manager.createQuery(jpql);
		
		query.setParameter("user", login.getNome());
		query.setParameter("pass", login.getSenha());
		
		@SuppressWarnings("unchecked")
		List<Login> result = query.getResultList();
		
		
		return (result != null && result.size() == 1);
		
	}
	
	
}






