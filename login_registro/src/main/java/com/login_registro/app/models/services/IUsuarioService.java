package com.login_registro.app.models.services;

import com.login_registro.app.models.entity.Usuario;

public interface IUsuarioService {
	public Usuario findByUsername(String username);
	public Usuario registrar(Usuario u);
}
