package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository iEstudianteRepository;

	@Override
	public void insertarEstudiante(Estudiante e) {
		// TODO Auto-generated method stub
		this.iEstudianteRepository.insertarEstudiante(e);
	}

	@Override
	public List<Estudiante> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iEstudianteRepository.buscarTodos();
	}

	private EstudianteTO convertirATo(Estudiante estudiante) {
		EstudianteTO est = new EstudianteTO();
		est.setNombre(estudiante.getNombre());
		est.setApellido(estudiante.getApellido());
		est.setCedula(estudiante.getCedula());
		return est;
	}

	@Override
	public List<EstudianteTO> consultarTodosTO() {
		// TODO Auto-generated method stub
		List<Estudiante> lista = this.iEstudianteRepository.buscarTodos();
		List<EstudianteTO> listaTO = lista.stream().map(estudiante -> this.convertirATo(estudiante))
				.collect(Collectors.toList());
		return listaTO;
	}

}
