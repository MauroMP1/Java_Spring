package com.app.usuarios.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.usuarios.models.Alumno;
import com.app.usuarios.repository.AlumnosRepository;

@Service
public class AlumnoServiceImp implements AlumnoService {

	@Autowired
	private AlumnosRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Alumno> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Alumno> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Alumno save(Alumno alumno) {
		// TODO Auto-generated method stub
		return repository.save(alumno);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
