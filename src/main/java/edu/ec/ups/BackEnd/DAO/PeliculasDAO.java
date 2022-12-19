package edu.ec.ups.BackEnd.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.ec.ups.BackEnd.model.Pelicula;


@Stateless
public class PeliculasDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Pelicula pelicula) {
		em.persist(pelicula);
	}

	public void update(Pelicula pelicula) {
		em.merge(pelicula);
	}
	
	public Pelicula read(int id) {
		return em.find(Pelicula.class, id);
	}
	
	public void delete(int id) {
		em.remove(id);
	}
	
	public List<Pelicula> getPeliculas(){
		String jpql = "SELECT * FROM peliculas";
		Query query = em.createQuery(jpql, Pelicula.class);
		List<Pelicula> peliculas = query.getResultList();
		return peliculas;
	}
}
