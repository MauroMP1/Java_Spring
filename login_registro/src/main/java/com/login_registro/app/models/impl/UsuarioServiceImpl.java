package com.login_registro.app.models.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.login_registro.app.models.dao.IUsuarioDAO;
import com.login_registro.app.models.entity.Usuario;
import com.login_registro.app.models.services.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private IUsuarioDAO userDao;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public Usuario findByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUsername(username);
	}

	@Override
	public Usuario registrar(Usuario u) {
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		return userDao.save(u);
	}
	
	

}
