package com.app.usuarios.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.usuarios.models.Alumno;

public interface AlumnosRepository extends CrudRepository<Alumno, Long> {

}
