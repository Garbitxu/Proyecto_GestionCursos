package com.ipartek.formacion.api;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ipartek.formacion.domain.Cursos;
import com.ipartek.formacion.domain.Mensajes;
import com.ipartek.formacion.service.ServiceCursos;

@Controller
@RequestMapping(value = "api/curso")
public class ApiCursoController {

	private static final Logger LOG = LoggerFactory.getLogger(ApiCursoController.class);
	private Mensajes msg = new Mensajes();
	@Autowired()
	private ServiceCursos serviceCurso;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<ArrayList<Cursos>> listado(
			@RequestParam(value = "filtro", required = false) String filtro) {

		LOG.info("recuperando los cursos que contengan: " + filtro);

		ResponseEntity<ArrayList<Cursos>> response = new ResponseEntity<ArrayList<Cursos>>(HttpStatus.NO_CONTENT);

		try {

			ArrayList<Cursos> cursos = (ArrayList<Cursos>) this.serviceCurso.listado(filtro);

			if (!cursos.isEmpty()) {

				response = new ResponseEntity<ArrayList<Cursos>>((ArrayList<Cursos>) this.serviceCurso.listado(filtro),
						HttpStatus.OK);

			}

		} catch (Exception e) {

			LOG.error("Excepcion sin controlar", e);
			response = new ResponseEntity<ArrayList<Cursos>>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return response;
	}

}
