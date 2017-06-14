package com.ipartek.formacion.repository;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.domain.Cursos;

public interface DAOCursos {

	void setDatasource(DataSource ds);

	List<Cursos> cogerTodos(String filtro);

	List<Cursos> cogerUltimosDiez();

	Cursos getById(long id);

	boolean insertar(Cursos cursos);

	boolean actualizar(Cursos cursos);

	boolean eliminar(long id);

	boolean anadir(final Cursos cursos);
}
