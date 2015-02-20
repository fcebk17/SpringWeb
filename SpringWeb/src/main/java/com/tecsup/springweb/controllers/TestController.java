package com.tecsup.springweb.controllers;

import java.util.HashMap;

import org.hibernate.mapping.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tecsup.springweb.model.Programa;

@Controller
@RequestMapping(value = { "/", "pruebas", "test" })
public class TestController {

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Tecsup 1");
		model.addAttribute("contenido",
				"Bienvenidos al curso Srping Framework 1");

		return "test/index";
	}

	@RequestMapping("informacion")
	public String alternativo() {
		return "test/informacion";
	}

	@RequestMapping(value = { "info", "prueba" })
	public String pruebas() {
		return "test/pruebas";
	}

	@ModelAttribute
	public void informacion(Model model) {
		model.addAttribute("titulo2", "informacion 2");
		model.addAttribute("contenido2", "informacion 2");

	}

	@RequestMapping("parametros")
	public String parametros(String nombres, String apellidos, Model model) {
		model.addAttribute("nombreCompleto", nombres + " " + apellidos);
		return "test/parametros";
	}

	@RequestMapping("parametros2")
	public String parametros2(@RequestParam("nombres") String nombres,
			@RequestParam("apellidos") String apellidos, Model model) {

		model.addAttribute("nombreCompleto", nombres + " " + apellidos);
		return "test/parametros2";
	}
	/*SpringWeb/parametros2?nombres="exito"&apellidos="exitoi2"*/
	
	@RequestMapping("binding")
	public String parametros(Programa programa, Model model){
		model.addAttribute("programa",programa);
		return "test/binding";
	}
	
	@ResponseBody
	@RequestMapping("ajax")
	public String ajax(Programa programa){
	Programa prg = new Programa();
		prg.setNombre("el men!!!!!");
		return programa.getNombre();
		
	}

}
