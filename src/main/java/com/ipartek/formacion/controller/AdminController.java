package com.ipartek.formacion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.domain.Mensajes;
import com.ipartek.formacion.service.ServiceCursos;

@Controller()
public class AdminController {
	
	private Mensajes msg = new Mensajes();

	private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);
	private static final String VIEW_ADMIN_INDEX = "admin/index";

	@Autowired()
	private ServiceCursos serviceCursos;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String listar(Model model) {

		LOG.info("recuperando todos los cursos");

		model.addAttribute("cursos", this.serviceCursos.listado(null));

		return VIEW_ADMIN_INDEX;
	}
	
	@RequestMapping(value = "/admin/migracion", method = RequestMethod.GET)
	public String migracion(Model model) {
		try {
			this.serviceCursos.migracion();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("cursos", this.serviceCursos.listado(null));
		
		this.msg.setDescripcion("Migración realizada con éxito");
		this.msg.setClase(Mensajes.CLASE_SUCCESS);
		return VIEW_ADMIN_INDEX;
	}
}


