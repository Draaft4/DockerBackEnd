package edu.ec.ups.BackEnd.model;

import javax.persistence.*;

@Entity
public class Pelicula {
	
	@Id
	@GeneratedValue
	private int id;
	private String nombre;
	private String genero;
	private int anioEstreno;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getAnioEstreno() {
		return anioEstreno;
	}
	
	public void setAnioEstreno(int anioEstreno) {
		this.anioEstreno = anioEstreno;
	}
	
}
