package com.ipartek.formacion.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.domain.Cursos;
import com.ipartek.formacion.service.ServiceCursos;



@Controller()
@RequestMapping(value = "/curso")
public class CursoController {

	private static final String VIEW_ADMIN_INDEX = "admin/index";
	private static final String VIEW_ADMIN_FORM = "admin/form";

	@Autowired()
	private ServiceCursos serviceCursos;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listar(Model model) {

	
		model.addAttribute("cursos", this.serviceCursos.listado(null));

		return VIEW_ADMIN_INDEX;
	}

	@RequestMapping(value = "/edit{id}", method = RequestMethod.GET)
	public String formularioEditar(@PathVariable int id, Model model) {

	

		model.addAttribute("curso", this.serviceCursos.buscarPorId(id));

		return VIEW_ADMIN_FORM;
	}

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public String crear(@Valid Cursos cursos, BindingResult bindingResult, Model model) {


		String msg = null;

		// validamos los datos del formulario
		if (!bindingResult.hasErrors()) {

			if (cursos.getId() == -1) {

				serviceCursos.crearCursos(cursos);
				msg = "GENIAL!! El nuevo curso se ha creado con éxito ;)";

			} else {

				serviceCursos.modificarCursos(cursos);
				msg = "GENIAL!! Has modificado el curso con éxito :D";

			}

		} else {

	

		}

		model.addAttribute("cursos", serviceCursos.listado(null));
		model.addAttribute("msg", msg);

		return VIEW_ADMIN_INDEX;
	}

	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String eliminar(@PathVariable int id, Model model) {

		
		String view = "redirect: ../";
		String msg = "ERROR!! El curso no ha sido eliminado";

		if (serviceCursos.eliminarCursos(id)) {
			msg = "Curso Eliminado con exito";
			view = VIEW_ADMIN_INDEX;

		} else {

			view = "redirect: ../edit/" + id;
		}

		model.addAttribute("cursos", serviceCursos.listado(null));
		model.addAttribute("msg", msg);
		return view;
	}
}
