package com.ipartek.formacion.service;

import java.io.FileReader;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.domain.Cursos;
import com.ipartek.formacion.repository.DAOCursos;

import au.com.bytecode.opencsv.CSVReader;

@Service("serviceCursos")
public class ServiceCursosImpl implements ServiceCursos {

	private final Log LOG = LogFactory.getLog(getClass());
	@Autowired()
	private DAOCursos daoCursos;

	@Override()
	public List<Cursos> listado(String filtro) {
		return daoCursos.cogerTodos(filtro);
	}

	@Override()
	public List<Cursos> listadoUltimosCursos() {
		return daoCursos.cogerUltimosDiez();
	}

	@Override()
	public Cursos buscarPorId(long id) {
		return daoCursos.getById(id);
	}

	@Override()
	public boolean crearCursos(Cursos cursos) {
		return daoCursos.insertar(cursos);
	}

	@Override()
	public boolean modificarCursos(Cursos cursos) {
		return daoCursos.actualizar(cursos);
	}

	@Override()
	public boolean eliminarCursos(long id) {
		return daoCursos.eliminar(id);
	}
	
	@Override()
	public void migracion() throws Exception {
		int cont = 0;
		CSVReader lector = new CSVReader(new FileReader("c:\\cursos.csv"),';');
	     List<String[]> misEntradas = lector.readAll();
	     for (String[] linea: misEntradas) {
	    	 if(cont!=0){
		    	 Cursos cursos = new Cursos();
		    	 cursos.setNombre(linea[1]);
		    	 cursos.setCodigo(linea[8]);
		    	 if(!"".equals(cursos.getCodigo()) && !"".equals(cursos.getNombre())){
		    		 this.daoCursos.anadir(cursos);
		    	 }
	    	 }
	    	 cont++;
		}
	     lector.close();
	}

}
