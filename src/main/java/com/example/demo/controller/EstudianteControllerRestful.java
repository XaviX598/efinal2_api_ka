package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.to.EstudianteTO;

@RestController
@RequestMapping("/estudiantes")
@CrossOrigin
public class EstudianteControllerRestful {

	@Autowired
	private IEstudianteService iEstudianteService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public void guardar(@RequestBody Estudiante estudiante) {
		this.iEstudianteService.insertarEstudiante(estudiante);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstudianteTO>> consultarTodosHATEOAS() {
		List<EstudianteTO> lista = this.iEstudianteService.consultarTodosTO();
		return new ResponseEntity<>(lista, null, 200);

	}

}
