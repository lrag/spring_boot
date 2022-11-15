package com.curso.modelo.entidad;

public class Coche {
	private String marca;
	private String modelo;

	public Coche() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Coche(String marca, String modelo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

}
