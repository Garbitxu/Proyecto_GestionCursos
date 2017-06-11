package com.ipartek.formacion.domain;

public class Cursos {

	private long id;

	private String nombre;

	private String codigo;

	public Cursos(long id, String nombre, String codigo) {
		super();
		this.id = -1;
		this.nombre = "";
		this.codigo = null;
	}

	public Cursos() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Cursos [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + "]";
	}

}
