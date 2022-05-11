package com.login_registro.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.login_registro.app.models.entity.Usuario;
import com.login_registro.app.models.services.IUsuarioService;

@Controller
public class LoginController {

	@Autowired
	private IUsuarioService userService;
	
	
	
	@GetMapping("/auth/registro")
	public String registroForm(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "registro";
	}
	
	@PostMapping("/auth/registro")
	public String registro(@Validated @ModelAttribute Usuario usuario, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "redirect:/auth/registro";
		}else {
			model.addAttribute("usuario", userService.registrar(usuario));
		}
		return "redirect:/auth/login";
		
	}
	
}
