package com.app.usuarios.service;

import java.util.Optional;

import com.app.usuarios.models.Alumno;

public interface AlumnoService {

	public Iterable<Alumno> findAll();
	
	public Optional<Alumno> findById(Long id);
	
	public Alumno save(Alumno alumno);
	
	public void deleteById( Long id);
	
}
