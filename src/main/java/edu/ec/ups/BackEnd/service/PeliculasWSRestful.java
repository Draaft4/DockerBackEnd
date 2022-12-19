package edu.ec.ups.BackEnd.service;


import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.ec.ups.BackEnd.DAO.PeliculasDAO;
import edu.ec.ups.BackEnd.model.Pelicula;

@Path("peliculas")
public class PeliculasWSRestful {
	@Inject
	private PeliculasDAO dao;
	
	@POST
	@Path("insertar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Mensaje registrarPelicula(Pelicula pelicula) {
		Mensaje  msj = new Mensaje();
		dao.insert(pelicula);
		msj.setCodigo("01");
		msj.setMensaje("OK");
		return msj;
	}
	
	
	@GET
	@Path("listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pelicula> listar(){
		return dao.getPeliculas();
	}
}
