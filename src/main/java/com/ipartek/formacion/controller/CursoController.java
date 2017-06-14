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
import com.ipartek.formacion.domain.Mensajes;
import com.ipartek.formacion.service.ServiceCursos;

/**
 * Controlador de cursos
 * 
 * RequestMapping = URI
 * 
 * @author Garbi
 *
 */
@Controller()
@RequestMapping(value = "admin/curso")

public class CursoController {
	
	private Mensajes msg = new Mensajes();

	/**
	 * Variables finales
	 */
	private static final String VIEW_ADMIN_INDEX = "admin/index";
	private static final String VIEW_ADMIN_FORM = "admin/gestionCursos";

	@Autowired()
	private ServiceCursos serviceCursos;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listado(Model model) {

		model.addAttribute("cursos", this.serviceCursos.listado(null));

		return VIEW_ADMIN_INDEX;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String irFormularioNuevo(Model model) {

		model.addAttribute("cursos", new Cursos());

		return VIEW_ADMIN_FORM;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String formularioEditar(@PathVariable int id, Model model) {

		model.addAttribute("cursos", this.serviceCursos.buscarPorId(id));
		this.msg.setDescripcion("Curso editado con éxito");
		this.msg.setClase(Mensajes.CLASE_SUCCESS);

		return VIEW_ADMIN_FORM;
	}

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public String crear(@Valid Cursos cursos, BindingResult bindingResult, Model model) {

		// validamos los datos del formulario
		if (!bindingResult.hasErrors()) {
			if (cursos.getId() == -1) {
				serviceCursos.crearCursos(cursos);

				this.msg.setDescripcion("GENIAL!! El nuevo curso se ha creado con éxito ;)");
				this.msg.setClase(Mensajes.CLASE_SUCCESS);
			} else {
				serviceCursos.modificarCursos(cursos);

				this.msg.setDescripcion("GENIAL!! Has modificado el curso con éxito :D");
				this.msg.setClase(Mensajes.CLASE_SUCCESS);
			}
		}
		model.addAttribute("cursos", serviceCursos.listado(null));
		model.addAttribute("msg", msg);
		return VIEW_ADMIN_INDEX;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String eliminar(@PathVariable int id, Model model) {

		String view = "redirect: ../";

		
		if (serviceCursos.eliminarCursos(id)) {

			this.msg.setDescripcion("GENIAL!! Has eliminado el curso con éxito :D");
			this.msg.setClase(Mensajes.CLASE_SUCCESS);
			view = VIEW_ADMIN_INDEX;

		} else {

			view = "redirect: ../edit/" + id;
			this.msg.setDescripcion("ERROR!!! No se ha podido eliminar el curso");
			this.msg.setClase(Mensajes.CLASE_DANGER);

		}

		model.addAttribute("cursos", serviceCursos.listado(null));

		return view;
	}
}
