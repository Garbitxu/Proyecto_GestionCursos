package com.ipartek.formacion.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.domain.Cursos;
import com.ipartek.formacion.repository.DAOCursos;

@Service("serviceCursos")
public class ServiceCursosImpl implements ServiceCursos {
	
	private final Log LOG = LogFactory.getLog(getClass());
	@Autowired()
	private DAOCursos daoCursos;
	
	
	@Override
	public List<Cursos> listado(String filter) {
		return daoCursos.cogerTodos(filter);

	}

	@Override
	public List<Cursos> listadoUltimosCursos() {
		// TODO Auto-generated method stub
		return daoCursos.cogerUltimosDiez();
	}

	@Override
	public Cursos buscarPorId(long id) {
		// TODO Auto-generated method stub
		return daoCursos.getById(id);
	}

	@Override
	public boolean crearCursos(Cursos cursos) {
		// TODO Auto-generated method stub
		return daoCursos.insertar(cursos);
	}

	@Override
	public boolean modificarCursos(Cursos cursos) {
		// TODO Auto-generated method stub
		return daoCursos.actualizar(cursos);
	}

	@Override
	public boolean eliminarCursos(long id) {
		// TODO Auto-generated method stub
		return daoCursos.eliminar(id);
	}

}
