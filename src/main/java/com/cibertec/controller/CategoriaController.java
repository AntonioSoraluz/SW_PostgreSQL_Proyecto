package com.cibertec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.Categoria;
import com.cibertec.service.CategoriaService;

@RestController
@RequestMapping("/rest/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService service;

	@GetMapping()
	public ResponseEntity<?> lista() {
		List<Categoria> lstSalida = service.listaCategoria();
		return ResponseEntity.ok(lstSalida);
	}

	@PostMapping
	public ResponseEntity<?> inserta(@RequestBody Categoria obj) {
		Categoria objSalida = service.insertaCategoria(obj);
		return ResponseEntity.ok(objSalida);
	}

	@GetMapping("/porId/{id}")
	public ResponseEntity<?> listaPorIdEnPath(@PathVariable Integer id) {
		Optional<Categoria> optSalida = service.buscaCategoria(id);
		return ResponseEntity.ok(optSalida.get());
	}

	@GetMapping("/porId")
	public ResponseEntity<?> listaPorIdEnParamaterer(
			@RequestParam(name = "id", defaultValue = "0", required = true) Integer id) {
		Optional<Categoria> optSalida = service.buscaCategoria(id);
		return ResponseEntity.ok(optSalida.get());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminaCategoria(@PathVariable Integer id) {
		service.eliminaCategoria(id);
		Optional<Categoria> optCategoria = service.buscaCategoria(id);
		if (optCategoria.isEmpty()) {
			return ResponseEntity.ok("Eliminación exitosa");
		}
		return ResponseEntity.ok("No existe el id " + id);
	}

	@PutMapping
	public ResponseEntity<?> actualiza(@RequestBody Categoria obj) {
		Optional<Categoria> optCategoria = service.buscaCategoria(obj.getIdCategoria());
		if (optCategoria.isPresent()) {
			Categoria objSalida = service.insertaCategoria(obj);
			return ResponseEntity.ok(objSalida);
		} else {
			return ResponseEntity.ok("El Categoria no existe");
		}
	}
}
