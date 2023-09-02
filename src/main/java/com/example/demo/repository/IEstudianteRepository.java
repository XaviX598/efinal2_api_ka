package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteRepository {
	
	public void insertarEstudiante(Estudiante e);
	
	
	public List<Estudiante> buscarTodos();

}
