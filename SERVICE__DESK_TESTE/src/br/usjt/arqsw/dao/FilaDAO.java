package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;


/***
 * 
 * @author Gabriel Ferreira Primo 81618660 SIN3AN-MCA | USJT MOOCA
 */

@Repository
public class FilaDAO {
	@PersistenceContext
	EntityManager manager;

	public List<Chamado> listarChamados(Fila fila) throws IOException{
		fila = manager.find(Fila.class, fila.getId());
		
		String jpql = "select c from Chamado c where c.fila = :fila";
		
		Query query = manager.createQuery(jpql);
		query.setParameter("fila", fila);
		query.setParameter("status", Chamado.ABERTO);
		
		@SuppressWarnings("unchecked")
		List<Chamado> result = query.getResultList();
		
		return result;
		
	}
	
	
//	private Connection conn;
	
//	@Autowired
//	public FilaDAO(DataSource dataSource) throws IOException{
//		try {
//			this.conn = dataSource.getConnection();
//		}catch (SQLException e) {
//			throw new IOException(e);
//		}
//	}
//
//	public ArrayList<Fila> listarFilas() throws IOException {
//		String query = "select id_fila, nm_fila from fila";
//		ArrayList<Fila> lista = new ArrayList<>();
//		try (
//				PreparedStatement pst = conn.prepareStatement(query);
//				ResultSet rs = pst.executeQuery();) {
//
//			while (rs.next()) {
//				Fila fila = new Fila();
//				fila.setId(rs.getInt("id_fila"));
//				fila.setNome(rs.getString("nm_fila"));
//				lista.add(fila);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new IOException(e);
//		}
//		return lista;
//	}
//
//	public Fila carregar(int id) throws IOException {
//		Fila fila = new Fila();
//		fila.setId(id);
//		String sql = "select nm_fila from fila where id_fila=?";
//		try (
//				PreparedStatement stmt = conn.prepareStatement(sql);) {
//			stmt.setInt(1, fila.getId());
//			try (ResultSet rs = stmt.executeQuery();) {
//				if (rs.next()) {
//					fila.setNome(rs.getString("nm_fila"));
//				}else{
//					fila.setNome(null);
//				}
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//				throw new IOException(e1);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new IOException(e);
//		}
//
//		return fila;
//	}
	
}
