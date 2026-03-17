package com.curso.modelo.entidad;

import java.util.List;

public class Pelicula {

	private String titulo;
	private String director;
	private int year;
	private List<String> actores;

	public Pelicula() {
	}

	public Pelicula(String titulo, String director, int year, List<String> actores) {
		this.titulo = titulo;
		this.director = director;
		this.year = year;
		this.actores = actores;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<String> getActores() {
		return actores;
	}

	public void setActores(List<String> actores) {
		this.actores = actores;
	}

	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", director=" + director + ", year=" + year + ", actores=" + actores
				+ "]";
	}
	
}