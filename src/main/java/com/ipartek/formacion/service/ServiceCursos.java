package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.domain.Cursos;

public interface ServiceCursos {

	List<Cursos> listado(String filtro); // filtrar+listar todo

	List<Cursos> listadoUltimosCursos(); // listar ultimo

	Cursos buscarPorId(long id); // buscar curso por id

	boolean crearCursos(Cursos cursos); // crear curso

	boolean modificarCursos(Cursos cursos); // modifica curso

	boolean eliminarCursos(long id); // elimina curso
}
