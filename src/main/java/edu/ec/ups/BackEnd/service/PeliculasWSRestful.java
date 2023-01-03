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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@Path("peliculas")
public class PeliculasWSRestful {
	@Inject
	private PeliculasDAO dao;
	
	@POST
	@Path("insertar")
	@Operation(summary = "Registrar Pelicula", description = "Registra una pelicula.", responses = {
			@ApiResponse(description = "Pelicula registrada Correctamente", content = @Content(mediaType = "application/json"), responseCode = "200")
	})
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
	@Operation(summary = "Listar Peliculas", description = "Lista las peliculas previamente ingresadas",responses = {
			@ApiResponse(description = "Listado Correctamente", content = @Content(mediaType = "application/json"), responseCode = "200")
	})
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pelicula> listar(){
		return dao.getPeliculas();
	}
}
