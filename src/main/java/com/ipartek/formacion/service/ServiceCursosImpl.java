package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.domain.Cursos;

@Service("serviceCursos")
public class ServiceCursosImpl implements ServiceCursos {

	@Override
	public List<Cursos> listado(String filter) {
		return DAOCursos.cogerTodos(filter);

	}

	@Override
	public List<Cursos> listadoUltimosCursos() {
		// TODO Auto-generated method stub
		return DAOCursos.cogerUltimosDiez();
	}

	@Override
	public Cursos buscarPorId(long id) {
		// TODO Auto-generated method stub
		return DAOCursos.getById(id);
	}

	@Override
	public boolean crearCursos(Cursos cursos) {
		// TODO Auto-generated method stub
		return DAOCursos.insertar(cursos);
	}

	@Override
	public boolean modificarCursos(Cursos cursos) {
		// TODO Auto-generated method stub
		return DAOCursos.actualizar(cursos);
	}

	@Override
	public boolean eliminarCursos(long id) {
		// TODO Auto-generated method stub
		return DAOCursos.eliminar(id);
	}

}
