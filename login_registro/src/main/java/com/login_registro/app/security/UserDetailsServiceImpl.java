package com.login_registro.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.login_registro.app.models.dao.IUsuarioDAO;
import com.login_registro.app.models.entity.Usuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private IUsuarioDAO userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = userDao.findByUsername(username);
		UserBuilder builder = null;
		
		if(usuario !=null) {
			builder = User.withUsername(username);
			builder.disabled(false);
			builder.password(usuario.getPassword());
			builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));
		}else {
			throw new UsernameNotFoundException("Revise los datos ingresados");
		}
		
		return builder.build();
	}

}
