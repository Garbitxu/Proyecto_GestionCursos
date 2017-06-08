package com.ipartek.formacion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.service.ServiceCursos;


public class AdminController {
	
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

}
